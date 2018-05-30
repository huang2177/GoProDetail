package com.module.mall.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mall.R;
import com.module.mall.adpter.MoreEvaluateAdapter;

import butterknife.BindView;

/**
 * Created by shibing on 18/5/28.
 */

public class MoreEvaluateActivity extends BaseActivity {


    private ListView listView;
    private MoreEvaluateAdapter adapter;


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
        listView = findViewById(R.id.list_moreeval);
        adapter = new MoreEvaluateAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
