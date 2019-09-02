package com.mycompany;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import java.util.logging.Logger;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

public class PersonalInfo extends Form<Person> {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(PersonalInfo.class.getName());
    
    private Person person;
    private TextField<String> name;
    private TextField<String> lastname;
    private TextField<String> profession;
    private Button submit;
    
    public PersonalInfo(String id) {
        super(id);
        initComponents();
        setModels();
        addInto();
    }

   

    private void initComponents() {
        LOG.info("[ENTERING initComponents(): void]");
        
        name = new TextField<>("name");
        lastname = new TextField<>("lastname");
        profession = new TextField<>("profession");
        submit = new Button("send");

        LOG.info("[ENDING initComponents(): void]");
    }

    private void setModels() {
        LOG.info("[ENTERING setModels(): void]");
        
        this.person = new Person();
        name.setDefaultModel(new PropertyModel<>(person, "name"));
        lastname.setDefaultModel(new PropertyModel<>(person, "lastname"));
        profession.setDefaultModel(new PropertyModel<>(person,"profession"));
        
        LOG.info("[ENDING setModels(): void]");
    }

    private void addInto() {
        LOG.info("[ENTERING addInto(): void]");

        final PersonalInfo ownComponent = this;
        ownComponent.add(name).add(lastname).add(profession).add(submit);
        
        LOG.info("[ENDING addInto(): void]");
    }

    @Override 
    public void onSubmit() {
        getWebSession().setAttribute("person", person);
        setResponsePage(InfoPage.class);
    }

}