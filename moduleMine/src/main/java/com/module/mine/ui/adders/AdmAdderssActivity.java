package com.module.mine.ui.adders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;
import com.module.mine.adapter.AdmAddressListAdapter;
import com.module.mine.bean.AddersBean;

import java.util.List;

/**
 * Created by shibing on 18/5/8.
 */

public class AdmAdderssActivity extends BaseActivity implements AddersView {


    private AdmAddressListAdapter adapter;
    private ListView listView;
    private Button button;
    private LinearLayout layout;
    private AdderPresenter presenter;


    private List<AddersBean.DataBean> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title(" 收货地址").rightText("完成");
        presenter.AddersList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_admaddress;
    }


    @Override
    public void setListener() {
        super.setListener();
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        startActivity(new Intent(this, AdderAddressActivity.class));
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.admress_list);
        button = findViewById(R.id.add_but);
        layout = findViewById(R.id.nadata_lay);

    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new AdderPresenter();
        return presenter;
    }

    @Override
    public void showAdders(AddersBean addersBean) {
        list = addersBean.getData();
        if (list.size() == 0) {
            listView.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
            return;
        }
        listView.setVisibility(View.VISIBLE);
        adapter = new AdmAddressListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void OnAddersErr(String err) {

    }
}
