package com.module.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;

/**
 * Created by shibing on 18/5/8.
 */

public class ComplaintActivity extends BaseActivity {


    private EditText edName, edPhone, edContent;
    private Button butCommit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("投诉建议");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_complaint;
    }

    @Override
    public void initView() {
        edName = findViewById(R.id.complaint_name_ed);
        edPhone = findViewById(R.id.complaint_phone_ed);
        edContent = findViewById(R.id.complaint_content_ed);
        butCommit = findViewById(R.id.commit_but);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
