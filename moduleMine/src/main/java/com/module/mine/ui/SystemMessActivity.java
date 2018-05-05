package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;
import com.module.mine.adapter.MessAgeAdapter;

/**
 * Created by shibing on 18/5/5.
 */

public class SystemMessActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    private ListView listView;

    private MessAgeAdapter messAgeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("系统消息").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.message_list);
        listView.setOnItemClickListener(this);
        messAgeAdapter = new MessAgeAdapter(this);
        listView.setAdapter(messAgeAdapter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this, "监听事件");
    }
}
