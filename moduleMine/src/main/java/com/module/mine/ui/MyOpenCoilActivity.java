package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;
import com.module.mine.adapter.OpenCoilAdapter;

/**
 * Created by shibing on 18/5/6.
 */

public class MyOpenCoilActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private OpenCoilAdapter openCoilAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title("我的开团卷").rightText("帮助说明");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_opencoil;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.opencoil_list);
        listView.setOnItemClickListener(this);

        openCoilAdapter = new OpenCoilAdapter(this);
        listView.setAdapter(openCoilAdapter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
