package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
JTable table;
JButton back;

	public Room() {
		Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
		setSize(size);
		setLocation(0,0);
		setBounds(300,200,1000,600);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
	    
	    
	    JLabel l1 = new JLabel("Room Number");
	    l1.setBounds(40, 50, 100,20 );
	    add(l1);
	    
	    JLabel l2 = new JLabel("Availibility");
	    l2.setBounds(150, 50, 100,20 );
	    add(l2);
	    
	    JLabel l3 = new JLabel("Status");
	    l3.setBounds(250, 50, 100,20 );
	    add(l3);
	    
	    JLabel l4 = new JLabel("Price");
	    l4.setBounds(350, 50, 100,20 );
	    add(l4);
	    
	    JLabel l5 = new JLabel("Bed Type ");
	    l5.setBounds(450, 50, 100,20 );
	    add(l5);
	    
	    table = new JTable();
	    table.setBounds(30,90,500,400);
	    add(table);
	    
	    try {
	    	Conn c = new Conn();
	    	ResultSet rs = c.s.executeQuery("select * from room");
	    	table.setModel(DbUtils.resultSetToTableModel(rs));
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    back = new JButton("Back");
	    back.addActionListener(this);
	    back.setBounds(500, 350, 130, 30);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(" "));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(700,80,480,410);
        add(image);
	    
		setVisible(true);
		
	}

	public static void main(String[] args) {
       new Room();
       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception();
		
	}

}
