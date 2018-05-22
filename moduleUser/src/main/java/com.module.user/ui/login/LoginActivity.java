package com.module.user.ui.login;

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
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.user.R;
import com.module.user.bean.RegisterBean;
import com.module.user.ui.register.RegisterActivity;

/**
 * Created by shibing on 18/5/3.
 */

@Route(path = Constant.PATH_LOGINACTIVITY)
public class LoginActivity extends BaseActivity implements LoginView {
    private EditText edPhone, edPassword;
    private Button btLogin;
    private TextView tvRegister, tvForgetpass;

    private String tvPhone, tvPassword;
    private LoginPresenter loginPresenter;
    private SPUtil spUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("登录").leftImageRes(0);
        spUtil = SPUtil.getInstance(this);
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
        loginPresenter = new LoginPresenter();
        return loginPresenter;
    }


    private void getInfoFromEdit() {
        tvPhone = edPhone.getText().toString();
        tvPassword = edPassword.getText().toString();

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        getInfoFromEdit();
        int i = v.getId();
        //登录
        if (i == R.id.login_but) {
            loginPresenter.login(tvPhone, tvPassword);
        }
        //注册
        else if (i == R.id.login_register_tv) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        //忘记密码
        else if (i == R.id.login_forgetpass_tv) {
            ARouter.getInstance().build(Constant.PATH_MODIFYACTIVITY).navigation();
        }
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }


    //成功后回调
    @Override
    public void onLoginSuc(RegisterBean registerBean) {


        if (!registerBean.getCode().equals("00") && !registerBean.getMsg().equals("SUCCESS")) {
            ToastUtil.show(this, registerBean.getMsg().toString());
            return;
        }

        //保存用户id
        spUtil.setString(Constant.USERID, registerBean.getData().getId());
        ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
        finish();
    }

    @Override
    public void onLoginErr(String error) {
        ToastUtil.show(this, error.toString());
    }
}
