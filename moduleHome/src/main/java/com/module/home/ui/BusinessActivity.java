package com.module.home.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.XItemDecoration;
import com.module.base.widgets.dialog.CommonDialog;
import com.module.home.R;
import com.module.home.adpter.BusinessAdapter;
import com.module.home.bean.BusinBean;
import com.module.home.ui.business.BusinPresenter;
import com.module.home.ui.business.BusinView;

import java.util.List;

/**
 * Created by shibing on 18/6/10.
 */

@Route(path = Constant.LOCATION)
public class BusinessActivity extends BaseActivity implements BusinView, OnItemClickListener, CommonDialog.DialogClickListener {
    private TextView tvCity;
    private LinearLayout layQiehuan;
    private RecyclerView recyclerView;
    private LinearLayout layout;
    private LinearLayoutManager manager;
    private BusinessAdapter adapter;
    private BusinPresenter presenter;
    private List<BusinBean.DataBean> list;
    private String tel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("营业厅");
        presenter.getShopList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_business;
    }

    @Override
    public void initView() {
        tvCity = findViewById(R.id.busin_city_tv);
        layQiehuan = findViewById(R.id.busin_qiehun_lay);
        recyclerView = findViewById(R.id.busin_recyler);
        layout = findViewById(R.id.nadata_lay);

        initRecy();
    }


    public BusinessActivity background(int resColor) {
        int color = ContextCompat.getColor(this, resColor);
        titleBarContainer.setBackgroundColor(color);
        return this;
    }


    private void initRecy() {
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new XItemDecoration(this));
    }


    @Override
    public BasePresenter createPresenter() {
        presenter = new BusinPresenter();
        return presenter;
    }

    @Override
    public void showBusin(BusinBean businBean) {
        list = businBean.getData();
        if (list.size() == 0) {
            layout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            return;
        }
        recyclerView.setVisibility(View.VISIBLE);
        adapter = new BusinessAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.addOnItemClickListener(this);
        adapter.TelOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, int type) {
                tel = list.get(position).getTel();
                showDialog();
            }
        });
    }


    private void showDialog() {
        CommonDialog dialog = new CommonDialog.Builder()
                .context(this)
                .listener(this)
                .title("拼跌")
                .message("确定要拨打" + tel + "吗？")
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();
    }

    @Override
    public void onBusinErr(String err) {

    }


    @Override
    public void onItemClick(int position, int type) {
        ToastUtil.show(this, "营业厅详情");
    }


    public void dialogClick(int flag, int type) {
        if (flag == CommonDialog.CONFIRM) {
            // getTel();
        }
    }


    // TODO: 18/6/11 需要添加动态权限
    @SuppressLint("MissingPermission")
    private void getTel() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + tel);
        intent.setData(data);
        startActivity(intent);
    }
}
