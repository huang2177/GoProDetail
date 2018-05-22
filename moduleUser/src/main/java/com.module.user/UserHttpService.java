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


    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
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


    /**
     * 登录
     *
     * @param mobile
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("api/WebUser/Login")
    Observable<RegisterBean> login(@Field("mobile") String mobile
            , @Field("password") String password);


    /**
     * POST /api/WebUser/ResetPassword 忘记密码/修改密码
     *
     * @param mobile
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("api/WebUser/ResetPassword")
    Observable<ResponseBody> ModifyPsw(@Field("mobile") String mobile
            , @Field("smsCode") String smsCode
            , @Field("password") String password);


}
