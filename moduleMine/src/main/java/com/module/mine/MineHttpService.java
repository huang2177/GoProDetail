package com.module.mine;

import com.module.mine.bean.AddersBean;
import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.ComPlaintBean;
import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetailBean;
import com.module.mine.bean.MessAgeBean;
import com.module.mine.bean.ModifyUserBean;
import com.module.mine.bean.TeamBean;
import com.module.mine.bean.TuanCouponBean;
import com.module.mine.bean.UserInfoBean;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

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


    /**
     * 修改用户基本信息
     */
    @Multipart
    @PUT("api/WebUser/{id}")
    Observable<ModifyUserBean> ModifyUser(@Part("photo") RequestBody photo);

    /**
     * 获取系统消息
     *
     * @param id
     * @return
     */
    @GET("api/UserMessage/List")
    Observable<MessAgeBean> UserMessage(@Query("uid") String id);


    /**
     * 获取银行卡余额
     *
     * @param id
     * @return
     */
    @GET("api/UserFeeRecord/List")
    Observable<BlankNumBean> UserFeeRecord(@Query("uid") String id);


    /**
     * 获取我的团队
     *
     * @param id
     * @return
     */
    @GET("api/UserCenter/MyTeam")
    Observable<TeamBean> MyTeam(@Query("uid") String id);


    /**
     * 获取我的开团卷
     *
     * @param id
     * @return
     */
    @GET("api/TuanCoupon/List")
    Observable<TuanCouponBean> TuanCoupon(@Query("uid") String id);


    /**
     * 投诉建议
     *
     * @param uid
     * @param name
     * @param mobile
     * @param content
     * @return
     */
    @FormUrlEncoded
    @POST("api/Suggest")
    Observable<ComPlaintBean> PutSuggest(@Field("uid") String uid
            , @Field("name") String name
            , @Field("mobile") String mobile
            , @Field("content") String content);


    /**
     * 获取新手帮助列表
     *
     * @return
     */
    @GET("api/Problem/List")
    Observable<HelpBean> getProblemList();


    /**
     * 根据id获取新手帮助详情
     *
     * @param id
     * @return
     */
    @GET("api/Problem/{id}")
    Observable<HelpDetailBean> getProblemDetalis(@Path("id") String id);


    /**
     * 获取地址列表
     *
     * @return
     */
    @GET("api/UserAddress/List")
    Observable<AddersBean> getAddersList();


    @FormUrlEncoded
    @POST("api/UserAddress")
    Observable<AddersBean> getUserAddress(@FieldMap Map<String, String> map);

}
