package com.module.base.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 黄双 on 2018/5/19.
 */

public class HttpManager {

    private Retrofit mRetrofit;

    private HttpManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.ourInstance;
    }

    /**
     * 内部类实现单例
     */
    private static class SingletonHolder {
        private static final HttpManager ourInstance = new HttpManager();
    }

    /**
     * 获取相应的Service
     * @param clazz
     * @param <T>
     * @return
     */
    public <T>T getService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
