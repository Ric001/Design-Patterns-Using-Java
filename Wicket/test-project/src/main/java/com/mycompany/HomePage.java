package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(HomePage.class.getName());

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new PersonalInfo("personal-info"));
	
	}
}
