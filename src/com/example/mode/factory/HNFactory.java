package com.example.mode.factory;

/**
 * Created by xue on 15/9/12.
 */
public class HNFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new HNBoy();
    }

    @Override
    public Girl getGirl() {
        return new HNGirl();
    }
}
