package com.brainbg.designpattern.abstractFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   : 普通充电器
 * </pre>
 */
public class GeneralCharger extends Charger {

    private String factoryName;

    public GeneralCharger(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String produceCharger() {
        return factoryName + "生产了一批普通充电器 \n";
    }
}
