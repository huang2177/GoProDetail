package com.module.base;

/**
 * Created by 黄双 on 2018/5/19.
 */

public interface BaseView {

    void showLoading(String msg);

    void hideLoading();

    void onError(String msg);
}
