package com.module.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mall.R;

/**
 * @author Huangshuang  2018/5/11 0011
 */

public class OrderConfirmActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("支付拼团订单");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_confirm;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
