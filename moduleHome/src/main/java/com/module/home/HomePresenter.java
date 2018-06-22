package com.module.home;

import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.pouduct.ProductBean;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;

import java.util.ArrayList;
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
                handleData(productBean);

            }
        }));
    }

    private void handleData(ProductBean productBean) {
        List<ProductBean.DataBean> phoneList = new ArrayList<>();
        List<ProductBean.DataBean> goldList = new ArrayList<>();

        for (int i = 0; i < productBean.getData().size(); i++) {
            if (productBean.getData().get(i).getCatagory().equals("1")) {
                phoneList.add(productBean.getData().get(i));
            } else {
                goldList.add(productBean.getData().get(i));
            }
        }

        homeView.showProduct(phoneList, goldList);

    }


}
