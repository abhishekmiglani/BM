package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class Home {

	static JFrame frmHomePage;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					frmHomePage.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
					window.frmHomePage.setVisible(true);
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
	public Home() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmHomePage = new JFrame();
		frmHomePage.getContentPane().setBackground(Color.WHITE);
		frmHomePage.getContentPane().setForeground(new Color(0, 204, 102));
		frmHomePage.setTitle("Home Page\r\n");
		frmHomePage.setBounds(100, 100, 1610,750);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String check_table = "select count(TABLE_NAME) from dba_tables where table_name = 'COMPANY_DETAILS'";
		Statement stmt = con.createStatement();
		ResultSet check_table_rs = stmt.executeQuery(check_table);
		check_table_rs.next();
		if(check_table_rs.getInt(1)==0)
		{
			String create_table = "create table company_details (companyID number(10) primary key, company_name varchar2(60) not null , commpany_address varchar2(60) , company_contact VARCHAR2(10) , Company_bank varchar2(60) , acc_no varchar2(60) , ifsc varchar2(60))"; 
			stmt.execute(create_table);
		}
		String check_table_customer = "select count(TABLE_NAME) from dba_tables where table_name = 'CUSTOMERS'";
		Statement stmt1 = con.createStatement();
		ResultSet check_table_customer_rs = stmt.executeQuery(check_table_customer);
		check_table_customer_rs.next();
		if(check_table_customer_rs.getInt(1)==0)
		{
			String create_table_customer = "create table customers (customer_id number(5),customer_name varchar2(60) ,customer_company_name varchar2(60),mobile number(10) , o_add varchar2(60),h_address varchar2(60))"; 
			stmt.execute(create_table_customer);
		}
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1370, 21);
		frmHomePage.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File        ");
		menuBar.add(mnFile);
		
		JMenuItem mntmCustomerList = new JMenuItem("Customer List");
		mntmCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer_list cl ;
				cl = new Customer_list();
				cl.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
				
			}
		});
		mnFile.add(mntmCustomerList);
		
		JMenuItem mntmCompanyList = new JMenuItem("Company List");
		mntmCompanyList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				company_lists cl;
				cl = new company_lists();
				cl.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
				
			}
		});
		mnFile.add(mntmCompanyList);
		
		
		JMenuItem mntmProductList = new JMenuItem("Product List");
		mntmProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnFile.add(mntmProductList);
		
		JMenu mnEdit = new JMenu("Edit        ");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddNewCustomer = new JMenuItem("Add New Customer");
		mntmAddNewCustomer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				customer_details ac = null;
				try {
					ac = new customer_details();
					ac.main(null);
					frmHomePage.setVisible(false);
					frmHomePage.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.main(null);
			}
		});
		mnEdit.add(mntmAddNewCustomer);
		
		JMenuItem mntmAddNewProduct = new JMenuItem("Add New Product");
		mntmAddNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnEdit.add(mntmAddNewProduct);
		
		JMenuItem mntmAddNewCompany = new JMenuItem("Add New Company");
		mntmAddNewCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComapnyDetails cd;
				try {
					cd = new ComapnyDetails();
					cd.main(null);
					frmHomePage.setVisible(false);
					frmHomePage.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnEdit.add(mntmAddNewCompany);
		
		JMenu mnUpadte = new JMenu("Update\r\n");
		menuBar.add(mnUpadte);
		
		JMenuItem mntmUpdateCustomerList = new JMenuItem("Update Product Details\r\n\r\n");
		mntmUpdateCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock s1=new Stock();
				s1.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
			}
		});
		mnUpadte.add(mntmUpdateCustomerList);
		
		JMenuItem mntmUpdateStock = new JMenuItem("Update stock");
		mntmUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock s=new Stock();
				s.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
			}
		});
		mnUpadte.add(mntmUpdateStock);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 21, 1370, 89);
		frmHomePage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Welcome To your Business Managment Software");
		lblNewJgoodiesTitle.setBounds(198, 5, 974, 78);
		panel_1.add(lblNewJgoodiesTitle);
		lblNewJgoodiesTitle.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesTitle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 34));
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JButton btnAddNewCompany = new JButton("ADD NEW COMPANY");
		btnAddNewCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComapnyDetails window =new ComapnyDetails();
					window.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddNewCompany.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnAddNewCompany.setBackground(new Color(211, 211, 211));
		btnAddNewCompany.setBounds(751, 173, 212, 58);
		btnAddNewCompany.setUI(new StyledButtonUI());
		frmHomePage.getContentPane().add(btnAddNewCompany);
		
		JButton button1 = new JButton("OPEN CUSTOMERS LIST");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_list window = new Customer_list();
				window.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
			}
		});
		button1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		button1.setBackground(new Color(211, 211, 211));
		button1.setBounds(408, 173, 212, 58);
		button1.setUI(new StyledButtonUI());
		frmHomePage.getContentPane().add(button1);
		
		JButton button11 = new JButton("OPEN COMPANY LIST");
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				company_lists window;
				window = new company_lists();
				window.main(null);
				frmHomePage.setVisible(false);
				frmHomePage.dispose();
				
			}
		});
		button11.setFont(new Font("Sitka Text", Font.BOLD, 14));
		button11.setBackground(new Color(211, 211, 211));
		button11.setBounds(1073, 173, 212, 58);
		button11.setUI(new StyledButtonUI());
		frmHomePage.getContentPane().add(button11);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 326, 1370, 305);
		frmHomePage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MIGLANI BEEJ STORE");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(131, 54, 1108, 197);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(152, 251, 152));
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 78));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
