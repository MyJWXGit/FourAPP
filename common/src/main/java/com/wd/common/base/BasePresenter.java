package com.wd.common.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {
    private WeakReference<V> reference;

    //无参构造方法  用来绑定Model
    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void attachView(V v) {
        reference = new WeakReference<>(v);
    }

    protected void detachView() {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }

    protected boolean isViewAttached() {
        if (reference == null || reference.get() == null) {
            return false;
        }
        return true;
    }

    protected V getView() {
        return reference.get();
    }
}
