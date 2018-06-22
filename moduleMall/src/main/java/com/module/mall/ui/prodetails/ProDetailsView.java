package com.module.mall.ui.prodetails;

import com.module.base.pouduct.ProductBean;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by shibing on 18/6/15.
 */

public interface ProDetailsView {

    void showDetails(ProDetailsBean proDetailsBean);


    void showCollection(ProDetailsBean proDetailsBean);

    void showProductEva(List<ProductEvaBean.DataBean> productEva);

    void showProductEvaEmpty();


    void showTuanList(List<ProductTuanBean.DataBean> productTuan);

    void showRule(PintuanRuleBean ruleBean);
}
