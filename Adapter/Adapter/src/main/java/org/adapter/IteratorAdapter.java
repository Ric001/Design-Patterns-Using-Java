package org.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Optional;

public class IteratorAdapter<T> implements Enumeration<T> {

    private Optional<Iterator<T>> iterator;

    public IteratorAdapter(Optional<Iterator<T>> iterator) 
    {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        if (iterator.isPresent())
            return iterator.get().hasNext();
        return false;
    }

    @Override
    public T nextElement() {
        if (iterator.isPresent())
            return iterator.get().next();
        return null;
    }

}