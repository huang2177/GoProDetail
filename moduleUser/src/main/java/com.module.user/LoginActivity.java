package com.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

/**
 * Created by shibing on 18/5/3.
 */

public class LoginActivity extends BaseActivity {


    private EditText login_phone_ed, login_password_ed;
    private Button login_but;
    private TextView login_register_tv, login_forgetpass_tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title("登录").rightText("完成");
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
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void setListener() {
        super.setListener();
        login_but.setOnClickListener(this);
        login_register_tv.setOnClickListener(this);
        login_forgetpass_tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);

        /// TODO: 18/5/4  怎么不能switch
      /*  switch (v.getId()) {
            case R.id.login_but:
                break;

            case R.id.login_register_tv:
                break;

            case R.id.login_forgetpass_tv:
                break;
        }*/
    }
}
