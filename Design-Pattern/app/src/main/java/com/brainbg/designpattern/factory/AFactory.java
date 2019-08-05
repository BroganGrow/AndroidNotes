package com.brainbg.designpattern.factory;

public class AFactory extends DataLineFactory {
    @Override
    public DataLine product() {
        return new AppleDataLine();
    }
}
