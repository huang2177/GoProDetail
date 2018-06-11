package com.module.home;

import com.module.home.bean.BusinBean;

import okhttp3.ResponseBody;
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

}
