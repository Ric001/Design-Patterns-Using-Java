package com.mycompany;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;

public class MenuItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String caption;
    private Class<? extends WebPage> destination;

    
    public String getCaption() {
        return caption;
    }

    public Class<? extends WebPage> getDestination() {
        return destination;
    }

    public void setDestination(Class<? extends WebPage> destination) {
        this.destination = destination;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public MenuItem(String caption, Class<? extends WebPage> destination) {
        this.caption = caption;
        this.destination = destination;
    }
    
}