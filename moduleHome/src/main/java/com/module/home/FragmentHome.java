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
import com.module.home.adpter.HomeListgGlodAdpter;
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

    private RecyclerView home_xlist_phone;   //手机
    private RecyclerView home_xlist_gold;    //珠宝

    private GridLayoutManager manager, manager1;
    private HomeListAdpter adpter;
    private List<BannerBean.DataBean> bannerList;
    private HomePresenter presenter;
    private List<ProductBean.DataBean> proList;
    private List<ProductBean.DataBean> phoneList;

    private HomeListgGlodAdpter glodAdpter;

    private static FragmentHome fragment;


    public static FragmentHome newInstance(String msg) {
        Bundle args = new Bundle();
        args.putString("msg", msg);
        if (fragment == null) {
            fragment = new FragmentHome();
        }
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


        home_xlist_phone = viewRoot.findViewById(R.id.home_xlist_phone);
        home_xlist_gold = viewRoot.findViewById(R.id.home_xlist_gold);
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


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.home_location_tv) {
            startActivity(new Intent(getActivity(), BusinessActivity.class));

        } else if (i == R.id.home_new_user_tv) {
            ARouter.getInstance().build(Constant.NEWHELP).navigation();
        }
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

    @SuppressLint("SetTextI18n")
    @Override
    public void showIndexData(IndexDataBean indexDataBean) {
        tvNewUser.setText(indexDataBean.getData().getRegsterCount() + "人" + "\n注册");
        tvPinging.setText(indexDataBean.getData().getPintuanCount() + "笔" + "\n拼团");
        tvPinged.setText(indexDataBean.getData().getSuccessCount() + "笔" + "\n拼团成功");
    }


    //产品
    @Override
    public void shouProduct(ProductBean productBean) {

        initProduct(productBean);
        //initGoldProduct(productBean);
        Logger.e("----111-----", proList.size() + "");
    }

    //手机专区
    private void initProduct(ProductBean productBean) {
        proList = productBean.getData();
        manager = new GridLayoutManager(mActivity, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);

       /* phoneList = new ArrayList<>();
        for (int i = 0; i < proList.size(); i++) {
            if (proList.get(i).getType() == 0) {
                phoneList.add(new ProductBean.DataBean(
                        proList.get(i).getId()
                        , proList.get(i).getImgurl()
                        , proList.get(i).getBannerImgurl()
                        , proList.get(i).getTitle()
                        , proList.get(i).getAmount()
                        , proList.get(i).getTuanAmount()
                        , proList.get(i).getStarCount()
                        , proList.get(i).getFreight()
                        , proList.get(i).getStockCount()
                        , proList.get(i).getContent()
                        , proList.get(i).getTuanCount()
                        , proList.get(i).getTuanDay()
                        , proList.get(i).getType()
                        , proList.get(i).getCatagory()
                        , proList.get(i).isCollection()
                        , proList.get(i).getLoginUid()
                        , proList.get(i).getCommission()
                        , true
                        , proList.get(i).getDeposit()
                        , proList.get(i).getNorms()
                ));
            }
        }*/

        adpter = new HomeListAdpter(mActivity, getData());
        recyclerView.setAdapter(adpter);
        adpter.addOnItemClickListener(this);
    }

    //黄金专区
   /* private void initGoldProduct(ProductBean productBean) {
        proList = productBean.getData();
        manager1 = new GridLayoutManager(mActivity, 2);
        manager1.setOrientation(OrientationHelper.VERTICAL);
        home_xlist_gold.setLayoutManager(manager1);
        home_xlist_gold.setNestedScrollingEnabled(false);
        glodAdpter = new HomeListgGlodAdpter(mActivity, proList);
        home_xlist_gold.setAdapter(glodAdpter);
    }*/


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
