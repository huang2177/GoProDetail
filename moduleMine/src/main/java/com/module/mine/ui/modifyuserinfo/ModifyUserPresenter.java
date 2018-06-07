package com.module.mine.ui.modifyuserinfo;

import android.content.Context;
import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.ui.modifypaw.FindView;

import org.json.JSONObject;

import okhttp3.ResponseBody;

/**
 * Created by shibing on 18/5/21.
 */

public class ModifyUserPresenter extends BasePresenter<ModifyUserView> {
    private static final String TAG = "FingPswPresenter";
    private ModifyUserView modifyUserView;
    private MineHttpService mService;
    private Context mContext;


    @Override
    protected void bindView(ModifyUserView modifyUserView) {
        this.modifyUserView = modifyUserView;
        mContext = (Context) modifyUserView;
        mService=HttpManager.getInstance().getService(MineHttpService.class);
    }




}
