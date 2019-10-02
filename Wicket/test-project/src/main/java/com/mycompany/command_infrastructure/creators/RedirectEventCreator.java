package com.mycompany.command_infrastructure.creators;

import java.util.Optional;

import com.mycompany.command_infrastructure.ICommand;
import com.mycompany.command_infrastructure.RedirectEvent;
import com.mycompany.command_infrastructure.events.Reciever;
import com.mycompany.command_infrastructure.events.Redirecter;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedirectEventCreator {
    
   private Optional<ICommand> eventExecuter;
   
   private final Logger _LOG = LoggerFactory.getLogger(RedirectEvent.class);

   public RedirectEventCreator(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender) {
        setCommand(pageRef, pageToRender);
   }

   public void setCommand(final Optional<? extends WebPage> pageRef, final Optional<Class<? extends Page>> pageToRender) {
       _LOG.info("[ENTERING void setCommand(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender)]");

       final Optional<Redirecter> redirecter = Optional.of(new Redirecter(pageRef, pageToRender));
       final RedirectEvent redirectingEvent = new RedirectEvent(redirecter); 
       eventExecuter = Optional.of(redirectingEvent);

       _LOG.info("[ENDNIG void setCommand(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender)]");
   }

   public Link<Void> event(final String id) {
     _LOG.info("[ENTERING Link<Void> event(final String id)]");
        final Link<Void> event = new Link<Void>(id) {
            private final static long serialVersionUID = 1L;
            @Override
            public void onClick() {
                if (eventExecuter.isPresent()) 
                    eventExecuter.get().execute();
            }
        };
        _LOG.info("[ENTERING Link<Void> event(final String id)]");
        return event;
   }

   
}