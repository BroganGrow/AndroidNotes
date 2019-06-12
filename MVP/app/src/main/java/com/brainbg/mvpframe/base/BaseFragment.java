package com.brainbg.mvpframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail.com
 *     time   : 2019/05/31
 *     desc   :Fragment的基础类
 * </pre>
 * <p>
 */
public abstract class BaseFragment<P extends BaseContract.IPresenter<BaseContract.IView>> extends Fragment implements BaseContract.IView {
    /**
     * @return 布局ID
     */
    public abstract int getLayoutResID();

    /**
     * 初始化成员View
     *
     * @param savedInstanceState bundle
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 初始化状态栏
     */
    protected abstract void initStatusBar();

    protected P mPresenter;

    /**
     * 初始化 Presenter
     *
     * @return 泛型
     */
    public abstract P bindPresenter();

    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 根view
     */
    protected View mRootView;
    Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutResID(), container, false);
        this.mContext = getActivity();
        unbinder = ButterKnife.bind(this, mRootView);

        mPresenter = bindPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        init(savedInstanceState);
        initStatusBar();

        return mRootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
        this.mPresenter = null;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).hideLoading();
    }


    @Override
    public void showErr() {
        checkActivityAttached();
        ((BaseActivity) mContext).showErr();
    }

    protected boolean isAttachedContext() {
        return getActivity() != null;
    }

    @Override
    public void showNullLayout() {

    }

    @Override
    public void hideNullLayout() {

    }

    @Override
    public void showErrorLayout(View.OnClickListener listener) {

    }

    @Override
    public void hideErrorLayout() {

    }

    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException {
        ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}