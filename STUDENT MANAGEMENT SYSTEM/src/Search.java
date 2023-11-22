import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.css.PseudoClass;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;



public class Search {
	JButton searchS ,back;
	Font h1= new Font("SansSerif", Font.BOLD,40);
	Font h2  = new Font("Osward",Font.BOLD,20);
	Font h3  = new Font("Osward",Font.BOLD,15);
	Font inputh2 = new Font("Raleway", Font.BOLD, 22);
	 JFrame f = new JFrame("Search Students ");
	 JTextField enrollmenno ;
	 String s;
	 JLabel lprogam,lgender,lDOB,lfathersname,lfathersmobileno,lmobileno,lenrollmentno,lname;
	 public Search() {
		 
		 back = new JButton("Home Page ");
		 back.setBounds(2,2,150,30);
		 back.setFont(h3);
		 f.add(back);
	 
		 back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent a) {
				f.dispose();
				Index xIndex = new Index();
				
			}
		});
		
		 
		 JLabel heading = new JLabel("Search Student details  ");
			heading.setFont(h2);
			heading.setBounds(100,50,500,60);
			f.add(heading);
		 
		 JLabel enrollmentno = new  JLabel("Enrollment number = ");
			enrollmentno.setBounds(30,150,250,40);
			enrollmentno.setFont(inputh2);
			f.add(enrollmentno);
			
			
			this.enrollmenno = new JTextField();
			this.enrollmenno.setBounds(250,150,230,40);
			this.enrollmenno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			this.enrollmenno.setFont(inputh2);
			f.add(this.enrollmenno);
			
			searchS = new JButton("Search ");
			this.searchS.setBounds(480,150,60,40);
			this.searchS.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			f.add(searchS);
			searchS.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent a) {
						s= enrollmenno.getText();
						//System.out.print(s);
						try{
							f.remove(lname);
			                f.remove(lenrollmentno);
			                f.remove(lDOB);
			                f.remove(lgender);
			                f.remove(lmobileno);
			                f.remove(lprogam);
			                f.remove(lfathersname);
			                f.remove(lfathersmobileno);
						}
						catch(Exception e){
							
						}
						try {
						Connection con=DBCon.getConnection();
						Statement stmt = con.createStatement();
						
						PreparedStatement ps =con.prepareStatement("select * from studentdata where enrollmenno=?");
					
							//System.out.print("SQL");
							ps.setString (1,s);
							
							//ps.execute();
							ResultSet rs =ps.executeQuery();
						System.out.println(rs);
							 
								//System.out.println(rs.next());
								if(rs.next()) {
									   System.out.print("IF_ACMPEQ rs ");
				            	
				                String name = rs.getString("name");
				                String enrollmenno = rs.getString("enrollmenno");
				                long mobileno= rs.getLong("mobileno");
				                long fathersmobileno= rs.getLong("fathersmobileno");
				                
				                String fathersname = rs.getString("fathersname");
				                String dob = rs.getString("dob");
				                String program = rs.getString("program");
				                String branch = rs.getString("branch");
				                String gender = rs.getString("gender");
				                
				                 
				                lname = new JLabel("Name ="+"            " +name);
				                lenrollmentno = new JLabel("Enrollment no = "+ enrollmenno);
				                lDOB = new JLabel("D.O.B =           "+dob);
				                lgender = new JLabel("Gender =          "+gender);
				                lmobileno = new JLabel("mobile no =       "+ mobileno);
				                lprogam = new JLabel("program =       "+ program+"    \t\t Branch = "+branch);
				                lfathersname = new JLabel("Parents name = "+ fathersname);
				                lfathersmobileno = new JLabel("parents mobile no =  "+ fathersmobileno);
				                lname.setBounds(5,250,600,40);
				                lenrollmentno.setBounds(5,300,600,40);
				                lDOB.setBounds(5,350,600,40);
				                lgender.setBounds(5,400,600,40);
				                lmobileno.setBounds(5,450,600,40);
				                lprogam.setBounds(5,500,600,40);
				                lfathersname.setBounds(5,550,600,40);
				                lfathersmobileno.setBounds(5,600,600,40);
				                f.add(lname);
				                f.add(lenrollmentno);
				                f.add(lDOB);
				                f.add(lgender);
				                f.add(lmobileno);
				                f.add(lprogam);
				                f.add(lfathersname);
				                f.add(lfathersmobileno);
				                
				                lname.setFont(h2);
				                lenrollmentno.setFont(h2);
				                lDOB.setFont(h2);
				                lgender.setFont(h2);
				                lmobileno.setFont(h2);
				                lprogam.setFont(h2);
				                lfathersname.setFont(h2);
				                lfathersmobileno.setFont(h2);
				                
				                
				                System.out.println("ss");
				                f.repaint();f.revalidate();
							}
						else{
									JFrame parent = new JFrame();
								    JOptionPane.showMessageDialog(parent," Error : Data not founf for given data \n Enter Correct enrollmenno ");
								}
						
						                f.repaint();f.revalidate();
						               
						              f.repaint();
						            
					}
						catch(SQLException e){
							System.out.print(e.getMessage());
							System.out.print(e.getSQLState());
							System.out.print(e.getMessage());
							JFrame parent = new JFrame();
						    JOptionPane.showMessageDialog(parent,e.getMessage());
						}
						catch(Exception e){
							System.out.print(e.getMessage());
							System.out.print(((SQLException) e).getSQLState());
							System.out.print(e.getMessage());
							JFrame parent = new JFrame();
						    JOptionPane.showMessageDialog(parent,e.getMessage());
							
						}
					}
				});
			
		 f.setLayout(null);
			f.setSize(600,700);
			f.setVisible(true);
			f.setLocation(100, 25);
			f.setBackground(Color.WHITE);
	}

}
