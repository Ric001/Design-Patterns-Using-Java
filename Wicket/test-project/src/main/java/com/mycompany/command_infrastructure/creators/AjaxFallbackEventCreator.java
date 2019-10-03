package com.mycompany.command_infrastructure.creators;

import java.io.Serializable;
import java.util.Optional;

import com.mycompany.Strings;
import com.mycompany.command_infrastructure.ICommand;
import com.mycompany.command_infrastructure.events.AdderEvent;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjaxFallbackEventCreator implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient Optional<ICommand> eventExecuter;
    private final static Logger _LOG = LoggerFactory.getLogger(AjaxFallbackEventCreator.class);
    
    public AjaxFallbackEventCreator(final Optional<? extends WebPage> container, final Optional<? extends Component> component) {
        setCommand(container, component);
    }
    public Optional<ICommand> getEventExecuter() {
        return eventExecuter;
    }

    public void setEventExecuter(Optional<ICommand> eventExecuter) {
        this.eventExecuter = eventExecuter;
    }

    public void setCommand(final Optional<? extends WebPage> container, final Optional<? extends Component> component) {
        _LOG.info("[ENTERING void setCommand(final Optional<? extends MarkupContainer> container, final Optional<? extends Component> component)]");
        
        final Optional<ICustomAdder> opCustomAdder = Optional.of(new CustomAdder());
        eventExecuter = Optional.of(new AdderEvent(component, container, opCustomAdder));
        
        _LOG.info("[ENTERING void setCommand(final Optional<? extends MarkupContainer> container, final Optional<? extends Component> component)]");
    }

    public AjaxFallbackLink<Void> event(final String id) {
        _LOG.info("[ENTERING AjaxFallbackLink<Void> event(final String id)]");

        final AjaxFallbackLink<Void> event = new AjaxFallbackLink<Void>(id) {
            private final static long serialVersionUID = 1L;

            @Override
            public void onClick(Optional<AjaxRequestTarget> target) {
                if (target.isPresent())
                    eventExecuter.get().execute();
            }
        };
    
        _LOG.info("[RETURNING FROM AjaxFallbackLink<Void> event(final String id)]");
        return event;
    }
}