package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Student extends Person implements Serializable{
    
    private float gpa;

    private ArrayList<GradedCourse> gradedCourses = new ArrayList<GradedCourse>(); 
    private static ArrayList<Student> students = new ArrayList<Student>();


    public Student(int id, String fName, String mName, String lName, String gender, String email, String number, Departement department, float gpa) {
        super(id, fName, mName, lName, gender, email, number, department);

        this.gpa = gpa;
        students.add(this);
    }

    public void setGradedcourses(ArrayList<GradedCourse> gradedCourses) {
        this.gradedCourses = gradedCourses;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public float getGpa() {
        return gpa;
    }

    public ArrayList<GradedCourse> getGradedcourses() {
        if(gradedCourses.isEmpty() || gradedCourses == null){
            return null;
        }
        return gradedCourses;
    }


    public static ArrayList<Student> getStudents() {
        return students;
    }

    public void assignCourse(GradedCourse gc){
       
       this.gradedCourses.add(gc); 
    }
    
    public void removeStudent(){
        students.remove(this);
    }
    
    public void removeGradedCourse(int index){
        for (int i = 0; i < gradedCourses.size(); i++) {
            if( gradedCourses.get(i).getCourse().getId() == index ){
                gradedCourses.remove(i);
            }
        }
    }

    public static Student getStudent(int Pid){
        for (int i = 0; i < students.size(); i++) {
            if( students.get(i).getId() == Pid ){
                return students.get(i);
            }
        }
        return null;
    }

    public static Student getStudent(String name){
        if(name != null){
            for (Student student : students) {
                if( student.getName().equals(name) ){
                    return student;
                }
            }            
        }
        return null;
    }


    @Override
    public String toString(){

       String st = super.toString() + "\n" + "GPA: " + this.getGpa();

       return st;
    }  
   
}
     
