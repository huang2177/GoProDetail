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
    public boolean sendCode(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.show(mContext, "手机号码不能为空！");
            return false;
        }

        if (!TextUtil.isChinaPhoneLegal(mobile)) {
            ToastUtil.show(mContext, "请输入正确手机号码！");
            return false;
        }

        return observer(new HttpObserver(mContext
                , mService.sendCode(mobile)
                , new HttpCallBackImpl<ResponseBody>() {
            @Override
            public void onCompleted(ResponseBody responseBody) {
                try {
                    if (isRecycle()) {
                        return;
                    }
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

        observer(new HttpObserver(mContext
                , mService.register(mobile, password, smsCode, inviteCode)
                , new HttpCallBackImpl<RegisterBean>() {
            @Override
            public void onCompleted(RegisterBean registerBean) {
                if (registerBean == null || isRecycle()) {
                    return;
                }
                mRegisterView.onRegisterSuc(registerBean);
            }
        }));
    }
}
