package com.module.mall;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;

import java.util.List;

public class MallPresenter extends BasePresenter<MallView> {


    private MallView mallView;
    private MallHttpService mService;

    @Override
    protected void bindView(MallView mallView) {
        this.mallView = mallView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
    }


    /**
     * 获取产品类别
     */

    public void getProductType(String type) {
        observer(new HttpObserver<ProductTypeBean>(mContext, mService.getPorTypeList(type)
                , new HttpCallBackImpl<ProductTypeBean>() {
            @Override
            public void onCompleted(ProductTypeBean typeBean) {
                if (typeBean == null) {
                    return;
                }
                mallView.showProductType(typeBean);
            }
        }));

    }


    /**
     * 获取产品列表
     *
     * @param catagory
     */
    public void getProductList(String type, String catagory) {
        observer(new HttpObserver<ProductBean>(mContext, mService.getMallPorList(type, false, catagory)
                , new HttpCallBackImpl<ProductBean>() {
            @Override
            public void onCompleted(ProductBean productBean) {
                if (productBean == null) {
                    return;
                }
                mallView.showProduct(productBean.getData());
            }
        }));

    }
}
