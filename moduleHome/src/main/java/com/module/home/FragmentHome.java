package com.module.home;

import android.os.Bundle;
import android.widget.TextView;

import com.module.base.base.BaseFragment;

/**
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentHome extends BaseFragment {

    public static FragmentHome newInstance(String  msg) {

        Bundle args = new Bundle();
        args.putString("msg", msg);
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        TextView textView = f(R.id.tv);
        textView.setText(getArguments().getString("msg"));
    }
}
