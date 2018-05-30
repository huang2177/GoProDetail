package com.module.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mall.R;

/**
 * Created by shibing on 18/5/28.
 */

public class ReturnRuleActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("返现规则");
    }

    @Override
    public int getLayoutId() {
        return R.layout.avtivity_teturnrule;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
