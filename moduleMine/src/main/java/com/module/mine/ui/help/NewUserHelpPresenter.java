package com.module.mine.ui.help;

import android.content.Context;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetalisBean;

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


    /**
     * 获取新手帮助详情
     */
    public void getHelpDetalis(String helpId) {
        observer(new HttpObserver<HelpDetalisBean>(mContext, mService.getProblemDetalis(helpId), new HttpCallBackImpl<HelpDetalisBean>() {
            @Override
            public void onCompleted(HelpDetalisBean detalisBean) {
                if (detalisBean == null) {
                    return;
                }
                helpView.showHelpDetalis(detalisBean);
            }
        }));
    }


}
