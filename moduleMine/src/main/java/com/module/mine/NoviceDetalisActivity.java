package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;

/**
 * Created by shibing on 18/5/16.
 */

public class NoviceDetalisActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("视频详情");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novicedetalis;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
