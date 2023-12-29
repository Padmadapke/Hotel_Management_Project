package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{
	HomePage(){
		Dimension size = Toolkit. getDefaultToolkit(). getScreenSize();
		setSize(size);
		setLocation(0,0);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/FirstIcon.jpg"));
	    JLabel image = new JLabel(i1);
	    image.setBounds(10, 0, 1, 565);
	    add(image);
	    
	    JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
	    text.setBounds(500, 700, 1000, 100);
	    text.setForeground(Color.BLACK);
	    text.setFont( new Font("Times New Roman",Font.PLAIN,30));
	    
	    JButton next = new JButton("Next");
	    next.setBounds(1150, 750,150, 50 );
	    image.add(next);
	    next.setBackground(Color.BLACK);
	    next.setForeground(Color.WHITE);
	    next.addActionListener(this);
	    next.setFont(new Font("serif",Font.PLAIN,24));
	    image.add(text);
	    
		setVisible(true);
		
		while(true) {
			text.setVisible(false);

			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
				
			}	
		}	
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}
	public static void main(String[] args) {
		new HomePage(); 

	}

}
