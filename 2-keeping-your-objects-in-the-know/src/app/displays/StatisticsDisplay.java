package app.displays;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import app.interfaces.DisplayElement;
import app.measures.Temperature;

public class StatisticsDisplay implements PropertyChangeListener, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

        if (event.getNewValue() instanceof HashMap) {
            HashMap<?, ?> measures = (HashMap<?, ?>) event.getNewValue();
            Temperature temp = (Temperature) measures.get("temperature");
            tempSum += temp.getValue();
            numReadings++;

            if (temp.getValue() > maxTemp) {
                maxTemp = temp.getValue();
            }

            if (temp.getValue() < minTemp) {
                minTemp = temp.getValue();
            }
        }

        display();
    }
}
