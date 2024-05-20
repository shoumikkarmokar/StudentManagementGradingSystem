package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Hossam
 */


public class DisplayDepartmentController {
    static public DefaultListModel getDepartmentsNames(){
        DefaultListModel noIdea = new DefaultListModel();
        ArrayList<Departement> ds = Departement.getDepartements();
        for(int i=0; i<ds.size(); i++){
            noIdea.addElement(ds.get(i).getName());
        }
        return noIdea;
    }
    
    
    static public String[] getDepartmentInfo(int i){
        
        Departement d =  Departement.getDepartement(i);
        String[] str = new String[4];
        str[0] = d.getName();
        str[1] = d.getManagerName();
        str[2] = d.getEmail();
        str[3] = d.getDescription();
        return str;
    }
    
}
