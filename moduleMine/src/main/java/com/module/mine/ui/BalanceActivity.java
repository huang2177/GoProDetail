package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
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
        title("余额").rightImageRes(0);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
