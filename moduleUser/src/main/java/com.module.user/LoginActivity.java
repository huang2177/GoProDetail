package com.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;

/**
 * Created by shibing on 18/5/3.
 */

@Route(path = Constant.PATH_LOGINACTIVITY)
public class LoginActivity extends BaseActivity {

    private EditText edPhone, edPassword;
    private Button btLogin;
    private TextView tvRegister, tvForgetpass;

    private String tvPhone, tvPassword;

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
        edPhone = findViewById(R.id.login_phone_ed);
        edPassword = findViewById(R.id.login_password_ed);
        btLogin = findViewById(R.id.login_but);
        tvRegister = findViewById(R.id.login_register_tv);
        tvForgetpass = findViewById(R.id.login_forgetpass_tv);


        tvPhone = edPhone.getText().toString();
        tvPassword = edPassword.getText().toString();

    }

    @Override
    public void setListener() {
        super.setListener();
        btLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvForgetpass.setOnClickListener(this);
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
            //登录
            ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
            finish();
        } else if (i == R.id.login_register_tv) {
            //注册
            startActivity(new Intent(this, RegisterActivity.class));
        } else if (i == R.id.login_forgetpass_tv) {
            //忘记密码
            startActivity(new Intent(this, FindPSWActivity.class));
        }
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
