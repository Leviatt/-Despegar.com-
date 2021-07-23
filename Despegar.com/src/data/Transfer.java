package data;

import java.io.*;

public class Transfer extends Service implements Serializable{
    
    String APlace;
    String DPlace;
    String PCapacity;
    String BagCapacity;

    public Transfer(String APlace, String DPlace, String PCapacity, String BagCapacity, String Name, String Date, String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.APlace = APlace;
        this.DPlace = DPlace;
        this.PCapacity = PCapacity;
        this.BagCapacity = BagCapacity;
    }

    public String getAPlace() {
        return APlace;
    }

    public String getDPlace() {
        return DPlace;
    }

    public String getPCapacity() {
        return PCapacity;
    }

    public String getBagCapacity() {
        return BagCapacity;
    }

    public void setAPlace(String APlace) {
        this.APlace = APlace;
    }

    public void setDPlace(String DPlace) {
        this.DPlace = DPlace;
    }

    public void setPCapacity(String PCapacity) {
        this.PCapacity = PCapacity;
    }

    public void setBagCapacity(String BagCapacity) {
        this.BagCapacity = BagCapacity;
    }
    
    
}
