package com.module.mine.ui.compiaint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.base.utils.TextUtil;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;
import com.module.mine.bean.ComPlaintBean;

/**
 * Created by shibing on 18/5/8.
 */

public class ComplaintActivity extends BaseActivity implements ComPlaintView {


    private EditText edName, edPhone, edContent;
    private Button butCommit;
    private ComPlaintPresenter presenter;
    private String name;
    private String moblie;
    private String content;
    private SPUtil spUtil;
    private String userId;

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
        presenter = new ComPlaintPresenter();
        return presenter;
    }


    private void getEdit() {
        spUtil = SPUtil.getInstance(this);
        userId = spUtil.getString(Constant.USERID);
        name = edName.getText().toString();
        moblie = edPhone.getText().toString();
        content = edContent.getText().toString();


    }

    @Override
    public void setListener() {
        super.setListener();
        butCommit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        getEdit();
        if (!TextUtil.isChinaPhoneLegal(moblie)) {
            ToastUtil.show(this, "请填写正确的手机号码，以便方便联系您");
            return;
        }
        presenter.getSuggest(userId, name, moblie, content);
    }

    @Override
    public void OnSuPlanSuc(ComPlaintBean comPlaintBean) {
        if (comPlaintBean.getCode().equals("00") && comPlaintBean.getMsg().equals("SUCCESS")) {
            ToastUtil.show(this, "提交成功");
            finish();
        }
    }

    @Override
    public void OnSuPlanErr(String error) {

    }
}
