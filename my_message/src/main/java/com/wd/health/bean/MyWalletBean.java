package com.wd.health.bean;
/*
 *@auther:
 *@Date: 2019/12/19
 *@Time:16:11
 *@Description:我的钱包
 **/

public class MyWalletBean {

    /**
     * result : 307
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
