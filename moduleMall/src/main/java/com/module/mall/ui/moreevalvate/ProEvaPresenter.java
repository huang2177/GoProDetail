package com.module.mall.ui.moreevalvate;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mall.MallHttpService;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.moretuan.ProTuanView;

import java.util.List;

/**
 * Created by shibing on 18/6/15.
 */

public class ProEvaPresenter extends BasePresenter<ProEvaView> {


    private MallHttpService mService;
    private ProEvaView proEvaView;

    @Override
    protected void bindView(ProEvaView proEvaView) {

        this.proEvaView = proEvaView;
        mService = HttpManager.getInstance().getService(MallHttpService.class);
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
                    return;
                }
                proEvaView.showProductEva(productEva.getData());
            }
        }));
    }

}
