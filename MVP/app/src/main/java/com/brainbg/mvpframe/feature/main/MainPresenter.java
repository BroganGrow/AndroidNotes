package com.brainbg.mvpframe.feature.main;

import com.brainbg.mvpframe.base.BasePresenter;
import com.brainbg.mvpframe.data.model.UserInfoParser;


/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/10
 *     desc   :
 * </pre>
 */
public class MainPresenter extends BasePresenter<MainContract.MineView> implements MainContract.IMinePresenter {

    @Override
    public void setUserInfo() {
        new MainModel().getUserInfo(new MainContract.MineCallback() {
            @Override
            public void onSuccess(UserInfoParser data) {
                if (isViewAttached()) {
                    getView().setUserInfo(data);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onCompleted() {

            }
        });

    }
}
