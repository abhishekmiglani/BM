package org.eclipse.wb.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class Edits extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField contacts;
	private JTextField bank;
	private JTextField account;
	private JTextField ifs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edits frame = new Edits();
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
	 * @throws ClassNotFoundException 
	 */
	public Edits(String id) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String edit_data_query = "select * from company_details where companyid="+id;
		PreparedStatement EditData = con.prepareStatement(edit_data_query);
		ResultSet data_rs = EditData.executeQuery();
		data_rs.next();
		
		String Name = data_rs.getString(2), Address = data_rs.getString(3) , Contact= data_rs.getString(4), Bank = data_rs.getString(5),
				Account = data_rs.getString(6) , IFS = data_rs.getString(7);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 784, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label.setBounds(59, 33, 111, 36);
		contentPane.add(label);
		
		name = new JTextField();
		name.setText(Name);
		name.setColumns(10);
		name.setBounds(261, 41, 212, 20);
		contentPane.add(name);
		
		JLabel NameError = new JLabel("");
		NameError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		NameError.setForeground(Color.RED);
		NameError.setBounds(479, 41, 212, 18);
		contentPane.add(NameError);
		
		JLabel label_1 = new JLabel("Contact Details");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_1.setBounds(59, 93, 111, 36);
		contentPane.add(label_1);
		
		contacts = new JTextField();
		contacts.setText(Contact);
		contacts.setColumns(10);
		contacts.setBounds(261, 101, 212, 20);
		contentPane.add(contacts);
		
		JLabel ContactError = new JLabel("");
		ContactError.setForeground(Color.RED);
		ContactError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ContactError.setBounds(479, 102, 212, 18);
		contentPane.add(ContactError);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_2.setBounds(57, 153, 111, 36);
		contentPane.add(label_2);
		
		JTextArea address = new JTextArea();
		address.setText(Address);
		address.setBounds(261, 159, 212, 20);
		contentPane.add(address);
		
		JLabel label_3 = new JLabel("Bank Details");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_3.setBounds(59, 213, 111, 36);
		contentPane.add(label_3);
		
		bank = new JTextField();
		bank.setText(Bank);
		bank.setColumns(10);
		bank.setBounds(261, 221, 212, 20);
		contentPane.add(bank);
		
		JLabel label_4 = new JLabel("Account No.");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_4.setBounds(59, 283, 111, 36);
		contentPane.add(label_4);
		
		account = new JTextField();
		account.setText(Account);
		account.setColumns(10);
		account.setBounds(261, 291, 212, 20);
		contentPane.add(account);
		
		JLabel label_5 = new JLabel("IFS Code");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_5.setBounds(59, 343, 111, 36);
		contentPane.add(label_5);
		
		ifs = new JTextField();
		ifs.setText(IFS);
		ifs.setColumns(10);
		ifs.setBounds(261, 351, 212, 20);
		contentPane.add(ifs);
		
		JButton button = new JButton("UPDATE");
		Image img3 = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		button.setIcon(new ImageIcon(img3));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ContactFlag =false, NameFlag = false, execute = true;
				Long contact = null;
				String updateName = name.getText(),updateAddress = address.getText(),updateBank = bank.getText(),updateAccount = account.getText(),updateIFS = ifs.getText();
				
				try {
					contact = Long.parseLong(contacts.getText());
					ContactFlag =true;	
				}catch (NumberFormatException e){
					ContactFlag = false;}
				if(updateName.equals(""))
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
					ContactError.setText("Contact needs to be of 10 Digits");
				else{
					NameError.setText("");
					ContactError.setText("");
					try {
						String detailsUpdateQuery = "update company_details set company_name = ?, company_contact = ?, commpany_address = ?, company_bank = ?, ACC_NO = ? , IFSC = ? where companyid = ?";
						PreparedStatement updateStatement = con.prepareStatement(detailsUpdateQuery);
						updateStatement.setString(1, updateName);
						updateStatement.setLong(2, contact);
						updateStatement.setString(3, updateAddress);
						updateStatement.setString(4,updateBank);
						updateStatement.setString(5, updateAccount);
						updateStatement.setString(6, updateIFS);
						updateStatement.setString(7, id);
						
						
						updateStatement.executeUpdate();
						updateStatement.execute("commit");
						JOptionPane.showMessageDialog(contentPane, "Details Updated SuccessFully");
						
//						Clearing all text Fields
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, e);
					}
					
				}
			
			}
		});
		button.setBounds(583, 394, 137, 36);
		contentPane.add(button);
	}
	public Edits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label.setBounds(59, 33, 111, 36);
		contentPane.add(label);
		
		name = new JTextField();
		name.setText("");
		name.setColumns(10);
		name.setBounds(261, 41, 212, 20);
		contentPane.add(name);
		
		JLabel NameError = new JLabel("");
		NameError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		NameError.setForeground(Color.RED);
		NameError.setBounds(479, 41, 212, 18);
		contentPane.add(NameError);
		
		JLabel label_1 = new JLabel("Contact Details");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_1.setBounds(59, 93, 111, 36);
		contentPane.add(label_1);
		
		contacts = new JTextField();
		contacts.setText("");
		contacts.setColumns(10);
		contacts.setBounds(261, 101, 212, 20);
		contentPane.add(contacts);
		
		JLabel ContactError = new JLabel("");
		ContactError.setForeground(Color.RED);
		ContactError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ContactError.setBounds(479, 102, 212, 18);
		contentPane.add(ContactError);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_2.setBounds(57, 153, 111, 36);
		contentPane.add(label_2);
		
		JTextArea address = new JTextArea();
		address.setBounds(261, 159, 212, 20);
		contentPane.add(address);
		
		JLabel label_3 = new JLabel("Bank Details");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_3.setBounds(59, 213, 111, 36);
		contentPane.add(label_3);
		
		bank = new JTextField();
		bank.setText("");
		bank.setColumns(10);
		bank.setBounds(261, 221, 212, 20);
		contentPane.add(bank);
		
		JLabel label_4 = new JLabel("Account No.");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_4.setBounds(59, 283, 111, 36);
		contentPane.add(label_4);
		
		account = new JTextField();
		account.setText("");
		account.setColumns(10);
		account.setBounds(261, 291, 212, 20);
		contentPane.add(account);
		
		JLabel label_5 = new JLabel("IFS Code");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Sitka Text", Font.BOLD, 14));
		label_5.setBounds(59, 343, 111, 36);
		contentPane.add(label_5);
		
		ifs = new JTextField();
		ifs.setText("");
		ifs.setColumns(10);
		ifs.setBounds(261, 351, 212, 20);
		contentPane.add(ifs);
		
		JButton button = new JButton("UPDATE");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		Image img3 = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		button.setIcon(new ImageIcon(img3));
		button.setBounds(570, 404, 165, 36);
		contentPane.add(button);
	}
}




















