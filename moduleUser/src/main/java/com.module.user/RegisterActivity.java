package com.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.base.Constant;

/**
 * Created by shibing on 18/5/3.
 */

public class RegisterActivity extends BaseActivity {

    private EditText Edphone, Edpassword, Edcode, Edinvicode;
    private TextView sendcode, agreement;
    private Button register;


    private String Tvphone, Tvpassword, Tvcode, Tvinvicode;


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
        Edphone = findViewById(R.id.register_phone_ed);
        Edpassword = findViewById(R.id.register_pwass_ed);
        Edcode = findViewById(R.id.registetr_code_ed);
        Edinvicode = findViewById(R.id.register_invit_ed);

        sendcode = findViewById(R.id.register_sendcode_tv);
        register = findViewById(R.id.register_but);
        agreement = findViewById(R.id.register_agre_tv);

        //
        Tvphone = Edphone.getText().toString();
        Tvpassword = Edpassword.getText().toString();
        Tvcode = Edcode.getText().toString();
        Tvinvicode = Edinvicode.getText().toString();


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


    /**
     * 监听事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.register_but) {
            //注册
            ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
            finish();

        } else if (i == R.id.registetr_code_ed) {
            //发送验证码

        } else if (i == R.id.register_agre_tv) {
            //协议
            startActivity(new Intent(this, AgreementActivity.class));
        }
    }


    @Override
    public void onRightClick() {
        super.onRightClick();
        startActivity(new Intent(this, HelpActivity.class));
    }
}
