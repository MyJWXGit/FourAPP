package com.wd.my_message.bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 13:49
 * @change
 * @chang time
 * @class describe
 */
public class UserColletionBean {

    /**
     * result : [{"createTime":1576734350000,"id":864,"infoId":9,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1dQWOB7Ev1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1g1JOB7LT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1jf_OBKE_1RCvBVdK","title":"决明子泡水喝有什么功效？这4个作用，还有很多人不清楚"},{"createTime":1576734345000,"id":863,"infoId":1,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1slZcBvEg1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1YYVOBvYT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1mRDSB7xT1RCvBVdK","title":"春季预防三高，预防心脑血管疾病，不得不提到的三个\u201c笋\u201d子！"},{"createTime":1576734341000,"id":862,"infoId":13,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1A9WOBXK_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1VgAOB_h_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1rhDOBCKT1RCvBVdK","title":"喝茶或咖啡会抑制铁吸收吗？专家完整分析原因"},{"createTime":1576734338000,"id":861,"infoId":12,"thumbnail":"https://jkcdn.pajk.com.cn/image/T10_xOB_dg1RCvBVdK","title":"学会这几招，改善玩手机导致的含胸驼背，改善你的体态"},{"createTime":1576734336000,"id":860,"infoId":10,"thumbnail":"https://jkcdn.pajk.com.cn/image/T15fLOBCKv1RCvBVdK","title":"肠道微生物通过其代谢物丙酸盐对血脑屏障起保护作用"}]
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
         * createTime : 1576734350000
         * id : 864
         * infoId : 9
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1dQWOB7Ev1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1g1JOB7LT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1jf_OBKE_1RCvBVdK
         * title : 决明子泡水喝有什么功效？这4个作用，还有很多人不清楚
         */

        private long createTime;
        private int id;
        private int infoId;
        private String thumbnail;
        private String title;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
