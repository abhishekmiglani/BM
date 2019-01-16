package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class customer_details {

	private JFrame frame;
	private JTextField NameField;
	private JTextField companyNameField;
	private JTextField MobileField;
	private JTextField textField_5;
	private JTextField id_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_details window = new customer_details();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public customer_details() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws SQLException, ClassNotFoundException {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		frame.getContentPane().setFont(new Font("Traditional Arabic", Font.PLAIN, 14));
		frame.setBounds(100, 100, 771, 597);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 817, 65);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFillYourCustomer = new JLabel("Fill Your Customer Details");
		lblFillYourCustomer.setForeground(Color.WHITE);
		lblFillYourCustomer.setBounds(50, 10, 717, 45);
		panel.add(lblFillYourCustomer);
		lblFillYourCustomer.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblFillYourCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillYourCustomer.setLabelFor(frame);
		
		JLabel lblName = new JLabel("Customer Name\r\n\r\n");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 133, 146, 20);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Company Name\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 178, 146, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile No.\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 230, 146, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Office Address\r\n\r\n");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 280, 146, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Home Address");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 370, 146, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblCustomerIdProof = new JLabel("Customer Id Proof");
		lblCustomerIdProof.setForeground(new Color(0, 0, 0));
		lblCustomerIdProof.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblCustomerIdProof.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerIdProof.setBounds(10, 467, 146, 14);
		frame.getContentPane().add(lblCustomerIdProof);
		
		NameField = new JTextField();
		NameField.setBounds(183, 130, 323, 20);
		frame.getContentPane().add(NameField);
		NameField.setColumns(10);
		
		JLabel NameError = new JLabel("");
		NameError.setForeground(Color.RED);
		NameError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		NameError.setBounds(519, 133, 212, 14);
		frame.getContentPane().add(NameError);
		
		companyNameField = new JTextField();
		companyNameField.setBounds(183, 178, 323, 20);
		frame.getContentPane().add(companyNameField);
		companyNameField.setColumns(10);
		
		MobileField = new JTextField();
		MobileField.setBounds(183, 227, 323, 20);
		frame.getContentPane().add(MobileField);
		MobileField.setColumns(10);
		
		JLabel ContactError = new JLabel("");
		ContactError.setForeground(Color.RED);
		ContactError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ContactError.setBounds(519, 230, 212, 14);
		frame.getContentPane().add(ContactError);
		
		textField_5 = new JTextField();
		textField_5.setBounds(183, 464, 323, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JTextPane officeAddressPane = new JTextPane();
		officeAddressPane.setBounds(183, 280, 323, 71);
		frame.getContentPane().add(officeAddressPane);
		
		JTextPane HomeAddressPane = new JTextPane();
		HomeAddressPane.setBounds(183, 370, 323, 71);
		frame.getContentPane().add(HomeAddressPane);
		
		JButton btnNewButton = new JButton("Browse\r\n");
		btnNewButton.setBounds(516, 463, 18, 23);
		frame.getContentPane().add(btnNewButton);
		
		id_field = new JTextField();
		id_field.setColumns(10);
		id_field.setBounds(183, 94, 66, 20);
		frame.getContentPane().add(id_field);
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				String id_value = "select max(customer_id)+1 from customers";
				Statement id_value_stmt = con.createStatement();
				ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
				id_value_result.next();

				if(id_value_result.getString(1)==null)
					id_field.setText("1");
				else
					id_field.setText(id_value_result.getString(1));
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnCreateAccount.setBackground(Color.LIGHT_GRAY);
		Image img = new ImageIcon(this.getClass().getResource("/create.png")).getImage();
		btnCreateAccount.setIcon(new ImageIcon(img));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ContactFlag =false, NameFlag = false, execute = true;
				Long contact = null;
				String name = NameField.getText();
				try {
					contact = Long.parseLong(MobileField.getText());
					ContactFlag =true;	
				}catch (NumberFormatException e){
					ContactFlag = false;}
				if(name.equals(""))
					NameFlag = false;
				else
					NameFlag = true;
				
				if(NameFlag==false && ContactFlag==false){
					NameError.setText("Customer Name cannot be Empty");
					ContactError.setText("Fill the Contact Details Carefully");
				}
				else if(NameFlag==true && ContactFlag == false){
					NameError.setText("");
					ContactError.setText("Fill the Contact Details Carefully");
				}
				else if(NameFlag==false && ContactFlag == true){
					NameError.setText("Customer Name cannot be Empty");
					ContactError.setText("");
				}
				else if(NameFlag == true && ContactFlag ==true && contact<1000000000)
					ContactError.setText("Contact needs of 10 Digits");
				else{
					NameError.setText("");
					ContactError.setText("");
				try{  					 
					String sql="insert into customers(customer_id, customer_name, customer_company_name, mobile, o_add, h_address) values (?,?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(sql); 
					stmt.setInt	(1, Integer.parseInt(id_field.getText()));
					stmt.setString(2,NameField.getText().toUpperCase());
					stmt.setString(3,companyNameField.getText().toUpperCase());
					stmt.setString(4,(MobileField.getText()));
					stmt.setString(5,officeAddressPane.getText().toUpperCase());
					stmt.setString(6,HomeAddressPane.getText().toUpperCase());
					stmt.executeQuery();
					String s = "C"+id_field.getText().toString();
					String duplicate_table = "C"+s;
					String new_customer = "create table "+s+"(Sno number(5) , BillNo varchar(20), DESIRED_DATE Date not null,Particular varchar2(200) , credit decimal(20,2) , debit decimal(20,2), balance decimal(20,2))"; 
					String duplicate_new_customer = "create table "+duplicate_table+"(Sno number(5) , BillNo varchar(20)  , DESIRED_DATE Date not null , Particular varchar2(200) , credit decimal(20,2) ,debit decimal(20,2),balance decimal(20,2))";
					PreparedStatement create_customer_account_table_stmt = con.prepareStatement(new_customer);
					create_customer_account_table_stmt.executeQuery();
					PreparedStatement create_duplicate_customer_account_table_stmt = con.prepareStatement(duplicate_new_customer);
					create_duplicate_customer_account_table_stmt.executeQuery();
					
					String sql3 = "commit";
					Statement stt = con.createStatement();
					stt.executeQuery(sql3);
					JOptionPane.showMessageDialog(frame, "customer has been added to your account");
					String id_value = "select max(customer_id)+1 from customers";
					Statement id_value_stmt = con.createStatement();
					ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
					id_value_result.next();

					if(id_value_result.getString(1)==null)
						id_field.setText("1");
					else
						id_field.setText(id_value_result.getString(1));
			
					}catch(Exception e){ 
						JOptionPane.showMessageDialog(frame, e);
						} 
				NameField.setText("");
				companyNameField.setText("");
				MobileField.setText("");
				textField_5.setText("");
				officeAddressPane.setText("");
				HomeAddressPane.setText("");
				
				}
			}
		});
		btnCreateAccount.setBounds(526, 502, 211, 45);
		btnCreateAccount.setUI(new StyledButtonUI());
		frame.getContentPane().add(btnCreateAccount);
		
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setForeground(new Color(0, 0, 0));
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblCustomerId.setBounds(10, 94, 146, 14);
		frame.getContentPane().add(lblCustomerId);
		
		
		
		
	}
}
