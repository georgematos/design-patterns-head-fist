package app.displays;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import app.interfaces.DisplayElement;
import app.measures.Humidity;
import app.measures.Measure;
import app.measures.Temperature;

public class CurrentConditionsDisplay implements PropertyChangeListener, DisplayElement {

    private Measure temperature;
    private Measure humidity;

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature.getValue() + "F degrees and " + humidity.getValue()
                + "% humidity");
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

        if (event.getNewValue() instanceof HashMap) {
            Map<?, ?> measures = (HashMap<?, ?>) event.getNewValue();
            this.temperature = (Temperature) measures.get("temperature");
            this.humidity = (Humidity) measures.get("humidity");
        }

        display();
    }

}
