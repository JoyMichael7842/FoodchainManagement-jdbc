package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addBranch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBranch frame = new addBranch();
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
	public addBranch() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainmenu();
				dispose();
			}
		});
		
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(12, 442, 111, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Branch_Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(81, 60, 101, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(226, 64, 137, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNameOfBranch = new JLabel("Name of branch");
		lblNameOfBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameOfBranch.setBounds(81, 124, 118, 32);
		contentPane.add(lblNameOfBranch);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(226, 128, 137, 26);
		contentPane.add(textField_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(81, 188, 118, 32);
		contentPane.add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(226, 194, 137, 26);
		contentPane.add(textField_2);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPostalCode.setBounds(81, 250, 118, 32);
		contentPane.add(lblPostalCode);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(226, 256, 137, 26);
		contentPane.add(textField_3);
		
		JLabel lblManagerId = new JLabel("Manager Id");
		lblManagerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblManagerId.setBounds(81, 310, 118, 32);
		contentPane.add(lblManagerId);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(226, 316, 137, 26);
		contentPane.add(textField_4);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = textField.getText();
				String name = textField_1.getText();
				int num = Integer.valueOf(textField_2.getText());
				int post = Integer.valueOf(textField_3.getText());
				String man = textField_4.getText();
				
				String query = "insert into restaurant values(?,?,?,?,?)";
				try {
					PreparedStatement prstmt = con.prepareStatement(query);
					prstmt.setString(1,Id);
					prstmt.setString(2,man);
					prstmt.setString(3,name);
					prstmt.setInt(4,num);
					prstmt.setInt(5,post);
					
					prstmt.execute();
					JOptionPane.showMessageDialog(null,"Succesfully Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(226, 385, 97, 25);
		contentPane.add(btnAdd);
	}
}
