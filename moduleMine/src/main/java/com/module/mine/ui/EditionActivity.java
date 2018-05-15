package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/15.
 */

public class EditionActivity extends BaseActivity {


    private TextView tvEdition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("版本信息");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edition;
    }

    @Override
    public void initView() {
        tvEdition = findViewById(R.id.edition_tv);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
