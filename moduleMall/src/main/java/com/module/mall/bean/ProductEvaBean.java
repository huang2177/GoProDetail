package com.module.mall.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/19.
 */

public class ProductEvaBean {

    /**
     * code : string
     * data : [{"content":"string","evaTime":"2018-06-19T13:20:27.258Z","id":0,"imgurl":"string","imgurls":"string","nickname":"string","oid":0,"pid":0,"starCount":0,"uid":0}]
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
         * evaTime : 2018-06-19T13:20:27.258Z
         * id : 0
         * imgurl : string
         * imgurls : string
         * nickname : string
         * oid : 0
         * pid : 0
         * starCount : 0
         * uid : 0
         */

        private String content;
        private String evaTime;
        private int id;
        private String imgurl;
        private String imgurls;
        private String nickname;
        private int oid;
        private int pid;
        private int starCount;
        private int uid;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEvaTime() {
            return evaTime;
        }

        public void setEvaTime(String evaTime) {
            this.evaTime = evaTime;
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

        public String getImgurls() {
            return imgurls;
        }

        public void setImgurls(String imgurls) {
            this.imgurls = imgurls;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getStarCount() {
            return starCount;
        }

        public void setStarCount(int starCount) {
            this.starCount = starCount;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
