package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.base.Constant;

/**
 * Created by shibing on 18/5/6.
 * <p>
 * <p>
 * 拼团返现
 */

public class CollageReturnsActivity extends BaseActivity {
    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("拼团返现").rightImageRes(0);
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

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
