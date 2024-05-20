package gradingsystem.controller;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Student;

public class RemoveStudentController {
    public static boolean removeStudent(int selectedStudent){
        Student s = Student.getStudent(selectedStudent);
        
        DBConnector db = new DBConnector();
        
        boolean remove = db.removeStudent(selectedStudent);
        
        if(remove){
            s.removeStudent();
            return true;
        }
        return false;
    }
}
