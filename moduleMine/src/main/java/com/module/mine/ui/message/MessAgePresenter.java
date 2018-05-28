package com.module.mine.ui.message;

import android.content.Context;
import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.utils.SPUtil;
import com.module.mine.MineHttpService;
import com.module.mine.bean.MessAgeBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shibing on 18/5/26.
 */

public class MessAgePresenter extends BasePresenter<MessAgeView> {


    private MessAgeView messAgeView;
    private MineHttpService mService;
    private Context mContext;


    @Override
    protected void bindView(MessAgeView messAgeView) {
        this.messAgeView = messAgeView;
        mContext = (Context) messAgeView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取系统消息列表
     */


    public void getSystemMessAge(String userId) {
        observer(new HttpObserver(mContext
                , mService.UserMessage(userId)
                , new HttpCallBackImpl<MessAgeBean>() {
            @Override
            public void onCompleted(MessAgeBean messAgeBean) {

                if (messAgeBean == null) {
                    return;
                }
                messAgeView.showMessAge(messAgeBean);
            }
        }));
    }
}
