package com.module.mine.bean;

/**
 * Created by shibing on 18/5/22.
 */

public class UserInfoBean {

    /**
     * code : string
     * data : {"amount":0,"cardBank":"string","cardName":"string","cardNum":"string","childCount":0,"freezeAmount":0,"id":0,"imgurl":"string","mobile":"string","nickname":"string","password":"string","pid":0,"status":0,"totalAmount":0}
     * msg : string
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * amount : 0
         * cardBank : string
         * cardName : string
         * cardNum : string
         * childCount : 0
         * freezeAmount : 0
         * id : 0
         * imgurl : string
         * mobile : string
         * nickname : string
         * password : string
         * pid : 0
         * status : 0
         * totalAmount : 0
         */

        private int amount;
        private String cardBank;
        private String cardName;
        private String cardNum;
        private int childCount;
        private int freezeAmount;
        private int id;
        private String imgurl;
        private String mobile;
        private String nickname;
        private String password;
        private int pid;
        private int status;
        private int totalAmount;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCardBank() {
            return cardBank;
        }

        public void setCardBank(String cardBank) {
            this.cardBank = cardBank;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public int getChildCount() {
            return childCount;
        }

        public void setChildCount(int childCount) {
            this.childCount = childCount;
        }

        public int getFreezeAmount() {
            return freezeAmount;
        }

        public void setFreezeAmount(int freezeAmount) {
            this.freezeAmount = freezeAmount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }
    }
}
