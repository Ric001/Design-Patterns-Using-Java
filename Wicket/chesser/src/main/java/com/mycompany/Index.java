package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
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
        }).add(new ListView<Chesse>("cart", new PropertyModel<>(this, "cart.chesses")) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<Chesse> item) {
                _LOG.info("[ENTERING populateItem(ListItem<Cheese> item): void]");
                populatingCartItems(item);
            }
        }).add(new Link<Void>("checkout") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Checkout.class);
            }
            @Override
            public boolean isVisible() {
                return !getCart().getChesses().isEmpty();
            }

        }).add(new Label("total", new Model<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getObject() {
                return "$" + (float) getCart().getTotal();
            }
        })).add(new PagingNavigator("navigator", (PageableListView<Chesse>) get("cheeses")));
    }

    private void populatingCartItems(ListItem<Chesse> item) {
        _LOG.info("[ENTERING populateItem(List<Cheese> item): void]");
        Chesse cheese = item.getModelObject();
        item.add(new Label("name", cheese.getName())).add(new Label("price", cheese.getPrice()))
                .add(new Link<Chesse>("remove", item.getModel()) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void onClick() {
                        removeProduct(this);
                    }
                });

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

    private void removeProduct(Link<Chesse> link) {
        _LOG.info("[ENTERING removeProduct(Link<Chesse> link): void]");
        Chesse selectedToRemove = link.getModelObject();
        getCart().getChesses().remove(selectedToRemove);
    }

}
