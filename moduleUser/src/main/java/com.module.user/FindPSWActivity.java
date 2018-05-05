package com.module.user;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

/**
 * Created by shibing on 18/5/4.
 */

public class FindPSWActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("忘记密码").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_psw;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
