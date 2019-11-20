package com.mycompany;

import java.util.logging.Logger;

import com.mycompany.models.Customer;
import com.mycompany.my.commons.base.CustomAdder;
import com.mycompany.my.commons.base.ICustomAdder;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class CustomerInput extends Form<Customer> {

    private static final long serialVersionUID = 1L;

    private TextField<String> documentId;
    private TextField<String> name;
    private TextField<String> lastname;
    private TextField<String> accountNumber;
    private TextField<String> street;
    private TextField<String> city;
    private TextField<String> country;

    private Button send;

    private transient final static Logger _LOG = Logger.getLogger(CustomerInput.class.getName());

    public CustomerInput(String id) {
        super(id);
        initComponents();
        setModels();
        putOnContainer();
    }

    public void initComponents() {
        _LOG.info("[ENTERING void initComponents()]");

        documentId = new TextField<>("documentId");
        name = new TextField<>("name");
        lastname = new TextField<>("lastname");
        accountNumber = new TextField<>("accountNumber");
        street = new TextField<>("street");
        city = new TextField<>("address.city");
        country = new TextField<>("address.country");
        send = new Button("send");

        _LOG.info("[ENDING void initComponents()]");
    }

    public void setModels() {
        _LOG.info("[ENTERING void setModels(): void]");

        final CompoundPropertyModel<Customer> model = new CompoundPropertyModel<>(new Customer());
        street.setModel(model.bind("address.street"));
        this.setModel(model);

        _LOG.info("[ENDING void setModels(): void]");
    }

    public void putOnContainer() {
        _LOG.info("[ENTERING void putOnContainer()]");

        final ICustomAdder customAdder = new CustomAdder();
        customAdder.setFatherContainer(this).add(documentId, name, lastname, accountNumber, street, city, country,
                send);

        _LOG.info("[ENDING void putOnContainer()]");
    }

    @Override
    public void onSubmit() {
        _LOG.info("[ENTERING onSubmit(): void]");

        final Customer customer = getModelObject();
        getSession().setAttribute(customer.getClass().getName(), customer);
        setResponsePage(InfoPage.class);
        System.out.println(customer);

        _LOG.info("[ENTERING onSubmit(): void]");
    }

}