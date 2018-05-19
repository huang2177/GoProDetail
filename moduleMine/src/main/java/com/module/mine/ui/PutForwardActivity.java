package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/19.
 */

public class PutForwardActivity extends BaseActivity {


    RelativeLayout rayMoney, rayBlank, rayWeacth;
    TextView tvMoney, tvBlank, tvWeacth, tvAllMoney;
    Button butCommit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("提现");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_putforward;
    }

    @Override
    public void initView() {
        rayMoney = findViewById(R.id.put_money_ray);
        rayBlank = findViewById(R.id.put_blank_ray);
        rayWeacth = findViewById(R.id.put_wc_ray);
        tvMoney = findViewById(R.id.tx_money_tv);
        tvAllMoney = findViewById(R.id.tx_all_tv);
        tvBlank = findViewById(R.id.tx_banlak_tv);
        tvWeacth = findViewById(R.id.tx_wc_tv);
        butCommit = findViewById(R.id.put_commit_but);
    }


    @Override
    public void setListener() {
        super.setListener();
        butCommit.setOnClickListener(this);
        rayMoney.setOnClickListener(this);
        rayBlank.setOnClickListener(this);
        rayWeacth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.put_money_ray) {

        } else if (i == R.id.put_blank_ray) {

        } else if (i == R.id.put_wc_ray) {

        } else if (i == R.id.put_commit_but) {

        }

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
