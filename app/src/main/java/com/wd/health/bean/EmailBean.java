package com.wd.health.bean;

/**
 * @name Health
 * @class name：com.wd.health.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 19:13
 * @change
 * @chang time
 * @class describe
 */
public class EmailBean {

    /**
     * message : 发送成功
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
