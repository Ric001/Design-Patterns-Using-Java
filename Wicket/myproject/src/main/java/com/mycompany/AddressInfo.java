package com.mycompany;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class AddressInfo extends Form<Address> {

    private TextField<String> street;
    private TextField<String> city;
    private TextField<String> country;
    
    private static final long serialVersionUID = 1L;

    private final static Logger LOG = Logger.getLogger(AddressInfo.class.getName());
    
    public AddressInfo(String id) {
        super(id);
        LOG.info("[CREATING AddressInfo Form]");
        initComponents();
        setModels();
        addInto();
    }

    private void initComponents() {
        LOG.info("[ENTERING initComponents(): void]");

        street = new TextField<>("street");
        city = new TextField<>("city");
        country = new TextField<>("country");
        
        LOG.info("[ENDING initComponents(): void]");
    }   

    private void setModels() {
        LOG.info("[ENTRING setModels(): void]");

        street.setModel(new Model<>(""));
        city.setModel(new Model<>(""));
        country.setModel(new Model<>(""));

        LOG.info("[ENDING setModels(): void]");
    }

    private void addInto() {
        LOG.info("[ENTERING addInto(): void]");
        
        add(street).add(city).add(country);

        LOG.info("[ENDING addInto(): void]");
    }

    public void compound(WebMarkupContainer container) {
        LOG.info("[ENTERING compound(WebMarkupContainer container)]");

        container.add(street).add(city).add(country);
        
        LOG.info("[RETURNING compound(WebMarkupContainer container)]");
    }

    public IModel<Address> address() {
        final String street = this.street.getValue();
        final String city = this.city.getValue();
        final String country = this.country.getValue();
        
        Address address = new Address(street, city, country);
        setDefaultModel(new Model<>(address));
        return (IModel<Address>) getDefaultModel();
    }

	

}