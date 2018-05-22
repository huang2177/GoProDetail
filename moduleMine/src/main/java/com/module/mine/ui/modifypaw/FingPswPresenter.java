package com.module.mine.ui.modifypaw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.module.base.BasePresenter;
import com.module.base.http.HttpManager;
import com.module.base.utils.TextUtil;
import com.module.base.utils.ToastUtil;
import com.module.mine.MineHttpService;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shibing on 18/5/21.
 */

public class FingPswPresenter extends BasePresenter<FindView> {
    private static final String TAG = "FingPswPresenter";
    private FindView findView;
    private MineHttpService mService;
    private Context context;


    @Override
    protected void bindView(FindView findView) {
        this.findView = findView;
        context = (Context) findView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 发送验证码
     *
     * @param mobile
     */
    public void sendCode(String mobile) {

        if (isRecycle()) {
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
                                findView.onSendCodeSuc("发送成功！");
                            } else {
                                findView.onSendCodeErr(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {

                        }
                    }
                }));
    }


    /**
     * 修改密码
     */
    public void ModidyPaw(String phone, String smscode, String passward) {
        if (isRecycle()) {
            return;
        }

        mSubscription.add(mService.ModifyPsw(phone, smscode, passward)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            Log.e(TAG, "onCompleted: " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }));

    }
}
