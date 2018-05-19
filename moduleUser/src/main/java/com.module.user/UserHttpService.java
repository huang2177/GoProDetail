package com.module.user;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface UserHttpService {

    @POST
    Observable register(@Query("mobile") String mobile
            , @Query("password") String password
            , @Query("smsCode") String smsCode
            , @Query("inviteCode") String inviteCode);
}
