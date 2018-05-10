package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/6.
 * <p>
 * 我的押金
 */

public class DepositActivity extends BaseActivity {

    private TextView tvMoney, tvShous;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("押金").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView() {
        tvMoney = findViewById(R.id.order_money_tv);
        tvShous = findViewById(R.id.order_shous_tv);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
