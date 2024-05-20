package gradingsystem.GUI;

import gradingsystem.controller.AddInstructorController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewDirector extends JFrame{   
    
    private JLabel lblFName = new JLabel("Director First Name : ");
    private JLabel lblMName = new JLabel("Director Middle Name : ");
    private JLabel lblLName = new JLabel("Director Last Name : ");
    private JLabel lblEmail = new JLabel("Administiration Email : ");
    private JLabel lblGender = new JLabel("Director Gender : ");
    private JLabel lblPhoneNumber = new JLabel("Director Phone Number : ");
    private JLabel lblSalary = new JLabel("Director Salary : ");
    
    private JTextField txtFName = new JTextField("Enter First Name Here...");
    private JTextField txtMName = new JTextField("Enter Middle Name Here...");
    private JTextField txtLName = new JTextField("Enter Last Name Here...");
    private JTextField txtEmail = new JTextField("Enter Email Here...");
    private JTextField txtGender = new JTextField("Enter Gender Here...");
    private JIntegerNumberTextField txtPhoneNumber = new JIntegerNumberTextField("Enter Phone Number Here...");
    private JIntegerNumberTextField txtSalary = new JIntegerNumberTextField("Enter Salary Here...");
    
    
    private DefaultComboBoxModel modelGender = new DefaultComboBoxModel();
    private JComboBox<String> comboGender = new JComboBox(modelGender);
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    
    private DefaultListModel dlm;
    
    
    public NewDirector(DefaultListModel d){
        dlm = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New University Administration");
        this.setBounds(500, 350, 600, 375);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/department.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        modelGender.addElement("Male");
        modelGender.addElement("Female");
        
        lblEmail.setBounds(50,15,200,30);
        lblFName.setBounds(50,55,200,30);
        lblMName.setBounds(50,95,200,30);
        lblLName.setBounds(50,135,200,30);
        lblPhoneNumber.setBounds(50,175,200,30);
        lblSalary.setBounds(50,215,200,30);
        lblGender.setBounds(50,255,200,30);
        
        c.add(lblFName);
        c.add(lblMName);
        c.add(lblLName);
        c.add(lblEmail);
        c.add(lblGender);
        c.add(lblPhoneNumber);
        c.add(lblSalary);
        
        txtEmail.setBounds(250,15,300,30);
        txtFName.setBounds(250,55,300,30);
        txtMName.setBounds(250,95,300,30);
        txtLName.setBounds(250,135,300,30);
        txtPhoneNumber.setBounds(250,175,300,30);
        txtSalary.setBounds(250,215,300,30);
        comboGender.setBounds(250,255,300,30);
        
        c.add(txtFName);
        c.add(txtMName);
        c.add(txtLName);
        c.add(txtEmail);
        c.add(comboGender);
        c.add(txtPhoneNumber);        
        c.add(txtSalary);

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
        
        txtSalary.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtSalary.getText().equals("Enter Salary Here...") )
                    txtSalary.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtFName.getText().equals("") || txtFName.getText().equals("Enter First Name Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Director First Name!");
                    txtFName.requestFocus();
                    return;
                }
                if(txtMName.getText().equals("") || txtMName.getText().equals("Enter Middle Name Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Director Middle Name!");
                    return;
                }
                if(txtLName.getText().equals("") || txtLName.getText().equals("Enter Last Name Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Director Last Name!");
                    return;
                }
                if(txtEmail.getText().equals("") || txtEmail.getText().equals("Enter Email Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Administration Email!");
                    txtEmail.requestFocus();
                    return;
                }
                if(txtPhoneNumber.getText().equals("") || txtPhoneNumber.getText().equals("Enter Phone Number Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Director Phone Number!");
                    txtPhoneNumber.requestFocus();
                    return;
                }
                if(txtSalary.getText().equals("") || txtSalary.getText().equals("Enter Salary Here...") ) {
                    JOptionPane.showMessageDialog(NewDirector.this, "Enter Director Salary!");
                    txtPhoneNumber.requestFocus();
                    return;
                }
                
                String s = AddInstructorController.addDirector(txtFName.getText(), txtMName.getText(), txtLName.getText()
                                                                ,txtEmail.getText(), (String)comboGender.getSelectedItem(), txtPhoneNumber.getText(), 
                                                                txtSalary.getText() + "");
                
                dlm.addElement(s);
                
                NewDirector.this.dispatchEvent(new WindowEvent(NewDirector.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewDirector.this.dispatchEvent(new WindowEvent(NewDirector.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

   
}
