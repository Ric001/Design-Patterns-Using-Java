package org.log;

import java.util.logging.Logger;

import com.ricks.utils.ricksio.reader.ReadUtils;

public class Test {
    
    private final static Logger LOG = Logger.getLogger(Test.class.getName());

    public void log(final String message) {
        LOG.info(message);
    }
}