package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable{
    private int id;
    private String fName;
    private String mName;
    private String lName;
    private String gender;
    private String email;
    private String number;
    private Departement department;



    public Person(int id, String fName, String mName, String lName, String gender, String email, String number, Departement department) {
        this.id = id;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.gender = gender;
        this.email = email;
        this.number = number;
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getmName() {
        return mName;
    }

    public String getName() {
        return fName + " " + mName + " " + lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Departement getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }


    @Override
    public String toString(){

       String st = "ID: " + this.getId() +"\n" + "Name: " + this.getName() + "\n" +
                   "Email: " + this.getEmail() + "\n" + "Phone Number: " + this.getNumber()+ "\n" + "Department: " + this.getDepartment().getName();

       return st;
    }  
   
}
     
