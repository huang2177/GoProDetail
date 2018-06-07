package com.module.mine.ui.tuancoupon;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.TuanCouponBean;

/**
 * Created by shibing on 18/5/27.
 */

public class OpenCoilPresenter extends BasePresenter<TuanCouponView> {


    private Context mContext;
    private MineHttpService mService;
    private TuanCouponView mTuanCouponView;


    @Override
    protected void bindView(TuanCouponView tuanCouponView) {

        this.mTuanCouponView = tuanCouponView;
        mContext = (Context) tuanCouponView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    public void getTuanCouponList(String userId) {
        observer(new HttpObserver<TuanCouponBean>(mContext
                , mService.TuanCoupon(userId)
                , new HttpCallBackImpl<TuanCouponBean>() {
            @Override
            public void onCompleted(TuanCouponBean tuanCouponBean) {

                if (tuanCouponBean == null) {
                    return;
                }
                mTuanCouponView.showTuanCouponList(tuanCouponBean);
            }
        }));
    }
}
