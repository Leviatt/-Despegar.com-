package data;

import java.io.*;

public class User implements Serializable{
    private String User;
    private String Password;
    private String Name;
    private String LastName;
    private String Phone;
    private String CellPhone;
    private String Address;
    private String Email;
    private String Credit;
    private String Id;
    private boolean admin;

    public String getEmail() {
        return Email;
    }

    public String getId() {
        return Id;
    }

    public String getLastName() {
        return LastName;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUser() {
        return User;
    }

    public String getCredit() {
        return Credit;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public String getAddress() {
        return Address;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setCellPhone(String CellPhone) {
        this.CellPhone = CellPhone;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCredit(String Credit) {
        this.Credit = Credit;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    

    public User(String User, String Password, String Name, String LastName, String Phone, String CellPhone, String Address, String Email, String Credit, String Id, boolean admin) {
        this.User = User;
        this.Password = Password;
        this.Name = Name;
        this.LastName = LastName;
        this.Phone = Phone;
        this.CellPhone = CellPhone;
        this.Address = Address;
        this.Email = Email;
        this.Credit = Credit;
        this.Id = Id;
        this.admin = admin;
        
        
    }

    
}