package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/8.
 * <p>
 * <p>
 * 系统设置
 */

public class SeetingActivity extends BaseActivity {

    RelativeLayout rayPas, rayEdition;
    Switch aSwitch;
    Button butOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("系统设置");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_seeting;
    }

    @Override
    public void initView() {
        rayPas = findViewById(R.id.psw_ray);
        rayEdition = findViewById(R.id.edition_ray);
        butOut = findViewById(R.id.out_but);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void setListener() {
        super.setListener();
        rayPas.setOnClickListener(this);
        rayEdition.setOnClickListener(this);
        butOut.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //修改密码
        if (i == R.id.psw_ray) {
            startActivity(new Intent(this, ModifyPassActivity.class));
        }
        //版本信息
        else if (i == R.id.edition_ray) {
            startActivity(new Intent(this, EditionActivity.class));
        }
        //退出登录
        else if (i == R.id.out_but) {

        }
    }
}
