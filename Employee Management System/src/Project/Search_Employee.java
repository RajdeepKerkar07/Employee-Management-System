package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Search_Employee implements ActionListener{
    
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;

    Search_Employee(){
        f=new JFrame("Search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
        Image i2 = img.getImage().getScaledInstance(500, 270, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l5.setIcon(i3);


        l=new JLabel("Employee Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.black);
        Font F1=new Font("sans serif",Font.PLAIN,25);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        t.setFont(new Font("sans serif", Font.PLAIN,16));
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        b.setFont(new Font("sans serif", Font.PLAIN,16));
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        b2.setFont(new Font("sans serif", Font.PLAIN,16));
        l5.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            new Update_Employee(t.getText());
            f.setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new Search_Employee();
    } 	
}
