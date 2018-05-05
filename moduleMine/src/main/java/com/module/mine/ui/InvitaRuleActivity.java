package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/5.
 */

public class InvitaRuleActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("邀请规则").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invirule;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
