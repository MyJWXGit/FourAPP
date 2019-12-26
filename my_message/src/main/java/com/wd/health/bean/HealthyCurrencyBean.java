package com.wd.health.bean;

/*
 *@auther:妙国青
 *@Date: 2019/12/19
 *@Time:15:25
 *@Description:查询用户H币通知列表
 **/

import java.util.List;

public class HealthyCurrencyBean {

    /**
     * result : [{"content":"您采纳了志患者对你的建议，增加的悬赏10H币已从账号扣除","createTime":1576667144000,"id":333113},{"content":"您通过购买健康课堂视频消费了100H币","createTime":1576456561000,"id":333032},{"content":"您通过领取每日首次评论病友圈奖励获得了5H币","createTime":1576065647000,"id":332899},{"content":"恭喜您成功注册维度健康，注册奖励已发放到您的钱包，快去查看吧！","createTime":1576065540000,"id":332888},{"content":"您通过购买健康课堂视频消费了100H币","createTime":1576065540000,"id":332889},{"content":"您通过领取签到奖励获得了2H币","createTime":1576065540000,"id":332896}]
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
         * content : 您采纳了志患者对你的建议，增加的悬赏10H币已从账号扣除
         * createTime : 1576667144000
         * id : 333113
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
