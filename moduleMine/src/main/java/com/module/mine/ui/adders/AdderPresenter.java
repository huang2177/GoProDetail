package com.module.mine.ui.adders;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.AddersBean;
import com.module.mine.bean.BlankNumBean;
import com.module.mine.ui.blanknum.BlankNumView;

import java.util.Map;

/**
 * Created by shibing on 18/5/26.
 */

public class AdderPresenter extends BasePresenter<AddersView> {


    private AddersView addersView;
    private MineHttpService mService;
    private Context mContext;


    @Override
    protected void bindView(AddersView addersView) {
        this.addersView = addersView;
        mContext = (Context) addersView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取地址
     */
    public void AddersList() {
        observer(new HttpObserver<AddersBean>(mContext, mService.getAddersList()
                , new HttpCallBackImpl<AddersBean>() {
            @Override
            public void onCompleted(AddersBean addersBean) {
                if (addersBean == null) {
                    return;
                }
                addersView.showAdders(addersBean);
            }
        }));

    }

    public void getAddAdderss(Map<String, String> map) {

        observer(new HttpObserver<AddersBean>(mContext, mService.getUserAddress(map)
                , new HttpCallBackImpl<AddersBean>() {
            @Override
            public void onCompleted(AddersBean addersBean) {
                if (addersBean == null) {
                    return;
                }
                addersView.showAdders(addersBean);
            }
        }));
    }
}
