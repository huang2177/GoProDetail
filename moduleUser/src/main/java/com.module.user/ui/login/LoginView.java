package com.module.user.ui.login;

import com.module.user.bean.RegisterBean;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface LoginView {

    void onLoginSuc(RegisterBean registerBean);

    void onLoginErr(String error);

}
