package com.mycompany.wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mycompany.models.Cheese;

import org.apache.wicket.model.LoadableDetachableModel;

public class LoadableModel extends LoadableDetachableModel<Cheese> {

    private Long id;
    
    private final static Logger _LOG = Logger.getLogger(LoadableModel.class.getName());
    private final static long serialVersionUID = 1L;

    public LoadableModel(Long id) {
        this.id = id;
    }

    public LoadableModel(Cheese cheese) {
        super(cheese);
        this.id = cheese.getId();
    }

    @Override 
    public Cheese load() {
        _LOG.info("[ENTERING Cheese load()]");
        
        Cheese cheese = new Cheese(1L, "Cheddar", 20.9f);
        
        _LOG.info("[RETURNING Cheese load()]");
        return cheese;
    }

}