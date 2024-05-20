package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class AddStudentController {
    public static void addStudent(String id, String Fname, String Mname, String Lname, String gender, String email, String number, int selectedDept, float GPA){
        Student s = new Student(Integer.parseInt(id), Fname, Mname, Lname, gender, email, number, Departement.getDepartements().get(selectedDept), GPA);
    }
    
    public static String addStudentToDatabase(String Fname, String Mname, String Lname, String email, String gender, String telephone, String Did){
        DBConnector db = new DBConnector();
        
        int studentID = db.addStudent(Fname, Mname, Lname, email, gender, telephone, Did, 0 + "");
        
        new Student(studentID, Fname, Mname, Lname, gender, email, telephone, Departement.getDepartement(Integer.parseInt(Did)), 0);
        
        return Fname + " " + Mname + " " + Lname;
    }
    
    static public DefaultComboBoxModel getDepartmentsNames(){
        DefaultComboBoxModel noIdea = new DefaultComboBoxModel();
        ArrayList<Departement> ds = Departement.getDepartements();
        for(int i=0; i<ds.size(); i++){
            noIdea.addElement(ds.get(i).getName());
        }
        return noIdea;
    }
}
