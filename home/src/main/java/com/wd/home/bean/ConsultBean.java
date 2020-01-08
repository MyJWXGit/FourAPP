package com.wd.home.bean;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @class describe
 * @anthor 24673
 * @time 2019/12/25 14:07
 * @change
 * @chang time
 * @class describe
 */
public class ConsultBean {

    /**
     * doctorUserName : LTtW4qFYTzQ1IKoapIAU05CXgwBGxQrTQntuyieA3foRz+UO2b1M81jEscp7Taudg20RdhMAg240keTxmiz+J625/Ir1A9T15Whjn+uX0FnHZfIIXAbohfZ7w09yQwDBFAs3CeytYpUt/gRt6oIZCJvF3o910FC6u+TlGqrlOD8=
     * message : 查询成功
     * status : 0000
     */

    private String doctorUserName;
    private String message;
    private String status;

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
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
