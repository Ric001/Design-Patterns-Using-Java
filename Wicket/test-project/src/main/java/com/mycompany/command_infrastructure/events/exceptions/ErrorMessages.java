package com.mycompany.command_infrastructure.events.exceptions;

public enum ErrorMessages {
    
    ILLEGAL_STATE_MESSAGE;

    @Override
    public String toString() 
    {
        switch(this) 
        {
            case ILLEGAL_STATE_MESSAGE: return "Component Id Needs To Be Fully Provided";
            default: return "NOT ALLOWED ENUM PROVIDED";
        }
    }
}