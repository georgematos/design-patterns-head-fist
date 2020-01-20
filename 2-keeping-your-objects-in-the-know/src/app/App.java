package app;

import java.util.HashMap;
import java.util.Map;

import app.displays.CurrentConditionsDisplay;
import app.displays.ForecastDisplay;
import app.displays.StatisticsDisplay;
import app.measures.Humidity;
import app.measures.Measure;
import app.measures.Pressure;
import app.measures.Temperature;
import app.subjects.WeatherData;

public class App {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        CurrentConditionsDisplay ccDisplay = new CurrentConditionsDisplay();
        ForecastDisplay fcDisplay = new ForecastDisplay();
        StatisticsDisplay sDisplay = new StatisticsDisplay();

        wd.addPropertyChangeListener(ccDisplay);
        wd.addPropertyChangeListener(fcDisplay);
        wd.addPropertyChangeListener(sDisplay);

        System.out.println("----------------------------------");
        Map<String, Measure> measures = getNewListMeasures(80, 65, 30.3f);
        wd.setMeasurements(measures);
        System.out.println("----------------------------------");
        Map<String, Measure> measures2 = getNewListMeasures(82, 70, 29.2f);
        wd.setMeasurements(measures2);
        System.out.println("----------------------------------");
        Map<String, Measure> measures3 = getNewListMeasures(78, 90, 29.2f);
        wd.setMeasurements(measures3);
    }

    private static HashMap<String, Measure> getNewListMeasures(float temp, float humidity, float pressure) {

        HashMap<String, Measure> measures = new HashMap<>();
        measures.put("temperature", new Temperature(temp));
        measures.put("humidity", new Humidity(humidity));
        measures.put("pressure", new Pressure(pressure));

        return measures;
    }
}
