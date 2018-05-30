package com.module.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;

/**
 * Created by shibing on 18/5/30.
 */

public class JewelryDetalisActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean isUseDart() {
        return false;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_jew;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
