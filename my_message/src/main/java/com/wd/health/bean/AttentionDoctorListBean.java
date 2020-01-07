package com.wd.health.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/21 10:43
 * @change
 * @chang time
 * @class describe
 */
public class AttentionDoctorListBean {

    /**
     * result : [{"badNum":0,"departmentId":5,"departmentName":"小儿科","doctorId":1,"id":1309,"imagePic":"\u202aC:\\Users\\你过来呀\\Desktop\\图库\\QQ图片20190527145608.jpg","inauguralHospital":"北京清华大学附属医院","jobTitle":"主治医师","name":"张医生","number":46,"praise":"0.00%","praiseNum":0},{"badNum":0,"departmentId":5,"departmentName":"小儿科","doctorId":13,"id":1308,"inauguralHospital":"天津协和医院","jobTitle":"副主任医师","name":"马小瑞","number":2,"praise":"100.00%","praiseNum":1},{"badNum":0,"departmentId":2,"departmentName":"骨科","doctorId":12,"id":1307,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image7.jpg","inauguralHospital":"北京第一骨科医院","jobTitle":"主治医师","name":"陈小","number":10,"praise":"100.00%","praiseNum":1},{"badNum":0,"departmentId":6,"departmentName":"耳鼻喉科","doctorId":10,"id":1306,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inauguralHospital":"同仁堂","jobTitle":"院长","name":"ML","number":22,"praise":"100.00%","praiseNum":5},{"badNum":0,"departmentId":7,"departmentName":"内科","doctorId":8,"id":1305,"inauguralHospital":"北京","jobTitle":"主任医师","name":"祖宗","number":0,"praise":"0.00%","praiseNum":0},{"badNum":0,"departmentId":5,"departmentName":"小儿科","doctorId":6,"id":1304,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image1.jpg","inauguralHospital":"仁和医院","jobTitle":"普通医师","name":"李吉梅","number":2,"praise":"0.00%","praiseNum":0},{"badNum":0,"departmentId":7,"departmentName":"内科","doctorId":4,"id":1303,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inauguralHospital":"协和医院","jobTitle":"院长","name":"陈焮","number":3,"praise":"0.00%","praiseNum":0},{"badNum":0,"departmentId":2,"departmentName":"骨科","doctorId":2,"id":1302,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inauguralHospital":"三甲","jobTitle":"主治医师","name":"安安","number":33,"praise":"100.00%","praiseNum":2}]
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
         * badNum : 0
         * departmentId : 5
         * departmentName : 小儿科
         * doctorId : 1
         * id : 1309
         * imagePic : ‪C:\Users\你过来呀\Desktop\图库\QQ图片20190527145608.jpg
         * inauguralHospital : 北京清华大学附属医院
         * jobTitle : 主治医师
         * name : 张医生
         * number : 46
         * praise : 0.00%
         * praiseNum : 0
         */

        private int badNum;
        private int departmentId;
        private String departmentName;
        private int doctorId;
        private int id;
        private String imagePic;
        private String inauguralHospital;
        private String jobTitle;
        private String name;
        private int number;
        private String praise;
        private int praiseNum;

        public int getBadNum() {
            return badNum;
        }

        public void setBadNum(int badNum) {
            this.badNum = badNum;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }
    }
}
