package com.module.mine.ui.modifyuserinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.utils.GlideImageLoader;
import com.module.base.widgets.RoundImageView;
import com.module.mine.R;

import java.util.ArrayList;

/**
 * Created by shibing on 18/5/5.
 */

public class UserInfoActivity extends BaseActivity {
    private RoundImageView head;
    private EditText nikeName;
    private Button save;
    private String imgaePath;
    private String userName;
    public static final int REQUEST_CODE_SELECT = 100;
    public static final int IMAGE_PICKER = 101;
    private ArrayList<ImageItem> images;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("基础信息");
        initPicker();
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
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent, REQUEST_CODE_SELECT);
        }
        //保存
        else if (i == R.id.info_save_but) {

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null&&) {
                images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Log.e("12121212", "onActivityResult: " + images.size());
                // ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);

            }
        }*/
    }


    private void initPicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
       // imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);                      //显示拍照按钮
        imagePicker.setMultiMode(true);                       //设置单选
        imagePicker.setCrop(true);                            //允许裁剪（单选才有效）
        imagePicker.setSelectLimit(1);                        //数量
        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
        imagePicker.setStyle(CropImageView.Style.CIRCLE);     //裁剪框的形状
    }


}
