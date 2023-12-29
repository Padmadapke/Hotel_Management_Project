package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener{
	JTextField textfield1, textfield2, textfield3,textfield4,textfield5;
	JLabel available, heading,name,clean,l10,roomprice, l11;
	JComboBox comboBox,cleancombo, cleancombo1;
	JButton b1, b2;
	JMenuItem adddriver;
	AddDrivers(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tamoha",Font.BOLD,20));
		heading.setBounds(120, 10, 120, 22);
		add(heading);
		
	    name = new JLabel("Name");
		name.setFont(new Font("Tamoha",Font.PLAIN,16));
		name.setBounds(60, 50, 120, 30);
		add(name);
		textfield1 = new JTextField();
		textfield1.setBounds(200, 50, 150, 30);
	    add(textfield1);
	     
	    available = new JLabel("Age");
		available.setFont(new Font("Tamoha",Font.PLAIN,16));
	    available.setBounds(60, 90, 120, 30);
		add(available);
		textfield2 = new JTextField();
		textfield2.setBounds(200, 90, 150, 30);
	    add(textfield2);
		  
		/*String availableOptions[]= {"Available","Occupied"};
	    comboBox = new JComboBox(availableOptions);
		comboBox.setBounds(176, 110, 154, 20);
		comboBox.setBounds(200, 130, 150, 30);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);*/
			 
	    clean = new JLabel("Gender");
		clean.setFont(new Font("Tamoha",Font.PLAIN,16));
		clean.setBounds(60, 130, 120, 30);
		add(clean);
		String cleanOptions[] =  { "Male", "Female" };
		 cleancombo = new JComboBox(cleanOptions);
		 cleancombo.setBounds(200, 130, 150, 30);
		 cleancombo.setBackground(Color.WHITE);
		 add(cleancombo);
				 
		roomprice= new JLabel("Car Company");
		roomprice.setFont(new Font("Tamoha",Font.PLAIN,16));
		roomprice.setBounds(60, 170, 120, 30);
		add(roomprice);
	    textfield3 = new JTextField();
		 textfield3.setBounds(200, 170, 150, 30);
		 add(textfield3);
		
		 l10 = new JLabel("Car Model");
	     l10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 l10.setBounds(60, 210, 120, 30);
		 add(l10);
		 textfield4 = new JTextField();
		 textfield4.setBounds(200, 210, 150, 30);
		 add(textfield4);
		 
		    available = new JLabel("Availability");
			available.setFont(new Font("Tamoha",Font.PLAIN,16));
		    available.setBounds(60, 250, 120, 30);
			add(available);
		    String typeOptions[] =  { "Available", " Busy" };
			 cleancombo1 = new JComboBox(typeOptions);
			 cleancombo1.setBounds(200, 250, 150, 30);
			 cleancombo1.setBackground(Color.WHITE);
			 add(cleancombo1);
			 
			 l11 = new JLabel("Location");
		     l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
			 l11.setBounds(60, 290, 120, 30);
			 add(l11);
			 textfield5 = new JTextField();
			 textfield5.setBounds(200, 290, 150, 30);
			 add(textfield5);
			 
			 b1 = new JButton("Add Driver");
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
				
				ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/car.jpg"));
				Image i2 = i1.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
				ImageIcon i3= new ImageIcon(i2);
			    JLabel image = new JLabel(i1);
			    image.setBounds(400, 50, 500, 300);
			    add(image);
 
		setBounds(330,200,940,470);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
	
	try{

        if(e.getSource() == b1){
            try{
            Conn c = new Conn();
            String name = textfield1.getText();
            String age = textfield2.getText();
            		//(String)comboBox.getSelectedItem();
            String gender = (String)cleancombo.getSelectedItem();
            String company  = textfield3.getText();
            String brand = textfield4.getText();
            		
            String availability = (String)cleancombo1.getSelectedItem();;
            String location =l11.getText();   
            String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"','"+availability+"','"+location+"')";

			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Driver Successfully Added");
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
             new AddDrivers();
	}

	
	

}
