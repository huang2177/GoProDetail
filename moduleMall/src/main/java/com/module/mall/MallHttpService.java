package com.module.mall;

import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;

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
    Observable<ProductBean> getMallPorList(@Query("type") String type
            , @Query("toIndex") boolean toIndex
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


    @GET("api/Tuan/List")
    Observable<ProductTuanBean> ProductTuanListGorp(@Query("catagory") String catagory);


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
}
