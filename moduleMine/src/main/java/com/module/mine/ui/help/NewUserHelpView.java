package com.module.mine.ui.help;

import com.module.mine.bean.HelpBean;
import com.module.mine.bean.HelpDetailBean;

/**
 * Created by shibing on 18/6/9.
 */

public interface NewUserHelpView {

    void showHelp(HelpBean helpBean);

    void showHelpDetail(HelpDetailBean.DataBean detailBean);

}
