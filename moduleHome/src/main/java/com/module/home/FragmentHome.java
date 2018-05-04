package com.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseFragment;
import com.module.base.base.Constant;

/**
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentHome extends BaseFragment {

    private TextView textView;

    public static FragmentHome newInstance(String msg) {

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
        textView = f(R.id.tv);
        textView.setText(getArguments().getString("msg"));
    }

    @Override
    public void setListener() {
        textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
    }
}
