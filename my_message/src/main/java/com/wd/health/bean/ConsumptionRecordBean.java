package com.wd.health.bean;
/*
 *@auther:
 *@Date: 2019/12/19
 *@Time:18:46
 *@Description:用户消费记录
 **/

import java.util.List;

public class ConsumptionRecordBean {

    /**
     * result : [{"changeNum":0,"createTime":1576668566000,"direction":2,"type":6},{"changeNum":0,"createTime":1576666181000,"direction":2,"type":6},{"changeNum":0,"createTime":1576591307000,"direction":2,"type":6},{"changeNum":0,"createTime":1576591155000,"direction":2,"type":6},{"changeNum":0,"createTime":1576548445000,"direction":2,"type":6},{"changeNum":-100,"createTime":1576456561000,"direction":2,"remark":"购买健康课堂视频","type":17},{"changeNum":5,"createTime":1576065626000,"direction":1,"remark":"观看资讯","type":11},{"changeNum":2,"createTime":1576064380000,"direction":1,"remark":"签到","type":1},{"changeNum":-100,"createTime":1575985077000,"direction":2,"remark":"购买健康课堂视频","type":17}]
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
         * changeNum : 0
         * createTime : 1576668566000
         * direction : 2
         * type : 6
         * remark : 购买健康课堂视频
         */

        private int changeNum;
        private long createTime;
        private int direction;
        private int type;
        private String remark;

        public int getChangeNum() {
            return changeNum;
        }

        public void setChangeNum(int changeNum) {
            this.changeNum = changeNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
