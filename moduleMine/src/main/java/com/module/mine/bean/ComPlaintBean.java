package com.module.mine.bean;

/**
 * Created by shibing on 18/6/9.
 */

public class ComPlaintBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":5,"uid":6,"name":"拼爹测试","mobile":"18207182435","content":"拼爹测试拼爹测试拼爹测试拼爹测试"}
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
         * id : 5
         * uid : 6
         * name : 拼爹测试
         * mobile : 18207182435
         * content : 拼爹测试拼爹测试拼爹测试拼爹测试
         */

        private int id;
        private int uid;
        private String name;
        private String mobile;
        private String content;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
