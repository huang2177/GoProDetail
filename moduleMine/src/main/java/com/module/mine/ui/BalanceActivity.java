package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.XListView;
import com.module.mine.R;
import com.module.mine.adapter.BalanceAdapter;

/**
 * Created by shibing on 18/5/6.
 */

public class BalanceActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    private TextView tvMoney;
    private LinearLayout tvPut, tvRec;
    private XListView listView;

    private BalanceAdapter balanceAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("余额");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_balance;
    }

    @Override
    public void initView() {
        tvMoney = findViewById(R.id.balance_money_tv);
        tvPut = findViewById(R.id.balance_put_lay);
        tvRec = findViewById(R.id.balance_rec_lay);
        listView = findViewById(R.id.balance_listview);
        listView.setOnItemClickListener(this);
        balanceAdapter = new BalanceAdapter(this);
        listView.setAdapter(balanceAdapter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        tvPut.setOnClickListener(this);
        tvRec.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //提现
        if (i == R.id.balance_put_lay) {
            ToastUtil.show(this, "提现");
            startActivity(new Intent(this,PutForwardActivity.class));
        }
        //充值
        else if (i == R.id.balance_rec_lay) {
            Intent intent = new Intent(this, RechDepositActivity.class);
            intent.putExtra(Constant.TITLE, "充值");
            startActivity(intent);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this, "监听事件");
    }


}
