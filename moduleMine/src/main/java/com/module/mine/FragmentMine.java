package com.module.mine;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.base.BaseFragment;
import com.module.base.listener.AParamListener;
import com.module.base.widgets.XItemDecoration;
import com.module.mine.adapter.MineAdapter;
import com.module.mine.ui.BalanceActivity;
import com.module.mine.ui.InvitationCodeActivity;
import com.module.mine.ui.SystemMessActivity;
import com.module.mine.ui.UserInfoActivity;

/**
 * @author Huangshuang  2018/5/4 0004
 */

public class FragmentMine extends BaseFragment implements AdapterView.OnItemClickListener
        , AParamListener {

    private ImageView head;
    private FrameLayout messFra;
    private RecyclerView recyclerView;
    private LinearLayout inCodeLay, banLanceLay, cardLay;
    private TextView phoneTv, mesTv, banlanceTv, inCodeTv;

    private MineAdapter mineAdapter;


    public static FragmentMine newInstance(String msg) {
        return new FragmentMine();
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        head = f(R.id.mine_hede_img);
        phoneTv = f(R.id.mine_phone_tv);
        mesTv = f(R.id.mine_mes_tv);
        banlanceTv = f(R.id.mine_banlance_tv);
        inCodeTv = f(R.id.mine_incode_tv);
        messFra = f(R.id.mine_mes_fra);
        inCodeLay = f(R.id.mine_incode_lay);
        banLanceLay = f(R.id.mine_banlance_lay);
        cardLay = f(R.id.mine_card_lay);
        recyclerView = f(R.id.mine_recycler);

        initRecycle();
    }

    private void initRecycle() {
        GridLayoutManager manager = new GridLayoutManager(activity, 3);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(new XItemDecoration(activity));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(manager);

        mineAdapter = new MineAdapter(activity, this);
        recyclerView.setAdapter(mineAdapter);
    }

    @Override
    public void setListener() {
        super.setListener();
        head.setOnClickListener(this);
        messFra.setOnClickListener(this);
        inCodeLay.setOnClickListener(this);
        banLanceLay.setOnClickListener(this);
        cardLay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //头像
        if (i == R.id.mine_hede_img) {
            startActivity(new Intent(activity, UserInfoActivity.class));
        }
        //消息
        else if (i == R.id.mine_mes_fra) {
            startActivity(new Intent(activity, SystemMessActivity.class));
        }
        //邀请码
        else if (i == R.id.mine_incode_lay) {
            startActivity(new Intent(activity, InvitationCodeActivity.class));
        }
        //余额
        else if (i == R.id.mine_banlance_lay) {
            startActivity(new Intent(activity, BalanceActivity.class));
        }
        //银行卡
        else if (i == R.id.mine_card_lay) {

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;

        }
    }


    @Override
    public void callBack(Object o) {
        //gridView.setBackgroundColor(ContextCompat.getColor(activity,R.color.colorWhite));
    }
}
