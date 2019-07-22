package com.mycompany;

import java.util.Objects;
import java.util.logging.Logger;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;


public class ShoppingCartPanel extends Panel {
    private Cart cart;

    private static final Logger LOG = Logger.getLogger(ShoppingCartPanel.class.getName());

    public ShoppingCartPanel(String id, Cart cart) {
        super(id);
        this.cart = cart;
        add(new ListView<Chesse>("cart", new PropertyModel<>(this, "cart.chesses")) {
            private static final long serialVersionUID = 1L;
            @Override
            protected void populateItem(ListItem<Chesse> item) {
                Chesse chesse = item.getModelObject();
                if (Objects.nonNull(chesse)) {
                    item.add(new Label("name", chesse.getName()));
                    item.add(new Label("price", chesse.getPrice()));
                    item.add(new Link<Chesse>("remove") {
                        private static final long serialVersionUID = 1L;

                        @Override
                        public void onClick() {
                            LOG.info("Recalculating cart amount");
                            double priceToSustract = chesse.getPrice();
                            //getCart().getChesses().remove(ndex);
                            getCart().recalculateTotal(priceToSustract);
                        }
                    });
                }
            }
        });

        add(new Label("total", new PropertyModel<String>(getCart(), "total") {
            private static final long serialVersionUID = 1L;
            @Override
            public String getObject() {
                return "$" + (float) getCart().getTotal();
            }
        }));
    }

    private Cart getCart() {
        return cart;
    }
}