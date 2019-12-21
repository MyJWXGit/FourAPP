package com.wd.home.contract;


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
        void onDoctorList(int deptId, int condition , int page, int count, IBallBask iBallBask);

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
