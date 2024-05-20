package gradingsystem;

import java.sql.*;
import gradingsystem.Entities.*;
import gradingsystem.GUI.GUI;
import gradingsystem.controller.AddCourseController;
import gradingsystem.controller.AddGradedCourseController;

public class DBConnector {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public static int universityID;
    
    public DBConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grading_system", "root", "");
            statement = connection.createStatement();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public void getData(){
        try{
            getDepartments();
            getStudents();
            getInstructors();
            getCourses();
            getGradedCourses();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public boolean isThisTheFirstTimeToUseTheApp(){
        try{
            String query = "select count(*) as total from university";
            
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String count = resultSet.getString("total");
            
            System.out.println(count);
            if(Integer.parseInt(count) > 0){
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return true;
        }
    }
    
    public void updateUniversityID(String Name, String Address){
        try{
            String query = "select Uid from university "
                    + "where Name = '" + Name + "' "
                    + "and Address = '" + Address + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Uid = resultSet.getString("Uid");
            
            universityID = Integer.parseInt(Uid);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public void updateStudentGPA(int pid, float gpa){
        try{
            String query = "UPDATE `student` SET `GPA` = '" + gpa + "' WHERE `student`.`Pid` = " + pid;
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            
            // execute the preparedstatement
            preparedStmt.execute(); 

        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public void updateAdministration(int Did, int Mid){
        try{
            String query = "UPDATE `department` SET `Mid` = '" + Mid + "' WHERE `Department`.`Did` = " + Did;
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            
            // execute the preparedstatement
            preparedStmt.execute(); 

        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public int addUniversity(String Name, String Address){
        try{
            String query = "INSERT INTO `university` (`Name`, `Address`) VALUES (?, ?)";
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Name);
            preparedStmt.setString (2, Address);

            // execute the preparedstatement
            preparedStmt.execute();     
            
            query = "select Uid from university "
                    + "where Name = '" + Name + "' "
                    + "and Address = '" + Address + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Uid = resultSet.getString("Uid");
            
            universityID = Integer.parseInt(Uid);
            
            return Integer.parseInt(Uid);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
    
    public int addAdministration(String Name, String Email, String Description, String Uid){
        try{
            String query = "INSERT INTO `department` (`Name`, `Email`, `Description`, `Uid`) VALUES (?, ?, ?, ?)";
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Name);
            preparedStmt.setString (2, Email);
            preparedStmt.setString (3, Description);
            preparedStmt.setString (4, Uid);

            // execute the preparedstatement
            preparedStmt.execute();     
            
            query = "select Did from Department "
                    + "where Name = '" + Name + "' "
                    + "and Email = '" + Email + "' "
                    + "and Description = '" + Description + "' "
                    + "and Uid = '" + Uid + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Did = resultSet.getString("Did");
            
            return Integer.parseInt(Did);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
      
    public int addDirector(String Fname, String Mname, String Lname, String Email, String Gender, String Telephone, String Did, String Salary){
        try{
            String query = "INSERT INTO `person` (`Fname`, `Mname`, `Lname`, `Email`, `Gender`, `Telephone`, `Did`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Fname);
            preparedStmt.setString (2, Mname);
            preparedStmt.setString (3, Lname);
            preparedStmt.setString (4, Email);
            preparedStmt.setString (5, Gender);
            preparedStmt.setString (6, Telephone);
            preparedStmt.setString (7, Did);

            // execute the preparedstatement
            preparedStmt.execute(); 
            
            
            query = "select pid from Person "
                    + "where Fname = '" + Fname + "' "
                    + "and Mname = '" + Mname + "' "
                    + "and Lname = '" + Lname + "' "
                    + "and Email = '" + Email + "' "
                    + "and Gender = '" + Gender + "' "
                    + "and Telephone = '" + Telephone + "' "
                    + "and Did = '" + Did + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Pid = resultSet.getString("Pid");
            
            query = "INSERT INTO `instructor` (`Pid`, `Salary`) VALUES (?, ?)";

            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Pid);
            preparedStmt.setString (2, Salary);

            // execute the preparedstatement
            preparedStmt.execute(); 
            
            return Integer.parseInt(Pid);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
    
    public boolean removeDepartment(int Did){
        try{
            String query = "DELETE FROM `department` WHERE `Did` = " + Did;            
            statement.executeUpdate(query);
            
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }            
    }
    
    public boolean removeStudent(int Pid){
        try{
            String query = "DELETE FROM `person` WHERE `Pid` = " + Pid;            
            statement.executeUpdate(query);
            
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public boolean removeCourse(int Cid){
        try{
            String query = "DELETE FROM `course` WHERE `Cid` = " + Cid;            
            statement.executeUpdate(query);
            
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public boolean removeGradedCourse(int Pid, int Cid){
        try{
            String query = "DELETE FROM `student_takes_course` WHERE `Pid` = " + Pid +
                            " AND `Cid` = " + Cid;            
            statement.executeUpdate(query);
            
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public int addDepartment(String Name, String Email, String Mid, String Description, String Uid){
        try{
            String query = "INSERT INTO `department` (`Name`, `Email`, `Mid`, `Description`, `Uid`) VALUES (?, ?, ?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Name);
            preparedStmt.setString (2, Email);
            preparedStmt.setString (3, Mid);
            preparedStmt.setString (4, Description);
            preparedStmt.setString (5, this.universityID+"");

            // execute the preparedstatement
            preparedStmt.execute();     
            
            query = "select Did from Department "
                    + "where Name = '" + Name + "' "
                    + "and Email = '" + Email + "' "
                    + "and Mid = '" + Mid + "' "
                    + "and Description = '" + Description + "' "
                    + "and Uid = '" + Uid + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Did = resultSet.getString("Did");
            
            return Integer.parseInt(Did);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
    
    public int addStudent(String Fname, String Mname, String Lname, String Email, String Gender, String Telephone, String Did, String GPA){
        try{
            String query = "INSERT INTO `person` (`Fname`, `Mname`, `Lname`, `Email`, `Gender`, `Telephone`, `Did`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Fname);
            preparedStmt.setString (2, Mname);
            preparedStmt.setString (3, Lname);
            preparedStmt.setString (4, Email);
            preparedStmt.setString (5, Gender);
            preparedStmt.setString (6, Telephone);
            preparedStmt.setString (7, Did);

            // execute the preparedstatement
            preparedStmt.execute(); 
            
            
            query = "select pid from Person "
                    + "where Fname = '" + Fname + "' "
                    + "and Mname = '" + Mname + "' "
                    + "and Lname = '" + Lname + "' "
                    + "and Email = '" + Email + "' "
                    + "and Gender = '" + Gender + "' "
                    + "and Telephone = '" + Telephone + "' "
                    + "and Did = '" + Did + "'";
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String Pid = resultSet.getString("Pid");
            
            query = "INSERT INTO `student` (`Pid`, `GPA`) VALUES (?, ?)";

            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Pid);
            preparedStmt.setString (2, GPA);

            // execute the preparedstatement
            preparedStmt.execute(); 
            
            return Integer.parseInt(Pid);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
    
    public int addCourse(String Name, String CreditHrs, String Pid, String Did){
        try{
            String query = "INSERT INTO `course` (`Name`, `CreditHrs`, `Pid`, `Did`) VALUES (?, ?, ?, ?)";
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Name);
            preparedStmt.setString (2, CreditHrs);
            preparedStmt.setString (3, Pid);
            preparedStmt.setString (4, Did);

            // execute the preparedstatement
            preparedStmt.execute();    
            
            query = "select cid from course "
                    + "where Name = '" + Name + "' "
                    + "and CreditHrs = '" + CreditHrs + "' "
                    + "and Pid = '" + Pid + "' "
                    + "and Did = '" + Did + "'";  
            
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            String cid = resultSet.getString("cid");  
            
            return Integer.parseInt(cid);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return -1;
        }
    }
    
    public void addGradedCourse(String Pid, String Cid, String Grade){
        try{
            String query = "INSERT INTO `student_takes_course` (`Pid`, `Cid`, `Grade`) VALUES (?, ?, ?)";
            

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, Pid);
            preparedStmt.setString (2, Cid);
            preparedStmt.setString (3, Grade);

            // execute the preparedstatement
            preparedStmt.execute();        
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    private void getDepartments() throws SQLException{
            String query = "select * from department";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String id = resultSet.getString("Did");
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String description = resultSet.getString("Description");
                String Uid = resultSet.getString("Uid");
                String Mid = resultSet.getString("Mid");
                
                new Departement(Integer.parseInt(id), name, description, email, Integer.parseInt(Mid), Integer.parseInt(Uid));
            }
    }
    
    private void getStudents() throws SQLException{
            String query = "select person.pid, person.Fname, person.Mname, person.Lname, person.email, person.gender, person.telephone, person.Did, student.gpa "
                    + "from Student, Person "
                    + "where person.pid = student.pid";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String id = resultSet.getString("Pid");
                String Fname = resultSet.getString("Fname");
                String Mname = resultSet.getString("Mname");
                String Lname = resultSet.getString("Lname");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String telephone = resultSet.getString("Telephone");
                String Did = resultSet.getString("Did");
                String gpa = resultSet.getString("GPA");
                
                new Student(Integer.parseInt(id), Fname, Mname, Lname, gender, email, telephone, Departement.getDepartement(Integer.parseInt(Did)), Float.parseFloat(gpa));
            }
    }
    
    private void getInstructors() throws SQLException{
            String query = "select person.pid, person.Fname, person.Mname, person.Lname, person.email, person.gender, person.telephone, person.Did, instructor.salary "
                    + "from instructor, Person "
                    + "where person.pid = instructor.pid";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String id = resultSet.getString("Pid");
                String Fname = resultSet.getString("Fname");
                String Mname = resultSet.getString("Mname");
                String Lname = resultSet.getString("Lname");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String telephone = resultSet.getString("Telephone");
                String Did = resultSet.getString("Did");
                String salary = resultSet.getString("Salary");
                
                new Instructor(Integer.parseInt(id), Fname, Mname, Lname, gender, email, telephone, Departement.getDepartement(Integer.parseInt(Did)), Integer.parseInt(salary));
            }
    }
    
    private void getCourses() throws SQLException{
            String query = "select * from course";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String id = resultSet.getString("Cid");
                String name = resultSet.getString("Name");
                String creditHrs = resultSet.getString("creditHrs");
                String Pid = resultSet.getString("Pid");
                String Did = resultSet.getString("Did");
                
                AddCourseController.addCourse(Integer.parseInt(id), name, Integer.parseInt(creditHrs), Integer.parseInt(Did), Integer.parseInt(Pid));
            }
    }
    
    private void getGradedCourses() throws SQLException{
            String query = "select * from student_takes_course";
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String id = resultSet.getString("Pid");                
                String Cid = resultSet.getString("Cid");
                String grade = resultSet.getString("Grade");
                
                AddGradedCourseController.addCourse(Integer.parseInt(id), Integer.parseInt(Cid), Float.parseFloat(grade));
            }
    }

    public static int getUniversityID() {
        return universityID;
    }
}
