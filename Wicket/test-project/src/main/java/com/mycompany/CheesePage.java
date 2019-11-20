package com.mycompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.mycompany.command_infrastructure.creators.AjaxFallbackEventCreator;
import com.mycompany.command_infrastructure.events.exceptions.ErrorMessages;
import com.mycompany.models.Cheese;
import com.mycompany.my.commons.base.CustomAdder;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
/**
 * 
 * @author Jose Ricardo Osorio Soto
 * 
 */
public class CheesePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private final static Logger _LOG = Logger.getLogger(CheesePage.class.getName());

    public CheesePage() 
    {
        final ListView<Cheese> cheesesListView = buildListView(loadableModel());
        final AjaxFallbackLink<Void> messageAdderEvent = ajaxLink("event"); 
        final RepeatingView numberRepeater = numberRepater();
        new CustomAdder().setFatherContainer(this)
            .add(cheesesListView, messageAdderEvent, numberRepeater);

    }
    
    public CheesePage(final PageParameters params) 
    {
        this();
        System.out.println("=================");
        System.out.println(" " + params + " ");
        System.out.println("=================");
    }

    private AjaxFallbackLink<Void> ajaxLink(final String id) {
        _LOG.info("[ENTERING AjaxFallbackLink<Void> ajaxLink(final String id)]");
        System.out.println(String.format("\n=====> Ajax FallBack Link ID -> [%s] <====\n", id));

        if (Strings.isNullOrEmpty(id))
        {
            throw new IllegalStateException(ErrorMessages.ILLEGAL_STATE_MESSAGE.toString());
        }
        
        final Optional<Component> label = Optional.of(new Label("sing", "Terminator"));
        final AjaxFallbackLink<Void> link = new AjaxFallbackEventCreator().addingEvent(id, label);

        _LOG.info("[RETURNING FROM AjaxFallbackLink<Void> ajaxLink(final String id) " + link + "]");

        return link;
    }

    public void assertIsNotNull(final Optional<? extends Object> obj) 
    {   
        if (!obj.isPresent())
        {
            throw new IllegalStateException(ErrorMessages.ILLEGAL_STATE_MESSAGE.toString());
        }
    }

    private ListView<Cheese> buildListView(final IModel<List<Cheese>> model) 
    {
        assertIsNotNull(Optional.of(model));
        final ListView<Cheese> listView = new ListView<Cheese>("products", model) 
        {
            private final static long serialVersionUID = 1L;

            @Override
            public void populateItem(ListItem<Cheese> item) 
            {
                _LOG.info("[ENTERING void populateItem(ListItem<Cheese> item)]");
                
                final Cheese cheese = item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("price", cheese.getPrice()));
                
                _LOG.info("[ENDING void populateItem(ListItem<Cheese> item) " + item + "]");
            }
        };

        return listView;
    }

    private IModel<List<Cheese>> loadableModel() {
        _LOG.info("[ENTERING List<Cheese> loadableModel()]");

        IModel<List<Cheese>> model = new LoadableDetachableModel<List<Cheese>>()
        {
            private static final long serialVersionUID = 1L;
            
            @Override
            public List<Cheese> load() 
            {
                _LOG.info("[ENTERING List<Cheese> load()]");

                final List<Cheese> cheeses = new ArrayList<>();
                cheeses.add(new Cheese(1L, "Roquefourt", 20F));
    
                _LOG.info("[RETURNING List<Cheese> load() " + cheeses + "]");
                return Collections.unmodifiableList(cheeses);
            }
        };

        _LOG.info("[RETURNING FROM loadableModel() " + model + "]");
        return model;
    }

    private RepeatingView numberRepater()
    {
        _LOG.info("[ENTERING RepeatingView repeatingView()]");
        final RepeatingView numberRepeater = new RepeatingView("rv");
        for (int i = 0; i < 2; i++)  
        {
            numberRepeater.add(new Label(Integer.toString(i), i));
        }
        _LOG.info("[ENDING RepeatingView repeatingView() " + numberRepeater + "]");
        return numberRepeater;
    }
} 