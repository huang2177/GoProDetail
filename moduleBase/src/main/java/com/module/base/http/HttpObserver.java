package com.module.base.http;

import android.content.Context;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 黄双 on 2018/5/26.
 */

public class HttpObserver<T> implements Observer<T> {
    private Context mContext;
    private HttpCallBackImpl mIHttpCallBack;
    public Subscription mSubscription;

    public HttpObserver(Context context, Observable observable, HttpCallBackImpl callBack) {
        this.mContext = context;
        this.mIHttpCallBack = callBack;
        mSubscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        mIHttpCallBack.onError(e, mContext);
    }

    @Override
    public void onNext(T o) {
        try {
            mIHttpCallBack.onCompleted(o);
        } catch (Exception e) {

        }
    }
}
