package app.subjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import app.measures.Measure;

public class WeatherData {

    // this property handle listeners
    private PropertyChangeSupport support;

    // property that will be listen
    Map<String, Measure> measures = new HashMap<>();

    public WeatherData() {
        support = new PropertyChangeSupport(this);
    }
    // adds a PropertyChangeListener, a object that will listener changes in this class
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    // removes a listener
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    // when this method is called, that is, when property 'measures' was change
    public void setMeasurements(Map<String, Measure> measures) {
        // notify the listeners (arguments: propertyName, oldValue, newValue)
        support.firePropertyChange("measures", this.measures, measures);
        this.measures = measures;
    }

}
