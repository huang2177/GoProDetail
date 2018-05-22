package com.module.mine.ui.modifypaw;

/**
 * Created by shibing on 18/5/21.
 */

public interface FindView {


    void onFindSuc();

    void onFindErr();


    void onSendCodeSuc(String msg);

    void onSendCodeErr(String error);
}
