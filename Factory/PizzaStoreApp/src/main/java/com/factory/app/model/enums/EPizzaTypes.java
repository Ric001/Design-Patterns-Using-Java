package com.factory.app.model.enums;

public enum EPizzaTypes {
    PEPERONI, CHESSY, VEGGIE;

    @Override
    public String toString() {
        switch(this) {
            case PEPERONI: return "Peperoni";
            case CHESSY: return "Chessy";
            case VEGGIE: return "Veggie";
            default: return "Unsupported Product type";
        }
    }
}