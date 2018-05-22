package com.module.mine;

import com.module.base.http.HttpService;
import com.module.mine.bean.UserInfoBean;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface MineHttpService {

    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    @GET("api/WebUser/Sms")
    Observable<ResponseBody> sendCode(@Query("mobile") String mobile);

    /**
     * 忘记密码/修改密码
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


    /**
     * 根据id获取用户详情
     */
    @GET("api/WebUser/{id}")
    Observable<UserInfoBean> getUserInfo(@Path("id") String id);

}
