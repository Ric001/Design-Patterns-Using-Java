package com.mycompany;

import java.util.Objects;
import java.util.Optional;

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
