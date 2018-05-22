package com.module.mine;

import com.module.base.BaseView;
import com.module.mine.bean.UserInfoBean;

/**
 * Created by shibing on 18/5/21.
 */

public interface MineView extends BaseView{

    void showUserInfo(UserInfoBean userInfo);

    void onError(String error);


}
