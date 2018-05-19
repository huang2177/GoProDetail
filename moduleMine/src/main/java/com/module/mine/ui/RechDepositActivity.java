package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.mine.R;

import java.util.Objects;

/**
 * Created by shibing on 18/5/14.
 * <p>
 * 充值押金
 */


public class RechDepositActivity extends BaseActivity {


    private ImageView imageReduce, imageAdd;
    private TextView tvMoney, tvPay, tvSuerpay, tvContent, tvTitle;
    private RelativeLayout rayAipay, rayWeathpay, rayUnionpay;


    private String title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title(title);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rechdeposit;
    }

    @Override
    public void initView() {
        title = getIntent().getStringExtra(Constant.TITLE);

        imageReduce = findViewById(R.id.reduce_image);
        imageAdd = findViewById(R.id.add_image);
        tvMoney = findViewById(R.id.money_tv);
        tvPay = findViewById(R.id.pay_tv);
        tvSuerpay = findViewById(R.id.surepay_tv);
        rayAipay = findViewById(R.id.aipay_lay);
        rayWeathpay = findViewById(R.id.weathpay_ray);
        rayUnionpay = findViewById(R.id.unionpay_ray);
        tvContent = findViewById(R.id.content_tv);
        tvTitle = findViewById(R.id.title_tv);


        tvPay.setText((Html.fromHtml("实际支付 <font color= '#a0563c'>"
                + "￥"
                + "<big>"
                + "2000"
                + "</big></font> "
                + ".00")));
        setTitle();
    }


    private void setTitle() {
        if (title.equals("充值")) {
            tvContent.setVisibility(View.GONE);
            tvTitle.setText("充值到余额");
        } else {
            tvContent.setVisibility(View.VISIBLE);
            tvTitle.setText("充值押金");
        }
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void setListener() {
        super.setListener();
        imageReduce.setOnClickListener(this);       //减
        imageAdd.setOnClickListener(this);          //加
        tvSuerpay.setOnClickListener(this);         //确认支付
        rayAipay.setOnClickListener(this);          //支付宝支付
        rayWeathpay.setOnClickListener(this);       //微信支付
        rayUnionpay.setOnClickListener(this);       //银联支付
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //减
        if (i == R.id.reduce_image) {

        }
        //加
        else if (i == R.id.add_image) {

        }
        //确认支付
        else if (i == R.id.surepay_tv) {
            startActivity(new Intent(this, PaySuccessActivity.class));
        }
        //支付宝支付
        else if (i == R.id.aipay_lay) {

        }
        //微信支付
        else if (i == R.id.weathpay_ray) {

        }
        //银联支付
        else if (i == R.id.unionpay_ray) {

        }
    }
}
