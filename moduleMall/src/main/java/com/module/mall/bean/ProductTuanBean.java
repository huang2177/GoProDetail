package com.module.mall.bean;

import java.util.List;

/**
 * Created by shibing on 18/6/19.
 */

public class ProductTuanBean {


    /**
     * code : string
     * data : [{"amount":0,"catagory":"string","commission":0,"couponId":0,"endTime":"2018-06-19T02:01:46.689Z","id":0,"imgurl":"string","isPublic":true,"joinCount":0,"joins":[{"commission":0,"id":0,"imgurl":"string","isPay":true,"joinTime":"2018-06-19T02:01:46.689Z","joinType":0,"nickname":"string","orderId":0,"tuanId":0,"uid":0}],"needOrderNum":0,"nickname":"string","normstr":"string","orderId":0,"pid":0,"product":{"amount":0,"bannerImgurl":"string","catagory":"string","collection":true,"commission":0,"content":"string","deposit":0,"freight":0,"id":0,"imgurl":"string","loginUid":0,"norms":[{"id":0,"items":[{"amount":0,"id":0,"imgurl":"string","itemName":"string","normId":0,"stockCount":0}],"name":"string","pid":0}],"starCount":0,"stockCount":0,"title":"string","toIndex":true,"tuanAmount":0,"tuanCount":0,"tuanDay":0,"type":0},"success":true,"type":0,"uid":0}]
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
         * amount : 0
         * catagory : string
         * commission : 0
         * couponId : 0
         * endTime : 2018-06-19T02:01:46.689Z
         * id : 0
         * imgurl : string
         * isPublic : true
         * joinCount : 0
         * joins : [{"commission":0,"id":0,"imgurl":"string","isPay":true,"joinTime":"2018-06-19T02:01:46.689Z","joinType":0,"nickname":"string","orderId":0,"tuanId":0,"uid":0}]
         * needOrderNum : 0
         * nickname : string
         * normstr : string
         * orderId : 0
         * pid : 0
         * product : {"amount":0,"bannerImgurl":"string","catagory":"string","collection":true,"commission":0,"content":"string","deposit":0,"freight":0,"id":0,"imgurl":"string","loginUid":0,"norms":[{"id":0,"items":[{"amount":0,"id":0,"imgurl":"string","itemName":"string","normId":0,"stockCount":0}],"name":"string","pid":0}],"starCount":0,"stockCount":0,"title":"string","toIndex":true,"tuanAmount":0,"tuanCount":0,"tuanDay":0,"type":0}
         * success : true
         * type : 0
         * uid : 0
         */

        private int amount;
        private String catagory;
        private int commission;
        private int couponId;
        private String endTime;
        private int id;
        private String imgurl;
        private boolean isPublic;
        private int joinCount;
        private int needOrderNum;
        private String nickname;
        private String normstr;
        private int orderId;
        private int pid;
        private ProductBean product;
        private boolean success;
        private int type;
        private int uid;
        private List<JoinsBean> joins;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
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

        public boolean isIsPublic() {
            return isPublic;
        }

        public void setIsPublic(boolean isPublic) {
            this.isPublic = isPublic;
        }

        public int getJoinCount() {
            return joinCount;
        }

        public void setJoinCount(int joinCount) {
            this.joinCount = joinCount;
        }

        public int getNeedOrderNum() {
            return needOrderNum;
        }

        public void setNeedOrderNum(int needOrderNum) {
            this.needOrderNum = needOrderNum;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNormstr() {
            return normstr;
        }

        public void setNormstr(String normstr) {
            this.normstr = normstr;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public List<JoinsBean> getJoins() {
            return joins;
        }

        public void setJoins(List<JoinsBean> joins) {
            this.joins = joins;
        }

        public static class ProductBean {
            /**
             * amount : 0
             * bannerImgurl : string
             * catagory : string
             * collection : true
             * commission : 0
             * content : string
             * deposit : 0
             * freight : 0
             * id : 0
             * imgurl : string
             * loginUid : 0
             * norms : [{"id":0,"items":[{"amount":0,"id":0,"imgurl":"string","itemName":"string","normId":0,"stockCount":0}],"name":"string","pid":0}]
             * starCount : 0
             * stockCount : 0
             * title : string
             * toIndex : true
             * tuanAmount : 0
             * tuanCount : 0
             * tuanDay : 0
             * type : 0
             */

            private int amount;
            private String bannerImgurl;
            private String catagory;
            private boolean collection;
            private int commission;
            private String content;
            private int deposit;
            private double freight;
            private int id;
            private String imgurl;
            private int loginUid;
            private double starCount;
            private int stockCount;
            private String title;
            private boolean toIndex;
            private int tuanAmount;
            private int tuanCount;
            private int tuanDay;
            private int type;
            private List<NormsBean> norms;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getBannerImgurl() {
                return bannerImgurl;
            }

            public void setBannerImgurl(String bannerImgurl) {
                this.bannerImgurl = bannerImgurl;
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

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getDeposit() {
                return deposit;
            }

            public void setDeposit(int deposit) {
                this.deposit = deposit;
            }

            public double getFreight() {
                return freight;
            }

            public void setFreight(double freight) {
                this.freight = freight;
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

            public int getLoginUid() {
                return loginUid;
            }

            public void setLoginUid(int loginUid) {
                this.loginUid = loginUid;
            }

            public double getStarCount() {
                return starCount;
            }

            public void setStarCount(double starCount) {
                this.starCount = starCount;
            }

            public int getStockCount() {
                return stockCount;
            }

            public void setStockCount(int stockCount) {
                this.stockCount = stockCount;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public boolean isToIndex() {
                return toIndex;
            }

            public void setToIndex(boolean toIndex) {
                this.toIndex = toIndex;
            }

            public int getTuanAmount() {
                return tuanAmount;
            }

            public void setTuanAmount(int tuanAmount) {
                this.tuanAmount = tuanAmount;
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

            public List<NormsBean> getNorms() {
                return norms;
            }

            public void setNorms(List<NormsBean> norms) {
                this.norms = norms;
            }

            public static class NormsBean {
                /**
                 * id : 0
                 * items : [{"amount":0,"id":0,"imgurl":"string","itemName":"string","normId":0,"stockCount":0}]
                 * name : string
                 * pid : 0
                 */

                private int id;
                private String name;
                private int pid;
                private List<ItemsBean> items;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public List<ItemsBean> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBean> items) {
                    this.items = items;
                }

                public static class ItemsBean {
                    /**
                     * amount : 0
                     * id : 0
                     * imgurl : string
                     * itemName : string
                     * normId : 0
                     * stockCount : 0
                     */

                    private int amount;
                    private int id;
                    private String imgurl;
                    private String itemName;
                    private int normId;
                    private int stockCount;

                    public int getAmount() {
                        return amount;
                    }

                    public void setAmount(int amount) {
                        this.amount = amount;
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

                    public String getItemName() {
                        return itemName;
                    }

                    public void setItemName(String itemName) {
                        this.itemName = itemName;
                    }

                    public int getNormId() {
                        return normId;
                    }

                    public void setNormId(int normId) {
                        this.normId = normId;
                    }

                    public int getStockCount() {
                        return stockCount;
                    }

                    public void setStockCount(int stockCount) {
                        this.stockCount = stockCount;
                    }
                }
            }
        }

        public static class JoinsBean {
            /**
             * commission : 0
             * id : 0
             * imgurl : string
             * isPay : true
             * joinTime : 2018-06-19T02:01:46.689Z
             * joinType : 0
             * nickname : string
             * orderId : 0
             * tuanId : 0
             * uid : 0
             */

            private int commission;
            private int id;
            private String imgurl;
            private boolean isPay;
            private String joinTime;
            private int joinType;
            private String nickname;
            private int orderId;
            private int tuanId;
            private int uid;

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
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

            public boolean isIsPay() {
                return isPay;
            }

            public void setIsPay(boolean isPay) {
                this.isPay = isPay;
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
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
        }
    }
}
