package com.module.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseFragment;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;
import com.module.base.utils.Logger;
import com.module.mall.adpter.JewelryAdpter;
import com.module.mall.adpter.MallListAdpter;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.prodetails.ProDetailActivity;

import java.util.Arrays;
import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentLease extends BaseFragment
        implements TabLayout.OnTabSelectedListener
        , OnItemClickListener
        , MallView {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;
    private JewelryAdpter jewelryAdpter;

    private static FragmentLease fragment;
    private MallPresenter presenter;
    private List<ProductTypeBean.DataBean> typeList;
    private String catagory;
    private List<ProductBean.DataBean> list;

    public static FragmentLease newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        if (fragment == null) {
            fragment = new FragmentLease();
        }
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getProductType("1");
        presenter.getProductList("1", catagory);

    }

    @Override
    protected BasePresenter createPresenter() {
        presenter = new MallPresenter();
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_lease;
    }

    @Override
    public void initView() {
        tabLayout = viewRoot.findViewById(R.id.ping_tab);
        editSearch = viewRoot.findViewById(R.id.home_ed);
        recyclerView = viewRoot.findViewById(R.id.ping_recycle);
        tvLocation = viewRoot.findViewById(R.id.home_location_tv);
        tvNewUserPoint = viewRoot.findViewById(R.id.home_new_user_tv);
        initProduct();
    }


    private void initProduct() {
        GridLayoutManager manager = new GridLayoutManager(mActivity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);

    }


    @Override
    public void setListener() {
        tvLocation.setOnClickListener(this);
        tvNewUserPoint.setOnClickListener(this);
        tabLayout.addOnTabSelectedListener(this);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        //新手帮助
        if (i == R.id.home_new_user_tv) {
            ARouter.getInstance().build(Constant.NEWHELP).navigation();
        } else if (i == R.id.home_location_tv) {
            ARouter.getInstance().build(Constant.LOCATION).navigation();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getPosition() == 0) {
            presenter.getProductList("1", catagory);
        } else {
            presenter.getProductList("1", typeList.get(tab.getPosition() - 1).getId() + "");
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    //产品类别列表
    @Override
    public void showProductType(ProductTypeBean typeBean) {
        typeList = typeBean.getData();
        tabLayout.addTab(tabLayout.newTab().setText("全部"), 0, true);
        for (int i = 0; i < typeBean.getData().size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(typeBean.getData().get(i).getCatagory()));
        }
    }


    //产品列表
    @Override
    public void showProduct(List<ProductBean.DataBean> productBean) {
        list = productBean;
        jewelryAdpter = new JewelryAdpter(mActivity, productBean);
        jewelryAdpter.addOnItemClickListener(this);
        recyclerView.setAdapter(jewelryAdpter);
    }


    //拼团列表
    @Override
    public void showTuanList(List<ProductTuanBean.DataBean> productTuan) {

    }

    @Override
    public void onItemClick(int position, int type) {
        Intent intent = new Intent(mActivity, ProDetailActivity.class);
        intent.putExtra(Constant.PORDUCTID, list.get(position).getId() + "");
        startActivity(intent);

    }
}
