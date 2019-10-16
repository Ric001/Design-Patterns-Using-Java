package com.mycompany.my.commons.base;

import static java.util.Objects.isNull;

import java.util.Optional;

import com.mycompany.command_infrastructure.events.exceptions.ErrorMessages;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAdder implements ICustomAdder {

    private final Logger LOG =  LoggerFactory.getLogger(CustomAdder.class);

    private Optional<MarkupContainer> container;
    private Optional<WebPage> page;
    private Optional<AjaxRequestTarget> target;
    private boolean configurated; 

    public CustomAdder() 
    {
        container = Optional.empty();
        page = Optional.empty();
        target = Optional.empty();
    }

    @Override
    public ICustomAdder add(Component... components) {
        LOG.info("[ENTERING ICustomAdder add(Component... components)]");

        if (isNull(components))
            return this;

        if (!isConfigValid())
            throw new IllegalStateException(ErrorMessages.MISSING_FATHER_CONTAINER.toString());

        if (container.isPresent())
            for (Component children : components)
                container.get().add(children);

        else if (page.isPresent())
            for (Component children : components)
                page.get().add(children);

        else if (target.isPresent())
            for (Component child : components)
                page.get().add(child);

        LOG.info("[ENDING ICustomAdder add(Component... components)]");
        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(WebMarkupContainer clientContainer) {
        this.container = Optional.of(clientContainer);
        setConfig(true);
        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(WebPage page) {
        this.page = Optional.of(page);
        setConfig(true);
        return this;
    }

    @Override
    public ICustomAdder setFatherContainer(AjaxRequestTarget target) {
        this.target = Optional.of(target);
        setConfig(true);
        return this;
    }

    @Override
    public boolean isConfigValid() {
        return configurated;
    }

    @Override
    public ICustomAdder setConfig(boolean configurated) {
        this.configurated = configurated;
        return this;
    }
}