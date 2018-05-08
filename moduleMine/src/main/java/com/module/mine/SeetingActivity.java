package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;

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
}
