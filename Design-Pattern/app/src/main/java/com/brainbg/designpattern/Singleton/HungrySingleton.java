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
    // 1. 加载该类时，单例就会自动被创建
    private static final HungrySingleton instance = new HungrySingleton();

    // 2. 构造函数 设置为 私有权限
    // 原因：禁止他人创建实例
    private HungrySingleton() {
    }

    // 3. 通过调用静态方法获得创建的单例
    public static HungrySingleton getInstance() {
        return instance;
    }
}