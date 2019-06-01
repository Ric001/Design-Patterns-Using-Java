import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import static java.lang.System.out;

public class ForeCastDisplay implements Observer, DisplayElement {
    private float currentPressure;
    private float lastPressure;
    private Observable subject;

    public final Logger LOGGER = Logger.getLogger(ForeCastDisplay.class.getName());

    public ForeCastDisplay(Observable subject) {
        LOGGER.info("[CREATING ForeCastDisplay(Observable)]");
        this.subject = subject;
    }

	@Override
	public void display() {
        LOGGER.info("[ENTERING display()]");
        System.out.println("Current pressure: " + currentPressure +"\n"+
        "lastPressure: " + lastPressure);
	}

	@Override
	public void update(Observable o, Object arg) {
        LOGGER.info("[ ENTERING update(Observable, Object) ]");
        if ( o instanceof WeatherData ) {
            LOGGER.info("[ ARG is instance of WeatherData ]");
            WeatherData wd = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = wd.getPressure();
            display();
        }
	} 


    
}