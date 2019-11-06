package org.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Optional;

public class EnumerationAdapter<T> implements Iterator<T> 
{

    private Optional<Enumeration<T>> enumeration;
    
    public EnumerationAdapter(Optional<Enumeration<T>> enumeration)
    {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        if (enumeration.isPresent())
            return enumeration.get().hasMoreElements();
        return false;
    }

    @Override
    public T next() {
        if (enumeration.isPresent())   
            return enumeration.get().nextElement();
        return null;
    }
    
    public void remove() 
    {
        throw new UnsupportedOperationException();
    }
}