import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;





public class Edit {
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
	String submit_data, enr;
	// =new String[9];
	
	String _name,_enrollmentno,_mobileno,_parentno, _parentName,_dob,_gender,_program,_branch,_selected;
	 public Edit() {
		 
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

		 JLabel heading = new JLabel("Edit Student details  ");
			heading.setFont(h1);
			heading.setBounds(100,50,500,60);
			f.add(heading);
			
			JLabel enrollment_no = new  JLabel("Enrollment number = ");
			enrollment_no.setBounds(30,150,250,40);
			enrollment_no.setFont(h2);
			f.add(enrollment_no);
			
			
			this.enrollmen_no = new JTextField();
			this.enrollmen_no.setBounds(300,150,250,40);
			this.enrollmen_no.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			this.enrollmen_no.setFont(inputh2);
			f.add(this.enrollmen_no);
			
			String [] perameter_to_edits = {"Name" , "Enrollmen No", "Mobileno", "Partents Mobileno", "Parents Name","Dob","Gender", "Program / Bramch"};
			
			JLabel paremater = new JLabel("Select to edit");
			paremater.setBounds(30,200,250,40);
			paremater.setFont(h2);
			f.add(paremater);
			
			perameter_to_edit  = new JComboBox(perameter_to_edits);
			perameter_to_edit.setBounds(300,200,150,40);
			perameter_to_edit.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			perameter_to_edit.setFont(inputh2);
			f.add(perameter_to_edit);
			
			 searchButton = new JButton("Search");
			 searchButton.setBounds(450,200,100,40);
			 this.searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.searchButton.setFont(inputh2);
				f.add(this.searchButton);
			
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					enr= enrollmen_no.getText();
					 choise =  Edit.this.perameter_to_edit.getSelectedIndex();
					
					 
				try{
					try {f.remove(lname);} catch (Exception e) {}
					try {f.remove(lenrollmentno);} catch (Exception e) {}
					try {f.remove(lDOB);	} catch (Exception e) {	}
					try {f.remove(lprogam);	} catch (Exception e) {	}
					try {f.remove(lfathersmobileno);	} catch (Exception e) {	}
					try {f.remove(lfathersname);	} catch (Exception e) {	}
					try {f.remove(lmobileno);	} catch (Exception e) {	}
					try {f.remove(lgender);	} catch (Exception e) {	}
					
					try {f.remove(male);	} catch (Exception e) {	}
					try {f.remove(branchComboBox);	} catch (Exception e) {	}
					try {f.remove(programComboBox);	} catch (Exception e) {	}
					try {f.remove(fathersname);	} catch (Exception e) {	}
					try {f.remove(fathersmobileno);	} catch (Exception e) {	}
					try {f.remove(mobileno);} catch (Exception e) {	}
					try {f.remove(enrollmenno);	} catch (Exception e) {	}
					try {f.remove(text);	} catch (Exception e) {	}
					try {f.remove(name);	} catch (Exception e) {	}
					try {f.remove(b);	} catch (Exception e) {	}
					try {f.remove(female);	} catch (Exception e) {	}
				}
				catch(Exception c){
					
				}
					
					System.out.print(choise);
					Options(choise);
					f.revalidate();
					f.repaint();
				}
			});
			
			f.revalidate();
			f.repaint();
			
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
					try {_name= 	Edit.this.name.getText();} catch(Exception c){}
					try{_enrollmentno=	Edit.this.enrollmenno.getText();}catch(Exception c){}
					try{_mobileno=	Edit.this.mobileno.getText();}catch(Exception c){}
					try{_parentno=	Edit.this.fathersmobileno.getText();}catch(Exception c){}
					try{_parentName= Edit.this.fathersname.getText();}catch(Exception c){}

					try{_gender=(male.isSelected())? "male":"female";}catch(Exception c){}

					try{_program = (String) Edit.this.programComboBox.getSelectedItem();}catch(Exception c){}
					try{_branch =  (String) Edit.this.branchComboBox.getSelectedItem();}catch(Exception c){}
					
					String dataString[] ={ _name,_enrollmentno,_mobileno,_parentno,_parentName,_dob,_gender,_program,_branch};
					
					//String fealdString []={"_name","_enrollmentno","_mobileno","_parentno"," _parentName","_dob","_gender","_program,_branch"};
					
					submit_data= (dataString[choise]);
					
					edit();
					
				}
				
				
			});
		
			
			clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					try{
						try {f.remove(lname);} catch (Exception e) {}
						try {f.remove(lenrollmentno);} catch (Exception e) {}
						try {f.remove(lDOB);	} catch (Exception e) {	}
						try {f.remove(lprogam);	} catch (Exception e) {	}
						try {f.remove(lfathersmobileno);	} catch (Exception e) {	}
						try {f.remove(lfathersname);	} catch (Exception e) {	}
						try {f.remove(lmobileno);	} catch (Exception e) {	}
						try {f.remove(lgender);	} catch (Exception e) {	}
						
						try {f.remove(male);	} catch (Exception e) {	}
						try {f.remove(branchComboBox);	} catch (Exception e) {	}
						try {f.remove(programComboBox);	} catch (Exception e) {	}
						try {f.remove(fathersname);	} catch (Exception e) {	}
						try {f.remove(fathersmobileno);	} catch (Exception e) {	}
						try {f.remove(mobileno);} catch (Exception e) {	}
						try {f.remove(enrollmenno);	} catch (Exception e) {	}
						try {f.remove(text);	} catch (Exception e) {	}
						try {f.remove(name);	} catch (Exception e) {	}
						try {f.remove(b);	} catch (Exception e) {	}
						try {f.remove(female);	} catch (Exception e) {	}
						
						f.repaint();
					}
					catch(Exception e ){
						
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
	
	 
	 

	 
	 
	 void edit(){
	
		 
		 String [] perameter_to_edits = {"Name" , "Enrollmen No", "Mobileno", "Partents Mobileno", "Parents Name","Dob","Gender", "Program / Bramch"};
		 //submit_data,,,choise
		 
		 try{
			 String[] tr={"name","enrollmenno", "mobileno", "fathersmobileno", "fathersname", "dob", "gender"," program", "branch"};
			Connection con=DBCon.getConnection();
			Statement stmt = con.createStatement();
			PreparedStatement ps =

					con.prepareStatement("UPDATE studentdata"+
							" "
							+ "SET "+ tr[choise] + " = ? WHERE enrollmenno =?");

			try {
				System.out.print("geting data ");
			
				System.out.println();
				switch (choise) {
				case 2:  long c2=Long.parseLong(submit_data);
					ps.setLong(1,c2);
				break;
				case 3: long c3=Long.parseLong(submit_data);
						ps.setLong(1,c3);
				break;
				default:
					ps.setString(1, submit_data);
					break;
				}
				
				ps.setString(2,enr);
			//	System.out.println(ps);
			
				
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
	 
	 
	 
	 void Options( int c ){
	
		switch(c) {
		 
			case 0:{
				//System.out.print(c);
				//Name
				//System.out.print("name ");
				 lname = new JLabel("Full Name = ");
				 lname.setBounds(30,300,250,40);
				 lname.setFont(h2);
				f.add(lname);
				
				
				
				this.name = new JTextField();
				this.name.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.name.setFont(inputh2);
				this.name.setBounds(300,300,250,40);
				f.add(this.name);
				
				break;
			}
			case 1:{
				//Enrollmen No
				//System.out.print("Enrollment ");
				 lenrollmentno = new  JLabel("Enrollment number = ");
				 lenrollmentno.setBounds(30,300,250,40);
				 lenrollmentno.setFont(h2);
				f.add(lenrollmentno);
				
				
				this.enrollmenno = new JTextField();
				this.enrollmenno.setBounds(300,300,250,40);
				this.enrollmenno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.enrollmenno.setFont(inputh2);
				f.add(this.enrollmenno);
				
				break;
			}
			case 2:{
				//Mobileno
				lmobileno = new JLabel("Mobile Number  = ");
				lmobileno.setBounds(30,300,250,40);
				lmobileno.setFont(h2);
				f.add(lmobileno);
				
				
				this.mobileno = new JTextField();
				this.mobileno.setBounds(300,300,250,40);
				this.mobileno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.mobileno.setFont(inputh2);
				f.add(this.mobileno);
				
				break;}
			case 3:
				//Partents Mobileno
				 lfathersmobileno  = new JLabel("Parents Mobile Number = ");
				 lfathersmobileno.setBounds(30,300,250,40);
				 lfathersmobileno.setFont(h2);
				f.add(lfathersmobileno);
				
				
				
				this.fathersmobileno = new JTextField();
				this.fathersmobileno.setBounds(300,300,250,40);
				this.fathersmobileno.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.fathersmobileno.setFont(inputh2);
				f.add(this.fathersmobileno);
				
				break;
			case 4:
				//Parents Name
				lfathersname = new  JLabel("Parents Name = ");
				lfathersname.setBounds(30,300,250,40);
				lfathersname.setFont(h2);
				f.add(lfathersname);
				
				
				
				this.fathersname = new JTextField();
				this.fathersname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
				this.fathersname.setFont(inputh2);
				this.fathersname.setBounds(300,300,250,40);
				f.add(this.fathersname);
				
				break;
			case 5:
				//Dob
				lDOB = new JLabel("Selected Date OF Birth = :");
				
				 b = new JButton("Select");
				//JPanel p = new JPanel();
				lDOB.setBounds(30,300,250,40);
				text.setBounds(300,300,175,40);
				b.setBounds(475,300,75,40);
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
				
				break;
			case 6:
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
				
				break;
			case 7:
				//Program / Bramch
				lprogam = new JLabel("Program /Branch");
				lprogam.setBounds(30,300,250,40);
				lprogam.setFont(h2);
				f.add(lprogam);
				
				String [] sProgram = {"B TECH", "M TECH","BCA","DEPLOMA"};
				String [] sBranch = {"CSE","M.E","E.E","C.E","E.C","OTHER"};
				
				 programComboBox = new JComboBox(sProgram);
				programComboBox.setBounds(300,300,100,40);
				f.add(programComboBox);
				 branchComboBox=  new JComboBox(sBranch);
				branchComboBox.setBounds(430,300,100,40);
				f.add(branchComboBox);
				
				break;
				
				
			default:
				break;
			}
		
			}
	 

	 
	 
	 
}
