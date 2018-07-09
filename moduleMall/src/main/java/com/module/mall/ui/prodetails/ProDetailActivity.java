package com.module.mall.ui.prodetails;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.utils.SPUtil;
import com.module.base.widgets.XListView;
import com.module.mall.R;
import com.module.mall.adpter.MoreEvaluateAdapter;
import com.module.mall.adpter.ProductTuanAdapter;
import com.module.mall.bean.PintuanRuleBean;
import com.module.mall.bean.ProDetailsBean;
import com.module.mall.bean.ProductEvaBean;
import com.module.mall.bean.ProductTuanBean;
import com.module.mall.ui.moreevalvate.MoreEvaluateActivity;
import com.module.mall.ui.confirmorder.OrderConfirmActivity;
import com.module.mall.ui.ProModelDialog;
import com.module.mall.ui.moretuan.MoreTuanActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by 黄双 on 2018/5/6.
 */

@Route(path = Constant.PRODETAIL)
public class ProDetailActivity extends BaseActivity implements ProDetailsView {

    Banner banner;
    private LinearLayout layoutEvaluate, layMoreEva, layPintuan, layJewelry, layTuanTitle, layRule;
    private XListView lvIntroduce, lvImage, lvGrouping, lvEvaluate;
    private TextView tvMoreIntroduce, tvEvaluate, tvService, tvPhone, tvBuy, tvGroup, tvShuom, tvjewelry;
    private TextView tvName, tvPingedNum, tvPirce, tvOldPirce, tvFreight, tvInventory, tvCollection, tvNoEvaluate;
    private TextView tvContent, tvIntroduce;
    private boolean isCollectioned;
    private ProModelDialog proModelDialog;
    private String form;
    private ProDetailsPresenter presenter;
    private String pid, uid;
    //评价适配器
    private MoreEvaluateAdapter evaluateAdapter;
    //商品团适配器
    private ProductTuanAdapter tuanAdapter;
    private int typeRule;
    private String catagory;
    private List<String> bannerList;
    //说明id
    private String ruleId;

    //规格
    private ProDetailsBean.DataBean mDataBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pid = getIntent().getStringExtra(Constant.PORDUCTID);
        uid = SPUtil.getInstance(this).getString(Constant.USERID);
        presenter.ProDetails(pid);
        presenter.productEvaList(pid, uid);
        presenter.productTuan(uid, pid, true, catagory);

    }

    @Override
    public boolean isUseDart() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pro_detail;
    }

    @Override
    public void initView() {
        tvBuy = findViewById(R.id.pro_buy);
        tvName = findViewById(R.id.pro_name);
        tvPhone = findViewById(R.id.pro_phone);
        tvGroup = findViewById(R.id.pro_group);
        tvPirce = findViewById(R.id.pro_pirce);
        tvContent = findViewById(R.id.pro_content);
        tvIntroduce = findViewById(R.id.introduce_tv);

        banner = findViewById(R.id.pro_banner);
        lvImage = findViewById(R.id.pro_image_lv);
        tvService = findViewById(R.id.pro_service);
        tvFreight = findViewById(R.id.pro_freight);
        tvOldPirce = findViewById(R.id.pro_old_pirce);
        tvInventory = findViewById(R.id.pro_inventory);
        tvPingedNum = findViewById(R.id.pro_pinged_num);
        lvGrouping = findViewById(R.id.pro_grouping_lv);
        tvCollection = findViewById(R.id.pro_collection);
        lvIntroduce = findViewById(R.id.pro_introduce_lv);
        lvEvaluate = findViewById(R.id.evaluate_list);


        tvEvaluate = findViewById(R.id.pro_tv_evaluate_more);
        tvNoEvaluate = findViewById(R.id.no_evaluate);
        tvMoreIntroduce = findViewById(R.id.pro_tv_introduce_more);
        tvShuom = findViewById(R.id.order_shoum_tv);
        tvjewelry = findViewById(R.id.jewelry_buy);
        layMoreEva = findViewById(R.id.moreeva_lay);
        layPintuan = findViewById(R.id.order_pintuan_lay);
        layJewelry = findViewById(R.id.order_jewelry_lay);
        layTuanTitle = findViewById(R.id.produtc_tuan_lay);
        layRule = findViewById(R.id.rule_lay);

        tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        //benner
        bannerList = new ArrayList<>();

    }


    @Override
    public void setListener() {
        super.setListener();
        tvBuy.setOnClickListener(this);
        tvPhone.setOnClickListener(this);
        tvGroup.setOnClickListener(this);
        tvService.setOnClickListener(this);
        tvEvaluate.setOnClickListener(this);
        tvMoreIntroduce.setOnClickListener(this);
        tvCollection.setOnClickListener(this);
        layMoreEva.setOnClickListener(this);
        layPintuan.setOnClickListener(this);
        layTuanTitle.setOnClickListener(this);
        layRule.setOnClickListener(this);
        //支付押金
        tvjewelry.setOnClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new ProDetailsPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent = null;
        int i = v.getId();
        if (i == R.id.pro_collection) {
            presenter.ProCollection(uid, pid);
        }
        //更多评价
        else if (i == R.id.moreeva_lay) {
            intent = new Intent(this, MoreEvaluateActivity.class);
            intent.putExtra("pid", pid);
            startActivity(intent);
        }
        //更多拼团
        else if (i == R.id.produtc_tuan_lay) {
            intent = new Intent(this, MoreTuanActivity.class);
            intent.putExtra("pid", pid);
            startActivity(intent);
        }
        //说明详细
        else if (i == R.id.rule_lay) {
            intent = new Intent(this, RuleDetalisActivity.class);
            intent.putExtra("ruleId", ruleId);
            startActivity(intent);
        }
        //客服
        else if (i == R.id.pro_service) {

        }
        //电话
        else if (i == R.id.pro_phone) {

        }
        //支付
        else if (i == R.id.pro_buy) {
            proModelDialog = new ProModelDialog(this, mDataBean, "Wholeprice");  //土豪购买
            proModelDialog.show();
        }
        //跳转至订单详情 0元购
        else if (i == R.id.pro_group) {
            proModelDialog = new ProModelDialog(this, mDataBean, "openTuan");    //去开团
            proModelDialog.show();
        }
        //0元首饰盒  支付押金
        else if (i == R.id.jewelry_buy) {
            proModelDialog = new ProModelDialog(this, mDataBean, "lease");  //产品租赁
            proModelDialog.show();
        }
    }


    //详情
    @Override
    public void showDetails(ProDetailsBean.DataBean dataBean) {
        //规格
        this.mDataBean = dataBean;

        tvName.setText(dataBean.getTitle());
        tvPingedNum.setText(dataBean.getTuanCount() + "人拼团成功");
        tvPirce.setText(dataBean.getTuanAmount() + "元购");
        tvOldPirce.setText("¥" + dataBean.getAmount());
        tvFreight.setText("运费¥" + dataBean.getFreight());
        tvInventory.setText("库存" + dataBean.getStockCount() + "件");
        if (Build.VERSION.SDK_INT >= 24) {
            tvContent.setText(Html.fromHtml(dataBean.getContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            tvContent.setText(Html.fromHtml(dataBean.getContent()));
        }
        //是否收藏
        isCollectioned = dataBean.isCollection();
        tvCollection.setCompoundDrawablesWithIntrinsicBounds(0
                , isCollectioned ? R.drawable.ic_heart_brown2 : R.drawable.ic_heart_brown1
                , 0
                , 0);

        typeRule = dataBean.getType();
        if (typeRule == 1) {
            tvPingedNum.setText("押金：¥2000");
            tvPirce.setVisibility(View.GONE);
            tvOldPirce.setVisibility(View.GONE);
            layPintuan.setVisibility(View.GONE);
            tvShuom.setText("首饰盒租借说明");
            layJewelry.setVisibility(View.VISIBLE);
            tvjewelry.setVisibility(View.VISIBLE);
            tvBuy.setVisibility(View.GONE);
            tvGroup.setVisibility(View.GONE);
        }

        //判断是拼团还是租凭
        if (typeRule == 0) {
            presenter.PintuanRule(pid);
        } else {
            presenter.ZulinRule(pid);
        }
        //banner图
        String str[] = dataBean.getBannerImgurl().split(",");
        bannerList = Arrays.asList(str);
        initBanner();
    }


    /**
     * banner 图
     */
    private void initBanner() {
        banner.setImages(bannerList)
                .setImageLoader(new GlideImageLoader())
                .start();
    }


    //收藏产品
    @Override
    public void showCollection(ProDetailsBean proDetailsBean) {
        tvCollection.setCompoundDrawablesWithIntrinsicBounds(0
                , isCollectioned ? R.drawable.ic_heart_brown2 : R.drawable.ic_heart_brown1
                , 0
                , 0);
    }


    /**
     * 最新评价
     */

    @Override
    public void showProductEva(List<ProductEvaBean.DataBean> productEva) {
        if (productEva.size() == 0) {
            lvEvaluate.setVisibility(View.GONE);
            tvNoEvaluate.setVisibility(View.VISIBLE);
            return;
        }
        evaluateAdapter = new MoreEvaluateAdapter(this, productEva, "prodetailsEva");
        lvEvaluate.setAdapter(evaluateAdapter);
    }

    /**
     * 暂无评价
     */
    @Override
    public void showProductEvaEmpty() {


    }


    //拼团list
    @Override
    public void showTuanList(List<ProductTuanBean.DataBean> productTuan) {
        if (productTuan.size() == 0) {
            layPintuan.setVisibility(View.GONE);
            return;
        }
        tuanAdapter = new ProductTuanAdapter(this, productTuan, "detailsTuan");
        lvGrouping.setAdapter(tuanAdapter);
    }


    //说明
    @Override
    public void showRule(PintuanRuleBean ruleBean) {
        tvIntroduce.setText(ruleBean.getData().getTitle());
        ruleId = ruleBean.getData().getId();
    }






   /* */

    /**
     * 重写图片加载器
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object o, ImageView imageView) {
            String imgurl = null;
            for (int i = 0; i < bannerList.size(); i++) {
                imgurl = bannerList.get(i);
            }
            GlideManager.loadImage(context, Constant.IMAGE_HOST + imgurl, imageView);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }
}