package com.wd.circle.presenter;

import android.content.Context;
import android.widget.Toast;

import com.wd.circle.contract.Contract;
import com.wd.circle.model.Circle_MainModel;
import com.wd.circle.bean.Circle_Comment_Bean;
import com.wd.circle.bean.Circle_Details_Bean;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.CommentBean;
import com.wd.circle.bean.DiseaseBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.bean.PictureBean;
import com.wd.circle.bean.RepleaseCircleBean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.bean.UserTaskListBean;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.ToastUtils;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;


/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 9:00
 * @change
 * @chang time
 * @class describe
 */
public class Circle_MainPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private Circle_MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new Circle_MainModel();
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    public void onLogin(String email, String pwd) {
        mainModel.onLogin(email, pwd, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    LoginBean loginBean = (LoginBean) obj;
                    if (loginBean != null && loginBean.getStatus().equals("0000")) {
                        getView().onSuccess(loginBean);
                    } else {
                        Toast.makeText(context(), "请求失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onHome() {
        mainModel.onhome(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    Circle_list_Bean circle_list_bean = (Circle_list_Bean) obj;
                    if (circle_list_bean != null) {
                        getView().onSuccess(circle_list_bean);
                    } else {
                        ToastUtils.show(context(), circle_list_bean.getMessage(), 2000);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onHomes(int departmentId, int page, int count) {
        mainModel.onhomes(departmentId, page, count, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    Circle_lists_Bean circle_lists_bean = (Circle_lists_Bean) obj;
                    if (circle_lists_bean != null) {
                        getView().onSuccess(circle_lists_bean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onSearch(String keyWord) {
        mainModel.onSearch(keyWord, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    SearchCircleBean searchCircleBean = (SearchCircleBean) obj;
                    if (searchCircleBean != null) {
                        getView().onSuccess(searchCircleBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onDetails(int sickCircleId, String userId, String sessionId) {
        mainModel.onDetails(sickCircleId, userId, sessionId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    Circle_Details_Bean circle_details_bean = (Circle_Details_Bean) obj;
                    if (circle_details_bean != null) {
                        getView().onSuccess(circle_details_bean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onComment(int sickCircleId, String userId, String sessionId, String content) {
        mainModel.onComment(sickCircleId, userId, sessionId, content, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    CommentBean commentBean = (CommentBean) obj;
                    if (commentBean != null) {
                        getView().onSuccess(commentBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onCircleComment(int sickCircleId, String userId, String sessionId, int count, int page) {
        mainModel.onCircleComment(sickCircleId, userId, sessionId, count, page, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    Circle_Comment_Bean circle_comment_bean = (Circle_Comment_Bean) obj;
                    if (circle_comment_bean != null) {
                        getView().onSuccess(circle_comment_bean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onDoTask(String userId, String sessionId, int taskId) {
        mainModel.onDoTask(userId, sessionId, taskId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    DoTaskBean doTaskBean = (DoTaskBean) obj;
                    if (doTaskBean != null) {
                        getView().onSuccess(doTaskBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUserTaskList(String userId, String sessionId) {
        mainModel.onUserTaskList(userId, sessionId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    UserTaskListBean userTaskListBean = (UserTaskListBean) obj;
                    if (userTaskListBean != null) {
                        getView().onSuccess(userTaskListBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onDisease(int departmentId) {
        mainModel.onDisease(departmentId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    DiseaseBean diseaseBean = (DiseaseBean) obj;
                    if (diseaseBean != null) {
                        getView().onSuccess(diseaseBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onReplease(String userId, String sessionId, Map<String, Object> map) {
        mainModel.onReplease(userId, sessionId, map, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    RepleaseCircleBean repleaseCircleBean = (RepleaseCircleBean) obj;
                    if (repleaseCircleBean != null) {
                        getView().onSuccess(repleaseCircleBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onPicture(String userId, String sessionId, int sickCircleId, List<MultipartBody.Part> part) {
        mainModel.onPicture(userId, sessionId, sickCircleId, part, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    PictureBean pictureBean = (PictureBean) obj;
                    if (pictureBean != null) {
                        getView().onSuccess(pictureBean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

}