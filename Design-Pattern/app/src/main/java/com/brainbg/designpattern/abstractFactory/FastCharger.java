package com.brainbg.designpattern.abstractFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   :快充电器
 * </pre>
 */
public class FastCharger extends Charger {
    private String factoryName;

    public FastCharger(String factoryName) {
        this.factoryName = factoryName;
    }
    @Override
    public String produceCharger() {
        return factoryName+"生产了一批快速充电器 \n";
    }
}
