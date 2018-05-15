package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/16.
 */

public class OrderDetalisActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 18/5/16  需要添加一张图片
        title("订单详情").rightText("已公开");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_orderdetalis;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
