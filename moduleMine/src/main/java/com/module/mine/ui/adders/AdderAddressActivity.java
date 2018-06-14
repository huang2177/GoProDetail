package com.module.mine.ui.adders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.model.IPickerViewData;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.base.utils.ToastUtil;
import com.module.mine.R;
import com.module.mine.bean.AddersBean;
import com.module.mine.ui.adders.AddressActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shibing on 18/5/8.
 */

public class AdderAddressActivity extends BaseActivity implements AddersView {


    EditText edName, edPhone, edDetailed;
    TextView tvCity;
    Button butSave;
    RelativeLayout rayCity;

    private String name;
    private String mobile;
    private String province;
    private String city;
    private String area;
    private String detail;
    private String uid;

    private SPUtil spUtil;
    private OptionsPickerView pickerView;
    private ArrayList<String> provinceList;
    private ArrayList<ArrayList<String>> cityList;
    private ArrayList<ArrayList<ArrayList<String>>> areaList;
    private String string;

    private AdderPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("收货信息管理");
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
        rayCity = findViewById(R.id.address_city_ray);
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
        rayCity.setOnClickListener(this);
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
        getEdit();
        //选择城市
        if (i == R.id.address_city_ray) {
            ChoiceCity();
        }
        //保存地址
        else if (i == R.id.address_save) {
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
    }


    private void ChoiceCity() {

        provinceList = new ArrayList<>();
        provinceList.add("qweqwe");
        provinceList.add("qweqwe");
        provinceList.add("qweqwe");
        provinceList.add("qweqwe");
        cityList = new ArrayList<ArrayList<String>>();


        pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

                string = provinceList.get(options1)
                        + cityList.get(options1).get(options2)
                        + areaList.get(options1).get(options2).get(options3);
                tvCity.setText(string);
            }
        }).build();
        pickerView.setPicker(provinceList, cityList, areaList);
        pickerView.show();
    }


    @Override
    public void showAdders(AddersBean addersBean) {

    }

    @Override
    public void OnAddersErr(String err) {

    }
}
