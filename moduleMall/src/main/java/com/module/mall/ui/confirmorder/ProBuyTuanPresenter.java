package com.module.mall.ui.confirmorder;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mall.MallHttpService;
import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;

/**
 * Created by shibing on 18/6/15.
 */

public class ProBuyTuanPresenter extends BasePresenter<TuanBuyView> {


    private MallHttpService mService;
    private TuanBuyView tuanBuyView;

    @Override
    protected void bindView(TuanBuyView tuanBuyView) {
        this.tuanBuyView = tuanBuyView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
    }


    public void BuyTuan(String uid, String pid, String addressId, String normstr, String payType) {
        observer(new HttpObserver<OpenTuanBean>(mContext, mService.getBuyTuan(uid, pid, addressId, normstr, payType)
                , new HttpCallBackImpl<OpenTuanBean>() {
            @Override
            public void onCompleted(OpenTuanBean tuanBean) {
                if (tuanBean == null) {
                    return;
                }
                if (tuanBean.getCode().equals("00") && tuanBean.getMsg().equals("SUCCESS")) {
                    tuanBuyView.showBuyTuan(tuanBean.getData());
                } else {
                    tuanBuyView.showBuyError(tuanBean.getMsg());
                }
            }
        }));
    }


}
