package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.mine.R;

import retrofit2.http.Path;

/**
 * Created by shibing on 18/5/6.
 * <p>
 * 我的押金
 */


@Route(path = Constant.PATH_DEPOSIT)
public class DepositActivity extends BaseActivity {

    private TextView tvMoney, tvShous;
    private Button butRec;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("押金");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView() {
        tvMoney = findViewById(R.id.order_money_tv);
        tvShous = findViewById(R.id.order_shous_tv);
        butRec = findViewById(R.id.rec_but);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        butRec.setOnClickListener(this);
        tvShous.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //前往0元首饰盒
        if (i == R.id.order_shous_tv) {

        }
        //去充值押金
        else if (i == R.id.rec_but) {
            Intent intent = new Intent(this, RechDepositActivity.class);
            intent.putExtra(Constant.TITLE, "支付押金");
            startActivity(intent);
        }
    }
}
