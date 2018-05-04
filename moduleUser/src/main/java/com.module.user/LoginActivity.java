package com.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.base.Constant;

/**
 * Created by shibing on 18/5/3.
 */

@Route(path = Constant.PATH_LOGINACTIVITY)
public class LoginActivity extends BaseActivity {

    private EditText login_phone_ed, login_password_ed;
    private Button login_but;
    private TextView login_register_tv, login_forgetpass_tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title("登录").leftImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        login_phone_ed = findViewById(R.id.login_phone_ed);
        login_password_ed = findViewById(R.id.login_password_ed);
        login_but = findViewById(R.id.login_but);
        login_register_tv = findViewById(R.id.login_register_tv);
        login_forgetpass_tv = findViewById(R.id.login_forgetpass_tv);

    }

    @Override
    public void setListener() {
        super.setListener();
        login_but.setOnClickListener(this);
        login_register_tv.setOnClickListener(this);
        login_forgetpass_tv.setOnClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.login_but) {

        } else if (i == R.id.login_register_tv) {
            startActivity(new Intent(this, RegisterActivity.class));
        } else if (i == R.id.login_forgetpass_tv) {

        }
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
