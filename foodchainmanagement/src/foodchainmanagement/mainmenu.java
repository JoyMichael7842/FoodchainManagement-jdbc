package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Branch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBranch brframe = null;
				try {
					brframe = new addBranch();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				brframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(456, 44, 135, 35);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Branch details");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Brdetails brframe = null;
				try {
					brframe = new Brdetails();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				brframe.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(12, 46, 160, 29);
		contentPane.add(button);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Menu();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMenu.setBounds(450, 268, 141, 26);
		contentPane.add(btnMenu);
		
		JButton Empbutton = new JButton("Employee details");
		Empbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Empbutton.setBounds(12, 164, 160, 29);
		contentPane.add(Empbutton);
		Empbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Empdetails empframe = null;
				try {
					empframe = new Empdetails();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				empframe.setVisible(true);
				dispose();
				
			}});
		
		JButton Custbutton = new JButton("Customers");
		Custbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Custbutton.setBounds(456, 164, 141, 28);
		contentPane.add(Custbutton);
		
		Custbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Custdetails Custframe = null;
				try {
					Custframe = new Custdetails();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Custframe.setVisible(true);
				dispose();
			}			
		});
		
		JButton button_4 = new JButton("Orders");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderdetails ordframe = new Orderdetails();
				ordframe.setVisible(true);
				dispose();
			}			
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_4.setBounds(12, 267, 160, 29);
		contentPane.add(button_4);
		
		JButton btnDetails = new JButton("Sales details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salesdetails Salframe = new Salesdetails();
				Salframe.setVisible(true);
				dispose();
			}
		});
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDetails.setBounds(12, 361, 160, 29);
		contentPane.add(btnDetails);
		
		JButton btnDeliveries = new JButton("Deliveries");
		btnDeliveries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deldetails delframe = null;
				try {
					delframe = new Deldetails();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				delframe.setVisible(true);
				dispose();
			}
		});
		btnDeliveries.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeliveries.setBounds(456, 361, 135, 29);
		contentPane.add(btnDeliveries);
		setVisible(true);
	}

}
