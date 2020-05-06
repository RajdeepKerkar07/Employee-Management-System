package Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Print_Data implements ActionListener{
    
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,aid9,id9,id10,id11,aid10;
    String emp_id,name,address,email_id,designation,age,dob,salary;
    JButton b1,b2;
    ImageIcon icon;
    int i =0;

    Print_Data(String e_id){
        try{
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            if(rs.next()){
                name = rs.getString("name");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                email_id = rs.getString("email_id");
                designation = rs.getString("designation");
                salary = rs.getString("salary");
                emp_id = rs.getString("emp_id");
                i=1;
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"Id not found!");
                new View_Employee();
                
                }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        if(i==1){
        f=new JFrame("Print Data");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,50);
        f.setBackground(Color.white);
        f.setLayout(null);
        }

        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image i2 = img.getImage().getScaledInstance(595, 642, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        id9.setIcon(i3);

        id8 = new JLabel("Employee Details");
        id8.setBounds(50,10,250,30);
        f.add(id8);
        id8.setFont(new Font("sans serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("Employee Id:");
        id.setBounds(50,70,200,30);
        id.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id);

        aid = new JLabel(emp_id);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid);

        id1 = new JLabel("Name:");
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id1);

        aid1 = new JLabel(name);
        aid1.setBounds(200,100,300,30);
        aid1.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid1);
        

        id3= new JLabel("Email Id:");
        id3.setBounds(50,130,100,30);
        id3.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id3);

        aid3= new JLabel(email_id);
        aid3.setBounds(200,130,300,30);
        aid3.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid3);

        
        id5= new JLabel("Age:");
        id5.setBounds(50,160,100,30);
        id5.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id5);

        aid5= new JLabel(age);
        aid5.setBounds(200,160,300,30);
        aid5.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid5);


        id7= new JLabel("Date of Birth:");
        id7.setBounds(50,190,1200,30);
        id7.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id7);
        
        
        aid6= new JLabel(dob);
        aid6.setBounds(200,190,300,30);
        aid6.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid6);
        
        id7= new JLabel("Address:");
        id7.setBounds(50,220,100,30);
        id7.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id7);
        
        
        aid7= new JLabel(address);
        aid7.setBounds(200,220,300,30);
        aid7.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(aid7);
        
        id10= new JLabel("Designation:");
        id10.setBounds(50,250,150,30);
        id10.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id10);
        
        
        aid9= new JLabel(designation);
        aid9.setBounds(200,250,300,30);
        aid9.setFont(new Font("sans serif",Font.PLAIN,20));
        aid9.setForeground(Color.white);
        id9.add(aid9);
        
        
        id11= new JLabel("Salary:");
        id11.setBounds(50,280,150,30);
        id11.setFont(new Font("sans serif",Font.PLAIN,20));
        id9.add(id11);
        
        
        aid10= new JLabel(salary);
        aid10.setBounds(200,280,300,30);
        aid10.setFont(new Font("sans serif",Font.PLAIN,20));
        aid10.setForeground(Color.white);
        id9.add(aid10);

        
        b1=new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,520,100,30);
        b1.addActionListener(this);
        b1.setFont(new Font("sans serif",Font.PLAIN,15));
        id9.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,520,100,30);
        b2.addActionListener(this);
        b2.setFont(new Font("sans serif",Font.PLAIN,15));
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
    }
    public static void main(String[] args){
            new Print_Data("Print Data");
    }
}
