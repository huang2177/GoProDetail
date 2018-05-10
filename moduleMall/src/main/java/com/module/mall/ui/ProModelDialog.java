package com.module.mall.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.widgets.CommonAdapter;
import com.module.base.widgets.ViewHolder;
import com.module.base.widgets.XBottomDialog;
import com.module.base.widgets.XGridView;
import com.module.mall.R;

import java.util.Arrays;
import java.util.List;

/**
 * @author Huangshuang  2018/5/10 0010
 */

public class ProModelDialog extends XBottomDialog implements AdapterView.OnItemClickListener {

    private ImageView ivPro;
    private Button btnConfirm;
    private XGridView gvColor, gvCapacity, gvVersion;
    private TextView tvName, tvPrice, tvInventory, tvColor;

    private int colorBrown, colorBlack;
    private Drawable drawableBrown, drawableBlack;

    private CommonAdapter<String> colorAdapter;
    private CommonAdapter<String> versionAdapter;
    private CommonAdapter<String> capacityAdapter;

    private SparseArray<TextView> colorViews;
    private SparseArray<TextView> versionViews;
    private SparseArray<TextView> capacityViews;

    private SparseArray<SparseArray<TextView>> views;

    public ProModelDialog(@NonNull Activity activity) {
        super(activity);

        views = new SparseArray<>();
        colorViews = new SparseArray<>();
        versionViews = new SparseArray<>();
        capacityViews = new SparseArray<>();

        colorBrown = ContextCompat.getColor(activity, R.color.colorBrown);
        colorBlack = ContextCompat.getColor(activity, R.color.colorLittleBlack1);
        drawableBrown = ContextCompat.getDrawable(activity, R.drawable.shape_brown);
        drawableBlack = ContextCompat.getDrawable(activity, R.drawable.shape_gray0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_pro_model_layout;
    }

    @Override
    protected void initView() {
        ivPro = findViewById(R.id.model_img);
        tvName = findViewById(R.id.model_name);
        tvPrice = findViewById(R.id.model_price);
        tvColor = findViewById(R.id.model_color);
        btnConfirm = findViewById(R.id.model_btn);
        tvInventory = findViewById(R.id.model_inventory);

        gvColor = findViewById(R.id.model_gv_color);
        gvVersion = findViewById(R.id.model_gv_veision);
        gvCapacity = findViewById(R.id.model_gv_capacity);

        initColor();
        initCapacity();
        initVersion();

    }

    private void initColor() {
        List<String> texts = Arrays.asList("白色", "黑色");
        colorAdapter = new CommonAdapter<String>(activity, texts, R.layout.item_dialog_model_layout) {
            @Override
            public void convert(int position, ViewHolder holder, String data) {
                initTextView(1, position, holder, data);
            }

            public void changeColor(int position) {
                for (int i = 0; i < colorViews.size(); i++) {
                    colorViews.get(i).setTextColor(colorBlack);
                    colorViews.get(i).setBackground(drawableBlack);
                    if (i == position) {
                        colorViews.get(i).setTextColor(colorBrown);
                        colorViews.get(i).setBackground(drawableBrown);
                    }
                }
            }
        };
        gvColor.setAdapter(colorAdapter);
    }

    private void initCapacity() {
        List<String> texts = Arrays.asList("64G", "128G", "256G");
        capacityAdapter = new CommonAdapter<String>(activity, texts, R.layout.item_dialog_model_layout) {
            @Override
            public void convert(int position, ViewHolder holder, String data) {
                //initTextView(2, position, holder, data);
            }
        };
        gvCapacity.setAdapter(capacityAdapter);
    }

    private void initVersion() {
        List<String> texts = Arrays.asList("国行", "港行", "亚太行");
        versionAdapter = new CommonAdapter<String>(activity, texts, R.layout.item_dialog_model_layout) {
            @Override
            public void convert(int position, ViewHolder holder, String data) {
                //initTextView(3, position, holder, data);
            }


        };
        gvVersion.setAdapter(versionAdapter);

    }

    private void initTextView(int type, int position, ViewHolder holder, String data) {
        TextView textView = holder.getItemView(R.id.model_dialog_tv);
        textView.setText(data);
        colorViews.put(position, textView);
        if (position == 0) {
            colorViews.get(0).setTextColor(colorBrown);
            colorViews.get(0).setBackground(drawableBrown);
        } else {
            colorViews.get(position).setTextColor(colorBlack);
            colorViews.get(position).setBackground(drawableBlack);
        }
    }

    @Override
    protected void setListener() {
        btnConfirm.setOnClickListener(this);

        gvColor.setOnItemClickListener(this);
        gvVersion.setOnItemClickListener(this);
        gvCapacity.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.model_btn) {

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int i = parent.getId();
        if (i == R.id.model_gv_color) {
            changeColor(position);
        } else if (i == R.id.model_gv_veision) {

        } else if (i == R.id.model_gv_capacity) {

        }
    }

    public void changeColor(int position) {
        for (int i = 0; i < colorViews.size(); i++) {
            colorViews.get(i).setTextColor(colorBlack);
            colorViews.get(i).setBackground(drawableBlack);
            if (i == position) {
                colorViews.get(i).setTextColor(colorBrown);
                colorViews.get(i).setBackground(drawableBrown);
            }
        }
    }
}
