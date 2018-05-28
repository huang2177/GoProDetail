package com.module.mine.ui.modifypaw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
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
    private FindView mFindView;
    private MineHttpService mService;
    private Context mContext;


    @Override
    protected void bindView(FindView findView) {
        this.mFindView = findView;
        mContext = (Context) findView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 发送验证码
     *
     * @param mobile
     */
    public void sendCode(String mobile) {

        observer(new HttpObserver(mContext
                , mService.sendCode(mobile)
                , new HttpCallBackImpl<ResponseBody>() {
            @Override
            public void onCompleted(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string());
                    if (TextUtils.equals(jsonObject.getString("code"), "00")) {
                        mFindView.onSendCodeSuc("发送成功！");
                    } else {
                        mFindView.onSendCodeErr(jsonObject.getString("msg"));
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
        observer(new HttpObserver(mContext
                , mService.ModifyPsw(phone, smscode, passward)
                , new HttpCallBackImpl<ResponseBody>() {
            @Override
            public void onCompleted(ResponseBody responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(responseBody.string());
                    if (TextUtils.equals(jsonObject.getString("code"), "00")) {
                        mFindView.onSendCodeSuc("修改成功！");
                    } else {
                        mFindView.onSendCodeErr(jsonObject.getString("msg"));
                    }
                } catch (Exception e) {

                }

            }
        }));
    }
}
