package com.example.mode.factory;

/**
 * Created by xue on 15/9/12.
 */
public class MCFactory implements PersonFactory {


    @Override
    public Girl getGirl() {
        return new MCGirl();
    }

    @Override
    public Boy getBoy() {
        return new MCBoy();
    }
}
