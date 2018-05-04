package com.module.user;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

/**
 * Created by shibing on 18/5/4.
 */


/**
 * 用户协议
 */


public class AgreementActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("用户协议").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_agreement;
    }

    @Override
    public void initView() {


    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
