package gradingsystem.GUI;

import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Student;
import gradingsystem.controller.AddStudentController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewStudent extends JFrame{   
    
    private JLabel lblFName = new JLabel("First Name : ");
    private JLabel lblMName = new JLabel("Middle Name : ");
    private JLabel lblLName = new JLabel("Last Name : ");
    private JLabel lblEmail = new JLabel("Email : ");
    private JLabel lblGender = new JLabel("Gender : ");
    private JLabel lblPhoneNumber = new JLabel("Phone Number : ");
    private JLabel lblDepartment = new JLabel("Department : ");
    
    private JTextField txtFName = new JTextField("Enter First Name Here...");
    private JTextField txtMName = new JTextField("Enter Middle Name Here...");
    private JTextField txtLName = new JTextField("Enter Last Name Here...");
    private JTextField txtEmail = new JTextField("Enter Email Here...");
    private JTextField txtGender = new JTextField("Enter Gender Here...");
    private JIntegerNumberTextField txtPhoneNumber = new JIntegerNumberTextField("Enter Phone Number Here...");
    
    
    private DefaultComboBoxModel modelGender = new DefaultComboBoxModel();
    private JComboBox<String> comboGender = new JComboBox(modelGender);
    
    private DefaultComboBoxModel modelDepartments = AddStudentController.getDepartmentsNames();
    private JComboBox<String> comboDepartments = new JComboBox(modelDepartments);
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private DefaultListModel dml;

    
    public NewStudent(DefaultListModel d){
        dml = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Student");
        this.setBounds(300, 300, 600, 375);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/student.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        modelGender.addElement("Male");
        modelGender.addElement("Female");
        
        lblFName.setBounds(100,15,100,30);
        lblMName.setBounds(100,55,100,30);
        lblLName.setBounds(100,95,100,30);
        lblEmail.setBounds(100,135,100,30);
        lblPhoneNumber.setBounds(100,175,100,30);
        lblGender.setBounds(100,215,100,30);
        lblDepartment.setBounds(100,255,100,30);
        
        c.add(lblFName);
        c.add(lblMName);
        c.add(lblLName);
        c.add(lblEmail);
        c.add(lblGender);
        c.add(lblPhoneNumber);
        c.add(lblDepartment);
        
        txtFName.setBounds(210,15,300,30);
        txtMName.setBounds(210,55,300,30);
        txtLName.setBounds(210,95,300,30);
        txtEmail.setBounds(210,135,300,30);
        txtPhoneNumber.setBounds(210,175,300,30);
        comboGender.setBounds(210,215,300,30);
        comboDepartments.setBounds(210,255,300,30);
        
        c.add(txtFName);
        c.add(txtMName);
        c.add(txtLName);
        c.add(txtEmail);
        c.add(comboGender);
        c.add(txtPhoneNumber);        
        c.add(comboDepartments);

        
        btnOk.setBounds(260,300,100,30);
        btnCancel.setBounds(370,300,100,30);
        c.add(btnOk);
        c.add(btnCancel);
        
        
        //-----Action Listeners-----
        
        
        txtFName.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtFName.getText().equals("Enter First Name Here...") )
                    txtFName.setText("");
            }
        });
        
        txtMName.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtMName.getText().equals("Enter Middle Name Here...") )
                    txtMName.setText("");
            }
        });
        
        txtLName.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtLName.getText().equals("Enter Last Name Here...") )
                    txtLName.setText("");
            }
        });
        
        txtPhoneNumber.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtPhoneNumber.getText().equals("Enter Phone Number Here...") )
                    txtPhoneNumber.setText("");
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
                if(txtFName.getText().equals("") || txtFName.getText().equals("Enter First Name Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student First Name!");
                    txtFName.requestFocus();
                    return;
                }
                if(txtMName.getText().equals("") || txtMName.getText().equals("Enter Middle Name Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Middle Name!");
                    return;
                }
                if(txtLName.getText().equals("") || txtLName.getText().equals("Enter Last Name Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Last Name!");
                    return;
                }
                if(txtEmail.getText().equals("") || txtEmail.getText().equals("Enter Email Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Email!");
                    txtEmail.requestFocus();
                    return;
                }
                if(txtPhoneNumber.getText().equals("") || txtPhoneNumber.getText().equals("Enter Phone Number Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Phone Number!");
                    txtPhoneNumber.requestFocus();
                    return;
                }
                
                if(comboDepartments.getSelectedIndex()== -1) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Choose a Department!");
                    comboDepartments.requestFocus();
                    return;
                }
                
                String s =AddStudentController.addStudentToDatabase(txtFName.getText(), txtMName.getText(), txtLName.getText()
                        ,txtEmail.getText(), (String)comboGender.getSelectedItem(), txtPhoneNumber.getText(), 
                        Departement.getDepartement((String)comboDepartments.getSelectedItem()).getId() + "");
                
                dml.addElement(s);
                
                NewStudent.this.dispatchEvent(new WindowEvent(NewStudent.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewStudent.this.dispatchEvent(new WindowEvent(NewStudent.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

   
}
