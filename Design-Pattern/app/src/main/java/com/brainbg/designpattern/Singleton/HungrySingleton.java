package com.brainbg.designpattern.singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/01
 *     desc   :饿汉式
 * </pre>
 */
public class HungrySingleton {
<<<<<<< HEAD
    // 1. 加载该类时，单例就会自动被创建
    private static final HungrySingleton instance = new HungrySingleton();
=======
    private static HungrySingleton instance = new HungrySingleton();
>>>>>>> 3d243fe48784bc236be6395377ba8bf5ab41baaa

    // 2. 构造函数 设置为 私有权限
    // 原因：禁止他人创建实例
    private HungrySingleton() {
    }

    // 3. 通过调用静态方法获得创建的单例
    public static HungrySingleton getInstance() {
        return instance;
    }
}