package com.module.mall.ui.moretuan;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mall.MallHttpService;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.prodetails.ProDetailsView;

import java.util.List;

/**
 * Created by shibing on 18/6/15.
 */

public class ProTuanPresenter extends BasePresenter<ProTuanView> {


    private MallHttpService mService;
    private ProTuanView proTuanView;

    @Override
    protected void bindView(ProTuanView proTuanView) {

        this.proTuanView = proTuanView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
    }


    /**
     * 获取拼团列表
     *
     * @param uid
     * @param pid
     */
    public void productTuan(String uid, String pid) {
        observer(new HttpObserver<ProductTuanBean>(mContext, mService.ProductTuanList(
                uid, pid, true), new HttpCallBackImpl<ProductTuanBean>() {
            @Override
            public void onCompleted(ProductTuanBean productTuan) {
                if (productTuan == null) {
                    return;
                }
                proTuanView.showTuanList(productTuan.getData());
            }
        }));

    }

}
