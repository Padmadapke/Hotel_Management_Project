package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField lblroomnumber;
	JButton checkout, back;
	JLabel lblroom ,lblcheckin, lblcheckintime,lblcheckout,lblcheckouttime;
	public Checkout() {

		setBounds(300,200,800,400);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Checkout");
		text.setForeground(Color.MAGENTA);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(100, 20, 100, 30);
		add(text);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30, 80, 100,20 );
	    add(lblid);
	    
	    ccustomer = new Choice();
		ccustomer.setBounds(150,80,150,25);
		add(ccustomer);
		
		lblroom = new JLabel("Room Number");
		lblroom.setBounds(30, 130, 100,30 );
	    add(lblroom);
	    
	    lblroomnumber = new JTextField();
		lblroomnumber.setBounds(150, 130, 150,25 );
	    add(lblroomnumber);
	    

	    lblcheckin = new JLabel("Checkin Time ");
		lblcheckin.setBounds(30, 180, 100,30 );
	    add(lblcheckin);
	    
	    lblcheckintime = new JLabel();
		lblcheckintime.setBounds(150, 180, 100,30 );
	    add(lblcheckintime);
	    
	    lblcheckout = new JLabel("Checkout Time ");
	    lblcheckout.setBounds(30, 230, 100,30 );
	    add(lblcheckout);
	    
	    Date date = new Date();
	    lblcheckouttime = new JLabel(""+ date);
	    lblcheckouttime.setBounds(150,230, 100,30 );
	    add(lblcheckouttime);
	    
	    back = new JButton("Back");
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    back.addActionListener(this);
	    back.setBounds(170, 280, 120,30);
		add(back);
		
	   checkout = new JButton("Checkout");
	   checkout.setBackground(Color.BLACK);
	   checkout.setForeground(Color.WHITE);
	   checkout.addActionListener(this);
	   checkout.setBounds(30, 280, 120,30);
	   add(checkout);
	   
	   try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			
			while(rs.next()) {
				ccustomer.add(rs.getString("Numberr"));
				lblroomnumber.setText(rs.getString("room1"));
				lblcheckintime.setText(rs.getString("checkintime"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	   
	   ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/checkout1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
	    JLabel image = new JLabel(i1);
	    image.setBounds(350, 80, 400, 250);
	    add(image);
	    
		
	}



	public static void main(String[] args) {
     new Checkout();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkout) {
		String query1= "delete from customer where numberr='"+ccustomer.getSelectedItem()+"'";
		String query2 = "update room set availability='Available' where roomnumber ='"+lblroomnumber.getText()+"'";
		
		try {
			Conn c = new Conn();
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null," Checkout Done" );
			setVisible(false);
			new Reception();
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		
		
		
		}else {
			setVisible(false);
			new Reception();
		}
		
	}

}
