package gradingsystem.GUI;

import gradingsystem.Entities.Course;
import gradingsystem.Entities.GradedCourse;
import gradingsystem.Entities.Instructor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gradingsystem.controller.AddCourseController;

public class NewCourse extends JFrame{   
    
    private JLabel lblName = new JLabel("Name : ");
    private JLabel lblcreditHrs= new JLabel("Credit Hours : ");
    private JLabel lblInstructor= new JLabel("Instructor : ");
    
    private JTextField txtName = new JTextField("Enter Name Here...");
    private JIntegerNumberTextField txtcreditHrs = new JIntegerNumberTextField("Enter Credit Hours Here...");
    
    private DefaultComboBoxModel modelInstructors = AddCourseController.getInstructorNames();
    private JComboBox<String> comboInstructors = new JComboBox(modelInstructors);
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private int selectedIndex;
    
    private DefaultListModel dlm;
    
    
    
   // New Course Variables 
    private String name = "None";
    
    
    
    public NewCourse(int selectedIndex, DefaultListModel d){
        this.selectedIndex = selectedIndex;
        dlm = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Course");
        this.setBounds(300, 300, 600, 250);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/course.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        lblcreditHrs.setBounds(100,60,100,30);
        lblInstructor.setBounds(100,105,100,30);
        
        c.add(lblName);
        c.add(lblcreditHrs);
        c.add(lblInstructor);
        
        txtName.setBounds(210,15,300,30);
        txtcreditHrs.setBounds(210,60,300,30);
        comboInstructors.setBounds(210, 105, 300, 30);
        
        c.add(txtName);
        c.add(txtcreditHrs);
        c.add(comboInstructors);

        
        btnOk.setBounds(260,160,100,30);
        btnCancel.setBounds(370,160,100,30);
        c.add(btnOk);
        c.add(btnCancel);
        
        
        //-----Action Listeners-----
        
        
        txtName.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtName.getText().equals("Enter Name Here...") )
                    txtName.setText("");
            }
        });
        
        txtcreditHrs.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtcreditHrs.getText().equals("Enter Credit Hours Here...") )
                    txtcreditHrs.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if( txtName.getText().equals("") || txtName.getText().equals("Enter Name Here...") ){
                    JOptionPane.showMessageDialog(NewCourse.this, "Enter Course Name!");
                    txtName.requestFocus();
                    return;
                }
                if( txtcreditHrs.getText().equals("") || txtcreditHrs.getText().equals("Enter Credit Hours Here...") ){
                    JOptionPane.showMessageDialog(NewCourse.this, "Enter Credit Hours Name!");
                    txtcreditHrs.requestFocus();
                    return;
                }
                else{
                    
                    String s = AddCourseController.addCourseToDatabase(txtName.getText(), 
                            txtcreditHrs.getText(), Instructor.getInstructor((String)comboInstructors.getSelectedItem()).getId() + "", selectedIndex + "");
                   
                    dlm.addElement(s);
                    NewCourse.this.dispatchEvent(new WindowEvent(NewCourse.this, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewCourse.this.dispatchEvent(new WindowEvent(NewCourse.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
  
    
    
    // Move this method to the controller class
//    public static void addNewCourse(NewCourse nc){
//        students.add(nc);
//        try {
//            FileWriter fw = new FileWriter("Courses.csv", true);
//            PrintWriter pw = new PrintWriter(fw, true);
//            pw.println(ns.name);
//            pw.close();
//            fw.close();
//        }
//        catch(IOException e){
//            
//        }
//    }

    @Override
    public String getName() {
        return name;
    } 
    
    @Override
    public String toString() {
        String s;
        
        s = "Name : " + name + "\n";
        return s;
    }
}
