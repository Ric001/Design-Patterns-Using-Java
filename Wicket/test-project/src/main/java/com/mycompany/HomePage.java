package com.mycompany;

import java.util.Optional;

import com.mycompany.command_infrastructure.creators.RedirectEventCreator;
import com.mycompany.command_infrastructure.events.Redirecter;
import com.mycompany.models.Recipe;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	public final static String MEAL_NAME = "name";
	private transient final static Logger _LOG = LoggerFactory.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("message", "<h1>Hello World from a label component</h1>").setEscapeModelStrings(true));
		add(new Label("message2", "SNAP OUT OF IT"));
		add(new Label("message3", "Forever is for everyone"));
		add(new Label("message4", "I get both feeling, and i like to..."));
		add(new MultiLineLabel("multi-line", "Loose\nYourself"));

		Recipe recipeDomain = new Recipe("https://www.delish.com/cooking/recipe-ideas/g3176/",
				"weeknight-pasta-dinners/");
		ExternalLink recepiUrl = new ExternalLink("link", recipeDomain.getUrl(), recipeDomain.getMealName());
		add(recepiUrl);
		externalLink(20);
		add(link());
		addingRecepies();
		hamburger();

		ICustomAdder customAdder = new CustomAdder();
		customAdder.add(this, redirectionEvent("redirecter"));
	}

	private Link<Void> redirectionEvent(final String id) {
		_LOG.info("[ENTERING Link<Void> redirectionEvent(final String id)]");
		
		final Optional<? extends WebPage> thisPage = Optional.of(this);
		final Optional<Class<? extends Page>> pageToRender = Optional.of(InfoPage.class);

		return new RedirectEventCreator(thisPage, pageToRender).event(id);
	}

	private void externalLink(final int registrationId) {
		_LOG.info("[ENTERING void externalLinkGenerator()]");

		final Class<InfoPage> page = InfoPage.class;
		final PageParameters pageParameters = new PageParameters().add("id", "id=" + registrationId);
		final String url = (String) urlFor(page, pageParameters);
		final String message = "Click on the following link:\n\n" + url + "\n\nto Confirm Registration";

		System.out.println(message);

		_LOG.info("[ENDING void externalLinkGenerator()]");
	}

	private BookmarkablePageLink<InfoPage> link() {
		_LOG.info("[ENTERING BookmarkablePageLink link()]");

		final BookmarkablePageLink<InfoPage> link = new BookmarkablePageLink<>("bookmarkable-link", InfoPage.class);
		final Class<InfoPage> infoPageClass = InfoPage.class;

		System.out.println(link + "\n" + "Class: " + infoPageClass);
		_LOG.info("[RETURNING BookmarkablePageLink link()]");
		return link;
	}

	private void addingRecepies() {
		_LOG.info("[ENTERING void addingRecepies()]");

		final Recipe recepie = new Recipe("whwhwhw","Anaconada Rusty");
		final PageParameters recipesUrlParams = new PageParameters().add("name", recepie.getMealName());
		add(new BookmarkablePageLink<>("meal-link", InfoPage.class, recipesUrlParams));
		
		System.out.println(recipesUrlParams);

		_LOG.info("[ENDING void addingRecepies()]");
	}


	private void hamburger() {
		_LOG.info("[ENTERING void hamburguer()]");

		final Recipe recipe = new Recipe("", "Cheesy Bite Hamburguer");
		final PageParameters parameters = new PageParameters().add("name", recipe.getMealName());
		final BookmarkablePageLink<InfoPage> mealLink = new BookmarkablePageLink<>("fast-food-link", InfoPage.class, parameters);
		add(mealLink);

		_LOG.info("[ENDING void hamburguer()]");
	}
	
	
}
