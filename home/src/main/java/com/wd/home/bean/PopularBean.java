package com.wd.home.bean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/20 14:56
 * @change
 * @chang time
 * @class describe
 */
public class PopularBean {

    /**
     * result : [{"id":7,"name":"流鼻涕"},{"id":2,"name":"发烧"},{"id":12,"name":"牛黄上清丸"},{"id":11,"name":"慢性胃炎"},{"id":10,"name":"近视"},{"id":6,"name":"咳嗽"},{"id":3,"name":"脱发"},{"id":1,"name":"头痛"},{"id":4,"name":"小儿感冒颗粒"},{"id":5,"name":"喉咙发炎"},{"id":8,"name":"皮肤痒"},{"id":9,"name":"阿莫西林"}]
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
         * id : 7
         * name : 流鼻涕
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}