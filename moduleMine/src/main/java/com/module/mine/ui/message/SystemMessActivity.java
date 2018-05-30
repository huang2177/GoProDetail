package com.module.mine.ui.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;
import com.module.mine.adapter.MessAgeAdapter;
import com.module.mine.bean.MessAgeBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class SystemMessActivity extends BaseActivity
        implements AdapterView.OnItemClickListener,
        MessAgeView {


    private ListView listView;
    private LinearLayout layNodata;

    private MessAgeAdapter messAgeAdapter;
    private MessAgePresenter messAgePresenter;
    private SPUtil spUtil;
    private List<MessAgeBean.DataBean> beanList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("系统消息").rightImageRes(0);
        messAgePresenter.getSystemMessAge(spUtil.getString(Constant.USERID));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        spUtil = SPUtil.getInstance(this);

        layNodata = findViewById(R.id.nadata_lay);
        listView = findViewById(R.id.message_list);
        listView.setOnItemClickListener(this);


    }

    @Override
    public BasePresenter createPresenter() {
        messAgePresenter = new MessAgePresenter();
        return messAgePresenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this, "监听事件");
    }


    /**
     * 数据处理
     *
     * @param messAgeBean
     */
    @Override
    public void showMessAge(MessAgeBean messAgeBean) {
        beanList = messAgeBean.getData();

        if (beanList.size() == 0) {
            listView.setVisibility(View.GONE);
            layNodata.setVisibility(View.VISIBLE);
            return;
        }
        listView.setVisibility(View.VISIBLE);
        messAgeAdapter = new MessAgeAdapter(this, beanList);
        listView.setAdapter(messAgeAdapter);

    }

    @Override
    public void onFindErr(String error) {

    }
}
