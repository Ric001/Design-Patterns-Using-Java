package com.mycompany;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public abstract class CheeserPage extends WebPage {
    private static final long serialVersionUID = 1L;

    public CheeserSession getCheeserSession() {
        return (CheeserSession) getSession();
    }

    public Cart getCart() {
        return getCheeserSession().getCart();
    }

    public List<Chesse> getCheesses() {
        return CheeserApplication.get().getChesses();
    }
}