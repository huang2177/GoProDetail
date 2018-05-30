package com.module.mine.ui.team;

import android.content.Context;
import android.text.TextUtils;

import com.module.base.BasePresenter;
import com.module.base.http.HttpCallBackImpl;
import com.module.base.http.HttpManager;
import com.module.base.http.HttpObserver;
import com.module.mine.MineHttpService;
import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.TeamBean;
import com.module.mine.ui.blanknum.BlankNumView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shibing on 18/5/26.
 */

public class TeamPresenter extends BasePresenter<TeamView> {


    private TeamView teamView;
    private MineHttpService mService;
    private Context mContext;

    @Override
    protected void bindView(TeamView teamView) {
        this.teamView = teamView;
        mContext = (Context) teamView;
        mService = HttpManager.getInstance().getService(MineHttpService.class);
    }


    /**
     * 获取系统消息列表
     */


    public void getTeamList(String userId) {
        observer(new HttpObserver(mContext,
                mService.MyTeam(userId)
                , new HttpCallBackImpl<TeamBean>() {
            @Override
            public void onCompleted(TeamBean teamBean) {
                if (teamBean == null) {
                    return;
                }
                teamView.showTeam(teamBean);
            }
        }));
    }
}
