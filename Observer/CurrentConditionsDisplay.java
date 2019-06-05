import java.util.logging.Logger;
import java.util.Observer;
import java.util.Observable;
public class CurrentConditionsDisplay implements DisplayElement, Observer {
    
    private float humidity;
    private float temperature;
    private Observable subject;

    public final Logger LOGGER = Logger.getLogger(CurrentConditionsDisplay.class.getName());
    
    public CurrentConditionsDisplay(Observable weatherData) {
        LOGGER.info("[CREATING CurrentConditionsDisplay(Observable)]");
        this.subject = weatherData;
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object obj) {
        LOGGER.info("[ENTERING update(Observable, Object)]");
        if (o instanceof WeatherData) {
            LOGGER.info("[Object is instance of WeatherData Class]");
            WeatherData wd = (WeatherData) o;
            this.humidity = wd.getHummidity();
            this.temperature = wd.getTemperature();  
            display();
        }
        
    }

    @Override
    public void display() {
        LOGGER.info("[ENTERING display()]");
        System.out.println("Current conditions: " + temperature
        + "F degrees and " + humidity + "% humidity");
    }

    public Observable getObservable() {
        LOGGER.info("[GETTING the observable subject]");
        return subject;
    }

    public void setObservable(Observable observable) {
        LOGGER.info("[SETTING the Observable subject]");
        subject = observable;
    }
}