package com.wd.health.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/26 14:31
 * @change
 * @chang time
 * @class describe
 */
public class MySickCircleCommentListBean {

    /**
     * result : [{"commentId":7771,"commentTime":1576588109000,"commentUserId":157,"content":"好的","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"小明","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7730,"commentTime":1576548459000,"commentUserId":447,"content":"jianyi建议","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-26/d4jZnC20191226094013.jpg","nickName":"蜕变","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7715,"commentTime":1576486441000,"commentUserId":447,"content":"jianyi建议","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-26/d4jZnC20191226094013.jpg","nickName":"蜕变","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7691,"commentTime":1576414341000,"commentUserId":440,"content":"非常不好","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg","nickName":"IF_LGOGZ","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7354,"commentTime":1576046867000,"commentUserId":156,"content":"好","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"王晓","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1}]
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
         * commentId : 7771
         * commentTime : 1576588109000
         * commentUserId : 157
         * content : 好的
         * headPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * nickName : 小明
         * opinion : 0
         * opposeNum : 0
         * supportNum : 0
         * whetherDoctor : 1
         */

        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String content;
        private String headPic;
        private String nickName;
        private int opinion;
        private int opposeNum;
        private int supportNum;
        private int whetherDoctor;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getOpinion() {
            return opinion;
        }

        public void setOpinion(int opinion) {
            this.opinion = opinion;
        }

        public int getOpposeNum() {
            return opposeNum;
        }

        public void setOpposeNum(int opposeNum) {
            this.opposeNum = opposeNum;
        }

        public int getSupportNum() {
            return supportNum;
        }

        public void setSupportNum(int supportNum) {
            this.supportNum = supportNum;
        }

        public int getWhetherDoctor() {
            return whetherDoctor;
        }

        public void setWhetherDoctor(int whetherDoctor) {
            this.whetherDoctor = whetherDoctor;
        }
    }
}
