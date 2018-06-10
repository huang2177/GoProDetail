package com.module.mine.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/9.
 */

public class HelpBean {


    /**
     * code : string
     * data : [{"content":"string","createTime":"2018-06-09T07:23:03.693Z","id":0,"imgurl":"string","title":"string","type":0,"videoImgurl":"string"}]
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
         * createTime : 2018-06-09T07:23:03.693Z
         * id : 0
         * imgurl : string
         * title : string
         * type : 0
         * videoImgurl : string
         */

        private String content;
        private String createTime;
        private String id;
        private String imgurl;
        private String title;
        private int type;
        private String videoImgurl;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getVideoImgurl() {
            return videoImgurl;
        }

        public void setVideoImgurl(String videoImgurl) {
            this.videoImgurl = videoImgurl;
        }
    }
}
