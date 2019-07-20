package com.mycompany;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class Checkout extends CheeserPage {

    private static final long serialVersionUID = 1L;
    private final static Logger LOG = Logger.getLogger(Checkout.class.getName());
    
    public Checkout() {
        Form<Address> form = new Form<>("form");
        Address address = getCart().getBillingAddress();
        
        form.add(new TextField<>("name", new PropertyModel<>(address, "name")))
            .add(new TextField<>("street", new PropertyModel<>(address,"street")))
            .add(new TextField<>("zipcode", new PropertyModel<>(address, "zipcode")))
            .add(new TextField<>("city", new PropertyModel<>(address, "city")))

            .add(new Link<Void>("cancel") {
                private static final long serialVersionUID = 1L;
                @Override
                public void onClick() {
                    LOG.info("[CANCELING Checkout Order]");
                    setResponsePage(Index.class);    
                }
            });
            add(new Button("order"){
                private static final long serialVersionUID = 1L;
                @Override
                public void onSubmit() {
                    getCart().getChesses().clear();
                    LOG.info("[Chesses Cart Cleared -> ] " + getCart().getChesses().size());
                    setResponsePage(Index.class);
                }
            });
        add(form);
    }
}