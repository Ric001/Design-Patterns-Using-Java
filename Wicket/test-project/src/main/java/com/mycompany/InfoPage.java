package com.mycompany;

import com.mycompany.models.Customer;
import com.mycompany.models.Person;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

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
        addingManager.add(this, label, labelII);
    
    }

    private Label mealName(PageParameters parameters) {
        _LOG.info("[ENTERING Label mealName()]");

        final Label label = new Label("meal-name", "NOT MEAL NAME FOUND AT THIS POINT");
        if (parameters.getNamedKeys().contains(HomePage.MEAL_NAME))
            label.setDefaultModelObject(parameters.get(HomePage.MEAL_NAME));
        
        _LOG.info("[RETURNING Label mealName() ] -> " + label + " key: " + HomePage.MEAL_NAME);
        return label;
    }
}