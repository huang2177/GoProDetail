package com.module.mine.bean;

import java.util.List;

/**
 * Created by shibing on 18/5/26.
 */

public class MessAgeBean {


    /**
     * code : string
     * data : [{"content":"string","createTime":"2018-05-26T13:03:21.826Z","id":0,"read":true,"title":"string","type":"string","uid":0}]
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
         * content : string
         * createTime : 2018-05-26T13:03:21.826Z
         * id : 0
         * read : true
         * title : string
         * type : string
         * uid : 0
         */

        private String content;
        private String createTime;
        private int id;
        private boolean read;
        private String title;
        private String type;
        private int uid;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public boolean isRead() {
            return read;
        }

        public void setRead(boolean read) {
            this.read = read;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
