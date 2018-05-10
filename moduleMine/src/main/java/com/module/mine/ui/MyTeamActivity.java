package com.module.mine.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.XListView;
import com.module.mine.R;
import com.module.mine.adapter.MyTeamAdapter;

/**
 * Created by shibing on 18/5/6.
 */

public class MyTeamActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ImageView imageHead, imageTelPhone;
    private TextView tvName, tvPhone;
    private XListView listView;


    private MyTeamAdapter myTeamAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("我的团队").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myteam;
    }

    @Override
    public void initView() {
        imageHead = findViewById(R.id.myteam_item_head_img);
        imageTelPhone = findViewById(R.id.myteam_telphone_img);
        tvName = findViewById(R.id.myteam_name_tv);
        tvPhone = findViewById(R.id.myteam_phone_tv);
        listView = findViewById(R.id.myteam_list);

        myTeamAdapter = new MyTeamAdapter(this);
        listView.setAdapter(myTeamAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
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
}
