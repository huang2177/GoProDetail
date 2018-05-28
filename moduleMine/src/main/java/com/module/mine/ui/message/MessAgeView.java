package com.module.mine.ui.message;

import com.module.mine.bean.MessAgeBean;

/**
 * Created by shibing on 18/5/26.
 */

public interface MessAgeView {

    void showMessAge(MessAgeBean messAgeBean);

    void onFindErr(String error);

}
