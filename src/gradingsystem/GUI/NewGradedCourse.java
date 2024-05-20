package gradingsystem.GUI;

import gradingsystem.Entities.Course;
import gradingsystem.Entities.Departement;
import gradingsystem.controller.AddGradedCourseController;
import gradingsystem.controller.CalculateGPAController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewGradedCourse extends JFrame{   
    
    private JLabel lblName = new JLabel("Courses : ");
    private JLabel lblGrade = new JLabel("Grade : ");
    
    private DefaultComboBoxModel model;
    private JComboBox comboCourse;
    private JNumberTextField txtGrade = new JNumberTextField("0.00");
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private DefaultListModel dml;
    private DefaultListModel dml2;
    
    private int selectedStudent;
    private JLabel lblGPA;
    
    public NewGradedCourse(int selectedStudent, DefaultListModel d, DefaultListModel d2, JLabel lbl){
        this.selectedStudent = selectedStudent;
        dml = d;
        dml2 = d2;
        lblGPA = lbl;
        model = AddGradedCourseController.getCourse(selectedStudent);
        comboCourse = new JComboBox(model);
        init();
    }
    
    private void init(){
        this.setTitle("Assign New Course");
        this.setBounds(300, 300, 600, 180);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/gradedCourse.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        lblGrade.setBounds(100,55,100,30);
        
        c.add(lblName);
        c.add(lblGrade);
        
        comboCourse.setBounds(210,15,300,30);
        txtGrade.setBounds(210,55,300,30);
        
        c.add(comboCourse);
        c.add(txtGrade);

        
        btnOk.setBounds(260,95,100,30);
        btnCancel.setBounds(370,95,100,30);
        c.add(btnOk);
        c.add(btnCancel);
        
        
        //-----Action Listeners-----
        
        
        txtGrade.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtGrade.getText().equals("0.00") )
                    txtGrade.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(comboCourse.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(NewGradedCourse.this, "Select a Course!");
                    comboCourse.requestFocus();
                    return;
                }
                if(txtGrade.getText().equals("") || txtGrade.getText().equals("0.0")){
                    JOptionPane.showMessageDialog(NewGradedCourse.this, "Enter Grade!");
                    txtGrade.requestFocus();
                    return;
                }
                float grade = 0;
                try{
                    grade = Float.parseFloat(txtGrade.getText());
                    if(grade > 4 || grade < 0){
                        JOptionPane.showMessageDialog(NewGradedCourse.this, "Grade must be between zero and four!");
                        return;
                    }
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(NewGradedCourse.this, "Enter a suitable Grade!");
                    return;
                }
                
                Course c = Departement.getCourse((String)comboCourse.getSelectedItem());
                
                AddGradedCourseController.addGradedCourseToDatabase(selectedStudent + "", 
                        c.getId() + "", grade + "");
                dml.addElement(c.getName());
                dml2.addElement(grade + "");
                
                String gpa = CalculateGPAController.calculateGPA(selectedStudent);
                lblGPA.setText(gpa);
                
                NewGradedCourse.this.dispatchEvent(new WindowEvent(NewGradedCourse.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewGradedCourse.this.dispatchEvent(new WindowEvent(NewGradedCourse.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
  
    
}
