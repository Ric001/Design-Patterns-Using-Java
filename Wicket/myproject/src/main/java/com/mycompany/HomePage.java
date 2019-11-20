package com.mycompany;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

import com.ricks.utils.string.Strings;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private static final transient Logger LOG = Logger.getLogger(HomePage.class.getName());
	
	public HomePage(final PageParameters parameters) {
		LOG.info("[ENTERING HomePage(final PageParameters parameters)]");

		final Component[] fieldsComponent = fieldsArray("nameSender", "name","password");
		System.out.println(String.format("======> Fields Component [%s]<====", Arrays.toString(fieldsComponent)));
		final Form<Void> form = getForm("formName", fieldsComponent);
		
		this.add(new Label("customer", getCustomer()))
			.add(new Label("address", getAddress()))
			.add(new Label("product", getProduct()))
			.add(new PersonalInfo("personal-info"))
			.add(form);
			
		LOG.info("[ENDING HomePage(final PageParameter parameters)]");	
	}

	public Model<Address> getAddress() {
		return new Model<>(new Address("San Martin", "12", "RD", "SD"));
	}

	public Model<Product> getProduct() {
		return new Model<>(new Product("MacBook Pro", 100.8f));
	}

	public Model<Customer> getCustomer() {
		return new Model<>(new Customer("Jose Ricardo", "Osorio Soto", "22"));
	}

	private Form<Void> getForm(final String id, final Component... fields) {
		LOG.info("[ENTERING Form<Void> getForm(final String id, final Component... field)]");

		assertIsValid(id);
		assertIsValid(fields);

		final Form<Void> form = new Form<Void>(id) {
			public final static long serialVersionUID = 1L;
			@Override
			protected void onSubmit() {
				final TextField<String> textField = (TextField<String>) get("name");
				final PasswordTextField passwordTextField = (PasswordTextField) get("password");
				if (Objects.nonNull(textField) && Objects.nonNull(passwordTextField))
					System.out.println(String.format("\n====> User Name [%s] Password ----> [%s] <====\n", textField.getInput(), passwordTextField.getConvertedInput()));
			}
		};
		
		for (Component component : fields)
			if (Objects.nonNull(component))
				form.add(component);
		LOG.info("[ENDING Form<Void> getForm(final String id, final Component... fields)]");
		return form;
	}

	private Component[] fieldsArray(final String sumbitId, final String... ids) {
		LOG.info("[ENTERING Component[] fieldsArray(final String submitId, final String... ids)]");

		assertIsValid(sumbitId);
		assertIsValid(ids);
		final Button submitButton = new Button(sumbitId);
		final Component[] fields = new Component[ids.length + 1];
		final TextField<String> textField = field("", ids[0]);
		final PasswordTextField passwordTextField = new PasswordTextField(ids[1]);
		passwordTextField.setDefaultModel(new Model<>(""));
		fields[0] = textField;
		fields[1] = passwordTextField;
		fields[fields.length - 1] = submitButton;
		LOG.info(String.format("[ENDING Component[] fieldsArray(final String submitId, final String... ids)] [%s]", Arrays.toString(fields)));
		return fields;
	}

	private <T extends Serializable> TextField<T> field(T type, final String id) {
		final TextField<T> field = new TextField<>(id);
		field.setDefaultModel(new Model<>(type));
		return field;
	} 
	
	private boolean assertIsValid(final Object o) {
		LOG.info("[ENTERING boolean assertIsValid(final Object o)]");
		if (Objects.isNull(o))
			return false;
		if (o instanceof String) 
			return Strings.isNullOrEmpty((String) o);
		return true;
	}

	
}
