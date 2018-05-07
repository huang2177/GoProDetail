package com.module.mall.ui;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
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
    private XListView lvIntroduce, lvImage;
    private TextView tvIntroduce, tvEvaluate;
    private TextView tvName, tvPingedNum, tvPirce, tvOldPirce, tvFreight, tvInventory, tvCollection;

    private boolean isCollectioned;

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
        tvName = findViewById(R.id.pro_name);
        tvPirce = findViewById(R.id.pro_pirce);
        banner = findViewById(R.id.pro_banner);
        lvImage = findViewById(R.id.pro_image_lv);
        tvFreight = findViewById(R.id.pro_freight);
        tvOldPirce = findViewById(R.id.pro_old_pirce);
        tvInventory = findViewById(R.id.pro_inventory);
        tvPingedNum = findViewById(R.id.pro_pinged_num);
        tvCollection = findViewById(R.id.pro_collection);
        lvIntroduce = findViewById(R.id.pro_introduce_lv);
        tvEvaluate = findViewById(R.id.pro_tv_evaluate_more);
        tvIntroduce = findViewById(R.id.pro_tv_introduce_more);

        tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        initBanner();
        initProIntroduce();
        initImage();
    }

    @Override
    public void setListener() {
        super.setListener();
        tvEvaluate.setOnClickListener(this);
        tvIntroduce.setOnClickListener(this);
        tvCollection.setOnClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.pro_collection) {
            isCollectioned = !isCollectioned;
            tvCollection.setText(isCollectioned ? "已收藏" : "收藏");
            tvCollection.setCompoundDrawablesWithIntrinsicBounds(0
                    , isCollectioned ? R.drawable.ic_heart_brown2 : R.drawable.ic_heart_brown1
                    , 0
                    , 0);
        } else if (i == R.id.pro_tv_evaluate_more) {

        } else if (i == R.id.pro_tv_introduce_more) {

        }
    }

    private void initBanner() {
        banner.setImages(Arrays.asList("123", "123"))
                .setImageLoader(new GlideImageLoader())
                .start();
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
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, R.layout.item_pro_detail_image, list);
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
