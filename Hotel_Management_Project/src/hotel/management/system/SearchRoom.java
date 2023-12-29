package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
	JComboBox bedType;
	JTable table;
	JButton back,submit;
	JCheckBox available;
	public SearchRoom() {
		
		
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel text = new JLabel("Search for Room");
			text.setFont(new Font("Tahoma",Font.BOLD,20));
			text.setBounds(400, 30, 200, 30);
			add(text);
			
			JLabel lblbed = new JLabel("Bed Type");
			lblbed.setBounds(50, 100, 100,20 );
		    add(lblbed);
		    
		    String cleanOptions[] =  { "Single Bed", "Double Bed" };
			 bedType = new JComboBox(cleanOptions);
			 bedType.setBounds(150, 100, 150, 25);
			 bedType.setBackground(Color.WHITE);
			 add(bedType);
		    
			available = new JCheckBox("Only display Available");
			available.setBounds(650, 100, 150, 25);
			available.setBackground(Color.WHITE);
			add(available);
			 
			JLabel l1 = new JLabel("Room Number");
		    l1.setBounds(50, 160, 100,20 );
		    add(l1);
		    
		    JLabel l2 = new JLabel("Availability");
		    l2.setBounds(270, 160, 100,20 );
		    add(l2);
		    
		    JLabel l3 = new JLabel("Cleaning Status");
		    l3.setBounds(450, 160, 100,20 );
		    add(l3);
		    
		    JLabel l4 = new JLabel("Price");
		    l4.setBounds(630, 160, 100,20 );
		    add(l4);
		    
		    JLabel l5 = new JLabel("Bed Type");
		    l5.setBounds(820, 160, 100,20 );
		    add(l5);
		    
		    table = new JTable();
		    table.setBounds(0,200,1000,300);
		    add(table);
		  
		    try {
		    	Conn c = new Conn();
		    	ResultSet rs = c.s.executeQuery("select * from room");
		    	table.setModel(DbUtils.resultSetToTableModel(rs));
		    	
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		    
		    submit = new JButton("Submit");
		    submit.setBackground(Color.BLACK);
		    submit.setForeground(Color.WHITE);
		    submit.addActionListener(this);
		    submit.setBounds(300, 500, 120,30);
			add(submit);
		    
		    back = new JButton("Back");
		    back.setBackground(Color.BLACK);
		    back.setForeground(Color.WHITE);
		    back.addActionListener(this);
		    back.setBounds(520, 500, 120,30);
			add(back);
			
			setBounds(300,200,1000,600);
			setVisible(true);
		    
		    
		}

	
		

		@Override
		public void actionPerformed(ActionEvent e) {
           if(e.getSource()== submit ) {
        	   try {
        		   String s1 = "select * from room where bed_type='"+bedType.getSelectedItem()+"'";
        		   String s2 = "select * from room where availability='Available' AND bed_type='"+bedType.getSelectedItem()+"'";
        		   Conn c = new Conn();
        		   ResultSet rs;
        		   
        		   if(available.isSelected()) {
        			   rs = c.s.executeQuery(s2);
        		   }else {
        			   rs = c.s.executeQuery(s1);
        		   }
        		   table.setModel(DbUtils.resultSetToTableModel(rs));
        		   
        		   
        	   }catch(Exception ae) {
        		   ae.printStackTrace();
        	   }
           }else {
			setVisible(false);
			new Reception();
		}

		}

	
	public static void main(String[] args) {
          new SearchRoom();
		
	}

}
