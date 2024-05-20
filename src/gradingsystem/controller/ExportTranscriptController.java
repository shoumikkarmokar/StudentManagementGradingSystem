package gradingsystem.controller;

import gradingsystem.Entities.Student;
import java.io.*;

public class ExportTranscriptController {
    public static void exportTranscript(int selectedStudent){
        try {
            Student s = Student.getStudent(selectedStudent);
            
            FileWriter fw = new FileWriter(s.getId() + "-" + s.getName() + ".txt", false);
            PrintWriter pw = new PrintWriter(fw, true);
            pw.println("Student's Information : ");
            pw.println("------------------------");
            pw.println();
            pw.println("ID: " + s.getId());
            pw.println("Name: " + s.getName());
            pw.println("Gender: " + s.getGender());
            pw.println("Email: " + s.getEmail());
            pw.println("Phone Number: " + s.getNumber());
            pw.println("Department: " + s.getDepartment().getName());
            pw.println("Accumulative GPA: " + s.getGpa());
            
            pw.println();
            pw.println("--------------------------------------------------------------------------");
            pw.println();
            
            pw.println("Studied Courses : ");
            pw.println("------------------");
            pw.println();
            pw.println("  Grade       Course Name");
            pw.println("---------    --------------");
            pw.println();
            for (int i = 0; i < s.getGradedcourses().size(); i++) {
                
                pw.println("  " + s.getGradedcourses().get(i).getGrade() + "        " + s.getGradedcourses().get(i).getCourse().getName());
            }
            
            pw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println("Error in Exporting");
        }
    }
}
