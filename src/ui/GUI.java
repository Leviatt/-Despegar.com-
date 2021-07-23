package ui;
import bussines_logic.main;
import static bussines_logic.main.Hotels;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import data.*;
import java.util.ArrayList;

public class GUI extends javax.swing.JFrame {    
    public static ArrayList<String> Hotel$;
    public static HashMap<Integer, String[]> AuxH = new HashMap<>();
    public static HashMap<Integer, String[]> AuxF = new HashMap<>();
    public static HashMap<Integer, String[]> AuxC = new HashMap<>();
    public static HashMap<Integer, String[]> AuxT = new HashMap<>();
    public static HashMap<Integer, String[]> AuxI = new HashMap<>();
    public static HashMap<Integer, String> CountryC = new HashMap<>();
    public static HashMap<Integer, String> CarsList = new HashMap<>();
    public static HashMap<Integer, String> Packages = new HashMap<>();
    public static HashMap<Integer, HashMap<Integer, String[]>> Aux = new HashMap<>();
    public static HashMap<String, HashMap<Integer, HashMap<Integer,String[]>>> Services = new HashMap<>();
    public static String[] PassHotel = new String[6];
    public static String[] PassFly = new String[4];
    public static String[] PassTransfers = new String[5];
    public static String[] PassCars = new String[6];
    public static String[] PassInsurance = new String[11];
    public static HashMap<Integer, String> DepartureF = new HashMap<>();
    public static HashMap<Integer, String> ArriveF = new HashMap<>();
    public static double PriceH;
    public static String AddressH;
    public static String CountrySelected, CarSelected, Capacity$;
    public static String PlaceI, PeopleI, SelectedPackage;
    public static Integer DaysI;
    public static boolean HotelAirport;
    public static DefaultListModel TransferModel1 = new DefaultListModel();
    public static DefaultListModel TransferModel2 = new DefaultListModel();
    
       
    public GUI(){
        initComponents();
        
    }
    public static void SearchFields(javax.swing.JTextField TextField$,
            javax.swing.JList<String> JList$, DefaultListModel Model$){
        DefaultListModel ModelSearch = new DefaultListModel();
        String toCompare = TextField$.getText();
        if(toCompare.length() != 0){
            String[] Aux = new String[Model$.size()];
            Model$.copyInto(Aux);
            for(int i = 0; i < Model$.size(); i++){
                if(Aux[i].toLowerCase().contains(toCompare.toLowerCase())){
                    ModelSearch.addElement(Aux[i]);
                }
            }
            if(ModelSearch.equals(new DefaultListModel()) || ModelSearch.size() == 0){
                JList$.setModel(Model$);
            }
            JList$.setModel(ModelSearch);
        }else{
            JList$.setModel(Model$);
        }
    }
    public static DefaultListModel HotelList(){
        DefaultListModel hotelList = new DefaultListModel();
        Hotels.values().stream().forEach((cont) -> {
            hotelList.addElement(cont.getName() + " - " + cont.getPlace());
        });
        return hotelList;
    }
    public static DefaultListModel CountryList(){
        DefaultListModel carList = new DefaultListModel();
        for(Car It: main.Cars.values()){
            if (!CountryC.containsValue(It.getPlace())){
                CountryC.put(CountryC.size(), It.getPlace());
            }
        }
        CountryC.values().stream().forEach((cont) -> {
            carList.addElement(cont);
        });
        return carList;
    }
    public static DefaultListModel InsurancesList(){
        DefaultListModel packList = new DefaultListModel();
        Packages.values().stream().forEach((cont) -> {
            packList.addElement(cont);
        });
        return packList;
    }
    public static DefaultListModel CarList(){
        DefaultListModel carsList = new DefaultListModel();
        CarsList.values().stream().forEach((cont) -> {
            carsList.addElement(cont);
        });
        return carsList;
    }
    
    public static DefaultListModel DepartureF(){
        DefaultListModel DepartureList = new DefaultListModel();
        for(Fly It : main.Flies.values()){
            if(!(DepartureF.containsValue(It.getDPlace()))){
                DepartureF.put(DepartureF.size(),It.getDPlace());
            }
        }
        for(String cont: DepartureF.values()){
            DepartureList.addElement(cont);
        }
        return DepartureList;
    }
    DefaultListModel ArriveF(){
        DefaultListModel arriveF = new DefaultListModel();
        ArriveF.values().stream().forEach((cont) -> {
            arriveF.addElement(cont);
        });
        return arriveF;
    }
    
    public void BuyHotel(){
        String Select = (String)HotelList.getSelectedValue();
        Hotel HotelR = new Hotel();
        int Key = 0, Change, Chair;
        PriceH = 0.0;
        for(Hotel It :main.Hotels.values()){
                if((It.getName() + " - " + It.getPlace()).equals(Select)){
                Change = Integer.parseInt(RoomNH.getSelectedItem().toString());
                switch(RoomNH.getSelectedIndex()){
                    case 0:
                        PriceH = (Integer.parseInt(It.getPrice()) * 0.4 * Change) *
                                (Integer.parseInt(PassHotel[0]));
                        Chair = Integer.parseInt(It.getSimpleRooms());
                        HotelR = It;
                        HotelR.setSimpleRooms((Chair-Change)+"");
                        HotelR.setPrice(PriceH+"");
                        break;
                    case 1:
                        PriceH = (Integer.parseInt(It.getPrice()) * 0.7 * Change) *
                                (Integer.parseInt(PassHotel[0]));
                        Chair = Integer.parseInt(It.getDoubleRooms());
                        HotelR = It;
                        HotelR.setDoubleRooms((Chair-Change)+"");
                        HotelR.setPrice(PriceH+"");
                        break;
                    case 2:
                        PriceH = (Integer.parseInt(It.getPrice()) * 0.8 * Change) *
                                (Integer.parseInt(PassHotel[0]));
                        Chair = Integer.parseInt(It.getMatrimonialRooms());
                        HotelR = It;
                        HotelR.setMatrimonialRooms((Chair-Change)+"");
                        HotelR.setPrice(PriceH+"");
                        break;
                    case 3:
                        PriceH = (Integer.parseInt(It.getPrice())* Change) *
                                (Integer.parseInt(PassHotel[0]));
                        Chair = Integer.parseInt(It.getSuiteRooms());
                        HotelR = It;
                        HotelR.setSuiteRooms((Chair-Change)+"");
                        HotelR.setPrice(PriceH+"");
                        break;
                }
                main.Hotels.replace(Key, HotelR);
            }
            Key++;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboInDayH = new javax.swing.JComboBox<>();
        SearchHField = new javax.swing.JTextField();
        ComboInMH = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ComboOutDayH = new javax.swing.JComboBox<>();
        ComboOutMH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        RoomNH = new javax.swing.JComboBox<>();
        AdultsH = new javax.swing.JComboBox<>();
        ChildrenH = new javax.swing.JComboBox<>();
        ButtonH = new javax.swing.JButton();
        ComboInYH = new javax.swing.JComboBox<>();
        ComboOutYH = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        HotelList = new javax.swing.JList<>();
        RoomType = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        DepFSearch = new javax.swing.JTextField();
        AFSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        DayDestF = new javax.swing.JComboBox<>();
        MDestF = new javax.swing.JComboBox<>();
        YDestF = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        DayDepF = new javax.swing.JComboBox<>();
        MDepF = new javax.swing.JComboBox<>();
        YDepF = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        ChildrenF = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        AdultsF = new javax.swing.JComboBox<>();
        BuyF = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        DPlaceF = new javax.swing.JList<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        APlaceF = new javax.swing.JList<>();
        ClassF = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        CarDIn = new javax.swing.JComboBox<>();
        CarMIn = new javax.swing.JComboBox<>();
        CarYIn = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        CarDOut = new javax.swing.JComboBox<>();
        CarMOut = new javax.swing.JComboBox<>();
        CarYOut = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        BuyC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CarList = new javax.swing.JList<>();
        searchCar = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        CountryCList = new javax.swing.JList<>();
        CapacityC = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        DestTIns = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        DIIn = new javax.swing.JComboBox<>();
        MIIn = new javax.swing.JComboBox<>();
        YIIn = new javax.swing.JComboBox<>();
        DIOut = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        BuyI = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        NPeopleI = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        MIOut = new javax.swing.JComboBox<>();
        YIOut = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        InsuranceList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        HotelsTOption = new javax.swing.JRadioButton();
        AirportsTOption = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TTrSearch = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        FTrSearch = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        DepTrDay = new javax.swing.JComboBox<>();
        DepTrM = new javax.swing.JComboBox<>();
        DepTrY = new javax.swing.JComboBox<>();
        DepTrHour = new javax.swing.JComboBox<>();
        AdultsTr = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        ChildrenTr = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        BuyT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TransferList1 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        TransferList2 = new javax.swing.JList<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trip.com");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("Hotels"); // NOI18N
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(541, 440));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOTELS ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 20, 110, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("When?");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 120, 39, 15);

        jLabel4.setText("Check in");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 150, 60, 16);

        ComboInDayH.setBackground(new java.awt.Color(153, 153, 153));
        ComboInDayH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th" }));
        ComboInDayH.setEnabled(false);
        ComboInDayH.setName(""); // NOI18N
        ComboInDayH.setOpaque(false);
        jPanel1.add(ComboInDayH);
        ComboInDayH.setBounds(30, 170, 50, 22);

        SearchHField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchHField.setForeground(new java.awt.Color(204, 204, 204));
        SearchHField.setText("Search hotel");
        SearchHField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchHFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchHFieldFocusLost(evt);
            }
        });
        SearchHField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchHFieldKeyReleased(evt);
            }
        });
        jPanel1.add(SearchHField);
        SearchHField.setBounds(240, 20, 270, 40);

        ComboInMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        ComboInMH.setEnabled(false);
        ComboInMH.setOpaque(false);
        jPanel1.add(ComboInMH);
        ComboInMH.setBounds(90, 170, 90, 22);

        jLabel5.setText("Check out");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 190, 70, 16);

        ComboOutDayH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        ComboOutDayH.setEnabled(false);
        jPanel1.add(ComboOutDayH);
        ComboOutDayH.setBounds(30, 210, 50, 22);

        ComboOutMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        ComboOutMH.setEnabled(false);
        jPanel1.add(ComboOutMH);
        ComboOutMH.setBounds(90, 210, 90, 22);

        jLabel6.setText("Rooms number");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 290, 100, 16);

        jLabel7.setText("Adults");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(140, 240, 60, 16);

        jLabel8.setText("Children");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 290, 70, 16);

        RoomNH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        RoomNH.setEnabled(false);
        jPanel1.add(RoomNH);
        RoomNH.setBounds(30, 310, 90, 22);

        AdultsH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        AdultsH.setEnabled(false);
        jPanel1.add(AdultsH);
        AdultsH.setBounds(150, 260, 90, 22);

        ChildrenH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        ChildrenH.setEnabled(false);
        jPanel1.add(ChildrenH);
        ChildrenH.setBounds(150, 310, 90, 22);

        ButtonH.setBackground(new java.awt.Color(204, 0, 0));
        ButtonH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/anadir (2).png"))); // NOI18N
        ButtonH.setText("ADD TO BASKET");
        ButtonH.setBorder(null);
        ButtonH.setBorderPainted(false);
        ButtonH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonH.setEnabled(false);
        ButtonH.setSelected(true);
        ButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonH);
        ButtonH.setBounds(50, 350, 111, 39);

        ComboInYH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        ComboInYH.setEnabled(false);
        jPanel1.add(ComboInYH);
        ComboInYH.setBounds(190, 170, 50, 22);

        ComboOutYH.setBackground(new java.awt.Color(204, 204, 204));
        ComboOutYH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        ComboOutYH.setEnabled(false);
        jPanel1.add(ComboOutYH);
        ComboOutYH.setBounds(190, 210, 50, 22);

        HotelList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                HotelListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(HotelList);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(295, 107, 220, 243);

        RoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Double", "Marital", "Suite" }));
        RoomType.setEnabled(false);
        RoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomTypeActionPerformed(evt);
            }
        });
        jPanel1.add(RoomType);
        RoomType.setBounds(30, 260, 90, 22);

        jLabel29.setText("Room type");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(30, 240, 80, 16);

        jLabel30.setBackground(new java.awt.Color(216, 0, 0));
        jLabel30.setOpaque(true);
        jPanel1.add(jLabel30);
        jLabel30.setBounds(0, 0, 540, 80);

        jTabbedPane1.addTab("Hotels", new javax.swing.ImageIcon(getClass().getResource("/icons/cama.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        DepFSearch.setForeground(new java.awt.Color(204, 204, 204));
        DepFSearch.setText("Search departure place");
        DepFSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DepFSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DepFSearchFocusLost(evt);
            }
        });
        DepFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepFSearchActionPerformed(evt);
            }
        });
        DepFSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DepFSearchKeyReleased(evt);
            }
        });
        jPanel2.add(DepFSearch);
        DepFSearch.setBounds(30, 100, 230, 30);

        AFSearch.setEnabled(false);
        AFSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AFSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AFSearchFocusLost(evt);
            }
        });
        AFSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AFSearchKeyReleased(evt);
            }
        });
        jPanel2.add(AFSearch);
        AFSearch.setBounds(280, 100, 230, 30);

        jLabel13.setText("Departure");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(30, 240, 80, 16);

        DayDestF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        DayDestF.setEnabled(false);
        jPanel2.add(DayDestF);
        DayDestF.setBounds(280, 260, 50, 22);

        MDestF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        MDestF.setEnabled(false);
        jPanel2.add(MDestF);
        MDestF.setBounds(350, 260, 90, 22);

        YDestF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        YDestF.setEnabled(false);
        jPanel2.add(YDestF);
        YDestF.setBounds(460, 260, 55, 22);

        jLabel14.setText("Return");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(280, 240, 60, 16);

        DayDepF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        DayDepF.setEnabled(false);
        DayDepF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayDepFActionPerformed(evt);
            }
        });
        jPanel2.add(DayDepF);
        DayDepF.setBounds(30, 260, 50, 22);

        MDepF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        MDepF.setEnabled(false);
        jPanel2.add(MDepF);
        MDepF.setBounds(100, 260, 90, 22);

        YDepF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        YDepF.setEnabled(false);
        jPanel2.add(YDepF);
        YDepF.setBounds(210, 260, 55, 22);

        jLabel15.setText("Adults");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(30, 290, 70, 16);

        ChildrenF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        ChildrenF.setEnabled(false);
        jPanel2.add(ChildrenF);
        ChildrenF.setBounds(170, 310, 90, 22);

        jLabel16.setText("Children");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(170, 290, 80, 16);

        AdultsF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        AdultsF.setEnabled(false);
        jPanel2.add(AdultsF);
        AdultsF.setBounds(30, 310, 90, 22);

        BuyF.setBackground(new java.awt.Color(255, 255, 255));
        BuyF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda (1).png"))); // NOI18N
        BuyF.setText("BUY");
        BuyF.setBorder(null);
        BuyF.setEnabled(false);
        BuyF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyFActionPerformed(evt);
            }
        });
        jPanel2.add(BuyF);
        BuyF.setBounds(50, 350, 111, 39);

        DPlaceF.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        DPlaceF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DPlaceFKeyReleased(evt);
            }
        });
        DPlaceF.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DPlaceFValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(DPlaceF);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(30, 140, 230, 90);

        jLabel33.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("FLIGHTS");
        jPanel2.add(jLabel33);
        jLabel33.setBounds(80, 20, 110, 32);

        jLabel31.setBackground(new java.awt.Color(255, 153, 0));
        jLabel31.setOpaque(true);
        jPanel2.add(jLabel31);
        jLabel31.setBounds(0, 0, 540, 80);

        jLabel45.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("HOTELS ");
        jPanel2.add(jLabel45);
        jLabel45.setBounds(80, 20, 110, 32);

        APlaceF.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        APlaceF.setEnabled(false);
        APlaceF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                APlaceFKeyReleased(evt);
            }
        });
        APlaceF.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                APlaceFValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(APlaceF);

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(280, 140, 230, 90);

        ClassF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First", "Executive", "Economic" }));
        ClassF.setEnabled(false);
        jPanel2.add(ClassF);
        ClassF.setBounds(300, 310, 90, 22);

        jLabel2.setText("Class");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(300, 290, 50, 16);

        jTabbedPane1.addTab("Flights", new javax.swing.ImageIcon(getClass().getResource("/icons/aeroplano.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setEnabled(false);
        jPanel3.setLayout(null);

        jLabel47.setBackground(new java.awt.Color(255, 102, 102));
        jLabel47.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("CAR RENTAL");
        jPanel3.add(jLabel47);
        jLabel47.setBounds(30, 20, 190, 32);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Pick up date");
        jPanel3.add(jLabel35);
        jLabel35.setBounds(30, 130, 110, 15);

        CarDIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        CarDIn.setEnabled(false);
        jPanel3.add(CarDIn);
        CarDIn.setBounds(30, 150, 50, 22);

        CarMIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        CarMIn.setEnabled(false);
        jPanel3.add(CarMIn);
        CarMIn.setBounds(90, 150, 90, 22);

        CarYIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        CarYIn.setEnabled(false);
        jPanel3.add(CarYIn);
        CarYIn.setBounds(190, 150, 55, 22);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Return date");
        jPanel3.add(jLabel36);
        jLabel36.setBounds(30, 190, 100, 15);

        CarDOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        CarDOut.setEnabled(false);
        jPanel3.add(CarDOut);
        CarDOut.setBounds(30, 210, 50, 22);

        CarMOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        CarMOut.setEnabled(false);
        jPanel3.add(CarMOut);
        CarMOut.setBounds(90, 210, 90, 22);

        CarYOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        CarYOut.setEnabled(false);
        jPanel3.add(CarYOut);
        CarYOut.setBounds(190, 210, 55, 22);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Capacity");
        jPanel3.add(jLabel37);
        jLabel37.setBounds(30, 260, 80, 15);

        BuyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa.png"))); // NOI18N
        BuyC.setText("BUY");
        BuyC.setEnabled(false);
        BuyC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyCActionPerformed(evt);
            }
        });
        jPanel3.add(BuyC);
        BuyC.setBounds(54, 352, 111, 39);

        CarList.setEnabled(false);
        CarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CarListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(CarList);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(320, 230, 179, 110);

        searchCar.setForeground(new java.awt.Color(204, 204, 204));
        searchCar.setText("Pick up location (Enter a city or airport)");
        searchCar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchCarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchCarFocusLost(evt);
            }
        });
        searchCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCarActionPerformed(evt);
            }
        });
        searchCar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchCarKeyReleased(evt);
            }
        });
        jPanel3.add(searchCar);
        searchCar.setBounds(240, 20, 270, 40);

        jLabel46.setBackground(new java.awt.Color(0, 204, 102));
        jLabel46.setOpaque(true);
        jPanel3.add(jLabel46);
        jLabel46.setBounds(0, 0, 540, 80);

        CountryCList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CountryCListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(CountryCList);

        jPanel3.add(jScrollPane7);
        jScrollPane7.setBounds(317, 105, 179, 110);

        CapacityC.setEditable(false);
        CapacityC.setText(" ");
        CapacityC.setDragEnabled(true);
        CapacityC.setEnabled(false);
        jPanel3.add(CapacityC);
        CapacityC.setBounds(30, 290, 70, 22);

        jTabbedPane1.addTab("Cars", new javax.swing.ImageIcon(getClass().getResource("/icons/coche.png")), jPanel3); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Destination");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(30, 87, 90, 15);

        DestTIns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentina", "Aruba", "Bahamas", "Bonaire", "Brazil", "Chile", "France", "Germany", "Miami", "South Africa", "Spain", "United Kingdom", "United States" }));
        DestTIns.setSelectedIndex(-1);
        DestTIns.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DestTInsItemStateChanged(evt);
            }
        });
        jPanel6.add(DestTIns);
        DestTIns.setBounds(30, 108, 466, 29);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("When?");
        jPanel6.add(jLabel26);
        jLabel26.setBounds(30, 155, 60, 15);

        jLabel27.setText("Departure");
        jPanel6.add(jLabel27);
        jLabel27.setBounds(30, 176, 90, 16);

        DIIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        DIIn.setEnabled(false);
        jPanel6.add(DIIn);
        DIIn.setBounds(30, 196, 50, 22);

        MIIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        MIIn.setEnabled(false);
        jPanel6.add(MIIn);
        MIIn.setBounds(86, 196, 90, 22);

        YIIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        YIIn.setEnabled(false);
        jPanel6.add(YIIn);
        YIIn.setBounds(182, 196, 55, 22);

        DIOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        DIOut.setEnabled(false);
        jPanel6.add(DIOut);
        DIOut.setBounds(290, 200, 50, 22);

        jLabel28.setText("Return");
        jPanel6.add(jLabel28);
        jLabel28.setBounds(290, 180, 70, 16);

        BuyI.setBackground(new java.awt.Color(255, 255, 255));
        BuyI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda (1).png"))); // NOI18N
        BuyI.setText("BUY");
        BuyI.setEnabled(false);
        BuyI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyIActionPerformed(evt);
            }
        });
        jPanel6.add(BuyI);
        BuyI.setBounds(54, 352, 111, 39);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Number of people");
        jPanel6.add(jLabel44);
        jLabel44.setBounds(31, 234, 130, 15);

        NPeopleI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        NPeopleI.setEnabled(false);
        jPanel6.add(NPeopleI);
        NPeopleI.setBounds(30, 255, 100, 22);

        jLabel52.setBackground(new java.awt.Color(255, 102, 102));
        jLabel52.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("TRAVEL INSURANCE");
        jPanel6.add(jLabel52);
        jLabel52.setBounds(50, -10, 270, 110);

        jLabel51.setBackground(java.awt.Color.cyan);
        jLabel51.setOpaque(true);
        jPanel6.add(jLabel51);
        jLabel51.setBounds(0, 0, 540, 80);

        MIOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        MIOut.setEnabled(false);
        jPanel6.add(MIOut);
        MIOut.setBounds(350, 200, 90, 22);

        YIOut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        YIOut.setEnabled(false);
        jPanel6.add(YIOut);
        YIOut.setBounds(450, 200, 55, 22);

        InsuranceList.setEnabled(false);
        InsuranceList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                InsuranceListValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(InsuranceList);

        jPanel6.add(jScrollPane8);
        jScrollPane8.setBounds(290, 240, 210, 130);

        jTabbedPane1.addTab("Insurance", new javax.swing.ImageIcon(getClass().getResource("/icons/hospital.png")), jPanel6); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        HotelsTOption.setBackground(new java.awt.Color(153, 0, 153));
        HotelsTOption.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HotelsTOption.setForeground(new java.awt.Color(255, 255, 255));
        HotelsTOption.setText("Hotels");
        HotelsTOption.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                HotelsTOptionStateChanged(evt);
            }
        });
        jPanel4.add(HotelsTOption);
        HotelsTOption.setBounds(390, 20, 93, 23);

        AirportsTOption.setBackground(new java.awt.Color(153, 0, 153));
        AirportsTOption.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AirportsTOption.setForeground(new java.awt.Color(255, 255, 255));
        AirportsTOption.setText("Airports");
        AirportsTOption.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AirportsTOptionStateChanged(evt);
            }
        });
        jPanel4.add(AirportsTOption);
        AirportsTOption.setBounds(390, 50, 93, 23);

        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("Hotel or airport");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(40, 110, 87, 16);

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Hotel or airport");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(290, 110, 80, 16);

        TTrSearch.setEnabled(false);
        TTrSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TTrSearchKeyReleased(evt);
            }
        });
        jPanel4.add(TTrSearch);
        TTrSearch.setBounds(281, 106, 230, 30);

        jLabel39.setText("To");
        jPanel4.add(jLabel39);
        jLabel39.setBounds(284, 86, 70, 16);

        FTrSearch.setEnabled(false);
        FTrSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FTrSearchKeyReleased(evt);
            }
        });
        jPanel4.add(FTrSearch);
        FTrSearch.setBounds(30, 106, 232, 30);

        jLabel40.setText("From");
        jPanel4.add(jLabel40);
        jLabel40.setBounds(30, 86, 70, 16);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Departure date and time");
        jPanel4.add(jLabel41);
        jLabel41.setBounds(30, 285, 180, 15);

        DepTrDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11st", "12nd", "13rd", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" }));
        DepTrDay.setEnabled(false);
        jPanel4.add(DepTrDay);
        DepTrDay.setBounds(30, 306, 50, 22);

        DepTrM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April ", "May ", "June", "Jule", "August", "September", "October", "November", "December" }));
        DepTrM.setEnabled(false);
        jPanel4.add(DepTrM);
        DepTrM.setBounds(86, 306, 90, 22);

        DepTrY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        DepTrY.setEnabled(false);
        jPanel4.add(DepTrY);
        DepTrY.setBounds(182, 306, 55, 22);

        DepTrHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));
        DepTrHour.setEnabled(false);
        jPanel4.add(DepTrHour);
        DepTrHour.setBounds(237, 306, 60, 22);

        AdultsTr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        AdultsTr.setEnabled(false);
        jPanel4.add(AdultsTr);
        AdultsTr.setBounds(318, 306, 90, 22);

        jLabel42.setText("Adults");
        jPanel4.add(jLabel42);
        jLabel42.setBounds(318, 286, 50, 16);

        ChildrenTr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        ChildrenTr.setEnabled(false);
        jPanel4.add(ChildrenTr);
        ChildrenTr.setBounds(418, 306, 90, 22);

        jLabel43.setText("Children");
        jPanel4.add(jLabel43);
        jLabel43.setBounds(418, 286, 80, 16);

        BuyT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/busqueda.png"))); // NOI18N
        BuyT.setText("BUY");
        BuyT.setEnabled(false);
        BuyT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyTActionPerformed(evt);
            }
        });
        jPanel4.add(BuyT);
        BuyT.setBounds(54, 352, 111, 39);

        TransferList1.setEnabled(false);
        TransferList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransferList1ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(TransferList1);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(30, 142, 232, 130);

        TransferList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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
        jScrollPane5.setViewportView(TransferList2);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(280, 142, 232, 130);

        jLabel49.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("TRANSFERS");
        jPanel4.add(jLabel49);
        jLabel49.setBounds(70, 10, 160, 80);

        jLabel48.setBackground(new java.awt.Color(153, 0, 153));
        jLabel48.setOpaque(true);
        jPanel4.add(jLabel48);
        jLabel48.setBounds(0, 0, 540, 80);

        jTabbedPane1.addTab("Transfers", new javax.swing.ImageIcon(getClass().getResource("/icons/taxi.png")), jPanel4); // NOI18N

        LogOut.setText("Log out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(LogOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        login.main(new String[1]);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DPlaceF.setModel(DepartureF());
        buttonGroup1.add(HotelsTOption);
        buttonGroup1.add(AirportsTOption);
        HotelList.setModel(HotelList());
        CountryCList.setModel(CountryList());
        InsuranceList.setModel(InsurancesList());
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formComponentShown

    private void BuyIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyIActionPerformed
        // TODO add your handling code here:
        
        this.hide();
        SeenInsurance.main(new String[1]);
    }//GEN-LAST:event_BuyIActionPerformed

    private void TransferList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransferList2ValueChanged
        // TODO add your handling code here:
        DepTrDay.setEnabled(true);
        DepTrM.setEnabled(true);
        DepTrY.setEnabled(true);
        DepTrHour.setEnabled(true);
        AdultsTr.setEnabled(true);
        ChildrenTr.setEnabled(true);
        BuyT.setEnabled(true);
    }//GEN-LAST:event_TransferList2ValueChanged

    private void TransferList2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TransferList2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TransferList2KeyReleased

    private void BuyTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyTActionPerformed
        // TODO add your handling code here:
        if(HotelAirport){
                String Key = (String)TransferList1.getSelectedValue() + " - " +
                        (String)TransferList2.getSelectedValue();
                for(Transfer It:main.Transfers.values()){
                    String Key$ = It.getName();
                    if(Key.equals(Key$)){
                        PassTransfers[0] = It.getBagCapacity();
                        PassTransfers[1] = It.getPCapacity();
                        PassTransfers[2] = It.getDPlace();
                        PassTransfers[3] = It.getAPlace();
                        PassTransfers[5] = It.getPrice();
                        /*PCapTField.setText(It.getPCapacity());
                        BCapTField.setText(It.getBagCapacity());
                        CompanyTField.setText(It.getPlace());
                        PriceTField.setText(It.getPrice());*/
                    }
                }
            }else{
                String Key1 =  (String)TransferList2.getSelectedValue() + " - " +
                                (String)TransferList1.getSelectedValue();
                for(Transfer It:main.Transfers.values()){
                    String Key$ = It.getName();
                    if(Key1.equals(Key$)){
                        PassTransfers[0] = It.getBagCapacity();
                        PassTransfers[1] = It.getPCapacity();
                        PassTransfers[2] = It.getDPlace();
                        PassTransfers[3] = It.getAPlace();
                        PassTransfers[4] = It.getPrice();
                        /*PCapTField.setText(It.getPCapacity());
                        BCapTField.setText(It.getBagCapacity());
                        CompanyTField.setText(It.getPlace());
                        PriceTField.setText(It.getPrice());*/
                    }
                }
            }
        this.hide();
        SeenTransfers.main(new String [1]);
        
    }//GEN-LAST:event_BuyTActionPerformed

    private void FTrSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTrSearchKeyReleased
        // TODO add your handling code here:
        SearchFields(FTrSearch, TransferList1, TransferModel1);
    }//GEN-LAST:event_FTrSearchKeyReleased

    private void TTrSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TTrSearchKeyReleased
        // TODO add your handling code here:
        SearchFields(TTrSearch, TransferList2, TransferModel2);
    }//GEN-LAST:event_TTrSearchKeyReleased

    private void CountryCListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CountryCListValueChanged
        // TODO add your handling code here:
        if(CountryCList.getSelectedIndex()!=-1){
            CarsList = new HashMap<>();
        for(Car It: main.Cars.values()){
            if(CountryCList.getSelectedValue().equals(It.getPlace()) && !CarsList.containsValue(It.getPlace())){
                CarsList.put(CarsList.size(), It.getModel() + " - " + It.getName() + " - " + It.getPlate());
            }
        }
        CountrySelected = (String)CountryCList.getSelectedValue();
        CarList.setModel(CarList());
        CarList.setEnabled(true);
        }
    }//GEN-LAST:event_CountryCListValueChanged

    private void searchCarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCarKeyReleased
        // TODO add your handling code here:
        SearchFields(searchCar, CountryCList, CountryList());        
    }//GEN-LAST:event_searchCarKeyReleased

    private void searchCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCarActionPerformed

    private void CarListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CarListValueChanged
        // TODO add your handling code here:
        BuyC.setEnabled(true);
        CarDIn.setEnabled(true);
        CarMIn.setEnabled(true);
        CarYIn.setEnabled(true);
        CarDOut.setEnabled(true);
        CarMOut.setEnabled(true);
        CarYOut.setEnabled(true);
        CapacityC.setEnabled(true);
        for(Car It: main.Cars.values()){
            if((CountryCList.getSelectedValue().equals(It.getPlace()) &&
                (CarList.getSelectedValue().equals(It.getModel() + " - " +
                    It.getName() + " - " +  It.getPlate())))){

        CapacityC.setText(It.getPeople());
        }
        }

        CarSelected = (String)CarList.getSelectedValue();
        Capacity$ = (String)CapacityC.getText();
    }//GEN-LAST:event_CarListValueChanged

    private void BuyCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyCActionPerformed
        // TODO add your handling code here:
        this.hide();
        SeenCar.main(new String[1]);

    }//GEN-LAST:event_BuyCActionPerformed

    private void APlaceFValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_APlaceFValueChanged
        // TODO add your handling code here:
        DepFSearch.setEnabled(false);
        DayDepF.setEnabled(true);
        MDepF.setEnabled(true);
        YDepF.setEnabled(true);
        DayDestF.setEnabled(true);
        MDestF.setEnabled(true);
        YDestF.setEnabled(true);
        AdultsF.setEnabled(true);
        ChildrenF.setEnabled(true);
        ClassF.setEnabled(true);
        BuyF.setEnabled(true);
    }//GEN-LAST:event_APlaceFValueChanged

    private void APlaceFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APlaceFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_APlaceFKeyReleased

    private void DPlaceFValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DPlaceFValueChanged
        // TODO add your handling code here:
       if(DPlaceF.getSelectedIndex() != -1){
            DepFSearch.setEnabled(true);
            APlaceF.setModel(new DefaultListModel());
            ArriveF = new HashMap<>();
             for(Fly It: main.Flies.values()){
                 if(DPlaceF.getSelectedValue().equals(It.getDPlace())&& (!ArriveF.containsValue(It.getAPlace()))){
                     ArriveF.put(ArriveF.size(), It.getAPlace());
                 }
             }
             if(DPlaceF.getSelectedIndex() == -1){
                 APlaceF.setEnabled(false);
                 APlaceF.setSelectedIndex(-1);
             }
             AFSearch.setText("Search departure place");
             AFSearch.setForeground(new java.awt.Color(204, 204, 204));
             APlaceF.setModel(ArriveF());
             DayDepF.setEnabled(false);
             MDepF.setEnabled(false);
             YDepF.setEnabled(false);
             DayDestF.setEnabled(false);
             MDestF.setEnabled(false);
             YDestF.setEnabled(false);
             AdultsF.setEnabled(false);
             ChildrenF.setEnabled(false);
             ClassF.setEnabled(false);
             BuyF.setEnabled(false);
             APlaceF.setEnabled(true);
             AFSearch.setEnabled(true);
       }
    }//GEN-LAST:event_DPlaceFValueChanged

    private void DPlaceFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DPlaceFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_DPlaceFKeyReleased

    private void BuyFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyFActionPerformed
        // TODO add your handling code here:
        this.hide();
        SeenFly.main(new String[1]);
        PassFly[0] = (Integer.parseInt(AdultsF.getSelectedItem().toString()) + Integer.parseInt(ChildrenF.getSelectedItem().toString()))+"";
        PassFly[1] = ClassF.getSelectedItem().toString();
        PassFly[2] = MDepF.getSelectedItem().toString() + " " + DayDepF.getSelectedItem().toString()
        + " of " + YDepF.getSelectedItem().toString();
        for(Fly It : main.Flies.values()){
            if(It.getDPlace().equals(DPlaceF.getSelectedValue()) && It.getAPlace().equals(APlaceF.getSelectedIndex())){
                switch(ClassF.getSelectedIndex()){
                    case 0:
                    PassFly[3] = It.getPrice();
                    break;
                    case 1:
                    PassFly[3] = (Integer.parseInt(It.getPrice())*.8)+"";
                    break;
                    case 2:
                    PassFly[3] = (Integer.parseInt(It.getPrice())*.5)+"";
                    break;
                }
            }
        }
    }//GEN-LAST:event_BuyFActionPerformed

    private void DayDepFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayDepFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayDepFActionPerformed

    private void AFSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AFSearchKeyReleased
        // TODO add your handling code here:
        SearchFields(AFSearch, APlaceF, ArriveF());
    }//GEN-LAST:event_AFSearchKeyReleased

    private void DepFSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DepFSearchKeyReleased
        // TODO add your handling code here:
        SearchFields(DepFSearch, DPlaceF, DepartureF());
        AFSearch.setEnabled(false);
        APlaceF.setEnabled(false);
        
    }//GEN-LAST:event_DepFSearchKeyReleased

    private void DepFSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepFSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepFSearchActionPerformed

    private void RoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomTypeActionPerformed

    private void HotelListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_HotelListValueChanged
        // TODO add your handling code here:
        ComboInDayH.setEnabled(true);
        ComboOutDayH.setEnabled(true);
        ComboInMH.setEnabled(true);
        ComboOutMH.setEnabled(true);
        ComboInYH.setEnabled(true);
        ComboOutYH.setEnabled(true);
        RoomType.setEnabled(true);
        AdultsH.setEnabled(true);
        RoomNH.setEnabled(true);
        ChildrenH.setEnabled(true);
        ButtonH.setEnabled(true);
    }//GEN-LAST:event_HotelListValueChanged

    private void ButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHActionPerformed
        // TODO add your handling code here:
        Integer Day1 = (ComboInDayH.getSelectedIndex()+1) +
        (30*(ComboInMH.getSelectedIndex()+1)) +
        ((ComboInYH.getSelectedIndex()+1)*360);
        Integer Day2 = (ComboOutDayH.getSelectedIndex()+1) +
        (30*(ComboOutMH.getSelectedIndex()+1)) +
        ((ComboOutYH.getSelectedIndex()+1)*360);
        PassHotel[0] = (Day2-Day1)+"";
        PassHotel[1] = (Integer.parseInt((String)AdultsH.getSelectedItem()) +
            Integer.parseInt((String)ChildrenH.getSelectedItem()))+"";
        PassHotel[2] = (String)RoomNH.getSelectedItem();
        for(Hotel It: main.Hotels.values()){
            if(HotelList.getSelectedValue().equals(It.getName() + " - " + It.getPlace())){
                PassHotel[3] = It.getLocation();
                PassHotel[4] = It.getStars();
            }
        }
        PassHotel[5] = PriceH + "";
        System.out.println(PassHotel[0]);
        SeenHotel.main(new String[1]);
        this.hide();
        BuyHotel();
        //Services.put(Services.size(), ServiceToAdd);
    }//GEN-LAST:event_ButtonHActionPerformed

    private void InsuranceListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_InsuranceListValueChanged
        // TODO add your handling code here:
        SelectedPackage = InsuranceList.getSelectedValue();
        Integer DIn = (DIIn.getSelectedIndex()+1) + ((MIIn.getSelectedIndex()+1)*30)
                + ((YIIn.getSelectedIndex()+1)*360);
        Integer DOut = (DIOut.getSelectedIndex()+1) + ((MIOut.getSelectedIndex()+1)*30)
                + ((YIOut.getSelectedIndex()+1)*360);
        DaysI = DOut - DIn;
        PeopleI = (String)NPeopleI.getSelectedItem();
        DIIn.setEnabled(true);
        MIIn.setEnabled(true);
        YIIn.setEnabled(true);
        DIOut.setEnabled(true);
        MIOut.setEnabled(true);
        YIOut.setEnabled(true);
        NPeopleI.setEnabled(true);
        BuyI.setEnabled(true);
    }//GEN-LAST:event_InsuranceListValueChanged

    private void DestTInsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DestTInsItemStateChanged
        // TODO add your handling code here:
        //System.out.println(DestTIns.getSelectedItem().toString());
        InsuranceList.setEnabled(true);
        PlaceI = (String)DestTIns.getSelectedItem();
        Packages = new HashMap<>();
        for (Safe It: main.Safes.values()){
            if(PlaceI.equals(It.getPlace())){
                Packages.put(Packages.size(), It.getSafeCompany() + " - " + It.getName());
            }
        }
        InsuranceList.setModel(InsurancesList());
    }//GEN-LAST:event_DestTInsItemStateChanged

    private void AirportsTOptionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AirportsTOptionStateChanged
        // TODO add your handling code here:
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

    private void HotelsTOptionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_HotelsTOptionStateChanged
        // TODO add your handling code here:
        TransferModel1 = new DefaultListModel();
        if(HotelsTOption.isSelected()){
            
            for(Hotel It : main.Hotels.values()){
                TransferModel1.addElement(It.getPlace()+ ", " + It.getName());
            }
            try{
                TransferList1.setModel(TransferModel1);
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
        TransferList1.setEnabled(true);
        FTrSearch.setEnabled(true);
    }//GEN-LAST:event_HotelsTOptionStateChanged

    private void TransferList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransferList1ValueChanged
        // TODO add your handling code here:
        TransferModel2 = new DefaultListModel();
        TransferList2.setEnabled(true);
        TTrSearch.setEnabled(true);
        try{
            //SearchTField2.setEnabled(true);
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
                        TransferModel2.addElement(It);
                    }
                }
                TransferList2.setModel(TransferModel2);
            }else{
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
                        TransferModel2.addElement(Aux$ + ", " + It.getName());
                    }
                }
                TransferList2.setModel(TransferModel2);
            }
            TransferList2.setEnabled(true);
        }catch(Exception ex){
            
        }
        //SearchTField2.setEnabled(true);
    }//GEN-LAST:event_TransferList1ValueChanged

    private void SearchHFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchHFieldKeyReleased
        // TODO add your handling code here:
        SearchFields(SearchHField, HotelList, main.HotelList());
    }//GEN-LAST:event_SearchHFieldKeyReleased

    private void SearchHFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchHFieldFocusGained
        // TODO add your handling code here:
        SearchHField.setText("");
        SearchHField.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_SearchHFieldFocusGained

    private void SearchHFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchHFieldFocusLost
        // TODO add your handling code here:
        if(SearchHField.getText().length() == 0){
            SearchHField.setForeground(new java.awt.Color(204, 204, 204));
            SearchHField.setText("Search hotel");
        }
    }//GEN-LAST:event_SearchHFieldFocusLost

    private void AFSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AFSearchFocusGained
        // TODO add your handling code here:
        AFSearch.setText("");
        AFSearch.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_AFSearchFocusGained

    private void AFSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AFSearchFocusLost
        // TODO add your handling code here:
        if(AFSearch.getText().length() == 0){
            AFSearch.setText("Search departure place");
            AFSearch.setForeground(new java.awt.Color(204, 204, 204));
        }
    }//GEN-LAST:event_AFSearchFocusLost

    private void DepFSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DepFSearchFocusGained
        // TODO add your handling code here:
        DepFSearch.setText("");
        DepFSearch.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_DepFSearchFocusGained

    private void DepFSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DepFSearchFocusLost
        // TODO add your handling code here:
        if(DepFSearch.getText().length() == 0){
            DepFSearch.setText("Search departure place");
            DepFSearch.setForeground(new java.awt.Color(204, 204, 204));
        }
    }//GEN-LAST:event_DepFSearchFocusLost

    private void searchCarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCarFocusLost
        // TODO add your handling code here:
     
        if(searchCar.getText().length() == 0){
            searchCar.setText("Pick up location (Enter a city or airport)");
            searchCar.setForeground(new java.awt.Color(204, 204, 204));
        }
    }//GEN-LAST:event_searchCarFocusLost

    private void searchCarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCarFocusGained
        // TODO add your handling code here:
        searchCar.setText("");
        searchCar.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_searchCarFocusGained

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
//<editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AFSearch;
    private javax.swing.JList<String> APlaceF;
    private javax.swing.JComboBox<String> AdultsF;
    private javax.swing.JComboBox<String> AdultsH;
    private javax.swing.JComboBox<String> AdultsTr;
    private javax.swing.JRadioButton AirportsTOption;
    private javax.swing.JButton ButtonH;
    private javax.swing.JButton BuyC;
    private javax.swing.JButton BuyF;
    private javax.swing.JButton BuyI;
    private javax.swing.JButton BuyT;
    private javax.swing.JTextField CapacityC;
    private javax.swing.JComboBox<String> CarDIn;
    private javax.swing.JComboBox<String> CarDOut;
    private javax.swing.JList<String> CarList;
    private javax.swing.JComboBox<String> CarMIn;
    private javax.swing.JComboBox<String> CarMOut;
    private javax.swing.JComboBox<String> CarYIn;
    private javax.swing.JComboBox<String> CarYOut;
    private javax.swing.JComboBox<String> ChildrenF;
    private javax.swing.JComboBox<String> ChildrenH;
    private javax.swing.JComboBox<String> ChildrenTr;
    private javax.swing.JComboBox<String> ClassF;
    private javax.swing.JComboBox<String> ComboInDayH;
    private javax.swing.JComboBox<String> ComboInMH;
    private javax.swing.JComboBox<String> ComboInYH;
    private javax.swing.JComboBox<String> ComboOutDayH;
    private javax.swing.JComboBox<String> ComboOutMH;
    private javax.swing.JComboBox<String> ComboOutYH;
    private javax.swing.JList<String> CountryCList;
    private javax.swing.JComboBox<String> DIIn;
    private javax.swing.JComboBox<String> DIOut;
    private javax.swing.JList<String> DPlaceF;
    private javax.swing.JComboBox<String> DayDepF;
    private javax.swing.JComboBox<String> DayDestF;
    private javax.swing.JTextField DepFSearch;
    private javax.swing.JComboBox<String> DepTrDay;
    private javax.swing.JComboBox<String> DepTrHour;
    private javax.swing.JComboBox<String> DepTrM;
    private javax.swing.JComboBox<String> DepTrY;
    private javax.swing.JComboBox<String> DestTIns;
    private javax.swing.JTextField FTrSearch;
    private javax.swing.JList<String> HotelList;
    private javax.swing.JRadioButton HotelsTOption;
    private javax.swing.JList<String> InsuranceList;
    private javax.swing.JButton LogOut;
    private javax.swing.JComboBox<String> MDepF;
    private javax.swing.JComboBox<String> MDestF;
    private javax.swing.JComboBox<String> MIIn;
    private javax.swing.JComboBox<String> MIOut;
    private javax.swing.JComboBox<String> NPeopleI;
    private javax.swing.JComboBox<String> RoomNH;
    private javax.swing.JComboBox<String> RoomType;
    private javax.swing.JTextField SearchHField;
    private javax.swing.JTextField TTrSearch;
    private javax.swing.JList<String> TransferList1;
    private javax.swing.JList<String> TransferList2;
    private javax.swing.JComboBox<String> YDepF;
    private javax.swing.JComboBox<String> YDestF;
    private javax.swing.JComboBox<String> YIIn;
    private javax.swing.JComboBox<String> YIOut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField searchCar;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
