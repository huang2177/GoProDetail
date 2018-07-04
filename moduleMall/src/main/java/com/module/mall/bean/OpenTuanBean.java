package com.module.mall.bean;

/**
 * Created by shibing on 18/7/3.
 */

public class OpenTuanBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":11,"uid":6,"nickname":null,"imgurl":null,"pid":1,"catagory":"1","endTime":"2019-07-03 15:02:49","needOrderNum":12,"joinCount":0,"success":false,"type":0,"isPublic":true,"couponId":11,"amount":0,"commission":0,"orderId":0,"joins":null,"product":null,"normstr":""}
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
         * id : 11
         * uid : 6
         * nickname : null
         * imgurl : null
         * pid : 1
         * catagory : 1
         * endTime : 2019-07-03 15:02:49
         * needOrderNum : 12
         * joinCount : 0
         * success : false
         * type : 0
         * isPublic : true
         * couponId : 11
         * amount : 0
         * commission : 0
         * orderId : 0
         * joins : null
         * product : null
         * normstr :
         */

        private int id;
        private int uid;
        private Object nickname;
        private Object imgurl;
        private int pid;
        private String catagory;
        private String endTime;
        private int needOrderNum;
        private int joinCount;
        private boolean success;
        private int type;
        private boolean isPublic;
        private int couponId;
        private int amount;
        private int commission;
        private int orderId;
        private Object joins;
        private Object product;
        private String normstr;

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

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public Object getImgurl() {
            return imgurl;
        }

        public void setImgurl(Object imgurl) {
            this.imgurl = imgurl;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getNeedOrderNum() {
            return needOrderNum;
        }

        public void setNeedOrderNum(int needOrderNum) {
            this.needOrderNum = needOrderNum;
        }

        public int getJoinCount() {
            return joinCount;
        }

        public void setJoinCount(int joinCount) {
            this.joinCount = joinCount;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isIsPublic() {
            return isPublic;
        }

        public void setIsPublic(boolean isPublic) {
            this.isPublic = isPublic;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public Object getJoins() {
            return joins;
        }

        public void setJoins(Object joins) {
            this.joins = joins;
        }

        public Object getProduct() {
            return product;
        }

        public void setProduct(Object product) {
            this.product = product;
        }

        public String getNormstr() {
            return normstr;
        }

        public void setNormstr(String normstr) {
            this.normstr = normstr;
        }
    }
}
