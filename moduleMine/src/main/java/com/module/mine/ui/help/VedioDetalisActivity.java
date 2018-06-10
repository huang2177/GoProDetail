package com.module.mine.ui.help;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangbryant.mylibrary.media.HIjkPlayerView;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.Logger;
import com.module.base.utils.ScreenUtils;
import com.module.mine.R;
import com.module.mine.bean.HelpBean;

import java.util.List;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * 视频详情
 * Created by shibing on 18/5/16.
 */

public class VedioDetalisActivity extends BaseActivity
        implements IMediaPlayer.OnCompletionListener
        , VedioDetalisView {

    private LinearLayout mLayout;
    private TextView tvName, tvTime, tvContent;
    private HIjkPlayerView mPlayerView;
    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";

    private List<HelpBean.DataBean> list;
    private VedioDetalisPresenter presenter;
    private String imagePath;
    private String vedioUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("视频详情");
        Log.e("1212121", "onCreate: " + getIntent().getStringExtra("helpId"));
        presenter.getHelpDetalis(getIntent().getStringExtra("helpId"));
    }

    @Override
    public boolean isUseStatusBarColor() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novicedetalis;
    }

    @Override
    public void initView() {
        tvName = findViewById(R.id.tv_name);
        tvTime = findViewById(R.id.tv_time);
        tvContent = findViewById(R.id.tv_content);
        mLayout = findViewById(R.id.ll_container);
        mPlayerView = findViewById(R.id.ijk_player);
    }


    @Override
    public BasePresenter createPresenter() {
        presenter = new VedioDetalisPresenter();
        return presenter;
    }


    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mPlayerView.getLayoutParams();
        lp.topMargin = newConfig.orientation == 2 ? 0 : ScreenUtils.dp2px(this, 165);
        mPlayerView.setLayoutParams(lp);
        mPlayerView.setLayoutParams(lp);
        mPlayerView.configurationChanged(newConfig);
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

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        mPlayerView.mPlayerThumb.setVisibility(View.VISIBLE);
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

    @Override
    public void showHelpDetalis(HelpBean helpBean) {
        list = helpBean.getData();
        tvName.setText(list.get(0).getTitle());
        tvTime.setText(list.get(0).getCreateTime());
        tvContent.setText(list.get(0).getContent());
        imagePath = list.get(0).getImgurl();
        vedioUrl = list.get(0).getVideoImgurl();
        intiPlayer(imagePath, vedioUrl);
    }

    @Override
    public void showHeloErr(String error) {

    }


    //视频设置
    private void intiPlayer(String imagePath, String vedioUrl) {
        mPlayerView.init()
                .setTitle("")
                //.setVideoPath(vedioUrl)
                .setVideoPath(VIDEO_HD_URL)
                .setMediaQuality(HIjkPlayerView.MEDIA_QUALITY_HIGH)
                .setOnCompletionListener(this);
        Glide.with(this).load(Constant.IMAGEURL + imagePath).into(mPlayerView.mPlayerThumb);

    }
}
