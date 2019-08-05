package com.brainbg.designpattern.simpleFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/03
 *     desc   : 安卓数据线
 * </pre>
 */
public class AndroidDataLine extends DataLine {
    @Override
    public String produce() {
        return "生产了一批安卓(Android)数据线 \n";
    }
}
