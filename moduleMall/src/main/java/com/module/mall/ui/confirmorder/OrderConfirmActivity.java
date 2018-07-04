package com.module.mall.ui.confirmorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.utils.Logger;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.mall.R;
import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.ui.ReturnRuleActivity;


/**
 * @author Huangshuang  2018/5/11 0011
 */

public class OrderConfirmActivity extends BaseActivity implements PorOrderView {


    //地址
    private TextView tvAdderName, tvAdderPhone, tvAdder, noAddress;
    private RelativeLayout layAdder;

    //商品
    private ImageView imageProduct;
    private TextView tvProductName, tvProductPic, tvProductCon;
    private LinearLayout layRule;
    private RelativeLayout rayProuduct;

    //支付
    private RelativeLayout rayAipay, rayWeatch, rayUnionpay;
    private TextView tvAiPay, tvWeatchPay, tvUnionPay;
    private LinearLayout layOrderPay;

    //确定支付
    private TextView tvPayMoney, tvSure;

    //开团卷
    private RelativeLayout rayOpen;
    private LinearLayout layOpen, layOpenText;   //开团卷说明
    private TextView tvOpen;


    private String userId, froum, porTitle, porIamgeUrl, porId, porPic, porTuanPic, porColr;

    //开团卷
    private String openTuanNumer, openTuanTitle, openTuanId;

    private ProOrderPresenter presenter;
    private SPUtil spUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("支付拼团订单");
        presenter.ProDefaultAddress(userId);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_confirm;
    }

    @Override
    public void initView() {
        spUtil = SPUtil.getInstance(this);
        userId = spUtil.getString(Constant.USERID);


        //地址
        tvAdderName = findViewById(R.id.order_confirm_name);
        tvAdderPhone = findViewById(R.id.order_confirm_phone);
        tvAdder = findViewById(R.id.order_confirm_adder_tv);
        layAdder = findViewById(R.id.order_adder_ray);
        noAddress = findViewById(R.id.no_adderss);

        //商品
        imageProduct = findViewById(R.id.order_confirm_img);
        tvProductName = findViewById(R.id.order_confirm_pouname);
        tvProductPic = findViewById(R.id.order_confirm_price);
        tvProductCon = findViewById(R.id.order_confirm_inventory);
        rayProuduct = findViewById(R.id.order_prouduct_ray);
        layRule = findViewById(R.id.order_confirm_gz_lay);


        //开团卷
        rayOpen = findViewById(R.id.order_op_ray);
        layOpen = findViewById(R.id.order_open_lay);
        tvOpen = findViewById(R.id.order_open_tv);
        layOpenText = findViewById(R.id.order_opentext_lay);

        //支付
        rayAipay = findViewById(R.id.order_aipay_ray);
        rayWeatch = findViewById(R.id.order_weathpay_ray);
        rayUnionpay = findViewById(R.id.order_unionpay_ray);
        tvAiPay = findViewById(R.id.order_aipay_tv);
        tvWeatchPay = findViewById(R.id.order_weathpay_tv);
        tvUnionPay = findViewById(R.id.order_unionpay_tv);
        layOrderPay = findViewById(R.id.order_pay_lay);

        //确认支付
        tvPayMoney = findViewById(R.id.order_pay_tv);
        tvSure = findViewById(R.id.order_surepay_tv);


        if (getIntent().getStringExtra("from") != null) {
            froum = getIntent().getStringExtra("from");
            if (froum.equals("zero")) {
                layOrderPay.setVisibility(View.GONE);
                tvSure.setText("确认开团");
                tvPayMoney.setText("无需支付  ￥-");
            } else {
                layOrderPay.setVisibility(View.VISIBLE);
                layOpen.setVisibility(View.GONE);
                tvSure.setText("确认支付");
            }
        }
        setPorduct();

    }


    private void setPorduct() {
        porTitle = getIntent().getStringExtra(Constant.PORDUCT_TITLE);
        porIamgeUrl = getIntent().getStringExtra(Constant.PORDUCT_IMAGR);
        porPic = getIntent().getStringExtra(Constant.PORDUCT_PIC);
        porTuanPic = getIntent().getStringExtra(Constant.PORDUCT_TUAN_PIC);
        porId = getIntent().getStringExtra(Constant.PORDUCTID);
        porColr = getIntent().getStringExtra(Constant.PORDUCT_CLORO);

        Logger.e("11111", porTitle);
        Logger.e("22222", porIamgeUrl);
        Logger.e("33333", porPic);
        Logger.e("44444", porTuanPic);
        Logger.e("55555", porId);

        tvProductName.setText(porTitle);
        tvProductPic.setText("￥" + porPic);
        tvProductCon.setText(porColr);
        GlideManager.loadImage(this, Constant.IMAGE_HOST + porIamgeUrl, imageProduct);


    }


    @Override
    public BasePresenter createPresenter() {
        presenter = new ProOrderPresenter();
        return presenter;
    }


    @Override
    public void setListener() {
        super.setListener();

        layAdder.setOnClickListener(this);
        rayProuduct.setOnClickListener(this);
        layRule.setOnClickListener(this);
        rayAipay.setOnClickListener(this);
        rayWeatch.setOnClickListener(this);
        rayUnionpay.setOnClickListener(this);
        tvSure.setOnClickListener(this);
        rayOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //选择地址
        if (i == R.id.order_adder_ray) {
            ARouter.getInstance().build(Constant.ADDERS).navigation();
        }
        // 跳转商品详情
        else if (i == R.id.order_prouduct_ray) {

        }
        //跳转至规则
        else if (i == R.id.order_confirm_gz_lay) {
            startActivity(new Intent(this, ReturnRuleActivity.class));
        }
        //跳转至我的开团卷
        else if (i == R.id.order_op_ray) {
            ARouter.getInstance().build(Constant.OPENCOIL).navigation(this, 10);
        }
        //跳转至开团卷规则
        else if (i == R.id.order_open_lay) {

        }


        //支付宝支付
        else if (i == R.id.order_aipay_ray) {

        }
        //微信支付
        else if (i == R.id.order_weathpay_ray) {

        }
        //银联支付
        else if (i == R.id.order_unionpay_ray) {

        }
        //确认支付
        else if (i == R.id.order_surepay_tv) {
            //开团卷不为空时  使用开团卷开团
            if (TextUtils.isEmpty(openTuanNumer)) {
                ToastUtil.show(this, "开团卷为空");
                return;
            }
            presenter.ProOpenTuan(userId, porId, openTuanId);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            openTuanNumer = data.getStringExtra(Constant.OPEN_TUAN_NUMER);
            openTuanTitle = data.getStringExtra(Constant.OPEN_TUAN_NAME);
            openTuanId = data.getStringExtra(Constant.OPEN_TUAN_ID);
            if (TextUtils.isEmpty(openTuanNumer) && TextUtils.isEmpty(openTuanTitle)) {
                tvOpen.setVisibility(View.GONE);
                layOpenText.setVisibility(View.GONE);
                return;
            }
            tvOpen.setText(openTuanTitle + " | " + openTuanNumer);
            layOpenText.setVisibility(View.VISIBLE);

            Logger.e("-------openTuanId", openTuanId);
        }

    }

    /**
     * 获取默认地址
     *
     * @param dataBean
     */
    @Override
    public void showDefaultAddress(DefaultAddressBean.DataBean dataBean) {
        tvAdderName.setText(dataBean.getName());
        tvAdderPhone.setText(dataBean.getMobile());
        tvAdder.setText(dataBean.getProvince()
                + dataBean.getCity() + dataBean.getArea() + dataBean.getDetail());
    }

    @Override
    public void showError() {
        noAddress.setVisibility(View.VISIBLE);
        layAdder.setVisibility(View.GONE);
    }

    //使用开团卷开团
    @Override
    public void showOpenTuan(OpenTuanBean.DataBean dataBean) {
        ToastUtil.show(this, "开团成功");
    }


    //返回错误的消息
    @Override
    public void showOpenError(String msg) {
        ToastUtil.show(this, msg);
    }
}
