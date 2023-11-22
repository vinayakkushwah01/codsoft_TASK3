import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Registration {
	JFrame f= new JFrame();
	JLabel lprogam,lgender,lDOB,lfathersname,lfathersmobileno,lmobileno,lenrollmentno,lname;
	JTextField name , enrollmenno, mobileno, fathersmobileno, fathersname,dob,program,enrollmen_no;
	JRadioButton male, female;
	JComboBox branchComboBox,programComboBox,perameter_to_edit;
	final JTextField text = new JTextField(20);
	ButtonGroup gender = new ButtonGroup();
	JButton submit , clear,searchButton,b,back;
	Font h1= new Font("SansSerif", Font.BOLD,40);
	Font h2  = new Font("Osward",Font.BOLD,20);
	Font inputh2 = new Font("Raleway", Font.BOLD, 18);
	JTextArea address = new JTextArea();
	int choise;
	String _name,_enrollmentno,_parentName,_dob,_gender,_program,_branch,_selected;
	long _mobileno;
	long _parentno;
	
	 public Registration() {
		 
		 back = new JButton("Home Page ");
		 back.setBounds(2,2,150,30);
		 back.setFont( new Font("Osward",Font.BOLD,15));
		 f.add(back);
		 
		 back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent a) {
				f.dispose();
				Index xIndex = new Index();
				
			}
		});
		 
		 
		 Options();
		 

		 JLabel heading = new JLabel("Register new Student");
			heading.setFont(h1);
			heading.setBounds(100,50,500,60);
			f.add(heading);
			
						
			String [] perameter_to_edits = {"Name" , "Enrollmen No", "Mobileno", "Partents Mobileno", "Parents Name","Dob","Gender", "Program / Bramch"};
			
			
			
			clear = new JButton("Clear");
			clear.setBorder(BorderFactory.createLineBorder(Color.RED,2));
			clear.setFont(inputh2);
			clear.setBackground(Color.RED);
			clear.setBounds(60,600,150,40);
			submit= new JButton("Submit ");
			submit.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
			submit.setFont(inputh2);
			submit.setBackground(Color.GREEN);
			submit.setBounds(400,600,150,40);
			f.add(submit);
			f.add(clear);
			
			
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					
					try{
					_name = name.getText();
					_enrollmentno = enrollmenno.getText();
					//_gender = String(male.get)
					_mobileno =Long.parseLong( mobileno.getText());
					_program = (String)programComboBox.getSelectedItem();
					_branch = (String) branchComboBox.getSelectedItem();
					_parentName = fathersname.getText();
					_parentno= Long.parseLong(fathersmobileno.getText());
					_gender = (male.isSelected())? "male":"female";
					
					//_gender= "male";
					
					Connection con=DBCon.getConnection();
					Statement stmt = con.createStatement();
					PreparedStatement ps =

							con.prepareStatement("insert into studentdata " +

                   "(name, enrollmenno, mobileno, fathersmobileno, fathersname, dob, program, branch, gender) " +

                   "values (?, ?, ?,?, ?, ?,?, ?, ?)");

					try {
						System.out.print("SQL");
						ps.setString (1, _name);

						ps.setString(2, _enrollmentno);

						ps.setLong(3,_mobileno);
   
						ps.setLong(4, _parentno);
						ps.setString (5, _parentName);
						ps.setString(6, _dob);
						ps.setString(7, _program);
						ps.setString(8, _branch);
						ps.setString(9, _gender);
						
					
						ps.execute();
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent, "Data Add sucessfully");

					}
					catch (Exception r){
						System.out.print(r.getMessage());
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent,r.getMessage());
					}
					
					
					
					}
					catch(NullPointerException e){
						System.out.print("enter all the felds Correctly");
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent, e.getMessage());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent,e.getMessage());
					}
					catch (Exception e) {
						// TODO: handle exception
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent,e.getMessage());
					}
				
				}
			});
		
			
			clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					try{
						name.setText("");
						enrollmenno.setText("");
						text.setText("");
						//gender.setSelected(male, false);
						mobileno.setText("");
						fathersmobileno.setText("");
						fathersname.setText("");
						
					}
					catch(Exception e ){
						JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent,e.getMessage());
						
					}
				}
			});
	
			
			
	
		// TODO Auto-generated constructor stub
		 f.setLayout(null);
			f.setSize(600,700);
			f.setVisible(true);
			f.setLocation(100, 25);
			f.setBackground(Color.WHITE);
	 }
	
	
	 
	 
	 
	 void Options( ){
	
						//System.out.print(c);
				//Name
				//System.out.print("name ");
				 lname = new JLabel("Full Name = ");
				 lname.setBounds(30,150,250,40);
				 lname.setFont(h2);
				f.add(lname);
				
				
				
				this.name = new JTextField();
				this.name.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.name.setFont(inputh2);
				this.name.setBounds(300,150,250,40);
				f.add(this.name);
				
		
				//Enrollmen No
				//System.out.print("Enrollment ");
				 lenrollmentno = new  JLabel("Enrollment number = ");
				 lenrollmentno.setBounds(30,200,250,40);
				 lenrollmentno.setFont(h2);
				f.add(lenrollmentno);
				
				
				this.enrollmenno = new JTextField();
				this.enrollmenno.setBounds(300,200,250,40);
				this.enrollmenno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.enrollmenno.setFont(inputh2);
				f.add(this.enrollmenno);
				
			
			
				
			
				
				//Dob
				lDOB = new JLabel("Selected Date OF Birth = :");
				
				 b = new JButton("Select");
				//JPanel p = new JPanel();
				lDOB.setBounds(30,250,250,40);
				text.setBounds(300,250,175,40);
				b.setBounds(475,250,75,40);
				//p.setBounds(300,300,250,40);
				f.add(lDOB);
				lDOB.setFont(h2);
				f.add(text);
				text.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				text.setFont(inputh2);
				f.add(b);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						_dob=(new DatePicker(f).setPickedDate());
						text.setText(_dob);
					}
				});
				
				
				//Gender
				 lgender = new JLabel("Gender = ");
				 lgender.setBounds(30,300,250,40);
				 lgender.setFont(h2);
				f.add(lgender);
				
				male = new  JRadioButton("Male");
				female = new JRadioButton("Female");
				this.male.setBounds(300,300,100,40);
				this.male.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.male.setFont(inputh2);
				this.female.setBounds(400,300,100,40);
				this.female.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.female.setFont(inputh2);
				f.add(this.male);
				f.add(this.female);
				this.gender.add(male);
				this.gender.add(female);
				
		
				//Program / Bramch
				lprogam = new JLabel("Program /Branch");
				lprogam.setBounds(30,350,250,40);
				lprogam.setFont(h2);
				f.add(lprogam);
				
				String [] sProgram = {"B TECH", "M TECH","BCA","DEPLOMA"};
				String [] sBranch = {"CSE","M.E","E.E","C.E","E.C","OTHER"};
				
				 programComboBox = new JComboBox(sProgram);
				programComboBox.setBounds(300,350,100,40);
				f.add(programComboBox);
				 branchComboBox=  new JComboBox(sBranch);
				branchComboBox.setBounds(430,350,100,40);
				f.add(branchComboBox);
				
				//Mobileno
				lmobileno = new JLabel("Mobile Number  = ");
				lmobileno.setBounds(30,400,250,40);
				lmobileno.setFont(h2);
				f.add(lmobileno);
				
				
				this.mobileno = new JTextField();
				this.mobileno.setBounds(300,400,250,40);
				this.mobileno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.mobileno.setFont(inputh2);
				f.add(this.mobileno);
				
				//Parents Name
				lfathersname = new  JLabel("Parents Name = ");
				lfathersname.setBounds(30,450,250,40);
				lfathersname.setFont(h2);
				f.add(lfathersname);
				
				
				
				this.fathersname = new JTextField();
				this.fathersname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.fathersname.setFont(inputh2);
				this.fathersname.setBounds(300,450,250,40);
				f.add(this.fathersname);
				
				//Partents Mobileno
				 lfathersmobileno  = new JLabel("Parents Mobile Number = ");
				 lfathersmobileno.setBounds(30,500,250,40);
				 lfathersmobileno.setFont(h2);
				f.add(lfathersmobileno);
				
				
				
				this.fathersmobileno = new JTextField();
				this.fathersmobileno.setBounds(300,500,250,40);
				this.fathersmobileno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.fathersmobileno.setFont(inputh2);
				f.add(this.fathersmobileno);
		
				
				
			
			
			}
	 

	 
}
