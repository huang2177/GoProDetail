package com.module.mine.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.VerifyCodeUtil;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/14.
 */



@Route(path = Constant.PATH_MODIFYACTIVITY)
public class ModifyPassActivity extends BaseActivity implements VerifyCodeUtil.CountListener {


    private EditText edPhoneMd, edPassMd, edCodeMd;
    private TextView tvCode;
    private Button butModifty;


    private VerifyCodeUtil util;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("修改密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_modifypass;
    }

    @Override
    public void initView() {
        edPhoneMd = findViewById(R.id.modify_phone_ed);
        edPassMd = findViewById(R.id.modify_pw_ed);
        edCodeMd = findViewById(R.id.modify_code_ed);
        tvCode = findViewById(R.id.modify_sendcode_tv);
        butModifty = findViewById(R.id.modify_but);

        util = new VerifyCodeUtil(this, this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        tvCode.setOnClickListener(this);
        butModifty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        int i = v.getId();
        //发送验证码
        if (i == R.id.modify_sendcode_tv) {
            util.startCount();
        }
        //重置密码
        else if (i == R.id.modify_but) {

        }
    }

    @Override
    public void count(Activity activity, String count) {
        if (TextUtils.equals(count, "0")) {
            tvCode.setText("重新发送");
            tvCode.setClickable(true);
        } else {
            tvCode.setClickable(false);
            tvCode.setText(count + "s");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        util.setStop(true);
    }
}
