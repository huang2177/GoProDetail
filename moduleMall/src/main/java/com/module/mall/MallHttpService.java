package com.module.mall;

import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;

import retrofit2.http.Field;
import retrofit2.http.GET;
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
    Observable<ProductBean> getMallPorList(@Query("catagory") String catagory);

}
