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
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private int counter = 0;
	private Label label;
	private Label toTheOtherPage;

	private static final transient Logger LOG = Logger.getLogger(HomePage.class.getName());
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		label = new Label("label", new PropertyModel<Void>(this, "counter"));
		addAjaxCounter();
		addAnotherPageLink();
		setClock();
	}

	private void setClock() {
		LOG.info("[ENTERINGI setClock(): void]");

		final Model<Serializable> clock = getTimeModel();
		 add(new Label("clock", clock))
		.add(getClockUpdater());
		
		LOG.info("[RETURNING setClock(): void] " + get("clock"));
	}

	private Component getClockUpdater() {
		LOG.info("[ENTERING getClockUpdater(): Component ]");

		Link<Void> clockUpdater = new Link<Void>("clockUpdater") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				get("clock").getDefaultModel().getObject();
			}
		};

		LOG.info("[RETURNING getClockUpdater(): Component ] " + clockUpdater);
		return clockUpdater;
	}

	private Model getTimeModel() {
		LOG.info("[ENTERING getTimeModel(): Model]");

		Model model =  new Model() {
			private static final long serialVersionUID = 1L;
			@Override
			public Serializable getObject() {
				DateFormat format = new SimpleDateFormat("hh:mm:ss");
				return format.format(new Date());
			}
		};

		LOG.info("[RETURNING getTimeModel(): Model] " + model);
		return model;
	}

	public void addAjaxCounter() {
		add(new AjaxFallbackLink<Void>("Link") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick(Optional<AjaxRequestTarget> optional) {
				counter++;
				if (Objects.nonNull(optional.get()))
					optional.get().add(label);
			}
		});
	}

	private void addAnotherPageLink() {
		add(label.setOutputMarkupId(true)).add(new AjaxFallbackLink<Void>("toTheOther") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick(Optional<AjaxRequestTarget> optionalTarget) {
				if (Objects.nonNull(optionalTarget))
					setResponsePage(Another.class);
			}
		});
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Label getToTheOtherPage() {
		return toTheOtherPage;
	}

	public void setToTheOtherPage(Label toTheOtherPage) {
		this.toTheOtherPage = toTheOtherPage;
	}

}
