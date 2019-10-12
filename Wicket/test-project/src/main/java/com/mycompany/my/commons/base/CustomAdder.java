package com.mycompany.my.commons.base;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class CustomAdder implements ICustomAdder {

    private final static Logger _LOG = Logger.getLogger(CustomAdder.class.getName());

    private Optional<MarkupContainer> container;
    private Optional<WebPage> page;
    private Optional<AjaxRequestTarget> target;
    
    @Override
    public ICustomAdder add(Component... components) 
    {
        if (isNull(components))
            return this;

        if(container.isPresent())
            for(Component children : components)
                container.get().add(children);
        
        else if (page.isPresent())
            for(Component children : components)
                page.get().add(children);

        else if (target.isPresent())
            for (Component child : components)
                page.get().add(child);

        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(WebMarkupContainer clientContainer) {
        this.container = Optional.of(clientContainer);
        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(WebPage page) {
        this.page = Optional.of(page);
        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(AjaxRequestTarget target) {
        this.target = Optional.of(target);
        return this;
    }
}