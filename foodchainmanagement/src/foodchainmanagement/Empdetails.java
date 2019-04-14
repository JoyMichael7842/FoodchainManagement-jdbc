package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Empdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empdetails frame = new Empdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Empdetails() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Enter Employee id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 25, 162, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(31, 68, 152, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
		
		JButton btnNewButton = new JButton("Show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					String empid = textField.getText();
					ResultSet rs = stmt.executeQuery("select * from Employee where Emp_Id="+"'"+ empid + "'");
					while(rs.next()) {
						textField_1.setText(rs.getString("NAME"));
						textField_2.setText(empid);
						textField_3.setText(String.valueOf(rs.getInt("PHONE")));
						textField_4.setText(rs.getString("RES_ID"));
						textField_5.setText(rs.getString("POSITION"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(222, 50, 155, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Add new employee:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(232, 103, 155, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(261, 153, 145, 28);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(474, 157, 131, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setBounds(261, 207, 145, 28);
		contentPane.add(lblEmployeeId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(474, 211, 131, 22);
		contentPane.add(textField_2);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(261, 260, 145, 28);
		contentPane.add(lblPhoneNumber);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(474, 264, 131, 22);
		contentPane.add(textField_3);
		
		JLabel lblRestaurantId = new JLabel("Restaurant Id");
		lblRestaurantId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRestaurantId.setBounds(261, 301, 145, 28);
		contentPane.add(lblRestaurantId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(474, 305, 131, 22);
		contentPane.add(textField_4);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition.setBounds(261, 342, 145, 28);
		contentPane.add(lblPosition);
		
		textField_5 = new JTextField();
		textField_5.setBounds(474, 346, 131, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnAddEmployess = new JButton("Add Employee");
		btnAddEmployess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String Id = textField_2.getText();
				int num = Integer.valueOf(textField_3.getText());
				String rest = textField_4.getText();
				String pos = textField_5.getText();
				
				String query = "insert into employee values(?,?,?,?,?)";
				try {
					PreparedStatement prstmt = con.prepareStatement(query);
					prstmt.setString(1,Id);
					prstmt.setString(2,name);
					prstmt.setInt(3,num);
					prstmt.setString(4,pos);
					prstmt.setString(5,rest);
					
					prstmt.execute();
					JOptionPane.showMessageDialog(null,"Succesfully Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddEmployess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddEmployess.setBounds(321, 394, 155, 37);
		contentPane.add(btnAddEmployess);
		
		JButton backbtn = new JButton("Back");
		backbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backbtn.setBounds(12, 394, 116, 32);
		contentPane.add(backbtn);
		
		backbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new mainmenu();
				dispose();
			}
			});
	
	}
}
