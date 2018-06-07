package com.module.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseFragment;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
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

public class FragmentMall extends BaseFragment implements TabLayout.OnTabSelectedListener, OnItemClickListener {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;

    private int flag;
    private MallListAdpter adpter;
    private JewelryAdpter jewelryAdpter;

    public static FragmentMall newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        FragmentMall fragment = new FragmentMall();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
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
        List<String> tabs = flag == 1
                ? Arrays.asList("全部", "手机", "黄金首饰")
                : Arrays.asList("全部", "项链", "戒指", "耳环");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
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

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(mActivity, ProDetailActivity.class);
        //商品
        if (flag == 1) {
            intent.putExtra("form", "por");
            startActivity(intent);
        }
        //首饰
        else {
            intent.putExtra("form", "jewelry");
            startActivity(intent);
        }
        // activity.startActivity(new Intent(activity, ProDetailActivity.class));


    }
}
