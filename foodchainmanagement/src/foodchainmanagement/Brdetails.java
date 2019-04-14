package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Brdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brdetails frame = new Brdetails();
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
	public Brdetails() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterBranchId = new JLabel("Enter Branch Id");
		lblEnterBranchId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterBranchId.setBounds(113, 62, 126, 27);
		contentPane.add(lblEnterBranchId);
		
		textField = new JTextField();
		textField.setBounds(278, 65, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
		
		
		
		
		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranchName.setBounds(113, 191, 126, 27);
		contentPane.add(lblBranchName);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(304, 197, 97, 21);
		contentPane.add(label_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(113, 252, 126, 27);
		contentPane.add(lblPhoneNumber);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(304, 258, 97, 21);
		contentPane.add(label_2);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPostalCode.setBounds(113, 310, 126, 27);
		contentPane.add(lblPostalCode);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(304, 316, 90, 21);
		contentPane.add(label_3);
		
		JLabel lblManager = new JLabel("Manager");
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblManager.setBounds(113, 369, 126, 27);
		contentPane.add(lblManager);
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(304, 375, 97, 21);
		contentPane.add(label_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new mainmenu();
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					String brid = textField.getText();
					ResultSet rs = stmt.executeQuery("select * from restaurant where Res_id="+"'"+ brid + "'");
					while(rs.next()) {
						label_1.setText(rs.getString("NAME"));
						label_2.setText(String.valueOf(rs.getInt("PHONE")));
						label_3.setText(String.valueOf(rs.getInt("POSTAL_CODE")));
						label_4.setText(rs.getString("MANAGER_ID"));						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(210, 124, 97, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(12, 445, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
