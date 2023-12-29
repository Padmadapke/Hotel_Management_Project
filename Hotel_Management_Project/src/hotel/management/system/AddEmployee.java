package hotel.management.system;

	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	import javax.swing.*;

	public class AddEmployee extends JFrame implements ActionListener{


		 JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
	        JComboBox c1;
	        JRadioButton male, female;
	        JButton Next;
	        JLabel lblname, Pnrno, Gender,Address,Nationality,Name,Phno, email,AddPassengers;

	         public AddEmployee(){
	           Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
	     		setSize(size);
	     	    setLocation(0,0);
	            getContentPane().setBackground(Color.WHITE);
	            setTitle("ADD EMPLOYEE DETAILS");

	            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            setSize(778,486);
	            getContentPane().setLayout(null);

	            lblname = new JLabel("NAME");
	           lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            lblname.setBounds(60, 30, 150, 27);
	             add(lblname);

	            textField = new JTextField();
	            textField.setBounds(200, 30, 150, 27);
	            add(textField);

	             Next = new JButton("SAVE");
	            Next.setBounds(200, 420, 150, 30);
	            Next.setBackground(Color.BLACK);
	            Next.setForeground(Color.WHITE);
	            add(Next);

	             Pnrno = new JLabel("AGE");
	            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Pnrno.setBounds(60, 80, 150, 27);
	            add(Pnrno);

	            textField_1 = new JTextField();
	            textField_1.setBounds(200, 80, 150, 27);
	            add(textField_1);

	             Gender = new JLabel("GENDER");
	            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Gender.setBounds(60, 120, 150, 27);
	            add(Gender);

	            male = new JRadioButton("MALE");
	            male.setBackground(Color.WHITE);
	            male.setBounds(200, 120, 70, 27);
	            add(male);

	            female = new JRadioButton("FEMALE");
	            female.setBackground(Color.WHITE);
	            female.setBounds(280, 120, 70, 27);
	            add(female);
	            ButtonGroup bg = new ButtonGroup();
	            bg.add(female);
	            bg.add(male);


	             Address = new JLabel("JOB");
	            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Address.setBounds(60, 170, 150, 27);
	            add(Address);

	            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
	            c1 = new JComboBox(course);
	            c1.setBackground(Color.WHITE);
	            c1.setBounds(200,170,150,30);
	            add(c1);

	             Nationality = new JLabel("SALARY");
	            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Nationality.setBounds(60, 220, 150, 27);
	            add(Nationality);  

	           textField_3 = new JTextField();
	            textField_3.setBounds(200, 220, 150, 27);
	            add(textField_3);

	             Name = new JLabel("PHONE");
	            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Name.setBounds(60, 270, 150, 27);
	            add(Name);

	            textField_4 = new JTextField();
	            textField_4.setBounds(200, 270, 150, 27);
	            add(textField_4);

	            Phno = new JLabel("AADHAR");
	            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            Phno.setBounds(60, 320, 150, 27);
	            add(Phno);

	            textField_5 = new JTextField();
	            textField_5.setBounds(200, 320, 150, 27);
	            add(textField_5);


	             email = new JLabel("EMAIL");
	            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
	            email.setBounds(60, 370, 150, 27);
	            add(email);

	            textField_6 = new JTextField();
	            textField_6.setBounds(200, 370, 150, 27);
	            add(textField_6);

	            setVisible(true);

	             AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
	            AddPassengers.setForeground(Color.BLUE);
	            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
	            AddPassengers.setBounds(450, 24, 442, 35);
	            add(AddPassengers);


	            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/epl.jpg"));
	            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
	            ImageIcon i2 = new ImageIcon(i3);
	            JLabel image = new JLabel(i2);
	            image.setBounds(410,80,480,410);
	            add(image);

	         
	           Next.addActionListener(new ActionListener(){
	                public void actionPerformed(ActionEvent ae){
	                    String name = textField.getText();
	                    String age = textField_1.getText();
	                    String salary = textField_3.getText();
	                    String phone = textField_4.getText();
	                    String aadhar = textField_5.getText();
	                    String email = textField_6.getText();

	                    String gender = null;
	                    if(name.equals("")) {
	                    	 JOptionPane.showMessageDialog(null,"Name should not be empty");
	                    	 return;
	                    }
	                  

	                    if(male.isSelected()){
	                        gender = "male";

	                    }else if(female.isSelected()){
	                        gender = "female";
	                    }


	                    String job = (String)c1.getSelectedItem();

	                    try {
	                       
	                    	Conn c = new Conn();
	                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";

	                        c.s.executeUpdate(str);
	                        JOptionPane.showMessageDialog(null,"Employee Added Successfully");
	                        setVisible(false);

	                    } catch (Exception e) {
	                        e.printStackTrace();
	        	    }
			   }
	            });

	            setSize(900,600);
	            setVisible(true);
	            setLocation(400,200);

		}

	    public static void main(String[] args){
	        new AddEmployee();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}   
	}