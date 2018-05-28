package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.XListView;
import com.module.mine.R;
import com.module.mine.adapter.GiveOpenCoilAdapter;

/**
 * Created by shibing on 18/5/6.
 */

public class GiveOpenCoilActivity extends BaseActivity {


    private XListView listView;
    private EditText edPhone;
    private TextView tvGive;

    private GiveOpenCoilAdapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("赠送开团卷").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_giveopencoil;
    }

    @Override
    public void initView() {
        edPhone = findViewById(R.id.give_phone_ed);
        tvGive = findViewById(R.id.give_tv);

        listView = findViewById(R.id.give_list);
        adapter = new GiveOpenCoilAdapter(this);
        listView.setAdapter(adapter);

        tvGive.setOnClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        ToastUtil.show(this, "赠送");

    }
}
