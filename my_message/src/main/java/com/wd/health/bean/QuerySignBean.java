package com.wd.health.bean;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/23 10:50
 * @change
 * @chang time
 * @class describe
 */
public class QuerySignBean {

    /**
     * result : 1
     * message : 查询成功
     * status : 0000
     */

    private int result;
    private String message;
    private String status;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
