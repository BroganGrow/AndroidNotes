package com.brainbg.designpattern.Singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/06/26
 *     desc   :懒汉式
 * </pre>
 */
public class LazySingleton {
    private static volatile LazySingleton instance; //保证 instance 在所有线程中同步

    private LazySingleton() {
        //private 避免类在外部被实例化
    }

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
