package com.module.mall.ui;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.module.base.BasePresenter;
import com.module.base.utils.ToastUtil;
import com.module.base.widgets.dialog.XBottomDialog;
import com.module.mall.R;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.ui.confirmorder.ProBuyTuanPresenter;
import com.module.mall.ui.confirmorder.TuanBuyView;

/**
 * Created by shibing on 18/7/7.
 */

public class PayDialog extends XBottomDialog implements TuanBuyView {


    private TextView tvAipay, tvWeatchPay, tvUnionPay;


    private ProBuyTuanPresenter presenter;


    private String userId, porId, addressId, noAddress, payType;


    public PayDialog(@NonNull Activity activity, String userId, String porId,
                     String addressId, String noAddress, String payType) {
        super(activity);
        this.userId = userId;
        this.porId = porId;
        this.addressId = addressId;
        this.noAddress = noAddress;
        this.payType = payType;

    }

    @Override
    protected int getLayoutId() {
        return R.layout.pay_dialog;
    }

    @Override
    protected void initView() {
        tvAipay = findViewById(R.id.aipay_tv);
        tvWeatchPay = findViewById(R.id.weacthpay_tv);
        tvUnionPay = findViewById(R.id.unionpay_tv);
    }

    @Override
    protected void setListener() {
        tvAipay.setOnClickListener(this);
        tvWeatchPay.setOnClickListener(this);
        tvUnionPay.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //支付宝支付
        if (i == R.id.aipay_tv) {
            ToastUtil.show(activity, "支付宝支付");
            presenter.BuyTuan(userId, porId, noAddress, addressId, noAddress);

        }
        //微信支付
        else if (i == R.id.weacthpay_tv) {
            ToastUtil.show(activity, "微信支付");

        }
        //银联支付
        else if (i == R.id.unionpay_tv) {
            ToastUtil.show(activity, "银联支付");
        }
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new ProBuyTuanPresenter();
        return presenter;
    }


    /**
     * 原价开团
     *
     * @param dataBean
     */
    @Override
    public void showBuyTuan(OpenTuanBean.DataBean dataBean) {

    }

    @Override
    public void showBuyError(String msg) {

    }
}
