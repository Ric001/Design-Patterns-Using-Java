package com.mycompany;

import com.mycompany.models.Customer;
import com.mycompany.models.Person;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;


public class InfoPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public InfoPage() {

        final Label label = new Label("incoming-info", (Person) getSession().getAttribute("person"));
        final Label labelII = new Label("customer-info", (Customer) getSession().getAttribute(Customer.class.getName()));
        final ICustomAdder addingManager = new CustomAdder();
        
        addingManager.add(this, label, labelII);
    
    }
}