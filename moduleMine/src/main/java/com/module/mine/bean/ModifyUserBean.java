package com.module.mine.bean;

/**
 * Created by shibing on 18/6/7.
 */

public class ModifyUserBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":6,"nickname":"buhaoya","imgurl":null,"mobile":null,"password":null,"cardNum":null,"cardName":null,"cardBank":null,"amount":null,"freezeAmount":null,"totalAmount":null,"pid":null,"childCount":null,"status":null,"requestCode":null}
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
         * id : 6
         * nickname : buhaoya
         * imgurl : null
         * mobile : null
         * password : null
         * cardNum : null
         * cardName : null
         * cardBank : null
         * amount : null
         * freezeAmount : null
         * totalAmount : null
         * pid : null
         * childCount : null
         * status : null
         * requestCode : null
         */

        private int id;
        private String nickname;
        private String imgurl;
        private String mobile;
        private String password;
        private String cardNum;
        private String cardName;
        private String cardBank;
        private String amount;
        private String freezeAmount;
        private String totalAmount;
        private String pid;
        private String childCount;
        private String status;
        private String requestCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardBank() {
            return cardBank;
        }

        public void setCardBank(String cardBank) {
            this.cardBank = cardBank;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFreezeAmount() {
            return freezeAmount;
        }

        public void setFreezeAmount(String freezeAmount) {
            this.freezeAmount = freezeAmount;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getChildCount() {
            return childCount;
        }

        public void setChildCount(String childCount) {
            this.childCount = childCount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRequestCode() {
            return requestCode;
        }

        public void setRequestCode(String requestCode) {
            this.requestCode = requestCode;
        }
    }
}
