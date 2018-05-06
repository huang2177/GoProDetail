package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

/**
 * Created by shibing on 18/5/6.
 * <p>
 * <p>
 * 拼团返现
 */

public class CollageReturnsActivity extends BaseActivity {

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

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
