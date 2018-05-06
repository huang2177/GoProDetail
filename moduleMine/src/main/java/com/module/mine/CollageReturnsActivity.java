package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.base.Constant;
import com.module.mine.adapter.ReturnsListAdpter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/5/6.
 * <p>
 * <p>
 * 拼团返现
 */

public class CollageReturnsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    Fragment fragment;

    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    private ReturnsListAdpter adpter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("拼团返现");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_collreturns;
    }

    @Override
    public void initView() {
      /*  FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment1 = (Fragment) ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
        transaction.add(R.id.fragment_container, fragment1);
        transaction.commit();*/
        tabLayout = findViewById(R.id.ping_tab);
        recyclerView = findViewById(R.id.ping_recycle);
        initTab();
        initProduct();
    }


    private void initTab() {
        List<String> tabs = Arrays.asList("有效订单", "完成订单", "失败订单");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
    }


    private void initProduct() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new ReturnsListAdpter(this, getData());
        recyclerView.setAdapter(adpter);
    }


    @Override
    public void setListener() {
        super.setListener();
        tabLayout.addOnTabSelectedListener(this);
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
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
