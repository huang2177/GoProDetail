package com.module.home.ui.business;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.home.HomeHttpService;
import com.module.home.bean.BusinBean;

/**
 * Created by shibing on 18/6/9.
 */

public class BusinPresenter extends BasePresenter<BusinView> {


    private Context mContext;
    private BusinView businView;
    private HomeHttpService mService;

    @Override
    protected void bindView(BusinView businView) {
        this.businView = businView;
        this.mContext = (Context) businView;
        mService = HttpManager.getInstance().getService(HomeHttpService.class);
    }


    /**
     * 获取新手帮助列表
     */
    public void getShopList() {
        observer(new HttpObserver<BusinBean>(mContext, mService.ShopList(), new HttpCallBackImpl<BusinBean>() {
            @Override
            public void onCompleted(BusinBean businBean) {

                if (businBean == null) {
                    return;
                }
                businView.showBusin(businBean);
            }
        }));
    }


}
