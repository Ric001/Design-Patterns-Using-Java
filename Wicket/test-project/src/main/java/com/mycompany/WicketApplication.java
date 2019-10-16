package com.mycompany;

import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WicketApplication extends WebApplication {

	private final static Logger LOG = LoggerFactory.getLogger(WicketApplication.class);
	private final static String APP_NAME_PREFIX = "wicket.";
	private final static String EMPTY_SPACE = "";

	@Override
	public Class<? extends WebPage> getHomePage() {
		LOG.info("Getting Home PAGE");
		
		Class<? extends WebPage> classPage = HomePage.class;
		return classPage;
	}

	@Override
	public RuntimeConfigurationType getConfigurationType() 
	{
		return RuntimeConfigurationType.DEPLOYMENT;
	}

	@Override
	public void init()
	{
		super.init();
		LOG.info("[INITING Configurations......] -> Name: " + getName().replace(APP_NAME_PREFIX, EMPTY_SPACE));
		getApplicationSettings().setDefaultMaximumUploadSize(Bytes.kilobytes(100));
	}
}
