package com.module.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseFragment;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.pouduct.ProductBean;
import com.module.base.pouduct.ProductPresenter;
import com.module.base.utils.Logger;
import com.module.base.widgets.CommonDialog;
import com.module.home.adpter.HomeListAdpter;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;
import com.module.home.ui.BusinessActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Huangshuang  2018/5/3 0003
 */

public class FragmentHome extends BaseFragment
        implements CommonDialog.DialogClickListener
        , OnItemClickListener
        , HomeView, OnBannerListener {

    private Banner banner;
    private EditText editSearch;
    private RecyclerView recyclerView;
    private TextView tvLocation, tvNewUserPoint, tvNewUser, tvPinging, tvPinged;

    private HomeListAdpter adpter;
    private List<BannerBean.DataBean> bannerList;
    private HomePresenter presenter;
    private List<ProductBean.DataBean> proList;


    public static FragmentHome newInstance(String msg) {
        Bundle args = new Bundle();
        args.putString("msg", msg);
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getBannerList();
        presenter.getIndexData();
        presenter.getProductList();
    }

    @Override
    protected BasePresenter createPresenter() {
        presenter = new HomePresenter();
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home;

    }

    @Override
    public void initView() {
        banner = viewRoot.findViewById(R.id.home_banner);
        editSearch = viewRoot.findViewById(R.id.home_ed);
        tvNewUser = viewRoot.findViewById(R.id.home_new_user);
        tvPinged = viewRoot.findViewById(R.id.home_pinged_num);
        recyclerView = viewRoot.findViewById(R.id.home_recycle);
        tvPinging = viewRoot.findViewById(R.id.home_pinging_num);
        tvLocation = viewRoot.findViewById(R.id.home_location_tv);
        tvNewUserPoint = viewRoot.findViewById(R.id.home_new_user_tv);

        initTable();
        initBanner();
        initProduct();
    }

    private void initProduct() {
        GridLayoutManager manager = new GridLayoutManager(mActivity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        adpter = new HomeListAdpter(mActivity, getData());
        recyclerView.setAdapter(adpter);
        adpter.addOnItemClickListener(this);
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

    }

    private void initBanner() {


    }

    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.home_location_tv) {
            startActivity(new Intent(getActivity(), BusinessActivity.class));

        } else if (i == R.id.home_new_user_tv) {
            ARouter.getInstance().build(Constant.NEWHELP).navigation();
        }


       /* CommonDialog dialog = new CommonDialog.Builder()
                .context(mContext)
                .listener(this)
                .title("拼跌")
                .message("您还没没有登录，请登录后操作！")
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();*/
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

    @Override
    public void dialogClick(int flag, int type) {
        if (flag == CommonDialog.CONFIRM) {
            ARouter.getInstance().build(Constant.PATH_LOGINACTIVITY).navigation();
        }
    }


    @Override
    public void onItemClick(int position) {
        ARouter.getInstance().build(Constant.PRODETAIL)
                .withString("form", "por")
                .navigation();
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        bannerList = bannerBean.getData();
        banner.setImages(bannerBean.getData())
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void OnBannerErr(String err) {

    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void showIndexData(IndexDataBean indexDataBean) {
        String str1 = getResources().getString(R.string.text_home_new_user);
        String result1 = String.format(str1, indexDataBean.getData().getRegsterCount() + "");
        tvNewUser.setText(Html.fromHtml(result1));

        String str2 = getResources().getString(R.string.text_home_pinging);
        String result2 = String.format(str2, indexDataBean.getData().getPintuanCount() + "");
        tvPinging.setText(Html.fromHtml(result2));

//        <font color="#a0563c" size="18"><b><tt></tt></b>笔</font>\n拼团中
//        "实际支付 <font color= '#a0563c'>" + "￥" + "<big>" + "2000" + "</big></font> " + ".00")
        String str3 = getResources().getString(R.string.text_home_pinged);
        String result3 = String.format(str3, indexDataBean.getData().getSuccessCount() + "");
        tvPinged.setText(Html.fromHtml(
                " <font color= '#a0563c'><big>"
                        + indexDataBean.getData().getSuccessCount()
                        + "</big></font>" + "笔" + "\n" + "拼团成功"));


//        tvPinged.setText(Html.fromHtml(
//                "<font color=#a0563c size=18><b><tt>"
//                        + indexDataBean.getData().getSuccessCount()
//                        + "</tt></b>笔</font>" + "\n拼团成功"));
    }

    @Override
    public void OnIndexErr(String err) {

    }


    //产品
    @Override
    public void shouProduct(ProductBean productBean) {
        proList = productBean.getData();
        Logger.e("----111-----", proList.size() + "");
    }

    @Override
    public void OnProductErr(String err) {

    }

    @Override
    public void OnBannerClick(int position) {
        Logger.e(position + "11111111", "----------");
    }

    /**
     * 重写图片加载器
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object o, ImageView imageView) {
            BannerBean.DataBean dataBean = (BannerBean.DataBean) o;
            String imgurl = Constant.IMAGE_HOST + dataBean.getImgurl();
            GlideManager.loadImage(context, imgurl, imageView);
        }
    }
}
