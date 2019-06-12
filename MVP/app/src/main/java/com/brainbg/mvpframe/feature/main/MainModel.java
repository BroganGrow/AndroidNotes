package com.brainbg.mvpframe.feature.main;

import com.blankj.utilcode.util.LogUtils;
import com.brainbg.mvpframe.data.model.UserInfoParser;
import com.brainbg.mvpframe.util.RetrofitHelper;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/10
 *     desc   :
 * </pre>
 */
public class MainModel implements MainContract.MineModel {

    @Override
    public void getUserInfo(final MainContract.MineCallback mMineCallback) {
        RetrofitHelper
                .getInstance()
                .getApiCenter()
                .getUserInfo("User.Getuserinfo", "69cef1a19a3d3ebc808275558ad813de")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoParser>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("onError：" , e.toString());
                    }

                    @Override
                    public void onNext(UserInfoParser userInfoBean) {
                        mMineCallback.onSuccess(userInfoBean);
                    }
                });
    }

}
