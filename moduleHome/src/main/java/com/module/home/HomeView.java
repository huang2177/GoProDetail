package com.module.home;

import com.module.base.pouduct.ProductBean;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;

public interface HomeView {


    void showBanner(BannerBean bannerBean);

    void OnBannerErr(String err);

    void showIndexData(IndexDataBean indexDataBean);

    void OnIndexErr(String err);


    void shouProduct(ProductBean productBean);

    void OnProductErr(String err);
}
