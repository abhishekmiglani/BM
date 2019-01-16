package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ComapnyDetails extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField name_field;
	private JTextField ContactField;
	private JTextField BankField;
	private JTextField AccountField;
	private JTextField ifsField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComapnyDetails frame = new ComapnyDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ComapnyDetails() throws SQLException {
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 518);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 796, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Enter Company Details");
		label.setForeground(Color.WHITE);
		label.setBounds(112, 0, 571, 56);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Rockwell", Font.BOLD, 24));
		
		JLabel label_1 = new JLabel("Company's ID");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(46, 90, 166, 20);
		contentPane.add(label_1);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(291, 92, 86, 20);
		contentPane.add(idField);
		
		JLabel label_2 = new JLabel("Company's Name\r\n");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(46, 133, 166, 20);
		contentPane.add(label_2);
		
		name_field = new JTextField();
		name_field.setColumns(10);
		name_field.setBounds(293, 133, 271, 20);
		contentPane.add(name_field);
		
		JLabel label_3 = new JLabel("Company's Address\r\n");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(46, 170, 166, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Company's Contact No.");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Dialog", Font.BOLD, 14));
		label_4.setBounds(46, 249, 166, 20);
		contentPane.add(label_4);
		
		ContactField = new JTextField();
		ContactField.setColumns(10);
		ContactField.setBounds(293, 252, 271, 20);
		contentPane.add(ContactField);
		
		JLabel label_5 = new JLabel("BANK NAME");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Dialog", Font.BOLD, 14));
		label_5.setBounds(46, 285, 166, 20);
		contentPane.add(label_5);
		
		BankField = new JTextField();
		BankField.setColumns(10);
		BankField.setBounds(293, 285, 271, 20);
		contentPane.add(BankField);
		
		JLabel label_6 = new JLabel("Account No.");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Dialog", Font.BOLD, 14));
		label_6.setBounds(46, 323, 166, 14);
		contentPane.add(label_6);
		
		AccountField = new JTextField();
		AccountField.setColumns(10);
		AccountField.setBounds(293, 323, 271, 20);
		contentPane.add(AccountField);
		
		JLabel label_7 = new JLabel("IFS Code");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Dialog", Font.BOLD, 14));
		label_7.setBounds(46, 367, 166, 14);
		contentPane.add(label_7);
		
		ifsField = new JTextField();
		ifsField.setColumns(10);
		ifsField.setBounds(293, 367, 271, 20);
		contentPane.add(ifsField);
		
		JTextPane txtpnAddresspane = new JTextPane();
		txtpnAddresspane.setBounds(291, 170, 271, 56);
		contentPane.add(txtpnAddresspane);
		
		JLabel NameError = new JLabel("");
		NameError.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameError.setForeground(Color.RED);
		NameError.setBounds(574, 136, 212, 14);
		contentPane.add(NameError);
		
		JLabel ContactError = new JLabel("");
		ContactError.setFont(new Font("Tahoma", Font.BOLD, 11));
		ContactError.setForeground(Color.RED);
		ContactError.setBounds(574, 254, 212, 14);
		contentPane.add(ContactError);
		
		JButton btnAddCompanyDetails = new JButton("Add Company\r\n\t Details\r\n");
		btnAddCompanyDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				boolean ContactFlag =false, NameFlag = false, execute = true;
				Long contact = null;
				String name = name_field.getText();
				try {
					contact = Long.parseLong(ContactField.getText());
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
					int confirmation = JOptionPane.showConfirmDialog(contentPane, "Are you sure");
					if(confirmation == 0) {
						String entry_query = "insert into company_details ( company_name , commpany_address , company_contact , Company_bank , acc_no  , ifsc,companyid) values(?,?,?,?,?,?,?)";
						PreparedStatement ps;
						try {
							ps = con.prepareStatement(entry_query);
							ps.setString(1,name_field.getText());
							ps.setString(2, txtpnAddresspane.getText());
							ps.setLong(3, Long.parseLong(ContactField.getText()));
							ps.setString(4, BankField.getText());
							ps.setString(5, AccountField.getText());
							ps.setString(6, ifsField.getText());
							ps.setInt(7,Integer.parseInt( idField.getText()));
							ps.executeQuery();
							Statement st  = con.createStatement();
							String s = "Company"+idField.getText();
							String create_table_query = "create table "+s+"(Bill_no number(20) , Billing_DATE Date not null,Particular varchar2(200) , quantity decimal(20,2) , Rate decimal(20,2) , credit decimal(20,2) ,debit decimal(20,2), balance decimal(20,2))";
							String Duplicate_table = "DuplicateCompany"+idField.getText();
							String create_duplicate_table_query = "create table "+Duplicate_table+"(Bill_no number(20)  , Billing_DATE Date not null,Particular varchar2(200) , quantity decimal(20,2) , Rate decimal(20,2) , credit decimal(20,2) ,debit decimal(20,2), balance decimal(20,2))";
							st.executeQuery(create_table_query);
							st.executeQuery(create_duplicate_table_query);
							String commit_query = "commit";
							execute = st.execute(commit_query);
							JOptionPane.showMessageDialog(contentPane, "Company has Been Added in Your Accounts");
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(contentPane, "There Is some Error. Contact Ak");}
					}
					else
					{
						name_field.setText("");;
						ContactField.setText("");
						BankField.setText("");
						AccountField.setText("");
						ifsField.setText("");
					}
					}
				
				
				try {	
				Statement id_value_stmt = con.createStatement();
				
				String id_value = "select max(companyid)+1 from company_details";
				ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
				id_value_result.next();
				if(id_value_result.getString(1)==null)
					idField.setText("1");
				else
					idField.setText(id_value_result.getString(1));
				}
				catch(Exception e){
				}
				
				if(execute == false) {
					name_field.setText("");;
					ContactField.setText("");;
					BankField.setText("");;
					AccountField.setText("");;
					ifsField.setText("");;
				}
				
				
			}
		});
		
		Image img = new ImageIcon(this.getClass().getResource("/create.png")).getImage();
		btnAddCompanyDetails.setIcon(new ImageIcon(img));
		btnAddCompanyDetails.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnAddCompanyDetails.setBackground(new Color(211, 211, 211));
		btnAddCompanyDetails.setBounds(534, 408, 222, 43);
		contentPane.add(btnAddCompanyDetails);
		
		
		
		Statement id_value_stmt = con.createStatement();
		String id_value = "select max(companyid)+1 from company_details";
		ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
		id_value_result.next();
		if(id_value_result.getString(1)==null)
			idField.setText("1");
		else
			idField.setText(id_value_result.getString(1));
		
		
	}
}
