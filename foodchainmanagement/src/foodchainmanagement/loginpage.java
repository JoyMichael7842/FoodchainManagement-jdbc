package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(39, 30, 81, 33);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(156, 36, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(39, 76, 81, 22);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(156, 77, 116, 22);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(39, 155, 97, 25);
		contentPane.add(btnLogin);
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");			
	        		
		
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 try {
					
			        Statement stmt = con.createStatement();
			        String user1 = textField.getText();
					ResultSet rs = stmt.executeQuery("select * from login where username ="+"'"+ user1 + "'");
					System.out.println("connected");
					while(rs.next()) {
						System.out.println(rs.getString(1));
						System.out.println(textField.getText());
						String userID = rs.getString("username");
						String password = rs.getString("password");
						if(userID.equals(textField.getText())&&(password.equals(new String(passwordField.getPassword()))))
						{
							JOptionPane.showMessageDialog(null,"you have logged in");
							new mainmenu();
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Incorrect username and password");
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			
		});
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignUp.setBounds(226, 155, 97, 25);
		contentPane.add(btnSignUp);
		
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				//Statement stmt = con.createStatement();
				String passwordString = new String(passwordField.getPassword());
				//stmt.executeUpdate("INSERT INTO login " + "VALUES ("+textField.getText()+","+passwordString+")");
				String query = " insert into login (username,password)"
				        + " values (?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, textField.getText());
			      preparedStmt.setString (2, passwordString);
			      preparedStmt.execute();
				con.close();
				
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}}});
		
		
	}
}

