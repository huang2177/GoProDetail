package com.module.mine.ui.blanknum;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.BlankNumBean;

/**
 * Created by shibing on 18/5/26.
 */

public class BlankNumPresenter extends BasePresenter<BlankNumView> {


    private BlankNumView blankNumView;
    private MineHttpService mService;
    private Context mContext;


    @Override
    protected void bindView(BlankNumView blankNumView) {
        this.blankNumView = blankNumView;
        mContext = (Context) blankNumView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取系统消息列表
     */


    public void getBlankList(String userId) {
       /* if (isRecycle()) {
            return;
        }
        mSubscription.add(mService.UserFeeRecord(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BlankNumBean>() {
                    public BlankNumBean blankNumBean;

                    @Override
                    public void onCompleted() {
                        try {
                            if (blankNumBean == null || !TextUtils.equals(blankNumBean.getCode(), "00")) {
                                return;
                            }
                            blankNumView.showBlankNum(blankNumBean);
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BlankNumBean blankNumBean) {

                        this.blankNumBean = blankNumBean;

                    }
                }));*/

        observer(new HttpObserver(mContext, mService.UserFeeRecord(userId)
                , new HttpCallBackImpl<BlankNumBean>() {
            @Override
            public void onCompleted(BlankNumBean blankNumBean) {

                if (blankNumBean==null){
                    return;
                }
                blankNumView.showBlankNum(blankNumBean);
            }
        }));
    }
}
