package com.wd.video.bean;

import java.util.List;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_QueryBean {

    /**
     * result : [{"abstracts":"影响长高的3种食物，快看看你中枪了没","buyNum":66,"categoryId":1,"duration":26,"id":1,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek1.mp4","price":100,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek1.mp4","title":"南方健康","whetherBuy":2,"whetherCollection":2},{"abstracts":"宝宝腹泻时家长要避免的几个误区","buyNum":33,"categoryId":1,"duration":55,"id":2,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek2.mp4","price":50,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek2.mp4","title":"儿科医生雨滴","whetherBuy":1,"whetherCollection":2},{"abstracts":"手足口病是如何传播的？如何预防？","buyNum":32,"categoryId":1,"duration":44,"id":6,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek6.mp4","price":60,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek6.mp4","title":"儿科儿保专家说","whetherBuy":2,"whetherCollection":2},{"abstracts":"宝宝入睡困难的一剂良药：如何养成良好的睡眠习惯！","buyNum":21,"categoryId":1,"duration":61,"id":4,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek4.mp4","price":80,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek4.mp4","title":"儿科医生鱼小南","whetherBuy":2,"whetherCollection":2},{"abstracts":"如何正确冲奶粉，奶爸们快快收藏！","buyNum":18,"categoryId":1,"duration":15,"id":5,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek5.mp4","price":50,"shearUrl":"http://172.17.8.100/video/health/cut/ek/ek5.mp4","title":"儿童育婴师教你如何育儿","whetherBuy":2,"whetherCollection":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * abstracts : 影响长高的3种食物，快看看你中枪了没
         * buyNum : 66
         * categoryId : 1
         * duration : 26
         * id : 1
         * originalUrl : http://172.17.8.100/video/health/original/ek/ek1.mp4
         * price : 100
         * shearUrl : http://172.17.8.100/video/health/cut/ek/ek1.mp4
         * title : 南方健康
         * whetherBuy : 2
         * whetherCollection : 2
         */

        private String abstracts;
        private String buyNum;
        private String categoryId;
        private String duration;
        private String id;
        private String originalUrl;
        private String price;
        private String shearUrl;
        private String title;
        private int whetherBuy;
        private int whetherCollection;

        public String getAbstracts() {
            return abstracts;
        }

        public void setAbstracts(String abstracts) {
            this.abstracts = abstracts;
        }

        public String getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(String buyNum) {
            this.buyNum = buyNum;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getShearUrl() {
            return shearUrl;
        }

        public void setShearUrl(String shearUrl) {
            this.shearUrl = shearUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWhetherBuy() {
            return whetherBuy;
        }

        public void setWhetherBuy(int whetherBuy) {
            this.whetherBuy = whetherBuy;
        }

        public int getWhetherCollection() {
            return whetherCollection;
        }

        public void setWhetherCollection(int whetherCollection) {
            this.whetherCollection = whetherCollection;
        }
    }
}
