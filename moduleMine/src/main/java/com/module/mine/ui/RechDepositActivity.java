package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/14.
 * <p>
 * 充值押金
 */


public class RechDepositActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("支付押金");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rechdeposit;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
