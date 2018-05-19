package com.module.mine;

import com.module.base.http.HttpService;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Subscriber;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface MineHttpService extends HttpService {
    @GET
    Subscriber getData(@Query("name") String s);
}
