package com.module.base.http;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.module.base.BuildConfig;
import com.module.base.utils.Logger;
import com.module.base.utils.ToastUtil;

import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by 黄双 on 2018/5/26.
 */

public abstract class HttpCallBackImpl<T> {

    public abstract void onCompleted(T t);

    /**
     * 统一处理 异常
     *
     * @param e
     */
    public void onError(Throwable e, Context context) {

        if (e instanceof ConnectException) {
            ToastUtil.show(context, "网络异常，请检查后重试！");
        }
        if (e instanceof HttpException) {
            HttpException exception = (HttpException) e;
            int code = exception.code();
            ToastUtil.show(context, "服务器异常，请稍后重试！");
        }
    }
}
