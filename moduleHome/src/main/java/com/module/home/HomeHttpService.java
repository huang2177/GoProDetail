package com.module.home;

import com.module.base.pouduct.ProductBean;
import com.module.home.bean.BannerBean;
import com.module.home.bean.BusinBean;
import com.module.home.bean.IndexDataBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shibing on 18/6/10.
 */

public interface HomeHttpService {


    /**
     * 获取营业厅列表
     */
    @GET("api/Shop/List")
    Observable<BusinBean> ShopList();


    /**
     * 获取banner图
     *
     * @return
     */
    @GET("api/Banner/List")
    Observable<BannerBean> getBannerList();


    /**
     * 获取首页数据
     *
     * @return
     */
    @GET("api/IndexData")
    Observable<IndexDataBean> getIndexData();

    /**
     * 获取首页产品list
     */

    @GET("api/Product/List")
    Observable<ProductBean> getHomePorList(@Query("toIndex") boolean toIndex);

}
