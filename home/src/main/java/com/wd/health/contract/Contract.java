package com.wd.health.contract;


import com.wd.common.base.IBaseView;

public interface Contract {
    //接口回调  IBaseView
    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }

    //Activity  P层方法
    interface IPresenter {
        //首页banner板块数据展示
        void onBanner();

        //查询科室列表
        void onDepartment();

        //健康资讯分类类目查询
        void onPlateList();

        //健康资讯分类类目查询
        void onInformationList(int plateId, int page, int count);

        //资讯详情
        void onFindInfo(int infoId);

        //首页搜索
        void onHomeSearch(String keyWord);

        //热门搜索
        void onPopular();

        //问诊-发送消息（文本消息）
        void onPuMessage(int inquiryId, String content, int type, int doctorId);

        //查询历史问诊聊天记录
        void getRecording(int inquiryId, int page, int count);


        //用户查看当前问诊
        void onInquiryRecord();
    }

    //Activity  M层
    interface IModer {
        //首页banner板块数据展示
        void onBanner(IBallBask iBallBask);

        //查询科室列表
        void onDepartment(IBallBask iBallBask);

        //健康资讯分类类目查询
        void onPlateList(IBallBask iBallBask);

        //健康资讯分类类目查询
        void onInformationList(int plateId, int page, int count, IBallBask iBallBask);

        //资讯详情
        void onFindInfo(int userId, String sessionId, int infoId, IBallBask iBallBask);

        //资讯详情
        void onHomeSearch(String keyWord, IBallBask iBallBask);

        //热门搜索
        void onPopular(IBallBask iBallBask);

        //问诊-发送消息（文本消息）
        void onPuMessage(int userId, String sessionId, int inquiryId, String content, int type, int doctorId, IBallBask iBallBask);

        //查询历史问诊聊天记录
        void getRecording(int userId, String sessionId, int inquiryId, int page, int count, IBallBask iBallBask);


        //用户查看当前问诊
        void onInquiryRecord(int userId, String sessionId, IBallBask iBallBask);

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }

    //Fragment  P层方法
    interface FPresenter {
        //查询科室列表
        void onDepartment();

        //根据科室查询对应病症
        void onCategory(int departmentId);

        //查询常见病症详情
        void onDiseaseKnowledge(int id);

        //药品科目分类列表查询
        void onCategoryList();

        //根据药品类目查询常见药品
        void onDrugsKnowledgeList(int drugsCategoryId, int page, int count);

        //查询常见药品详情
        void onIllness(int id);

        //查询问诊医生列表
        void onDoctorList(int deptId, int condition, int page, int count);

        //查询医生明细信息
        void onDoctorInfo(String doctorId);

        //关注医生
        void onFollow(int doctorId);

        //取消关注医生
        void onCancelFollow(int doctorId);

        //我的钱包
        void onUserWallet();

        //查询医生评价列表
        void onEvaluateList(int doctorId, int page, int count);

        //咨询医生
        void getConsult(int doctorId);

        //结束问诊
        void onEndInquiry(int recordId);

        //用户查看当前问诊
        void onInquiryRecord();

    }

    //Fragment  M层
    interface FModer {
        //查询科室列表
        void onDepartment_F(IBallBask iBallBask);

        //根据科室查询对应病症
        void onCategory(int departmentId, IBallBask iBallBask);

        //查询常见病症详情
        void onDiseaseKnowledge(int id, IBallBask iBallBask);

        //药品科目分类列表查询
        void onCategoryList(IBallBask iBallBask);

        //根据药品类目查询常见药品
        void onDrugsKnowledgeList(int drugsCategoryId, int page, int count, IBallBask iBallBask);

        //查询常见药品详情
        void onIllness(int id, IBallBask iBallBask);

        //查询问诊医生列表
        void onDoctorList(int deptId, int condition, int page, int count, IBallBask iBallBask);

        //关注医生
        void onDoctorInfo(int userId, String sessionId, String doctorId, IBallBask iBallBask);

        //关注医生
        void onFollow(int userId, String sessionId, int doctorId, IBallBask iBallBask);

        //取消关注医生
        void onCancelFollow(int userId, String sessionId, int doctorId, IBallBask iBallBask);

        //我的钱包
        void onUserWallet(int userId, String sessionId, IBallBask iBallBask);

        //查询医生评价列表
        void onEvaluateList(int doctorId, int page, int count, IBallBask iBallBask);

        //咨询医生
        void getConsult(int userId, String sessionId, int doctorId, IBallBask iBallBask);

        //结束问诊
        void onEndInquiry(int userId, String sessionId, int recordId, IBallBask iBallBask);

        //用户查看当前问诊
        void onInquiryRecord(int userId, String sessionId, IBallBask iBallBask);

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
