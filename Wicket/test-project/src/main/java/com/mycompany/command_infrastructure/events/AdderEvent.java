package com.mycompany.command_infrastructure.events;

import java.util.Optional;

import com.mycompany.command_infrastructure.ICommand;
import com.mycompany.my.commons.base.ICustomAdder;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

public class AdderEvent implements ICommand {

    private Optional<? extends Component> componentToAdd;
    private Optional<? extends WebPage> container;
    private Optional<? extends ICustomAdder> customAdder;
    private Optional<? extends MarkupContainer> mContainer;
    private Optional<? extends AjaxRequestTarget> target;

    public AdderEvent(Optional<? extends Component> componentToAdd, Optional<? extends WebPage> container,
            Optional<? extends ICustomAdder> customAdder) {
        this.setComponentToAdd(componentToAdd);
        this.setContainer(container);
        this.setCustomAdder(customAdder);
    }

    public AdderEvent(Optional<? extends Component> componentToAdd, MarkupContainer container,
            Optional<? extends ICustomAdder> customAdder) {
            this.setComponentToAdd(componentToAdd);
            this.setmContainer(Optional.of(container));
            this.setCustomAdder(customAdder);
    } 

    public AdderEvent(Optional<? extends Component> componentToAdd, AjaxRequestTarget container,
            Optional<? extends ICustomAdder> customAdder) {
            this.setComponentToAdd(componentToAdd);
            this.setTarget(Optional.of(container));
            this.setCustomAdder(customAdder);
            
    } 
    
    public Optional<? extends MarkupContainer> getmContainer() {
        return mContainer;
    }

    public void setmContainer(Optional<? extends MarkupContainer> mContainer) {
        this.mContainer = mContainer;
    }

    public Optional<? extends WebPage> getContainer() {
        return container;
    }

    public void setContainer(Optional<? extends WebPage> container) {
        this.container = container;
    }

    public Optional<? extends Component> getComponentToAdd() {
        return componentToAdd;
    }

    public void setComponentToAdd(Optional<? extends Component> componentToAdd) {
        this.componentToAdd = componentToAdd;
    }

    public Optional<? extends ICustomAdder> getCustomAdder() {
        return customAdder;
    }

    public void setCustomAdder(Optional<? extends ICustomAdder> customAdder) {
        this.customAdder = customAdder;
    }

    public Optional<? extends AjaxRequestTarget> getTarget() {
        return target;
    }

    public void setTarget(Optional<? extends AjaxRequestTarget> target) {
        this.target = target;
    }

    private boolean validateContainerExistence() 
    {
        return (container.isPresent() && componentToAdd.isPresent() && customAdder.isPresent());
    }
    
    private boolean validateTargetExistence() 
    {
        return (target.isPresent() && componentToAdd.isPresent() && customAdder.isPresent());
    }

    private boolean validateMarkupExistence() 
    {
        return (mContainer.isPresent() && componentToAdd.isPresent() && customAdder.isPresent());
    }

    @Override
    public void execute() {
        if (validateContainerExistence())
        {
            customAdder.get().setFatherContainer(container.get()).add(componentToAdd.get());
        }
        else if (validateTargetExistence())
        {
            customAdder.get().setFatherContainer(target.get()).add(componentToAdd.get());
        } 
        else if (validateMarkupExistence())
        {
            customAdder.get().setFatherContainer((WebMarkupContainer)mContainer.get()).add(componentToAdd.get());
        }
    }    
}