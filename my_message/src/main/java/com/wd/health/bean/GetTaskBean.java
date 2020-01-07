package com.wd.health.bean;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/24 9:07
 * @change
 * @chang time
 * @class describe
 */
public class GetTaskBean {

    /**
     * message : 已领取，不可重复领取
     * status : 8001
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
