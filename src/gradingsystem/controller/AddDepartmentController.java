package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;


public class AddDepartmentController {
    public static void addDepartment(String id, String name, String description, String email, String Mid, String Uid){
        Departement d = new Departement(Integer.parseInt(id),name, description,email, Integer.parseInt(Mid), Integer.parseInt(Uid));
    }
    
    public static String addDepartmentToDatabase(String name, String description, String email, String Mid, String Uid){
        DBConnector db = new DBConnector();
        
        int Did = db.addDepartment(name, email, Mid, description, Uid);
        
        new Departement(Did, name, description, email, Integer.parseInt(Mid), Integer.parseInt(Uid));
        
        return name;
    }
}
