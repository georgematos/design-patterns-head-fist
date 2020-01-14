package app.displays;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import app.interfaces.DisplayElement;
import app.measures.Pressure;
import app.subjects.WeatherData;

public class ForecastDisplay implements PropertyChangeListener, DisplayElement {

    private Pressure currentPressure;
    private Pressure lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        currentPressure = new Pressure();
        currentPressure.setValue(29.92f);
        this.weatherData = weatherData;
        this.weatherData.addPropertyChangeListener(this);
    }

    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure.getValue() > lastPressure.getValue()) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure.getValue() == lastPressure.getValue()) {
            System.out.println("More of the same");
        } else if (currentPressure.getValue() < lastPressure.getValue()) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        lastPressure = currentPressure;

        if (event.getNewValue() instanceof HashMap) {
            HashMap<?, ?> measures = (HashMap<?, ?>) event.getNewValue();
            this.currentPressure = (Pressure) measures.get("pressure");
        }

        display();
    }
}
