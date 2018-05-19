package com.module.base;

import android.content.Context;

import rx.subscriptions.CompositeSubscription;

/**
 * @author Huangshuang 2018/3/8 0008
 */

public abstract class BasePresenter<V> {

    public CompositeSubscription mSubscription;

    public void onCreate() {
        mSubscription = new CompositeSubscription();
    }



    public abstract void attachView(V v);


    public void detachView() {
        if (mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe();
        }
    }
}
