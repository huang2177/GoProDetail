package com.module.mall.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/21.
 */

public class TuanDetalisBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":3,"uid":1,"nickname":null,"imgurl":null,"pid":1,"catagory":"","endTime":"2019-05-10 10:37:11","needOrderNum":12,"joinCount":1,"success":true,"type":1,"isPublic":false,"couponId":0,"amount":0,"commission":0,"orderId":9,"joins":[{"id":5,"tuanId":3,"uid":1,"nickname":"lipeng","imgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg","orderId":10,"joinTime":"2018-05-10 10:38:26","joinType":1,"isPay":true,"commission":0}],"product":{"id":1,"imgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg","bannerImgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg,pintuan-admin/2018-05-06/7c1de4672f414d55a35b0a9f019ff4e6.jpg","title":"国行正品Apple/苹果 iPhone X 港版现货苹果iphonex 苹果x手机10x","amount":8388,"tuanAmount":0,"starCount":5,"freight":0,"stockCount":100,"content":"<p>产品详情<\/p>","tuanCount":12,"tuanDay":365,"type":0,"catagory":"1","collection":true,"loginUid":null,"norms":[{"id":1,"pid":1,"name":"颜色","items":[{"id":1,"normId":1,"itemName":"白色","stockCount":100,"amount":0,"imgurl":"pintuan-admin/2018-05-06/b2300aa363f049d4b232680892cf3c0f.jpg"},{"id":2,"normId":1,"itemName":"黑色","stockCount":100,"amount":0,"imgurl":""},{"id":12,"normId":1,"itemName":"手机","stockCount":6,"amount":0,"imgurl":""}]},{"id":2,"pid":1,"name":"容量","items":[{"id":3,"normId":2,"itemName":"64G","stockCount":100,"amount":0,"imgurl":""},{"id":4,"normId":2,"itemName":"128G","stockCount":100,"amount":0,"imgurl":""},{"id":5,"normId":2,"itemName":"256G","stockCount":100,"amount":0,"imgurl":""}]}],"commission":0,"toIndex":false,"deposit":0},"normstr":""}
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
         * id : 3
         * uid : 1
         * nickname : null
         * imgurl : null
         * pid : 1
         * catagory :
         * endTime : 2019-05-10 10:37:11
         * needOrderNum : 12
         * joinCount : 1
         * success : true
         * type : 1
         * isPublic : false
         * couponId : 0
         * amount : 0
         * commission : 0
         * orderId : 9
         * joins : [{"id":5,"tuanId":3,"uid":1,"nickname":"lipeng","imgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg","orderId":10,"joinTime":"2018-05-10 10:38:26","joinType":1,"isPay":true,"commission":0}]
         * product : {"id":1,"imgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg","bannerImgurl":"pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg,pintuan-admin/2018-05-06/7c1de4672f414d55a35b0a9f019ff4e6.jpg","title":"国行正品Apple/苹果 iPhone X 港版现货苹果iphonex 苹果x手机10x","amount":8388,"tuanAmount":0,"starCount":5,"freight":0,"stockCount":100,"content":"<p>产品详情<\/p>","tuanCount":12,"tuanDay":365,"type":0,"catagory":"1","collection":true,"loginUid":null,"norms":[{"id":1,"pid":1,"name":"颜色","items":[{"id":1,"normId":1,"itemName":"白色","stockCount":100,"amount":0,"imgurl":"pintuan-admin/2018-05-06/b2300aa363f049d4b232680892cf3c0f.jpg"},{"id":2,"normId":1,"itemName":"黑色","stockCount":100,"amount":0,"imgurl":""},{"id":12,"normId":1,"itemName":"手机","stockCount":6,"amount":0,"imgurl":""}]},{"id":2,"pid":1,"name":"容量","items":[{"id":3,"normId":2,"itemName":"64G","stockCount":100,"amount":0,"imgurl":""},{"id":4,"normId":2,"itemName":"128G","stockCount":100,"amount":0,"imgurl":""},{"id":5,"normId":2,"itemName":"256G","stockCount":100,"amount":0,"imgurl":""}]}],"commission":0,"toIndex":false,"deposit":0}
         * normstr :
         */

        private int id;
        private int uid;
        private String nickname;
        private String imgurl;
        private int pid;
        private String catagory;
        private String endTime;
        private int needOrderNum;
        private int joinCount;
        private boolean success;
        private String type;
        private boolean isPublic;
        private int couponId;
        private int amount;
        private int commission;
        private int orderId;
        private ProductBean product;
        private String normstr;
        private List<JoinsBean> joins;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
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

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public String getNormstr() {
            return normstr;
        }

        public void setNormstr(String normstr) {
            this.normstr = normstr;
        }

        public List<JoinsBean> getJoins() {
            return joins;
        }

        public void setJoins(List<JoinsBean> joins) {
            this.joins = joins;
        }

        public static class ProductBean {
            /**
             * id : 1
             * imgurl : pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg
             * bannerImgurl : pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg,pintuan-admin/2018-05-06/7c1de4672f414d55a35b0a9f019ff4e6.jpg
             * title : 国行正品Apple/苹果 iPhone X 港版现货苹果iphonex 苹果x手机10x
             * amount : 8388
             * tuanAmount : 0
             * starCount : 5
             * freight : 0
             * stockCount : 100
             * content : <p>产品详情</p>
             * tuanCount : 12
             * tuanDay : 365
             * type : 0
             * catagory : 1
             * collection : true
             * loginUid : null
             * norms : [{"id":1,"pid":1,"name":"颜色","items":[{"id":1,"normId":1,"itemName":"白色","stockCount":100,"amount":0,"imgurl":"pintuan-admin/2018-05-06/b2300aa363f049d4b232680892cf3c0f.jpg"},{"id":2,"normId":1,"itemName":"黑色","stockCount":100,"amount":0,"imgurl":""},{"id":12,"normId":1,"itemName":"手机","stockCount":6,"amount":0,"imgurl":""}]},{"id":2,"pid":1,"name":"容量","items":[{"id":3,"normId":2,"itemName":"64G","stockCount":100,"amount":0,"imgurl":""},{"id":4,"normId":2,"itemName":"128G","stockCount":100,"amount":0,"imgurl":""},{"id":5,"normId":2,"itemName":"256G","stockCount":100,"amount":0,"imgurl":""}]}]
             * commission : 0
             * toIndex : false
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
                 * id : 1
                 * pid : 1
                 * name : 颜色
                 * items : [{"id":1,"normId":1,"itemName":"白色","stockCount":100,"amount":0,"imgurl":"pintuan-admin/2018-05-06/b2300aa363f049d4b232680892cf3c0f.jpg"},{"id":2,"normId":1,"itemName":"黑色","stockCount":100,"amount":0,"imgurl":""},{"id":12,"normId":1,"itemName":"手机","stockCount":6,"amount":0,"imgurl":""}]
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
                     * id : 1
                     * normId : 1
                     * itemName : 白色
                     * stockCount : 100
                     * amount : 0
                     * imgurl : pintuan-admin/2018-05-06/b2300aa363f049d4b232680892cf3c0f.jpg
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

        public static class JoinsBean {
            /**
             * id : 5
             * tuanId : 3
             * uid : 1
             * nickname : lipeng
             * imgurl : pintuan-api/2018-04-04/0b153a91d1384739b70985d826fcba61.jpg
             * orderId : 10
             * joinTime : 2018-05-10 10:38:26
             * joinType : 1
             * isPay : true
             * commission : 0
             */

            private int id;
            private int tuanId;
            private int uid;
            private String nickname;
            private String imgurl;
            private int orderId;
            private String joinTime;
            private int joinType;
            private boolean isPay;
            private int commission;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTuanId() {
                return tuanId;
            }

            public void setTuanId(int tuanId) {
                this.tuanId = tuanId;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
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

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getJoinTime() {
                return joinTime;
            }

            public void setJoinTime(String joinTime) {
                this.joinTime = joinTime;
            }

            public int getJoinType() {
                return joinType;
            }

            public void setJoinType(int joinType) {
                this.joinType = joinType;
            }

            public boolean isIsPay() {
                return isPay;
            }

            public void setIsPay(boolean isPay) {
                this.isPay = isPay;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }
        }
    }
}
