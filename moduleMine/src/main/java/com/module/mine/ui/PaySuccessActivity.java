package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/15.
 */

public class PaySuccessActivity extends BaseActivity {


    private TextView tvPaySb, tvPayRs;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("支付成功");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_paysuccess;
    }

    @Override
    public void initView() {
        tvPaySb = findViewById(R.id.pay_sb_tv);
        tvPayRs = findViewById(R.id.pay_rs_tv);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
