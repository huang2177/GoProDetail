package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/8.
 */

public class AdderAddressActivity extends BaseActivity {


    EditText edName, edPhone, edDetailed;
    TextView tvCity;
    Button butSave;
    RelativeLayout rayCity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("收货信息管理").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_addaddress;
    }

    @Override
    public void initView() {
        edName = findViewById(R.id.address_name_ed);
        edPhone = findViewById(R.id.adress_phone_ed);
        edDetailed = findViewById(R.id.address_detailed_ed);
        tvCity = findViewById(R.id.address_city_tv);
        butSave = findViewById(R.id.address_save);
        rayCity = findViewById(R.id.address_city_ray);


    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        rayCity.setOnClickListener(this);
        butSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //选择城市
        if (i == R.id.address_city_ray) {

        }
        //保存地址
        else if (i == R.id.address_save) {
            startActivity(new Intent(this, AddressActivity.class));
        }
    }
}
