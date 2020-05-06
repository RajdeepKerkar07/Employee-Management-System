package Project;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class Update_Employee extends Add_Employee implements ActionListener{
    
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9;
    JTextField t,t1,t2,t3,t4,t5,t6,t7;
    JButton b,b1; 
    String id_emp;

    Update_Employee(String idaa){
        super(0);
        f=new JFrame("Update Employee Details");
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(200,50);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idaa;   
        idimg=new JLabel();
        idimg.setBounds(0,0,900,700);
        idimg.setLayout(null);
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = im.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        idimg.setIcon(i3);
        f.add(idimg);

        id1 = new JLabel("Employee Details");
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

        showData(idaa);
    }

    int i=0;

    void showData(String s){
        try{
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+s+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;
                
                t.setText(rs.getString(2));
                t1.setText(rs.getString(3));
                t2.setText(rs.getString(4));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                t6.setText(rs.getString(8));
                t7.setText(rs.getString(9));
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"Id not found");
            new Search_Employee();}
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(200,50);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update employee set name='"+t.getText()+"',email_id='"+t1.getText()+"',emp_id='"+t2.getText()+"',age='"+t3.getText()+"',dob='"+t4.getText()+"',address='"+t5.getText()+"',designation='"+t6.getText()+"',salary='"+t7.getText()+"' where emp_id='"+id_emp+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new Search_Employee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update_Employee("Update Employee");
    }
    
}
