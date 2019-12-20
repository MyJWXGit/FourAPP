package com.wd.my_message.bean;


/*
 *@auther:妙国青
 *@Date: 2019/12/19
 *@Time:15:23
 *@Description:问诊消息
 **/

import java.util.List;

public class InquiryMessageBean {

    /**
     * result : [{"content":"恭喜您成为维度健康用户，快去体验它带来的便捷已经它强大的功能吧!","createTime":1576065510000,"id":332887}]
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
         * content : 恭喜您成为维度健康用户，快去体验它带来的便捷已经它强大的功能吧!
         * createTime : 1576065510000
         * id : 332887
         */

        private String content;
        private long createTime;
        private int id;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
