package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.Logger;
import com.module.base.widgets.XGridView;
import com.module.base.widgets.dialog.CommonDialog;
import com.module.base.widgets.dialog.ShareDialog;
import com.module.mine.R;
import com.module.mine.adapter.OrderPopreAdpter;
import com.module.mine.ui.adders.AddressActivity;

/**
 * Created by shibing on 18/5/16.
 */


@Route(path = Constant.PATH_ORDERDETALIS)
public class OrderDetalisActivity extends BaseActivity implements CommonDialog.DialogClickListener {


    private LinearLayout layAdder;
    //物流
    private TextView tvShzt, tvYqhy, tvWuName, tvWuPhone, tvWuAdder, tvWuType, tvHy, tvLeader;   //
    // 公开图片    团长图片
    private ImageView imageGk, imageTz;
    //邀请好友gridview
    private XGridView gridView;
    //邀请好友开团
    private Button button;
    //商品图片
    private ImageView imagePro;
    //商品名称  商品价格  实际价格  手机大小   确认收货
    private TextView tvProName, tvProPicer, tvProYpicer, tvProinventory, tvProTrue;

    //实际支付   申请售后
    private TextView tvProPay, tvProsale;

    //  订单编号   创建时间  实际支付  订单类型  开团卷  过期时间
    private TextView tvNumber, tvTime, tvWordPay, tvOrderType, tvKtj, tvGqTime;

    private OrderPopreAdpter adpter;
    private String from;
    private ShareDialog shareDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 18/5/16  需要添加一张图片
        title("订单详情").rightText("已公开");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_orderdetalis;
    }

    @Override
    public void initView() {
        tvShzt = findViewById(R.id.order_shzd_tv);
        tvYqhy = findViewById(R.id.order_hy_tv);
        imageGk = findViewById(R.id.order_gk_image);

        tvWuName = findViewById(R.id.order_wl_name);
        tvWuPhone = findViewById(R.id.order_wl_phone);
        tvWuAdder = findViewById(R.id.order_adder_tv);
        tvWuType = findViewById(R.id.order_wl_type);
        layAdder = findViewById(R.id.order_detalis_adder);

        //邀请好友模块
        tvHy = findViewById(R.id.oredr_pople_tv);
        tvLeader = findViewById(R.id.order_tz_tv);
        imageTz = findViewById(R.id.order_tz_iamg);
        gridView = findViewById(R.id.order_gridview);
        button = findViewById(R.id.order_yqhy_but);

        //商品模块
        tvProName = findViewById(R.id.order_model_name);
        tvProPicer = findViewById(R.id.order_model_price);
        tvProYpicer = findViewById(R.id.order_model_yprice);
        tvProinventory = findViewById(R.id.order_model_inventory);
        tvProTrue = findViewById(R.id.order_sure_tv);
        imagePro = findViewById(R.id.order_model_img);
        //支付模块
        tvProPay = findViewById(R.id.order_pay_money);
        tvProsale = findViewById(R.id.order_sale_tv);


        tvNumber = findViewById(R.id.order_number_tv);
        tvTime = findViewById(R.id.order_time_tv);
        tvWordPay = findViewById(R.id.order_worldpay_tv);
        tvOrderType = findViewById(R.id.order_type_tv);
        tvKtj = findViewById(R.id.order_ktj_tv);
        tvGqTime = findViewById(R.id.order_gqtime_tv);

        from = getIntent().getStringExtra("from");
        Logger.e("---from----", from);
        setAdapter();
        if (!TextUtils.isEmpty(from)) {
            showShareDialog();
        }

    }


    private void showShareDialog() {
        shareDialog = new ShareDialog(this);
        shareDialog.show();
    }


    private void setAdapter() {
        adpter = new OrderPopreAdpter(this);
        gridView.setAdapter(adpter);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void setListener() {
        super.setListener();
        imageGk.setOnClickListener(this);
        tvProTrue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.order_gk_image) {
            startActivity(new Intent(this, OpenActivity.class));
        } else if (i == R.id.order_detalis_adder) {
            startActivity(new Intent(this, AddressActivity.class));
        } else if (i == R.id.order_sure_tv) {
            ShowSureDialog();
        }
    }


    private void ShowSureDialog() {
        CommonDialog dialog = new CommonDialog.Builder()
                .context(this)
                .listener(this)
                .title("拼跌")
                .message("确定收货？")
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();
    }

    @Override
    public void dialogClick(int flag, int type) {
        if (flag == CommonDialog.CONFIRM) {
            startActivity(new Intent(this, EvaluateActivity.class));
        }
    }
}
