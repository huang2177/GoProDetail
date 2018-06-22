package com.module.mall.ui.prodetails;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.utils.Logger;
import com.module.mall.R;

/**
 * Created by shibing on 18/6/21.
 */

public class RuleDetalisActivity extends BaseActivity {


    private String ruleId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("详细说明");
        ruleId = getIntent().getStringExtra("ruleId");
        Logger.e("<<<<<<<", ruleId);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rule;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
