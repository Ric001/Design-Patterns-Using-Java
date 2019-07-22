package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Index extends CheeserPage {
    private static final long serialVersionUID = 1L;
    private static final Logger _LOG = Logger.getLogger(Index.class.getName());

    public Index() {
        add(new PageableListView<Chesse>("cheeses", getCheesses(), 2) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<Chesse> item) {
                _LOG.info("[ENTERING populateItem(ListItem<Chesse> item):void]");
                performItemsPopulation(item);
            }
        }).add(new ShoppingCartPanel("shopping-cart-panel", getCart()))

                .add(new Link<Void>("checkout") {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void onClick() {
                        setResponsePage(Checkout.class);
                    }

                    @Override
                    public boolean isVisible() {
                        return !getCart().getChesses().isEmpty();
                    }
                }).add(new PagingNavigator("navigator", (PageableListView<Chesse>) get("cheeses")));
    }

    private void performItemsPopulation(ListItem<Chesse> item) {
        _LOG.info("[ENTERING performItemsPopulation(ListItem<Chesse> item): void]");
        Chesse cheese = item.getModelObject();
        item.add(new Label("name", cheese.getName())).add(new Label("description", cheese.getDescription()))
                .add(new Label("price", cheese.getPrice())).add(new Link<Chesse>("add", item.getModel()) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void onClick() {
                        triggerOnClickEvent(this);
                    }
                });
    }

    private void triggerOnClickEvent(Link<Chesse> link) {
        _LOG.info("[Adding selected Chesse to the cart]");
        Chesse selectedToAdd = link.getModelObject();
        getCart().getChesses().add(selectedToAdd);
    }

}
