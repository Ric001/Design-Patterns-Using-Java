package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class InfoPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public InfoPage() {
        Label label = new Label("incoming-info", (Person) getSession().getAttribute("person"));
        this.add(label);
    }
}