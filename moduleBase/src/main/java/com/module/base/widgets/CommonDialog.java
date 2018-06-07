package com.module.base.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.module.base.R;

/**
 * @author Huangshuang  2018/3/14 0014
 */

public class CommonDialog extends Dialog implements View.OnClickListener
        , DialogInterface.OnDismissListener {

    public static final int OUTSIDE = 1, CONFIRM = 0, CANCEL = -1;
    private int type;
    private Context mContext;
    private DialogClickListener listener;

    private TextView tvTitle, tvMessage;
    private Button btnCancel, btnConfirm;

    private CommonDialog(Context mContext, Builder builder) {
        super(mContext);
        this.mContext = mContext;
        init(builder);
        setListener();
    }

    /**
     * 初始化dialog
     *
     * @param builder
     */
    private void init(Builder builder) {
        type = builder.type;
        listener = builder.listener;

        setOnDismissListener(this);
        setCancelable(builder.cancelable);
        setCanceledOnTouchOutside(builder.canceledOnTouchOutside);
        setContentView(View.inflate(mContext, R.layout.dialog_common, null));

        setDialogWindowAttr(mContext, builder);

        tvTitle = findViewById(R.id.dialog_title);
        btnCancel = findViewById(R.id.btn_cancle);
        btnConfirm = findViewById(R.id.btn_confirm);
        tvMessage = findViewById(R.id.dialog_message);

        setTitle(builder.title);
        setMessage(builder.message);
    }

    /**
     * 设置dialog属性
     */
    private void setDialogWindowAttr(Context mContext, Builder builder) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Window window = getWindow();

        if (window != null && wm != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(outMetrics);
//            window.setWindowAnimations(R.style.commonDialogStyle);
            int width = outMetrics.widthPixels;
            int height = outMetrics.heightPixels;
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = Gravity.CENTER;
            lp.width = (int) ((width * 2) / 2.4);
//            lp.height = (int) (height / 3.5);
            lp.height = lp.WRAP_CONTENT;
            window.setAttributes(lp);
        }
    }

    /**
     * 设置监听
     *
     * @return
     */
    private void setListener() {
        if (btnCancel != null) {
            btnCancel.setOnClickListener(this);
            btnConfirm.setOnClickListener(this);
        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    /**
     * 设置显示内容
     *
     * @param message
     */
    public void setMessage(String message) {
        if (tvMessage != null) {
            tvMessage.setText(message);
        }
    }

    @Override
    public void onClick(View v) {
        dismiss();
        if (listener != null) {
            int flag = v.getId() == R.id.btn_confirm
                    ? CONFIRM
                    : CANCEL;
            listener.dialogClick(flag, type);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (listener != null) {
            listener.dialogClick(OUTSIDE, type);
        }
    }

    public interface DialogClickListener {
        /**
         * 点击回调
         *
         * @param flag 是点击确定（0）还是取消（-1）按钮 或者 点击空白（1）
         * @param type 调用者传的类型
         */
        void dialogClick(int flag, int type);
    }

    public static class Builder {
        private int type;
        private Context mContext;
        private boolean cancelable;
        private String title, message;
        private DialogClickListener listener;
        private boolean canceledOnTouchOutside;

        public Builder() {
            title = "提示信息";
            cancelable = true;
            canceledOnTouchOutside = true;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder context(Context context) {
            this.mContext = context;
            return this;
        }


        public Builder cancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.canceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder listener(DialogClickListener listener) {
            this.listener = listener;
            return this;
        }

        public CommonDialog build() {
            return new CommonDialog(mContext, this);
        }
    }
}
