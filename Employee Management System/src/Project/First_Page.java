package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class First_Page implements ActionListener {
    JFrame f;
    JLabel l1,id;
    JButton b;

    public First_Page() {
   
        f=new JFrame("Employee Management System");
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/First_Page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);
        
        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);

        
        b.setBounds(500,600,300,50);
        b.addActionListener(this);

        
        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
        
        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(120,30,1500,100);
        lid.setFont(new Font("sans serif",Font.PLAIN,65));
        lid.setForeground(Color.BLACK);
        id.add(lid);

        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1360,750);

        while(true){
            lid.setVisible(false); 
            try{
                Thread.sleep(500); 
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new login();    
        }     
    }
    
    public static void main(String[] args) {
        First_Page f = new First_Page();
    }
}
