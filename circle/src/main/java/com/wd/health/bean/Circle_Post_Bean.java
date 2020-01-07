package com.wd.health.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/15 21:12
 * @change
 * @chang time
 * @class describe
 */
public class Circle_Post_Bean {

    /**
     * result : [{"amount":10,"collectionNum":0,"commentNum":0,"detail":"详情","releaseTime":1564416000000,"sickCircleId":773,"title":"标题"},{"amount":10,"collectionNum":0,"commentNum":0,"detail":"详情","releaseTime":1564156800000,"sickCircleId":685,"title":"标题"},{"amount":10,"collectionNum":0,"commentNum":2,"detail":"详情","releaseTime":1564156800000,"sickCircleId":683,"title":"标题"},{"amount":10,"collectionNum":0,"commentNum":0,"detail":"详情","releaseTime":1564070400000,"sickCircleId":593,"title":"标题"},{"amount":10,"collectionNum":0,"commentNum":0,"detail":"详情","releaseTime":1564070400000,"sickCircleId":590,"title":"标题"}]
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
         * amount : 10
         * collectionNum : 0
         * commentNum : 0
         * detail : 详情
         * releaseTime : 1564416000000
         * sickCircleId : 773
         * title : 标题
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
