package com.module.mine.bean;

import java.util.List;

/**
 * Created by shibing on 18/5/26.
 */

public class BlankNumBean {


    /**
     * code : string
     * data : [{"amount":0,"createTime":"2018-05-26T13:03:21.788Z","id":0,"income":true,"title":"string","uid":0}]
     * msg : string
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
         * amount : 0
         * createTime : 2018-05-26T13:03:21.788Z
         * id : 0
         * income : true
         * title : string
         * uid : 0
         */

        private String amount;
        private String createTime;
        private int id;
        private boolean income;
        private String title;
        private int uid;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIncome() {
            return income;
        }

        public void setIncome(boolean income) {
            this.income = income;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
