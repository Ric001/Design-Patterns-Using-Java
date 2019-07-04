package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.logging.Logger;

public class Index extends CheeserPage {
    private static final long serialVersionUID = 1L;
    private static final Logger _LOG = Logger.getLogger(Index.class.getName());

    public Index() {
        add(new ListView<Chesse>("cheeses", getCheesses()) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<Chesse> item) {
                _LOG.info("[ENTERING populateItem(ListItem<Chesse> item):void]");
                performItemsPopulation(item);
            }
        });
    }

    private void performItemsPopulation(ListItem<Chesse> item) {
        _LOG.info("[ENTERING performItemsPopulation(ListItem<Chesse> item): void]");
        Chesse cheese = item.getModelObject();
        item.add(new Label("name", cheese.getName()))
            .add(new Label("description", cheese.getDescription()))
            .add(new Label("price", cheese.getPrice()))

            .add(new Link<Chesse>("add", item.getModel()) {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                triggerOnClick(this);
            }
        });
    }

    private void triggerOnClick(Link<Chesse> link) {
        _LOG.info("[Adding selected Chesse to the cart]");
        Chesse selected = link.getModelObject();
        getCart().getChesses().add(selected);
    }

}