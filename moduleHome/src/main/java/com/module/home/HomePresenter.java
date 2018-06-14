package com.module.home;

import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.pouduct.ProductBean;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;

import java.util.List;

public class HomePresenter extends BasePresenter<HomeView> {


    private HomeView homeView;
    private HomeHttpService mService;

    @Override
    protected void bindView(HomeView homeView) {
        this.homeView = homeView;
        mService = HttpManager.getInstance().getService(HomeHttpService.class);
    }

    public void getBannerList() {
        observer(new HttpObserver<BannerBean>(mContext, mService.getBannerList(), new HttpCallBackImpl<BannerBean>() {
            @Override
            public void onCompleted(BannerBean bannerBean) {
                if (bannerBean == null) {
                    return;
                }
                homeView.showBanner(bannerBean);
            }
        }));
    }

    public void getIndexData() {
        observer(new HttpObserver<IndexDataBean>(mContext, mService.getIndexData(), new HttpCallBackImpl<IndexDataBean>() {
            @Override
            public void onCompleted(IndexDataBean indexDataBean) {

                if (indexDataBean == null) {
                    return;
                }
                homeView.showIndexData(indexDataBean);
            }
        }));
    }

    public void getProductList() {
        observer(new HttpObserver<ProductBean>(mContext, mService.getHomePorList(true), new HttpCallBackImpl<ProductBean>() {
            @Override
            public void onCompleted(ProductBean productBean) {
                if (productBean == null) {
                    return;
                }
                homeView.showProduct(productBean);
            }
        }));
    }

    /**
     * 拼接数据
     *
     * @param productBean
     */
    private void handleData(ProductBean productBean) {
        int phoneCount = 0, goldCount = 0;
        List<ProductBean.DataBean> products = productBean.getData();
        for (int i = 0; i < products.size(); i++) {
            if (TextUtils.equals(products.get(i).getCatagory(), "1")) {
                phoneCount++;
            } else {
                goldCount++;
            }
        }


        ProductBean.DataBean dataBean1 = new ProductBean.DataBean();
        dataBean1.setId(R.drawable.img_banner1);
        products.add(0, dataBean1);

        ProductBean.DataBean dataBean2 = new ProductBean.DataBean();
        dataBean2.setId(R.drawable.img1);
        products.add(phoneCount + 1, dataBean2);

        ProductBean.DataBean dataBean3 = new ProductBean.DataBean();
        dataBean3.setId(R.drawable.img_banner2);
        products.add(phoneCount + 2, dataBean3);

        ProductBean.DataBean dataBean4 = new ProductBean.DataBean();
        dataBean4.setId(R.drawable.img1);
        products.add(phoneCount + goldCount + 3, dataBean4);

        homeView.showProduct(productBean);
    }
}
