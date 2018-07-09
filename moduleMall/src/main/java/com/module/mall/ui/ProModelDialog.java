package com.module.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.widgets.dialog.XBottomDialog;
import com.module.mall.R;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.ui.confirmorder.OrderConfirmActivity;

/**
 * @author Huangshuang  2018/5/10 0010
 */

public class ProModelDialog extends XBottomDialog implements AdapterView.OnItemClickListener {
    private ImageView ivPro;
    private Button btnConfirm;
    private RecyclerView mListView;
    private TextView tvName, tvPrice, tvInventory, tvColor;
    private String from;
    private ProDetailsBean.DataBean dataBean;

    public ProModelDialog(@NonNull Activity activity, ProDetailsBean.DataBean dataBean, String from) {
        super(activity);
        this.from = from;
        this.dataBean = dataBean;
        mListView.setLayoutManager(new LinearLayoutManager(activity));
        mListView.setAdapter(new ModeDialogAdapter(activity, dataBean.getNorms()));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_pro_model_layout;
    }

    @Override
    protected void initView() {
        ivPro = findViewById(R.id.model_img);
        tvName = findViewById(R.id.model_name);
        mListView = findViewById(R.id.dialog_lv);
        tvPrice = findViewById(R.id.model_price);
        tvColor = findViewById(R.id.model_color);
        btnConfirm = findViewById(R.id.model_btn);
        tvInventory = findViewById(R.id.model_inventory);
    }

    @Override
    protected void setListener() {
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(activity, OrderConfirmActivity.class);
        intent.putExtra(Constant.PORDUCTID, dataBean.getId() + "");
        intent.putExtra(Constant.PORDUCT_IMAGR, dataBean.getImgurl());
        intent.putExtra(Constant.PORDUCT_TITLE, dataBean.getTitle());
        intent.putExtra(Constant.PORDUCT_PIC, dataBean.getAmount());
        intent.putExtra(Constant.PORDUCT_TUAN_PIC, dataBean.getTuanAmount());
        intent.putExtra(Constant.PORDUCT_CLORO, "");
        intent.putExtra(Constant.PORDUCT_TYPE, dataBean.getType() + "");
        switch (from) {
            case "Wholeprice":
                intent.putExtra(Constant.PORDUCT_TUAN_TYPE, "Wholeprice");     //土豪购买 既不是开团 也不是参团
                activity.startActivity(intent);
                break;
            case "openTuan":
                intent.putExtra(Constant.PORDUCT_TUAN_TYPE, "openTuan");        //去开团
                activity.startActivity(intent);
                break;
            case "lease":
                intent.putExtra(Constant.PORDUCT_TUAN_TYPE, "porLease");        //产品租赁
                activity.startActivity(intent);
                break;
        }
        dismiss();
    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        adapterArray.get(parent.getId()).changeColor(position);
//        tvColor.setText(strColor + "  " + strCapacity + "  " + strVersion);
    }

}
