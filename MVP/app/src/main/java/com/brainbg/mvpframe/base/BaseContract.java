package com.brainbg.mvpframe.base;

import android.view.View;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/11
 *     desc   :契约基类
 * </pre>
 */
public interface BaseContract {

    interface IView{

        /**
         * 显示正在加载view
         */
        void showLoading();

        /**
         * 关闭正在加载view
         */
        void hideLoading();

        /**
         * 显示空数据布局
         */
        void showNullLayout();

        /**
         * 隐藏空数据布局
         */
        void hideNullLayout();

        /**
         * 显示异常布局
         *
         * @param listener
         */
        void showErrorLayout(View.OnClickListener listener);

        /**
         * 隐藏异常布局
         */
        void hideErrorLayout();

        /**
         * 显示请求错误提示
         */
        void showErr();
    }

    interface IPresenter<V extends IView> {


        /**
         * 绑定view，一般在初始化中调用该方法
         */
        void attachView(V iView);

        /**
         * 断开view，一般在onDestroy中调用
         */
        void detachView();

        /**
         * 是否与View建立连接
         * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
         */
        boolean isViewAttached();

        /**
         * 获取连接的view
         */
        V getView();
    }

    interface IModel {

    }

    interface ICallback<T> {

        /**
         * 数据请求成功
         *
         * @param data 请求到的数据
         */
        void onSuccess(T data);

        /**
         * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
         * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
         */
        void onError(Throwable e);

        /**
         * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
         * 请求时可以在此处隐藏“正在加载”的等待控件
         */
        void onCompleted();

    }
}
