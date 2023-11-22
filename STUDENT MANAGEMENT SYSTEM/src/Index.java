import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//adding a new student
//editing an existing student's information,
//searching for a student
// displaying all students
//exiting the application

public class Index extends DBCon {
	
	 JButton searchS , allS, addS, editS, exit;
		Font h1= new Font("SansSerif", Font.BOLD,40);
		Font h2  = new Font("Osward",Font.BOLD,20);
		Font inputh2 = new Font("Raleway", Font.BOLD, 22);
		 JFrame f = new JFrame("Home Page ");
	 
	 
	public Index() {
	
	 f.setLayout(null);
	 
	 JLabel welcomeJLabel=  new JLabel("WelCome");
	 JLabel headig = new JLabel("Student Management System");
	 headig.setBounds(10,100,600,80);
	 headig.setFont(h1);
	 f.add(headig);
	 
	 welcomeJLabel.setBounds(200,10,200,80);
	 welcomeJLabel.setFont(h1);
	// f.add(welcomeJLabel);
	 
	 
	 searchS = new JButton("Searching For A Student");
	 searchS.setBorder(BorderFactory.createLineBorder(new Color(255-255- 0),3));
	 searchS.setFont(inputh2);
	 searchS.setBackground(Color.yellow);
	 searchS.setBounds(60,200,500,50);
	 f.add(searchS);
	 searchS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
				Search search= new Search();
				f.dispose();
				}
				catch(Exception e ){
					
				}
			}
		});
	 
	 
	 
	 allS= new JButton("Displaying All Students ");
	 allS.setBorder(BorderFactory.createLineBorder(new Color(255-204- 0),3));
	 allS.setFont(inputh2);
	 allS.setBackground(Color.yellow);
	 allS.setBounds(60,270,500,50);
	 f.add(allS);
	 
	 
	 allS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					DisplayData display= new DisplayData();
					f.dispose();
				}
				catch(Exception e ){
					
				}
			}
		});
	 
	 
	 
	 addS= new JButton("Adding a New Student ");
	 addS.setBorder(BorderFactory.createLineBorder(new Color(255-204- 0),3));
	 addS.setFont(inputh2);
	 addS.setBackground(Color.yellow);
	 addS.setBounds(60,340,500,50);
	 f.add(addS);
	 
	 addS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					
					
					Registration sGui_Interface= new Registration();
					f.dispose();
				}
				catch(Exception e ){
					
				}
			}
		});
	 
	 
	 
	 editS= new JButton("Editing An Existing Student's Information, ");
	 editS.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
	 editS.setFont(inputh2);
	 editS.setBackground(Color.yellow);
	 editS.setBounds(60,410,500,50);
	 f.add(editS);
	 
	 editS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					Edit edit= new  Edit();
					f.dispose();
				}
				catch(Exception e ){
					
				}
			}
		});
	 
	 
	 exit= new JButton("Exit");
	 exit.setBorder(BorderFactory.createLineBorder(Color.black,3));
	 exit.setFont(inputh2);
	 exit.setBackground(Color.RED);
	 exit.setBounds(60,480,500,50);
	 f.add(exit);
	 
	 exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					System.exit(0);
					
				}
				catch(Exception e ){
					
				}
			}
		});
	 
		
	
		f.setSize(600,700);
		f.setVisible(true);
		f.setLocation(100, 25);
		f.setBackground(Color.WHITE);
		 f.setLayout(null);
		
	}
	
	
	public static void main(String[] args) {
	
		Index sGui_Interface= new Index();
		
		
	}

}
