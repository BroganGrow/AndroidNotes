package com.brainbg.designpattern.factory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   :一个专门生产数据线的工厂，提供生产苹果、安卓数据线
 * </pre>
 */
public abstract class DataLineFactory {
    public abstract DataLine product();
}
