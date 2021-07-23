package ui;

import bussines_logic.main;
import javax.swing.JOptionPane;
import java.io.*;
import data.*;
import java.util.HashMap;
import java.util.Random;
import javax.swing.DefaultListModel;

public class Admin extends javax.swing.JFrame {
    public static boolean AddHotel;
    public static boolean AddFly;
    public static boolean AddCar;
    public static boolean AddSafe;
    public static boolean HotelAirport;
    public int HotelKey = 0;
    public int ContAirline = 0;
    public int AirlineCont = 0;
    public int FliesCont = 0;
    public int DeletekeyF = 0;
    private int AuxMod = 0;
    private static HashMap<Integer,Hotel> HotelF;
    //<editor-fold>
 /*---------------------------------------------------------------------------*/  
    public void TransferGenerate(){
        for(String it: main.Airports.values()){
            for(Hotel It: main.Hotels.values()){
                String $Key = It.getPlace() + ", " + It.getName() + " - " + it;
                if(!main.Transfers.containsKey($Key)){
                    /*Random people = new Random();
                    int People = people.nextInt(12)+1;
                    Random bag = new Random();
                    int Bag = bag.nextInt(15)+1;
                    Random company = new Random();
                    int Company = company.nextInt(3)+1;
                    Random price = new Random();
                    int Price = price.nextInt(250)+1;
                    String Company$="";
                    switch(Company){
                        case 1:
                            Company$ = "Random House";
                            break;
                        case 2:
                            Company$ = "Taxi Transfer";
                            break;
                        case 3:
                            Company$ = "Company X";
                            break;
                    }*/
                    Transfer $Transfer = new Transfer(it, It.getPlace() + ", " +
                            It.getName(), "", "", $Key, "", 
                            "", "", "");
                    /*Transfer $Transfer = new Transfer(it, It.getPlace() + ", " +
                            It.getName(), People + "", Bag + "", $Key, "", 
                            Price + "", "", Company$);*/
                    main.Transfers.put($Key, $Transfer);
                }
            }
        }
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("TransferList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Transfer It : main.Transfers.values()){
                os.writeObject(It);
            }
            os.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    } 
 /*---------------------------------------------------------------------------*/
    public void InsuranceGenerate(){
        for(Safe it:main.Safes.values()){
           String $Key = it.getSafeCompany() + ", " + it.getName();
                if(!main.Safes.containsKey($Key)){
                    Random name = new Random(); 
                    int Name = name.nextInt(3)+1;
                    Random region = new Random();
                    int Region = region.nextInt(15)+1;
                    Random company = new Random();
                    int Company = company.nextInt(4)+1;
                    Random price = new Random();
                    int Price = price.nextInt(250)+1;
                    Random assist = new Random();
                    int Assistance = assist.nextInt(2500)+1;
                    
                    Random people = new Random();
                    int People = people.nextInt(12)+1;
                    Random coverage = new Random();
                    boolean Coverage = coverage.nextBoolean();
                    String Company$ = "";
                    switch(Company){
                        case 1:
                            Company$ = "Life Company";
                            break;
                        case 2:
                            Company$ = "Life ensure";
                            break;
                        case 3:
                            Company$ = "Happy Life";
                            break;
                        case 4:
                            Company$ = "Money Life";
                            break;
                            
                    }
                    String Name$ = "";
                    switch(Name){
                        case 1:
                            Name$ = "Dissease package";
                            break;
                        case 2:
                            Name$ = "Die package";
                            break;
                        case 3:
                            Name$ = "Bags package";
                            break;
                    }
                    String Region$ = "";
                    switch(Region){
                        case 1:
                            Region$ = "Argentina";
                            break;
                        case 2:
                            Region$ = "Die package";
                            break;
                        case 3:
                            Region$ = "Bags package";
                            break;
            }
                    Safe $Safe = new Safe(Company + "",it.getCoverage(), Assistance + "", Name + "",
                            "", Price + "",People + "",Region + "");
                    
                    main.Safes.put(Name, $Safe);
        
        }
        }
           FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("SafeList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Safe It : main.Safes.values()){
                os.writeObject(It);
            }
            os.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
 /*---------------------------------------------------------------------------*/   
    public void LogOutMethod(){
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Log out?",
                            "Log out", JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION){
            login.main(new String[1]);
            this.dispose();
        }
    }
//------------------------------------------------------------------------------
    public void ClearSFields(){
        CompanySField.setText("");
        PackageSField.setText("");
        AssistanceSField.setText("");
        PriceSField.setText("");
        PeopleSSlider.setValue(1);
        RegionSComboBox.setSelectedIndex(0);
        Box1.setSelected(false);
        Box2.setSelected(false);
        Box3.setSelected(false);
        Box4.setSelected(false);
        Box5.setSelected(false);
        Box6.setSelected(false);
    }
//------------------------------------------------------------------------------
    public void ClearCFields(){
        PlateCField.setText("");
        ColorCComboBox.setSelectedIndex(0);
        GpsCCheckBox.setSelected(false);
        FuelCComboBox.setSelectedIndex(0);
        ModelCField.setText("");
        DateCField.setText("");
        PriceCField.setText("");
        PeopleCField.setText("");
        PlaceCField.setText("");
        CompanyCField.setText("");
        BrandCField.setText("");
    }
 /*---------------------------------------------------------------------------*/        
    public void HSearch(){
        if(searchH.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contains = false;
            for(Hotel It : main.Hotels.values()){
                if(It.getName().toLowerCase().contains(searchH.getText().toLowerCase())){
                    SearchModel.addElement(It.getName() + " - " + It.getPlace() + " - " + It.getStars());
                    Contains = true;
                   
                }
            }
            if(Contains){
                HotelJList.setModel(SearchModel);
            }else{
                HotelJList.setModel(main.HotelList());
            }
        }else{
            HotelJList.setModel(main.HotelList());
        }
    }
 /*---------------------------------------------------------------------------*/
    public void AirlineSearch(){
        if(SearchAirlineF.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contains = false;
            for(String It : main.Airlines.values()){
                if(It.toLowerCase().contains(SearchAirlineF.getText().toLowerCase())){
                    SearchModel.addElement(It);
                    Contains = true;
                }
            }
            if(Contains){
                AirlineJList.setModel(SearchModel);
                
            }else{
                AirlineJList.setModel(main.AirlineList());
            }
        }else{
             AirlineJList.setModel(main.AirlineList());
        }
    }
 //-----------------------------------------------------------------------------
    public void ModelSearch(){
        if(SearchModelCField.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contains = false;
            for(String It : main.ModelHList.values()){
                if(It.toLowerCase().contains(SearchModelCField.getText().toLowerCase())){
                    SearchModel.addElement(It);
                    Contains = true;
                }
            }
            if(Contains){
                ModelCList.setModel(SearchModel);
            }else{
                ModelCList.setModel(main.ModelList());
            }
        }else{
             ModelCList.setModel(main.ModelList());
        }
    }
//------------------------------------------------------------------------------
    public void CarSearch(){
        if(SearchCarCField.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contains = false;
            /*for(String It : main.CarHList.values()){
                if(It.toLowerCase().contains(SearchCarCField.getText().toLowerCase())){
                    SearchModel.addElement(It);
                    Contains = true;
                }
            }*/
            for(Car It : main.Cars.values()){
                if(It.getModel().toLowerCase().contains(((String)ModelCList.getSelectedValue()).toLowerCase()) &&
                        It.getName().toLowerCase().contains(SearchCarCField.getText().toLowerCase())){
                    System.err.println(true);
                    SearchModel.addElement(It.getName());
                    Contains = true;
                }
            }
            if(Contains){
                CarCList.setModel(SearchModel);
            }else{
                CarCList.setModel(main.CarList());
            }
        }else{
            //CarCList.setModel(main.CarList());
            DefaultListModel SearchModel = new DefaultListModel();
            for(Car It : main.Cars.values()){ 
                if(It.getModel().equals((String)ModelCList.getSelectedValue())){
                    SearchModel.addElement(It.getName());
                }
            }
            CarCList.setModel(SearchModel);
        }
    }
 /*---------------------------------------------------------------------------*/
    public void FlySearch(){
        if(SearchFlyF.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contains = false;
            for(String It : main.FliesList.values()){
                if(It.toLowerCase().contains(SearchFlyF.getText().toLowerCase())){
                    SearchModel.addElement(It);
                    Contains = true;
                }
            }
            if(Contains){
                FliesJList.setModel(SearchModel);
            }else{
                FliesJList.setModel(main.FliesList());
            }
        }else{
             FliesJList.setModel(main.FliesList());
        }
    }
 /*---------------------------------------------------------------------------*/
    public void TSearch1(){
       if(HotelAirport){
           DefaultListModel ModelT1= new DefaultListModel();
           for(Hotel It : main.Hotels.values()){
                ModelT1.addElement(It.getPlace() + ", " + It.getName());
           }    
            if(SearchTField.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contain = false;
            for(Hotel It : main.Hotels.values()){
                if(It.getName().toLowerCase().contains(SearchTField.getText().toLowerCase())
                        ||It.getPlace().toLowerCase().contains(SearchTField.getText().toLowerCase())){
                    SearchModel.addElement(It.getPlace() + ", " + It.getName());
                    Contain = true;
                }
            }
                if(Contain){
                TransferList1.setModel(SearchModel);
                }else{
                TransferList1.setModel(ModelT1);
                }
            }else{
            TransferList1.setModel(ModelT1);
            PCapTField.setText("");
            BCapTField.setText("");
            CompanyTField.setText("");
            PriceTField.setText("");
            TransferList2.setModel(new DefaultListModel());
        }
                
        }else{
           DefaultListModel ModelT2= new DefaultListModel();
           for(String It : main.Airports.values()){
                ModelT2.addElement(It);
           }    
            if(SearchTField.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contain$ = false;
            for(String It : main.Airports.values()){
                if((It).toLowerCase().contains(SearchTField.getText().toLowerCase())){
                    SearchModel.addElement(It);
                    Contain$ = true;
                }
            }
                if(Contain$){
                    TransferList1.setModel(SearchModel);
                }else{
                    TransferList1.setModel(ModelT2);
            }
            }else{
                TransferList1.setModel(ModelT2);
                PCapTField.setText("");
                BCapTField.setText("");
                CompanyTField.setText("");
                PriceTField.setText("");
        
            } 
       }
  
     }    
 /*---------------------------------------------------------------------------*/
    public void TSearch2(){
       if(!HotelAirport){
            if(SearchTField2.getText().length() != 0){
            DefaultListModel SearchModel = new DefaultListModel();
            boolean Contain = false;
            for(Hotel It : main.Hotels.values()){
                if(It.getName().toLowerCase().contains(SearchTField2.getText().toLowerCase())
                        ||It.getPlace().toLowerCase().contains(SearchTField2.getText().toLowerCase())){
                    SearchModel.addElement(It.getPlace() + ", " + It.getName());
                    Contain = true;
                }
            }
                if(Contain){
                    TransferList2.setModel(SearchModel);
                }else{
                    PCapTField.setText("");
                    BCapTField.setText("");
                    CompanyTField.setText("");
                    PriceTField.setText("");
                }

            }else{
               DefaultListModel ModelT2= new DefaultListModel();
               for(String It : main.Airports.values()){
                    ModelT2.addElement(It);
               }    
                if(SearchTField2.getText().length() != 0){
                DefaultListModel SearchModel = new DefaultListModel();
                boolean Contain$ = false;
                for(String It : main.Airports.values()){
                    if((It).toLowerCase().contains(SearchTField2.getText().toLowerCase())){
                        SearchModel.addElement(It);
                        Contain$ = true;
                    }
                }
                    if(Contain$){
                        TransferList2.setModel(SearchModel);
                    }else{
                        TransferList2.setModel(ModelT2);
                }
                }else{
                    TransferList2.setModel(ModelT2);

                } 
           }
       }
    } 
 /*---------------------------------------------------------------------------*/    
    public void Hsave(){
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("HotelList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(data.Hotel It : main.Hotels.values()){
                os.writeObject(It);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        hotelSave.setEnabled(false);
        HotelJList.setModel(main.HotelList());
        HotelNameField.setEditable(false);
        HotelStarsField.setEditable(false);
        HotelLocationField.setEditable(false);
        RoomPriceField.setEditable(false);
        HotelSuiteField.setEditable(false);
        HotelMatrimonialField.setEditable(false);
        HotelDoubleField.setEditable(false);
        HotelSimpleField.setEditable(false);
        HotelPlaceField.setEditable(false);
        addH.setEnabled(true);
        HotelNameField.setText("");
        HotelStarsField.setText("");
        HotelLocationField.setText("");
        RoomPriceField.setText("");
        HotelSuiteField.setText("");
        HotelMatrimonialField.setText("");
        HotelDoubleField.setText("");
        HotelSimpleField.setText("");
        HotelPlaceField.setText("");
        HotelJList.setEnabled(true);
        editeH.setEnabled(false);
        deleteH.setEnabled(false);
    }
//-----------------------------------------------------------------------------
    public void CSave(){
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("CarList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Car CarIt : main.Cars.values()){
                os.writeObject(CarIt);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        ModelCList.setModel(main.ModelList());
        CarCList.setModel(main.CarList());
        EDCComponent(false);
        ClearCFields();
    }
/*----------------------------------------------------------------------------*/
    public void SSave(){
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("SafeList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Safe It : main.Safes.values()){
                os.writeObject(It);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        CompanySList.setModel(main.CompanySafeList());
        CompanySList.setEnabled(true);
        //CarCList.setModel(main.CarList());
        EDSComponent(false);
        ClearSFields();
    }
//------------------------------------------------------------------------------    
    public void EDCComponent(boolean Bol){
        CarCList.setEnabled(Bol);
        PlateCField.setEnabled(Bol);
        ColorCComboBox.setEnabled(Bol);
        CompanyCField.setEnabled(Bol);
        GpsCCheckBox.setEnabled(Bol);
        FuelCComboBox.setEnabled(Bol);
        ModelCField.setEnabled(Bol);
        DateCField.setEnabled(Bol);
        PeopleCField.setEnabled(Bol);
        PriceCField.setEnabled(Bol);
        PlaceCField.setEnabled(Bol);
        AddCButton.setEnabled(!Bol);
        SaveCButton.setEnabled(Bol);
        CancelCButton.setEnabled(Bol);  
        ModelCLabel.setVisible(Bol);
        BrandCField.setVisible(Bol);
        CarCLabel.setVisible(Bol);
        ModelCField.setVisible(Bol);
        CancelCButton.setEnabled(Bol);
        ModelCList.setEnabled(!Bol);
        CarCList.setEnabled(!Bol);
    }
//------------------------------------------------------------------------------
    public void EDSComponent(boolean Bol){
        AssistanceSField.setEnabled(Bol);
        PriceSField.setEnabled(Bol);
        PeopleSSlider.setEnabled(Bol);
        RegionSComboBox.setEnabled(Bol);
        Box1.setEnabled(Bol);
        Box2.setEnabled(Bol);
        Box3.setEnabled(Bol);
        Box4.setEnabled(Bol);
        Box5.setEnabled(Bol);
        Box6.setEnabled(Bol);
        SaveSButton.setEnabled(Bol);
        CancelSButton.setEnabled(Bol);
        AddSButton.setEnabled(!Bol);
        CompanySField.setVisible(Bol);
        CompanySLabel.setVisible(Bol);
        CompanySField.setEnabled(Bol);
        PackageSLabel.setVisible(Bol);
        PackageSField.setVisible(Bol);
        PackageSField.setEnabled(Bol);
        
    }
//------------------------------------------------------------------------------
    private void UpdateCarModel() {
        DefaultListModel CarModel = new DefaultListModel();
        CarCList.setEnabled(true);
         main.Cars.values().stream().filter((CarIt) -> (CarIt.getModel().equals(ModelCList.getSelectedValue()))).forEach((CarIt) -> {
            CarModel.addElement(CarIt.getName());
        });
        CarCList.setModel(CarModel);
    }    

  /*----------------------------------------------------------------------------*/    
    public void FSave(){
           
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("FlyList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Fly It : main.Flies.values()){
                os.writeObject(It);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        AirlineJList.setEnabled(true);
        AirlineJList.setModel(main.AirlineList());
        FliesJList.setEnabled(true);
        FliesJList.setModel(new DefaultListModel());
        DPlaceFField.setText("");
        DHourFField.setText("");
        APlaceFField.setText("");
        AHourFField.setText("");
        SeatsPriceFField.setText("");
        ExeFField.setText("");
        EcoFField.setText("");
        FirstFField.setText("");
        ScalesFField.setText("");
        DateFField.setText("");
        PeopleFField.setText("");
        DPlaceFField.setEditable(false);
        DHourFField.setEditable(false);
        APlaceFField.setEditable(false);
        AHourFField.setEditable(false);
        SeatsPriceFField.setEditable(false);
        ScalesFField.setEditable(false);
        DateFField.setEditable(false);
        PeopleFField.setEditable(false);
        FirstFField.setEditable(false);
        EcoFField.setEditable(false);
        ExeFField.setEditable(false);
        NameFLabel.setVisible(false);
        NameFField.setVisible(false);
        AirlineFLabel.setVisible(false);
        AirlineFField.setVisible(false);
        addF.setEnabled(true);
        editeF.setEnabled(false);
        cancelF.setEnabled(false);
        saveF.setEnabled(false);
        deleteF.setEnabled(false);        
        
    }
 /*---------------------------------------------------------------------------*/
    public void TSave(){
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("TransferList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(Transfer It : main.Transfers.values()){
                os.writeObject(It);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        TransferList1.setModel(new DefaultListModel());
        TransferList2.setModel(new DefaultListModel());
        PCapTField.setText("");
        BCapTField.setText("");
        CompanyTField.setText("");
        PriceTField.setText("");
        PCapTField.setEnabled(false);
        BCapTField.setEnabled(false);
        CompanyTField.setEnabled(false);
        PriceTField.setEnabled(false);
        TransferList1.setEnabled(false);
        TransferList2.setEnabled(false);
        HotelsTOption.setEnabled(true);
        AirportsTOption.setEnabled(true);
    }

  /*---------------------------------------------------------------------------*/
    public Admin() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        searchH = new javax.swing.JTextField();
        contactList = new javax.swing.JScrollPane();
        HotelJList = new javax.swing.JList();
        editeH = new javax.swing.JButton();
        addH = new javax.swing.JButton();
        deleteH = new javax.swing.JButton();
        lastName = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RoomPriceField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        HotelMatrimonialField = new javax.swing.JTextField();
        HotelSuiteField = new javax.swing.JTextField();
        HotelDoubleField = new javax.swing.JTextField();
        HotelSimpleField = new javax.swing.JTextField();
        hotelSave = new javax.swing.JButton();
        HotelPlaceField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        HotelNameField = new javax.swing.JTextField();
        HotelStarsField = new javax.swing.JTextField();
        HotelLocationField = new javax.swing.JTextField();
        CancelHotel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SearchAirlineF = new javax.swing.JTextField();
        contactList1 = new javax.swing.JScrollPane();
        AirlineJList = new javax.swing.JList();
        editeF = new javax.swing.JButton();
        addF = new javax.swing.JButton();
        deleteF = new javax.swing.JButton();
        saveF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FliesJList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        APlaceFField = new javax.swing.JTextField();
        DHourFField = new javax.swing.JTextField();
        AHourFField = new javax.swing.JTextField();
        DPlaceFField = new javax.swing.JTextField();
        SeatsPriceFField = new javax.swing.JTextField();
        cancelF = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        FirstFField = new javax.swing.JTextField();
        ExeFField = new javax.swing.JTextField();
        EcoFField = new javax.swing.JTextField();
        NameFLabel = new javax.swing.JLabel();
        AirlineFLabel = new javax.swing.JLabel();
        NameFField = new javax.swing.JTextField();
        AirlineFField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ScalesFField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DateFField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        PeopleFField = new javax.swing.JTextField();
        SearchFlyF = new javax.swing.JTextField();
        LogOut1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        SearchModelCField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        contactList2 = new javax.swing.JScrollPane();
        ModelCList = new javax.swing.JList();
        EditeCButton = new javax.swing.JButton();
        DeleteCButton = new javax.swing.JButton();
        AddCButton = new javax.swing.JButton();
        SaveCButton = new javax.swing.JButton();
        CancelCButton = new javax.swing.JButton();
        Log_outCButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CarCList = new javax.swing.JList<>();
        SearchCarCField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        PlateCField = new javax.swing.JTextField();
        ColorCComboBox = new javax.swing.JComboBox<>();
        CompanyCField = new javax.swing.JTextField();
        GpsCCheckBox = new javax.swing.JCheckBox();
        PriceCField = new javax.swing.JTextField();
        DateCField = new javax.swing.JTextField();
        PeopleCField = new javax.swing.JTextField();
        PlaceCField = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        BrandCField = new javax.swing.JTextField();
        ModelCField = new javax.swing.JTextField();
        ModelCLabel = new javax.swing.JLabel();
        CarCLabel = new javax.swing.JLabel();
        FuelCComboBox = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        SearchCompanySField = new javax.swing.JTextField();
        contactList3 = new javax.swing.JScrollPane();
        CompanySList = new javax.swing.JList();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        SearchPackageSField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        PackageSList = new javax.swing.JList<>();
        EditeSButton = new javax.swing.JButton();
        DeleteSButton = new javax.swing.JButton();
        AddSButton = new javax.swing.JButton();
        SaveSButton = new javax.swing.JButton();
        CancelSButton = new javax.swing.JButton();
        Log_outButton = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        AssistanceSField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        PriceSField = new javax.swing.JTextField();
        ModelCLabel1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        Box1 = new javax.swing.JCheckBox();
        Box2 = new javax.swing.JCheckBox();
        Box3 = new javax.swing.JCheckBox();
        Box4 = new javax.swing.JCheckBox();
        Box5 = new javax.swing.JCheckBox();
        Box6 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        PeopleSSlider = new javax.swing.JSlider();
        RegionSComboBox = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        CompanySLabel = new javax.swing.JLabel();
        CompanySField = new javax.swing.JTextField();
        PackageSLabel = new javax.swing.JLabel();
        PackageSField = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        PriceTField = new javax.swing.JTextField();
        SearchTField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        contactList4 = new javax.swing.JScrollPane();
        TransferList1 = new javax.swing.JList();
        jLabel50 = new javax.swing.JLabel();
        EditeTButton = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        SaveTButton = new javax.swing.JButton();
        CancelTButton = new javax.swing.JButton();
        Log_outTButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TransferList2 = new javax.swing.JList<>();
        SearchTField2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        PCapTField = new javax.swing.JTextField();
        BCapTField = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        HotelsTOption = new javax.swing.JRadioButton();
        AirportsTOption = new javax.swing.JRadioButton();
        CompanyTField = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        contactList5 = new javax.swing.JScrollPane();
        HotelJList1 = new javax.swing.JList();
        editeH1 = new javax.swing.JButton();
        hotelSave1 = new javax.swing.JButton();
        LogOut2 = new javax.swing.JButton();
        CancelHotel1 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Despegar.com");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(754, 413));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(754, 413));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.setLayout(null);

        searchH.setToolTipText("");
        searchH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHActionPerformed(evt);
            }
        });
        searchH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchHKeyReleased(evt);
            }
        });
        jPanel1.add(searchH);
        searchH.setBounds(274, 30, 342, 24);

        HotelJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                HotelJListValueChanged(evt);
            }
        });
        contactList.setViewportView(HotelJList);
        HotelJList.getAccessibleContext().setAccessibleDescription("");
        HotelJList.getAccessibleContext().setAccessibleParent(HotelJList);

        jPanel1.add(contactList);
        contactList.setBounds(15, 13, 202, 261);

        editeH.setText("Edite");
        editeH.setEnabled(false);
        editeH.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                editeHComponentShown(evt);
            }
        });
        editeH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editeHActionPerformed(evt);
            }
        });
        jPanel1.add(editeH);
        editeH.setBounds(200, 298, 103, 25);

        addH.setText("Add");
        addH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHActionPerformed(evt);
            }
        });
        jPanel1.add(addH);
        addH.setBounds(310, 298, 103, 25);

        deleteH.setText("Delete");
        deleteH.setEnabled(false);
        deleteH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHActionPerformed(evt);
            }
        });
        jPanel1.add(deleteH);
        deleteH.setBounds(200, 330, 103, 25);

        lastName.setText("Stars:");
        jPanel1.add(lastName);
        lastName.setBounds(274, 121, 35, 14);

        name.setText("Name:");
        jPanel1.add(name);
        name.setBounds(278, 86, 38, 16);

        jLabel6.setText("Overall rooms price:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(274, 231, 117, 16);

        RoomPriceField.setEditable(false);
        jPanel1.add(RoomPriceField);
        RoomPriceField.setBounds(409, 228, 75, 22);

        jLabel8.setText("Suite:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(558, 157, 34, 16);

        jLabel9.setText("Matrimonial:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(520, 192, 72, 16);

        jLabel10.setText("Double");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(642, 157, 39, 16);

        jLabel11.setText("Simple");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(642, 192, 39, 16);

        HotelMatrimonialField.setEditable(false);
        jPanel1.add(HotelMatrimonialField);
        HotelMatrimonialField.setBounds(597, 189, 40, 22);

        HotelSuiteField.setEditable(false);
        jPanel1.add(HotelSuiteField);
        HotelSuiteField.setBounds(597, 154, 40, 22);

        HotelDoubleField.setEditable(false);
        jPanel1.add(HotelDoubleField);
        HotelDoubleField.setBounds(686, 154, 40, 22);

        HotelSimpleField.setEditable(false);
        jPanel1.add(HotelSimpleField);
        HotelSimpleField.setBounds(686, 189, 40, 22);

        hotelSave.setText("Save");
        hotelSave.setEnabled(false);
        hotelSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelSaveActionPerformed(evt);
            }
        });
        jPanel1.add(hotelSave);
        hotelSave.setBounds(310, 330, 103, 25);

        HotelPlaceField.setEditable(false);
        jPanel1.add(HotelPlaceField);
        HotelPlaceField.setBounds(342, 191, 142, 22);

        jLabel14.setText("Location:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(274, 154, 52, 16);

        jLabel15.setText("Place:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(274, 194, 35, 16);

        jLabel16.setText("Free roms:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(520, 112, 64, 16);

        HotelNameField.setEditable(false);
        jPanel1.add(HotelNameField);
        HotelNameField.setBounds(344, 83, 137, 22);

        HotelStarsField.setEditable(false);
        jPanel1.add(HotelStarsField);
        HotelStarsField.setBounds(344, 117, 140, 22);

        HotelLocationField.setEditable(false);
        jPanel1.add(HotelLocationField);
        HotelLocationField.setBounds(344, 154, 140, 22);

        CancelHotel.setText("Cancel");
        CancelHotel.setEnabled(false);
        CancelHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelHotelActionPerformed(evt);
            }
        });
        jPanel1.add(CancelHotel);
        CancelHotel.setBounds(420, 298, 103, 25);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(634, 30, 30, 25);

        LogOut.setText("Log out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jPanel1.add(LogOut);
        LogOut.setBounds(420, 330, 103, 25);

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setOpaque(true);
        jPanel1.add(jLabel51);
        jLabel51.setBounds(0, 0, 760, 390);

        jTabbedPane1.addTab("Hotels", new javax.swing.ImageIcon(getClass().getResource("/icons/cama.png")), jPanel1); // NOI18N

        jPanel2.setToolTipText("");
        jPanel2.setLayout(null);

        SearchAirlineF.setToolTipText("");
        SearchAirlineF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchAirlineFKeyReleased(evt);
            }
        });
        jPanel2.add(SearchAirlineF);
        SearchAirlineF.setBounds(58, 13, 125, 24);

        AirlineJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AirlineJListValueChanged(evt);
            }
        });
        contactList1.setViewportView(AirlineJList);

        jPanel2.add(contactList1);
        contactList1.setBounds(12, 44, 192, 256);

        editeF.setText("Edite");
        editeF.setEnabled(false);
        editeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editeFActionPerformed(evt);
            }
        });
        jPanel2.add(editeF);
        editeF.setBounds(200, 313, 103, 25);

        addF.setText("Add");
        addF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFActionPerformed(evt);
            }
        });
        jPanel2.add(addF);
        addF.setBounds(310, 313, 103, 25);

        deleteF.setText("Delete");
        deleteF.setEnabled(false);
        deleteF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFActionPerformed(evt);
            }
        });
        jPanel2.add(deleteF);
        deleteF.setBounds(200, 345, 103, 25);

        saveF.setText("Save");
        saveF.setEnabled(false);
        saveF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFActionPerformed(evt);
            }
        });
        jPanel2.add(saveF);
        saveF.setBounds(310, 345, 103, 25);

        FliesJList.setEnabled(false);
        FliesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                FliesJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(FliesJList);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(216, 44, 131, 256);

        jLabel1.setText("Arrival Hour");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(365, 128, 68, 16);

        jLabel2.setText("Departure place:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(365, 50, 96, 16);

        jLabel3.setText("Arrival place:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(365, 75, 76, 14);

        jLabel5.setText("Departure Hour");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(365, 101, 88, 16);

        jLabel12.setText("Free Seats:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(365, 192, 67, 16);

        jLabel13.setText("Overall seats price:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(365, 155, 111, 16);

        APlaceFField.setEditable(false);
        jPanel2.add(APlaceFField);
        APlaceFField.setBounds(482, 71, 80, 22);

        DHourFField.setEditable(false);
        jPanel2.add(DHourFField);
        DHourFField.setBounds(482, 98, 80, 22);

        AHourFField.setEditable(false);
        jPanel2.add(AHourFField);
        AHourFField.setBounds(482, 125, 80, 22);

        DPlaceFField.setEditable(false);
        jPanel2.add(DPlaceFField);
        DPlaceFField.setBounds(479, 44, 80, 22);

        SeatsPriceFField.setEditable(false);
        jPanel2.add(SeatsPriceFField);
        SeatsPriceFField.setBounds(482, 152, 80, 22);

        cancelF.setText("Cancel");
        cancelF.setEnabled(false);
        cancelF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFActionPerformed(evt);
            }
        });
        jPanel2.add(cancelF);
        cancelF.setBounds(420, 313, 103, 25);

        jLabel18.setText("First Class:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(464, 213, 64, 16);

        jLabel19.setText("Economic:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(464, 271, 59, 16);

        jLabel20.setText("Executive:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(464, 242, 58, 16);

        FirstFField.setEditable(false);
        jPanel2.add(FirstFField);
        FirstFField.setBounds(540, 210, 48, 22);

        ExeFField.setEditable(false);
        jPanel2.add(ExeFField);
        ExeFField.setBounds(540, 239, 48, 22);

        EcoFField.setEditable(false);
        jPanel2.add(EcoFField);
        EcoFField.setBounds(540, 268, 48, 22);

        NameFLabel.setText("Name");
        jPanel2.add(NameFLabel);
        NameFLabel.setBounds(574, 128, 33, 16);

        AirlineFLabel.setText("Airline");
        jPanel2.add(AirlineFLabel);
        AirlineFLabel.setBounds(574, 155, 36, 16);

        NameFField.setEditable(false);
        jPanel2.add(NameFField);
        NameFField.setBounds(624, 121, 80, 22);

        AirlineFField.setEditable(false);
        jPanel2.add(AirlineFField);
        AirlineFField.setBounds(624, 148, 80, 22);

        jLabel21.setText("Scales");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(571, 47, 37, 16);

        ScalesFField.setEditable(false);
        jPanel2.add(ScalesFField);
        ScalesFField.setBounds(624, 44, 80, 22);

        jLabel22.setText("Date");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(574, 74, 26, 16);

        DateFField.setEditable(false);
        jPanel2.add(DateFField);
        DateFField.setBounds(624, 71, 80, 18);

        jLabel23.setText("People");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(574, 101, 38, 16);

        PeopleFField.setEditable(false);
        jPanel2.add(PeopleFField);
        PeopleFField.setBounds(624, 94, 80, 22);

        SearchFlyF.setEnabled(false);
        SearchFlyF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFlyFKeyReleased(evt);
            }
        });
        jPanel2.add(SearchFlyF);
        SearchFlyF.setBounds(243, 13, 87, 24);

        LogOut1.setText("Log out");
        LogOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOut1ActionPerformed(evt);
            }
        });
        jPanel2.add(LogOut1);
        LogOut1.setBounds(420, 345, 103, 25);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel2.add(jLabel24);
        jLabel24.setBounds(335, 13, 16, 24);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel2.add(jLabel25);
        jLabel25.setBounds(188, 13, 16, 24);

        jLabel17.setText("Airline:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(12, 17, 41, 16);

        jLabel28.setText("Fly:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(217, 17, 21, 16);

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setOpaque(true);
        jPanel2.add(jLabel54);
        jLabel54.setBounds(0, 0, 760, 390);

        jTabbedPane1.addTab("Flights", new javax.swing.ImageIcon(getClass().getResource("/icons/aeroplano.png")), jPanel2); // NOI18N

        jPanel3.setLayout(null);

        SearchModelCField.setToolTipText("");
        SearchModelCField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchModelCFieldKeyReleased(evt);
            }
        });
        jPanel3.add(SearchModelCField);
        SearchModelCField.setBounds(52, 11, 136, 24);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel3.add(jLabel26);
        jLabel26.setBounds(192, 11, 16, 24);

        ModelCList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ModelCListValueChanged(evt);
            }
        });
        contactList2.setViewportView(ModelCList);

        jPanel3.add(contactList2);
        contactList2.setBounds(10, 41, 192, 236);

        EditeCButton.setText("Edite");
        EditeCButton.setEnabled(false);
        EditeCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditeCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(EditeCButton);
        EditeCButton.setBounds(200, 288, 103, 25);

        DeleteCButton.setText("Delete");
        DeleteCButton.setEnabled(false);
        DeleteCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(DeleteCButton);
        DeleteCButton.setBounds(200, 319, 103, 25);

        AddCButton.setText("Add");
        AddCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(AddCButton);
        AddCButton.setBounds(309, 288, 103, 25);

        SaveCButton.setText("Save");
        SaveCButton.setEnabled(false);
        SaveCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(SaveCButton);
        SaveCButton.setBounds(309, 319, 103, 25);

        CancelCButton.setText("Cancel");
        CancelCButton.setEnabled(false);
        CancelCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(CancelCButton);
        CancelCButton.setBounds(418, 288, 103, 25);

        Log_outCButton.setText("Log out");
        Log_outCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_outCButtonActionPerformed(evt);
            }
        });
        jPanel3.add(Log_outCButton);
        Log_outCButton.setBounds(418, 319, 103, 25);

        CarCList.setEnabled(false);
        CarCList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CarCListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(CarCList);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(212, 41, 131, 236);

        SearchCarCField.setEnabled(false);
        SearchCarCField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchCarCFieldKeyReleased(evt);
            }
        });
        jPanel3.add(SearchCarCField);
        SearchCarCField.setBounds(259, 11, 72, 24);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel3.add(jLabel27);
        jLabel27.setBounds(336, 11, 16, 24);

        jLabel29.setText("Brand:");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(10, 16, 38, 16);

        jLabel30.setText("Model:");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(218, 16, 39, 16);
        jPanel3.add(PlateCField);
        PlateCField.setBounds(430, 52, 80, 22);

        ColorCComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Yellow", "Black", "Blue", "Green", "White", "Grey", "Orange", "Purple" }));
        jPanel3.add(ColorCComboBox);
        ColorCComboBox.setBounds(434, 80, 81, 22);
        jPanel3.add(CompanyCField);
        CompanyCField.setBounds(434, 108, 81, 22);
        jPanel3.add(GpsCCheckBox);
        GpsCCheckBox.setBounds(595, 88, 21, 21);
        jPanel3.add(PriceCField);
        PriceCField.setBounds(434, 192, 80, 22);
        jPanel3.add(DateCField);
        DateCField.setBounds(434, 164, 80, 22);
        jPanel3.add(PeopleCField);
        PeopleCField.setBounds(608, 162, 80, 22);
        jPanel3.add(PlaceCField);
        PlaceCField.setBounds(608, 190, 80, 22);

        jLabel31.setText("Color:");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(367, 83, 35, 16);

        jLabel32.setText("Plate:");
        jPanel3.add(jLabel32);
        jLabel32.setBounds(367, 55, 33, 16);

        jLabel33.setText("Company:");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(367, 111, 58, 16);

        jLabel34.setText("Fuel:");
        jPanel3.add(jLabel34);
        jLabel34.setBounds(370, 136, 29, 16);

        jLabel35.setText("GPS:");
        jPanel3.add(jLabel35);
        jLabel35.setBounds(560, 92, 28, 16);

        jLabel37.setText("Date:");
        jPanel3.add(jLabel37);
        jLabel37.setBounds(370, 161, 31, 16);

        jLabel44.setText("Price:");
        jPanel3.add(jLabel44);
        jLabel44.setBounds(370, 190, 33, 16);

        jLabel45.setText("People:");
        jPanel3.add(jLabel45);
        jLabel45.setBounds(553, 165, 43, 16);

        jLabel46.setText("Place:");
        jPanel3.add(jLabel46);
        jLabel46.setBounds(555, 193, 35, 16);
        jPanel3.add(BrandCField);
        BrandCField.setBounds(434, 220, 80, 22);
        jPanel3.add(ModelCField);
        ModelCField.setBounds(608, 219, 80, 22);

        ModelCLabel.setText("Brand:");
        jPanel3.add(ModelCLabel);
        ModelCLabel.setBounds(370, 219, 38, 16);

        CarCLabel.setText("Model:");
        jPanel3.add(CarCLabel);
        CarCLabel.setBounds(555, 222, 39, 16);

        FuelCComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fuel", "Electric", "Hybrid", "Hydrogen", " " }));
        jPanel3.add(FuelCComboBox);
        FuelCComboBox.setBounds(434, 136, 81, 22);

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setOpaque(true);
        jPanel3.add(jLabel55);
        jLabel55.setBounds(0, 0, 750, 390);

        jTabbedPane1.addTab("Cars", new javax.swing.ImageIcon(getClass().getResource("/icons/coche.png")), jPanel3); // NOI18N

        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel36.setText("Safe Company:");
        jPanel4.add(jLabel36);
        jLabel36.setBounds(10, 16, 88, 16);

        SearchCompanySField.setToolTipText("");
        SearchCompanySField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchCompanySFieldKeyReleased(evt);
            }
        });
        jPanel4.add(SearchCompanySField);
        SearchCompanySField.setBounds(105, 11, 70, 24);

        CompanySList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CompanySListValueChanged(evt);
            }
        });
        contactList3.setViewportView(CompanySList);

        jPanel4.add(contactList3);
        contactList3.setBounds(10, 41, 192, 236);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel4.add(jLabel38);
        jLabel38.setBounds(185, 11, 16, 24);

        jLabel39.setText("Package:");
        jPanel4.add(jLabel39);
        jLabel39.setBounds(211, 16, 52, 16);

        SearchPackageSField.setEnabled(false);
        SearchPackageSField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPackageSFieldKeyReleased(evt);
            }
        });
        jPanel4.add(SearchPackageSField);
        SearchPackageSField.setBounds(270, 10, 70, 24);

        PackageSList.setEnabled(false);
        PackageSList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                PackageSListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(PackageSList);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(212, 41, 151, 236);

        EditeSButton.setText("Edite");
        EditeSButton.setEnabled(false);
        EditeSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditeSButtonActionPerformed(evt);
            }
        });
        jPanel4.add(EditeSButton);
        EditeSButton.setBounds(200, 288, 103, 25);

        DeleteSButton.setText("Delete");
        DeleteSButton.setEnabled(false);
        DeleteSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSButtonActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteSButton);
        DeleteSButton.setBounds(200, 317, 103, 25);

        AddSButton.setText("Add");
        AddSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSButtonActionPerformed(evt);
            }
        });
        jPanel4.add(AddSButton);
        AddSButton.setBounds(309, 288, 103, 25);

        SaveSButton.setText("Save");
        SaveSButton.setEnabled(false);
        SaveSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveSButtonActionPerformed(evt);
            }
        });
        jPanel4.add(SaveSButton);
        SaveSButton.setBounds(309, 317, 103, 25);

        CancelSButton.setText("Cancel");
        CancelSButton.setEnabled(false);
        CancelSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelSButtonActionPerformed(evt);
            }
        });
        jPanel4.add(CancelSButton);
        CancelSButton.setBounds(418, 288, 103, 25);

        Log_outButton.setText("Log out");
        Log_outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_outButtonActionPerformed(evt);
            }
        });
        jPanel4.add(Log_outButton);
        Log_outButton.setBounds(418, 317, 103, 25);

        jLabel40.setText("Num");
        jPanel4.add(jLabel40);
        jLabel40.setBounds(381, 79, 50, 30);

        AssistanceSField.setEnabled(false);
        jPanel4.add(AssistanceSField);
        AssistanceSField.setBounds(439, 92, 80, 22);

        jLabel47.setText("Price:");
        jPanel4.add(jLabel47);
        jLabel47.setBounds(380, 120, 33, 16);

        PriceSField.setEnabled(false);
        jPanel4.add(PriceSField);
        PriceSField.setBounds(440, 120, 80, 22);

        ModelCLabel1.setText("People:");
        jPanel4.add(ModelCLabel1);
        ModelCLabel1.setBounds(380, 150, 40, 16);

        jLabel48.setText("Region:");
        jPanel4.add(jLabel48);
        jLabel48.setBounds(380, 180, 40, 16);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel4.add(jLabel41);
        jLabel41.setBounds(347, 11, 16, 24);

        jLabel43.setText("Coverage:");
        jPanel4.add(jLabel43);
        jLabel43.setBounds(529, 95, 59, 16);

        Box1.setBackground(new java.awt.Color(255, 255, 255));
        Box1.setText("Accidental Dead");
        jPanel4.add(Box1);
        Box1.setBounds(540, 120, 130, 25);

        Box2.setBackground(new java.awt.Color(255, 255, 255));
        Box2.setText("Animal Bite");
        jPanel4.add(Box2);
        Box2.setBounds(540, 140, 89, 25);

        Box3.setBackground(new java.awt.Color(255, 255, 255));
        Box3.setText("Insect Bite");
        jPanel4.add(Box3);
        Box3.setBounds(540, 160, 85, 25);

        Box4.setBackground(new java.awt.Color(255, 255, 255));
        Box4.setText("Tropical Diseases");
        Box4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4ActionPerformed(evt);
            }
        });
        jPanel4.add(Box4);
        Box4.setBounds(540, 180, 130, 25);

        Box5.setBackground(new java.awt.Color(255, 255, 255));
        Box5.setText("Murdered");
        jPanel4.add(Box5);
        Box5.setBounds(540, 200, 81, 25);

        Box6.setBackground(new java.awt.Color(255, 255, 255));
        Box6.setText("Luggage");
        Box6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6ActionPerformed(evt);
            }
        });
        jPanel4.add(Box6);
        Box6.setBounds(540, 220, 73, 25);

        jLabel4.setText("Assistance:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(380, 100, 60, 16);

        PeopleSSlider.setBackground(new java.awt.Color(255, 255, 255));
        PeopleSSlider.setMaximum(12);
        PeopleSSlider.setMinimum(1);
        PeopleSSlider.setValue(6);
        PeopleSSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PeopleSSliderStateChanged(evt);
            }
        });
        jPanel4.add(PeopleSSlider);
        PeopleSSlider.setBounds(440, 150, 80, 26);

        RegionSComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentine", "Aruba", "Bahamas ", "Bonaire", "Brazil", "Chile", "France", "Germany", "Miami", "South Africa", "Spain", "United Kingdom", "United States" }));
        jPanel4.add(RegionSComboBox);
        RegionSComboBox.setBounds(440, 180, 80, 22);

        jLabel42.setText("6");
        jPanel4.add(jLabel42);
        jLabel42.setBounds(520, 150, 20, 16);

        CompanySLabel.setText("Company:");
        jPanel4.add(CompanySLabel);
        CompanySLabel.setBounds(380, 60, 58, 16);

        CompanySField.setEnabled(false);
        jPanel4.add(CompanySField);
        CompanySField.setBounds(440, 60, 80, 22);

        PackageSLabel.setText("Package:");
        jPanel4.add(PackageSLabel);
        PackageSLabel.setBounds(540, 60, 50, 16);

        PackageSField.setEnabled(false);
        jPanel4.add(PackageSField);
        PackageSField.setBounds(590, 60, 80, 22);

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setOpaque(true);
        jPanel4.add(jLabel57);
        jLabel57.setBounds(0, 0, 750, 390);

        jTabbedPane1.addTab("Insurance", new javax.swing.ImageIcon(getClass().getResource("/icons/hospital.png")), jPanel4); // NOI18N

        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });
        jPanel5.setLayout(null);

        PriceTField.setEditable(false);
        jPanel5.add(PriceTField);
        PriceTField.setBounds(569, 166, 80, 22);

        SearchTField.setToolTipText("");
        SearchTField.setEnabled(false);
        SearchTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTFieldKeyReleased(evt);
            }
        });
        jPanel5.add(SearchTField);
        SearchTField.setBounds(108, 11, 172, 24);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel5.add(jLabel49);
        jLabel49.setBounds(285, 11, 16, 24);

        TransferList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransferList1ValueChanged(evt);
            }
        });
        contactList4.setViewportView(TransferList1);

        jPanel5.add(contactList4);
        contactList4.setBounds(108, 41, 192, 236);

        jLabel50.setText("People capacity:");
        jPanel5.add(jLabel50);
        jLabel50.setBounds(464, 81, 93, 16);

        EditeTButton.setText("Edite");
        EditeTButton.setEnabled(false);
        EditeTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditeTButtonActionPerformed(evt);
            }
        });
        EditeTButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditeTButtonKeyReleased(evt);
            }
        });
        jPanel5.add(EditeTButton);
        EditeTButton.setBounds(228, 288, 103, 25);

        jLabel52.setText("Bag capacity:");
        jPanel5.add(jLabel52);
        jLabel52.setBounds(464, 109, 76, 16);

        jLabel53.setText("Company:");
        jPanel5.add(jLabel53);
        jLabel53.setBounds(464, 140, 58, 16);

        SaveTButton.setText("Save");
        SaveTButton.setEnabled(false);
        SaveTButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SaveTButtonMouseReleased(evt);
            }
        });
        SaveTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTButtonActionPerformed(evt);
            }
        });
        jPanel5.add(SaveTButton);
        SaveTButton.setBounds(228, 319, 103, 25);

        CancelTButton.setText("Cancel");
        CancelTButton.setEnabled(false);
        CancelTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelTButtonActionPerformed(evt);
            }
        });
        jPanel5.add(CancelTButton);
        CancelTButton.setBounds(338, 288, 103, 25);

        Log_outTButton.setText("Log out");
        Log_outTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_outTButtonActionPerformed(evt);
            }
        });
        jPanel5.add(Log_outTButton);
        Log_outTButton.setBounds(337, 319, 103, 25);

        TransferList2.setEnabled(false);
        TransferList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TransferList2KeyReleased(evt);
            }
        });
        TransferList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransferList2ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(TransferList2);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(310, 41, 131, 236);

        SearchTField2.setEnabled(false);
        SearchTField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTField2KeyReleased(evt);
            }
        });
        jPanel5.add(SearchTField2);
        SearchTField2.setBounds(313, 11, 106, 24);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        jPanel5.add(jLabel56);
        jLabel56.setBounds(424, 11, 16, 24);

        PCapTField.setEditable(false);
        jPanel5.add(PCapTField);
        PCapTField.setBounds(569, 78, 80, 22);

        BCapTField.setEditable(false);
        jPanel5.add(BCapTField);
        BCapTField.setBounds(569, 106, 80, 22);

        jLabel59.setText("Price:");
        jPanel5.add(jLabel59);
        jLabel59.setBounds(464, 169, 33, 16);

        HotelsTOption.setText("Hotels");
        HotelsTOption.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                HotelsTOptionStateChanged(evt);
            }
        });
        HotelsTOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotelsTOptionActionPerformed(evt);
            }
        });
        HotelsTOption.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                HotelsTOptionPropertyChange(evt);
            }
        });
        jPanel5.add(HotelsTOption);
        HotelsTOption.setBounds(19, 118, 61, 25);

        AirportsTOption.setText("Airports");
        AirportsTOption.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AirportsTOptionStateChanged(evt);
            }
        });
        AirportsTOption.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                AirportsTOptionPropertyChange(evt);
            }
        });
        jPanel5.add(AirportsTOption);
        AirportsTOption.setBounds(19, 161, 71, 25);

        CompanyTField.setEditable(false);
        jPanel5.add(CompanyTField);
        CompanyTField.setBounds(569, 137, 80, 22);

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setOpaque(true);
        jPanel5.add(jLabel58);
        jLabel58.setBounds(0, 0, 750, 390);

        jTabbedPane1.addTab("Transfers", new javax.swing.ImageIcon(getClass().getResource("/icons/taxi.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        HotelJList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                HotelJList1ValueChanged(evt);
            }
        });
        contactList5.setViewportView(HotelJList1);

        jPanel6.add(contactList5);
        contactList5.setBounds(70, 50, 202, 261);

        editeH1.setText("Edite");
        editeH1.setEnabled(false);
        editeH1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                editeH1ComponentShown(evt);
            }
        });
        editeH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editeH1ActionPerformed(evt);
            }
        });
        jPanel6.add(editeH1);
        editeH1.setBounds(340, 260, 103, 25);

        hotelSave1.setText("Save");
        hotelSave1.setEnabled(false);
        hotelSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelSave1ActionPerformed(evt);
            }
        });
        jPanel6.add(hotelSave1);
        hotelSave1.setBounds(340, 290, 103, 25);

        LogOut2.setText("Log out");
        LogOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOut2ActionPerformed(evt);
            }
        });
        jPanel6.add(LogOut2);
        LogOut2.setBounds(450, 290, 103, 25);

        CancelHotel1.setText("Cancel");
        CancelHotel1.setEnabled(false);
        CancelHotel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelHotel1ActionPerformed(evt);
            }
        });
        jPanel6.add(CancelHotel1);
        CancelHotel1.setBounds(450, 260, 103, 25);

        jLabel60.setText("Users:");
        jPanel6.add(jLabel60);
        jLabel60.setBounds(70, 30, 37, 16);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Admin");
        jCheckBox1.setEnabled(false);
        jCheckBox1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jCheckBox1ComponentShown(evt);
            }
        });
        jPanel6.add(jCheckBox1);
        jCheckBox1.setBounds(340, 130, 61, 25);

        jTabbedPane1.addTab("User", new javax.swing.ImageIcon(getClass().getResource("/icons/comprobado.png")), jPanel6); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultListModel Model$ = new DefaultListModel();
        for(User It: main.Users.values()){
            Model$.addElement(It.getUser());
        }
        HotelJList1.setModel(Model$);
        InsuranceGenerate();
        TransferGenerate();
        EditeCButton.setEnabled(false);
        buttonGroup1.add(HotelsTOption);
        buttonGroup1.add(AirportsTOption);
        CompanySLabel.setVisible(false);
        CompanySField.setVisible(false);
        PackageSField.setVisible(false);
        PackageSLabel.setVisible(false);
        this.setLocationRelativeTo(null);
        HotelJList.setModel(main.HotelList());
        AirlineJList.setModel(main.AirlineList());
        FliesJList.setModel(main.FliesList());
        NameFLabel.setVisible(false);
        AirlineFLabel.setVisible(false);
        NameFField.setVisible(false);
        AirlineFField.setVisible(false);
        ModelCList.setModel(main.ModelList());
        CompanySList.setModel(main.CompanySafeList());
        UpdateCarModel();
        EDCComponent(false); 
        EDSComponent(false);
    }//GEN-LAST:event_formComponentShown

    private void PeopleSSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PeopleSSliderStateChanged
        // TODO add your handling code here:
        jLabel42.setText(""+PeopleSSlider.getValue());
    }//GEN-LAST:event_PeopleSSliderStateChanged

    private void Box6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box6ActionPerformed

    private void Box4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box4ActionPerformed

    private void Log_outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_outButtonActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_Log_outButtonActionPerformed

    private void CancelSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelSButtonActionPerformed
        // TODO add your handling code here:
        CompanySList.setEnabled(true);
        PackageSList.setModel(new DefaultListModel());
        EditeSButton.setEnabled(false);
        DeleteSButton.setEnabled(false);
        EDSComponent(false);
        ClearSFields();
    }//GEN-LAST:event_CancelSButtonActionPerformed

    private void SaveSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveSButtonActionPerformed
        // TODO add your handling code here:
        if(CompanySField.getText().length() == 0 && PackageSField.getText().length() == 0
            && AssistanceSField.getText().length() == 0 && PriceSField.getText().length()== 0){
            JOptionPane.showMessageDialog(rootPane, "A field is empty", "Error", HEIGHT);
        }else{
            boolean[] Checks = new boolean[6];
            Checks[0] = Box1.isSelected();
            Checks[1] = Box2.isSelected();
            Checks[2] = Box3.isSelected();
            Checks[3] = Box4.isSelected();
            Checks[4] = Box5.isSelected();
            Checks[5] = Box6.isSelected();
            Safe SafeToAdd = new Safe(CompanySField.getText(), Checks, AssistanceSField.getText(),
                PackageSField.getText(), " ", PriceSField.getText(), ""+PeopleSSlider.getValue(),
                (String)RegionSComboBox.getSelectedItem());
            if(AddSafe){
                main.Safes.put((main.Safes.size()), SafeToAdd);
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    SSave();
                }
            }else{
                int AuxKey = 0;
                for(Safe It : main.Safes.values()){
                    if(It.getSafeCompany().equals(CompanySList.getSelectedValue()) && It.getName().equals(PackageSList.getSelectedValue())){
                        break;
                    }
                    AuxKey++;
                }
                main.Safes.replace(AuxKey, SafeToAdd);
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    SSave();
                }
            }
        }
        CarCList.setModel(new DefaultListModel());
    }//GEN-LAST:event_SaveSButtonActionPerformed

    private void AddSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSButtonActionPerformed
        // TODO add your handling code here:
        EDSComponent(true);
        ClearSFields();
        EditeSButton.setEnabled(false);
        DeleteSButton.setEnabled(false);
        AddSafe = true;
    }//GEN-LAST:event_AddSButtonActionPerformed

    private void DeleteSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSButtonActionPerformed
        // TODO add your handling code here:
        int Answer = JOptionPane.showConfirmDialog(rootPane, "Sure?", "Delete?", JOptionPane.YES_NO_OPTION), AuxKey = 0,
        KeyToRemove = -1;
        boolean RemoveK = false;
        if(Answer == 0){
            for(Safe It : main.Safes.values()){
                if (It.getName().equals(PackageSList.getSelectedValue())
                    && It.getSafeCompany().equals(CompanySList.getSelectedValue())){
                    RemoveK = true;
                    KeyToRemove = AuxKey;
                    break;
                }
                AuxKey++;
            }
            if(RemoveK){
                try{
                    main.Safes.remove(KeyToRemove);
                }catch(Exception ex){ }
                HashMap<Integer,Safe> Aux = main.Safes;
                main.Safes = new HashMap <>();
                int DeleteKeyC = 0;
                for(Safe It : Aux.values()){
                    main.Safes.put(DeleteKeyC++, It);
                }
                SSave();
            }
        }
        CarCList.setEnabled(false);
        CarCList.setModel(new DefaultListModel());
    }//GEN-LAST:event_DeleteSButtonActionPerformed

    private void EditeSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditeSButtonActionPerformed
        // TODO add your handling code here:
        EDSComponent(true);
        CompanySList.setEnabled(false);
        PackageSList.setEnabled(false);
        EditeSButton.setEnabled(false);
        DeleteSButton.setEnabled(false);
        AddSafe = false;
    }//GEN-LAST:event_EditeSButtonActionPerformed

    private void PackageSListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_PackageSListValueChanged
        // TODO add your handling code here:
        EditeSButton.setEnabled(true);
        DeleteSButton.setEnabled(true);
        for(Safe It : main.Safes.values()){
            if(It.getName().equals(PackageSList.getSelectedValue())
                && It.getSafeCompany().equals(CompanySList.getSelectedValue())){
                CompanySField.setText(It.getSafeCompany());
                PackageSField.setText(It.getName());
                PriceSField.setText(It.getPrice());
                AssistanceSField.setText(It.getAssistance());
                PeopleSSlider.setValue(Integer.parseInt(It.getPeople()));
                RegionSComboBox.setSelectedItem(It.getPlace());
                Box1.setSelected(It.getCoverage()[0]);
                Box2.setSelected(It.getCoverage()[1]);
                Box3.setSelected(It.getCoverage()[2]);
                Box4.setSelected(It.getCoverage()[3]);
                Box5.setSelected(It.getCoverage()[4]);
                Box6.setSelected(It.getCoverage()[5]);
            }
        }
    }//GEN-LAST:event_PackageSListValueChanged

    private void SearchPackageSFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPackageSFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPackageSFieldKeyReleased

    private void CompanySListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CompanySListValueChanged
        // TODO add your handling code here:
        if(AuxMod++%2==0){
            ClearSFields();
            DefaultListModel Model$ = new DefaultListModel();
            //int Key$ = 0;
            for(Safe It : main.Safes.values()){
                if(It.getSafeCompany().equals((String)CompanySList.getSelectedValue())){
                    Model$.addElement(It.getName());
                    //main.CompanySafe.put(Key$++, It.getSafeCompany());
                }
            }
            PackageSList.setModel(Model$);
            PackageSList.setEnabled(true);
        }
    }//GEN-LAST:event_CompanySListValueChanged

    private void SearchCompanySFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchCompanySFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCompanySFieldKeyReleased

    private void SearchCarCFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchCarCFieldKeyReleased
        // TODO add your handling code here:
        CarSearch();
    }//GEN-LAST:event_SearchCarCFieldKeyReleased

    private void CarCListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CarCListValueChanged
        // TODO add your handling code here:
        EditeCButton.setEnabled(true);
        DeleteCButton.setEnabled(true);
        for(Car CarIt : main.Cars.values()){
            if(CarIt.getModel().equals(ModelCList.getSelectedValue())
                && CarIt.getName().equals(CarCList.getSelectedValue())){
                PlateCField.setText(CarIt.getPlate());
                ColorCComboBox.setSelectedItem(CarIt.getColor());
                GpsCCheckBox.setSelected(CarIt.isGps());
                CompanyCField.setText(CarIt.getCompany());
                FuelCComboBox.setSelectedItem(CarIt.getFuel());
                ModelCField.setText(CarIt.getName());
                DateCField.setText(CarIt.getDate());
                PeopleCField.setText(CarIt.getPeople());
                PriceCField.setText(CarIt.getPrice());
                PlaceCField.setText(CarIt.getPlace());
                BrandCField.setText(CarIt.getModel());
                ModelCField.setText(CarCList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_CarCListValueChanged

    private void Log_outCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_outCButtonActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_Log_outCButtonActionPerformed

    private void CancelCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelCButtonActionPerformed
        // TODO add your handling code here:
        EDCComponent(false);
    }//GEN-LAST:event_CancelCButtonActionPerformed

    private void SaveCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveCButtonActionPerformed
        // TODO add your handling code here:
        if(PlateCField.getText().length() == 0 || CompanyCField.getText().length() == 0
            || PlaceCField.getText().length() == 0 || DateCField.getText().length() == 0
            || PeopleCField.getText().length() == 0 || PriceCField.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "A field is empty", "Error", HEIGHT);
        }else{
            Car CarToAdd = new Car(PlateCField.getText(), BrandCField.getText(),
                (String)ColorCComboBox.getSelectedItem(), CompanyCField.getText(),
                ((String)FuelCComboBox.getSelectedItem()),GpsCCheckBox.isSelected(),ModelCField.getText(),
                DateCField.getText(),PriceCField.getText(),PeopleCField.getText(),PlaceCField.getText());
            if(AddCar){
                main.Cars.put((main.Cars.size()), CarToAdd);
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    CSave();
                }
            }else{
                int AuxKey = 0;
                for(Car ItCar : main.Cars.values()){
                    if(ItCar.getModel().equals(ModelCList.getSelectedValue()) && ItCar.getName().equals(CarCList.getSelectedValue())){
                        break;
                    }
                    AuxKey++;
                }
                main.Cars.replace(AuxKey, CarToAdd);
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    CSave();
                }
            }
        }
        CarCList.setModel(new DefaultListModel());
    }//GEN-LAST:event_SaveCButtonActionPerformed

    private void AddCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCButtonActionPerformed
        // TODO add your handling code here:.
        EDCComponent(true);
        ClearCFields();
        AddCar = true;
        EditeCButton.setEnabled(false);
        CarCList.setEnabled(false);
        ModelCList.setEnabled(false);
        DeleteCButton.setEnabled(false);
    }//GEN-LAST:event_AddCButtonActionPerformed

    private void DeleteCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCButtonActionPerformed
        // TODO add your handling code here:
        int Answer = JOptionPane.showConfirmDialog(rootPane, "Sure?", "Delete?", JOptionPane.YES_NO_OPTION), AuxKey = 0,
        KeyToRemove = -1;
        boolean RemoveK = false;
        if(Answer == 0){
            for(Car CarIt : main.Cars.values()){
                if (CarIt.getName().equals(CarCList.getSelectedValue())
                    && CarIt.getModel().equals(ModelCList.getSelectedValue())){
                    RemoveK = true;
                    KeyToRemove = AuxKey;
                    break;
                }
                AuxKey++;
            }
            if(RemoveK){
                try{
                    main.Cars.remove(KeyToRemove);
                }catch(Exception ex){ }
                HashMap<Integer,Car> Aux = main.Cars;
                main.Cars = new HashMap <>();
                int DeleteKeyC = 0;
                for(Car CarIt : Aux.values()){
                    main.Cars.put(DeleteKeyC++, CarIt);
                }
                CSave();
            }
        }
        CarCList.setEnabled(false);
        CarCList.setModel(new DefaultListModel());
    }//GEN-LAST:event_DeleteCButtonActionPerformed

    private void EditeCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditeCButtonActionPerformed
        // TODO add your handling code here:
        EditeCButton.setEnabled(false);
        DeleteCButton.setEnabled(false);
        EDCComponent(true);
        AddCar = false;
    }//GEN-LAST:event_EditeCButtonActionPerformed

    private void ModelCListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ModelCListValueChanged
        // TODO add your handling code here:
        if(AuxMod++%2==0){
            UpdateCarModel();
            EditeCButton.setEnabled(false);
            DeleteCButton.setEnabled(false);
            ClearCFields();
            SearchCarCField.setEnabled(true);
        }
    }//GEN-LAST:event_ModelCListValueChanged

    private void SearchModelCFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchModelCFieldKeyReleased
        // TODO add your handling code here:
        ModelSearch();
    }//GEN-LAST:event_SearchModelCFieldKeyReleased

    private void LogOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOut1ActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_LogOut1ActionPerformed

    private void SearchFlyFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFlyFKeyReleased
        // TODO add your handling code here:
        FlySearch();
    }//GEN-LAST:event_SearchFlyFKeyReleased

    private void cancelFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFActionPerformed
        // TODO add your handling code here:
        AirlineJList.setEnabled(true);
        SearchFlyF.setEnabled(false);
        FliesJList.setEnabled(false);
        FliesJList.setModel(new DefaultListModel());
        DPlaceFField.setText("");
        DHourFField.setText("");
        APlaceFField.setText("");
        AHourFField.setText("");
        SeatsPriceFField.setText("");
        ExeFField.setText("");
        EcoFField.setText("");
        FirstFField.setText("");
        ScalesFField.setText("");
        DateFField.setText("");
        PeopleFField.setText("");
        NameFField.setText("");
        AirlineFField.setText("");
        DPlaceFField.setEditable(false);
        DHourFField.setEditable(false);
        APlaceFField.setEditable(false);
        AHourFField.setEditable(false);
        SeatsPriceFField.setEditable(false);
        ScalesFField.setEditable(false);
        DateFField.setEditable(false);
        PeopleFField.setEditable(false);
        FirstFField.setEditable(false);
        EcoFField.setEditable(false);
        ExeFField.setEditable(false);
        NameFLabel.setVisible(false);
        AirlineFLabel.setVisible(false);
        NameFField.setVisible(false);
        AirlineFField.setVisible(false);
        NameFField.setEditable(false);
        AirlineFField.setEditable(false);
        addF.setEnabled(true);
        editeF.setEnabled(false);
        cancelF.setEnabled(false);
        saveF.setEnabled(false);
        deleteF.setEnabled(false);
    }//GEN-LAST:event_cancelFActionPerformed

    private void FliesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_FliesJListValueChanged
        // TODO add your handling code here:
        if(FliesCont++%2==0){
            /*if(!Fly$){
                int indexAirline = AirlineJList.getSelectedIndex();
                String Airline = main.Airlines.get(indexAirline);
                int index =  FliesJList.getSelectedIndex();
                String Select = main.FliesList.get(index);
                for(Fly it : main.Flies.values()){
                    if (it.getName().equals(Select) && it.getAirline().equals(Airline)){
                        try{
                            DPlaceFField.setText(it.getDPlace());
                            DHourFField.setText(it.getDHour());
                            APlaceFField.setText(it.getAPlace());
                            AHourFField.setText(it.getAHour());
                            SeatsPriceFField.setText(it.getPrice());
                            ExeFField.setText(it.getExeClass());
                            EcoFField.setText(it.getEcoClass());
                            FirstFField.setText(it.getFirstClass());
                            ScalesFField.setText(it.getScales());
                            DateFField.setText(it.getDate());
                            PeopleFField.setText(it.getPeople());
                        }catch(Exception ex){
                            DPlaceFField.setText("");
                            DHourFField.setText("");
                            APlaceFField.setText("");
                            AHourFField.setText("");
                            SeatsPriceFField.setText("");
                            ExeFField.setText("");
                            EcoFField.setText("");
                            FirstFField.setText("");
                            ScalesFField.setText("");
                            DateFField.setText("");
                            PeopleFField.setText("");
                        }
                        break;
                    }else{
                        DPlaceFField.setText("");
                        DHourFField.setText("");
                        APlaceFField.setText("");
                        AHourFField.setText("");
                        SeatsPriceFField.setText("");
                        ExeFField.setText("");
                        EcoFField.setText("");
                        FirstFField.setText("");
                        ScalesFField.setText("");
                        DateFField.setText("");
                        PeopleFField.setText("");
                    }
                }
                editeF.setEnabled(true);
                deleteF.setEnabled(true);
            }else{*/
                String toSearch = FliesJList.getSelectedValue();
                String to$earch = (String) AirlineJList.getSelectedValue();
                for(Fly It : main.Flies.values()){
                    if(It.getAirline().equals(to$earch) && It.getName().equals(toSearch)){
                        DPlaceFField.setText(It.getDPlace());
                        DHourFField.setText(It.getDHour());
                        APlaceFField.setText(It.getAPlace());
                        AHourFField.setText(It.getAHour());
                        SeatsPriceFField.setText(It.getPrice());
                        ExeFField.setText(It.getExeClass());
                        EcoFField.setText(It.getEcoClass());
                        FirstFField.setText(It.getFirstClass());
                        ScalesFField.setText(It.getScales());
                        DateFField.setText(It.getDate());
                        PeopleFField.setText(It.getPeople());
                    }
                }
            editeF.setEnabled(true);
            deleteF.setEnabled(true);
                //}
        }
    }//GEN-LAST:event_FliesJListValueChanged

    private void saveFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFActionPerformed
        // TODO add your handling code here:
        HashMap Generic = new HashMap<>();
        if(AHourFField.getText().length() == 0 || APlaceFField.getText().length() == 0
            || DHourFField.getText().length() == 0 || DPlaceFField.getText().length() == 0
            || EcoFField.getText().length() == 0 || ExeFField.getText().length() == 0
            || FirstFField.getText().length() == 0 || NameFField.getText().length() == 0
            || AirlineFField.getText().length() == 0 || SeatsPriceFField.getText().length() == 0
            || ScalesFField.getText().length() == 0 || DateFField.getText().length() == 0
            || PeopleFField.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "A field is empty", "Error", HEIGHT);
        }else{
            if (AddFly){
                Fly Fly = new Fly(AHourFField.getText(), DHourFField.getText(),
                    FirstFField.getText(), ExeFField.getText(), EcoFField.getText(),
                    APlaceFField.getText(), DPlaceFField.getText(), AirlineFField.getText(),
                    ScalesFField.getText(), NameFField.getText(), DateFField.getText(),
                    SeatsPriceFField.getText(), PeopleFField.getText(), "Place");
                if(main.Flies.containsValue(Fly)){
                    JOptionPane.showMessageDialog(rootPane, "Alredy Exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    int FlyKey = main.Flies.size();
                    main.Flies.put(FlyKey++,Fly);
                    int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION){
                        FSave();
                    }
                }
            }else{
                int indexAirline = AirlineJList.getSelectedIndex();
                String Airline = main.Airlines.get(indexAirline);
                int index =  FliesJList.getSelectedIndex();
                String Select = main.FliesList.get(index);
                int key = 0;
                for(Fly it : main.Flies.values()){
                    if (it.getName().equals(Select) && it.getAirline().equals(Airline)){
                        Fly FlyGeneric = new Fly(AHourFField.getText(), DHourFField.getText(),
                            FirstFField.getText(), ExeFField.getText(), EcoFField.getText(),
                            APlaceFField.getText(), DPlaceFField.getText(), AirlineFField.getText(),
                            ScalesFField.getText(), NameFField.getText(), DateFField.getText(),
                            SeatsPriceFField.getText(), PeopleFField.getText(), "Place");
                        Generic.put(key++, FlyGeneric);
                    }else{
                        Generic.put(key++, it);
                    }
                }
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    main.Flies = Generic;
                    FSave();
                }
            }
        }
        FliesJList.setEnabled(false);
    }//GEN-LAST:event_saveFActionPerformed

    private void deleteFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFActionPerformed
        // TODO add your handling code here:
        int Answer = JOptionPane.showConfirmDialog(rootPane, "Sure?", "Delete?", JOptionPane.YES_NO_OPTION), AuxKey = 0,
        KeyToRemove = -1;
        boolean RemoveK = false;
        if(Answer == 0){
            for(Fly it : main.Flies.values()){
                if (it.getName().equals(main.FliesList.get(FliesJList.getSelectedIndex()))
                    && it.getAirline().equals(main.Airlines.get(AirlineJList.getSelectedIndex()))){
                    RemoveK = true;
                    KeyToRemove = AuxKey;
                }
                AuxKey++;
            }
            if(RemoveK){
                try{
                    main.Flies.remove(KeyToRemove);
                }catch(Exception ex){ }
                HashMap<Integer,Fly> Aux = main.Flies;
                main.Flies = new HashMap <>();
                for(Fly It : Aux.values()){
                    main.Flies.put(DeletekeyF++, It);
                }
                FSave();
            }
        }
        FliesJList.setEnabled(false);
        FliesJList.setModel(new DefaultListModel());
    }//GEN-LAST:event_deleteFActionPerformed

    private void addFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFActionPerformed
        // TODO add your handling code here:
        AirlineJList.setEnabled(false);
        FliesJList.setEnabled(false);
        DPlaceFField.setText("");
        DHourFField.setText("");
        APlaceFField.setText("");
        AHourFField.setText("");
        SeatsPriceFField.setText("");
        ExeFField.setText("");
        EcoFField.setText("");
        FirstFField.setText("");
        ScalesFField.setText("");
        DateFField.setText("");
        PeopleFField.setText("");
        NameFField.setText("");
        AirlineFField.setText("");
        DPlaceFField.setEditable(true);
        DHourFField.setEditable(true);
        APlaceFField.setEditable(true);
        AHourFField.setEditable(true);
        SeatsPriceFField.setEditable(true);
        ScalesFField.setEditable(true);
        DateFField.setEditable(true);
        PeopleFField.setEditable(true);
        FirstFField.setEditable(true);
        EcoFField.setEditable(true);
        ExeFField.setEditable(true);
        NameFLabel.setVisible(true);
        NameFField.setVisible(true);
        NameFField.setEditable(true);
        AirlineFLabel.setVisible(true);
        AirlineFField.setVisible(true);
        AirlineFField.setEditable(true);
        addF.setEnabled(false);
        editeF.setEnabled(false);
        cancelF.setEnabled(true);
        saveF.setEnabled(true);
        deleteF.setEnabled(false);
        AddFly = true;
    }//GEN-LAST:event_addFActionPerformed

    private void editeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editeFActionPerformed
        // TODO add your handling code here:
        AddFly = false;
        AirlineJList.setEnabled(false);
        FliesJList.setEnabled(false);
        DPlaceFField.setEditable(true);
        DHourFField.setEditable(true);
        APlaceFField.setEditable(true);
        AHourFField.setEditable(true);
        SeatsPriceFField.setEditable(true);
        ScalesFField.setEditable(true);
        DateFField.setEditable(true);
        PeopleFField.setEditable(true);
        FirstFField.setEditable(true);
        EcoFField.setEditable(true);
        ExeFField.setEditable(true);
        NameFLabel.setVisible(true);
        AirlineFLabel.setVisible(true);
        NameFField.setEditable(true);
        NameFField.setVisible(true);
        AirlineFField.setEditable(true);
        AirlineFField.setVisible(true);
        addF.setEnabled(false);
        editeF.setEnabled(false);
        cancelF.setEnabled(true);
        saveF.setEnabled(true);
        deleteF.setEnabled(false);
        SearchFlyF.setEnabled(false);
        int indexAirline = AirlineJList.getSelectedIndex();
        String Airline = main.Airlines.get(indexAirline);
        int index =  FliesJList.getSelectedIndex();
        String Select = main.FliesList.get(index);
        for(Fly it : main.Flies.values()){
            if (it.getName().equals(Select) && it.getAirline().equals(Airline)){
                NameFField.setText(it.getName());
                AirlineFField.setText(it.getAirline());
            }
        }
    }//GEN-LAST:event_editeFActionPerformed

    private void AirlineJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AirlineJListValueChanged
        // TODO add your handling code here:
        if(AirlineCont++%2==0){
            main.FliesList = new HashMap<>();
            /*if (!AirlineSearch$){
                main.FliesList = new HashMap <>();
                int index =  AirlineJList.getSelectedIndex();
                String Select = main.Airlines.get(index);
                for(Fly it : main.Flies.values()){
                    if(it.getAirline().equals(Select)){
                        main.FliesList.put(ContAirline++, it.getName());
                    }
                }
                ContAirline = 0;
                FliesJList.setModel(main.FliesList());
                FliesJList.setEnabled(true);
                DPlaceFField.setText("");
                DHourFField.setText("");
                APlaceFField.setText("");
                AHourFField.setText("");
                SeatsPriceFField.setText("");
                editeF.setEnabled(false);
                deleteF.setEnabled(false);
                ScalesFField.setText("");
                DateFField.setText("");
                PeopleFField.setText("");
                FirstFField.setText("");
                EcoFField.setText("");
                ExeFField.setText("");
            }else{*/
                SearchFlyF.setEnabled(true);
                int key = 0;
                for(String It: main.Airlines.values()){
                    String ToSeach = (String)AirlineJList.getSelectedValue();
                    String ToCompare = It;
                    try {
                        if(ToSeach.equals(ToCompare)){
                            for (Fly It2: main.Flies.values()){
                                if((ToCompare.equals(It2.getAirline()))){
                                    main.FliesList.put(key++, It2.getName());
                                }
                            }
                        }    
                    }catch(Exception ex){
                        AirlineJList.setSelectedIndex(0);
                    }
                    FliesJList.setModel(main.FliesList());
                    FliesJList.setEnabled(true);
                    DPlaceFField.setText("");
                    DHourFField.setText("");
                    APlaceFField.setText("");
                    AHourFField.setText("");
                    SeatsPriceFField.setText("");
                    editeF.setEnabled(false);
                    deleteF.setEnabled(false);
                    ScalesFField.setText("");
                    DateFField.setText("");
                    PeopleFField.setText("");
                    FirstFField.setText("");
                    EcoFField.setText("");
                    ExeFField.setText("");
                }
                //}
        }
    }//GEN-LAST:event_AirlineJListValueChanged

    private void SearchAirlineFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAirlineFKeyReleased
        // TODO add your handling code here:
        AirlineSearch();
        //AirlineSearch$ = true;
    }//GEN-LAST:event_SearchAirlineFKeyReleased

//</editor-fold>
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_LogOutActionPerformed

    private void CancelHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelHotelActionPerformed
        // TODO add your handling code here:
        HotelJList.setEnabled(true);
        HotelNameField.setText("");
        HotelNameField.setText("");
        HotelStarsField.setText("");
        HotelLocationField.setText("");
        RoomPriceField.setText("");
        HotelSuiteField.setText("");
        HotelMatrimonialField.setText("");
        HotelDoubleField.setText("");
        HotelSimpleField.setText("");
        HotelPlaceField.setText("");
        CancelHotel.setEnabled(false);
        hotelSave.setEnabled(false);
        HotelJList.setModel(main.HotelList());
        HotelNameField.setEditable(false);
        HotelStarsField.setEditable(false);
        HotelLocationField.setEditable(false);
        RoomPriceField.setEditable(false);
        HotelSuiteField.setEditable(false);
        HotelMatrimonialField.setEditable(false);
        HotelDoubleField.setEditable(false);
        HotelSimpleField.setEditable(false);
        HotelPlaceField.setEditable(false);
        addH.setEnabled(true);
        editeH.setEnabled(true);
        deleteH.setEnabled(true);
    }//GEN-LAST:event_CancelHotelActionPerformed

    private void hotelSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelSaveActionPerformed
        // TODO add your handling code here:
        if(HotelNameField.getText().length() == 0 || HotelLocationField.getText().length() == 0
            || HotelStarsField.getText().length() == 0 || HotelSuiteField.getText().length() == 0
            || HotelMatrimonialField.getText().length() == 0 || HotelDoubleField.getText().length() == 0
            || HotelSimpleField.getText().length() == 0 || RoomPriceField.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "A field is empty", "Error", HEIGHT);
        }else{
            if (AddHotel){
                Hotel AddAHotel = new Hotel(HotelSuiteField.getText(),
                    HotelMatrimonialField.getText(), HotelDoubleField.getText(), HotelSimpleField.getText(),
                    HotelStarsField.getText(), HotelLocationField.getText(), HotelNameField.getText()," ",
                    RoomPriceField.getText()," ",HotelPlaceField.getText());
                HotelKey = main.Hotels.size();
                HotelKey++;
                main.Hotels.put(HotelKey,AddAHotel);
                int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    Hsave();
                }
            }else{
                main.Hotels.replace(HotelJList.getSelectedIndex(), new Hotel(HotelSuiteField.getText(),
                    HotelMatrimonialField.getText(), HotelDoubleField.getText(), HotelSimpleField.getText(),
                    HotelStarsField.getText(), HotelLocationField.getText(), HotelNameField.getText()," ",
                    RoomPriceField.getText()," ",HotelPlaceField.getText()));
            int option = JOptionPane.showConfirmDialog(rootPane,"Save changes?", "Save",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                Hsave();
            }
        }
        }
    }//GEN-LAST:event_hotelSaveActionPerformed

    private void deleteHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHActionPerformed
        // TODO add your handling code here:
        int Answer = JOptionPane.showConfirmDialog(rootPane, "Sure?", "Delete?", JOptionPane.YES_NO_OPTION);
        if(Answer == 0){
            int Cont = 0;
            main.Hotels.remove(HotelJList.getSelectedIndex());
            HashMap<Integer,Hotel> Aux = main.Hotels;
            main.Hotels = new HashMap<>();
            for(Hotel It : Aux.values()){
                main.Hotels.put(Cont++, It);
            }
            HotelJList.setModel(main.HotelList());
            Hsave();
        }

    }//GEN-LAST:event_deleteHActionPerformed

    private void addHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHActionPerformed
        // TODO add your handling code here:
        HotelNameField.setEditable(true);
        HotelStarsField.setEditable(true);
        HotelLocationField.setEditable(true);
        RoomPriceField.setEditable(true);
        HotelSuiteField.setEditable(true);
        HotelMatrimonialField.setEditable(true);
        HotelDoubleField.setEditable(true);
        HotelSimpleField.setEditable(true);
        HotelPlaceField.setEditable(true);
        addH.setEnabled(false);
        hotelSave.setEnabled(true);
        AddHotel = true;
        HotelNameField.setText("");
        HotelJList.setEnabled(false);
        HotelNameField.setText("");
        HotelStarsField.setText("");
        HotelLocationField.setText("");
        RoomPriceField.setText("");
        HotelSuiteField.setText("");
        HotelMatrimonialField.setText("");
        HotelDoubleField.setText("");
        HotelSimpleField.setText("");
        HotelPlaceField.setText("");
        CancelHotel.setEnabled(true);
        editeH.setEnabled(false);
        deleteH.setEnabled(false);

    }//GEN-LAST:event_addHActionPerformed

    private void editeHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editeHActionPerformed
        // TODO add your handling code here:
        HotelNameField.setEditable(true);
        HotelStarsField.setEditable(true);
        HotelLocationField.setEditable(true);
        RoomPriceField.setEditable(true);
        HotelSuiteField.setEditable(true);
        HotelMatrimonialField.setEditable(true);
        HotelDoubleField.setEditable(true);
        HotelSimpleField.setEditable(true);
        HotelPlaceField.setEditable(true);
        addH.setEnabled(false);
        hotelSave.setEnabled(true);
        AddHotel = false;
        HotelJList.setEnabled(false);

    }//GEN-LAST:event_editeHActionPerformed

    private void HotelJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_HotelJListValueChanged
        // TODO add your handling code here:
        editeH.setEnabled(true);
        deleteH.setEnabled(true);
        if(HotelJList.isEnabled()){
            if(HotelKey++%2==0){
                /*if(!Search$){
                    Hotel llenar = (Hotel) main.Hotels.get(HotelJList.getSelectedIndex());
                    try{
                        HotelNameField.setText(llenar.getName());
                        HotelStarsField.setText(llenar.getStars());
                        HotelLocationField.setText(llenar.getLocation());
                        HotelDoubleField.setText(llenar.getDoubleRooms());
                        HotelMatrimonialField.setText(llenar.getMatrimonialRooms());
                        HotelSuiteField.setText(llenar.getSuiteRooms());
                        HotelSimpleField.setText(llenar.getSimpleRooms());
                        HotelPlaceField.setText(llenar.getPlace());
                        RoomPriceField.setText(llenar.getPrice());
                    }catch(Exception ex){
                        HotelNameField.setText("");
                        HotelStarsField.setText("");
                        HotelLocationField.setText("");
                        HotelDoubleField.setText("");
                        HotelMatrimonialField.setText("");
                        HotelSuiteField.setText("");
                        HotelSimpleField.setText("");
                        HotelPlaceField.setText("");
                        RoomPriceField.setText("");
                    }
                }else{*/
                    for(Hotel It : main.Hotels.values()){
                        String ForSearch = It.getName() + " - " + It.getPlace() + " - " + It.getStars();
                        String ToCompare = (String)HotelJList.getSelectedValue();
                        if(ForSearch.equals(ToCompare)){
                            HotelNameField.setText(It.getName());
                            HotelStarsField.setText(It.getStars());
                            HotelLocationField.setText(It.getLocation());
                            HotelDoubleField.setText(It.getDoubleRooms());
                            HotelMatrimonialField.setText(It.getMatrimonialRooms());
                            HotelSuiteField.setText(It.getSuiteRooms());
                            HotelSimpleField.setText(It.getSimpleRooms());
                            HotelPlaceField.setText(It.getPlace());
                            RoomPriceField.setText(It.getPrice());
                        }
                    }
                    //}
            }
        }
    }//GEN-LAST:event_HotelJListValueChanged

    private void searchHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchHKeyReleased
        // TODO add your handling code here:
        HSearch();
    }//GEN-LAST:event_searchHKeyReleased

    private void searchHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchHActionPerformed

    private void SearchTFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTFieldKeyReleased
        // TODO add your handling code here:
        TSearch1();
    }//GEN-LAST:event_SearchTFieldKeyReleased

    private void TransferList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransferList1ValueChanged
        // TODO add your handling code here:
        try{
            SearchTField2.setEnabled(true);
            String ToSearch = (String)TransferList1.getSelectedValue();
            int Comma = 0;
            for(int i = 0; i<ToSearch.length(); i++){
                if(ToSearch.charAt(i) == ','){
                    Comma = i;
                    break;
                }
            }
            String Country = ToSearch.substring(0, Comma);
            if(HotelAirport){
                DefaultListModel $Model = new DefaultListModel();
                for(String It : main.Airports.values()){
                    int Comma$ = 0;
                    for(int i = 0; i<It.length(); i++){
                        if(It.charAt(i) == ','){
                            Comma$ = i;
                            break;
                        }
                    }
                    String Aux$ = It.substring(0, Comma$);
                    if(Aux$.equals(Country)){
                        $Model.addElement(It);
                    }
                }
                TransferList2.setModel($Model);
            }else{
                DefaultListModel $Model = new DefaultListModel();
                for(Hotel It : main.Hotels.values()){
                    int Comma$ = 0;
                    for(int i = 0; i<It.getPlace().length(); i++){
                        if(It.getPlace().charAt(i) == ','){
                            Comma$ = i;
                            break;
                        }
                    }
                    String Aux$ = It.getPlace();
                    if(Aux$.equals(Country)){
                        $Model.addElement(Aux$ + ", " + It.getName());
                    }
                }
                TransferList2.setModel($Model);
            }
            TransferList2.setEnabled(true);
        }catch(Exception ex){
            
        }
        SearchTField2.setEnabled(true);
    }//GEN-LAST:event_TransferList1ValueChanged

    private void EditeTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditeTButtonActionPerformed
        // TODO add your handling code here:
        EditeTButton.setEnabled(false);
        SaveTButton.setEnabled(true);
        CancelTButton.setEnabled(true);
        PCapTField.setEditable(true);
        BCapTField.setEditable(true);
        CompanyTField.setEditable(true);
        PriceTField.setEditable(true);
        TransferList1.setEnabled(false);
        TransferList2.setEnabled(false);
        PCapTField.setEnabled(true);
        BCapTField.setEnabled(true);
        CompanyTField.setEnabled(true);
        PriceTField.setEnabled(true);
    }//GEN-LAST:event_EditeTButtonActionPerformed

    private void SaveTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTButtonActionPerformed
        // TODO add your handling code here:
        String Key;
        Transfer TranToAdd;
        if(HotelAirport){
            Key = (String)TransferList1.getSelectedValue() + " - " +
                        (String)TransferList2.getSelectedValue();
            TranToAdd = new Transfer(((String)TransferList2.getSelectedValue()),
                    ((String)TransferList1.getSelectedValue()), PCapTField.getText(),
                    BCapTField.getText(), Key, "", PriceTField.getText(), "",CompanyTField.getText());
        }else{
            Key =  (String)TransferList2.getSelectedValue() + " - " +
                                (String)TransferList1.getSelectedValue();
            TranToAdd = new Transfer(((String)TransferList1.getSelectedValue()),
                    ((String)TransferList2.getSelectedValue()), PCapTField.getText(),
                    BCapTField.getText(), Key, "", PriceTField.getText(), "",CompanyTField.getText());
        }
        main.Transfers.replace(Key, TranToAdd);
        TSave();
    }//GEN-LAST:event_SaveTButtonActionPerformed

    private void CancelTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelTButtonActionPerformed
        // TODO add your handling code here:
        SaveTButton.setEnabled(false);
        EditeTButton.setEnabled(false);
        PCapTField.setEditable(false);
        BCapTField.setEditable(false);
        CompanyTField.setEditable(false);
        PriceTField.setEditable(false);
        TransferList1.setEnabled(true);
        TransferList2.setEnabled(true);
        CancelCButton.setEnabled(false);
        TransferList1.setModel(new DefaultListModel());
        TransferList2.setModel(new DefaultListModel());
        PCapTField.setText("");
        BCapTField.setText("");
        CompanyTField.setText("");
        PriceTField.setText("");
    }//GEN-LAST:event_CancelTButtonActionPerformed

    private void Log_outTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_outTButtonActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_Log_outTButtonActionPerformed

    private void TransferList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransferList2ValueChanged
        // TODO add your handling code here:
        if(AuxMod++%2==0){
            if(HotelAirport){
                String Key = (String)TransferList1.getSelectedValue() + " - " +
                        (String)TransferList2.getSelectedValue();
                for(Transfer It:main.Transfers.values()){
                    String Key$ = It.getName();
                    if(Key.equals(Key$)){
                        System.out.println(true + "-" + It.getPCapacity()+ "-");
                        PCapTField.setText(It.getPCapacity());
                        BCapTField.setText(It.getBagCapacity());
                        CompanyTField.setText(It.getPlace());
                        PriceTField.setText(It.getPrice());
                    }
                }
            }else{
                String Key1 =  (String)TransferList2.getSelectedValue() + " - " +
                                (String)TransferList1.getSelectedValue();
                for(Transfer It:main.Transfers.values()){
                    String Key$ = It.getName();
                    if(Key1.equals(Key$)){
                        PCapTField.setText(It.getPCapacity());
                        BCapTField.setText(It.getBagCapacity());
                        CompanyTField.setText(It.getPlace());
                        PriceTField.setText(It.getPrice());
                    }
                }
            }
        }
         EditeTButton.setEnabled(true);
    }//GEN-LAST:event_TransferList2ValueChanged

    private void HotelsTOptionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_HotelsTOptionStateChanged
        // TODO add your handling code here:
        SearchTField.setEnabled(true);
        if(HotelsTOption.isSelected()){
            DefaultListModel $Model = new DefaultListModel();
            for(Hotel It : main.Hotels.values()){
                $Model.addElement(It.getPlace()+ ", " + It.getName());
            }
            try{
                TransferList1.setModel($Model);
                TransferList1.setEnabled(true);
                HotelAirport = true;
                TransferList2.setEnabled(false);
                TransferList2.setModel(new DefaultListModel());
                HotelsTOption.setEnabled(false);
                AirportsTOption.setEnabled(true);
            }catch(Exception ex){
                System.out.println(ex.toString());
            }
            
        }      
    }//GEN-LAST:event_HotelsTOptionStateChanged

    private void AirportsTOptionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AirportsTOptionStateChanged
        // TODO add your handling code here:
        SearchTField.setEnabled(true);
        if(AirportsTOption.isSelected()){
            DefaultListModel $Model = new DefaultListModel();
            for(String It : main.Airports.values()){
                $Model.addElement(It);
            } 
            TransferList1.setModel($Model);
            HotelAirport = false;
            TransferList1.setEnabled(true);
            TransferList2.setEnabled(false);
            TransferList2.setModel(new DefaultListModel());
            HotelsTOption.setEnabled(true);
            AirportsTOption.setEnabled(false);
        }
    }//GEN-LAST:event_AirportsTOptionStateChanged

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        HotelsTOption.setSelected(false);
        AirportsTOption.setSelected(false);
        TransferList1.setModel(new DefaultListModel());
        TransferList2.setModel(new DefaultListModel());
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void SaveTButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveTButtonMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_SaveTButtonMouseReleased

    private void TransferList2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TransferList2KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_TransferList2KeyReleased

    private void EditeTButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditeTButtonKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EditeTButtonKeyReleased

    private void SearchTField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTField2KeyReleased
        // TODO add your handling code here:
        TSearch2();
    }//GEN-LAST:event_SearchTField2KeyReleased

    private void HotelsTOptionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_HotelsTOptionPropertyChange
        // TODO add your handling code here:
          
    }//GEN-LAST:event_HotelsTOptionPropertyChange

    private void AirportsTOptionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_AirportsTOptionPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AirportsTOptionPropertyChange

    private void HotelsTOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotelsTOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HotelsTOptionActionPerformed

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        // TODO add your handling code here:
        TransferGenerate();
    }//GEN-LAST:event_jPanel5ComponentShown

    private void editeHComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_editeHComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_editeHComponentShown

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        // TODO add your handling code here:
        InsuranceGenerate();
    }//GEN-LAST:event_jPanel4ComponentShown

    private void HotelJList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_HotelJList1ValueChanged
        // TODO add your handling code here:
        editeH1.setEnabled(true);
        String User = HotelJList1.getSelectedValue().toString();
        for(User It : main.Users.values()){
            if(It.getUser().equals(User)){
                jCheckBox1.setSelected(It.isAdmin());
            }
        }
    }//GEN-LAST:event_HotelJList1ValueChanged

    private void editeH1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_editeH1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_editeH1ComponentShown

    private void editeH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editeH1ActionPerformed
        // TODO add your handling code here:
        jCheckBox1.setEnabled(true);
    }//GEN-LAST:event_editeH1ActionPerformed

    private void hotelSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelSave1ActionPerformed
        // TODO add your handling code here:
        main.Users.get(HotelJList1.getSelectedValue()).setAdmin(jCheckBox1.isSelected());
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("USerList.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(data.User It : main.Users.values()){
                os.writeObject(It);
            }
            os.close();
            JOptionPane.showMessageDialog(rootPane, "Saved", "Save", WIDTH);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
    }//GEN-LAST:event_hotelSave1ActionPerformed

    private void LogOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOut2ActionPerformed
        // TODO add your handling code here:
        LogOutMethod();
    }//GEN-LAST:event_LogOut2ActionPerformed

    private void CancelHotel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelHotel1ActionPerformed
        // TODO add your handling code here:
        jCheckBox1.setEnabled(false);
    }//GEN-LAST:event_CancelHotel1ActionPerformed

    private void jCheckBox1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jCheckBox1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ComponentShown

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    //<editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AHourFField;
    private javax.swing.JTextField APlaceFField;
    private javax.swing.JButton AddCButton;
    private javax.swing.JButton AddSButton;
    private javax.swing.JTextField AirlineFField;
    private javax.swing.JLabel AirlineFLabel;
    private javax.swing.JList AirlineJList;
    private javax.swing.JRadioButton AirportsTOption;
    private javax.swing.JTextField AssistanceSField;
    private javax.swing.JTextField BCapTField;
    private javax.swing.JCheckBox Box1;
    private javax.swing.JCheckBox Box2;
    private javax.swing.JCheckBox Box3;
    private javax.swing.JCheckBox Box4;
    private javax.swing.JCheckBox Box5;
    private javax.swing.JCheckBox Box6;
    private javax.swing.JTextField BrandCField;
    private javax.swing.JButton CancelCButton;
    private javax.swing.JButton CancelHotel;
    private javax.swing.JButton CancelHotel1;
    private javax.swing.JButton CancelSButton;
    private javax.swing.JButton CancelTButton;
    private javax.swing.JLabel CarCLabel;
    private javax.swing.JList<String> CarCList;
    private javax.swing.JComboBox<String> ColorCComboBox;
    private javax.swing.JTextField CompanyCField;
    private javax.swing.JTextField CompanySField;
    private javax.swing.JLabel CompanySLabel;
    private javax.swing.JList CompanySList;
    private javax.swing.JTextField CompanyTField;
    private javax.swing.JTextField DHourFField;
    private javax.swing.JTextField DPlaceFField;
    private javax.swing.JTextField DateCField;
    private javax.swing.JTextField DateFField;
    private javax.swing.JButton DeleteCButton;
    private javax.swing.JButton DeleteSButton;
    private javax.swing.JTextField EcoFField;
    private javax.swing.JButton EditeCButton;
    private javax.swing.JButton EditeSButton;
    private javax.swing.JButton EditeTButton;
    private javax.swing.JTextField ExeFField;
    private javax.swing.JTextField FirstFField;
    private javax.swing.JList<String> FliesJList;
    private javax.swing.JComboBox<String> FuelCComboBox;
    private javax.swing.JCheckBox GpsCCheckBox;
    private javax.swing.JTextField HotelDoubleField;
    private javax.swing.JList HotelJList;
    private javax.swing.JList HotelJList1;
    private javax.swing.JTextField HotelLocationField;
    private javax.swing.JTextField HotelMatrimonialField;
    private javax.swing.JTextField HotelNameField;
    private javax.swing.JTextField HotelPlaceField;
    private javax.swing.JTextField HotelSimpleField;
    private javax.swing.JTextField HotelStarsField;
    private javax.swing.JTextField HotelSuiteField;
    private javax.swing.JRadioButton HotelsTOption;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton LogOut1;
    private javax.swing.JButton LogOut2;
    private javax.swing.JButton Log_outButton;
    private javax.swing.JButton Log_outCButton;
    private javax.swing.JButton Log_outTButton;
    private javax.swing.JTextField ModelCField;
    private javax.swing.JLabel ModelCLabel;
    private javax.swing.JLabel ModelCLabel1;
    private javax.swing.JList ModelCList;
    private javax.swing.JTextField NameFField;
    private javax.swing.JLabel NameFLabel;
    private javax.swing.JTextField PCapTField;
    private javax.swing.JTextField PackageSField;
    private javax.swing.JLabel PackageSLabel;
    private javax.swing.JList<String> PackageSList;
    private javax.swing.JTextField PeopleCField;
    private javax.swing.JTextField PeopleFField;
    private javax.swing.JSlider PeopleSSlider;
    private javax.swing.JTextField PlaceCField;
    private javax.swing.JTextField PlateCField;
    private javax.swing.JTextField PriceCField;
    private javax.swing.JTextField PriceSField;
    private javax.swing.JTextField PriceTField;
    private javax.swing.JComboBox<String> RegionSComboBox;
    private javax.swing.JTextField RoomPriceField;
    private javax.swing.JButton SaveCButton;
    private javax.swing.JButton SaveSButton;
    private javax.swing.JButton SaveTButton;
    private javax.swing.JTextField ScalesFField;
    private javax.swing.JTextField SearchAirlineF;
    private javax.swing.JTextField SearchCarCField;
    private javax.swing.JTextField SearchCompanySField;
    private javax.swing.JTextField SearchFlyF;
    private javax.swing.JTextField SearchModelCField;
    private javax.swing.JTextField SearchPackageSField;
    private javax.swing.JTextField SearchTField;
    private javax.swing.JTextField SearchTField2;
    private javax.swing.JTextField SeatsPriceFField;
    private javax.swing.JList TransferList1;
    private javax.swing.JList<String> TransferList2;
    private javax.swing.JButton addF;
    private javax.swing.JButton addH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelF;
    private javax.swing.JScrollPane contactList;
    private javax.swing.JScrollPane contactList1;
    private javax.swing.JScrollPane contactList2;
    private javax.swing.JScrollPane contactList3;
    private javax.swing.JScrollPane contactList4;
    private javax.swing.JScrollPane contactList5;
    private javax.swing.JButton deleteF;
    private javax.swing.JButton deleteH;
    private javax.swing.JButton editeF;
    private javax.swing.JButton editeH;
    private javax.swing.JButton editeH1;
    private javax.swing.JButton hotelSave;
    private javax.swing.JButton hotelSave1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel name;
    private javax.swing.JButton saveF;
    private javax.swing.JTextField searchH;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
