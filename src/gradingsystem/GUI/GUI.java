package gradingsystem.GUI;

import gradingsystem.DBConnector;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Student;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import gradingsystem.controller.*;
import java.util.ArrayList;


class JNumberTextField extends JTextField {
    @Override
    public void processKeyEvent(KeyEvent ev) {
        if ( Character.isDigit(ev.getKeyChar()) || ev.getKeyChar() == KeyEvent.VK_BACK_SPACE 
            || ev.getKeyCode() == KeyEvent.VK_LEFT || ev.getKeyCode() == KeyEvent.VK_RIGHT 
            || ev.getKeyChar() == KeyEvent.VK_PERIOD || ev.getKeyCode() == KeyEvent.VK_ENTER) {
            super.processKeyEvent(ev);
        }
        //ev.consume();
    }
    
    public JNumberTextField(){
        super();
    }
    
    public JNumberTextField(String s){
        super(s);
    }
    
    public JNumberTextField(String s , int n){
        super(s,n);
    }
}

class JIntegerNumberTextField extends JTextField {
    @Override
    public void processKeyEvent(KeyEvent ev) {
        if ( Character.isDigit(ev.getKeyChar()) || ev.getKeyChar() == KeyEvent.VK_BACK_SPACE 
            || ev.getKeyCode() == KeyEvent.VK_LEFT || ev.getKeyCode() == KeyEvent.VK_RIGHT 
            || ev.getKeyCode() == KeyEvent.VK_ENTER) {
            super.processKeyEvent(ev);
        }
        //ev.consume();
    }
    
    public JIntegerNumberTextField(){
        super();
    }
    
    public JIntegerNumberTextField(String s){
        super(s);
    }
    
    public JIntegerNumberTextField(String s , int n){
        super(s,n);
    }
}


public class GUI extends JFrame{
    
    //Main Panels
    private JPanel pnlNorthCenter = new JPanel();
    
    //Departments
    private JPanel pnlNorth_1 = new JPanel(new GridLayout(1, 3));
    private JPanel pnlSouth_1 = new JPanel();
    private JPanel pnlEast_1 = new JPanel(new GridLayout(1,2));
    private JPanel pnlWest_1 = new JPanel();    
    private JPanel pnlCenter_1 = new JPanel(null);
    
    private JPanel pnlNorthLeft_1 = new JPanel();
    private JPanel pnlNorthRight_1 = new JPanel();
    
    //Students
    private JPanel pnlNorth_2 = new JPanel(new GridLayout(1, 3));
    private JPanel pnlSouth_2 = new JPanel();
    private JPanel pnlEast_2 = new JPanel();
    private JPanel pnlWest_2 = new JPanel();    
    private JPanel pnlCenter_2 = new JPanel(null);
    
    private JPanel pnlNorthLeft_2 = new JPanel();
    private JPanel pnlNorthRight_2 = new JPanel();
    
    
    //North Panel Members
    private JTextField txtSearchStudent = new JTextField("Enter Student's Name Here...");    
    private JButton btnSearchStudent = new JButton("Search");
    
    private JRadioButton rbtnStudents = new JRadioButton("Students");
    private JRadioButton rbtnDepartments = new JRadioButton("Departments");
    private ButtonGroup bG = new ButtonGroup();
    
    private JButton btnAssignCourse = new JButton("Assign New Course");
    private JButton btnRemoveGradedCourse = new JButton("Remove Course");
    
    private JButton btnAddCourse = new JButton("Add New Course");
    private JButton btnRemoveCourse = new JButton("Remove Course");
    
    
    //Students West Panel Members
    private static DefaultListModel modelStudents = DisplayStudentController.getStudentsNames();
    private static JList<String> listStudents = new JList(modelStudents);
    private static JScrollPane scrollStudents = new JScrollPane(listStudents);
    
    
    //Students Center Panel Members
    private JLabel lblStudentId = new JLabel("ID : ");
    private JLabel lblStudentName = new JLabel("Name : ");
    private JLabel lblStudentGender = new JLabel("Gender : ");
    private JLabel lblStudentEmail = new JLabel("Email : ");
    private JLabel lblStudentNumber = new JLabel("Number : ");
    private JLabel lblStudentDept = new JLabel("Department : ");
    
    private JLabel lblStudentId_value = new JLabel();
    private JLabel lblStudentName_value = new JLabel();
    private JLabel lblStudentEmail_value = new JLabel();
    private JLabel lblStudentGender_value = new JLabel();
    private JLabel lblStudentNumber_value = new JLabel();
    private JLabel lblStudentDept_value = new JLabel();
    

    //Students East Panel Members
    private static DefaultListModel modelStudentCoursesName = new DefaultListModel();
    private static JList<String> listStudentCoursesName = new JList(modelStudentCoursesName);
    private static JScrollPane scrollStudentCoursesName = new JScrollPane(listStudentCoursesName);
    
    private static DefaultListModel modelStudentCoursesGrade = new DefaultListModel();
    private static JList<String> listStudentCoursesGrade = new JList(modelStudentCoursesGrade);
    private static JScrollPane scrollStudentCoursesGrade = new JScrollPane(listStudentCoursesGrade);
    
    
    //Students South Panel Members
    private JButton btnAddStudent = new JButton("Add New Student");
    private JButton btnRemoveStudent = new JButton("Remove Student");
    private JButton btnExportTranscript = new JButton("Export Transcript");
    
    private JLabel lblGpa = new JLabel("Total GPA : ");
    private JLabel lblGpa_value = new JLabel("0.0");
    
    
    //Departments West Panel Members
    private static DefaultListModel modelDepartments = DisplayDepartmentController.getDepartmentsNames();
    private static JList<String> listDepartments = new JList(modelDepartments);
    private static JScrollPane scrollDepartments = new JScrollPane(listDepartments);
    
    
    //Departments Center Panel Members
    private JLabel lblDepartmentName = new JLabel("Name : ");
    private JLabel lblDepartmentManager = new JLabel("Manager : ");
    private JLabel lblDepartmentEmail = new JLabel("Email : ");
    private JLabel lblDepartmentDescription = new JLabel("Description : ");
    
    private JLabel lblDepartmentName_value = new JLabel();
    private JLabel lblDepartmentManager_value = new JLabel();
    private JLabel lblDepartmentEmail_value = new JLabel();
    private JTextArea txtDepartmentDescription_value = new JTextArea();
    private JScrollPane scrollDepartmentDescription_value = new JScrollPane(txtDepartmentDescription_value ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    //Departments East Panel Members
    private static DefaultListModel modelDepartmentCourses = new DefaultListModel();
    private static JList<String> listDepartmentCourses = new JList(modelDepartmentCourses);
    private static JScrollPane scrollDepartmentCourses = new JScrollPane(listDepartmentCourses);
    
    
    
    //Departments South Panel Members
    private JButton btnAddDepartment = new JButton("Add New Department");
    private JButton btnRemoveDepartment = new JButton("Remove Department");
    
    
    
    public GUI(){
        init();
    }
    
    private void init(){
        setTitle("Grading System");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        setBounds(400,250,900,550);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/system.png")).getImage()); 
        
        Container c = getContentPane();
        
        //Container Allignment
        c.add(pnlNorth_1, BorderLayout.NORTH);
        
        c.add(pnlSouth_1, BorderLayout.SOUTH);
        c.add(pnlEast_1, BorderLayout.EAST);
        c.add(pnlWest_1, BorderLayout.WEST);
        c.add(pnlCenter_1);
              
        //North Panel Allignment
        pnlNorth_1.setBorder(BorderFactory.createTitledBorder("Options : "));
        pnlNorth_2.setBorder(BorderFactory.createTitledBorder("Options : "));
        bG.add(rbtnStudents);
        bG.add(rbtnDepartments);
        rbtnDepartments.setSelected(true);
        pnlNorthCenter.add(rbtnDepartments);
        pnlNorthCenter.add(rbtnStudents);
        
        
        
        //Departments North Panel
        pnlNorthRight_1.add(btnAddCourse);

        pnlNorth_1.add(pnlNorthLeft_1);
        pnlNorth_1.add(pnlNorthCenter);
        pnlNorth_1.add(pnlNorthRight_1);
        
        
        scrollDepartments.setPreferredSize(new Dimension(250, 360));
       
        pnlWest_1.setBorder(BorderFactory.createTitledBorder("Departments List : "));
        pnlWest_1.add(scrollDepartments);
        
        
        
        //Departments Center Panel Allignment
        pnlCenter_1.setBorder(BorderFactory.createTitledBorder("Department Information : "));
        
        txtDepartmentDescription_value.setBackground(new Color(238,238,238));
        txtDepartmentDescription_value.setEditable(false);
        txtDepartmentDescription_value.setLineWrap(true);
        txtDepartmentDescription_value.setWrapStyleWord(true);
        
        lblDepartmentName.setBounds(30,0,70,100);
        lblDepartmentManager.setBounds(30,35,70,100);
        lblDepartmentEmail.setBounds(30,70,70,100);
        lblDepartmentDescription.setBounds(30,105,85,100);
        
        lblDepartmentName_value.setBounds(90,0,1000,100);
        lblDepartmentManager_value.setBounds(90,35,1000,100);
        lblDepartmentEmail_value.setBounds(90,70,1000,100);
        scrollDepartmentDescription_value.setBounds(30,185,320,185);
        
        scrollDepartmentDescription_value.setBorder(BorderFactory.createEmptyBorder());
        
        
        pnlCenter_1.add(lblDepartmentName);
        pnlCenter_1.add(lblDepartmentName_value);
        pnlCenter_1.add(lblDepartmentEmail);
        pnlCenter_1.add(lblDepartmentEmail_value);
        pnlCenter_1.add(lblDepartmentManager);
        pnlCenter_1.add(lblDepartmentManager_value);
        pnlCenter_1.add(lblDepartmentDescription);
        pnlCenter_1.add(scrollDepartmentDescription_value);
        
        
        
        //Departments East Panel Allignment        
        scrollDepartmentCourses.setPreferredSize(new Dimension(250, 360));
       
        pnlEast_1.setBorder(BorderFactory.createTitledBorder("Available Courses List : "));
        pnlEast_1.add(scrollDepartmentCourses);
        
        
        
        //Departments South Panel Allignment
        pnlSouth_1.setBorder(BorderFactory.createTitledBorder("Options : "));
        pnlSouth_1.add(btnAddDepartment);
        pnlSouth_1.add(btnRemoveDepartment);    
        pnlSouth_1.add(btnRemoveCourse);    
        
        
        
        
        
        //Students North Panel Allignment
        txtSearchStudent.setPreferredSize(new Dimension(170, 30));
        pnlNorthLeft_2.add(txtSearchStudent);
        pnlNorthLeft_2.add(btnSearchStudent);        

        pnlNorthRight_2.add(btnAssignCourse);
        
        
        
        //Students West Panel Allignment        
        scrollStudents.setPreferredSize(new Dimension(250, 360));
       
        pnlWest_2.setBorder(BorderFactory.createTitledBorder("Students List : "));
        pnlWest_2.add(scrollStudents);
          
        
        
        //Students Center Panel Allignment
        pnlCenter_2.setBorder(BorderFactory.createTitledBorder("Student Information : "));
        
        lblStudentId.setBounds(30,0,70,100);
        lblStudentName.setBounds(30,50,70,100);
        lblStudentGender.setBounds(30,100,70,100);
        lblStudentEmail.setBounds(30,150,70,100);
        lblStudentNumber.setBounds(30,200,70,100);
        lblStudentDept.setBounds(30,250,85,100);
        
        lblStudentId_value.setBounds(130,0,1000,100);
        lblStudentName_value.setBounds(130,50,1000,100);
        lblStudentGender_value.setBounds(130,100,1000,100);
        lblStudentEmail_value.setBounds(130,150,1000,100);
        lblStudentNumber_value.setBounds(130,200,1000,100);
        lblStudentDept_value.setBounds(130,250,1000,100);
        
        pnlCenter_2.add(lblStudentId);
        pnlCenter_2.add(lblStudentId_value);
        pnlCenter_2.add(lblStudentName);
        pnlCenter_2.add(lblStudentName_value);
        pnlCenter_2.add(lblStudentGender);
        pnlCenter_2.add(lblStudentGender_value);
        pnlCenter_2.add(lblStudentEmail);
        pnlCenter_2.add(lblStudentEmail_value);
        pnlCenter_2.add(lblStudentNumber);
        pnlCenter_2.add(lblStudentNumber_value);
        pnlCenter_2.add(lblStudentDept);
        pnlCenter_2.add(lblStudentDept_value);
        
        
        
        //Students East Panel Allignment        
        scrollStudentCoursesName.setPreferredSize(new Dimension(200, 360));
        scrollStudentCoursesGrade.setPreferredSize(new Dimension(50, 360));
       
        pnlEast_2.setBorder(BorderFactory.createTitledBorder("Courses List : "));
        pnlEast_2.add(scrollStudentCoursesName);
        pnlEast_2.add(scrollStudentCoursesGrade);
     
        
        
        //Students South Panel Allignment
        pnlSouth_2.setBorder(BorderFactory.createTitledBorder("Options : "));
        pnlSouth_2.add(btnAddStudent);
        pnlSouth_2.add(btnRemoveStudent);
        pnlSouth_2.add(btnExportTranscript);
        pnlSouth_2.add(btnRemoveGradedCourse);
        
        pnlSouth_2.add(lblGpa);
        pnlSouth_2.add(lblGpa_value);

        
        
        // ----- Initialize Administration -----
        DBConnector db = new DBConnector();
        boolean firstTime = db.isThisTheFirstTimeToUseTheApp();
        
        if(firstTime){
            NewDirector nd = new NewDirector(modelDepartments);
            nd.setVisible(true);
        }
        else{
            db.updateUniversityID("Ain Shams University", "1 Al-Sarayyat St, Abbassiya, Cairo 11517, Egypt");
        }
            

        // ----- Action Listeners -----
        
        rbtnStudents.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                pnlNorth_1.setVisible(false);
                pnlWest_1.setVisible(false);
                pnlCenter_1.setVisible(false);
                pnlEast_1.setVisible(false);
                pnlSouth_1.setVisible(false);
        
                c.add(pnlNorth_2, BorderLayout.NORTH);
                c.add(pnlSouth_2, BorderLayout.SOUTH);
                c.add(pnlEast_2, BorderLayout.EAST);
                c.add(pnlWest_2, BorderLayout.WEST);
                c.add(pnlCenter_2);

                pnlNorth_2.add(pnlNorthLeft_2);
                pnlNorth_2.add(pnlNorthCenter);
                pnlNorth_2.add(pnlNorthRight_2);
                
                pnlNorth_2.setVisible(true);
                pnlWest_2.setVisible(true);
                pnlCenter_2.setVisible(true);
                pnlEast_2.setVisible(true);
                pnlSouth_2.setVisible(true);
            }
        });
        
        rbtnDepartments.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                pnlNorth_2.setVisible(false);
                pnlWest_2.setVisible(false);
                pnlCenter_2.setVisible(false);
                pnlEast_2.setVisible(false);
                pnlSouth_2.setVisible(false);    
        
                c.add(pnlNorth_1, BorderLayout.NORTH);
                c.add(pnlSouth_1, BorderLayout.SOUTH);
                c.add(pnlEast_1, BorderLayout.EAST);
                c.add(pnlWest_1, BorderLayout.WEST);
                c.add(pnlCenter_1);

                pnlNorth_1.add(pnlNorthLeft_1);
                pnlNorth_1.add(pnlNorthCenter);
                pnlNorth_1.add(pnlNorthRight_1);
                
                pnlNorth_1.setVisible(true);
                pnlWest_1.setVisible(true);
                pnlCenter_1.setVisible(true);
                pnlEast_1.setVisible(true);
                pnlSouth_1.setVisible(true);
            }
        });
        
        
        btnAddCourse.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listDepartments.getSelectedIndex() != -1) {
                    NewCourse nc = new NewCourse(Departement.getDepartement(listDepartments.getSelectedValue()).getId(), modelDepartmentCourses);
                    nc.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(GUI.this, "Select a Department!");
                }
                
            }
        });
        
        
        btnAddDepartment.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewDepartment nd = new NewDepartment(modelDepartments);
                nd.setVisible(true);
            }
        });
        
        
        btnRemoveDepartment.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = listDepartments.getSelectedIndex();
                if(i != -1){
                    listDepartments.setSelectedIndex(-1);
                    lblDepartmentName_value.setText("");
                    txtDepartmentDescription_value.setText("");
                    lblDepartmentManager_value.setText("");
                    lblDepartmentEmail_value.setText("");
                    modelDepartmentCourses.removeAllElements();
                    
                    boolean remove = RemoveDepartmentController.removeDepartment(Departement.getDepartement(listDepartments.getSelectedValue()).getId());
                    
                    if(remove){
                        modelDepartments.remove(i);
                    }
                }
                else
                    JOptionPane.showMessageDialog(GUI.this, "Select a Department!");
            }
        });
        
        
        btnRemoveCourse.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listDepartmentCourses.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(GUI.this, "Select a Course!");
                }
                else{
                    boolean remove = RemoveCourseController.removeCourse(Departement.getDepartement(listDepartments.getSelectedValue()).getId(), 
                                                                                    Departement.getCourse(listDepartmentCourses.getSelectedValue()).getId());
                    if(remove){
                        modelDepartmentCourses.remove(listDepartmentCourses.getSelectedIndex());
                    }
                }
            }
        });
        
        
        btnSearchStudent.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtSearchStudent.getText().equals("") || txtSearchStudent.getText().equals("Enter Student's Name Here...")){
                    JOptionPane.showMessageDialog(GUI.this, "Enter Student Name!");
                    txtSearchStudent.requestFocus();
                    return;
                }
                
                int i = SearchStudentController.searchStudent(txtSearchStudent.getText());
                if(i != -1){
                    listStudents.setSelectedIndex(i);
                    displayStudentInfo();
                }
                else{
                    JOptionPane.showMessageDialog(GUI.this, "Student Not Found!");
                }
                    
            }
        });
        
        
        btnAssignCourse.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listStudents.getSelectedIndex() != -1) {
                    NewGradedCourse ngc = new NewGradedCourse(Student.getStudent(listStudents.getSelectedValue()).getId() , 
                            modelStudentCoursesName, modelStudentCoursesGrade, lblGpa_value);
                    ngc.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(GUI.this, "Select a Student!");
            }
        });
        
        
        btnAddStudent.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                NewStudent ns = new NewStudent(modelStudents);
                ns.setVisible(true);
            }
        });
        
        
        btnRemoveStudent.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = listStudents.getSelectedIndex();
                if(i != -1){
                    listStudents.setSelectedIndex(-1);
                    lblStudentName_value.setText("");
                    lblStudentId_value.setText("");
                    lblStudentDept_value.setText("");
                    lblStudentEmail_value.setText("");
                    lblStudentGender_value.setText("");
                    lblStudentNumber_value.setText("");
                    modelStudentCoursesGrade.removeAllElements();
                    modelStudentCoursesName.removeAllElements();
                    
                    boolean remove = RemoveStudentController.removeStudent(Student.getStudent(listStudents.getSelectedValue()).getId());
                    
                    if(remove){
                        modelStudents.remove(i);
                        lblGpa_value.setText("0.0");
                    }
                    
                }
                    
                else
                    JOptionPane.showMessageDialog(GUI.this, "Select a Student!");
            }
        });
        
        
        btnExportTranscript.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = listStudents.getSelectedIndex();
                if(i != -1){
                    
                    ExportTranscriptController.exportTranscript(Student.getStudent(listStudents.getSelectedValue()).getId());
                    JOptionPane.showMessageDialog(GUI.this, "Transcript is exported successfully!");
                }
                    
                else
                    JOptionPane.showMessageDialog(GUI.this, "Select a Student!");
            }
        });
        
        
        btnRemoveGradedCourse.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listStudentCoursesName.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(GUI.this, "Select a Course!");
                }
                else{
                    boolean remove = RemoveGradedCourseController.removeGradedCourse(Student.getStudent(listStudents.getSelectedValue()).getId(),
                                                                    Departement.getCourse(listStudentCoursesName.getSelectedValue()).getId());
                    
                    if(remove){
                        modelStudentCoursesName.remove(listStudentCoursesName.getSelectedIndex());
                        modelStudentCoursesGrade.remove(listStudentCoursesGrade.getSelectedIndex());

                        String str = CalculateGPAController.calculateGPA(Student.getStudent(listStudents.getSelectedValue()).getId());
                        lblGpa_value.setText(str);
                    }
                }
            }
        });
        
        txtSearchStudent.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtSearchStudent.getText().equals("Enter Student's Name Here...") )
                    txtSearchStudent.setText("");
            }
        });
        
        listDepartments.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(listDepartments.getSelectedIndex() != -1){
                    modelDepartmentCourses.removeAllElements();
                    ArrayList<String> ss = DisplayCourseController.getCourses(Departement.getDepartement(listDepartments.getSelectedValue()).getId());
                    for(String s: ss)
                        modelDepartmentCourses.addElement(s);
                    
                    pnlEast_1.repaint();
                    
                    String[] str = DisplayDepartmentController.getDepartmentInfo(Departement.getDepartement(listDepartments.getSelectedValue()).getId());
                    
                    lblDepartmentName_value.setText(str[0]);
                    lblDepartmentManager_value.setText(str[1]);
                    lblDepartmentEmail_value.setText(str[2]);
                    txtDepartmentDescription_value.setText(str[3]);
                    
                }
            }
        });
        
        listStudentCoursesName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(listStudentCoursesName.getSelectedIndex() != -1){
                    listStudentCoursesGrade.setSelectedIndex(listStudentCoursesName.getSelectedIndex());
                }
            }
        });
        
        listStudentCoursesGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(listStudentCoursesGrade.getSelectedIndex() != -1){
                    listStudentCoursesName.setSelectedIndex(listStudentCoursesGrade.getSelectedIndex());
                }
            }
        });
        
        listStudents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(listStudents.getSelectedIndex() != -1){
                    displayStudentInfo();
                    String gpa = CalculateGPAController.calculateGPA(Student.getStudent(listStudents.getSelectedValue()).getId());
                    lblGpa_value.setText(gpa);
                }
            }
        });
    }
    
    private void displayStudentInfo() {
        String[] str = DisplayStudentController.getStudentInfo(Student.getStudent(listStudents.getSelectedValue()).getId());
        lblStudentId_value.setText(str[0]);
        lblStudentName_value.setText(str[1]);
        lblStudentGender_value.setText(str[2]);
        lblStudentEmail_value.setText(str[3]);
        lblStudentNumber_value.setText(str[4]);
        lblStudentDept_value.setText(str[5]);

        ArrayList<String[]> ss = DisplayCourseController.getGradedCourse(Student.getStudent(listStudents.getSelectedValue()).getId());
        modelStudentCoursesName.removeAllElements();
        modelStudentCoursesGrade.removeAllElements();
        for(int i=0; i<ss.size(); i++){
            modelStudentCoursesName.addElement(ss.get(i)[0]);
            modelStudentCoursesGrade.addElement(ss.get(i)[1]);
        }
        pnlEast_2.repaint();
    }
    
    public static void clearAllGuiLists(){
        modelDepartments.clear();
        modelDepartmentCourses.clear();
        modelStudents.clear();
        modelStudentCoursesName.clear();
        modelStudentCoursesGrade.clear();
    }
}


