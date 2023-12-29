package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
	JButton jb, jb1, jb3,jb4,jb5,jb6,jb11,jb8, jb9, jb10,jb7,jb12;

	public Reception() {
		setBounds(370,200,800,570);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel heading = new JLabel("HOTEL RECEPTION");
		heading.setFont(new Font("Tamoha",Font.BOLD,20));
		heading.setBounds(200, 5, 220, 30);
	
		add(heading);
		
		jb= new JButton("New Customer Form");
		jb.setBounds(10, 40, 200, 30);
		jb.setBackground(Color.BLACK);
		jb.setForeground(Color.WHITE);
		jb.addActionListener(this);
        add(jb);
        jb1= new JButton("Rooms");
		jb1.setBounds(10, 80, 200, 30);
		jb1.setBackground(Color.BLACK);
		jb1.setForeground(Color.WHITE);
		jb1.addActionListener(this);
        add(jb1);
        jb3= new JButton("Department");
		jb3.setBounds(10, 120, 200, 30);
		jb3.setBackground(Color.BLACK);
		jb3.setForeground(Color.WHITE);
		jb3.addActionListener(this);
        add(jb3);
        jb4= new JButton("All Employees");
		jb4.setBounds(10, 160, 200, 30);
		jb4.setBackground(Color.BLACK);
		jb4.setForeground(Color.WHITE);
		jb4.addActionListener(this);
        add(jb4);
        jb5= new JButton(" Customer Info ");
		jb5.setBounds(10, 200, 200, 30);
		jb5.setBackground(Color.BLACK);
		jb5.setForeground(Color.WHITE);
		jb5.addActionListener(this);
        add(jb5);
         jb6= new JButton("Manager Form");
		jb6.setBounds(10, 240, 200, 30);
		jb6.setBackground(Color.BLACK);
		jb6.setForeground(Color.WHITE);
		jb6.addActionListener(this);
		
        add(jb6);
         jb7= new JButton("Checkout");
		jb7.setBounds(10, 280, 200, 30);
		jb7.setBackground(Color.BLACK);
		jb7.setForeground(Color.WHITE);
		jb7.addActionListener(this);
        add(jb7);
        jb8= new JButton("Update Status");
		jb8.setBounds(10, 320, 200, 30);
		jb8.setBackground(Color.BLACK);
		jb8.setForeground(Color.WHITE);
		jb8.addActionListener(this);
        add(jb8);
        jb9= new JButton("Update Room Status");
		jb9.setBounds(10, 360, 200, 30);
		jb9.setBackground(Color.BLACK);
		jb9.setForeground(Color.WHITE);
		jb9.addActionListener(this);
        add(jb9);
         jb10= new JButton("Pickup Service");
		jb10.setBounds(10, 400, 200, 30);
		jb10.setBackground(Color.BLACK);
		jb10.setForeground(Color.WHITE);
		jb10.addActionListener(this);
        add(jb10);
         jb11= new JButton("Search Room");
		jb11.setBounds(10, 440, 200, 30);
		jb11.setBackground(Color.BLACK);
		jb11.setForeground(Color.WHITE);
		jb11.addActionListener(this);
        add(jb11);
        jb12= new JButton("Logout");
		jb12.setBounds(10, 480, 200, 30);
		jb12.setBackground(Color.BLACK);
		jb12.setForeground(Color.WHITE);
		jb12.addActionListener(this);
        add(jb12);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/recp.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
	    JLabel image = new JLabel(i1);
	    image.setBounds(250, 30, 500, 470);
	    add(image);		
	}
	public static void main(String[] args) {
       new Reception();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb) {
			setVisible(false);
			new AddCustomer();
			
		}else if(e.getSource()==jb1) {
			setVisible(false);
			new Room();
		}
		else if(e.getSource()==jb3) {
			setVisible(false);
			new Department();
		}
		else if(e.getSource()==jb4) {
			setVisible(false);
			new EmployeeInfo();
		}else if(e.getSource()==jb6) {
			setVisible(false);
			new ManagerInfo();
		}else if(e.getSource()==jb5) {
			setVisible(false);
			new CustomerInfo();
		}else if(e.getSource()==jb11) {
			setVisible(false);
			new SearchRoom();
		}else if(e.getSource()==jb8) {
			setVisible(false);
			new UpdateCheck();
	}else if(e.getSource()==jb9) {
		setVisible(false);
		new UpdateRoom();
	}else if(e.getSource()==jb10) {
		setVisible(false);
		new Pickup();
	}else if(e.getSource()==jb7) {
		setVisible(false);
		new Checkout();
		}else if(e.getSource()==jb12) {
			setVisible(false);
			
}}}