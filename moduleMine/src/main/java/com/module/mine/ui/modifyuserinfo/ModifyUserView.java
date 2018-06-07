package com.module.mine.ui.modifyuserinfo;

import com.module.mine.bean.ModifyUserBean;

/**
 * Created by shibing on 18/5/21.
 */

public interface ModifyUserView {


    void onModifyUserSuc(ModifyUserBean modifyUserBean);

    void onModifyUserErr();


    void onFileImageSuc(String msg);

    void onFileImageErr(String error);
}
