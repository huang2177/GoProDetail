package com.module.mine;

import com.module.base.base.BaseFragment;

/**
 * @author Huangshuang  2018/5/4 0004
 */

public class FragmentMine extends BaseFragment {
    public static FragmentMine newInstance(String msg) {
        return new FragmentMine();
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {

    }
}
