package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.Logger;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.SwitchButton;
import com.module.base.widgets.dialog.CommonDialog;
import com.module.mine.R;
import com.module.mine.ui.modifypaw.ModifyPassActivity;

/**
 * Created by shibing on 18/5/8.
 * <p>
 * <p>
 * 系统设置
 */

public class SeetingActivity extends BaseActivity implements CommonDialog.DialogClickListener {

    RelativeLayout rayPas, rayEdition;
    SwitchButton aSwitch;
    Button butOut;
    private CommonDialog dialog;
    private SPUtil spUtil;
    private boolean isLogin;

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
        spUtil = SPUtil.getInstance(this);
        rayPas = findViewById(R.id.psw_ray);
        rayEdition = findViewById(R.id.edition_ray);
        butOut = findViewById(R.id.out_but);
        isLogin = spUtil.getBoolean(Constant.IS_LOGIN);
        Logger.e("------", isLogin + "");
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
            showDialog();
        }
    }


    private void showDialog() {
        dialog = new CommonDialog.Builder()
                .context(this)
                .listener(this)
                .title("拼跌")
                .message("确定要退出程序吗?")
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();
    }

    @Override
    public void dialogClick(int flag, int type) {
        if (flag == CommonDialog.CONFIRM) {
            if (!isLogin) {
                ToastUtil.show(this, "当前已是退出状态");
                dialog.dismiss();
                return;
            }
            spUtil.setBooloean(Constant.IS_LOGIN, false);
            ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
            dialog.dismiss();
            finish();

        } else if (flag == CommonDialog.CANCEL) {
            dialog.dismiss();
        }

    }
}
