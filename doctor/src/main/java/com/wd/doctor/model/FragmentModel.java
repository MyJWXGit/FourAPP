package com.wd.doctor.model;

import com.wd.common.utils.HttpUtils;
import com.wd.doctor.api.ApiService;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.bean.PhotographBean;
import com.wd.doctor.bean.UploadingBean;
import com.wd.doctor.contract.Contract;

import okhttp3.MultipartBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/14
 * author:金豪(Lenovo)
 * function:
 */
public class FragmentModel implements Contract.FModer{
    //病友圈
    @Override
    public void Patients(int departmentId, int page, int count, Contract.IModer.IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Patients(departmentId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PatientsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(PatientsBean patientsBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(patientsBean);
                        }
                    }
                });
    }
    //查询病友圈详情
    @Override
    public void Details(int doctorId, String sessionId, int sickCircleId, Contract.IModer.IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Detals(doctorId,sessionId,sickCircleId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(detailsBean);
                        }
                    }
                });
    }

    @Override
    public void Imagep(Contract.IModer.IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Imagep()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ImagePicBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(ImagePicBean imagePicBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(imagePicBean);
                        }
                    }
                });
    }

    @Override
    public void Uploading(int doctorId, String sessionId, String imagePic, Contract.IModer.IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Uploading(doctorId, sessionId, imagePic)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UploadingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(UploadingBean uploadingBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(uploadingBean);
                        }
                    }
                });
    }
    //上传图片
    @Override
    public void Photograph(int doctorId, String sessionId, MultipartBody.Part part, Contract.IModer.IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Photograph(doctorId,sessionId,part)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PhotographBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(PhotographBean photographBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(photographBean);
                        }
                    }
                });
    }


}
