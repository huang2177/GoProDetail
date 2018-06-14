package com.module.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.widgets.CommonAdapter;
import com.module.base.widgets.ViewHolder;
import com.module.base.widgets.dialog.XBottomDialog;
import com.module.base.widgets.XGridView;
import com.module.mall.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Huangshuang  2018/5/10 0010
 */

public class ProModelDialog extends XBottomDialog implements AdapterView.OnItemClickListener {

    private static final HashMap<Integer, ModelAdapter> adapterArray = new HashMap<>();

    private ImageView ivPro;
    private Button btnConfirm;
    private Drawable drawableBrown, drawableBlack;
    private XGridView gvColor, gvCapacity, gvVersion;
    private TextView tvName, tvPrice, tvInventory, tvColor;


    private int colorBrown, colorBlack;
    private String strColor, strCapacity, strVersion;


    public ProModelDialog(@NonNull Activity activity) {
        super(activity);

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
        List<String> colorTexts = Arrays.asList("白色", "黑色");
        strColor = colorTexts.get(0);
        ModelAdapter<String> colorAdapter = new ModelAdapter<>(colorTexts, R.id.model_gv_color);
        gvColor.setAdapter(colorAdapter);
    }

    private void initCapacity() {
        List<String> capacityTexts = Arrays.asList("64G", "128G", "256G");
        strCapacity = capacityTexts.get(0);
        ModelAdapter<String> capacityAdapter = new ModelAdapter<>(capacityTexts, R.id.model_gv_capacity);
        gvCapacity.setAdapter(capacityAdapter);

    }

    private void initVersion() {
        List<String> versionTexts = Arrays.asList("国行", "港行", "亚太行");
        strVersion = versionTexts.get(0);
        ModelAdapter<String> versionAdapter = new ModelAdapter<>(versionTexts, R.id.model_gv_veision);
        gvVersion.setAdapter(versionAdapter);
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
        Intent intent = new Intent(activity, OrderConfirmActivity.class);
        intent.putExtra("form", "whole");    //全款购买
        activity.startActivity(intent);
        dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapterArray.get(parent.getId()).changeColor(position);
        tvColor.setText(strColor + "  " + strCapacity + "  " + strVersion);
    }

    /**
     * GridView Adapter
     *
     * @param <T>
     */
    class ModelAdapter<T> extends CommonAdapter {

        private SparseArray<TextView> textViewArray;
        private int type;

        ModelAdapter(List data, int type) {
            super(activity, data, R.layout.item_dialog_model_layout);

            this.type = type;
            textViewArray = new SparseArray<TextView>();
            adapterArray.put(type, this);
        }

        void changeColor(int position) {
            for (int i = 0; i < textViewArray.size(); i++) {
                textViewArray.get(i).setTextColor(colorBlack);
                textViewArray.get(i).setBackground(drawableBlack);
                if (i == position) {
                    textViewArray.get(i).setTextColor(colorBrown);
                    textViewArray.get(i).setBackground(drawableBrown);
                }
            }

            if (type == R.id.model_gv_color) {
                strColor = textViewArray.get(position).getText().toString();
            } else if (type == R.id.model_gv_capacity) {
                strCapacity = textViewArray.get(position).getText().toString();
            } else {
                strVersion = textViewArray.get(position).getText().toString();
            }
        }

        @Override
        public void convert(int position, ViewHolder holder, Object data) {
            TextView textView = holder.getItemView(R.id.model_dialog_tv);
            textView.setText(data.toString());
            textViewArray.put(position, textView);
            if (position == 0) {
                textViewArray.get(0).setTextColor(colorBrown);
                textViewArray.get(0).setBackground(drawableBrown);
            } else {
                textViewArray.get(position).setTextColor(colorBlack);
                textViewArray.get(position).setBackground(drawableBlack);
            }
        }
    }
}
