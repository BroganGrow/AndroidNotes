package com.brainbg.mvpframe;

import com.brainbg.mvpframe.data.model.UserInfoParser;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/09
 *     desc   : 接口中心,管理App所有的接口
 * </pre>
 */
public interface APICenter {

    /**
     * @param service 接口名称
     * @param token   token
     * @return 登录信息
     */
    @FormUrlEncoded
    @POST(Config.WEB)
    Observable<UserInfoParser> getUserInfo(@Field("service") String service,
                                               @Field("token") String token);


}
