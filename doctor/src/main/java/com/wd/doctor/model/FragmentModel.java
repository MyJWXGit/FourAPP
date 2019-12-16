package com.wd.doctor.model;

import com.wd.common.utils.HttpUtils;
import com.wd.doctor.api.ApiService;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.contract.Contract;

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


}
