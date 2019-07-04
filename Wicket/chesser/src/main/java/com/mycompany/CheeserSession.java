package com.mycompany;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class CheeserSession extends WebSession {

    private static final long serialVersionUID = 1L;
    private Cart cart;
    
    public CheeserSession(Request request) {
        super(request);
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


   

}