package com.mycompany;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

public class Checkout extends CheeserPage {

    private static final long serialVersionUID = 1L;
    private final static Logger LOG = Logger.getLogger(Checkout.class.getName());
    
    public Checkout() {
        Form<Address> form = new Form<>("form");
        Address address = getCart().getBillingAddress();
        
        form.add(new TextField<String>("name", new PropertyModel<>(address, "name")).setRequired(true).add(StringValidator.lengthBetween(5, 32)))
            .add(new TextField<String>("street", new PropertyModel<>(address,"street")).setRequired(true))
            .add(new TextField<>("zipcode", new PropertyModel<>(address, "zipcode")).setRequired(true))
            .add(new TextField<>("city", new PropertyModel<>(address, "city")).setRequired(true))

            .add(new Link<Void>("cancel") {
                private static final long serialVersionUID = 1L;
                @Override
                public void onClick() {
                    LOG.info("[CANCELING Checkout Order]");
                    setResponsePage(Index.class);    
                }
            }).add(new Button("order"){
                private static final long serialVersionUID = 1L;
                @Override
                public void onSubmit() {
                    getCart().getChesses().clear();
                    getCart().clearAmount();
                    LOG.info("[Chesses Cart Cleared -> ] " + getCart().getChesses().size());
                    setResponsePage(Index.class);
                }
            });
        add(form);
        add(new FeedbackPanel("feedback"));
    }
}