package hotel.management.system;
import java.awt.Choice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
	JLabel text, id, number,gender,country,room, time, checktime,deposit,nameLb;
	JComboBox comboid;
	JTextField depo,countryTf,numberTf,nameTf;
	JRadioButton male,female;
	Choice croom;
	JButton addd, back;
	

	public AddCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		 text = new JLabel("NEW CUSTOMER FORM");
		 text.setBounds(100, 20, 300, 30);
		 text.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(text);
		 
		nameLb = new JLabel("Name");
		nameLb.setBounds(35, 80, 100, 20);
		nameLb.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(nameLb);
		 nameTf = new JTextField();
		 nameTf.setBounds(200, 80, 150, 25);
		 add(nameTf);
		 
		 id = new JLabel("Id");
		 id.setBounds(35, 120, 100, 20);
		 id.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(id);
		 
		 String Options[] =  { "AadharCard", " Passport", "VoterIdCard" };
		 comboid = new JComboBox(Options);
		 comboid.setBounds(200, 120, 150, 25);
		 comboid.setBackground(Color.WHITE);
		 add(comboid); 

		 number = new JLabel("Id Number");
		 number.setBounds(35, 160, 100, 20);
		 number.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(number);
		 
		 numberTf = new JTextField();
		 numberTf.setBounds(200, 160, 150, 25);
		 add(numberTf);
		 
		 gender = new JLabel("Gender");
		 gender.setBounds(35, 200, 100, 20);
		 gender.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(gender);
		 male = new JRadioButton("Male");
         male.setBackground(Color.WHITE);
         male.setBounds(200, 200, 60, 25);
         add(male);

         female = new JRadioButton("Female");
         female.setBackground(Color.WHITE);
         female.setBounds(280, 200, 70, 25);
         add(female);
         ButtonGroup bg = new ButtonGroup();
         bg.add(female);
         bg.add(male);
         
          country = new JLabel("Country");
          country.setBounds(35, 240, 150, 20);
          country.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(country);
		 
		 countryTf = new JTextField();
		 countryTf.setBounds(200, 240, 150, 25);
		 add(countryTf);
		
		 room = new JLabel("Room No.");
		 room.setBounds(35, 280, 100, 20);
		 room.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(room);
		 croom = new Choice();
		 
		 try {
			 Conn c = new Conn();
			 String query = "select * from room where availability = 'Available'";
			 ResultSet rs =c.s.executeQuery(query);
			 while(rs.next()) {
				 croom.add(rs.getString("roomnumber"));
				 
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		 
		 croom.setBounds(200, 280, 150, 25);
		 add(croom);
		 
		 time= new JLabel("Checkin time");
		 time.setBounds(35, 320, 150, 20);
		 time.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(time);
		 
		 Date d = new Date();
		 
		 
		 checktime= new JLabel(" "+d);
		 checktime.setBounds(200, 320, 150, 25);
		 checktime.setFont(new Font("Raleway",Font.PLAIN,15));
		 add(checktime);
		 
		deposit= new JLabel("Deposit ");
		deposit.setBounds(35, 360, 150, 25);
		deposit.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(deposit);
		 depo = new JTextField();
		 depo.setBounds(200, 360, 150, 25);
		 add(depo);
		 
		 addd = new JButton("Add");
		 addd.setBounds(50,420,120,30);
		 addd.setFont(new Font("serif",Font.BOLD,30));
		 addd.setBackground(Color.BLACK);
		 addd.setForeground(Color.WHITE);
		 addd.addActionListener(this);
	     add(addd);
	     
	     back = new JButton("Back");
	     back.setBounds(200,420,120,30);
	     back.setFont(new Font("serif",Font.BOLD,30));
	     back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		 back.addActionListener(this);
	     add(back);
	     
	     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/customer.png"));
			Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
			ImageIcon i3= new ImageIcon(i2);
		    JLabel image = new JLabel(i1);
		    image.setBounds(270, 10, 500, 500);
		    add(image);	
		
		setBounds(350, 200, 800, 550);
		setVisible(true);
	}	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == addd) {
				String namee = nameTf.getText();
				String idd =(String) comboid.getSelectedItem();
				String Numberr = numberTf.getText();
				String genderr = null;
				if(male.isSelected()) {
					genderr = "Male";
				}else {
					genderr ="Female";
				}
				
				String countryy = countryTf.getText();
				String room1 = croom.getSelectedItem();
				System.out.println(room1);
				String checkintime= checktime.getText();
				String deposite = depo.getText();
				
				try {
					System.out.println(namee);
                  String query =" Insert into customer values ('"+namee+"','"+idd+"', '"+Numberr+"','"+genderr  +"','"+countryy+"', '"+room1+"','"+checkintime+"','"+deposite+"')";
				  String query2 = "update room set availability	= 'Occupied' where roomnumber='"+room1+"'";
				  
				  Conn c = new Conn();
				  c.s.executeUpdate(query);
				  c.s.executeUpdate(query2);
				  JOptionPane.showMessageDialog(null,"New customer added successfully");
                  setVisible(false);
                   new Reception();
                  
				}catch(Exception ee) {
					ee.printStackTrace();
				}
			
		   } else if(e.getSource() == back) {
			   setVisible(false);
               new Reception();
		   }
		
	}

	public static void main(String[] args) {
       new AddCustomer();
       
	}

	
}
