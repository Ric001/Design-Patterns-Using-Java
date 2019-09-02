package com.mycompany;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class PersonalInfo extends Form<Person> {

    private TextField<String> name;
    private TextField<String> lastname;
    private TextField<String> profession;
    private Button submit;
    private AddressInfo addressInfo;
    
    private static final long serialVersionUID = 1L;

    private final static Logger LOG = Logger.getLogger(PersonalInfo.class.getName());
    
    public PersonalInfo(String id) {
        super(id);
        LOG.info("[ CREATING PersonalInfo ]");   
        initComponents(); 
        setModels();
        addInto();
    }

    private void initComponents() {
        LOG.info("[ ENTERING void initComponents() ]");

        name = new TextField<>("name");
        lastname = new TextField<>("lastname");
        profession = new TextField<>("profession");
        submit = new Button("send");
        addressInfo = new AddressInfo("address-info");
        
        LOG.info("[ ENDING void initComponents() ]");
    }

    private void setModels() {
        LOG.info("[ ENTERING void setModels() ]");
        
        name.setDefaultModel(new Model<>(""));
        lastname.setDefaultModel(new Model<>(""));
        profession.setModel(new Model<>(""));
        
        LOG.info("[ ENDING void setModels() ]");
    }

    private void addInto() {
        LOG.info("[ ENTERING addInto(): void ]");

        add(name).add(lastname).add(profession).add(submit);
        addressInfo.compound(this);
        
        LOG.info("[ ENDING addInto(): void ]");
    }

    @Override
    public void onSubmit() {
        LOG.info("[ Submiting Personal Content ]");
        
        final String name = this.name.getValue();
        final String lastname = this.lastname.getValue();
        final String profession = this.profession.getValue();
        final IModel<Address> address = addressInfo.address();  
        
        Person person = new Person(name, lastname, profession, address.getObject());
        print(person);
    }

    public void print(Person person) {
        System.out.println(person);
    }

}