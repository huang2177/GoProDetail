package com.module.mall.ui.confirmorder;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mall.MallHttpService;
import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.prodetails.ProDetailsView;

/**
 * Created by shibing on 18/6/15.
 */

public class ProOrderPresenter extends BasePresenter<PorOrderView> {


    private MallHttpService mService;
    private PorOrderView porOrderView;

    @Override
    protected void bindView(PorOrderView porOrderView) {
        this.porOrderView = porOrderView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
    }

    /**
     * 获取默认地址
     *
     * @param id
     */
    public void ProDefaultAddress(String id) {
        observer(new HttpObserver<DefaultAddressBean>(mContext, mService.getDefaultAddress(id)
                , new HttpCallBackImpl<DefaultAddressBean>() {
            @Override
            public void onCompleted(DefaultAddressBean defaultAddressBean) {
                if (defaultAddressBean == null) {
                    porOrderView.showError();
                    return;
                }
                porOrderView.showDefaultAddress(defaultAddressBean.getData());
            }
        }));
    }


    /**
     * 使用开团卷开团
     *
     * @param uid
     * @param pid
     * @param couponId
     */
    public void ProOpenTuan(String uid, String pid, String couponId) {
        observer(new HttpObserver<OpenTuanBean>(mContext, mService.getOpenTua(uid, pid, true, couponId)
                , new HttpCallBackImpl<OpenTuanBean>() {
            @Override
            public void onCompleted(OpenTuanBean tuanBean) {
                if (tuanBean == null) {
                    return;
                }
                if (tuanBean.getCode().equals("00") && tuanBean.getMsg().equals("SUCCESS")) {
                    porOrderView.showOpenTuan(tuanBean.getData());
                } else {
                    porOrderView.showOpenError(tuanBean.getMsg());
                }
            }
        }));
    }

}
