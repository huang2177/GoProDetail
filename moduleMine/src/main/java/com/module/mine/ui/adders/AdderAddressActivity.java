package com.module.mine.ui.adders;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.bean.AddersBean;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shibing on 18/5/8.
 */

public class AdderAddressActivity extends BaseActivity implements AddersView {


    EditText edName, edPhone, edDetailed;
    TextView tvCity;
    Button butSave;

    private String name;
    private String mobile;
    private String province;
    private String city;
    private String area;
    private String detail;
    private String uid;

    private SPUtil spUtil;
    private String string;

    private AdderPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("收货信息管理").rightImageRes(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_addaddress;
    }

    @Override
    public void initView() {
        edName = findViewById(R.id.address_name_ed);
        edPhone = findViewById(R.id.adress_phone_ed);
        edDetailed = findViewById(R.id.address_detailed_ed);
        tvCity = findViewById(R.id.address_city_tv);
        butSave = findViewById(R.id.address_save);

        uid = SPUtil.getInstance(this).getString(Constant.USERID);
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new AdderPresenter();
        return presenter;
    }


    @Override
    public void setListener() {
        super.setListener();
        tvCity.setOnClickListener(this);
        butSave.setOnClickListener(this);
    }


    private void getEdit() {
        name = edName.getText().toString();
        mobile = edPhone.getText().toString();
        detail = edDetailed.getText().toString();
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.address_city_tv) {
            choiceCity();
        } else if (i == R.id.address_save) {
            getEdit();
            saveAddInfo();
        }
    }

    /**
     * 保存地址
     */
    private void saveAddInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("name", name);
        map.put("mobile", mobile);
        map.put("province", "上海市");
        map.put("city", "上海市");
        map.put("area", "浦东新区");
        map.put("detail", detail);

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(mobile)
                && TextUtils.isEmpty(string) && TextUtils.isEmpty(detail)) {
            ToastUtil.show(this, "信息不完整");
            return;
        }
        presenter.getAddAdderss(map);
    }

    /**
     * 选择城市
     */
    private void choiceCity() {
//        CityConfig.WheelType mWheelType = CityConfig.WheelType.PRO_CITY_DIS;
//        CityPickerView mCityPickerView = new CityPickerView();
//        mCityPickerView.init(this);
//
//
//        CityConfig cityConfig = new CityConfig.Builder()
//                .title("选择城市")//标题
//                .titleTextSize(18)//标题文字大小
//                .titleTextColor("#585858")//标题文字颜  色
//                .titleBackgroundColor("#E9E9E9")//标题栏背景色
//                .confirTextColor("#585858")//确认按钮文字颜色
//                .confirmText("ok")//确认按钮文字
//                .confirmTextSize(16)//确认按钮文字大小
//                .cancelTextColor("#585858")//取消按钮文字颜色
//                .cancelText("cancel")//取消按钮文字
//                .cancelTextSize(16)//取消按钮文字大小
//                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)//显示类，只显示省份一级，显示省市两级还是显示省市区三级
//                .showBackground(true)//是否显示半透明背景
//                .visibleItemsCount(7)//显示item的数量
//                .province("浙江省")//默认显示的省份
//                .city("杭州市")//默认显示省份下面的城市
//                .district("滨江区")//默认显示省市下面的区县数据
//                .provinceCyclic(true)//省份滚轮是否可以循环滚动
//                .cityCyclic(true)//城市滚轮是否可以循环滚动
//                .districtCyclic(true)//区县滚轮是否循环滚动
//                .drawShadows(false)//滚轮不显示模糊效果
//                .setLineColor("#03a9f4")//中间横线的颜色
//                .setLineHeigh(5)//中间横线的高度
//                .setShowGAT(true)//是否显示港澳台数据，默认不显示
//                .build();
//
//        //设置自定义的属性配置
//        mCityPickerView.setConfig(cityConfig);
//        mCityPickerView.showCityPicker();



    }

    @Override
    public void showAdders(AddersBean addersBean) {

    }

    @Override
    public void OnAddersErr(String err) {

    }
}
