package com.brainbg.designpattern.Singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/01
 *     desc   :懒汉式（同步锁，线程安全）
 * </pre>
 */
public class SafeLazySingleton {
    private static SafeLazySingleton instance;

    private SafeLazySingleton() {
    }

    //写法一
    public static synchronized SafeLazySingleton getInstance() {
        if (instance == null)
            instance = new SafeLazySingleton();
        return instance;
    }

    //写法二
    public static SafeLazySingleton getNewInstance() {
        synchronized (SafeLazySingleton.class) {
            if (instance == null)
                instance = new SafeLazySingleton();
        }
        return instance;
    }
}
