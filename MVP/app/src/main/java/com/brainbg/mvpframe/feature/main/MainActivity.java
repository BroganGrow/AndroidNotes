package com.brainbg.mvpframe.feature.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brainbg.mvpframe.R;
import com.brainbg.mvpframe.base.BaseActivity;
import com.brainbg.mvpframe.data.model.UserInfoParser;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.MineView {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.btn_get_user_info)
    Button btnRequestUserInfo;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initStatusBar() {

    }

    @Override
    public MainPresenter bindPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setUserInfo(UserInfoParser mUserInfoBean) {
        tvContent.setText(mUserInfoBean.toString());
        Log.i(TAG, mUserInfoBean.toString());
    }


    @OnClick(R.id.btn_get_user_info)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_user_info:
                mPresenter.setUserInfo();
                break;
        }
    }

}