package com.brainbg.designpattern.Singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/01
 *     desc   :懒汉式（双检锁/双重校验锁，即double-checked locking，简称DCL）
 * </pre>
 */
public class DCLSingleton {

    private volatile static DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null)
            synchronized (DCLSingleton.class) {
                if (instance == null)
                    instance = new DCLSingleton();
            }
        return instance;
    }
}
