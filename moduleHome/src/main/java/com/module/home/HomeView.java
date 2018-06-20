package com.module.home;

import com.module.base.pouduct.ProductBean;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;

import java.util.List;

public interface HomeView {


    void showBanner(BannerBean bannerBean);

    void OnBannerErr(String err);

    void showIndexData(IndexDataBean indexDataBean);



    void showProduct(List<ProductBean.DataBean> phoneList,List<ProductBean.DataBean> goldList);

}
