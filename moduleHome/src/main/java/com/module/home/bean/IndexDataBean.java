package com.module.home.bean;

public class IndexDataBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":1,"regsterCount":1861,"pintuanCount":62,"successCount":60}
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
         * regsterCount : 1861
         * pintuanCount : 62
         * successCount : 60
         */

        private int id;
        private int regsterCount;
        private int pintuanCount;
        private int successCount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRegsterCount() {
            return regsterCount;
        }

        public void setRegsterCount(int regsterCount) {
            this.regsterCount = regsterCount;
        }

        public int getPintuanCount() {
            return pintuanCount;
        }

        public void setPintuanCount(int pintuanCount) {
            this.pintuanCount = pintuanCount;
        }

        public int getSuccessCount() {
            return successCount;
        }

        public void setSuccessCount(int successCount) {
            this.successCount = successCount;
        }
    }
}
