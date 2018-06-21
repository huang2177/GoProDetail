package com.module.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.module.base.utils.Logger;
import com.module.base.widgets.dialog.CommonDialog;
import com.module.home.adpter.HomeListAdpter;
import com.module.home.adpter.HomeListgGlodAdpter;
import com.module.home.bean.BannerBean;
import com.module.home.bean.IndexDataBean;
import com.module.home.ui.BusinessActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

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

    private RecyclerView recyPhone;   //手机
    private RecyclerView recyGold;    //珠宝

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


        recyPhone = viewRoot.findViewById(R.id.home_xlist_phone);
        recyGold = viewRoot.findViewById(R.id.home_xlist_gold);

        initPhonreRecycle();
        initGoldRecycle();
    }

    /**
     * 初始化recycleview
     */
    private void initPhonreRecycle() {
        manager = new GridLayoutManager(mActivity, 2);
        recyPhone.setLayoutManager(manager);
        recyPhone.setNestedScrollingEnabled(false);
    }


    private void initGoldRecycle() {
        manager1 = new GridLayoutManager(mActivity, 2);
        recyGold.setLayoutManager(manager1);
        recyGold.setNestedScrollingEnabled(false);
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
    public void showProduct(ProductBean productBean) {
        proList = productBean.getData();
        adpter = new HomeListAdpter(mActivity, productBean.getData());
        recyPhone.setAdapter(adpter);
        adpter.addOnItemClickListener(this);

        glodAdpter = new HomeListgGlodAdpter(mActivity, productBean.getData());
        recyGold.setAdapter(glodAdpter);
        glodAdpter.addHoldOnItemClickListener(this);
    }


    @Override
    public void onItemClick(int position) {
        if (proList.get(position).getType() == 0) {
            ARouter.getInstance().build(Constant.PRODETAIL)
                    .withString("form", "por")
                    .navigation();
        } else if (proList.get(position).getType() == 1) {
            ARouter.getInstance().build(Constant.PRODETAIL)
                    .withString("form", "jewelry")
                    .navigation();
        }
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
