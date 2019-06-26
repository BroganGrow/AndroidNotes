package com.brainbg.designpattern.Singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/26
 *     desc   :饿汉式
 * </pre>
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}