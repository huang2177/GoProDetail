package com.module.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseFragment;
import com.module.base.base.Constant;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;

/**
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentHome extends BaseFragment {

    private Banner banner;
    private EditText editSearch;
    private TextView tvLocation, tvnewUser;

    public static FragmentHome newInstance(String msg) {

        Bundle args = new Bundle();
        args.putString("msg", msg);
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        editSearch = f(R.id.home_ed);
        banner = f(R.id.home_banner);
        tvnewUser = f(R.id.home_new_user_tv);
        tvLocation = f(R.id.home_location_tv);
    }

    @Override
    public void setListener() {
        tvnewUser.setOnClickListener(this);
        tvLocation.setOnClickListener(this);

        initBanner();
    }

    private void initBanner() {
        banner.setImages(Arrays.asList("123", "123"))
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onClick(View v) {
        ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
    }


    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    /**
     * 重写图片加载器
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide.with(context).load(path).into(imageView);
            imageView.setImageResource(R.drawable.banner);
        }
    }
}
