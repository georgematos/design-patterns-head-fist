package app.subjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import app.measures.Measure;

public class WeatherData {

    // this property set class like Observable (subject)
    private PropertyChangeSupport support;

    Map<String, Measure> measures = new HashMap<>();

    public WeatherData() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setMeasurements(Map<String, Measure> measures) {
        // notify the listeners, arguments (propertyName, oldValue, newValue)
        support.firePropertyChange("measures", this.measures, measures);
        this.measures = measures;
    }

}
