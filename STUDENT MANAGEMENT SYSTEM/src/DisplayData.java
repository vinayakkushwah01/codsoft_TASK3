import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.chart.PieChart.Data;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.result.Row;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;


public class DisplayData {
	int columanno, row ;
	JButton backButton,back ;
	Font h1= new Font("SansSerif", Font.BOLD,40);
	Font h2  = new Font("Osward",Font.BOLD,20);
	Font inputh2 = new Font("Raleway", Font.BOLD, 22);
	 JFrame f = new JFrame("Display all Students ");
	 public DisplayData() {
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
		 JLabel heading = new JLabel("All Student details  ");
			heading.setFont(h1);
			heading.setBounds(100,50,500,60);
			f.add(heading);
			
			printdata();
			f.repaint();
			
		 f.setLayout(null);
			f.setSize(900,700);
			f.setVisible(true);
			f.setLocation(100, 25);
			f.setBackground(Color.WHITE);
		
	}
		
	 
	void printdata(){
		
		int row=0, col=0;
		
		Connection con=DBCon.getConnection();
		try {
			Statement stmt =  con.createStatement(
				    ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY
				);
			 String query = "Select * from studentdata";
			 ResultSet rs = stmt.executeQuery(query);
			rs.last();
			row = rs.getRow();
			 col = rs.getMetaData().getColumnCount();
			System.out.println(row);
			 System.out.println(col);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rowData [][]= new String[row][col]; 
		
		
		String columanname[] = {"name", "enrollmenno", "mobileno", "fathersmobileno", "fathersname", "dob", "program", "branch", "gender"};
		
		
		try {
			Statement stmt = con.createStatement();
			String qString ="Select * from studentdata";
			
			//rSet.beforeFirst();
			ResultSet rSet = stmt.executeQuery(qString);
			
			rSet.next();
			for (int i = 0; i < row; i++) {
				
				for (int j = 0; j < col; j++) {
					
				rowData[i][j] = rSet.getString(columanname[j]);
					//System.out.print(rowData[i][j] + "          ");
					
				}
				rSet.next();
			//	System.out.println(rSet.next());
				//System.out.println("on roe ");
				
			}
			final JTable alldata= new JTable(rowData,columanname);
			alldata.setBounds(5,200,900,600);
			//f.add(alldata);
			JScrollPane jsp = new JScrollPane(alldata);
			jsp.setBounds(5,200,900,600);
			f.add(jsp);
		
		} catch (SQLException e) {
	
			System.out.print(e.getMessage());
			System.out.print(e.getLocalizedMessage());
		}
		
		
		
	}
	 
		

}
