package com.module.mall.ui;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.base.BaseActivity;
import com.module.base.base.BasePresenter;
import com.module.mall.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;

/**
 * Created by 黄双 on 2018/5/6.
 */

public class ProDetailActivity extends BaseActivity {

    private Banner banner;
    private TextView tvName, tvPingedNum, tvPirce, tvOldPirce, tvFreight, tvInventory, tvCollection;

    private boolean isCollectioned;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pro_detail;
    }

    @Override
    public void initView() {
        tvName = findViewById(R.id.pro_name);
        tvPirce = findViewById(R.id.pro_pirce);
        banner = findViewById(R.id.pro_banner);
        tvFreight = findViewById(R.id.pro_freight);
        tvOldPirce = findViewById(R.id.pro_old_pirce);
        tvInventory = findViewById(R.id.pro_inventory);
        tvPingedNum = findViewById(R.id.pro_pinged_num);
        tvCollection = findViewById(R.id.pro_collection);

        tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        initBanner();
    }

    @Override
    public void setListener() {
        super.setListener();
        tvCollection.setOnClickListener(this);
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
        }
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    private void initBanner() {
        banner.setImages(Arrays.asList("123", "123"))
                .setImageLoader(new GlideImageLoader())
                .start();
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

    @Override
    public boolean isUseDart() {
        return false;
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
}
