package com.brainbg.designpattern.factory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   : 苹果数据线
 * </pre>
 */
public class AppleDataLine extends DataLine {
    @Override
    public String produceLine() {
        return "生产了一批苹果(Apple)数据线 \n";
    }
}
