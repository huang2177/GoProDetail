package com.module.mall;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseFragment;
import com.module.base.base.Constant;
import com.module.base.widgets.XGridView;
import com.module.mall.adpter.MallListAdpter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentMall extends BaseFragment implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;

    private int flag;
    private MallListAdpter adpter;

    public static FragmentMall newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        FragmentMall fragment = new FragmentMall();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_mall;
    }

    @Override
    public void initView() {
        tabLayout = f(R.id.mall_tab);
        editSearch = f(R.id.home_ed);
        recyclerView = f(R.id.mall_recycle);
        tvLocation = f(R.id.home_location_tv);
        tvNewUserPoint = f(R.id.home_new_user_tv);

        flag = getArguments().getInt(Constant.FLAG);

        initTab();
        initProduct();
    }

    private void initTab() {
        List<String> tabs = flag == 1
                ? Arrays.asList("全部", "手机", "黄金首饰")
                : Arrays.asList("全部", "项链", "戒指", "耳环");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
    }

    private void initProduct() {
        GridLayoutManager manager = new GridLayoutManager(activity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new MallListAdpter(activity, getData());
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
