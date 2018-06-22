package com.module.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseFragment;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;
import com.module.mall.adpter.PingListAdpter;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.prodetails.ProDetailActivity;
import com.module.mall.ui.tuanhall.GroupDetalisActivity;

import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */
@Route(path = Constant.PATH_FRAGMENTPING)
public class FragmentGroup extends BaseFragment
        implements TabLayout.OnTabSelectedListener
        , OnItemClickListener, MallView {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;
    private PingListAdpter adpter;
    private static FragmentGroup fragment;
    private MallPresenter presenter;
    private List<ProductTypeBean.DataBean> typeList;
    private List<ProductTuanBean.DataBean> tuanList;
    private String uid, pid, catagory;

    public static FragmentGroup newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        if (fragment == null) {
            fragment = new FragmentGroup();
        }
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getProductType("0");
    }

    @Override
    protected BasePresenter createPresenter() {
        presenter = new MallPresenter();
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_group;
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
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
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
        }
        //营业厅
        else if (i == R.id.home_location_tv) {
            ARouter.getInstance().build(Constant.LOCATION).navigation();
        }

    }


    @Override
    public void showProductType(ProductTypeBean typeBean) {
        typeList = typeBean.getData();
        tabLayout.addTab(tabLayout.newTab().setText("全部"), 0, true);
        for (int i = 0; i < typeBean.getData().size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(typeBean.getData().get(i).getCatagory()));
        }
        presenter.productTuan(uid, pid, false, catagory);
    }


    //商城列表
    @Override
    public void showProduct(List<ProductBean.DataBean> productBean) {

    }


    //拼团列表
    @Override
    public void showTuanList(List<ProductTuanBean.DataBean> productTuan) {
        tuanList = productTuan;
        adpter = new PingListAdpter(mActivity, productTuan);
        adpter.addOnItemClickListener(this);
        recyclerView.setAdapter(adpter);
    }

    /**
     * tab  监听事件
     *
     * @param tab
     */

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getPosition() == 0) {
            presenter.productTuan(uid, pid, false, catagory);
        } else {
            presenter.productTuan(uid, pid, false, typeList.get(tab.getPosition() - 1).getId() + "");
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    /**
     * item  监听事件
     *
     * @param position
     * @param type
     */
    @Override
    public void onItemClick(int position, int type) {
        Intent intent = new Intent(mActivity, GroupDetalisActivity.class);
        intent.putExtra(Constant.PORDUCTID, tuanList.get(position).getId());
        startActivity(intent);
    }
}
