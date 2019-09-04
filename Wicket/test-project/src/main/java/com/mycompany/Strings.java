package com.mycompany;

import java.util.Objects;
import java.util.logging.Logger;

public final class Strings { 
    
    private Strings() {}

    private final static Logger _LOG = Logger.getLogger(Strings.class.getName());
    
    public static boolean isNullOrEmpty(String value) {
        _LOG.info("[ENTERING static boolean isNullOrEmpty(String value)]");

        if (Objects.isNull(value) || value.isEmpty())
            return true;

        _LOG.info("[ENDING static boolean isNullOrEmpty(String value)]");
        return false;
    }

    public static boolean isNotNullOrEmpty(String value) {
        _LOG.info("[ENTERING static boolean isNotNullOrEmpty(String value)]");
        
        if (Objects.nonNull(value) || !value.isEmpty())
            return true;

        _LOG.info("[ENDING static boolean isNotNullOrEmpty(String value)]");
        return false;
    }
}