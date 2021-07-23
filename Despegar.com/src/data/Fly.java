package data;

import java.io.*;

public class Fly extends Service implements Serializable{

    String AHour;
    String DHour;
    String FirstClass;
    String ExeClass;
    String EcoClass;
    String APlace;
    String DPlace;
    String Airline;
    String Scales;

    public Fly(String AHour, String DHour, String FirstClass, String ExeClass, String EcoClass, String APlace, String DPlace, String Airline, String Scales, String Name, String Date, String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.AHour = AHour;
        this.DHour = DHour;
        this.FirstClass = FirstClass;
        this.ExeClass = ExeClass;
        this.EcoClass = EcoClass;
        this.APlace = APlace;
        this.DPlace = DPlace;
        this.Airline = Airline;
        this.Scales = Scales;
    }

    public String getAHour() {
        return AHour;
    }

    public String getDHour() {
        return DHour;
    }

    public String getFirstClass() {
        return FirstClass;
    }

    public String getExeClass() {
        return ExeClass;
    }

    public String getEcoClass() {
        return EcoClass;
    }

    public String getAPlace() {
        return APlace;
    }

    public String getDPlace() {
        return DPlace;
    }

    public String getAirline() {
        return Airline;
    }

    public String getScales() {
        return Scales;
    }

    public void setAHour(String AHour) {
        this.AHour = AHour;
    }

    public void setDHour(String DHour) {
        this.DHour = DHour;
    }

    public void setFirstClass(String FirstClass) {
        this.FirstClass = FirstClass;
    }

    public void setExeClass(String ExeClass) {
        this.ExeClass = ExeClass;
    }

    public void setEcoClass(String EcoClass) {
        this.EcoClass = EcoClass;
    }

    public void setAPlace(String APlace) {
        this.APlace = APlace;
    }

    public void setDPlace(String DPlace) {
        this.DPlace = DPlace;
    }

    public void setAirline(String Airline) {
        this.Airline = Airline;
    }

    public void setScales(String Scales) {
        this.Scales = Scales;
    }
}

    