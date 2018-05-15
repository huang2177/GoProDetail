package com.module.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.listener.OnItemClickListener;
import com.module.mine.adapter.NoviceAdapter;

/**
 * Created by shibing on 18/5/16.
 */

public class NoviceActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    private ListView listView;

    private NoviceAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("新手帮助");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novice;
    }

    @Override
    public void initView() {
        listView = findViewById(R.id.novice_list);
        adapter = new NoviceAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    /**
     * list  监听
     *
     * @param position
     */
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this,NoviceDetalisActivity.class));
    }
}
