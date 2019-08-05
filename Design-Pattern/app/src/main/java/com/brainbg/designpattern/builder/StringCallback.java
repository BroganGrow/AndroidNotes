package com.brainbg.designpattern.builder;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   :
 * </pre>
 */
public interface StringCallback {
    void onSuccess(String result);

    void onError(String error);
}
