package com.module.mall.ui.tuanhall;

import com.module.base.pouduct.ProductBean;
import com.module.mall.bean.TuanDetalisBean;

import java.util.List;

/**
 * Created by shibing on 18/6/21.
 */

public interface TuanDetalisView {


    void showTuanDetalis(TuanDetalisBean tuanDetalisBean);

    void showTuanDetalisProduct(List<ProductBean.DataBean> productBean);
}
