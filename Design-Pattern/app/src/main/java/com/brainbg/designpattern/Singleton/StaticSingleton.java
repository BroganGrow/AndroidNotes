package com.brainbg.designpattern.Singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/01
 *     desc   :静态内部类/登记式
 * </pre>
 */
public class StaticSingleton {
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
