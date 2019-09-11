package org.commons.oca;

import java.util.ArrayList;
import java.util.List;

public class App 
{

    public static void main( String[] args )
    {
        final List<Product> products = new ArrayList<>();
        final Product product = new Product("JAMON");
        final Product p2 = new Product("JABON");
        products.add(product);
        products.add(p2);

        
        
    }



}
