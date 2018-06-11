package com.module.home.ui.business;

import com.module.home.bean.BusinBean;

/**
 * Created by shibing on 18/6/10.
 */

public interface BusinView {

    void showBusin(BusinBean businBean);

    void onBusinErr(String err);
}
