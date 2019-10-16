package com.mycompany.command_infrastructure.events.exceptions;

public enum ErrorMessages {
    
    ILLEGAL_STATE_MESSAGE, MISSING_FATHER_CONTAINER;
    @Override
    public String toString() 
    {
        switch(this) 
        {
            case ILLEGAL_STATE_MESSAGE: return "Component Id Needs To Be Fully Provided";
            case MISSING_FATHER_CONTAINER: return "Father Container was not configured";
            default: return "NOT ALLOWED ENUM PROVIDED";
        }
    }
}