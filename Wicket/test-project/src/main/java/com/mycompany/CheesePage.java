package com.mycompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.mycompany.command_infrastructure.creators.AjaxFallbackEventCreator;
import com.mycompany.models.Cheese;
import com.mycompany.wrappers.LoadableModel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

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
                item.add(new Label("price", cheese.getPrice()));
                
                _LOG.info("[ENDING void populateItem(ListItem<Cheese> item) " + item + "]");
            }
        });

        final LoadableModel cheeseModel = new LoadableModel(new Cheese(2L, "Danish", 20F));
        final PropertyModel<LoadableModel> nameModel = new PropertyModel<>(cheeseModel, "name");
        final String name = nameModel.getObject().getObject().getName();
        nameModel.detach(); 
        ajaxLink("Event");
        System.out.println("Cheese Name: " + name);       
    }

    private void ajaxLink(final String id) {
        final Optional<Component> label = Optional.of(new Label("Sing", "Terminator"));
        final Optional<WebPage> thisPage = Optional.of(this);
        add(label.get().setVisible(false));
        add(new AjaxFallbackEventCreator(thisPage, label).event(id));
    }
}