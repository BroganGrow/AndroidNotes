package com.brainbg.mvpframe.feature.main;

import com.brainbg.mvpframe.base.BaseContract;
import com.brainbg.mvpframe.data.model.UserInfoParser;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/09
 *     desc   :我的-契约
 * </pre>
 */
public interface MainContract {

    interface MineModel extends BaseContract.IModel{
        void getUserInfo(MineCallback mMineCallback);
    }

    interface IMinePresenter extends BaseContract.IPresenter<MineView> {
        void setUserInfo();
    }

    interface MineView extends BaseContract.IView {
        void setUserInfo(UserInfoParser mUserInfoBean);
    }

    interface MineCallback extends BaseContract.ICallback<UserInfoParser> {

    }

}
