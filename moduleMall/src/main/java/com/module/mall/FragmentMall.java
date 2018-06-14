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
import com.module.mall.ui.ProDetailActivity;

import java.util.Arrays;
import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentMall extends BaseFragment
        implements TabLayout.OnTabSelectedListener
        , OnItemClickListener
        , MallView {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;

    private int flag;
    private MallListAdpter adpter;
    private JewelryAdpter jewelryAdpter;

    private static FragmentMall fragment;
    private MallPresenter presenter;
    private List<ProductTypeBean.DataBean> typeList;

    public static FragmentMall newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        if (fragment == null) {
            fragment = new FragmentMall();
        }
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getProductList("");   //默认加载全部
        if (flag == 1) {
            presenter.getProductType("0");
        } else {
            presenter.getProductType("1");
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        presenter = new MallPresenter();
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_mall;
    }

    @Override
    public void initView() {
        tabLayout = viewRoot.findViewById(R.id.ping_tab);
        editSearch = viewRoot.findViewById(R.id.home_ed);
        recyclerView = viewRoot.findViewById(R.id.ping_recycle);
        tvLocation = viewRoot.findViewById(R.id.home_location_tv);
        tvNewUserPoint = viewRoot.findViewById(R.id.home_new_user_tv);

        flag = getArguments().getInt(Constant.FLAG);

        initTab();
        initProduct();
    }

    private void initTab() {

    }

    private void initProduct() {
        GridLayoutManager manager = new GridLayoutManager(mActivity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        if (flag == 1) {
            adpter = new MallListAdpter(mActivity, getData());
            adpter.addOnItemClickListener(this);
            recyclerView.setAdapter(adpter);
        } else {
            jewelryAdpter = new JewelryAdpter(mActivity);
            jewelryAdpter.addOnItemClickListener(this);
            recyclerView.setAdapter(jewelryAdpter);
        }


    }

    private List<Integer> getData() {
        return Arrays.asList(R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro);
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
            presenter.getProductList("");
        } else {
            presenter.getProductList(typeList.get(tab.getPosition() - 1).getCatagory());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onItemClick(int position) {
        Intent intent;
        //商品
        if (flag == 1) {
            intent = new Intent(mActivity, ProDetailActivity.class);
            intent.putExtra("form", "por");
            startActivity(intent);
        }
        //首饰
        else {
            intent = new Intent(mActivity, ProDetailActivity.class);
            intent.putExtra("form", "jewelry");
            startActivity(intent);
        }
    }


    //产品类别列表
    @Override
    public void showProductType(ProductTypeBean typeBean) {
        typeList = typeBean.getData();
        tabLayout.addTab(tabLayout.newTab().setText("全部"), 0, true);
        Log.e("2-----2222-----222", typeBean.getData().size() + "");
        for (int i = 0; i < typeBean.getData().size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(typeBean.getData().get(i).getCatagory()));
        }
    }

    //产品列表
    @Override
    public void showProduct(ProductBean productBean) {
        Log.e("1------111----11", "showProduct: " + productBean.getData().size());
    }
}
