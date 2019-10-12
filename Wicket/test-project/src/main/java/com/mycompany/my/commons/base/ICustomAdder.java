package com.mycompany.my.commons.base;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public interface ICustomAdder {

    public final static String ERROR_MESSAGE = "NO SE PUEDE CARGAR ESTA PAGINA";

    public ICustomAdder add(Component... components);

    public ICustomAdder setFatherContainer(WebMarkupContainer clientContainer);

    public ICustomAdder setFatherContainer(WebPage page);

    public ICustomAdder setFatherContainer(AjaxRequestTarget target);


}