package com.mycompany.wrappers;


import java.util.Objects;

import com.mycompany.models.Cheese;

import org.apache.wicket.model.Model;

public class CheeseModel extends Model {

    private static final long serialVersionUID = 1L;
    
    private transient Cheese chesse;
    
    private Long id;

    public CheeseModel() {
    }

    public Cheese getObjectModel() {
        if (Objects.nonNull(chesse))
            return chesse;
        if (Objects.isNull(chesse))
            return new Cheese();
        return dao(id);
    }

    public Cheese dao(final Long id) {
        Cheese cheese = new Cheese();
        cheese.setId(id);  
        return new Cheese();
    }
    public void setObject(Object object) {
        this.chesse = (Cheese) object;
        this.id = (Objects.isNull(chesse)) ? null : this.chesse.getId();
    }

   @Override
   public void detach() {
       this.chesse = null;
   }

}