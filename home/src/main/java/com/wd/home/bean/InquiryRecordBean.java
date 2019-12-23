package com.wd.home.bean;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/21 16:35
 * @change
 * @chang time
 * @class describe
 */
public class InquiryRecordBean {
    /**
     * message : 当前无问诊
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "NowIMS{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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
}
