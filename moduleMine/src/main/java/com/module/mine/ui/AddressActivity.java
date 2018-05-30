package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.http.HttpService;
import com.module.mine.MineHttpService;
import com.module.mine.R;
import com.module.mine.adapter.AddressListAdapter;

/**
 * Created by shibing on 18/5/6.
 */

@Route(path = Constant.ADDERS)
public class AddressActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private AddressListAdapter addressListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("收货地址").rightText("管理");

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_adderss;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.address_list);

        addressListAdapter = new AddressListAdapter(this);
        listView.setAdapter(addressListAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onRightClick() {
        super.onRightClick();
        startActivity(new Intent(this, AdmAdderssActivity.class));
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
