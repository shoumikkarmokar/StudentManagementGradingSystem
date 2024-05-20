package gradingsystem.Entities;

import java.io.Serializable;
import gradingsystem.Entities.Departement;

public class GradedCourse implements Serializable {
    private Course course;
    private Student student;
    private float grade;

    public GradedCourse(int Cid, int Pid, float grade) {
        
        course = Departement.getCourse(Cid);
        
        student = Student.getStudent(Pid);
        this.grade = grade;
        
        student.assignCourse(this);
    }

    public float getGrade() {
        return this.grade;
    }

    public Course getCourse() {
        return course;
    }  
}
