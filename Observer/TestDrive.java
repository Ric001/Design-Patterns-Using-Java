import java.util.Observer;
import java.util.Observable;
public class TestDrive {
    public static void main(String[] args) {
        Observable weatherData = new WeatherData();
        Observer currentConditionsDisp = new CurrentConditionsDisplay(weatherData);
        weatherData.addObserver(currentConditionsDisp);
        weatherData.addObserver(new ForeCastDisplay(weatherData));
        ((WeatherData) weatherData).setMeasurements(120f, 22f, 10f);
    }
}