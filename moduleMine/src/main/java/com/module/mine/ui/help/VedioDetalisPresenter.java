package com.module.mine.ui.help;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.HelpBean;

/**
 * Created by shibing on 18/6/9.
 */

public class VedioDetalisPresenter extends BasePresenter<VedioDetalisView> {


    private Context mContext;
    private VedioDetalisView vedioDetalisView;
    private MineHttpService mService;


    @Override
    protected void bindView(VedioDetalisView vedioDetalisView) {
        this.vedioDetalisView = vedioDetalisView;
        this.mContext = (Context) vedioDetalisView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }
    /**
     * 获取新手帮助详情
     */
    public void getHelpDetalis(String helpId) {
        observer(new HttpObserver<HelpBean>(mContext, mService.getProblemDetalis(helpId), new HttpCallBackImpl<HelpBean>() {
            @Override
            public void onCompleted(HelpBean helpBean) {
                if (helpBean == null) {
                    return;
                }
                vedioDetalisView.showHelpDetalis(helpBean);
            }
        }));
    }


}
