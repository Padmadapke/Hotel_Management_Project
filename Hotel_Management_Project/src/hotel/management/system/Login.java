package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    JLabel user,pass;

    Login(){
    	Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
		setSize(size);
	    setLocation(0,0);
    	getContentPane().setBackground(Color.WHITE);
    	setBounds(1150, 750,150, 50 );
    	setVisible(true);
        setLayout(null);

      
        user = new JLabel("Username");
        user.setBounds(400,70,100,30);
        add(user);

         pass = new JLabel("Password");
        pass.setBounds(400,120,100,30);
        add(pass);

        username=new JTextField();
        username.setBounds(520,70,150,30);
        add(username);

         password =new JPasswordField();
        password.setBounds(520,120,150,30);
        add(password);
        
      login = new JButton("Login");
        login.setBounds(400,200,120,30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

         cancel =new JButton("Cancel");
        cancel.setBounds(550,200,120,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


      getContentPane().setBackground(Color.WHITE);

        setVisible(true);
       setSize(size);
        setLocation(0,0);
    } 
    public void actionPerformed(ActionEvent ae) {
	if(ae.getSource() == login) {
        	 String user = username.getText();
                 String pass = password.getText();
                  try {
                	  Conn c =new Conn();
                 String query = "select * from login where username='"+user+"' and password='"+pass+"'";

                 ResultSet rs = c.s.executeQuery(query); 
                 
                 if(rs.next()){ 
                     new Dashboard().setVisible(true);
                     setVisible(false);
                 }else{
                     JOptionPane.showMessageDialog(null, "Invalid login");
                     setVisible(false);
                 }
            	
            }catch(Exception e) {
            	 e.printStackTrace();
            }
            
    	}else if(ae.getSource() == cancel) {
    		System.exit(0);
    	}
    	
    	
    }
    public static void main(String[] arg){
        new Login();
    }
}