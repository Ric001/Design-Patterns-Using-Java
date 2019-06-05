import java.util.Observable;
import java.util.logging.Logger;
public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float pressure;
    public static final Logger LOGGER = Logger.getLogger(WeatherData.class.getName());

    public void measurementsChanged() {
        LOGGER.info("[ ENTERING measurementsChanged() ]");
        setChanged();
        notifyObservers(this);
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        LOGGER.info("[ENTERING setMeasurements(float, float, float)]");
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temp;
    }

    public void setTemperature(float temp) {
        this.temp = temp;
    }

    public float getHummidity() {
        return humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getPressure() {
        return pressure;
    }
}