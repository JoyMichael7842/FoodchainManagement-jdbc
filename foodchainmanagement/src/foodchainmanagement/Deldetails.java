package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Deldetails extends JFrame {
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deldetails frame = new Deldetails();
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
	public Deldetails() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainmenu();
				dispose();
			}
		});
		
		
		btnNewButton.setBounds(12, 441, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("customer id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(237, 39, 97, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblItemid = new JLabel("Item_id");
		lblItemid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemid.setBounds(237, 100, 97, 34);
		contentPane.add(lblItemid);
		
		JLabel lblBranchid = new JLabel("Branch_id");
		lblBranchid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBranchid.setBounds(237, 159, 97, 34);
		contentPane.add(lblBranchid);
		
		JLabel label = new JLabel("");
		label.setBounds(224, 268, 56, 16);
		contentPane.add(label);
		
		JLabel lblDateddmmyyyy = new JLabel("Date(dd-mm-yyyy)");
		lblDateddmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateddmmyyyy.setBounds(234, 210, 154, 34);
		contentPane.add(lblDateddmmyyyy);
		
		JLabel lblDeliveryCost = new JLabel("Delivery Cost");
		lblDeliveryCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeliveryCost.setBounds(237, 268, 97, 34);
		contentPane.add(lblDeliveryCost);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setBounds(237, 315, 97, 34);
		contentPane.add(lblEmployeeId);
		
		JLabel lblDeliveryId = new JLabel("Delivery Id");
		lblDeliveryId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeliveryId.setBounds(237, 377, 97, 34);
		contentPane.add(lblDeliveryId);
		
		textField = new JTextField();
		textField.setBounds(406, 46, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(406, 107, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(406, 166, 116, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(405, 217, 116, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(406, 275, 116, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(405, 327, 116, 22);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(406, 384, 116, 22);
		contentPane.add(textField_6);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");				        			
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
		
		JButton btnAddNewDelivery = new JButton("Add new Delivery");
		btnAddNewDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cid = textField.getText();
				String item = textField_1.getText();
				String bid = textField_2.getText();
				String date = textField_3.getText();
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date myDate = null;
				try {
					myDate = format.parse(date);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				System.out.println(date);
				int cost = Integer.valueOf(textField_4.getText());
				String eid = textField_5.getText();
				String delid = textField_6.getText();
				
				String query = "insert into delivery values(?,?,?,?,?,?,?)";
				try {
					PreparedStatement prstmt = con.prepareStatement(query);
					prstmt.setString(1,delid);
					prstmt.setString(2,cid);
					prstmt.setString(3,item);
					prstmt.setString(4,bid);
					prstmt.setInt(5,cost);
					java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
					prstmt.setDate(6,sqlDate);
					prstmt.setString(7,eid);
					
					prstmt.execute();
					JOptionPane.showMessageDialog(null,"Succesfully Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnAddNewDelivery.setBounds(360, 419, 131, 40);
		contentPane.add(btnAddNewDelivery);
	}
}