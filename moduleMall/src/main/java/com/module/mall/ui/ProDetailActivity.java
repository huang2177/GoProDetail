package com.module.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.widgets.CommonAdapter;
import com.module.base.widgets.RoundImageView;
import com.module.base.widgets.ViewHolder;
import com.module.base.widgets.XListView;
import com.module.mall.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 黄双 on 2018/5/6.
 */

public class ProDetailActivity extends BaseActivity {

    private Banner banner;
    private LinearLayout layoutEvaluate, layMoreEva;
    private XListView lvIntroduce, lvImage, lvGrouping;
    private TextView tvIntroduce, tvEvaluate, tvService, tvPhone, tvBuy, tvGroup;
    private TextView tvName, tvPingedNum, tvPirce, tvOldPirce, tvFreight, tvInventory, tvCollection;

    private boolean isCollectioned;
    private ProModelDialog proModelDialog;
    private String forum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forum = getIntent().getStringExtra("forum");
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
        tvEvaluate = findViewById(R.id.pro_tv_evaluate_more);
        tvIntroduce = findViewById(R.id.pro_tv_introduce_more);
        layoutEvaluate = findViewById(R.id.pro_evaluate_container);
        layMoreEva = findViewById(R.id.moreeva_lay);

        tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        initBanner();
        initEvaluate();
        initGrouping();
        initProIntroduce();
        initImage();
    }

    @Override
    public void setListener() {
        super.setListener();
        tvBuy.setOnClickListener(this);
        tvPhone.setOnClickListener(this);
        tvGroup.setOnClickListener(this);
        tvService.setOnClickListener(this);
        tvEvaluate.setOnClickListener(this);
        tvIntroduce.setOnClickListener(this);
        tvCollection.setOnClickListener(this);
        layMoreEva.setOnClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent = null;
        int i = v.getId();
        if (i == R.id.pro_collection) {
            isCollectioned = !isCollectioned;
            //tvCollection.setText(isCollectioned ? "已收藏" : "收藏");
            tvCollection.setCompoundDrawablesWithIntrinsicBounds(0
                    , isCollectioned ? R.drawable.ic_heart_brown2 : R.drawable.ic_heart_brown1
                    , 0
                    , 0);
        }
        //更多评价
        else if (i == R.id.moreeva_lay) {
            startActivity(new Intent(this, MoreEvaluateActivity.class));
        } else if (i == R.id.pro_service) {

        } else if (i == R.id.pro_phone) {

        } else if (i == R.id.pro_buy) {
//            if (proModelDialog == null) {
//            }
            proModelDialog = new ProModelDialog(this);
            proModelDialog.show();
        }

        //跳转至订单详情 0元购
        else if (i == R.id.pro_group) {
            intent = new Intent(this, OrderConfirmActivity.class);
            intent.putExtra("forum", "zero");
            startActivity(intent);
        }
    }

    private void initBanner() {
        banner.setImages(Arrays.asList("123", "123"))
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    private void initEvaluate() {
        layoutEvaluate.removeAllViews();
        List<Integer> list = Arrays.asList(R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro);
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(list.get(i));
            layoutEvaluate.addView(imageView);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            lp.weight = 1;
            imageView.setLayoutParams(lp);
        }

    }

    private void initGrouping() {
        List<Integer> list = Arrays.asList(R.drawable.pro
                , R.drawable.pro_detail);
        CommonAdapter<Integer> adapter = new CommonAdapter<Integer>(this, list, R.layout.child_item_ping_list1) {
            @Override
            public void convert(int position, ViewHolder holder, Integer data) {
                RoundImageView imageView = holder.getItemView(R.id.item_img_head);
                imageView.setShapeType(1);

            }
        };
        lvGrouping.setAdapter(adapter);
    }

    private void initProIntroduce() {

        List<String> list = Arrays.asList(". 发起拼团，支付商品全款即可获得商品，无需等待拼团成功。"
                , ". 开团后，邀请指定人数参团，在规定时限内完成拼团名额， 团长即可获得商品全款返现。"
                , ". 首次开团的用户，在开团后，需为自己的电话账户充值200 元话费，拼团成功后和手机款一起返还。"
                , " . 若在规定时限内未完成拼团人数要求，则视为拼团失败，当 次拼团费用不予以返还。");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_pro_detail_introduce, list);
        lvIntroduce.setAdapter(adapter);
    }

    private void initImage() {
        List<Integer> list = Arrays.asList(R.drawable.pro
                , R.drawable.pro_detail
                , R.drawable.img_banner1
                , R.drawable.banner
                , R.drawable.img_banner2);
        CommonAdapter<Integer> adapter = new CommonAdapter<Integer>(this, list, R.layout.item_pro_detail_image) {
            @Override
            public void convert(int position, ViewHolder holder, Integer data) {
                holder.setImageResource(R.id.item_pro_image, data);
            }
        };
        lvImage.setAdapter(adapter);
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

    /**
     * 重写图片加载器
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide.with(context).load(path).into(imageView);
            imageView.setImageResource(R.drawable.pro_detail);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}
