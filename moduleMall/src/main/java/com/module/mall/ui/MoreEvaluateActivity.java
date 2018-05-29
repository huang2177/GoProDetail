package com.module.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mall.R;

/**
 * Created by shibing on 18/5/28.
 */

public class MoreEvaluateActivity extends BaseActivity {


    private ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("全部评价");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_moreeval;
    }

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
