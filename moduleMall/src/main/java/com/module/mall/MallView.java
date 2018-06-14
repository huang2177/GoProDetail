package com.module.mall;

import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductTypeBean;

public interface MallView {


    void showProductType(ProductTypeBean typeBean);

    void showProduct(ProductBean productBean);

}
