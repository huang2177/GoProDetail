package com.module.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Huangshuang 2018/3/8 0008
 */

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment implements View.OnClickListener {
    protected View viewRoot;
    protected Context mContext;
    protected FragmentActivity mActivity;

    private BasePresenter<V> presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getContext();
        mActivity = getActivity();
        viewRoot = View.inflate(mActivity, getContentView(), null);

        initView();
        setListener();

        presenter = createPresenter();
        if (presenter != null) {
            presenter.onCreate();
            presenter.attachView((V) this);
        }
    }

    protected abstract BasePresenter<V> createPresenter();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return viewRoot;
    }


    /**
     * 用于实现类返回视图
     *
     * @return
     */
    public abstract int getContentView();

    /**
     * 用于实现类初始化控件
     */
    public abstract void initView();


    public void setListener() {

    }


    protected <V extends View> V f(int id) {
        return viewRoot.findViewById(id);
    }

    /**
     * 弹出软键盘
     *
     * @param editText
     */
    public void showInPutKeybord(final EditText editText) {
        editText.requestFocus();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(editText, 0);
                }
            }
        }, 100);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter == null) {
            return;
        }
        presenter.detachView();
    }
}
