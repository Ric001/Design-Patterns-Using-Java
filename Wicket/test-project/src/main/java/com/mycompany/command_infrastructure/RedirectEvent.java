package com.mycompany.command_infrastructure;

import java.util.Optional;
import java.util.logging.Logger;

import com.mycompany.command_infrastructure.events.Redirecter;

public class RedirectEvent implements ICommand {

    private Optional<Redirecter> redirecter;
    private final static Logger _LOG = Logger.getLogger(RedirectEvent.class.getName());
    
    public RedirectEvent(Optional<Redirecter> redirecter) {
        this.setRedirecter(redirecter);
    }

    public Optional<Redirecter> getRedirecter() {
        return redirecter;
    }

    public void setRedirecter(Optional<Redirecter> redirecter) {
        this.redirecter = redirecter;
    }

    @Override
    public void execute() {
       if (redirecter.isPresent())
        redirecter.get().redirect();
    }

}