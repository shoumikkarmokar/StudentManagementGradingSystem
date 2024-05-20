package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Instructor extends Person implements Serializable{
    private int salary;
    
    private static ArrayList<Instructor> instructors = new ArrayList<Instructor>();

    public Instructor(int id, String fName, String mName, String lName, String gender, String email, String number, Departement department, int salary) {
        super(id, fName, mName, lName, gender, email, number, department);

        this.salary = salary;
        instructors.add(this);
    }

    public static void setInstructors(ArrayList<Instructor> instructors) {
        Instructor.instructors = instructors;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    
    public static ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    
    public void removeInstructor(){
        instructors.remove(this);
    }
    
    public static Instructor getInstructor(int id){
        for (int i = 0; i < instructors.size(); i++) {
            if( instructors.get(i).getId() == id ){
                return instructors.get(i);
            }
        }
        return null;
    }

    public static Instructor getInstructor(String name){
        if(name != null){
            for (int i = 0; i < instructors.size(); i++) {
                if( instructors.get(i).getName().equals(name) ){
                    return instructors.get(i);
                }
            }            
        }
        return null;
    }

    @Override
    public String toString(){

       String st = super.toString() + "\n" + "Salary: " + this.getSalary();

       return st;
    }  
   
}
     
