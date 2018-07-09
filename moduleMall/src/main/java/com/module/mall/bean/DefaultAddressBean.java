package com.module.mall.bean;

/**
 * Created by shibing on 18/7/2.
 */

public class DefaultAddressBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":1,"uid":6,"name":"拼爹测试","mobile":"18207182435","province":"湖北省","city":"武汉","area":"洪山区","detail":"QQ企鹅去我屋企饿饿问起我","isDefault":true}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * uid : 6
         * name : 拼爹测试
         * mobile : 18207182435
         * province : 湖北省
         * city : 武汉
         * area : 洪山区
         * detail : QQ企鹅去我屋企饿饿问起我
         * isDefault : true
         */

        private String id;
        private int uid;
        private String name;
        private String mobile;
        private String province;
        private String city;
        private String area;
        private String detail;
        private boolean isDefault;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public boolean isIsDefault() {
            return isDefault;
        }

        public void setIsDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }
    }
}
