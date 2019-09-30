package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycompany.models.Recipe;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.ExternalLink;

public class HomePage extends WebPage {
	
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		add(new Label("message", "<h1>Hello World from a label component</h1>").setEscapeModelStrings(true));
		add(new Label("message2", "SNAP OUT OF IT"));
		add(new Label("message3", "Forever is for everyone"));
		add(new Label("message4", "I get both feeling, and i like to..."));
		add(new MultiLineLabel("multi-line", "Loose\nYourself"));

		Recipe recipeDomain = new Recipe("https://www.delish.com/cooking/recipe-ideas/g3176/","weeknight-pasta-dinners/");
		ExternalLink recepiUrl = new ExternalLink("link", recipeDomain.getUrl(), recipeDomain.getMealName());
		add(recepiUrl);
	}
	
}
