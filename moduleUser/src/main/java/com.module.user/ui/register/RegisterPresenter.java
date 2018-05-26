package com.module.user.ui.register;

import android.content.Context;
import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.base.utils.TextUtil;
import com.module.base.utils.ToastUtil;
import com.module.user.UserHttpService;
import com.module.user.bean.RegisterBean;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 黄双 on 2018/5/19.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {


    private RegisterView mRegisterView;
    private UserHttpService mService;

    private Context mContext;
    private static final String TAG = "RegisterPresenter";

    @Override
    public void bindView(RegisterView registerView) {
        mContext = (Context) registerView;
        this.mRegisterView = registerView;
        mService = HttpManager.getInstance().getService(UserHttpService.class);
    }

    /**
     * 发送验证码
     *
     * @param mobile
     */
    public void sendCode(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.show(mContext, "手机号码不能为空！");
            return;
        }

        if (!TextUtil.isChinaPhoneLegal(mobile)) {
            ToastUtil.show(mContext, "请输入正确手机号码！");
            return;
        }

        if (isRecycle()) {
            return;
        }
//        mSubscription.add(mService.sendCode(mobile)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResponseBody>() {
//                    @Override
//                    public void onCompleted() {
//                        //mRegisterView.onSuccess("1111");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //mRegisterView.onSendCodeErr(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody o) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(o.string());
//                            if (TextUtils.equals(jsonObject.getString("code"), "00")) {
//                                mRegisterView.onSendCodeSuc("发送成功！");
//                            } else {
//                                mRegisterView.onSendCodeErr(jsonObject.getString("msg"));
//                            }
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }));

        observer(new HttpObserver(mContext
                , mService.sendCode(mobile)
                , new HttpCallBackImpl<ResponseBody>() {
            @Override
            public void onCompleted(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string());
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
        if (isRecycle()) {
            return;
        }
        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.show(mContext, "手机号码不能为空！");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            ToastUtil.show(mContext, "密码不能为空！");
            return;
        }
        if (TextUtils.isEmpty(smsCode)) {
            ToastUtil.show(mContext, "验证码不能为空！");
            return;
        }
//        mSubscription.add(mService.register(mobile, password, smsCode, inviteCode)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<RegisterBean>() {
//
//                    public RegisterBean registerBean;
//
//                    @Override
//                    public void onCompleted() {
//                        if (registerBean == null) {
//                            return;
//                        }
//                        mRegisterView.onRegisterSuc(registerBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mRegisterView.onRegisterErr(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(RegisterBean registerBean) {
//                        this.registerBean = registerBean;
//                    }
//                }));

        observer(new HttpObserver(mContext
                , mService.register(mobile, password, smsCode, inviteCode)
                , new HttpCallBackImpl<RegisterBean>() {
            @Override
            public void onCompleted(RegisterBean registerBean) {
                if (registerBean == null) {
                    return;
                }
                mRegisterView.onRegisterSuc(registerBean);
            }
        }));
    }
}
