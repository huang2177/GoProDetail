package com.module.base.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.module.base.R;

/**
 * 分享dialog
 * Created by 黄双 on 2018/6/9.
 */

public class ShareDialog extends Dialog implements View.OnClickListener {

    private TextView mTvWechat, mTvQQ, mTvWeibo, mTvZFB;

    public ShareDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_share_layout);

        initView();
        setListener();
    }

    private void initView() {
        mTvQQ = findViewById(R.id.share_qq);
        mTvZFB = findViewById(R.id.share_zfb);
        mTvWeibo = findViewById(R.id.share_weibo);
        mTvWechat = findViewById(R.id.share_wechat);
    }

    private void setListener() {
        mTvQQ.setOnClickListener(this);
        mTvZFB.setOnClickListener(this);
        mTvWeibo.setOnClickListener(this);
        mTvWechat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.share_qq) {

        } else if (i == R.id.share_zfb) {

        } else if (i == R.id.share_weibo) {

        } else if (i == R.id.share_wechat) {

        }
    }
}
