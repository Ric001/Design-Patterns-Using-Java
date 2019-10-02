package com.mycompany;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import com.mycompany.command_infrastructure.creators.RedirectEventCreator;
import com.mycompany.models.Customer;
import com.mycompany.models.Person;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class InfoPage extends WebPage {

    private static final long serialVersionUID = 1L;

    private final static Logger _LOG = LoggerFactory.getLogger(InfoPage.class);
    public InfoPage(final PageParameters parameters) {

        final Label label = new Label("incoming-info", (Person) getSession().getAttribute("person"));
        final Label labelII = new Label("customer-info", (Customer) getSession().getAttribute(Customer.class.getName()));
        final ICustomAdder addingManager = new CustomAdder();
        
        addingManager.add(this, mealName(parameters));
        addingManager.add(this, label, labelII, backButton());
    }

    private Label mealName(PageParameters parameters) {
        _LOG.info("[ENTERING Label mealName()]");

        final Label label = new Label("meal-name", "NOT MEAL NAME FOUND AT THIS POINT");
        if (parameters.getNamedKeys().contains(HomePage.MEAL_NAME))
            label.setDefaultModelObject(parameters.get(HomePage.MEAL_NAME));
        
        _LOG.info("[RETURNING Label mealName() ] -> " + label + " key: " + HomePage.MEAL_NAME);
        return label;
    }

    private Component backButton() {
        _LOG.info("[ENTERING void backButton()]");

        final Optional<? extends WebPage> pageRef = Optional.of(this);
        final Optional<Class<? extends Page>> pageToRender = Optional.of(loadLastVisitedPageFromSession());

        _LOG.info("[ENTERING Component backButton()]");
        return new RedirectEventCreator(pageRef, pageToRender).event("back");
    }

    private Class<? extends WebPage> loadLastVisitedPageFromSession() {
       _LOG.info("[ENTERING Class<? extends WebPage> loadLastVisitedPageFromSession()]");

       final Serializable possibleWebPage = getSession().getAttribute(RedirectEventCreator.LAST_VISITED_PAGE);

       if (possibleWebPage instanceof Class && Objects.nonNull(possibleWebPage))
            return (Class<? extends WebPage>) possibleWebPage;

        _LOG.info("[ENDING Class<? extends WebPage> loadLastVisitedPageFromSession()]");
        return null;
    }
}