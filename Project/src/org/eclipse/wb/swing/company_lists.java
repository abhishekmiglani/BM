package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Popup;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class company_lists {

	private static JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					company_lists window = new company_lists();
					frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}
	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public company_lists() {
		initialize();
		
		
		callingData();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1370, 68);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomersList = new JLabel("COMPANYS' LIST");
		lblCustomersList.setBackground(Color.WHITE);
		lblCustomersList.setBounds(201, 11, 967, 46);
		panel.add(lblCustomersList);
		lblCustomersList.setForeground(Color.WHITE);
		lblCustomersList.setFont(new Font("Rockwell", Font.BOLD, 26));
		lblCustomersList.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("EDIT");
		Image img1 = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		button.setIcon(new ImageIcon(img1));
		button.setFont(new Font("Sitka Text", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row_index = table.getSelectedRow();
				String id =  table.getValueAt(row_index, 0).toString();
				Edits window = null;
				try {
					window = new Edits(id);
					window.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e);
				}
				
			}
		});
		
		JButton btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Home go = new Home();
					go.main(null);
					frame.setVisible(false);
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnHome.setBounds(1184, 79, 159, 58);
		btnHome.setUI(new StyledButtonUI());
		Image img3 = new ImageIcon(this.getClass().getResource("/home-icon.png")).getImage();
		btnHome.setIcon(new ImageIcon(img3));
		frame.getContentPane().add(btnHome);
		button.setBounds(1184, 379, 159, 58);
		button.setUI(new StyledButtonUI());
		frame.getContentPane().add(button);
		
		button_1 = new JButton("DELETE");
		Image img = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		button_1.setIcon(new ImageIcon(img));
		button_1.setFont(new Font("Sitka Text", Font.BOLD, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Delete_confirmation = JOptionPane.showConfirmDialog(frame, "Do you really want to delete this account ");
				if(Delete_confirmation==0)
				{
					int row_index = table.getSelectedRow();
					if(row_index<0) {	
					}	
					else {
					String index =  table.getValueAt(row_index, 0).toString();
					String delete_comapny_table = "Drop table company"+index;
					String delete_company_name = "Delete from company_details where companyid = "+index;
					String commit = "commit";
					try {
						Connection con = null;
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
						Statement table_deletion_query = con.createStatement();
						table_deletion_query.execute(delete_comapny_table);
						table_deletion_query.execute(delete_company_name);
						Boolean bs = table_deletion_query.execute(commit);
						if(bs==false)
							JOptionPane.showMessageDialog(frame, "Account Deleted Succesfully");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(frame, "Error Occured");
					}
						callingData();
					}
				}
			}
		});
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callingData();
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/Refresh-icon.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(img5));
		btnRefresh.setUI(new StyledButtonUI());
		btnRefresh.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnRefresh.setBounds(1184, 479, 159, 58);
		frame.getContentPane().add(btnRefresh);
		button_1.setBounds(1184, 279, 159, 58);
		button_1.setUI(new StyledButtonUI());
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("OPEN");
		Image img2 = new ImageIcon(this.getClass().getResource("/open.png")).getImage();
		button_2.setIcon(new ImageIcon(img2));
		button_2.setFont(new Font("Sitka Text", Font.BOLD, 18));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row_index = table.getSelectedRow();
				String s1 = "company"+table.getValueAt(row_index, 0).toString();
				String s2 = table.getValueAt(row_index, 1).toString();
				
				try {
					CompanyAccount com = new CompanyAccount(s1,s2);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "hello");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "hi");
				}
			}
		});
		button_2.setBounds(1184, 179, 159, 58);
		button_2.setUI(new StyledButtonUI());
		frame.getContentPane().add(button_2);
		
		
		JButton btnAdd = new JButton("ADD NEW ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ComapnyDetails window = new ComapnyDetails();
					window.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e);
				} 
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/add-new-icon.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img6));
		btnAdd.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnAdd.setBackground(SystemColor.control);
		btnAdd.setUI(new StyledButtonUI());
		btnAdd.setBounds(1184, 579, 159, 58);
		
		frame.getContentPane().add(btnAdd);
		
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 79, 1122, 621);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		frame.setBounds(100, 100, 1610,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void callingData()
	{
		String call_data = "select companyid as ID,company_name as name, company_contact as Contact_Details ,  commpany_address as ADDRESS , company_bank as Bank_details , Acc_no as account_number , IFSC as IFS_CODE from Company_Details order by companyid";
		PreparedStatement call_data_stmt = null;
		ResultSet data_rs = null;
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			call_data_stmt = con.prepareStatement(call_data);
			data_rs = call_data_stmt.executeQuery();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, e2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, e);
		}
		table.setModel(DbUtils.resultSetToTableModel(data_rs));
	}
}
