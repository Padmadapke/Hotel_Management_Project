package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener  {
    Choice ccustomer;
    JTextField textfield,nametextfield,checktextfield,paidtextfield,pendingtextfield;
	JButton check, update,back;
	
	public UpdateCheck() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tamoha",Font.PLAIN,20));
		text.setBounds(400, 20, 200,30 );
		text.setForeground(Color.BLUE);
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
		lblroom.setBounds(30, 120, 100,20 );
	    add(lblroom);
		
	    textfield = new JTextField();
		textfield.setBounds(200, 120, 150, 20);
		add(textfield);
		
	    JLabel lblname = new JLabel("Name");
		lblname.setBounds(30, 160, 100,20 );
	    add(lblname);
			
		nametextfield = new JTextField();
		nametextfield.setBounds(200, 160, 150, 20);
		add(nametextfield);
		 
		JLabel lblcheck = new JLabel("Checkin Time");
		lblcheck.setBounds(30, 200, 100,20 );
		add(lblcheck);
				
		checktextfield = new JTextField();
		checktextfield.setBounds(200, 200, 150, 20);
		add(checktextfield);
			 
		JLabel lblpaid = new JLabel("Amount Paid");
		lblpaid.setBounds(30, 240, 100,20 );
	    add(lblpaid);
					
		paidtextfield = new JTextField();
		paidtextfield.setBounds(200, 240, 150, 20);
    	add(paidtextfield);
				 
	    JLabel lblpaid1 = new JLabel("Pending Amount ");
	    lblpaid1.setBounds(30, 280, 100,20 );
	    add(lblpaid1);
	    pendingtextfield = new JTextField();
	    pendingtextfield.setBounds(200, 280, 150, 20);
	    add(pendingtextfield);
	
		check= new JButton("Check");
	    check.setBounds(30, 340, 100, 30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
	    add(check);
	        
	    update= new JButton("Update");
	    update.setBounds(150, 340, 100, 30);
	    update.setBackground(Color.BLACK);
	    update.setForeground(Color.WHITE);
	    update.addActionListener(this);
	    add(update);
	        
	    back= new JButton("Back");
	    back.setBounds(270, 340, 100, 30);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    back.addActionListener(this);
	    add(back);	
	        
	    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/check2.jpg"));
    	Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
	    JLabel image = new JLabel(i1);
	    image.setBounds(350, 50, 1000,600);
	    add(image);

			
		
		
	   setBounds(300,200,980,500);
	   setVisible(true);
	}

	
	public static void main(String[] args) {
		new UpdateCheck();
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
				  System.out.println(textfield.getText());
				  nametextfield.setText(rs.getString("namee"));
				  checktextfield.setText(rs.getString("checkintime"));
				  paidtextfield.setText(rs.getString("deposite"));
			  }
			  
			  ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+textfield.getText()+"'"); 
			  System.out.println(textfield.getText());
			  while(rs2.next()) {
				  String price = rs2.getString("price");
				  System.out.println(price);
				  int amountPaid = Integer.parseInt(price) - Integer.parseInt(paidtextfield.getText());
				  pendingtextfield.setText(""+amountPaid);
				  
			  }
		  }catch(Exception ae) {
			  ae.printStackTrace();
		  }
		  
		}else if(e.getSource()==update) {
			String number = ccustomer.getSelectedItem();
			String room= textfield.getText();
			String name= nametextfield.getText();
			String checkin = checktextfield.getText();
			String deposit = paidtextfield.getText();
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate("Update customer set room1 = '"+room+"', namee ='"+name+"',checkintime ='"+checkin+"',deposite='"+deposit+"' where Numberr = '"+ number+"'");
			   
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
