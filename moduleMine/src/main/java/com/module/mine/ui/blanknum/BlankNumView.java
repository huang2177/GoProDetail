package com.module.mine.ui.blanknum;

import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.MessAgeBean;

/**
 * Created by shibing on 18/5/26.
 */

public interface BlankNumView {

    void showBlankNum(BlankNumBean blankNumBean);

    void onFindErr(String error);

}
