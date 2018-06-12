package com.module.home.bean;

import java.util.List;

public class BannerBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : [{"id":1,"imgurl":"pintuan-admin/2018-05-06/86c9572e485f4a389faaaa3432831a8d.jpg","url":"http://www.baidu.com","type":1},{"id":2,"imgurl":"pintuan-admin/2018-05-06/dc2cb183deeb4d8cb77414bdb0c736e8.jpg","url":"1","type":0}]
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
         * id : 1
         * imgurl : pintuan-admin/2018-05-06/86c9572e485f4a389faaaa3432831a8d.jpg
         * url : http://www.baidu.com
         * type : 1
         */

        private int id;
        private String imgurl;
        private String url;
        private int type;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
