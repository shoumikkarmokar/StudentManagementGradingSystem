package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Departement implements Serializable {
    private int id;
    private String name;
    private String description;
    private String email;
    private int universityId;
    private int instructorId;
    
    private ArrayList<Course> courses = new ArrayList<Course>();
    private static ArrayList<Departement> departements = new ArrayList<Departement>();



    public Departement(int id, String name, String description, String email, int Mid, int Uid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.instructorId = Mid;
        this.universityId = Uid;

        departements.add(this);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public static void setDepartements(ArrayList<Departement> depts) {
        departements = depts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String getManagerName() {
        return Instructor.getInstructor(instructorId).getName();
    }
    
    public static ArrayList<Departement> getDepartements() {
        return departements;
    }
    
    public void removeDepartment(){
        departements.remove(this);
    }

    public void addCourse(Course c){
       courses.add(c);
    }

    public void removeCourse(int index){
        for (int i = 0; i < courses.size(); i++) {
            if( courses.get(i).getId() == index ){
                courses.remove(i);
            }
        }
    }

    public static Departement getDepartement(String name){
        if(name != null){
            for (int i = 0; i < departements.size(); i++) {
                if( departements.get(i).getName().equals(name) ){
                    return departements.get(i);
                }
            }            
        }
        return null;
    }

    public static Departement getDepartement(int Did){
        for (int i = 0; i < departements.size(); i++) {
            if( departements.get(i).getId() == Did ){
                return departements.get(i);
            }
        }
        return null;
    }

    public static Course getCourse(String name){
        if(name != null){
            for (int i = 0; i < departements.size(); i++) {
                for (Course course : departements.get(i).courses) {
                    if( course.getName().equals(name) ){
                        return course;
                    }
                }
            }            
        }
        return null;
    }

    public static Course getCourse(int Cid){
        for (int i = 0; i < departements.size(); i++) {
            for (Course course : departements.get(i).courses) {
                if( course.getId() == Cid ){
                    return course;
                }
            }
        }     
        return null;
    }
    
    @Override
   public String toString(){
   
       String st = "ID: " + this.getId() +"\n" + "Name: " + this.getName() + "\n" +
                    "Description: " + this.getDescription();
   
       return st;
   }  

}
