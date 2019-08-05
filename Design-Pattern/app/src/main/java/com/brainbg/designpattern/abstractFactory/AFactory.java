package com.brainbg.designpattern.abstractFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   :电子厂A，专门生产苹果数据线、和快充
 * </pre>
 */
public class AFactory extends ElectronicsFactory {
    private String factoryName;

    public AFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public DataLine produceDataLine() {
        return new AppleDataLine(factoryName);
    }

    @Override
    public Charger produceCharger() {
        return new FastCharger(factoryName);
    }
}
