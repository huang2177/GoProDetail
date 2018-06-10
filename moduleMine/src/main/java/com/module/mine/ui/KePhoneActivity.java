package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/8.
 * <p>
 * 客服电话
 */

public class KePhoneActivity extends BaseActivity {


    TextView tvYwPhone, tvDPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("客服电话");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_kephone;
    }

    @Override
    public void initView() {
        tvYwPhone = findViewById(R.id.yw_phone_tv);
        tvDPhone = findViewById(R.id.dl_phone_tv);
        tvYwPhone.setText(Html.fromHtml("业务咨询 <font color='#263A7A'>：400 800 2421</font>"));
        tvDPhone.setText(Html.fromHtml("代理咨询 <font color='#263A7A'>：400 800 2421</font>"));
    }


    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
