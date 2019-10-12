package com.mycompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import com.mycompany.models.Cheese;
import com.mycompany.wrappers.LoadableCheeseModel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class CheesePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private final static Logger _LOG = Logger.getLogger(CheesePage.class.getName());

    public CheesePage() {
        IModel<List<Cheese>> model = new LoadableDetachableModel<List<Cheese>>() {
            private static final long serialVersionUID = 1L;

            @Override
            protected List<Cheese> load() {
                _LOG.info("[ENTERING List<Cheese> load()]");
  
                List<Cheese> list = new ArrayList<>();
                list.add(new Cheese(1L, "Roquefourt", 20F));
                list.add(new Cheese(2L, "Cheddar", 20F));
                list.add(new Cheese(3L, "Gouda", 20F));
  
                _LOG.info("[ENDING List<Cheese> load()]");
                return Collections.unmodifiableList(list);
            }
        };

        add(new ListView<Cheese>("cheeses", model) {
            private static final long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Cheese> item) {
                _LOG.info("[ENTERING void populateItem(ListItem<Cheee> item)]");

                Cheese cheese = item.getModelObject();
                item.add(new Label("desc", cheese.getName()));
                item.add(new Label("amount", cheese.getPrice()));
                item.add(new Label("uniqueN", cheese.getId()));

                _LOG.info("[ENDING void populateItem(ListItem<Cheese> item)]");
            }
        });
        final Long USER_ID = 1L;
        add(new Form<>("cheesesForm", new LoadableCheeseModel(USER_ID)));
    }
}