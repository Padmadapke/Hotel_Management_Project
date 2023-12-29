package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener{
	    Choice ccustomer;
	    JTextField textfield,tfavailable,tfstatus,paidtextfield,pendingtextfield;
		JButton check, update,back;
		
	public UpdateRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tamoha",Font.BOLD,25));
		text.setBounds(300, 10, 250,30 );
		text.setForeground(Color.DARK_GRAY);
	    add(text);
		
	    JLabel lblid = new JLabel("Customer Id");
	    lblid.setBounds(30, 80, 100,20 );
	    add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			
			while(rs.next()) {
				ccustomer.add(rs.getString("Numberr"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30, 130, 100,20 );
	    add(lblroom);
		
	    textfield = new JTextField();
		textfield.setBounds(200, 130, 150, 20);
		add(textfield);
		
	    JLabel lblname = new JLabel("Availability");
		lblname.setBounds(30, 180, 100,20 );
	    add(lblname);
			
		tfavailable = new JTextField();
		tfavailable.setBounds(200, 180, 150, 20);
		add(tfavailable);
		 
		JLabel lblcheck = new JLabel(" Cleaning Status");
		lblcheck.setBounds(30, 230, 100,20 );
		add(lblcheck);
				
		tfstatus = new JTextField();
		tfstatus.setBounds(200, 230, 150, 20);
		add(tfstatus);
			 
		check= new JButton("Check");
	    check.setBounds(30, 300, 100, 30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
	    add(check);
	        
	    update= new JButton("Update");
	    update.setBounds(150, 300, 100, 30);
	    update.setBackground(Color.BLACK);
	    update.setForeground(Color.WHITE);
	    update.addActionListener(this);
	    add(update);
	        
	    back= new JButton("Back");
	    back.setBounds(270, 300, 100, 30);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    back.addActionListener(this);
	    add(back);	
		
	    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/luxury_terrace1.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
	    JLabel image = new JLabel(i1);
	    image.setBounds(370, 50, 570,400);
	    add(image);

		
	    
	    setBounds(300,200,980,500);
		setVisible(true);
	    
	}

	public static void main(String[] args) {
         new UpdateRoom();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			
			  String id = ccustomer.getSelectedItem();
			  String query = "select * from customer where Numberr='"+id+"'";
			  try {
				  Conn c = new Conn();
				  ResultSet rs = c.s.executeQuery(query);
				  
				  while(rs.next()) {
					  textfield.setText(rs.getString("room1"));
				  }
				  
					  ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+textfield.getText()+"'"); 
					  while(rs2.next()) {
						 tfavailable.setText(rs2.getString("availability"));
						 tfstatus.setText(rs2.getString("cleaning_status"));
					  }
				  
			  }catch(Exception ae) {
					  ae.printStackTrace();
				  
			  }}
			  
	else if(e.getSource()==update) {
					String number = ccustomer.getSelectedItem();
					String room= textfield.getText();
					String available= tfavailable.getText();
					String status = tfstatus.getText();
					
					try {
						Conn c = new Conn();
						c.s.executeUpdate("Update room set availability= '"+available+"',availability='"+status+"', cleaning_status ='"+status+"'where roomnumber = '"+room+"'");
					   
						JOptionPane.showMessageDialog(null, "Data Updated Successfully");
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
