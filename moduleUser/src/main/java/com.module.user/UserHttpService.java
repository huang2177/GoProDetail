package com.module.user;

import com.module.user.bean.RegisterBean;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface UserHttpService {

    @GET("api/WebUser/Sms")
    Observable<ResponseBody> sendCode(@Query("mobile") String mobile);

    /**
     * 注册
     *
     * @param mobile
     * @param password
     * @param smsCode
     * @param inviteCode
     * @return
     */
    @FormUrlEncoded
    @POST("api/WebUser")
    Observable<RegisterBean> register(@Field("mobile") String mobile
            , @Field("password") String password
            , @Field("smsCode") String smsCode
            , @Field("inviteCode") String inviteCode);
}
