package com.module.mine.ui.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.RoundImageView;
import com.module.base.widgets.XListView;
import com.module.mine.R;
import com.module.mine.adapter.MyTeamAdapter;
import com.module.mine.bean.TeamBean;

import java.util.List;

import static com.module.mine.R.drawable.ic_mine_head;

/**
 * Created by shibing on 18/5/6.
 */

public class MyTeamActivity extends BaseActivity implements
        AdapterView.OnItemClickListener, TeamView {

    private RoundImageView imageHead;
    private ImageView imageTelPhone;
    private TextView tvName, tvPhone;
    private XListView listView;
    private LinearLayout layTeam, layNodata;
    private TeamPresenter teamPresenter;

    private MyTeamAdapter myTeamAdapter;
    private SPUtil spUtil;
    private List<TeamBean.DataBean.TeamsBean> list;
    private TeamBean.DataBean.InviteBean inviteBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("我的团队").rightImageRes(0);
        teamPresenter.getTeamList(spUtil.getString(Constant.USERID));

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myteam;
    }

    @Override
    public void initView() {


        imageHead = findViewById(R.id.myteam_head_img);
        imageTelPhone = findViewById(R.id.myteam_telphone_img);
        tvName = findViewById(R.id.myteam_name_tv);
        tvPhone = findViewById(R.id.myteam_phone_tv);
        listView = findViewById(R.id.myteam_list);
        layTeam = findViewById(R.id.myteam_layout);
        layNodata = findViewById(R.id.nadata_lay);


        listView.setOnItemClickListener(this);
        spUtil = SPUtil.getInstance(this);


        //设置圆形
        imageHead.setShapeType(1);
    }

    @Override
    public BasePresenter createPresenter() {
        teamPresenter = new TeamPresenter();
        return teamPresenter;
    }


    @Override
    public void setListener() {
        super.setListener();
        imageTelPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ToastUtil.show(this, "打电话");
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void showTeam(TeamBean teamBean) {

        inviteBean = teamBean.getData().getInvite();
        list = teamBean.getData().getTeams();

        //邀请人信息
        //GlideManager.loadImage(this, R.drawable.ic_mine_head, imageHead);
        //tvName.setText(inviteBean.getNickname());
        // tvPhone.setText(inviteBean.getMobile());


        if (list.size() == 0) {
            layTeam.setVisibility(View.GONE);
            layNodata.setVisibility(View.VISIBLE);
            return;
        }
        layTeam.setVisibility(View.VISIBLE);
        //团队列表
        myTeamAdapter = new MyTeamAdapter(this, list);
        listView.setAdapter(myTeamAdapter);

    }

    @Override
    public void onFindErr(String error) {

    }
}
