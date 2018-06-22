package com.module.mall.ui.moretuan;

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
import com.module.mall.adpter.ProductTuanAdapter;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by shibing on 18/6/19.
 */

public class MoreTuanActivity extends BaseActivity implements ProTuanView, AdapterView.OnItemClickListener {


    private ListView listView;
    private LinearLayout layout;
    private ProductTuanAdapter tuanAdapter;
    private ProTuanPresenter presenter;
    private String uid, pid, catagory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("更多开团");

        uid = SPUtil.getInstance(this).getString(Constant.USERID);
        pid = getIntent().getStringExtra("pid");
        presenter.productTuan(uid, pid, false, catagory);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_moretuan;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.moretuan_list);
        layout = findViewById(R.id.nadata_lay);
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new ProTuanPresenter();
        return presenter;
    }


    @Override
    public void showTuanList(List<ProductTuanBean.DataBean> productTuan) {
        if (productTuan.size() == 0) {
            listView.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
            return;
        }
        listView.setVisibility(View.VISIBLE);
        tuanAdapter = new ProductTuanAdapter(this, productTuan, "more");
        listView.setAdapter(tuanAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
