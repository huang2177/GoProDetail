package com.module.base.pouduct;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;

/**
 * Created by shibing on 18/6/12.
 */

public class ProductPresenter extends BasePresenter<ProductView> {

    private ProductHttpService mService;
    private ProductView productView;

    @Override
    protected void bindView(ProductView productView) {
        this.productView = productView;
        mService = HttpManager.getInstance().getService(ProductHttpService.class);
    }


    public void getProductList() {
        observer(new HttpObserver<ProductBean>(mContext, mService.getHomePorList(true), new HttpCallBackImpl<ProductBean>() {
            @Override
            public void onCompleted(ProductBean productBean) {
                if (productBean == null) {
                    return;
                }
                productView.shouProduct(productBean);
            }
        }));
    }

}
