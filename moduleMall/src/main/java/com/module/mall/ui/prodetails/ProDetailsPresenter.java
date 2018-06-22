package com.module.mall.ui.prodetails;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.pouduct.ProductBean;
import com.module.mall.MallHttpService;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by shibing on 18/6/15.
 */

public class ProDetailsPresenter extends BasePresenter<ProDetailsView> {


    private MallHttpService mService;
    private ProDetailsView proDetailsView;

    @Override
    protected void bindView(ProDetailsView proDetailsView) {

        this.proDetailsView = proDetailsView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
    }


    /**
     * 获取产品详情
     *
     * @param id
     */
    public void ProDetails(String id) {
        observer(new HttpObserver<ProDetailsBean>(mContext, mService.getPorDetails(id)
                , new HttpCallBackImpl<ProDetailsBean>() {
            @Override
            public void onCompleted(ProDetailsBean proDetailsBean) {
                if (proDetailsBean == null) {
                    return;
                }
                proDetailsView.showDetails(proDetailsBean);
            }
        }));
    }


    /**
     * 收藏产品
     *
     * @param uid
     * @param pid
     */
    public void ProCollection(String uid, String pid) {
        observer(new HttpObserver<ProDetailsBean>(mContext, mService.ProductCollection(uid, pid)
                , new HttpCallBackImpl<ProDetailsBean>() {
            @Override
            public void onCompleted(ProDetailsBean proDetailsBean) {
                if (proDetailsBean == null) {
                    return;
                }
                proDetailsView.showCollection(proDetailsBean);
            }
        }));
    }


    /**
     * 获取 评价列表
     *
     * @param pid
     * @param uid
     */
    public void productEvaList(String pid, String uid) {

        observer(new HttpObserver<ProductEvaBean>(mContext, mService.ProductEvaList(pid, uid)
                , new HttpCallBackImpl<ProductEvaBean>() {
            @Override
            public void onCompleted(ProductEvaBean productEva) {

                if (productEva == null) {
                    proDetailsView.showProductEvaEmpty();
                    return;
                }
                proDetailsView.showProductEva(productEva.getData());
            }
        }));
    }


    /**
     * 获取拼团列表
     *
     * @param uid
     * @param pid
     */
    public void productTuan(String uid, String pid, boolean isPublic, String catagory) {
        observer(new HttpObserver<ProductTuanBean>(mContext, mService.ProductTuanList(
                uid, pid, isPublic, catagory), new HttpCallBackImpl<ProductTuanBean>() {
            @Override
            public void onCompleted(ProductTuanBean productTuan) {
                if (productTuan == null) {
                    return;
                }
                proDetailsView.showTuanList(productTuan.getData());
            }
        }));
    }


    // api/PintuanRule/{id} 根据ID获取0元购返现说明信息
    public void PintuanRule(String id) {
        observer(new HttpObserver<PintuanRuleBean>(mContext,
                mService.PintuanRule(id), new HttpCallBackImpl<PintuanRuleBean>() {
            @Override
            public void onCompleted(PintuanRuleBean pintuanRuleBean) {

                if (pintuanRuleBean == null) {
                    return;
                }
                proDetailsView.showRule(pintuanRuleBean);
            }
        }));
    }


    // api/PintuanRule/{id} 根据ID获取0元购返现说明信息
    public void ZulinRule(String id) {
        observer(new HttpObserver<PintuanRuleBean>(mContext,
                mService.ZulinRule(id), new HttpCallBackImpl<PintuanRuleBean>() {
            @Override
            public void onCompleted(PintuanRuleBean pintuanRuleBean) {

                if (pintuanRuleBean == null) {
                    return;
                }
                proDetailsView.showRule(pintuanRuleBean);
            }
        }));
    }

}
