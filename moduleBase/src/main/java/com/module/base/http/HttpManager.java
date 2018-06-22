package com.module.base.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.module.base.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 黄双 on 2018/5/19.
 */

public class HttpManager {

    private Retrofit mRetrofit;

    private HttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new StethoInterceptor());

        /**log用拦截器*/
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
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
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
