package com.module.user.ui.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.http.HttpManager;
import com.module.base.utils.SPUtil;
import com.module.base.utils.TextUtil;
import com.module.base.utils.ToastUtil;
import com.module.user.UserHttpService;
import com.module.user.bean.RegisterBean;
import com.module.user.ui.register.RegisterView;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 黄双 on 2018/5/19.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginView loginView;
    private UserHttpService mService;
    private Context context;
    private static final String TAG = "RegisterPresenter";

    @Override
    public void bindView(LoginView loginView) {
        this.loginView = loginView;
        context = (Context) loginView;
        mService = HttpManager.getInstance().getService(UserHttpService.class);
    }


    public void login(String mobile, String password) {
        if (isRecycle()) {
            return;
        }
        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.show(context, "手机号码不能为空！");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            ToastUtil.show(context, "密码不能为空！");
            return;
        }

        mSubscription.add(mService.login(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {

                    public RegisterBean registerBean;

                    @Override
                    public void onCompleted() {
                        if (registerBean == null) {
                            return;
                        }
                        loginView.onLoginSuc(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.onLoginErr(e.toString());
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        this.registerBean = registerBean;
                    }
                }));

    }
}
