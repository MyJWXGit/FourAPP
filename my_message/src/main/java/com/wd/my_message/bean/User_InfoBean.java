package com.wd.my_message.bean;

/*
 *author:郭昊坤
 *date:2019/12/27
 *function:*/public class User_InfoBean {

    /**
     * result : {"age":0,"email":"17701300447@163.com","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_6.jpg","height":0,"id":444,"jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","nickName":"复古","sex":1,"userName":"HLo7T517701300447","weight":0,"whetherBingWeChat":2}
     * message : 用户信息查询成功
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
         * age : 0
         * email : 17701300447@163.com
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_6.jpg
         * height : 0
         * id : 444
         * jiGuangPwd : enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=
         * nickName : 复古
         * sex : 1
         * userName : HLo7T517701300447
         * weight : 0
         * whetherBingWeChat : 2
         */

        private int age;
        private String email;
        private String headPic;
        private int height;
        private int id;
        private String jiGuangPwd;
        private String nickName;
        private int sex;
        private String userName;
        private int weight;
        private int whetherBingWeChat;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWhetherBingWeChat() {
            return whetherBingWeChat;
        }

        public void setWhetherBingWeChat(int whetherBingWeChat) {
            this.whetherBingWeChat = whetherBingWeChat;
        }
    }
}
