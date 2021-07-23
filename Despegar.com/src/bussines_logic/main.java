package bussines_logic;
import ui.*;
import data.*;
import java.io.*;
import java.util.HashMap;
import javax.swing.DefaultListModel;

public class main {
    //<editor-fold>
    public static HashMap<Integer, User> Users = new HashMap<>();
    public static HashMap<Integer, Car> Cars = new HashMap<>();
    public static HashMap<String, Cruise>  Cruises= new HashMap<>();
    public static HashMap<Integer, Fly> Flies = new HashMap<>();
    public static HashMap<Integer, Hotel> Hotels = new HashMap<>();
    public static HashMap<Integer, Safe> Safes = new HashMap<>();
    public static HashMap<String, Transfer> Transfers = new HashMap<>();
    public static HashMap<Integer, String> Airlines = new HashMap<>();
    public static HashMap<Integer, String> FliesList = new HashMap<>();
    public static HashMap<Integer, String> ModelHList = new HashMap<>();
    public static HashMap<Integer, String> CarHList = new HashMap<>();
    public static HashMap<Integer, String> CompanySafe = new HashMap<>();
    public static HashMap<Integer, String> Airports = new HashMap<>();
    //</editor-fold>
    
    
    //<editor-fold>
    public static DefaultListModel HotelList(){
        DefaultListModel hotelList = new DefaultListModel();
        Hotels.values().stream().forEach((cont) -> {
            hotelList.addElement(cont.getName() + " - " + cont.getPlace() + " - " + cont.getStars());
        });
        return hotelList;
    }
    public static DefaultListModel AirlineList(){
        DefaultListModel airlineList = new DefaultListModel();
        Airlines = new HashMap<>();
        for(Fly It: Flies.values()){
            if(!Airlines.containsValue(It.getAirline())){
                airlineList.addElement(It.getAirline());
                Airlines.put(Airlines.size(), It.getAirline());
            }
        }
        return airlineList;
    }
    public static DefaultListModel CompanySafeList(){
        DefaultListModel companySafeList = new DefaultListModel();
        CompanySafe = new HashMap<>();
        for(Safe It: Safes.values()){
            if(!CompanySafe.containsValue(It.getSafeCompany())){
                companySafeList.addElement(It.getSafeCompany());
                CompanySafe.put(CompanySafe.size(), It.getSafeCompany());
            }
        }
        return companySafeList;
    }
    public static DefaultListModel FliesList(){
        DefaultListModel fliesList = new DefaultListModel();
        FliesList.values().stream().forEach((cont) -> {
            fliesList.addElement(cont);
        });
        return fliesList;
    }
    public static DefaultListModel ModelList(){
        DefaultListModel AuxModelList = new DefaultListModel();
        ModelHList = new HashMap<>();
        int AuxKey = 0;
        for(Car CarIt: Cars.values()){
            if(!ModelHList.containsValue(CarIt.getModel())){
                AuxModelList.addElement(CarIt.getModel());
                ModelHList.put(AuxKey++, CarIt.getModel());
            }
        }
        return AuxModelList;
    }
    public static DefaultListModel CarList(){
        DefaultListModel AuxCarList = new DefaultListModel();
        CarHList = new HashMap<>();
        int AuxKey = 0;
        for(Car CarIt: Cars.values()){
            AuxCarList.addElement(CarIt.getName());
            ModelHList.put(AuxKey++, CarIt.getName());
        }
        return AuxCarList;
    }
    //</editor-fold>
    
    public static void main(String[] args){
        //<editor-fold>
        
        FileInputStream hotelFileStream = null;
        int HotelCount = 0;
        try{
            hotelFileStream = new FileInputStream("HotelList.obj");
            ObjectInputStream os = new ObjectInputStream(hotelFileStream);
            do{
                try{
                    Object HotelR = os.readObject();
                    Hotel RHotel = (Hotel) HotelR;
                    Hotels.put(HotelCount++, RHotel);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        /*--------------------------------------------------------------------*/
        FileInputStream userFileStream = null;
        Users = new HashMap(); 
        int UserCount = 0;
        try{
            userFileStream = new FileInputStream("UserList.obj");
            ObjectInputStream os = new ObjectInputStream(userFileStream);
            do{
                try{
                    Object UserR = os.readObject();
                    User RUser = (User) UserR;
                    Users.put(UserCount++, RUser);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
         /*--------------------------------------------------------------------*/
        FileInputStream CarFileStream = null;
        int CarCount = 0;
        try{
            CarFileStream = new FileInputStream("CarList.obj");
            ObjectInputStream os = new ObjectInputStream(CarFileStream);
            do{
                try{
                    Object CarR = os.readObject();
                    Car RCar = (Car) CarR;
                    Cars.put(CarCount++, RCar);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        //----------------------------------------------------------------------
        FileInputStream SafeFileStream = null;
        Safes = new HashMap(); 
        int SafeCount = 0;
        try{
            SafeFileStream = new FileInputStream("SafeList.obj");
            ObjectInputStream os = new ObjectInputStream(SafeFileStream);
            do{
                try{
                    Object SafeR = os.readObject();
                    Safe RSafe = (Safe) SafeR;
                    Safes.put(SafeCount++, RSafe);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        /*--------------------------------------------------------------------*/
        FileInputStream flyFileStream = null;
        Flies = new HashMap<>();
        int FlyCount = 0;
        try{
            flyFileStream = new FileInputStream("FlyList.obj");
            ObjectInputStream os = new ObjectInputStream(flyFileStream);
            do{
                try{
                    Object FlyR = os.readObject();
                    Fly RFly = (Fly) FlyR;
                    Flies.put(FlyCount++, RFly);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        //----------------------------------------------------------------------
        FileInputStream transferFileStream = null;
        Transfers = new HashMap<>();
        int TranCount = 0;
        try{
            transferFileStream = new FileInputStream("TransferList.obj");
            ObjectInputStream os = new ObjectInputStream(transferFileStream);
            do{
                try{
                    Object TranR = os.readObject();
                    Transfer RTran = (Transfer) TranR;
                    Transfers.put(RTran.getName(), RTran);
                }catch(EOFException ex){
                    break;
                }
            }while(os.available()+1 > 0);
            os.close();
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        /*--------------------------------------------------------------------*/
        for (Fly It: Flies.values()){
            boolean Contains = false;
            for(String IT : Airports.values()){
                if(IT.equals(It.getAPlace())){
                    Contains = true;
                    break;
                }
            }
            if(!Contains){
                String Airport$;
                Airport$ = It.getAPlace();
                Airports.put(Airports.size(), Airport$);
            }
            Contains = false;
            for(String IT : Airports.values()){
                if(IT.equals(It.getDPlace())){
                    Contains = true;
                    break;
                }
            }
            if(!Contains){
                String Airport$;
                Airport$ = It.getDPlace();
                Airports.put(Airports.size(), Airport$);
            }
        }
//</editor-fold>
        login.main(new String [1]);
     }  
}