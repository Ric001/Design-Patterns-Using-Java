package com.components;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(HomePage.class.getName());

	public HomePage(final PageParameters parameters) {
		super(parameters);
		final Form<Void> form = form("form");
		// final Form<Details> detailsForm = compoundPropertyForm("cpmForm");
		add(form);

	}

	private Form<Void> form(final String id) {
		LOG.info("[ENTERING Form<Void> form()]");
		if (Objects.isNull(id) || id.isEmpty())
			return null;

		final Form<Void> form = new Form<>(id);
		final TextArea<String> commentBox = new TextArea<>("txtArea");
		final Details details = new Details();
		final List<String> categories = Arrays.asList("Fresh", "Whey", "Goat or sheep", "Hard", "Blue Vein");
		final ListChoice<String> listChoice = new ListChoice<>("category", new PropertyModel<>(details, "category"),
				categories);
		final DropDownChoice<String> dropDownChoice = new DropDownChoice<>("dropdown",
				new PropertyModel<>(details, "dropChoice"), categories);
		final RadioChoice<String> radioChoices = new RadioChoice<>("radioChoices", new PropertyModel<>(details, "radioChoice"), categories);
		
		details.setCategory("Blue Vein");
		details.setDropChoice("VENUS");
		listChoice.add(new AttributeModifier("size", categories.size()));
		form.add(commentBox);
		form.add(listChoice);
		form.add(dropDownChoice);
		form.add(radioChoices);
		LOG.info("[RETURNING FROM Form<Void> form()]");
		return form;
	}

	/*
	 * private Form<Details> compoundPropertyForm(String id) {
	 * LOG.info("[ENTERING Form<Void> compoundPropertyForm(String id)]");
	 * 
	 * if (Objects.isNull(id) || id.isEmpty()) return null;
	 * 
	 * final Details details = new Details(); final Form<Details> form = new
	 * Form<>(id, new CompoundPropertyModel<Details>(details)); final
	 * ListChoice<Details> choicesToMake = new ListChoice<Details>("choices", new
	 * Model<>()); form.add(choicesToMake);
	 * LOG.info("[RETURNING Form<Void> compoundPropertyForm(String id) ]---> " +
	 * form); return form; }
	 */
}

class Details implements Serializable {

	private static final long serialVersionUID = 1L;
	private String category;
	private String dropChoice;
	private String radioChoice;

	public String getCategory() {
		return category;
	}

	public String getRadioChoice() {
		return radioChoice;
	}

	public void setRadioChoice(String radioChoice) {
		this.radioChoice = radioChoice;
	}

	public String getDropChoice() {
		return dropChoice;
	}

	public void setDropChoice(String dropChoice) {
		this.dropChoice = dropChoice;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}