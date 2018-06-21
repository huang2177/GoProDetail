package com.module.mine.ui.help;

import android.os.Build;
import android.view.KeyEvent;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.widgets.X5WebView;
import com.module.mine.R;

/**
 * Created by 黄双 on 2018/6/21.
 */

public class WebViewActivity extends BaseActivity {

    private X5WebView mX5WebView;
    private String mUrl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    public void initView() {
        initHardwareAccelerate();
        initWebView();
    }

    /**
     * 初始化WebView
     */
    private void initWebView() {
        mX5WebView = findViewById(R.id.webview);

        mUrl = getIntent().getStringExtra(Constant.URL);
        mX5WebView.loadUrl(mUrl);
    }

    /**
     * 启用硬件加速
     */
    private void initHardwareAccelerate() {
        if (Build.VERSION.SDK_INT >= 11) {
            getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
                    , android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mX5WebView != null && mX5WebView.canGoBack()) {
                mX5WebView.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        if (mX5WebView != null)
            mX5WebView.destroy();
        super.onDestroy();
    }
}
