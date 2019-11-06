package org.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class App 
{
    final static Logger _LOG = Logger.getLogger(App.class);
    public static void main( String[] args )
    {

        PropertyConfigurator.configure("log4j.properties");
        _LOG.debug("Log4j appender configuration succesful !!");
        _LOG.info("Tell me why are we so blind to see");

    }
}
