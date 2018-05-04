package com.huatai.goprodetail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.module.base.utils.StatusUtil;
import com.module.home.FragmentHome;
import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.mine.FragmentMine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Huangshuang  2018/5/3 0003
 */

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
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

        viewPager = findViewById(R.id.main_viewpager);
        navigationView = findViewById(R.id.main_navigation);

        initFragment();
        setNagationViewMode();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        FragmentHome home1 = FragmentHome.newInstance("首页");
        FragmentHome home2 = FragmentHome.newInstance("商城");
        FragmentHome home3 = FragmentHome.newInstance("0元首饰盒");
        FragmentHome home4 = FragmentHome.newInstance("拼团大厅");
        FragmentMine home5 = FragmentMine.newInstance("我的拼跌");

        fragments.add(home1);
        fragments.add(home2);
        fragments.add(home3);
        fragments.add(home4);
        fragments.add(home5);

        viewPager.setAdapter(new ViewPagerAdapter());
        //  test


    }

    /**
     * 设置当item大于3的时候，ShiftingMode不改变；
     */
    @SuppressLint("RestrictedApi")
    private void setNagationViewMode() {
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
        boolean useDart = false;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                useDart = true;
                viewPager.setCurrentItem(0);
                break;
            case R.id.navigation_mall:
                useDart = true;
                viewPager.setCurrentItem(1);
                break;
            case R.id.navigation_jewelry:
                useDart = true;
                viewPager.setCurrentItem(2);
                break;
            case R.id.navigation_hall:
                useDart = true;
                viewPager.setCurrentItem(3);
                break;
            case R.id.navigation_mine:
                useDart = false;
                viewPager.setCurrentItem(4);
                break;
            default:
                break;

        }
        StatusUtil.setStatusTextColor(useDart, this);
        return true;
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
