package com.module.user.ui.register;

import com.module.user.bean.RegisterBean;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface RegisterView {

    void onRegisterSuc(RegisterBean registerBean);

    void onRegisterErr(String error);

    void onSendCodeSuc(String msg);

    void onSendCodeErr(String error);
}
