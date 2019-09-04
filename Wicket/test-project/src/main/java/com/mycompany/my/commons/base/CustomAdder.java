package com.mycompany.my.commons.base;

import java.util.Objects;
import java.util.logging.Logger;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class CustomAdder implements ICustomAdder {

    private final static Logger _LOG = Logger.getLogger(CustomAdder.class.getName());

    @Override
    public WebMarkupContainer add(WebMarkupContainer clientContainer, Component... components) {
        _LOG.info("[ENTERING WebMarkupContainer add(WebMarkupContainer clientContainer, Component... components)]");

        if (areBothValid(clientContainer, components))
            for (Component component : components)
                clientContainer.add(component);
        else 
            clientContainer.info(ERROR_MESSAGE);

        _LOG.info("[RETURNING FROM WebMarkupContainer add(WebMarkupContainer clientContainer, Component... components)]");
        return clientContainer;
    }

    @Override
    public boolean areBothValid(Object container, Component... components) {
        _LOG.info("[ENTERING boolean areBothValid(WebMarkupContainer container, Component... components)]");

        if (Objects.nonNull(container) && Objects.nonNull(components))
            return true;

        _LOG.info("[RETURNING FROM boolean areBothValid(WebMarkupContainer container, Component... components)]");
        return false;
    }

    @Override
    public WebPage add(WebPage page, Component... components) {
        _LOG.info("[ENTERING WebPage add(WebPage page, Component... components)]");

        if (areBothValid(page, components))
            for(Component componentToAdd : components)
                page.add(componentToAdd);
        else
            page.info(ERROR_MESSAGE);   

        _LOG.info("[RETURNING WebPage add(WebPage page, Component... components) " + page + "]");
        return page;
    }
}