package com.module.user;

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

public class RegisterActivity extends BaseActivity {

    private EditText phone, password, code, invicode;
    private TextView sendcode, agreement;
    private Button register;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("注册").rightText("帮助");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        phone = findViewById(R.id.register_phone_ed);
        password = findViewById(R.id.register_pwass_ed);
        code = findViewById(R.id.registetr_code_ed);
        sendcode = findViewById(R.id.register_sendcode_tv);
        invicode = findViewById(R.id.register_invit_ed);
        register = findViewById(R.id.register_but);
        agreement = findViewById(R.id.register_agre_tv);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void setListener() {
        super.setListener();
        register.setOnClickListener(this);
        agreement.setOnClickListener(this);
        sendcode.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
           /* case R.id.register_but:
                break;*/
        }
    }
}
