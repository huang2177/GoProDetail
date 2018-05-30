package com.module.mine.ui.team;

import com.module.mine.bean.BlankNumBean;
import com.module.mine.bean.TeamBean;

/**
 * Created by shibing on 18/5/26.
 */

public interface TeamView {

    void showTeam(TeamBean teamBean);

    void onFindErr(String error);

}
