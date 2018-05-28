package com.module.mine.bean;

import java.util.List;

/**
 * Created by shibing on 18/5/27.
 */

public class TuanCouponBean {


    /**
     * code : string
     * data : [{"fromId":0,"fromName":"string","fromTime":"2018-05-27T07:45:38.842Z","id":0,"isSend":true,"isUse":true,"orderId":0,"title":"string","toName":"string","toTime":"2018-05-27T07:45:38.842Z","toUid":0,"tuanNum":"string","uid":0,"useTime":"2018-05-27T07:45:38.842Z"}]
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
         * fromId : 0
         * fromName : string
         * fromTime : 2018-05-27T07:45:38.842Z
         * id : 0
         * isSend : true
         * isUse : true
         * orderId : 0
         * title : string
         * toName : string
         * toTime : 2018-05-27T07:45:38.842Z
         * toUid : 0
         * tuanNum : string
         * uid : 0
         * useTime : 2018-05-27T07:45:38.842Z
         */

        private int fromId;
        private String fromName;
        private String fromTime;
        private int id;
        private boolean isSend;
        private boolean isUse;
        private int orderId;
        private String title;
        private String toName;
        private String toTime;
        private int toUid;
        private String tuanNum;
        private int uid;
        private String useTime;

        public int getFromId() {
            return fromId;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public String getFromTime() {
            return fromTime;
        }

        public void setFromTime(String fromTime) {
            this.fromTime = fromTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsSend() {
            return isSend;
        }

        public void setIsSend(boolean isSend) {
            this.isSend = isSend;
        }

        public boolean isIsUse() {
            return isUse;
        }

        public void setIsUse(boolean isUse) {
            this.isUse = isUse;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getToName() {
            return toName;
        }

        public void setToName(String toName) {
            this.toName = toName;
        }

        public String getToTime() {
            return toTime;
        }

        public void setToTime(String toTime) {
            this.toTime = toTime;
        }

        public int getToUid() {
            return toUid;
        }

        public void setToUid(int toUid) {
            this.toUid = toUid;
        }

        public String getTuanNum() {
            return tuanNum;
        }

        public void setTuanNum(String tuanNum) {
            this.tuanNum = tuanNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUseTime() {
            return useTime;
        }

        public void setUseTime(String useTime) {
            this.useTime = useTime;
        }
    }
}
