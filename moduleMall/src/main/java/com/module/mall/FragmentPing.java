package com.module.mall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseFragment;
import com.module.base.base.Constant;
import com.module.mall.adpter.MallListAdpter;
import com.module.mall.adpter.PingListAdpter;

import java.util.Arrays;
import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentPing extends BaseFragment implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;

    private int flag;
    private PingListAdpter adpter;

    public static FragmentPing newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        FragmentPing fragment = new FragmentPing();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_ping;
    }

    @Override
    public void initView() {
        tabLayout = f(R.id.ping_tab);
        editSearch = f(R.id.home_ed);
        recyclerView = f(R.id.ping_recycle);
        tvLocation = f(R.id.home_location_tv);
        tvNewUserPoint = f(R.id.home_new_user_tv);

        flag = getArguments().getInt(Constant.FLAG);

        initTab();
        initProduct();
    }

    private void initTab() {
        List<String> tabs = flag == 1
                ? Arrays.asList("全部", "手机", "黄金首饰")
                : Arrays.asList("有效订单", "完成订单", "失败订单");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
    }

    private void initProduct() {
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new PingListAdpter(activity, getData());
        recyclerView.setAdapter(adpter);
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
        ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
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
