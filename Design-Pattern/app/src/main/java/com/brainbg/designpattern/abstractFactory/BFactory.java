package com.brainbg.designpattern.abstractFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   :电子厂B,专门生产安卓数据线、和普通充电器
 * </pre>
 */
public class BFactory extends ElectronicsFactory {
    private String factoryName;

    public BFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public DataLine produceDataLine() {
        return new AndroidDataLine(factoryName);
    }

    @Override

    public Charger produceCharger() {
        return new GeneralCharger(factoryName);
    }
}
