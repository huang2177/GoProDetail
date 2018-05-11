package com.huatai.goprodetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.app.Constant;
import com.module.base.utils.StatusUtil;
import com.module.home.FragmentHome;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mall.FragmentMall;
import com.module.mall.FragmentPing;
import com.module.mine.FragmentMine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Huangshuang  2018/5/3 0003
 */


@Route(path = Constant.PATH_MAINACTIVITY)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragments = new ArrayList<>();

        navigationView = findViewById(R.id.main_navigation);

        showFragment(FragmentHome.newInstance(""));
        setNavigationViewMode();


    }

    /**
     * 显示Fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!fragments.contains(fragment)) {
            fragments.add(fragment);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!fragment.isAdded()) {
            transaction.add(R.id.main_container, fragment);
        }

        hideFragment(transaction);
        transaction.show(fragment);
        transaction.commit();
    }

    /**
     * 设置当item大于3的时候，ShiftingMode不改变；
     */
    @SuppressLint("RestrictedApi")
    private void setNavigationViewMode() {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                //设置false 让底部导航的动画效果始终保持 <= 3 的效果。
                itemView.setShiftingMode(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }
        } catch (Exception e) {

        }

    }

    /**
     * 隐藏所有的fragment
     */
    private void hideFragment(FragmentTransaction transaction) {
        for (int i = 0; i < fragments.size(); i++) {
            if (fragments.get(i) != null) {
                transaction.hide(fragments.get(i));
            }
        }
    }

    @Override
    public void setListener() {
        super.setListener();
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean useDart = true;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                showFragment(FragmentHome.newInstance(""));
                break;
            case R.id.navigation_mall:
                showFragment(FragmentMall.newInstance(1));
                break;
            case R.id.navigation_jewelry:
                showFragment(FragmentMall.newInstance(2));
                break;
            case R.id.navigation_hall:
                showFragment(FragmentPing.newInstance(1));
                break;
            case R.id.navigation_mine:
                useDart = false;
                showFragment(FragmentMine.newInstance(""));
                break;
            default:
                break;

        }
        StatusUtil.setStatusTextColor(useDart, this);
        return true;
    }

    /**
     * 获取Fragment
     *
     * @param position
     * @return
     */
    public Fragment getFragment(int position) {
        if (fragments == null || fragments.size() == 0) {
            return null;
        }
        return fragments.get(position);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        ViewPagerAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
