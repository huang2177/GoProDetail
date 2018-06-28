package com.module.mine.ui.help;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangbryant.mylibrary.media.HIjkPlayerView;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.mine.R;
import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetailBean;

import java.util.List;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * 视频详情
 * Created by shibing on 18/5/16.
 */

public class VideoDetailsActivity extends BaseActivity implements IMediaPlayer.OnCompletionListener
        , NewUserHelpView {

    private WebView mWebView;
    private LinearLayout mLayout;
    private TextView tvName, tvTime;
    private LinearLayout mLayoutTitle;
    private HIjkPlayerView mPlayerView;

    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";

    private NewUserHelpPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("视频详情");
        presenter.getHelpDetalis(getIntent().getStringExtra("helpId"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novicedetalis;
    }

    @Override
    public void initView() {
        tvName = findViewById(R.id.tv_name);
        tvTime = findViewById(R.id.tv_time);
        mWebView = findViewById(R.id.tv_content);
        mLayout = findViewById(R.id.ll_container);
        mLayoutTitle = findViewById(R.id.ll_title);
        mPlayerView = findViewById(R.id.ijk_player);

        mWebView.setWebViewClient(new MyX5WebClient());

        intiPlayer(IMAGE_URL, "");
    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new NewUserHelpPresenter();
        return presenter;
    }


    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mPlayerView.getLayoutParams();

//        scrollEnable = newConfig.orientation == 2;
//        mLayout.setVisibility(newConfig.orientation == 2 ? View.GONE : View.VISIBLE);
//        mSpace.setVisibility(newConfig.orientation == 2 ? View.GONE : View.VISIBLE);
//        titleBarContainer.setVisibility(newConfig.orientation == 2 ? View.GONE : View.VISIBLE);
//        lp.topMargin = newConfig.orientation == 2 ? 0 : ScreenUtils.dp2px(this,95);
        ViewGroup rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        if (newConfig.orientation == 2) {
            rootView.removeAllViews();
            mLayoutTitle.removeView(mPlayerView);
            rootView.addView(mPlayerView);
        } else {
            rootView.removeAllViews();
            mLayoutTitle.addView(mPlayerView, 2);
            rootView.addView(mLayout);
        }

//        mPlayerView.setLayoutParams(lp);
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

    /**
     * 视频播放完成
     *
     * @param iMediaPlayer
     */
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
        mPlayerView.onDestroy();
        if (mWebView != null) {
            mWebView.destroy();
        }
        super.onDestroy();
    }


    @Override
    public void showHelpDetail(HelpDetailBean.DataBean dataBean) {
        tvName.setText(dataBean.getTitle());
        tvTime.setText(dataBean.getCreateTime());

        mWebView.loadData(dataBean.getContent(), "text/html;charset=UTF-8", null);
        intiPlayer(dataBean.getImgurl(), dataBean.getVideoImgurl());
    }

    @Override
    public void showHelp(HelpBean helpBean) {

    }

    //视频设置
    private void intiPlayer(String imagePath, String vedioUrl) {
        mPlayerView.init()
                .setTitle("")
                //.setVideoPath(vedioUrl)
                .setVideoPath(VIDEO_HD_URL)
                .setMediaQuality(HIjkPlayerView.MEDIA_QUALITY_HIGH)
                .setOnCompletionListener(this);
        Glide.with(this).load(Constant.IMAGE_HOST + imagePath).into(mPlayerView.mPlayerThumb);
    }

    private class MyX5WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if (!url.startsWith("http")) {
                return true;
            }
            Intent intent = new Intent(VideoDetailsActivity.this, WebViewActivity.class);
            intent.putExtra(Constant.URL, url);
            startActivity(intent);
            return true;
        }
    }
}
