package com.wd.health.bean;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 13:52
 * @change
 * @chang time
 * @class describe
 */
public class UserSickCollectionBean {

    /**
     * result : [{"collectionNum":2,"commentNum":6,"createTime":1576734621000,"disease":"病症描述","id":941,"sickCircleId":8,"title":"急寻：面神经炎的治疗方法"},{"collectionNum":2,"commentNum":7,"createTime":1576734617000,"disease":"病症描述","id":940,"sickCircleId":6,"title":"急寻：面神经炎的治疗方法"},{"collectionNum":7,"commentNum":346,"createTime":1576734615000,"disease":"病症描述","id":939,"sickCircleId":5,"title":"急寻：面神经炎的治疗方法"},{"collectionNum":3,"commentNum":100,"createTime":1576734612000,"disease":"病症描述","id":938,"sickCircleId":4,"title":"急寻：面神经炎的治疗方法"},{"collectionNum":0,"commentNum":0,"createTime":1576734609000,"id":937,"sickCircleId":2}]
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
         * collectionNum : 2
         * commentNum : 6
         * createTime : 1576734621000
         * disease : 病症描述
         * id : 941
         * sickCircleId : 8
         * title : 急寻：面神经炎的治疗方法
         */

        private int collectionNum;
        private int commentNum;
        private long createTime;
        private String disease;
        private int id;
        private int sickCircleId;
        private String title;

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

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
