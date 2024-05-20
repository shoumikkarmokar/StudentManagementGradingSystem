package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Instructor;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AddInstructorController {
    public static String addDirector(String Fname, String Mname, String Lname, String email, String gender, String telephone, String salary){
        DBConnector db = new DBConnector();
        
        int universityID = db.addUniversity("Ain Shams University", "1 Al-Sarayyat St, Abbassiya, Cairo 11517, Egypt");
        int administrationID = db.addAdministration("Administration", email, "Welcome to Ain Shams University Administration.", universityID + "");
        int directorID = db.addDirector(Fname, Mname, Lname, email, gender, telephone, administrationID + "", salary + "");
        db.updateAdministration(administrationID, directorID);
        
        Departement administration = new Departement(administrationID, "Administration", "Welcome to Ain Shams University Administration.", email, directorID, 1);
        Instructor Director = new Instructor(directorID, Fname, Mname, Lname, gender, email, telephone, administration, Integer.parseInt(salary));
        
        return "Administration";
    }
}
