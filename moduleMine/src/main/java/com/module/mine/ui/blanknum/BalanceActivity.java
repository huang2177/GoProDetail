package com.module.mine.ui.blanknum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.utils.TextUtils;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.base.utils.TextUtil;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.XListView;
import com.module.mine.R;
import com.module.mine.adapter.BalanceAdapter;
import com.module.mine.bean.BlankNumBean;
import com.module.mine.ui.PutForwardActivity;
import com.module.mine.ui.RechDepositActivity;

import java.util.List;

/**
 * Created by shibing on 18/5/6.
 */

public class BalanceActivity extends BaseActivity implements
        AdapterView.OnItemClickListener
        , BlankNumView {


    private TextView tvMoney;
    private LinearLayout tvPut, tvRec;
    private XListView listView;
    private LinearLayout layNodata;

    private BalanceAdapter balanceAdapter;
    private String banlkNum;
    private List<BlankNumBean.DataBean> list;
    private BlankNumPresenter blankPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("余额");
        blankPresenter.getBlankList(SPUtil.getInstance(this).getString(Constant.USERID));
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
        layNodata = findViewById(R.id.nadata_lay);
        listView.setOnItemClickListener(this);


        banlkNum = getIntent().getStringExtra(Constant.BLANKNUM);
        if (TextUtils.isEmpty(banlkNum)) {
            tvMoney.setText("￥ 0.00");
            return;
        }
        tvMoney.setText("￥" + banlkNum);
    }

    @Override
    public BasePresenter createPresenter() {
        blankPresenter = new BlankNumPresenter();
        return blankPresenter;
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
            startActivity(new Intent(this, PutForwardActivity.class));
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


    /**
     * 展示数据
     *
     * @param blankNumBean
     */
    @Override
    public void showBlankNum(BlankNumBean blankNumBean) {
        list = blankNumBean.getData();


        //没有数据
        if (list.size() == 0) {
            listView.setVisibility(View.GONE);
            layNodata.setVisibility(View.VISIBLE);
            return;
        }

        listView.setVisibility(View.VISIBLE);
        balanceAdapter = new BalanceAdapter(this, list);
        listView.setAdapter(balanceAdapter);
    }

    @Override
    public void onFindErr(String error) {

    }
}
