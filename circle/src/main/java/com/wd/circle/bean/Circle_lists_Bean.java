package com.wd.circle.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 16:46
 * @change
 * @chang time
 * @class describe
 */
public class Circle_lists_Bean {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":0,"detail":"奖学金","releaseTime":1575475200000,"sickCircleId":1646,"title":"就直接"},{"amount":0,"collectionNum":1,"commentNum":2,"detail":"奖学金","releaseTime":1575475200000,"sickCircleId":1645,"title":"就直接"},{"amount":0,"collectionNum":0,"commentNum":4,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1641,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1635,"title":"嘿嘿嘿"},{"amount":0,"collectionNum":0,"commentNum":0,"detail":"呀呀呀","releaseTime":1575475200000,"sickCircleId":1636,"title":"嘿嘿嘿"}]
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
         * amount : 0
         * collectionNum : 0
         * commentNum : 0
         * detail : 奖学金
         * releaseTime : 1575475200000
         * sickCircleId : 1646
         * title : 就直接
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
