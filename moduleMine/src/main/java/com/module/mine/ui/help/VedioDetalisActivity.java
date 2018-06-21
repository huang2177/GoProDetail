package com.module.mine.ui.help;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangbryant.mylibrary.media.HIjkPlayerView;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.ScreenUtils;
import com.module.base.widgets.X5WebView;
import com.module.mine.R;
import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetailBean;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.List;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * 视频详情
 * Created by shibing on 18/5/16.
 */

public class VedioDetalisActivity extends BaseActivity implements IMediaPlayer.OnCompletionListener
        , NewUserHelpView {

    private X5WebView mX5WebView;
    private LinearLayout mLayout;
    private TextView tvName, tvTime;
    private HIjkPlayerView mPlayerView;
    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";

    private List<HelpBean.DataBean> list;
    private NewUserHelpPresenter presenter;
    private String imagePath;
    private String vedioUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initHardwareAccelerate();
        title("视频详情");
        presenter.getHelpDetalis(getIntent().getStringExtra("helpId"));
    }

    /**
     * 启用硬件加速(WebView)
     */
    private void initHardwareAccelerate() {
        getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
                , android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novicedetalis;
    }

    @Override
    public void initView() {
        tvName = findViewById(R.id.tv_name);
        tvTime = findViewById(R.id.tv_time);
        mLayout = findViewById(R.id.ll_container);
        mX5WebView = findViewById(R.id.tv_content);
        mPlayerView = findViewById(R.id.ijk_player);

        mX5WebView.setWebViewClient(new MyX5WebClient());

        intiPlayer(IMAGE_URL, "");
    }


    @Override
    public BasePresenter createPresenter() {
        presenter = new NewUserHelpPresenter();
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
        if (mX5WebView != null) {
            mX5WebView.destroy();
        }
        super.onDestroy();
    }


    @Override
    public void showHelpDetail(HelpDetailBean.DataBean dataBean) {
        imagePath = dataBean.getImgurl();
        tvName.setText(dataBean.getTitle());
        vedioUrl = dataBean.getVideoImgurl();
        tvTime.setText(dataBean.getCreateTime());

        mX5WebView.loadData(dataBean.getContent(), "text/html;charset=UTF-8", null);
        intiPlayer(imagePath, "");
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
            Intent intent = new Intent(VedioDetalisActivity.this, WebViewActivity.class);
            intent.putExtra(Constant.URL, url);
            startActivity(intent);
            return true;
        }
    }
}
