package com.module.mine.ui.help;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.huangbryant.mylibrary.media.HIjkPlayerView;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/16.
 */

public class NoviceDetalisActivity extends BaseActivity {

    private HIjkPlayerView mPlayerView;
    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("视频详情");

    }

    @Override
    public boolean isUseStatusBarColor() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novicedetalis;
    }

    @Override
    public void initView() {
        mPlayerView = findViewById(R.id.ijk_player);

        intiPlayer();
    }

    private void intiPlayer() {
        mPlayerView.init()
                .setVideoPath(VIDEO_HD_URL)
                .setMediaQuality(HIjkPlayerView.MEDIA_QUALITY_HIGH);
        Glide.with(this).load(IMAGE_URL).into(mPlayerView.mPlayerThumb);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int layoutDirection = newConfig.orientation;
        Log.e("======", layoutDirection + "====");
        titleBarContainer.setVisibility(newConfig.orientation == 1
                ? View.VISIBLE
                : View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPlayerView.configurationChanged(newConfig);
            }
        },1000);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
