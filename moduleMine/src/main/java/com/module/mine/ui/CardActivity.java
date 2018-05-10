package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/6
 * <p>
 * <p>
 * 设置银行卡
 */

public class CardActivity extends BaseActivity {


    private EditText edNumber, edName, edBank;
    private Button btSave;

    private String number, name, bank;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("设置银行卡").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_card;
    }

    @Override
    public void initView() {
        edNumber = findViewById(R.id.card_number_ed);
        edName = findViewById(R.id.card_name_ed);
        edBank = findViewById(R.id.card_bank_ed);
        btSave = findViewById(R.id.card_save_but);

        number = edNumber.getText().toString();
        name = edName.getText().toString();
        bank = edBank.getText().toString();

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void setListener() {
        super.setListener();
        btSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        ToastUtil.show(this, "保存");
    }
}
