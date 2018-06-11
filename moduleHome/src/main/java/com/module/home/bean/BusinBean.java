package com.module.home.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/10.
 */

public class BusinBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : [{"id":1,"city":"上海","address":"上海市浦东新区浦东南路321号","shopName":"浦东南路营业厅","tel":"021-10214413","imgurl":"pintuan-admin/2018-05-06/682ea384136142a2b78cb466d1820ee0.jpg","lng":121.713507,"lat":31.194598},{"id":2,"city":"上海","address":"上海浦东新区张杨路838号华都大厦3层 ","shopName":"陆家嘴营业厅","tel":"021-10214413","imgurl":"pintuan-admin/2018-05-06/682ea384136142a2b78cb466d1820ee0.jpg","lng":121.530001,"lat":31.234592}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * city : 上海
         * address : 上海市浦东新区浦东南路321号
         * shopName : 浦东南路营业厅
         * tel : 021-10214413
         * imgurl : pintuan-admin/2018-05-06/682ea384136142a2b78cb466d1820ee0.jpg
         * lng : 121.713507
         * lat : 31.194598
         */

        private int id;
        private String city;
        private String address;
        private String shopName;
        private String tel;
        private String imgurl;
        private double lng;
        private double lat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }
}
