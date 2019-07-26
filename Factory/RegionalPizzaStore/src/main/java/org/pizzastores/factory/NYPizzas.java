package org.pizzastores.factory;

public enum NYPizzas {
    NY_CHESSY("New York Chessy"), NY_PEPERONI("New York Chessy"), NY_VEGGIE("New York Veggie");
    private String type;

    private NYPizzas(String type) {
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}