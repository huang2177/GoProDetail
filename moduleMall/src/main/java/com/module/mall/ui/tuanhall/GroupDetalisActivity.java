package com.module.mall.ui.tuanhall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.pouduct.ProductBean;
import com.module.base.widgets.RoundImageView;
import com.module.base.widgets.XGridView;
import com.module.mall.R;
import com.module.mall.adpter.MallListAdpter;
import com.module.mall.adpter.PingPopleAdapter;
import com.module.mall.bean.TuanDetalisBean;
import com.module.mall.ui.confirmorder.OrderConfirmActivity;
import com.module.mall.ui.prodetails.ProDetailActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/6/2.
 * <p>
 * 拼团大厅详情
 */

public class GroupDetalisActivity extends BaseActivity implements OnItemClickListener, TuanDetalisView {


    //商品模块
    private ImageView imagePor;
    private TextView tvPorName, tvPorPicre, tvPorColor;
    //开团模块
    private RoundImageView roundImageTz;
    private TextView tvTuanz, tvPople;
    private XGridView gridView;
    private Button button;
    private RecyclerView recyclerView;


    //  开团适配器
    private PingPopleAdapter popleAdapter;
    private TuanDetalisPresenter presenter;

    //商品适配器
    private MallListAdpter porductAdapter;

    private String pid;
    private List<ProductBean.DataBean> dataBeanList;
    private String type;
    private TuanDetalisBean.DataBean dataBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("拼团详情");
        pid = getIntent().getStringExtra(Constant.PORDUCTID);
        presenter.TuanDetalis(pid);
        initPople();
        initPorduct();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_groupdetalis;
    }


    @Override
    public BasePresenter createPresenter() {
        presenter = new TuanDetalisPresenter();
        return presenter;
    }

    @Override
    public void initView() {
        //商品模块
        imagePor = findViewById(R.id.groupdetalis_img_pro);
        tvPorName = findViewById(R.id.groupdetalis_tv_pro_name);
        tvPorPicre = findViewById(R.id.groupdetalis_tv_pirce);
        tvPorColor = findViewById(R.id.groupdetalis_tv_color);
        //拼团模块
        roundImageTz = findViewById(R.id.groupdetalis_tz_iamg);
        tvTuanz = findViewById(R.id.groupdetalis_tz_tv);
        tvPople = findViewById(R.id.groupdetalis_pople_tv);
        gridView = findViewById(R.id.groupdetalis_gridview);
        button = findViewById(R.id.groupdetalis_but);
        recyclerView = findViewById(R.id.groupdetalis_recyler);
    }


    private void initPorduct() {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);


    }


    private List<Integer> getData() {
        return Arrays.asList(R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro
                , R.drawable.pro);
    }


    @Override
    public void setListener() {
        super.setListener();
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.groupdetalis_but) {
            Intent intent = new Intent(this, OrderConfirmActivity.class);
            intent.putExtra(Constant.PORDUCT_TUAN_TYPE, "JoinTuan");             //参团
            intent.putExtra(Constant.PORDUCT_TITLE, dataBean.getProduct().getTitle());
            intent.putExtra(Constant.PORDUCT_IMAGR, dataBean.getProduct().getImgurl());
            intent.putExtra(Constant.PORDUCT_PIC, dataBean.getProduct().getAmount() + "");
            intent.putExtra(Constant.PORDUCT_TUAN_PIC, dataBean.getProduct().getTuanAmount() + "");
            intent.putExtra(Constant.PORDUCTID, dataBean.getProduct().getId() + "");
            intent.putExtra(Constant.PORDUCT_CLORO, dataBean.getNormstr());
            intent.putExtra(Constant.PORDUCT_TYPE, dataBean.getType());
            intent.putExtra(Constant.TUAN_ID,dataBean.getJoinCount());
            startActivity(intent);
        }
    }


    //团详情
    @Override
    public void showTuanDetalis(TuanDetalisBean tuanDetalisBean) {
        dataBean = tuanDetalisBean.getData();


        GlideManager.loadImage(this
                , Constant.IMAGE_HOST + tuanDetalisBean.getData().getProduct().getImgurl()
                , imagePor);
        tvPorName.setText(tuanDetalisBean.getData().getProduct().getTitle());
        tvPorPicre.setText("¥" + tuanDetalisBean.getData().getProduct().getAmount());
        tvPorColor.setText(tuanDetalisBean.getData().getNormstr());
        tvPople.setText("还差" + tuanDetalisBean.getData().getNeedOrderNum() + "人成团"
                + ",剩余" + tuanDetalisBean.getData().getEndTime());
        button.setText("¥" + tuanDetalisBean.getData().getProduct().getAmount() + "立即参团");
        presenter.TuanDetalisProduct(type, tuanDetalisBean.getData().getCatagory());

    }


    private void initPople() {
        popleAdapter = new PingPopleAdapter(this, getData());
        gridView.setAdapter(popleAdapter);
    }


    @Override
    public void showTuanDetalisProduct(List<ProductBean.DataBean> productBean) {
        dataBeanList = productBean;
        porductAdapter = new MallListAdpter(this, productBean);
        porductAdapter.addOnItemClickListener(this);
        recyclerView.setAdapter(porductAdapter);
    }


    /**
     * 商品监听事件
     *
     * @param position
     * @param type
     */
    @Override
    public void onItemClick(int position, int type) {
        Intent intent = new Intent(this, ProDetailActivity.class);
        intent.putExtra(Constant.PORDUCTID, dataBeanList.get(position).getId() + "");
        startActivity(intent);
    }
}
