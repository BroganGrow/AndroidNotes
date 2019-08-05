package com.brainbg.designpattern.simpleFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   :一个专门生产数据线的工厂，提供生产苹果、安卓数据线
 * </pre>
 */
class DataLineFactory {
    static final int APPLE = 1;
    static final int ANDROID = 2;

    static DataLine product(int productName) {
        switch (productName) {
            case APPLE:
                return new AppleDataLine();
            case ANDROID:
                return new AndroidDataLine();
            default:
                return null;
        }
    }

}
