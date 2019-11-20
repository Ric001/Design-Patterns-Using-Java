package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		//RequestCycleSettings requestCycleSettings = getRequestCycleSettings();
		//requestCycleSettings.setRenderStrategy(RenderStrategy.REDIRECT_TO_BUFFER);
		//requestCycleSettings.setRenderStrategy(RenderStrategy.ONE_PASS_RENDER);
		//requestCycleSettings.setRenderStrategy(RenderStrategy.REDIRECT_TO_BUFFER);
		// add your configuration here
	}
}
