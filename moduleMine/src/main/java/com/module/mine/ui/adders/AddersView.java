package com.module.mine.ui.adders;

import com.module.mine.bean.AddersBean;

/**
 * Created by shibing on 18/6/9.
 */

public interface AddersView {


    void showAdders(AddersBean addersBean);

    void OnAddersErr(String err);
}
