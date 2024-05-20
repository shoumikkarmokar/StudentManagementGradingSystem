package gradingsystem.GUI;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Instructor;
import gradingsystem.controller.AddCourseController;
import gradingsystem.controller.AddDepartmentController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewDepartment extends JFrame{   
    
    private JLabel lblName = new JLabel("Name : ");
    private JLabel lblEmail = new JLabel("Email : ");
    private JLabel lblManager = new JLabel("Manager : ");
    private JLabel lblDescription = new JLabel("Description : ");
    
    private JTextField txtName = new JTextField("Enter Name Here...");
    private JTextField txtEmail = new JTextField("Enter Email Here...");
    private DefaultComboBoxModel modelInstructors = AddCourseController.getInstructorNames();
    private JComboBox<String> comboInstructors = new JComboBox(modelInstructors);
    
    private JTextArea txtDescription = new JTextArea("Enter Description Here...", 6,15);
    private JScrollPane scrollDescription = new JScrollPane( txtDescription ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private DefaultListModel dlm;
    
    
    private DBConnector db;
    
    
    public NewDepartment(DefaultListModel d){
        this.dlm = d;
        this.db = new DBConnector();
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Department");
        this.setBounds(300, 300, 600, 460);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/department.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        lblEmail.setBounds(100,55,100,30);
        lblManager.setBounds(100,95,100,30);
        lblDescription.setBounds(100,135,100,30);
        
        c.add(lblName);
        c.add(lblEmail);
        c.add(lblManager);
        c.add(lblDescription);
        
        txtName.setBounds(210,15,300,30);
        txtEmail.setBounds(210,55,300,30);
        comboInstructors.setBounds(210, 95, 300, 30);
        scrollDescription.setBounds(210,135,300,230);    
        
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        
//        txtDescription.setBorder(BorderFactory.createEtchedBorder());
        
        c.add(txtName);
        c.add(txtEmail);
        c.add(comboInstructors);
        c.add(scrollDescription);

        
        btnOk.setBounds(260,375,100,30);
        btnCancel.setBounds(370,375,100,30);
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
        
        
        txtDescription.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtDescription.getText().equals("Enter Description Here...") )
                    txtDescription.setText("");
            }
        });
        
        
        txtEmail.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtEmail.getText().equals("Enter Email Here...") )
                    txtEmail.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtName.getText().equals("") || txtName.getText().equals("Enter Name Here...")){
                    JOptionPane.showMessageDialog(NewDepartment.this, "Enter Department Name!");
                    txtName.requestFocus();
                    return;
                }
                if(txtDescription.getText().equals("") || txtDescription.getText().equals("Enter Description Here...")){
                    JOptionPane.showMessageDialog(NewDepartment.this, "Enter Department Description!");
                    txtDescription.requestFocus();
                    return;
                }
                if(txtEmail.getText().equals("") || txtEmail.getText().equals("Enter Email Here...")){
                    JOptionPane.showMessageDialog(NewDepartment.this, "Enter Department Email!");
                    txtDescription.requestFocus();
                    return;
                }

                String s;
                
                if( (String)comboInstructors.getSelectedItem() != null ){
                    s = AddDepartmentController.addDepartmentToDatabase(
                    txtName.getText(), txtDescription.getText(), txtEmail.getText(), Instructor.getInstructor((String)comboInstructors.getSelectedItem()).getId() + "",
                            DBConnector.getUniversityID() + "");
                }
                else{
                    s = AddDepartmentController.addDepartmentToDatabase(
                    txtName.getText(), txtDescription.getText(), txtEmail.getText(), null + "", "1");
                }
                
                dlm.addElement(s);
                
                NewDepartment.this.dispatchEvent(new WindowEvent(NewDepartment.this, WindowEvent.WINDOW_CLOSING));
            }
                
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewDepartment.this.dispatchEvent(new WindowEvent(NewDepartment.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
  
}
