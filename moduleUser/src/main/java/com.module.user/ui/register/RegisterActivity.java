package com.module.user.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.base.utils.VerifyCodeUtil;
import com.module.user.AgreementActivity;
import com.module.user.HelpActivity;
import com.module.user.R;
import com.module.user.bean.RegisterBean;

/**
 * Created by shibing on 18/5/3.
 */

public class RegisterActivity extends BaseActivity implements VerifyCodeUtil.CountListener
        , RegisterView {

    private EditText edPhone, edPassword, edCode, edInvicode;
    private TextView sendcode, agreement;
    private Button register;


    private VerifyCodeUtil util;
    private String tvPhone, tvPassword, tvCode, tvinviCode;
    private RegisterPresenter registerPresenter;

    private SPUtil spUtil;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("注册").rightText("帮助");
        spUtil = SPUtil.getInstance(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        edPhone = findViewById(R.id.register_phone_ed);
        edPassword = findViewById(R.id.register_pwass_ed);
        edCode = findViewById(R.id.registetr_code_ed);
        edInvicode = findViewById(R.id.register_invit_ed);
        sendcode = findViewById(R.id.register_sendcode_tv);
        register = findViewById(R.id.register_but);
        agreement = findViewById(R.id.register_agre_tv);
        util = new VerifyCodeUtil(this, this);
        agreement.setText(Html.fromHtml("我已阅读并同意用户<font color='#a0563c'>《用户注册协议》</font>"));
    }

    @Override
    public BasePresenter createPresenter() {
        registerPresenter = new RegisterPresenter();
        return registerPresenter;
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
        getInfoFromEdit();
        //注册
        if (i == R.id.register_but) {
            registerPresenter.register(tvPhone, tvPassword, tvCode, tvinviCode);
        }
        //发送验证码
        else if (i == R.id.register_sendcode_tv) {
            util.startCount();
            registerPresenter.sendCode(tvPhone);

        }
        //协议
        else if (i == R.id.register_agre_tv) {
            startActivity(new Intent(this, AgreementActivity.class));
        }
    }


    private void getInfoFromEdit() {
        tvPhone = edPhone.getText().toString();
        tvPassword = edPassword.getText().toString();
        tvCode = edCode.getText().toString();
        tvinviCode = edInvicode.getText().toString();
    }

    @Override
    public void onRightClick() {
        startActivity(new Intent(this, HelpActivity.class));
    }

    @Override
    public void count(Activity activity, String count) {
        if (TextUtils.equals(count, "0")) {
            sendcode.setText("重新发送");
            sendcode.setClickable(true);
        } else {
            sendcode.setClickable(false);
            sendcode.setText(count + "s");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        util.setStop(true);
    }

    @Override
    public void onRegisterSuc(RegisterBean registerBean) {
        if (!registerBean.getCode().equals("00") && !registerBean.getMsg().equals("SUCCESS")) {
            ToastUtil.show(this, registerBean.getMsg().toString());
            return;
        }
        spUtil.setString(Constant.USERID, registerBean.getData().getId());
        ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
        finish();
    }

    @Override
    public void onRegisterErr(String error) {
        ToastUtil.show(this, error);
    }

    @Override
    public void onSendCodeSuc(String msg) {
        ToastUtil.show(this, msg);
    }

    @Override
    public void onSendCodeErr(String error) {
        ToastUtil.show(this, error);
    }
}
