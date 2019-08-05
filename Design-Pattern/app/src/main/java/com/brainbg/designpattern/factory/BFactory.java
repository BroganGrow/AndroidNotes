package com.brainbg.designpattern.factory;

public class BFactory extends DataLineFactory {
    @Override
    public DataLine product() {
        return new AndroidDataLine();
    }
}
