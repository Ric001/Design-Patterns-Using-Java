package com.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(HomePage.class.getName());

	public HomePage(final PageParameters parameters) {
		super(parameters);
		Form<Void> form = multipleChoices(form("form"));
		form = checkBoxMultipleChoices(form);
		add(form);
		// final Form<Details> detailsForm = compoundPropertyForm("cpmForm");
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
		radioChoices.setSuffix("<br>");		
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

	private Form<Void> multipleChoices(Form<Void> form) {
		LOG.info("[ENTERING Form<Vodid> multipleChoices(Form<Void> form)]");

		if (Objects.isNull(form))
			return form;
		
		final List<String> choices = Arrays.asList("Camel", "Cow", "Goat", "Something");
		final Cheese cheese = new Cheese();
		
		final ListMultipleChoice<String> multipleChoice = new ListMultipleChoice<>("multiple",new PropertyModel<>(cheese, "milkTypes"), choices);
		final Link<Void> submit = new Link<Void>("send") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				System.out.println(String.format("[ <==== CHEESE ====> %s]", multipleChoice.getDefaultModel().toString()));
			}
		};
		form.add(multipleChoice);
		form.add(submit);
		LOG.info("[RETURNING FROM Form<Void> multipleChoices(Form<Void> form)]");
		return form;
	}

	private Form<Void> checkBoxMultipleChoices(Form<Void> form) {
		LOG.info("[ENTERING Form<Void> checkBoxMultipleChoices(Form<Void> form)]");
		if (Objects.isNull(form))
			return form;
		
		final List<String> choices = Arrays.asList("Camel", "Cow", "Kangaroo");
		final Cheese cheese = new Cheese();
		final CheckBoxMultipleChoice<String> checkBoxes = new CheckBoxMultipleChoice<>("checkboxes", new PropertyModel<>(cheese, "milkTypes"), choices);
		form.add(checkBoxes);

		LOG.info("[RETURNING FROM Form<Void> checkBoxMultipleChoices(Form<Void> form)]");
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


class Cheese implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> milkTypes = new ArrayList<>();

	public List<String> getMilkTypes() {
		return milkTypes;
	}

	public void setMilkTypes(List<String> milkTypes) {
		this.milkTypes = milkTypes;
	}

	@Override
	public String toString() {
		return "Cheese [milkTypes=" + milkTypes + "]";
	}

	
	
}
