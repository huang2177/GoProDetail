package com.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

/**
 * Created by shibing on 18/5/3.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title("登录").rightText("完成");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this,RegisterActivity.class));
    }
}
