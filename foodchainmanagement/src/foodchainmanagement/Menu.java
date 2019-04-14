package foodchainmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Menu extends JFrame {
	
	

	 private JFrame frame;
	    private JPanel mainPane;
	    private JPanel topPane;
	    private JPanel tablePane;
	    private JPanel bottomPane;
	    private JLabel userNameLabel;
	    private JLabel passwordLabel;
	    private JLabel homeWorldLabel;

	    private JTextField idField;
	    private JTextField itkindField;
	    private JTextField priceField;

	    private JCheckBox membersBox;
	    private JCheckBox randomBox;

	    private JButton selectAccountButton;
	    private JButton addButton;
	    private JButton deleteButton;

	    private JTable table;

	    private JScrollPane scroll;
	    private JTextField textField;

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
						new Menu();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	    }
	    
	    public Menu() throws ClassNotFoundException, SQLException {
	        frame = new JFrame(getClass().getSimpleName());

	        Class.forName("oracle.jdbc.driver.OracleDriver");				        			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "oracle");
			
	        int rows = 30;
	        int cols = 3;
	        int row = 0;
	        
	        String[][] data = null;
			try {
				
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Menu ");

				data = new String[rows][cols];					
				
					while(rs.next()) {
						System.out.println(rs.getString("ITEM_NAME"));
						data[row][0] =  rs.getString("ITEM_ID");
						data[row][1] =  rs.getString("ITEM_NAME");
						data[row][2] =  String.valueOf(rs.getInt("PRICE"));
						row++;
				}
						
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        String[] columnNames = { "Item Id", "Item Name", "Price" };

	        table = new JTable(data, columnNames);

	        scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	        table.setPreferredScrollableViewportSize(new Dimension(420, 250));
	        table.setFillsViewportHeight(true); 

	        JLabel nameField = new JLabel("Item Name");
	        userNameLabel = new JLabel("Item_id:");
	        passwordLabel = new JLabel("Price");
	        homeWorldLabel = new JLabel("Item kind");

	        selectAccountButton = new JButton("Back");
	        selectAccountButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new mainmenu();
					frame.dispose();
				}});
	        addButton = new JButton("Add");
	        addButton.addActionListener(new ActionListener() {        		
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String name = nameField.getText();
					String Id = idField.getText();
					int num = Integer.valueOf(priceField.getText());
					String itkind = itkindField.getText();
								
					String query = "insert into Menu values(?,?,?,?)";
					try {
						PreparedStatement prstmt = con.prepareStatement(query);
						prstmt.setString(1,Id);
						prstmt.setString(2,name);
						prstmt.setInt(3,num);
						prstmt.setString(4,itkind);
						
						prstmt.execute();
						JOptionPane.showMessageDialog(null,"Succesfully Added");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	        		
	        	
	        });
	        deleteButton = new JButton("Del");

	        idField = new JTextField(10);
	        priceField = new JTextField(10);
	        itkindField = new JTextField(3);

	        membersBox = new JCheckBox("SNACKS");
	        randomBox = new JCheckBox("Random world");

	        topPane = new JPanel();
	        topPane.setLayout(new BorderLayout());

	        topPane.add(nameField, BorderLayout.WEST);
	        topPane.add(selectAccountButton, BorderLayout.EAST);

	        tablePane = new JPanel();
	        tablePane.add(scroll);

	        bottomPane = new JPanel();
	        bottomPane.setLayout(new GridLayout(0, 5, 3, 3));

	        bottomPane.add(userNameLabel);
	        bottomPane.add(idField);
	        bottomPane.add(membersBox);
	        bottomPane.add(addButton);
	        bottomPane.add(deleteButton);
	        bottomPane.add(passwordLabel);
	        bottomPane.add(priceField);
	        bottomPane.add(randomBox);
	        bottomPane.add(homeWorldLabel);
	        bottomPane.add(itkindField);

	        mainPane = new JPanel();
	        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));

	        frame.getContentPane().add(topPane, BorderLayout.NORTH);
	        
	        textField = new JTextField();
	        topPane.add(textField, BorderLayout.CENTER);
	        textField.setColumns(10);
	        frame.getContentPane().add(tablePane, BorderLayout.CENTER);
	        frame.getContentPane().add(bottomPane, BorderLayout.SOUTH);

	        frame.pack();
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

}

