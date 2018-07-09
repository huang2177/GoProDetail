package com.module.mall.ui.confirmorder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
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
import com.module.base.bean.AddersBean;
import com.module.base.manager.GlideManager;
import com.module.base.utils.SPUtil;
import com.module.base.utils.TextTool;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.dialog.CommonDialog;
import com.module.mall.R;
import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.ui.PayDialog;
import com.module.mall.ui.ReturnRuleActivity;


/**
 * @author Huangshuang  2018/5/11 0011
 */

public class OrderConfirmActivity extends BaseActivity implements PorOrderView, CommonDialog.DialogClickListener {


    //地址
    private TextView tvAdderName, tvAdderPhone, tvAdder, noAddress;
    private RelativeLayout layAdder;

    //商品
    private ImageView imageProduct;
    private TextView tvProductName, tvProductPic, tvProductCon, tvProRule, tvProFreight;
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
    private TextView tvOpen, tvOpenTitle;


    private String userId, frum, porTitle, porIamgeUrl,
            porId, porTuanPic, porColr, addressId, normstr, payType, type;
    private Double porPic;

    //开团卷
    private String openTuanNumer, openTuanTitle, openTuanId;

    private ProOrderPresenter presenter;
    private SPUtil spUtil;


    private CommonDialog dialog;
    private String orderId;

    private PayDialog payDialog;

    //地址
    private AddersBean.DataBean addBean;
    //商品详情
    private ProDetailsBean.DataBean proDetaBean;

    //余额
    private int Balance;


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
        //产品规则
        tvProRule = findViewById(R.id.order_confirm_por_rule);
        //运费
        tvProFreight = findViewById(R.id.order_confirm_freight);


        //开团卷
        rayOpen = findViewById(R.id.order_op_ray);
        layOpen = findViewById(R.id.order_open_lay);
        tvOpen = findViewById(R.id.order_open_tv);
        layOpenText = findViewById(R.id.order_opentext_lay);
        tvOpenTitle = findViewById(R.id.order_open_title);


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


        partType();
        setPorduct();

    }


    /**
     * 区分是土豪购买还是拼团
     */

    private void partType() {
        if (getIntent().getStringExtra(Constant.PORDUCT_TUAN_TYPE) != null) {
            frum = getIntent().getStringExtra(Constant.PORDUCT_TUAN_TYPE);

            switch (frum) {
                case "Wholeprice":     //土豪购买
                    layOrderPay.setVisibility(View.VISIBLE);
                    layOpen.setVisibility(View.GONE);
                    tvSure.setText("确认支付");
                    break;
                case "openTuan":       //去开团
                    layOpen.setVisibility(View.VISIBLE);
                    tvSure.setText("确认开团");
                    break;
                case "JoinTuan":     //参团
                    layOrderPay.setVisibility(View.VISIBLE);
                    layOpen.setVisibility(View.GONE);
                    tvSure.setText("确认支付");
                    break;
                case "porLease":      // 去租赁
                    layOpen.setVisibility(View.VISIBLE);
                    tvProFreight.setVisibility(View.VISIBLE);
                    tvProRule.setText("退还商品后，可申请退还押金");
                    tvOpenTitle.setText("押金余额");
                    tvOpen.setText("￥" + spUtil.getInt(Constant.USER_AMOUNT));
                    tvOpen.setTextColor(getResources().getColor(R.color.colorBrown));
                    break;
            }
        }
    }


    /**
     * 产品 信息
     */
    private void setPorduct() {
        porTitle = getIntent().getStringExtra(Constant.PORDUCT_TITLE);
        porIamgeUrl = getIntent().getStringExtra(Constant.PORDUCT_IMAGR);
        porPic = Double.valueOf(getIntent().getStringExtra(Constant.PORDUCT_PIC));
        porTuanPic = getIntent().getStringExtra(Constant.PORDUCT_TUAN_PIC);
        porId = getIntent().getStringExtra(Constant.PORDUCTID);
        porColr = getIntent().getStringExtra(Constant.PORDUCT_CLORO);
        type = getIntent().getStringExtra(Constant.PORDUCT_TYPE);
        tvProductName.setText(porTitle);
        tvProductPic.setText("￥" + porPic);
        tvProductCon.setText(porColr);
        GlideManager.loadImage(this, Constant.IMAGE_HOST + porIamgeUrl, imageProduct);
        //支付价格
        setPorPic();

    }

    /**
     * 支付价格
     */
    private void setPorPic() {
        //产品价格
        if (type.equals("0")) {       //开团产品
            TextTool.getBuilder("")
                    .setBold().setAlign(Layout.Alignment.ALIGN_CENTER)
                    .append("支付")
                    .setForegroundColor(getResources().getColor(R.color.colorDeepGray))
                    .append("￥")
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))
                    .append(porPic + "")
                    .setProportion(2)
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))
                   /* .append(".00")
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))*/
                    .into(tvPayMoney);
        } else {                    //租赁产品
            Balance = spUtil.getInt(Constant.USER_AMOUNT);
            Double paymoney = (Double) (Balance - porPic);
            TextTool.getBuilder("")
                    .setBold().setAlign(Layout.Alignment.ALIGN_CENTER)
                    .append("实际支付")
                    .setForegroundColor(getResources().getColor(R.color.colorDeepGray))
                    .append("￥")
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))
                    .append(paymoney + "")
                    .setProportion(2)
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))
                   /* .append(".00")
                    .setForegroundColor(getResources().getColor(R.color.colorBrown))*/
                    .into(tvPayMoney);

        }


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
            ARouter.getInstance().build(Constant.PATH_ADDERS)
                    .withString("from", Constant.PORDUCT_ORDER)
                    .navigation(this, 20);
        }
        // 跳转商品详情
        else if (i == R.id.order_prouduct_ray) {

        }
        //跳转至规则
        else if (i == R.id.order_confirm_gz_lay) {
            startActivity(new Intent(this, ReturnRuleActivity.class));
        } else if (i == R.id.order_op_ray) {
            //是租凭 跳转至我的押金
            if (type.equals("1")) {
                ARouter.getInstance().build(Constant.PATH_DEPOSIT)
                        .navigation();
            }
            //跳转至我的开团卷
            else {
                ARouter.getInstance().build(Constant.OPENCOIL_PATH)
                        .withString("from", Constant.PORDUCT_ORDER)
                        .navigation(this, 10);
            }


        }
        //跳转至开团卷规则
        else if (i == R.id.order_open_lay) {

        }

        //支付宝支付
        else if (i == R.id.order_aipay_ray) {
            tvAiPay.setText("已选择");
            tvAiPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_solid, 0);
            tvWeatchPay.setText("");
            tvWeatchPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            tvUnionPay.setText("");
            tvUnionPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            payType = "alipay-";
        }
        //微信支付
        else if (i == R.id.order_weathpay_ray) {
            tvWeatchPay.setText("已选择");
            tvWeatchPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_solid, 0);
            tvAiPay.setText("");
            tvAiPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            tvUnionPay.setText("");
            tvUnionPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            payType = "weixin-";
        }
        //银联支付
        else if (i == R.id.order_unionpay_ray) {
            tvUnionPay.setText("已选择");
            tvUnionPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_solid, 0);
            tvAiPay.setText("");
            tvAiPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            tvWeatchPay.setText("");
            tvWeatchPay.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_checked_rou, 0);
            //银联支付
            payType = "";
        }
        //确认支付
        else if (i == R.id.order_surepay_tv) {
            switch (frum) {
                case "Wholeprice":    // 全款购买
                    if (TextUtils.isEmpty(payType)) {
                        ToastUtil.show(this, "请选择支付方式");
                        return;
                    }
                    presenter.BuyTuan(userId, porId, addressId, normstr, payType);
                    break;
                case "openTuan":     // 开团  如果开团卷为空   就是原价开团  反之就是开团卷开团
                    if (TextUtils.isEmpty(openTuanNumer)) {
                        if (TextUtils.isEmpty(payType)) {
                            ToastUtil.show(this, "请选择支付方式");
                            return;
                        }
                        presenter.BuyTuan(userId, porId, addressId, normstr, payType);
                        return;
                    }
                    presenter.ProOpenTuan(userId, porId, openTuanId);
                    break;

                case "porLease":     //租赁产品

                    break;

                case "JoinTuan":            //参团

                    break;
            }
        }

    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            //选择开团卷
            case 100:
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
                TextTool.getBuilder("")
                        .setBold().setAlign(Layout.Alignment.ALIGN_CENTER)
                        .append("无需支付")
                        .setForegroundColor(getResources().getColor(R.color.colorDeepGray))
                        .append("￥－")
                        .setForegroundColor(getResources().getColor(R.color.colorBrown))
                        .into(tvPayMoney);
                break;
            //选择地址
            case 200:
                addBean = (AddersBean.DataBean) data.getBundleExtra("bundle").getSerializable(Constant.ORDER_ADDER);
                if (addBean != null) {
                    tvAdderName.setText(addBean.getName());
                    tvAdderPhone.setText(addBean.getMobile());
                    tvAdder.setText(addBean.getProvince()
                            + addBean.getCity() + addBean.getArea() + addBean.getDetail());
                    addressId = addBean.getId();
                }
                break;
        }
    }

    /**
     * 获取默认地址
     *
     * @param dataBean
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void showDefaultAddress(DefaultAddressBean.DataBean dataBean) {
        tvAdderName.setText(dataBean.getName());
        tvAdderPhone.setText(dataBean.getMobile());
        addressId = dataBean.getId();
        tvAdder.setText(dataBean.getProvince()
                + dataBean.getCity() + dataBean.getArea() + dataBean.getDetail());
    }


    /**
     * 获取地址失败 或者是没有默认地址
     */
    @Override
    public void showError() {
        noAddress.setVisibility(View.VISIBLE);
        layAdder.setVisibility(View.GONE);
    }

    /**
     * 使用开团卷开团成功
     *
     * @param dataBean
     */
    @Override
    public void showOpenTuan(OpenTuanBean.DataBean dataBean) {
        orderId = dataBean.getOrderId();
        showDialog();
    }


    /**
     * 使用开团卷开团失败
     *
     * @param msg
     */
    @Override
    public void showOpenError(String msg) {
        ToastUtil.show(this, msg);
    }


    /**
     * 原价开团成功
     *
     * @param dataBean
     */
    @Override
    public void showBuyTuan(OpenTuanBean.DataBean dataBean) {
        orderId = dataBean.getOrderId();
        showDialog();
    }


    /**
     * 原价开团失败
     *
     * @param msg
     */
    @Override
    public void showBuyError(String msg) {
        ToastUtil.show(this, msg);
    }


    /**
     * 参团成功
     *
     * @param dataBean
     */
    @Override
    public void showJoinTuan(OpenTuanBean.DataBean dataBean) {

    }

    /**
     * 参团失败
     *
     * @param msg
     */
    @Override
    public void showJoinTuanErr(String msg) {

    }


    private void showDialog() {
        dialog = new CommonDialog.Builder()
                .context(this)
                .listener(this)
                .title("拼跌")
                .message("开团成功，快去邀请好友来拼团吧！")
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();
    }


    @Override
    public void dialogClick(int flag, int type) {
        if (flag == CommonDialog.CONFIRM) {
            ARouter.getInstance().build(Constant.PATH_ORDERDETALIS)
                    .withString(Constant.ORDER_ID, orderId)
                    .withString(Constant.PORDUCTID, porId)
                    .navigation();
            dialog.dismiss();
            finish();

        } else if (flag == CommonDialog.CANCEL) {
            dialog.dismiss();
        }
    }
}
