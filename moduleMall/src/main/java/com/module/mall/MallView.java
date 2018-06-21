package com.module.mall;

import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

public interface MallView {


    void showProductType(ProductTypeBean typeBean);

    void showProduct(List<ProductBean.DataBean> productBean);

    void showTuanList(List<ProductTuanBean.DataBean> productTuan);

}
