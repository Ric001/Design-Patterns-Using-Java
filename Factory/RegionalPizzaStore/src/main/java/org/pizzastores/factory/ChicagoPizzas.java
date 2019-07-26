package org.pizzastores.factory;

public enum ChicagoPizzas {
    CHICAGO_CHESSE("Chicago chessy"), 
    CHICAGO_PEPERONI("Chicago Peperoni"), 
    CHICAGO_VEGGIE("Chicago Veggie");
    
    private String type;
    
    private ChicagoPizzas(String type) {
        this.setType(type);
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}