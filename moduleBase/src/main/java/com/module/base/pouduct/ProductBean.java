package com.module.base.pouduct;

import java.util.List;

/**
 * Created by shibing on 18/6/12.
 */

public class ProductBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : [{"id":4,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/0152cfcf8a254ef2af05a9991691d303.jpg","bannerImgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/ee08a6e059d6422cbc9ef0bb8d1fdcf8.jpg,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/237a866d1ddd4c56a0b51de215620af7.jpg,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/9a7ca519822e4252b3465158c69d8e4d.png,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/6b1ffca3f99841098118e602e10dc528.jpg","title":"iPhone6 手机","amount":6989,"tuanAmount":0,"starCount":3.5,"freight":10,"stockCount":1000,"content":"<h5>&nbsp; &nbsp; &nbsp; 这是描述文件<\/h5><p>&nbsp; &nbsp; &nbsp;这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<span style=\"white-space: normal;\">这是第二段文字,第二段文字必须换行<\/span><\/span><\/span><\/span><\/span><\/span><\/p><h6>&nbsp; &nbsp; &nbsp;这是第三段文字小一点的字体<\/h6><p><br/><\/p><p><br/><\/p><p><img src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/f550d37434a342909d1e973340358b5d..png\" _src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/f550d37434a342909d1e973340358b5d..png\" style=\"width: 242px; height: 115px;\"/><img src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/96d16b4964294d73a28c25a62bf62cdf..jpg\" _src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/96d16b4964294d73a28c25a62bf62cdf..jpg\" style=\"width: 136px; height: 39px;\"/><\/p><p><img src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/29735705aab94d37b110f057e54cd76c..jpg\" _src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/29735705aab94d37b110f057e54cd76c..jpg\" style=\"width: 370px; height: 198px;\"/><img src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/337731c2c60b4eaca694a2e751b0dcad..jpg\" _src=\"http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/337731c2c60b4eaca694a2e751b0dcad..jpg\"/><\/p>","tuanCount":12,"tuanDay":365,"type":0,"catagory":"1","collection":false,"loginUid":null,"norms":[{"id":5,"pid":4,"name":"iPhone 6颜色","items":[{"id":6,"normId":5,"itemName":"黑色","stockCount":100,"amount":8000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1d82556f471841a1bf4b19bacc23addf.jpg"},{"id":7,"normId":5,"itemName":"红色","stockCount":0,"amount":9000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/9a55398f8bdf495a84b98775ab901566.jpg"},{"id":8,"normId":5,"itemName":"白色","stockCount":300,"amount":6000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/536e3bd4b89f4c3ba7ad3127039bdc9c.png"},{"id":11,"normId":5,"itemName":"金色","stockCount":123,"amount":123123,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/8b807e00b0a8433bbf02c7ef12d5412b.jpg"}]},{"id":6,"pid":4,"name":"iPhone6 容量","items":[{"id":9,"normId":6,"itemName":"128G","stockCount":100,"amount":9299,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/d493e21e61fa4b4383bf3edf571b04be.png"},{"id":10,"normId":6,"itemName":"256G","stockCount":12,"amount":10000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1fb01820d0f84ec69be96d8a3cf6a0cf.jpg"}]}],"commission":6989,"toIndex":true,"deposit":0}]
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
         * id : 4
         * imgurl : /usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/0152cfcf8a254ef2af05a9991691d303.jpg
         * bannerImgurl : /usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/ee08a6e059d6422cbc9ef0bb8d1fdcf8.jpg,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/237a866d1ddd4c56a0b51de215620af7.jpg,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/9a7ca519822e4252b3465158c69d8e4d.png,/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/6b1ffca3f99841098118e602e10dc528.jpg
         * title : iPhone6 手机
         * amount : 6989
         * tuanAmount : 0
         * starCount : 3.5
         * freight : 10
         * stockCount : 1000
         * content : <h5>&nbsp; &nbsp; &nbsp; 这是描述文件</h5><p>&nbsp; &nbsp; &nbsp;这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行<span style="white-space: normal;">这是第二段文字,第二段文字必须换行</span></span></span></span></span></span></p><h6>&nbsp; &nbsp; &nbsp;这是第三段文字小一点的字体</h6><p><br/></p><p><br/></p><p><img src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/f550d37434a342909d1e973340358b5d..png" _src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/f550d37434a342909d1e973340358b5d..png" style="width: 242px; height: 115px;"/><img src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/96d16b4964294d73a28c25a62bf62cdf..jpg" _src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/96d16b4964294d73a28c25a62bf62cdf..jpg" style="width: 136px; height: 39px;"/></p><p><img src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/29735705aab94d37b110f057e54cd76c..jpg" _src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/29735705aab94d37b110f057e54cd76c..jpg" style="width: 370px; height: 198px;"/><img src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/337731c2c60b4eaca694a2e751b0dcad..jpg" _src="http://39.106.187.244:8080/storage//usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/337731c2c60b4eaca694a2e751b0dcad..jpg"/></p>
         * tuanCount : 12
         * tuanDay : 365
         * type : 0
         * catagory : 1
         * collection : false
         * loginUid : null
         * norms : [{"id":5,"pid":4,"name":"iPhone 6颜色","items":[{"id":6,"normId":5,"itemName":"黑色","stockCount":100,"amount":8000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1d82556f471841a1bf4b19bacc23addf.jpg"},{"id":7,"normId":5,"itemName":"红色","stockCount":0,"amount":9000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/9a55398f8bdf495a84b98775ab901566.jpg"},{"id":8,"normId":5,"itemName":"白色","stockCount":300,"amount":6000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/536e3bd4b89f4c3ba7ad3127039bdc9c.png"},{"id":11,"normId":5,"itemName":"金色","stockCount":123,"amount":123123,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/8b807e00b0a8433bbf02c7ef12d5412b.jpg"}]},{"id":6,"pid":4,"name":"iPhone6 容量","items":[{"id":9,"normId":6,"itemName":"128G","stockCount":100,"amount":9299,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/d493e21e61fa4b4383bf3edf571b04be.png"},{"id":10,"normId":6,"itemName":"256G","stockCount":12,"amount":10000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1fb01820d0f84ec69be96d8a3cf6a0cf.jpg"}]}]
         * commission : 6989
         * toIndex : true
         * deposit : 0
         */

        private int id;
        private String imgurl;
        private String bannerImgurl;
        private String title;
        private String amount;
        private int tuanAmount;
        private double starCount;
        private double freight;
        private int stockCount;
        private String content;
        private int tuanCount;
        private int tuanDay;
        private int type;
        private String catagory;
        private boolean collection;
        private Object loginUid;
        private int commission;
        private boolean toIndex;
        private int deposit;
        private List<NormsBean> norms;


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

        public String getBannerImgurl() {
            return bannerImgurl;
        }

        public void setBannerImgurl(String bannerImgurl) {
            this.bannerImgurl = bannerImgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public int getTuanAmount() {
            return tuanAmount;
        }

        public void setTuanAmount(int tuanAmount) {
            this.tuanAmount = tuanAmount;
        }

        public double getStarCount() {
            return starCount;
        }

        public void setStarCount(double starCount) {
            this.starCount = starCount;
        }

        public double getFreight() {
            return freight;
        }

        public void setFreight(double freight) {
            this.freight = freight;
        }

        public int getStockCount() {
            return stockCount;
        }

        public void setStockCount(int stockCount) {
            this.stockCount = stockCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getTuanCount() {
            return tuanCount;
        }

        public void setTuanCount(int tuanCount) {
            this.tuanCount = tuanCount;
        }

        public int getTuanDay() {
            return tuanDay;
        }

        public void setTuanDay(int tuanDay) {
            this.tuanDay = tuanDay;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public boolean isCollection() {
            return collection;
        }

        public void setCollection(boolean collection) {
            this.collection = collection;
        }

        public Object getLoginUid() {
            return loginUid;
        }

        public void setLoginUid(Object loginUid) {
            this.loginUid = loginUid;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public boolean isToIndex() {
            return toIndex;
        }

        public void setToIndex(boolean toIndex) {
            this.toIndex = toIndex;
        }

        public int getDeposit() {
            return deposit;
        }

        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }

        public List<NormsBean> getNorms() {
            return norms;
        }

        public void setNorms(List<NormsBean> norms) {
            this.norms = norms;
        }

        public static class NormsBean {
            /**
             * id : 5
             * pid : 4
             * name : iPhone 6颜色
             * items : [{"id":6,"normId":5,"itemName":"黑色","stockCount":100,"amount":8000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1d82556f471841a1bf4b19bacc23addf.jpg"},{"id":7,"normId":5,"itemName":"红色","stockCount":0,"amount":9000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/9a55398f8bdf495a84b98775ab901566.jpg"},{"id":8,"normId":5,"itemName":"白色","stockCount":300,"amount":6000,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/536e3bd4b89f4c3ba7ad3127039bdc9c.png"},{"id":11,"normId":5,"itemName":"金色","stockCount":123,"amount":123123,"imgurl":"/usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/8b807e00b0a8433bbf02c7ef12d5412b.jpg"}]
             */

            private int id;
            private int pid;
            private String name;
            private List<ItemsBean> items;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {
                /**
                 * id : 6
                 * normId : 5
                 * itemName : 黑色
                 * stockCount : 100
                 * amount : 8000
                 * imgurl : /usr/local/tomcat/apache-tomcat-8.0.48/2018-05-30/1d82556f471841a1bf4b19bacc23addf.jpg
                 */

                private int id;
                private int normId;
                private String itemName;
                private int stockCount;
                private int amount;
                private String imgurl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getNormId() {
                    return normId;
                }

                public void setNormId(int normId) {
                    this.normId = normId;
                }

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public int getStockCount() {
                    return stockCount;
                }

                public void setStockCount(int stockCount) {
                    this.stockCount = stockCount;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }
            }
        }
    }
}
