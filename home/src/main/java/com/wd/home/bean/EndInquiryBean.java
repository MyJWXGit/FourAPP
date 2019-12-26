package com.wd.home.bean;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/21 16:36
 * @change
 * @chang time
 * @class describe
 */
public class EndInquiryBean {
    /**
     * result : 500
     * message : 查询成功
     * status : 0000
     */

    private int result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "MyMoneyBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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
