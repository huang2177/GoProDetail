package com.module.user.ui.register;

import android.support.v7.widget.RecyclerView;

import com.module.base.BasePresenter;
import com.module.base.http.HttpManager;
import com.module.user.UserHttpService;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 黄双 on 2018/5/19.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    private RegisterView mRegisterView;
    private UserHttpService mService;

    @Override
    public void attachView(RegisterView registerView) {
        this.mRegisterView = registerView;
        mService = HttpManager.getInstance().getService(UserHttpService.class);
    }

    /**
     * 注册
     */
    public void register() {
        mSubscription.add(mService.register("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onCompleted() {
                        mRegisterView.onSuccess("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRegisterView.onError(e.toString());
                    }

                    @Override
                    public void onNext(Object o) {

                    }
                }));

    }
}
