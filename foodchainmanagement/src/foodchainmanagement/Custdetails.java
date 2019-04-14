package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Custdetails extends JFrame {

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
					Custdetails frame = new Custdetails();
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
	public Custdetails() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Customer id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 25, 162, 28);
		contentPane.add(lblNewLabel);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
		
		JButton btnNewButton = new JButton("Show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					String cusid = textField.getText();
					ResultSet rs = stmt.executeQuery("select * from Customer where Cus_Id="+"'"+ cusid + "'");
					while(rs.next()) {
						textField_1.setText(rs.getString("NAME"));
						textField_2.setText(cusid);
						textField_3.setText(String.valueOf(rs.getInt("PHONE")));
						textField_4.setText(rs.getString("EMAIL"));
						textField_5.setText(rs.getString("ADDRESS"));
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
		
		JLabel lblNewLabel_1 = new JLabel("Add new Customer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(232, 100, 155, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(261, 150, 145, 28);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblEmployeeId = new JLabel("Customer Id");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setBounds(261, 191, 145, 28);
		contentPane.add(lblEmployeeId);
		
		
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(261, 238, 145, 28);
		contentPane.add(lblPhoneNumber);
		
		
		
		JLabel lblRestaurantId = new JLabel("Email Address");
		lblRestaurantId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRestaurantId.setBounds(261, 282, 145, 28);
		contentPane.add(lblRestaurantId);
		
		
		
		JLabel lblPosition = new JLabel("Address");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition.setBounds(261, 330, 145, 28);
		contentPane.add(lblPosition);
		
		
		
		JButton btnAddEmployess = new JButton("Add new customer");
		btnAddEmployess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String Id = textField_2.getText();
				int num = Integer.valueOf(textField_3.getText());
				String email = textField_4.getText();
				String address = textField_5.getText();
				
				String query = "insert into customer values(?,?,?,?,?)";
				try {
					PreparedStatement prstmt = con.prepareStatement(query);
					prstmt.setString(1,Id);
					prstmt.setString(2,name);
					prstmt.setInt(3,num);
					prstmt.setString(4,email);
					prstmt.setString(5,address);
					
					prstmt.execute();
					JOptionPane.showMessageDialog(null,"Succesfully Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddEmployess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddEmployess.setBounds(232, 411, 172, 37);
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
		
		
		
		textField = new JTextField();
		textField.setBounds(28, 58, 155, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(431, 153, 155, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(431, 192, 155, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(431, 239, 155, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(431, 283, 155, 29);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(418, 331, 203, 71);
		contentPane.add(textField_5);
	}

}
