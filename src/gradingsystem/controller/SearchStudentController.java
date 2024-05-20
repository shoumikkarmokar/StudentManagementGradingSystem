package gradingsystem.controller;

import gradingsystem.Entities.Student;
import java.util.ArrayList;

public class SearchStudentController {
    public static int searchStudent(String name){
        int idx = -1;
        ArrayList<Student> ss = Student.getStudents();
        for(int i=0; i<ss.size(); i++){
            if(name.equalsIgnoreCase(ss.get(i).getName())) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
