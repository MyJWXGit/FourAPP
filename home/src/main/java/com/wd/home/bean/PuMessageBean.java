package com.wd.home.bean;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/25 11:50
 * @change
 * @chang time
 * @class describe
 */
public class PuMessageBean {

    /**
     * message : 推送成功
     * status : 0000
     */

    private String message;
    private String status;

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
