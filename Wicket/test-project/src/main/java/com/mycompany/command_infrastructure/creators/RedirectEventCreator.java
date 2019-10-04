package com.mycompany.command_infrastructure.creators;

import java.io.Serializable;
import java.util.Optional;

import com.mycompany.Strings;
import com.mycompany.command_infrastructure.ICommand;
import com.mycompany.command_infrastructure.RedirectEvent;
import com.mycompany.command_infrastructure.events.Redirecter;
import com.mycompany.command_infrastructure.events.exceptions.ErrorMessages;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedirectEventCreator implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient Optional<ICommand> eventExecuter;
    public final static String LAST_VISITED_PAGE = "last-visited-page";
    private final Logger _LOG = LoggerFactory.getLogger(RedirectEvent.class);

   public RedirectEventCreator(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender) {
        setCommand(pageRef, pageToRender);
   }

   public void setCommand(final Optional<? extends WebPage> pageRef, final Optional<Class<? extends Page>> pageToRender) {
       _LOG.info("[ENTERING void setCommand(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender)]");

       final Optional<Redirecter> redirecter = Optional.of(new Redirecter(pageRef, pageToRender));
       final RedirectEvent redirectingEvent = new RedirectEvent(redirecter); 
       eventExecuter = Optional.of(redirectingEvent);
       saveLastPageBeforeRedirection(pageRef); 
        
       _LOG.info("[ENDNIG void setCommand(Optional<? extends WebPage> pageRef, Optional<Class<? extends Page>> pageToRender)]");
   }

   private void saveLastPageBeforeRedirection(final Optional<? extends WebPage> lastVisitedPage) {
       _LOG.info("[ENTERING void saveLastPageBeforeRedirection(final Optional<? extends WebPage> lastVisitedPage)]");

       final Class<? extends WebPage> pageClass = lastVisitedPage.get().getClass();

        if (lastVisitedPage.isPresent())
            lastVisitedPage.get().getSession().setAttribute(LAST_VISITED_PAGE, pageClass);
        
        _LOG.info("[ENDING saveLastPageBeforeRedirection(final Optional<? extends WebPage> lastVisitedPage)]");
    }

   public Link<Void> event(final String id) 
   {
    _LOG.info("[ENTERING Link<Void> event(final String id)]");

        if (Strings.isNullOrEmpty(id))
        {
            throw new IllegalStateException(ErrorMessages.ILLEGAL_STATE_MESSAGE.toString());
        }

        final Link<Void> event = new Link<Void>(id) 
        {
            private final static long serialVersionUID = 1L;
            @Override
            public void onClick() 
            {
                if (eventExecuter.isPresent()) 
                    eventExecuter.get().execute();
            }
        };

    _LOG.info("[ENDING Link<Void> event(final String id) " + event + "]");
    return event;
   }

}