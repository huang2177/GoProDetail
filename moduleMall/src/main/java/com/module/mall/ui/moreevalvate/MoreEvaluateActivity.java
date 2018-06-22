package com.module.mall.ui.moreevalvate;

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
import com.module.mall.R;
import com.module.mall.adpter.MoreEvaluateAdapter;
import com.module.mall.bean.ProductEvaBean;

import java.util.List;


/**
 * Created by shibing on 18/5/28.
 */

public class MoreEvaluateActivity extends BaseActivity implements ProEvaView, AdapterView.OnItemClickListener {


    private LinearLayout layout;
    private ListView listView;
    private MoreEvaluateAdapter adapter;

    private ProEvaPresenter presenter;
    private String uid, pid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("全部评价");
        pid = getIntent().getStringExtra("pid");
        uid = SPUtil.getInstance(this).getString(Constant.USERID);
        presenter.productEvaList(pid, uid);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_moreeval;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.list_moreeval);
        layout = findViewById(R.id.nadata_lay);

    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new ProEvaPresenter();
        return presenter;
    }


    @Override
    public void showProductEva(List<ProductEvaBean.DataBean> dataBeans) {
        if (dataBeans.size() == 0) {
            layout.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            return;
        }
        listView.setVisibility(View.VISIBLE);
        adapter = new MoreEvaluateAdapter(this, dataBeans, "moreEva");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
