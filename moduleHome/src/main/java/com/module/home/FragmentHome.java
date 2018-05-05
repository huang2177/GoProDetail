package com.module.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.base.BaseFragment;
import com.module.base.base.Constant;
import com.module.base.widgets.XGridView;
import com.module.home.adpter.HomeListAdpter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentHome extends BaseFragment {

    private Banner banner;
    private XGridView gridView;
    private RecyclerView recyclerView;
    private EditText editSearch;
    private TextView tvLocation, tvNewUserPoint, tvNewUser, tvPinging, tvPinged;

    private HomeListAdpter adpter;

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
        banner = f(R.id.home_banner);
        // gridView = f(R.id.home_grid);
        editSearch = f(R.id.home_ed);
        tvNewUser = f(R.id.home_new_user);
        tvPinged = f(R.id.home_pinged_num);
        recyclerView = f(R.id.home_recycle);
        tvPinging = f(R.id.home_pinging_num);
        tvLocation = f(R.id.home_location_tv);
        tvNewUserPoint = f(R.id.home_new_user_tv);

        initTable();
        initBanner();
        initProduct();
    }

    private void initProduct() {
        GridLayoutManager manager = new GridLayoutManager(activity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new HomeListAdpter(activity, getData());
        recyclerView.setAdapter(adpter);
    }

    private List<Integer> getData() {
        return Arrays.asList(R.drawable.img_banner1
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.img1
                , R.drawable.img_banner2
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.img1);
    }

    @Override
    public void setListener() {
        tvLocation.setOnClickListener(this);
        tvNewUserPoint.setOnClickListener(this);
    }

    private void initTable() {
//        String str1 = getResources().getString(R.string.text_home_new_user);
//        String result1 = String.format(str1, "42213");
//        tvNewUser.setText(Html.fromHtml(result1));
//
//        String str2 = getResources().getString(R.string.text_home_pinging);
//        String result2 = String.format(str2, "1345");
//        tvPinging.setText(Html.fromHtml(result2));
//
//        String str3 = getResources().getString(R.string.text_home_pined);
//        String result3 = String.format(str3, "4567");
//        tvPinged.setText(Html.fromHtml(result3));
    }

    private void initBanner() {
        banner.setImages(Arrays.asList("123", "123"))
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onClick(View v) {
        ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
    }


    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    /**
     * 重写图片加载器
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide.with(context).load(path).into(imageView);
            imageView.setImageResource(R.drawable.banner);
        }
    }
}
