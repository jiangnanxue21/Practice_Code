package com.example.mode.templete;

/**
 * Created by xue on 15/9/13.
 */
public abstract class RefreshBeverage {
    
    public final void prepareBeverageTemplate()
    {
        boiwater() ;
        brew() ;
        pourInCup() ;
        if (isCustomerWantsCondiments())//Hook
            addCondiments() ;
            
    }

    protected abstract void addCondiments();

    protected boolean isCustomerWantsCondiments() {
        return true;
    }

    private void pourInCup() {
        System.out.println("将饮料倒入茶杯中...");
    }

    protected abstract void brew();

    private void boiwater() {

        System.out.println("冲泡饮料..");
    }
}
