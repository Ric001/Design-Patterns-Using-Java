import java.util.Logging.Logger;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
    private float humidity;
    private float temperature;
    private float pressure;
    private Subject weatherData;

    public final Logger LOGGER = Logger.getLogger(CurrentConditionsDisplay.class.getName());
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
        + "F degrees and " + humidity + "% humidity");
    }



}