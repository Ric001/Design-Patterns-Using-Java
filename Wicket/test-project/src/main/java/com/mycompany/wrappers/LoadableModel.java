package com.mycompany.wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mycompany.models.Cheese;

import org.apache.wicket.model.LoadableDetachableModel;

public class LoadableModel extends LoadableDetachableModel<List<Cheese>> {

    private static final long serialVersionUID = 1L;
    private final static Logger _LOG = Logger.getLogger(LoadableModel.class.getName());
    
    @Override
	public List<Cheese> load() {
        _LOG.info("[ENTERING T load()]");
        
        final List<Cheese> cheeses = new ArrayList<>();
        cheeses.add(new Cheese(1L, "Roquefourt", 20F));
        
        _LOG.info("[RETURNING T load() " + cheeses + "]");
        return cheeses;
	}
    
}