package com.starbucks;

public abstract class CondimentDecorator extends Beverage {
    
    protected Beverage beverage;
    public abstract String getDescription();

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
}