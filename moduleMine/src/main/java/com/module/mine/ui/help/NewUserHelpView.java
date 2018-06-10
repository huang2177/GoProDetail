package com.module.mine.ui.help;

import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.HelpBean;

/**
 * Created by shibing on 18/6/9.
 */

public interface NewUserHelpView {

    void showHelp(HelpBean helpBean);

    void onHelpErr(String error);

}
