package com.module.mall.ui.tuanhall;

import com.module.base.BasePresenter;
import com.module.base.BaseView;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.pouduct.ProductBean;
import com.module.mall.MallHttpService;
import com.module.mall.bean.TuanDetalisBean;

/**
 * Created by shibing on 18/6/21.
 */

public class TuanDetalisPresenter extends BasePresenter<TuanDetalisView> {


    private TuanDetalisView detalisView;
    private MallHttpService mService;


    @Override
    protected void bindView(TuanDetalisView tuanDetalisView) {
        this.detalisView = tuanDetalisView;
        this.mService = HttpManager.getInstance().getService(MallHttpService.class);
    }


    /**
     * 获取拼团详情
     *
     * @param id
     */
    public void TuanDetalis(String id) {

        observer(new HttpObserver<TuanDetalisBean>(mContext, mService.TuanDetalis(id), new HttpCallBackImpl<TuanDetalisBean>() {
            @Override
            public void onCompleted(TuanDetalisBean detalisBean) {

                if (detalisBean == null) {
                    return;
                }
                detalisView.showTuanDetalis(detalisBean);
            }
        }));
    }


    public void TuanDetalisProduct(String type,String catagory) {
        observer(new HttpObserver<ProductBean>(mContext, mService.getMallPorList(type,false, catagory), new HttpCallBackImpl<ProductBean>() {
            @Override
            public void onCompleted(ProductBean productBean) {

                if (productBean == null) {
                    return;
                }
                detalisView.showTuanDetalisProduct(productBean.getData());
            }
        }));
    }


}
