package com.brainbg.mvpframe.util;

import com.brainbg.mvpframe.APICenter;
import com.brainbg.mvpframe.Config;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/09
 *     desc   :Retrofit的工具类
 * </pre>
 */
public class RetrofitHelper {
    private volatile static RetrofitHelper mInstance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitHelper.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitHelper();
                }
            }
        }
        return mInstance;
    }

    private RetrofitHelper() {
        initRetrofit();
    }


    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.WEB)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public APICenter getApiCenter() {
        return mRetrofit.create(APICenter.class);
    }

}