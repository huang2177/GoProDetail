package com.module.mall.ui.confirmorder;

import com.module.mall.bean.DefaultAddressBean;
import com.module.mall.bean.OpenTuanBean;

/**
 * Created by shibing on 18/6/15.
 */

public interface TuanBuyView {


    //开团卷开团
    void showBuyTuan(OpenTuanBean.DataBean dataBean);

    void showBuyError(String msg);


}
