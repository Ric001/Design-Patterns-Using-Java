package com.mycompany;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.mycompany.command_infrastructure.creators.RedirectEventCreator;
import com.mycompany.command_infrastructure.events.exceptions.ErrorMessages;
import com.mycompany.models.Recipe;
import com.mycompany.my.commons.base.CustomAdder;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	public final static String MEAL_NAME = "name";
	private transient final static Logger _LOG = LoggerFactory.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);
		setResponsePage(CheesePage.class);
		add(new PersonalInfo("personal-info"));
		add(new CustomerInput("customer-info"));

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
		
		
		final RepeatingView repeatingView = menu("link-menu");
		final Link<Void> redirector = redirectionEvent("redirecter");
		final RepeatingView numberRepeater = numberRepeater("numbers");

		new CustomAdder()
			.setFatherContainer(this)
			.add(redirector, numberRepeater, repeatingView);
	}

	private Link<Void> redirectionEvent(final String id) 
	{
		_LOG.info("[ENTERING Link<Void> redirectionEvent(final String id)]");
		
		final Optional<? extends WebPage> thisPage = Optional.of(this);
		final Optional<Class<? extends Page>> pageToRender = Optional.of(InfoPage.class);

		return new RedirectEventCreator(thisPage, pageToRender).event(id);
	}

	private void externalLink(final int registrationId) 
	{
		_LOG.info("[ENTERING void externalLinkGenerator()]");

		final Class<InfoPage> page = InfoPage.class;
		final PageParameters pageParameters = new PageParameters().add("id", "id=" + registrationId);
		final String url = (String) urlFor(page, pageParameters);
		final String message = "Click on the following link:\n\n" + url + "\n\nto Confirm Registration";

		System.out.println(message);

		_LOG.info("[ENDING void externalLinkGenerator()]");
	}

	private BookmarkablePageLink<InfoPage> link() 
	{
		_LOG.info("[ENTERING BookmarkablePageLink link()]");

		final BookmarkablePageLink<InfoPage> link = new BookmarkablePageLink<>("bookmarkable-link", InfoPage.class);
		final Class<InfoPage> infoPageClass = InfoPage.class;

		System.out.println(link + "\n" + "Class: " + infoPageClass);
		_LOG.info("[RETURNING BookmarkablePageLink link()]");
		return link;
	}

	private void addingRecepies() 
	{
		_LOG.info("[ENTERING void addingRecepies()]");

		final Recipe recepie = new Recipe("whwhwhw","Anaconada Rusty");
		final PageParameters recipesUrlParams = new PageParameters().add("name", recepie.getMealName());
		add(new BookmarkablePageLink<>("meal-link", InfoPage.class, recipesUrlParams));
		
		System.out.println(recipesUrlParams);

		_LOG.info("[ENDING void addingRecepies()]");
	}


	private void hamburger() 
	{
		_LOG.info("[ENTERING void hamburguer()]");

		final Recipe recipe = new Recipe("", "Cheesy Bite Hamburguer");
		final PageParameters parameters = new PageParameters().add("name", recipe.getMealName());
		final BookmarkablePageLink<InfoPage> mealLink = new BookmarkablePageLink<>("fast-food-link", InfoPage.class, parameters);
		add(mealLink);

		_LOG.info("[ENDING void hamburguer()]");
	}
	
	private RepeatingView numberRepeater(final String id) 
	{
		_LOG.info("[ENTERING RepeatingView numberRepeater()]");

		if (Strings.isNullOrEmpty(id))
			throw new IllegalStateException(ErrorMessages.ILLEGAL_STATE_MESSAGE.toString());
		
		final RepeatingView numberRepeater = new RepeatingView(id);
		for (int i = 0; i < 3; i++)
		{
			numberRepeater.add(new Label(numberRepeater.newChildId(), "Hello " + i));
		}
		
		_LOG.info("[ENDING RepeatingView numberRepeater()]");
		return numberRepeater;
	}
	

	private RepeatingView menu(final String id) 
	{
		_LOG.info("[ENTERING WebMarkupContainers menu()]");

		if (Strings.isNullOrEmpty(id))
			throw new IllegalStateException(ErrorMessages.ILLEGAL_STATE_MESSAGE.toString());

		final List<MenuItem> items = menuItems();
		final RepeatingView menu = new RepeatingView(id);

		for (MenuItem item : items) 
			fullFillMenu(menu, item);
		_LOG.info("[ENDING WebMarkupContainer menu()]");
		return menu;
	}

	private void fullFillMenu(final RepeatingView menu, final MenuItem item)
	{
		_LOG.info("[ENTERING void fullFillMenu(RepeatingView menu, MenuItem item)]");

		final WebMarkupContainer menuItemElementsContainer = new WebMarkupContainer(menu.newChildId());
		final BookmarkablePageLink<MenuItem> destination = new BookmarkablePageLink<>("link", item.getDestination());
		destination.add(new Label("caption", item.getCaption()));
		menuItemElementsContainer.add(destination);
		menu.add(menuItemElementsContainer);
		
		_LOG.info("[ENDING void fullFillMenu(RepeatingView menu, MenuItem item)]");
	}

	private List<MenuItem> menuItems() 
	{
		_LOG.info("[ENTERING List<MenuItem> menuItems()]");

		final MenuItem item = new MenuItem("Info Page", InfoPage.class);
		final MenuItem[] menuItemsArray = { item, item, item };
		final List<MenuItem> items = Arrays.asList(menuItemsArray);

		_LOG.info("[ENDING List<MenuItem> menuItems() -> " + items + "]");
		return Collections.unmodifiableList(items);	
	}

	 

	
}
