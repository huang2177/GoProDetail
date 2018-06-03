package com.module.mall;

import android.content.Intent;
import android.os.Bundle;
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
import com.module.mall.adpter.PingListAdpter;
import com.module.mall.ui.GroupDetalisActivity;

import java.util.Arrays;
import java.util.List;

/**
 * 商城 0元首饰盒
 *
 * @author Huangshuang  2018/5/3 0003
 */
@Route(path = Constant.PATH_FRAGMENTPING)
public class FragmentGroup extends BaseFragment
        implements TabLayout.OnTabSelectedListener
        , OnItemClickListener {

    private TabLayout tabLayout;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint;

    private int flag;
    private PingListAdpter adpter;

    public static FragmentGroup newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(Constant.FLAG, position);
        FragmentGroup fragment = new FragmentGroup();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getContentView() {
        /*资源文件在base中*/
        return R.layout.fragment_group;
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
        adpter.addOnItemClickListener(this);
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


    /**
     * item  监听事件
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {
        activity.startActivity(new Intent(activity, GroupDetalisActivity.class));
    }
}
