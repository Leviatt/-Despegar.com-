package data;

import java.io.*;

public class Safe extends Service implements Serializable{
    
    String SafeCompany;
    boolean[] Coverage;
    String Assistance;

    public Safe(String SafeCompany, boolean[] Coverage, String Assistance, String Name, String Date, String Price, String People, String Place) {
        super(Name, Date, Price, People, Place);
        this.SafeCompany = SafeCompany;
        this.Coverage = Coverage;
        this.Assistance = Assistance;
    }

    public String getAssistance() {
        return Assistance;
    }

    public boolean[] getCoverage() {
        return Coverage;
    }

    public String getSafeCompany() {
        return SafeCompany;
    }

    public void setAssistance(String Assistance) {
        this.Assistance = Assistance;
    }

    public void setCoverage(boolean[] Coverage) {
        this.Coverage = Coverage;
    }

    public void setSafeCompany(String SafeCompany) {
        this.SafeCompany = SafeCompany;
    }

   
}
