package com.module.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * @author Huangshuang 2018/3/8 0008
 */

public abstract class BasePresenter<V> {

    private WeakReference<V> mReference;
    public CompositeSubscription mSubscription;

    public void onCreate() {
        mSubscription = new CompositeSubscription();
    }

    public void attachView(V v) {
        mReference = new WeakReference<V>(v);
        bindView(mReference.get());
    }

    protected abstract void bindView(V v);

    /*
     * 判断view是否被回收
     */
    protected boolean isRecycle() {
        if (mReference == null)
            return true;
        return mReference.get() == null;
    }


    public void detachView() {
        if (mReference != null && mReference.get() != null) {
            mReference.clear();
            mReference = null;
        }
        if (mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
        }
    }
}
