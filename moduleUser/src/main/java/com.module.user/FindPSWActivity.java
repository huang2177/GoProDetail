package com.module.user;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;

/**
 * Created by shibing on 18/5/4.
 */

public class FindPSWActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("忘记密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_psw;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
