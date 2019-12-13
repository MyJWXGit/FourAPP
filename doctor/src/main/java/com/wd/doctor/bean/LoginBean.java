package com.wd.doctor.bean;

/**
 * date:2019/12/11
 * author:金豪(Lenovo)
 * function:
 */
public class LoginBean {

    /**
     * result : {"departmentId":5,"departmentName":"小儿科","id":161,"inauguralHospital":"清华大学附属医院","jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"妙手回春","name":"婉珍","reviewStatus":2,"sessionId":"1611576023407603161","userName":"JowGuR1269733973","whetherHaveImagePic":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * departmentId : 5
         * departmentName : 小儿科
         * id : 161
         * inauguralHospital : 清华大学附属医院
         * jiGuangPwd : enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=
         * jobTitle : 妙手回春
         * name : 婉珍
         * reviewStatus : 2
         * sessionId : 1611576023407603161
         * userName : JowGuR1269733973
         * whetherHaveImagePic : 2
         */

        private int departmentId;
        private String departmentName;
        private int id;
        private String inauguralHospital;
        private String jiGuangPwd;
        private String jobTitle;
        private String name;
        private int reviewStatus;
        private String sessionId;
        private String userName;
        private int whetherHaveImagePic;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
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

        public int getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(int reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherHaveImagePic() {
            return whetherHaveImagePic;
        }

        public void setWhetherHaveImagePic(int whetherHaveImagePic) {
            this.whetherHaveImagePic = whetherHaveImagePic;
        }
    }
}
