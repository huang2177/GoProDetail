package com.module.base.pouduct;

import java.util.List;

/**
 * Created by shibing on 18/6/14.
 */

public class ProductTypeBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : [{"id":3,"catagory":"项链","type":1},{"id":4,"catagory":"戒指","type":1},{"id":5,"catagory":"耳环","type":1}]
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
         * id : 3
         * catagory : 项链
         * type : 1
         */

        private int id;
        private String catagory;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
