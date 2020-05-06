package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_Employee implements ActionListener{
    
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,idimg;
    JTextField t,t1,t2,t3,t4,t5,t6,t7;
    JButton b,b1;

    Add_Employee(int i){}
    
    Add_Employee(){
        
        f = new JFrame("Add Employee");
        f.setBackground(Color.white);
        f.setLayout(null);

        
        idimg=new JLabel();
        idimg.setBounds(0,0,900,700);
        idimg.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        idimg.setIcon(i3);
        f.add(idimg);

        id1 = new JLabel("New Employee Details");
        id1.setBounds(320,30,500,50);
        id1.setFont(new Font("sans serif",Font.PLAIN,25));
        id1.setForeground(Color.black);
        idimg.add(id1);
 
        id2 = new JLabel("Name");
        id2.setBounds(50,150,100,30);
        id2.setFont(new Font("sans serif",Font.PLAIN,20));
        id2.setForeground(Color.white);
        idimg.add(id2);

        t=new JTextField();
        t.setBounds(200,150,150,30);
        idimg.add(t);

        id3= new JLabel("Email ID");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("sans serif",Font.PLAIN,20));
        id3.setForeground(Color.white);
        idimg.add(id3);

        t1=new JTextField();
        t1.setBounds(200,200,150,30);
        idimg.add(t1);

        id4= new JLabel("Employee ID");
        id4.setBounds(50,250,200,30);
        id4.setFont(new Font("sans serif",Font.PLAIN,20));
        id4.setForeground(Color.white);
        idimg.add(id4);

        t2=new JTextField();
        t2.setBounds(200,250,150,30);
        idimg.add(t2);

        id5= new JLabel("Age");
        id5.setBounds(50,300,100,30);
        id5.setFont(new Font("sans serif",Font.PLAIN,20));
        id5.setForeground(Color.white);
        idimg.add(id5);

        t3=new JTextField();
        t3.setBounds(200,300,150,30);
        idimg.add(t3);

        id6= new JLabel("Date of Birth");
        id6.setBounds(50,350,200,30);
        id6.setFont(new Font("sans serif",Font.PLAIN,20));
        id6.setForeground(Color.white);
        idimg.add(id6);

        t4=new JTextField();
        t4.setBounds(200,350,150,30);
        idimg.add(t4);

        id7= new JLabel("Address");
        id7.setBounds(50,400,150,30);
        id7.setFont(new Font("sans serif",Font.PLAIN,20));
        id7.setForeground(Color.white);
        idimg.add(id7);

        t5=new JTextField();   
        t5.setBounds(200,400,150,30);
        idimg.add(t5);
        
        id8= new JLabel("Designation");
        id8.setBounds(500,150,150,30);
        id8.setFont(new Font("sans serif",Font.PLAIN,20));
        id8.setForeground(Color.white);
        idimg.add(id8);

        t6=new JTextField();   
        t6.setBounds(650,150,150,30);
        idimg.add(t6);
        
        id9= new JLabel("Salary");
        id9.setBounds(500,200,100,30);
        id9.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.setForeground(Color.white);
        idimg.add(id9);

        t7=new JTextField();
        t7.setBounds(650,200,150,30);
        idimg.add(t7);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("sans serif",Font.PLAIN,20));
        b.setBounds(250,550,150,40);
        
        idimg.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("sans serif",Font.PLAIN,20));
        b1.setBounds(450,550,150,40);
        
        idimg.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(200,0);
    }

    public void actionPerformed(ActionEvent ae){
        
        String aa = t.getText();
        String bb = t1.getText();
        String cc = t2.getText();
        String dd = t3.getText();
        String ee = t4.getText();
        String ff = t5.getText();
        String gg = t6.getText();
        String hh = t7.getText();
        if(ae.getSource() == b){
            try{
                conn c1 = new conn();
                String q = "insert into employee (`name`,`email_id`,`emp_id`,`age`,`dob`,`address`,`designation`,`salary`) values('"+aa+"','"+bb+"','"+cc+"','"+dd+"','"+ee+"','"+ff+"','"+gg+"','"+hh+"')";
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details();
            }catch(Exception efe){
                System.out.println("The error is:"+efe);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new details();
        }
    }
    public static void main(String[ ] arg){
        new Add_Employee();
    }
    
}
