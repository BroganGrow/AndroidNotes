package com.brainbg.designpattern.builder.simple;

/**
 * <pre>
 *     author : brainbg
 *     e-mail : brainbg@foxmail.com
 *     time   : 2019/08/15
 *     desc   :
 * </pre>
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartA("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartA("建造 PartC");
    }
}
