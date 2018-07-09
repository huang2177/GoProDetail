package com.module.base.widgets.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.module.base.BasePresenter;

import static com.module.base.utils.ScreenUtils.getScreenHeight;
import static com.module.base.utils.StatusUtil.getStatusBarHeight;


/**
 * @author huangshuang
 */

public abstract class XBottomDialog<V, T extends BasePresenter<V>> extends BottomSheetDialog implements View.OnClickListener {
    public View view;
    protected Activity activity;

    public BasePresenter<V> presenter;

    public XBottomDialog(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;

        view = View.inflate(activity, getLayoutId(), null);
        setContentView(view);

        initView();
        setListener();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.onCreate();
            presenter.attachView((V) this);
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void setListener();


    @Override
    protected void onStart() {
        super.onStart();
        setPeekHeight();
    }

    /**
     * 设置展开的默认的高度
     */
    private void setPeekHeight() {
        BottomSheetBehavior mDialogBehavior = BottomSheetBehavior.from((View) view.getParent());
        mDialogBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    /**
     * 处理在某些手机上面存在状态栏不透明的问题
     */
    private void init() {
        int screenHeight = getScreenHeight(activity);
        int statusBarHeight = getStatusBarHeight(getContext());
        int dialogHeight = screenHeight - statusBarHeight;
        if (getWindow() != null) {
            getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, dialogHeight == 0
                    ? ViewGroup.LayoutParams.MATCH_PARENT
                    : dialogHeight);
        }
    }

    @Override
    public void onClick(View v) {

    }


    /**
     * 用于实现类创建presenter
     *
     * @return
     */
    public abstract BasePresenter<V> createPresenter();
}
