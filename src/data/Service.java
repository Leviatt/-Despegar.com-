package data;

import java.io.Serializable;

public abstract class Service implements Serializable{
    String Name;
    String Date;
    String Price;
    String People;
    String Place;

    public Service(String Name, String Date, String Price, String People, String Place) {
        this.Name = Name;
        this.Date = Date;
        this.Price = Price;
        this.People = People;
        this.Place = Place;
    }

    public String getDate() {
        return Date;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getPlace() {
        return Place;
    }

    public String getPeople() {
        return People;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setPeople(String People) {
        this.People = People;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }
    
   
}
