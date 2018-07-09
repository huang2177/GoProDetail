package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.mine.R;
import com.module.mine.adapter.OrderListAdpter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/5/6.
 */

public class OrderActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, OnItemClickListener {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    private String title;

    private OrderListAdpter adpter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getIntent().getStringExtra(Constant.TITLE);
        title(title);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void initView() {
        tabLayout = findViewById(R.id.ping_tab);
        recyclerView = findViewById(R.id.ping_recycle);
        initTab();
        initProduct();
    }


    private void initTab() {
        List<String> tabs = Arrays.asList("全部", "拼团", "购买", "0元首饰盒");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
    }


    private void initProduct() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new OrderListAdpter(this);
        recyclerView.setAdapter(adpter);

        adpter.addOnItemClickListener(this);

    }

    @Override
    public void setListener() {
        super.setListener();
        tabLayout.addOnTabSelectedListener(this);
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


    @Override
    public void onItemClick(int position, int type) {
        Intent intent = new Intent(this, OrderDetalisActivity.class);
        intent.putExtra("from", "");
        startActivity(intent);
    }
}
