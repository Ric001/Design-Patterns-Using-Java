package com.mycompany;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private static final transient Logger LOG = Logger.getLogger(HomePage.class.getName());
	
	public HomePage(final PageParameters parameters) {
		this.add(new Label("customer", getCustomer()))
			.add(new Label("address", getAddress()))
			.add(new Label("product", getProduct()));
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
}
