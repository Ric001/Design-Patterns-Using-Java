package com.mycompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.mycompany.models.Cheese;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
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
            public List<Cheese> load() {
                _LOG.info("[ENTERING List<Cheese> load()]");

                final List<Cheese> cheeses = new ArrayList<>();
                cheeses.add(new Cheese(1L, "Roquefourt", 20F));

                _LOG.info("[RETURNING List<Cheese> load() " + cheeses + "]");
                return Collections.unmodifiableList(cheeses);
            }
        };

        add(new ListView<Cheese>("products", model) {
            private final static long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Cheese> item) {
                _LOG.info("[ENTERING void populateItem(ListItem<Cheese> item)]");
            
                final Cheese cheese = item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("id", cheese.getId()));
                
                _LOG.info("[ENDING void populateItem(ListItem<Cheese> item) " + item + "]");
            }
        });
        
    }
}