package com.module.user.ui.register;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.module.base.BasePresenter;
import com.module.base.http.HttpManager;
import com.module.base.utils.Logger;
import com.module.base.utils.ToastUtil;
import com.module.user.UserHttpService;
import com.module.user.bean.RegisterBean;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
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

    private Context context;

    private static final String TAG = "RegisterPresenter";

    @Override
    public void attachView(RegisterView registerView) {
        this.mRegisterView = registerView;
        context = (Context) registerView;
        mService = HttpManager.getInstance().getService(UserHttpService.class);
    }

    /**
     * 发送验证码
     *
     * @param mobile
     */
    public void sendCode(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.show(context, "手机号码不能为空！");
            return;
        }
        mSubscription.add(mService.sendCode(mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        //mRegisterView.onSuccess("1111");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //mRegisterView.onSendCodeErr(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody o) {
                        try {
                            JSONObject jsonObject = new JSONObject(o.string());
                            if (TextUtils.equals(jsonObject.getString("code"), "00")) {
                                mRegisterView.onSendCodeSuc("发送成功！");
                            } else {
                                mRegisterView.onSendCodeErr(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {

                        }
                    }
                }));
    }


    /**
     * 注册
     */
    public void register(String mobile, String password, String smsCode, String inviteCode) {
        mSubscription.add(mService.register(mobile, password, smsCode, inviteCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {

                    public RegisterBean registerBean;

                    @Override
                    public void onCompleted() {
                        if (registerBean == null) {
                            return;
                        }
                        mRegisterView.onRegisterSuc(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRegisterView.onRegisterErr(e.toString());
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        this.registerBean = registerBean;
                    }
                }));

    }
}
