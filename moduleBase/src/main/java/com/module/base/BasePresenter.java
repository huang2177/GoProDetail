package com.module.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import com.module.base.http.HttpObserver;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * @author Huangshuang 2018/3/8 0008
 */

public abstract class BasePresenter<V> {

    private WeakReference<V> mReference;
    public CompositeSubscription mSubscription;
    public Context mContext;

    public void onCreate() {
        mSubscription = new CompositeSubscription();
    }

    public void attachView(V v) {
        mReference = new WeakReference<V>(v);
        bindView(mReference.get());

        if (v instanceof BaseActivity){
            mContext = (Context) v;
        }else if (v instanceof BaseFragment){
            mContext = ((BaseFragment) v).mContext;
        }
    }

    protected abstract void bindView(V v);

    /*
     * 判断view是否被回收
     */
    protected boolean isRecycle() {
        if (mReference == null) {
            return true;
        }
        return mReference.get() == null;
    }

    /**
     * 页面销毁时解除与view的绑定
     */
    public void detachView() {
        if (mReference != null && mReference.get() != null) {
            mReference.clear();
            mReference = null;
        }
        if (mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
        }
    }

    /**
     * 提交请求
     */
    public boolean observer(HttpObserver httpObserver) {
        if (httpObserver == null || httpObserver.mSubscription == null) {
            return false;
        }
        mSubscription.add(httpObserver.mSubscription);
        return true;
    }

}
