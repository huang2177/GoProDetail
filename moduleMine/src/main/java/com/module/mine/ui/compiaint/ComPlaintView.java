package com.module.mine.ui.compiaint;

import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.ComPlaintBean;

/**
 * Created by shibing on 18/6/9.
 */

public interface ComPlaintView {


    void OnSuPlanSuc(ComPlaintBean comPlaintBean);

    void OnSuPlanErr(String error);
}
