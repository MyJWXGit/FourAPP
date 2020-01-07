package com.wd.health.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/15 20:49
 * @change
 * @chang time
 * @class describe
 */
public class Circle_Comment_Bean {

    /**
     * result : [{"commentId":7691,"commentTime":1576414341000,"commentUserId":440,"content":"非常不好","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg","nickName":"IF_LGOGZ","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7354,"commentTime":1576046867000,"commentUserId":156,"content":"好","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"王晓","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7335,"commentTime":1575979235000,"commentUserId":440,"content":"非常不好","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg","nickName":"IF_LGOGZ","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7141,"commentTime":1574681822000,"commentUserId":397,"content":"奇偶撒积分解散的吉安","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-11/OKskpN20191211203309.gif","nickName":"杨立朝最帅","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":5881,"commentTime":1573530824000,"commentUserId":88,"content":"123","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"逯世宽","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1}]
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
         * commentId : 7691
         * commentTime : 1576414341000
         * commentUserId : 440
         * content : 非常不好
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg
         * nickName : IF_LGOGZ
         * opinion : 0
         * opposeNum : 0
         * supportNum : 0
         * whetherDoctor : 2
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
