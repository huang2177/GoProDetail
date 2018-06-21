package com.module.mine.ui.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.mine.R;
import com.module.mine.adapter.NoviceAdapter;
import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetailBean;

import java.util.List;

/**
 * 新手帮助
 * Created by shibing on 18/5/16.
 */

@Route(path = Constant.NEWHELP)
public class NewUserHelpActivity extends BaseActivity implements AdapterView.OnItemClickListener
        , NewUserHelpView {

    private ListView listView;
    private LinearLayout layout;
    private NoviceAdapter adapter;
    private List<HelpBean.DataBean> list;
    private NewUserHelpPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("新手帮助");
        presenter.getHelpList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novice;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.novice_list);
        layout = findViewById(R.id.nadata_lay);
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new NewUserHelpPresenter();
        return presenter;
    }


    /**
     * list  监听
     *
     * @param position
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, VedioDetalisActivity.class);
        intent.putExtra("helpId", list.get(position).getId());
        startActivity(intent);
    }


    //帮助列表
    @Override
    public void showHelp(HelpBean helpBean) {
        list = helpBean.getData();
        if (list.size() == 0) {
            listView.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
            return;
        }

        listView.setVisibility(View.VISIBLE);
        adapter = new NoviceAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void showHelpDetail(HelpDetailBean.DataBean helpBean) {

    }


}
