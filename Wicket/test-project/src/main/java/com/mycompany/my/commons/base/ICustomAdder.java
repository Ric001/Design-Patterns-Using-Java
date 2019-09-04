package com.mycompany.my.commons.base;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public interface ICustomAdder {

    public final static String ERROR_MESSAGE = "NO SE PUEDE CARGAR ESTA PAGINA";
    
    public boolean areBothValid(Object container, Component... components);

    public WebMarkupContainer add(WebMarkupContainer clientContainer, Component... components);

    public WebPage add(WebPage page, Component... components);
}