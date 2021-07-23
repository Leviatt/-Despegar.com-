package data;

import java.io.Serializable;

public class Cruise extends Service implements Serializable{

    String Region;
    String Stops;
    String Duration;

    public Cruise(String Region, String Stops, String Duration, String Name, String Date, String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.Region = Region;
        this.Stops = Stops;
        this.Duration = Duration;
    }

    public String getRegion() {
        return Region;
    }
    
    public String getStops() {
        return Stops;
    }

    public String getDuration() {
        return Duration;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setStops(String Stops) {
        this.Stops = Stops;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    
    
    
}
