package com.module.base.pouduct;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shibing on 18/6/10.
 */

public interface ProductHttpService {


    /**
     * 获取首页产品list
     */

    @GET("api/Product/List")
    Observable<ProductBean> getHomePorList(@Query("toIndex") boolean toIndex);

}
