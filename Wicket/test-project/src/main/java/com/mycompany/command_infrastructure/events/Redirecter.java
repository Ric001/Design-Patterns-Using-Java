package com.mycompany.command_infrastructure.events;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;

public class Redirecter implements Reciever, Serializable {

    private Optional<? extends WebPage> pageRef;
    private Optional<Class<? extends Page>> pageToRender;

    private final static Logger _LOG = Logger.getLogger(Redirecter.class.getName());
    private final static long serialVersionUID = 1l;
    
    public Redirecter(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender) {
        this.pageRef = pageRef;
        this.pageToRender = pageToRender;
    } 

    public void redirect() {
        _LOG.info("[ENTERING void redirect()]");
        
        if (pageRef.isPresent() && pageToRender.isPresent())
            pageRef.get().setResponsePage(pageToRender.get());

        _LOG.info("[ENDING void redirect()]");
    }

    
}