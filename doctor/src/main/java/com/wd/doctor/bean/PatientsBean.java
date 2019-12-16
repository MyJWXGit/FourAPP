package com.wd.doctor.bean;

import java.util.List;

/**
 * date:2019/12/14
 * author:金豪(Lenovo)
 * function:
 */
public class PatientsBean {

    /**
     * result : [{"amount":0,"detail":"发你你的名字看了下","releaseTime":1574870400000,"sickCircleId":1532,"title":"不是你男多女少"},{"amount":0,"detail":"发你你的名字看了下","releaseTime":1574870400000,"sickCircleId":1530,"title":"不是你男多女少"},{"amount":0,"detail":"发你你的名字看了下","releaseTime":1574870400000,"sickCircleId":1531,"title":"不是你男多女少"},{"amount":0,"detail":"计算机三级","releaseTime":1574870400000,"sickCircleId":1522,"title":"JJ麻将"},{"amount":0,"detail":"计算机三级","releaseTime":1574870400000,"sickCircleId":1521,"title":"JJ麻将"}]
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
         * detail : 发你你的名字看了下
         * releaseTime : 1574870400000
         * sickCircleId : 1532
         * title : 不是你男多女少
         */

        private int amount;
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
