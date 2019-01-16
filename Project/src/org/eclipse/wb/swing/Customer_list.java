package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Customer_list {

	private static JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_list window = new Customer_list();
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
	public Customer_list() {
		
		initialize();
		callingData();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1370, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomersList = new JLabel("CUSTOMERS' LIST");
		lblCustomersList.setBackground(Color.BLACK);
		lblCustomersList.setBounds(0, 13, 1370, 42);
		panel.add(lblCustomersList);
		lblCustomersList.setForeground(Color.WHITE);
		lblCustomersList.setFont(new Font("Sylfaen", Font.BOLD, 32));
		lblCustomersList.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Home go = new Home();
					go.main(null);
					frame.setVisible(false);
					frame.dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1);
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/home-icon.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.setUI(new StyledButtonUI());
		btnHome.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnHome.setBounds(1141, 92, 159, 58);
		frame.getContentPane().add(btnHome);
		
		JButton btnOpen = new JButton("OPEN");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row_index = table.getSelectedRow();
				String s1 = "c"+table.getValueAt(row_index, 0).toString();
				String s2 = 	table.getValueAt(row_index, 1).toString();
				try {
					
					CustomerAccount cus = new CustomerAccount(s1,s2);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();			}
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/open.png")).getImage();
		btnOpen.setIcon(new ImageIcon(img2));
		btnOpen.setUI(new StyledButtonUI());
		btnOpen.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnOpen.setBounds(1141, 192, 159, 58);
		frame.getContentPane().add(btnOpen);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row_index = table.getSelectedRow();
				if(row_index<0) {	
				}	
				else {
				String index =  table.getValueAt(row_index, 0).toString();
				String delete_customer_table = "Drop table c"+index;
				String delete_customer_name = "Delete from customers where customer_id = "+index;
				String commit = "commit";
				try {
					Connection con=DriverManager.getConnection(  
							"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
					Statement table_deletion_query = con.createStatement();
					table_deletion_query.execute(delete_customer_table);
					table_deletion_query.execute(delete_customer_name);
					Boolean bs = table_deletion_query.execute(commit);
					if(bs==false)
						JOptionPane.showMessageDialog(frame, "Account Deleted Succesfully");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1);
				}
				callingData();
				}
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnDelete.setIcon(new ImageIcon(img3));
		btnDelete.setUI(new StyledButtonUI());
		btnDelete.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnDelete.setBounds(1141, 292, 159, 58);
		frame.getContentPane().add(btnDelete);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
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
		Image img4 = new ImageIcon(this.getClass().getResource("/edit-icon.png")).getImage();
		btnEdit.setIcon(new ImageIcon(img4));
		btnEdit.setUI(new StyledButtonUI());
		btnEdit.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnEdit.setBounds(1141, 392, 159, 58);
		frame.getContentPane().add(btnEdit);
		
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
		btnRefresh.setBounds(1141, 492, 159, 58);
		frame.getContentPane().add(btnRefresh);
		
		
		JButton btnAdd = new JButton("ADD NEW ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					customer_details window = new customer_details();
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
		btnAdd.setBounds(1141, 592, 159, 58);
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
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 92, 1036, 595);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		
		frame.setBounds(100, 100, 1610,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void callingData()
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String call_data = "select customer_id as ID,customer_name as name, customer_company_name Company, mobile , o_add as OFFICE ,h_address as HOUSE_ADDRESS  from 		customers order by customer_id";
			PreparedStatement call_data_stmt = con.prepareStatement(call_data);
			ResultSet data_rs = call_data_stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(data_rs));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, e);
		}  
		
		
	}
}
