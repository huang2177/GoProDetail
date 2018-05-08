package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.mine.R;
import com.module.mine.adapter.AdmAddressListAdapter;

/**
 * Created by shibing on 18/5/8.
 */

public class AdmAdderssActivity extends BaseActivity {


    private AdmAddressListAdapter adapter;
    private ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title(" 收货地址").rightText("完成");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_admaddress;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.admress_list);


        adapter = new AdmAddressListAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
