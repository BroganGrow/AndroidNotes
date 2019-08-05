package com.brainbg.designpattern.abstractFactory;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   : 电子厂
 * </pre>
 */
public abstract class ElectronicsFactory {

    public abstract DataLine produceDataLine();

    public abstract Charger produceCharger();
}

