package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Another extends WebPage {
    private static final long serialVersionUID = 1L;
    private Label label;
    private TextField<String> field;

    public Another(final PageParameters parameters) {
        Form<String> form = new Form<>("form");
        
        form.add(field = new TextField<>("field", new Model<>("")))
            .add(new Button("button") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onSubmit() {
                performOnSubmit();
            }
        });
        
        label = new Label("message");
        label.setDefaultModel(new Model<>(""));
        add(label)
        .add(form);
    }

    public void performOnSubmit() {
        String value = field.getInput();
        label.setDefaultModelObject(value);
        field.setDefaultModelObject("");
    }

    public TextField<String> getTextField() {
        return field;
    }

    public void setTextField(TextField<String> field) {
        this.field = field;
    }
}