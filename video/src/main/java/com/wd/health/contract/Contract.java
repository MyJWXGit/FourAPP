package com.wd.health.contract;


import com.wd.common.base.IBaseView;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/
public interface Contract {

        interface IView extends IBaseView {
            void onSuccess(Object data);
            void onError(Throwable e);
        }
        interface IModel{
            //查询视频类目
            void onVideo_Entry(IModelCallBack iModelCallBack);
            //根据类目ID查询视频
            void onVideo_Query(String userId, String sessionId, String categoryId, String page, String count, IModelCallBack iModelCallBack);

            interface IModelCallBack{
                void onSuccess(Object data);
                void onError(Throwable e);
            }
        }
        interface IPresenter{
            //查询视频类目
            void onVideo_Entry();
            //根据类目ID查询视频
            void onVideo_Query(String categoryId, String page, String count);

        }
        //Fragment   M
    interface FModel{
            //发送评论（弹幕）
            void onVideo_Send(String userId,String sessionId,String videoId,String content,FModelCallBack fModelCallBack);
            //购买视频
            void onVideo_Pay(String userId,String sessionId,String videoId,String price,FModelCallBack fModelCallBack);
            //收藏视频
            void onVideo_Query_Barrage(String videoId,FModelCallBack iModelCallBack);
            //收藏视频
            void onVideo_Collection(String userId, String sessionId, String videoId,FModelCallBack iModelCallBack);
            interface FModelCallBack{
                void onSuccess(Object data);
                void onError(Throwable e);
            }
        }
        //Fragment P
    interface FPresenter{
            //收藏视频
            void onVideo_Collection(String videoId);
            //查询弹幕
            void onVideo_Query_Barrage(String videoId);
            //购买视频
            void onVideo_Pay(String videoId,String price);
            //发送评论（弹幕）
            void onVideo_Send(String videoId,String content);
        }
}
