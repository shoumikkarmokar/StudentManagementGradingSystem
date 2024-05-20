package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class RemoveDepartmentController {
    public static boolean removeDepartment(int selectedIndex){
        Departement d = Departement.getDepartement(selectedIndex);
        
        DBConnector db = new DBConnector();        
        
        boolean remove = db.removeDepartment(selectedIndex);
        
        if(remove){
            d.removeDepartment();
            return true;
        }
        return false;
    }
}
