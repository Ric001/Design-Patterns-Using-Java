package com.mycompany;

import org.apache.commons.fileupload.RequestContext;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxRequestTarget.ITargetRespondListener;
import org.apache.wicket.core.request.handler.IPageRequestHandler;
import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.UrlRenderer;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class RedirectRequestTarget implements IRequestHandler {
    private final String redirectUrl;
	
    public RedirectRequestTarget(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
	
    @Override
    public void respond(IRequestCycle iRequestCycle) {
        RequestCycle requestCycle = (RequestCycle) iRequestCycle;
        Response response = requestCycle.getResponse();
        response.reset();
        //requestCycle.get().setRequestTarget
    }

    public String getRedirectUrl() {
        return redirectUrl;
    } 
}