package gradingsystem.Entities;

import java.io.Serializable;

public class Course implements Serializable{
    
    private int id;
    private String name;
    private int creditHrs;
    private Instructor instructor;

    public Course(int id, String name, int creditHrs, int instructorId) {
        this.id = id;
        this.name = name;
        this.creditHrs = creditHrs;
        
        instructor = Instructor.getInstructor(instructorId);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCreditHrs() {
        return creditHrs;
    }
}
