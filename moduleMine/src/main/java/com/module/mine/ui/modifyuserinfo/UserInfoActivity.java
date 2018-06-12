package com.module.mine.ui.modifyuserinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.widgets.RoundImageView;
import com.module.mine.R;
import com.yanzhenjie.album.Album;

/**
 * Created by shibing on 18/5/5.
 */

public class UserInfoActivity extends BaseActivity {


    private RoundImageView head;
    private EditText nikeName;
    private Button save;
    private final int REQUESTCODE = 100;
    private String imgaePath;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("基础信息");
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_userinfo;
    }

    @Override
    public void initView() {
        head = findViewById(R.id.info_head_image);
        nikeName = findViewById(R.id.info_nikename_ed);
        save = findViewById(R.id.info_save_but);
        head.setShapeType(1);
        imgaePath = getIntent().getStringExtra("imagePath");
        userName = getIntent().getStringExtra("userName");


        GlideManager.loadImage(this, Constant.IMAGE_HOST + imgaePath, head);
        nikeName.setText(userName);

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        save.setOnClickListener(this);
        head.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //选择图片
        if (i == R.id.info_head_image) {
            Album.albumRadio(this)
                    .camera(true)
                    .toolBarColor(ContextCompat.getColor(this, R.color.colorBrown))
                    .statusBarColor(ContextCompat.getColor(this, R.color.colorBrown))
                    .start(REQUESTCODE);
        }
        //保存
        else if (i == R.id.info_save_but) {

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUESTCODE
                && resultCode != Activity.RESULT_OK
                || Album.parseResult(data).size() == 0) {
            return;
        }

        String imgPath = Album.parseResult(data).get(0);
        GlideManager.loadImage(this, imgPath, head);
    }






}
