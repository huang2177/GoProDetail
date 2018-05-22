package com.module.mine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.module.base.BasePresenter;
import com.module.base.http.HttpManager;
import com.module.mine.bean.UserInfoBean;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shibing on 18/5/21.
 */

public class MinePresenter extends BasePresenter<MineView> {
    private static final String TAG = "FingPswPresenter";
    private MineView mineView;
    private MineHttpService mService;


    @Override
    protected void bindView(MineView mineView) {
        this.mineView = mineView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取用户id
     *
     * @param id
     */
    public void getUserInfo(String id) {
        if (isRecycle()) {
            return;
        }
        mSubscription.add(mService.getUserInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoBean>() {
                    public UserInfoBean userinfo;

                    @Override
                    public void onCompleted() {
                        try {
                            if (userinfo == null || !TextUtils.equals(userinfo.getCode(), "00")) {
                                return;
                            }
                            mineView.showUserInfo(userinfo);
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onNext: 11" + e.toString());
                    }

                    @Override
                    public void onNext(UserInfoBean userInfo) {
                        this.userinfo = userInfo;
                    }
                }));
    }

}
