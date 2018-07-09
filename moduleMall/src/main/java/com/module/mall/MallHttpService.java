package com.module.mall;

import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;
import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.bean.TuanDetalisBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shibing on 18/6/10.
 */

public interface MallHttpService {


    /**
     * 获取首页产品类别
     */

    @GET("api/Product/Catagory/List")
    Observable<ProductTypeBean> getPorTypeList(@Query("type") String type);


    /**
     * 获取首页产品list
     */

    @GET("api/Product/List")
    Observable<ProductBean> getMallPorList(@Query("type") String type, @Query("toIndex") boolean toIndex
            , @Query("catagory") String catagory
    );


    /**
     * 获取产品详情
     */


    @GET("api/Product/{id}")
    Observable<ProDetailsBean> getPorDetails(@Path("id") String id);


    /**
     * 收藏产品
     *
     * @param pid
     * @param uid
     * @return
     */
    @FormUrlEncoded
    @POST("api/UserCollection")
    Observable<ProDetailsBean> ProductCollection(@Field("pid") String pid, @Field("uid") String uid);


    /**
     * 获取评价列表
     *
     * @param pid
     * @param uid
     * @return
     */
    @GET("api/ProductEva/List")
    Observable<ProductEvaBean> ProductEvaList(@Query("pid") String pid, @Query("uid") String uid);


    /**
     * 获取拼团列表
     *
     * @param pid
     * @param uid
     * @param isPublic
     * @return
     */
    @GET("api/Tuan/List")
    Observable<ProductTuanBean> ProductTuanList(@Query("pid") String pid
            , @Query("uid") String uid
            , @Query("isPublic") boolean isPublic
            , @Query("catagory") String catagory);


    @GET("api/Tuan/{id}")
    Observable<TuanDetalisBean> TuanDetalis(@Path("id") String id);


    /**
     * 根据ID获取0元购返现说明信息
     *
     * @param id
     * @return
     */
    @GET("api/PintuanRule/{id}")
    Observable<PintuanRuleBean> PintuanRule(@Path("id") String id);


    /**
     * 根据ID获取0元购返现说明信息
     *
     * @param id
     * @return
     */
    @GET("api/ZulinRule/{id}")
    Observable<PintuanRuleBean> ZulinRule(@Path("id") String id);


    /**
     * 获取默认地址
     *
     * @param id
     * @return
     */
    @GET("api/UserAddress/Default")
    Observable<DefaultAddressBean> getDefaultAddress(@Query("id") String id);


    /**
     * 使用开团卷开团
     *
     * @param uid
     * @param pid
     * @param isPublic
     * @param couponId
     * @return
     */
    @FormUrlEncoded
    @POST("api/Tuan")
    Observable<OpenTuanBean> getOpenTua(@Field("uid") String uid
            , @Field("pid") String pid
            , @Field("isPublic") boolean isPublic
            , @Field("couponId") String couponId);


    /**
     * 原价开团
     *
     * @param uid
     * @param pid
     * @param addressId
     * @param normstr
     * @param payType
     * @return
     */
    @FormUrlEncoded
    @POST("api/Tuan/Buy")
    Observable<OpenTuanBean> getBuyTuan(@Field("uid") String uid
            , @Field("pid") String pid
            , @Field("addressId") String addressId
            , @Field("normstr") String normstr
            , @Field("payType") String payType);


    @FormUrlEncoded
    @POST("api/TuanJoin")
    Observable<OpenTuanBean> getTuanJoin(@Field("uid") String uid
            , @Field("joinType") String joinType
            , @Field("tuanId") String tuanId
            , @Field("addressId") String addressId
            , @Field("normstr") String normstr
            , @Field("payType") String payType);


}


