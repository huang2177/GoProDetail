package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/5.
 */

public class UserInfoActivity extends BaseActivity {


    private ImageView head;
    private EditText nikeName;
    private Button save;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("基础信息").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_userinfo;
    }

    @Override
    public void initView() {
        head = findViewById(R.id.info_head_image);
        nikeName = findViewById(R.id.info_nikename_ed);
        save = findViewById(R.id.info_save_but);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ToastUtil.show(this, "监听事件");
    }
}
