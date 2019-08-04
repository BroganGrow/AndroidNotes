package com.brainbg.designpattern.singleton;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/01
 *     desc   :枚举
 * </pre>
 */
public enum EnumSingleton {
    //定义的枚举元素为单例类的实例
    INSTANCE;

    //隐藏了一个私有构造方法
    //private EnumSingleton() {}
    //获取该单例
    //EnumSingleton instance = EnumSingleton.INSTANCE;
}
