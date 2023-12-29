package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
	JTextField textfield1, textfield2;
	JLabel available, heading,roomno,clean,l10,roomprice;
	JComboBox comboBox,cleancombo, cleancombo1;
	JButton b1, b2;
	
	AddRooms(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tamoha",Font.BOLD,16));
		heading.setBounds(194, 10, 120, 22);
		add(heading);
		
	    roomno = new JLabel("Room Number");
		roomno.setFont(new Font("Tamoha",Font.PLAIN,16));
		roomno.setBounds(60, 80, 120, 30);
		add(roomno);
		
	    textfield1 = new JTextField();
		textfield1.setBounds(200, 80, 150, 30);
	    add(textfield1);
	     
	    available = new JLabel("Available");
		available.setFont(new Font("Tamoha",Font.PLAIN,16));
	    available.setBounds(60, 130, 120, 30);
		add(available);
		  
		String availableOptions[]= {"Available","Occupied"};
	    comboBox = new JComboBox(availableOptions);
		comboBox.setBounds(176, 110, 154, 20);
		comboBox.setBounds(200, 130, 150, 30);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);
			 
	    clean = new JLabel("Cleaning Status");
		clean.setFont(new Font("Tamoha",Font.PLAIN,16));
		clean.setBounds(60, 180, 120, 30);
		add(clean);
				
		 String cleanOptions[] =  { "Cleaned", "Dirty" };
		 cleancombo = new JComboBox(cleanOptions);
		 cleancombo.setBounds(200, 180, 150, 30);
		 cleancombo.setBackground(Color.WHITE);
		 add(cleancombo);
				 
		roomprice= new JLabel("Room Price");
		roomprice.setFont(new Font("Tamoha",Font.PLAIN,16));
		roomprice.setBounds(60, 230, 120, 30);
		add(roomprice);
					
		 textfield2 = new JTextField();
		 textfield2.setBounds(200, 230, 150, 30);
		 add(textfield2);
		
		 l10 = new JLabel("Bed Type");
	     l10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 l10.setBounds(60, 280, 120, 30);
		 add(l10);
		 
		 String typeOptions[] =  { "Single Bed", "Double Bed" };
			 cleancombo1 = new JComboBox(typeOptions);
			 cleancombo1.setBounds(200, 280, 150, 30);
			 cleancombo1.setBackground(Color.WHITE);
			 add(cleancombo1);
			 
			 b1 = new JButton("Add Room");
				b1.addActionListener(this);
				b1.setBounds(60, 350, 130, 30);
			        b1.setBackground(Color.BLACK);
			        b1.setForeground(Color.WHITE);
				add(b1);

				b2 = new JButton("Cancel");
				b2.addActionListener(this);
				b2.setBounds(220, 350, 130, 30);
			        b2.setBackground(Color.BLACK);
			        b2.setForeground(Color.WHITE);
				add(b2);
				
				ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/bed.jpeg"));
			    JLabel image = new JLabel(i1);
			    image.setBounds(400, 50, 500, 300);
			    add(image);
		          
 
		
		setBounds(330,200,940,470);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		  try{

	            if(e.getSource() == b1){
	                try{
	                Conn c = new Conn();
	                String room = textfield1.getText();
	                String availability = (String)comboBox.getSelectedItem();
	                String status = (String)cleancombo.getSelectedItem();
	                String price  = textfield2.getText();
	                String type = (String)cleancombo1.getSelectedItem();
	                String str = "INSERT INTO room values( '"+room+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";


			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Room Successfully Added");
	                this.setVisible(false);

	                }catch(Exception ee){
	                    System.out.println(ee);
	                }
	            }
	            else if(e.getSource() == b2){
	                this.setVisible(false);
	            }
	        }catch(Exception eee){

	        }
	    }
	
	public static void main(String[] args) {
	      new AddRooms();
			
		}

}
