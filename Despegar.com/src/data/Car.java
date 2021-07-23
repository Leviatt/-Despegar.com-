package data;

import java.io.*;

public class Car extends Service implements Serializable{

    String Plate;
    String Model;
    String Color;
    String Company;
    String Fuel;
    boolean Gps;

    public Car(String Plate, String Model, String Color, String Company, String Fuel, boolean Gps, String Name, String Date, String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.Plate = Plate;
        this.Model = Model;
        this.Color = Color;
        this.Company = Company;
        this.Fuel = Fuel;
        this.Gps = Gps;
    }

    public String getPlate() {
        return Plate;
    }

    public String getModel() {
        return Model;
    }

    public String getColor() {
        return Color;
    }

    public String getCompany() {
        return Company;
    }

    public String getFuel() {
        return Fuel;
    }

    public boolean isGps() {
        return Gps;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setFuel(String Fuel) {
        this.Fuel = Fuel;
    }

    public void setGps(boolean Gps) {
        this.Gps = Gps;
    }
        
    
}
