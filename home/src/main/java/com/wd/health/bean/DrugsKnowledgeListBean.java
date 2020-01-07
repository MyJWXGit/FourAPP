package com.wd.health.bean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 10:23
 * @change
 * @chang time
 * @class describe
 */
public class DrugsKnowledgeListBean {
    /**
     * result : [{"drugsCategoryId":5,"id":304,"name":" [仁和]奥利司他胶囊 ","picture":"https://imgq.ddky.com/c/product/536753/big/z_1.jpg?t=1532336349006&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":5,"id":305,"name":" [多贝斯]羟苯磺酸钙胶囊 ","picture":"https://imgq.ddky.com/c/product/109400/big/z_1.jpg?t=1507514635905&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":5,"id":306,"name":" 妇炎洁牌卫生护垫(清爽怡肤系列 丝薄棉柔) ","picture":"https://imgq.ddky.com/c/product/537702/big/z_1.jpg?t=1545016930792&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":5,"id":307,"name":" [雅塑]奥利司他胶囊 ","picture":"https://imgq.ddky.com/c/product/536657/big/z_1.jpg?t=1531730284828&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":5,"id":308,"name":" [可元]羟苯磺酸钙胶囊 ","picture":"https://imgq.ddky.com/c/product/111893/big/z_1.jpg?t=1522387346316&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"}]
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
         * drugsCategoryId : 5
         * id : 304
         * name :  [仁和]奥利司他胶囊
         * picture : https://imgq.ddky.com/c/product/536753/big/z_1.jpg?t=1532336349006&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100
         */

        private int drugsCategoryId;
        private int id;
        private String name;
        private String picture;

        public int getDrugsCategoryId() {
            return drugsCategoryId;
        }

        public void setDrugsCategoryId(int drugsCategoryId) {
            this.drugsCategoryId = drugsCategoryId;
        }

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

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
