package com.brainbg.mvpframe.base;


/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail.com
 *     time   : 2019/05/31
 *     desc   :Presenter的基础类
 * </pre>
 */
public class BasePresenter<V extends BaseContract.IView> implements BaseContract.IPresenter<V> {

    protected V iView;

    @Override
    public void attachView(V iView) {
        this.iView = iView;
    }

    @Override
    public void detachView() {
        this.iView = null;
    }

    @Override
    public boolean isViewAttached() {
        return iView != null;
    }

    @Override
    public V getView() {
        return iView;
    }
}