package com.module.mall.ui.confirmorder;

import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by shibing on 18/6/15.
 */

public interface PorOrderView {


    //获取默认地址

    void showDefaultAddress(DefaultAddressBean.DataBean dataBean);

    void showError();


    //开团卷开团
    void showOpenTuan(OpenTuanBean.DataBean dataBean);

    void showOpenError(String msg);



}
