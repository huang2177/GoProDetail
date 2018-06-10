package com.module.mine.ui.compiaint;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.ComPlaintBean;

/**
 * Created by shibing on 18/6/9.
 */

public class ComPlaintPresenter extends BasePresenter<ComPlaintView> {


    private Context mContext;
    private ComPlaintView comPlaintView;
    private MineHttpService mService;

    @Override
    protected void bindView(ComPlaintView comPlaintView) {
        this.comPlaintView = comPlaintView;
        mContext = (Context) comPlaintView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }

    public void getSuggest(String uid, String name, String moblie, final String content) {
        observer(new HttpObserver<ComPlaintBean>(mContext, mService.PutSuggest(uid, name, moblie, content),
                new HttpCallBackImpl<ComPlaintBean>() {
                    @Override
                    public void onCompleted(ComPlaintBean comPlaintBean) {

                        if (comPlaintBean == null) {
                            return;
                        }
                        comPlaintView.OnSuPlanSuc(comPlaintBean);
                    }
                }));
    }
}
