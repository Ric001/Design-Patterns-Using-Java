package com.mycompany.wrappers;

import java.util.logging.Logger;

import com.mycompany.models.Cheese;

import org.apache.wicket.model.LoadableDetachableModel;
import java.util.Objects;

public class LoadableCheeseModel extends LoadableDetachableModel<Cheese>{
    
    private static final long serialVersionUID = 1L;
    private final static Logger _LOG = Logger.getLogger(LoadableCheeseModel.class.getName());

    private Long id;

    @Override
    protected Cheese load() {
        _LOG.info("[Loading Domain Object]");
        
        if (Objects.isNull(id))
            return new Cheese();

        _LOG.info("[ENDING DOMAIN OBJECT LOADING]");
        return new Cheese();
    }


    public LoadableCheeseModel(Long id) {
        this.id = id;
    }   

    public LoadableCheeseModel(Cheese cheese) {
        super(cheese);
        this.id = cheese.getId();
    }
}