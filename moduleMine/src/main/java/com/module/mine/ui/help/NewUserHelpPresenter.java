package com.module.mine.ui.help;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.HelpBean;

/**
 * Created by shibing on 18/6/9.
 */

public class NewUserHelpPresenter extends BasePresenter<NewUserHelpView> {


    private Context mContext;
    private NewUserHelpView helpView;
    private MineHttpService mService;

    @Override
    protected void bindView(NewUserHelpView newUserHelpView) {
        this.helpView = newUserHelpView;
        this.mContext = (Context) newUserHelpView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取新手帮助列表
     */
    public void getHelpList() {
        observer(new HttpObserver<HelpBean>(mContext, mService.getProblemList(), new HttpCallBackImpl<HelpBean>() {
            @Override
            public void onCompleted(HelpBean helpBean) {

                if (helpBean == null) {
                    return;
                }
                helpView.showHelp(helpBean);
            }
        }));
    }



}
