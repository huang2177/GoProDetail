package com.module.mall.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.base.widgets.CommonAdapter;
import com.module.base.widgets.ViewHolder;
import com.module.base.widgets.XGridView;
import com.module.mall.R;
import com.module.mall.bean.ProDetailsBean;

import java.util.HashMap;
import java.util.List;

/**
 * Des:规格dialog listview Adapter
 * Created by 黄双 on 2018/6/24.
 */

public class ModeDialogAdapter extends RecyclerView.Adapter<ModeDialogAdapter.MyViewHolder> {
    private static final HashMap<Integer, ModelAdapter> adapterArray = new HashMap<>();
    private final List<ProDetailsBean.DataBean.NormsBean> data;
    private int colorBrown, colorBlack;
    private Drawable drawableBrown, drawableBlack;
    private Context mContext;


    public ModeDialogAdapter(Context context, List<ProDetailsBean.DataBean.NormsBean> data) {
        this.mContext = context;
        this.data = data;
        colorBrown = ContextCompat.getColor(context, R.color.colorBrown);
        colorBlack = ContextCompat.getColor(context, R.color.colorLittleBlack1);
        drawableBrown = ContextCompat.getDrawable(context, R.drawable.shape_brown);
        drawableBlack = ContextCompat.getDrawable(context, R.drawable.shape_gray0);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dialog_model_lv_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(data.get(position).getName());
        holder.xGridView.setAdapter(new ModelAdapter(this.mContext, data.get(position).getItems(), position));
    }


    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public XGridView xGridView;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            xGridView = itemView.findViewById(R.id.item_gv);
        }
    }

    /**
     * GridView Adapter
     */
    class ModelAdapter extends CommonAdapter<ProDetailsBean.DataBean.NormsBean.ItemsBean> {

        private SparseArray<TextView> textViewArray;
        private int type;

        ModelAdapter(Context context, List<ProDetailsBean.DataBean.NormsBean.ItemsBean> data, int type) {
            super(context, data, R.layout.item_dialog_model_layout);

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

//            if (type == R.id.model_gv_color) {
//                strColor = textViewArray.get(position).getText().toString();
//            } else if (type == R.id.model_gv_capacity) {
//                strCapacity = textViewArray.get(position).getText().toString();
//            } else {
//                strVersion = textViewArray.get(position).getText().toString();
//            }
        }


        @Override
        public void convert(int position, ViewHolder holder, ProDetailsBean.DataBean.NormsBean.ItemsBean data) {
            TextView textView = holder.getItemView(R.id.model_dialog_tv);
            textView.setText(data.getItemName());
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
