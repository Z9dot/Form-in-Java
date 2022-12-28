import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Interface implements Serializable{

    public Interface() {


        JFrame frame = new JFrame("Employee Information System");
        frame.setSize(550, 650);
        frame.setLayout(null);
        JLabel employeeInformationSystem = new JLabel("Employee Information System");
        employeeInformationSystem.setBounds(150,20,500,50);
        employeeInformationSystem.setFont(new Font("Calibre",Font.BOLD,16));

        //Panel for Input Fields
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(10,80,500,200);

        //Labels:
        JLabel CNIC,Name,SSN,Salary;

        //CNIC
        CNIC =new JLabel();
        CNIC.setText("CNIC");
        CNIC.setSize(100,60);
        CNIC.setFont(new Font("Calibre",Font.BOLD,16));
        JTextField enterCNIC=new JTextField();
        enterCNIC.setBorder(null);
        enterCNIC.setBounds(50,20,150,25);
        enterCNIC.setFont(new Font("Calibre",Font.PLAIN,14));


        //NAME
        Name=new JLabel();
        Name.setText("Name");
        Name.setFont(new Font("Calibre",Font.BOLD,16));
        Name.setBounds(0,40,100,60);
        JTextField enterName=new JTextField();
        enterName.setBorder(null);
        enterName.setBounds(50,60,150,25);
        enterName.setFont(new Font("Calibre",Font.PLAIN,14));

        //SSN
        SSN=new JLabel();
        SSN.setText("SSN");
        SSN.setFont(new Font("Calibre",Font.BOLD,16));
        SSN.setBounds(0,80,100,60);
        JTextField enterSSN=new JTextField();
        enterSSN.setBorder(null);
        enterSSN.setBounds(50,100,150,25);
        enterSSN.setFont(new Font("Calibre",Font.PLAIN,14));

        //Salary
        Salary=new JLabel();
        Salary.setText("Salary");
        Salary.setFont(new Font("Calibre",Font.BOLD,16));
        Salary.setBounds(0,120,100,60);
        JTextField enterSalary=new JTextField();
        enterSalary.setBorder(null);
        enterSalary.setBounds(50,140,150,25);
        enterSalary.setFont(new Font("Calibre",Font.PLAIN,14));

        //Panel for radio and combo
        JPanel panel2=new JPanel();
        panel2.setBounds(10,280,450,200);
        panel2.setLayout(null);



        JLabel Gender=new JLabel("Gender");
        Gender.setBounds(0,25,100,30);
        Gender.setFont(new Font("Calibre",Font.BOLD,16));


        JRadioButton male=new JRadioButton("Male");
        male.setActionCommand("Male");
        JRadioButton female=new JRadioButton("Female");
        female.setActionCommand("Female");
        ButtonGroup gender=new ButtonGroup();
        gender.add(male);
        gender.add(female);
        male.setBounds(80,30,80,30);
        female.setBounds(180,30,100,30);
        male.setFocusable(false);
        female.setFocusable(false);


        //Duty
        JCheckBox duty=new JCheckBox("On Duty");

        duty.setBounds(80,80,80,30);
        duty.setFocusable(false);



        //Date
        JLabel date=new JLabel("Date");
        date.setBounds(0,120,100,20);
        JComboBox<Integer> day=new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31});
        day.setBounds(30,120,50,20);
        JComboBox<String> month=new JComboBox<>(new String[]{"January","february", "march", "april", "may","june", "july","august","september","october","November","December"});
        month.setBounds(100,120,90,20);
        JComboBox<Integer> year=new JComboBox<>(new Integer[]{2019,2020,2021,2022});
        year.setBounds(220,120,80,20);


        //BUTTONS
        JPanel panel3=new JPanel();
        panel3.setBounds(10,480,500,100);
        panel3.setLayout(null);
        JButton save=new JButton("Save");
        save.setFocusable(false);
        save.addActionListener(new ActionListener() {
            File file = new File("employee.dat");
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Employee emp=new Employee(enterCNIC.getText(),enterName.getText(),gender.getSelection().getActionCommand(),enterSSN.getText(),Double.parseDouble(enterSalary.getText()),duty.isSelected(),(String) month.getSelectedItem(),(Integer) day.getSelectedItem(),(Integer) year.getSelectedItem());
//                    Date date=new Date();
//                    emp.setName(enterName.getText());
//                    emp.setSsn(enterSSN.getText());
//                    emp.setCnic(enterCNIC.getText());
//                    emp.setSalary(Double.parseDouble(enterSalary.getText()));
//                    emp.setGender(gender.getSelection().getActionCommand());
//                    emp.setOnDuty(duty.isSelected());
//                    date.setDay((Integer) day.getSelectedItem());
//                    date.setMonth((String) month.getSelectedItem());
//                    date.setYear((Integer) year.getSelectedItem());
//                    emp.setDate(date);
                    Filing filing=new Filing();
                    filing.Save(emp);
                    filing.Display();
                }
                catch (Exception e1){
                    System.out.println(e1);
                }
            }
        });
        save.setBounds(20,40,100,30);
        JButton delete=new JButton("Delete");
        delete.setBounds(140,40,100,30);
        delete.setFocusable(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Filing filing=new Filing();
                try {
                    filing.DeleteAStudent(enterCNIC.getText());
                } catch (Exception e1){
                    System.out.println(e1);
                }
            }
        });
        JButton search=new JButton("Search");
        search.setBounds(260,40,100,30);
        search.setFocusable(false);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Filing filing=new Filing();
                try {
                    filing.SearchAStudent(enterCNIC.getText());
                } catch (Exception e1) {
                    System.out.println(e1);
                }

            }
        });
        JButton clear=new JButton("Clear");
        clear.setBounds(380,40,100,30);
        clear.setFocusable(false);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterName.setText(null);
                enterCNIC.setText(null);
                enterSalary.setText(null);
                enterSSN.setText(null);
                male.setSelected(false);
                female.setSelected(false);
                duty.setSelected(false);
                day.setSelectedItem(null);
            }
        });


        panel3.add(save);
        panel3.add(delete);
        panel3.add(search);
        panel3.add(clear);

        panel1.add(CNIC);
        panel1.add(enterCNIC);
        panel1.add(Name);
        panel1.add(enterName);
        panel1.add(SSN);
        panel1.add(enterSSN);
        panel1.add(Salary);
        panel1.add(enterSalary);

        panel2.add(male);
        panel2.add(female);
        panel2.add(Gender);
        panel2.add(duty);
        panel2.add(date);
        panel2.add(day);
        panel2.add(month);
        panel2.add(year);
        //Adding Components to Frame
        frame.add(employeeInformationSystem);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Interface system=new Interface();
    }
}

