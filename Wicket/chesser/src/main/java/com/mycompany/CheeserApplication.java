package com.mycompany;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class CheeserApplication extends WebApplication {

    private List<Chesse> cheesses = Arrays.asList(
        new Chesse("CHEDAR", "CHEDAR is an italian[.....]", 10.5F),
        new Chesse("GOUDA", "Gouda is a yellowish ducth[.....]", 10.5F),
        new Chesse("GOUDA", "Gouda is a yellowish ducth[.....]", 10.5F),
        new Chesse("GOUDA", "Gouda is a yellowish ducth[.....]", 10.5F),
        new Chesse("GOUDA", "Gouda is a yellowish ducth[.....]", 10.5F)
    );

    @Override
    public Class<? extends Page> getHomePage() {
        return  Index.class;
    }

    @Override 
    public void init() {
        super.init();
    }

    public static CheeserApplication get() {
        return (CheeserApplication) Application.get();
    }

    public List<Chesse> getChesses() {
        return Collections.unmodifiableList(cheesses);
    }

    @Override
    public Session newSession(Request request, Response repsonse) {
        return new CheeserSession(request);
    }
    
}

