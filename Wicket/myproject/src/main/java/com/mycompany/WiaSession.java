package com.mycompany;

import java.util.Locale;
import java.util.Objects;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.Session;
public class WiaSession extends WebSession {

    private static final long serialVersionUID = 1L;

    private User user;

    public WiaSession(Request request) {
        super(request);
        setLocale(Locale.ENGLISH);
    }

    public static WiaSession get() {
        return (WiaSession) Session.get();
    }

    public synchronized User getUser() {
        return user;
    }
    
    public synchronized boolean isAuthenticated() {
        return Objects.isNull(user);
    }

    public synchronized void setUser(User user) {
        this.user = user;
        dirty();
    }
}