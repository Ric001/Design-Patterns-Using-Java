package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private int counter = 0;
	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Link<Void>("Link") {
			@Override
			public void onClick() {
				counter++;
			}
		});

		add(new Label("label", 
			new PropertyModel(this, "counter")));

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
