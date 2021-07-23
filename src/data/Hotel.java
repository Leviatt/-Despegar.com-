package data;

import java.io.*;

public class Hotel extends Service implements Serializable{
    
    String SuiteRooms;
    String MatrimonialRooms;
    String DoubleRooms;
    String SimpleRooms;
    String Stars;
    String Location;

    public Hotel() {
        super(null, null, null, null, null);
    }

    public Hotel(String SuiteRooms, String MatrimonialRooms, String DoubleRooms,
            String SimpleRooms, String Stars, String Location, String Name, String Date,
            String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.SuiteRooms = SuiteRooms;
        this.MatrimonialRooms = MatrimonialRooms;
        this.DoubleRooms = DoubleRooms;
        this.SimpleRooms = SimpleRooms;
        this.Stars = Stars;
        this.Location = Location;
    }    

    public String getSuiteRooms() {
        return SuiteRooms;
    }

    public String getMatrimonialRooms() {
        return MatrimonialRooms;
    }

    public String getDoubleRooms() {
        return DoubleRooms;
    }

    public String getSimpleRooms() {
        return SimpleRooms;
    }

    public String getStars() {
        return Stars;
    }

    public String getLocation() {
        return Location;
    }

    public void setSuiteRooms(String SuiteRooms) {
        this.SuiteRooms = SuiteRooms;
    }

    public void setMatrimonialRooms(String MatrimonialRooms) {
        this.MatrimonialRooms = MatrimonialRooms;
    }

    public void setDoubleRooms(String DoubleRooms) {
        this.DoubleRooms = DoubleRooms;
    }

    public void setSimpleRooms(String SimpleRooms) {
        this.SimpleRooms = SimpleRooms;
    }

    public void setStars(String Stars) {
        this.Stars = Stars;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    
}
