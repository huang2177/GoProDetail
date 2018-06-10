package com.module.mine.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/9.
 */

public class AddersBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : [{"id":2,"uid":1,"name":"李鹏","mobile":"18655253157","province":"上海","city":"上海","area":"浦东新区","detail":"莲城镇街道","isDefault":true},{"id":6,"uid":6,"name":"梁12345678","mobile":"12345678","province":"湖北省","city":"黄石市","area":"你好","detail":"好啥呀慢慢磨合","isDefault":true},{"id":8,"uid":2,"name":"Suoxiaoxiao","mobile":"18217334471","province":"上海市","city":"上海市","area":"黄浦区","detail":"Sushi","isDefault":true},{"id":1,"uid":1,"name":"李鹏","mobile":"18655253157","province":"安徽省","city":"蚌埠市","area":"固镇县","detail":"莲城镇街道","isDefault":false},{"id":5,"uid":6,"name":"梁123","mobile":"18207182435","province":"上海市","city":"上海市","area":"长宁区","detail":"延安西路","isDefault":false},{"id":7,"uid":6,"name":"梁123456","mobile":"18207182435","province":"湖北省","city":"武汉市","area":"桥口区","detail":"秀沿路","isDefault":false}]
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
         * id : 2
         * uid : 1
         * name : 李鹏
         * mobile : 18655253157
         * province : 上海
         * city : 上海
         * area : 浦东新区
         * detail : 莲城镇街道
         * isDefault : true
         */

        private int id;
        private int uid;
        private String name;
        private String mobile;
        private String province;
        private String city;
        private String area;
        private String detail;
        private boolean isDefault;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
