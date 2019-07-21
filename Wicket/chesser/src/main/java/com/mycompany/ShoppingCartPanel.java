package com.mycompany;

import org.apache.wicket.markup.html.panel.Panel;

public class ShoppingCartPanel extends Panel {
    private Cart cart; 
    
    public ShoppingCartPanel(String id, Cart cart) {
        super(id);
        this.cart = cart;
    }

    private Cart getCart() {
        return cart;
    }
}