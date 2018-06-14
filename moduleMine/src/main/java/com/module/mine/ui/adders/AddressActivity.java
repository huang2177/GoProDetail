package com.module.mine.ui.adders;

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
import com.module.mine.adapter.AddressListAdapter;
import com.module.mine.bean.AddersBean;

import java.util.List;

/**
 * Created by shibing on 18/5/6.
 */

@Route(path = Constant.ADDERS)
public class AddressActivity extends BaseActivity
        implements AdapterView.OnItemClickListener
        , AddersView {

    private ListView listView;
    private LinearLayout layout;

    private AddressListAdapter addressListAdapter;
    private AdderPresenter presenter;
    private List<AddersBean.DataBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("收货地址").rightText("管理");
        presenter.AddersList();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_adderss;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.address_list);
        layout = findViewById(R.id.nadata_lay);
    }





    @Override
    public void onRightClick() {
        super.onRightClick();
        startActivity(new Intent(this, AdmAdderssActivity.class));
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new AdderPresenter();
        return presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void showAdders(AddersBean addersBean) {
        list = addersBean.getData();
        if (list.size() == 0) {
            layout.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            return;
        }
        listView.setVisibility(View.VISIBLE);
        addressListAdapter = new AddressListAdapter(this,list);
        listView.setAdapter(addressListAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void OnAddersErr(String err) {

    }
}
