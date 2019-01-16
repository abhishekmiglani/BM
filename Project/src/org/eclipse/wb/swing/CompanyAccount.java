package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.Frame;
import javax.swing.JPanel;

public class CompanyAccount {

	private static JFrame frame;
	private JTable table;
	String s ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyAccount window = new CompanyAccount();
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
	public CompanyAccount() throws ClassNotFoundException, SQLException {
		initialize("NEW","new");
	}
	public CompanyAccount(String s1,String s2) throws ClassNotFoundException, SQLException
	{
		initialize(s1,s2);
	}

	int customer_id = 0;
	private JScrollPane scrollPane;
	private JTextField SnoField;
	private JTextField particular;
	private JTextField quantity;
	private JTextField rate;
	private JTextField credit;
	private JTextField Date;
	private DefaultTableModel model;
	private JTextField debit;
	
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(String table_name,String company_name) throws SQLException, ClassNotFoundException {
//		
//				
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.border.background"));
		frame.setForeground(Color.RED);

		frame.getContentPane().setForeground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		scrollPane.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		scrollPane.setAlignmentY(1.0f);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(13, 135, 901, 315);
		frame.getContentPane().add(scrollPane);
	
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		table.setRowHeight(50);
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		Statement stmt = con.createStatement();
		String sum = "select sum(credit) , sum(debit) from "+table_name;
		ResultSet srs = stmt.executeQuery(sum);
		srs.next();
		Double credit_total = srs.getDouble(1);
		Double debit_total = srs.getDouble(2);
		
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		lblTotal.setBounds(490, 461, 65, 40);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblCreditTotal = new JLabel(credit_total.toString());
		lblCreditTotal.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblCreditTotal.setBounds(591, 470, 86, 27);
		frame.getContentPane().add(lblCreditTotal);
		
		JLabel lblDebitTotal = new JLabel(debit_total.toString());
		lblDebitTotal.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblDebitTotal.setBounds(697, 470, 86, 27);
		frame.getContentPane().add(lblDebitTotal);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		lblBalance.setBounds(420, 497, 135, 40);
		frame.getContentPane().add(lblBalance);
		
		Double balance = new Double(0);
		balance = debit_total-credit_total;
		
		JLabel label = new JLabel(balance.toString());
		label.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		label.setBounds(591, 506, 86, 27);
		frame.getContentPane().add(label);
		
		SnoField = new JTextField();
		SnoField.setHorizontalAlignment(SwingConstants.CENTER);
		SnoField.setBounds(141, 73, 57, 20);
		SnoField.setColumns(10);
		frame.getContentPane().add(SnoField);
		
		
		DateTextField Date = new DateTextField();
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		Date.setBounds(20, 73, 111, 20);
		frame.getContentPane().add(Date);
			
		particular = new JTextField();
		particular.setHorizontalAlignment(SwingConstants.CENTER);
		particular.setToolTipText("Enter the Details");
		particular.setColumns(10);
		particular.setBounds(208, 73, 142, 20);
		frame.getContentPane().add(particular);
		
		rate = new JTextField();
		rate.setText("0.00");
		rate.setHorizontalAlignment(SwingConstants.CENTER);
		rate.setColumns(10);
		rate.setBounds(475, 73, 111, 20);
		frame.getContentPane().add(rate);
		
		quantity = new JTextField();
		quantity.setText("0.00");
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		quantity.setColumns(10);
		quantity.setBounds(356, 73, 111, 20);
		frame.getContentPane().add(quantity);
		
		
		debit = new JTextField();
		debit.setHorizontalAlignment(SwingConstants.CENTER);
		debit.setText("0.00");
		debit.setBounds(739, 73, 57, 20);
		frame.getContentPane().add(debit);
		debit.setColumns(10);
		
		credit = new JTextField();
		credit.setText("0.00");
		credit.setHorizontalAlignment(SwingConstants.CENTER);
		credit.setColumns(10);
		credit.setBounds(633, 73, 57, 20);
		frame.getContentPane().add(credit);
		
		String id_value = "select max(BILL_NO)+1  from "+table_name;
		Statement id_value_stmt = con.createStatement();
		ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
		id_value_result.next();

		if(id_value_result.getString(1)==null)
			SnoField.setText("1");
		else
			SnoField.setText(id_value_result.getString(1));
		
		Statement st = con.createStatement();
		String query = "select  TO_CHAR(Billing_DATE, 'dd/mon/yy') as DATE_ , BILL_NO, PARTICULAR , QUANTITY , RATE , CREDIT , DEBIT , BALANCE FROM "+table_name+" order by billing_date , bill_no";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		
		JButton ADDbtn = new JButton("ADD");
		ADDbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ResultSet srs4 = stmt.executeQuery(sum);
					srs4.next();
					Double credit_total = srs4.getDouble(1);
					Double debit_total = srs4.getDouble(2);
					Double balance = new Double(0);
					balance = (Double.parseDouble(debit.getText()) - Double.parseDouble(credit.getText()))+(debit_total-credit_total);
					
					java.util.Date oo=Date.getDate();
					java.sql.Date os=new java.sql.Date(oo.getTime());
					
					String insertion_query = "insert into "+table_name+"(Billing_DATE,BILL_NO, PARTICULAR , QUANTITY , RATE , CREDIT , DEBIT, BALANCE) values (?,?,?,?,?,?,?,?)";
					PreparedStatement psiq = con.prepareStatement(insertion_query);
//					String duplicate_data_insertion_query = "insert into Duplicate"+table_name+"(Billing_DATE,BILL_NO, PARTICULAR , QUANTITY , RATE , CREDIT , DEBIT, BALANCE) values (?,?,?,?,?,?,?,?)";
//					PreparedStatement Duplicatepsiq = con.prepareStatement(duplicate_data_insertion_query);
					psiq.setInt(2, Integer.parseInt(SnoField.getText()));
					psiq.setDate(1, os );
					psiq.setString(3, particular.getText());
					psiq.setDouble(4, Double.parseDouble(quantity.getText()));
					psiq.setDouble(5, Double.parseDouble(rate.getText()));
					psiq.setDouble(6, Double.parseDouble(credit.getText()));
					psiq.setDouble(7,(Double.parseDouble(debit.getText())));
					psiq.setDouble(8, balance);
					psiq.execute();
							ResultSet rs = ps.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
							id_value_result.next();
							if(id_value_result.getString(1)==null)
								SnoField.setText("1");
							else
								SnoField.setText(id_value_result.getString(1));
							
							ResultSet srs3 = stmt.executeQuery(sum);
							srs3.next();
							credit_total = srs3.getDouble(1);
							debit_total = srs3.getDouble(2);
							lblCreditTotal.setText(credit_total.toString());
							lblDebitTotal.setText(debit_total.toString());
							balance = new Double(0);
							balance = debit_total-credit_total;
							label.setText(balance.toString());
							
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane jp = new JOptionPane("Error");
					jp.setVisible(true);
					jp.setBounds(23,23,100,100);
					e.printStackTrace();
				}
				finally {
					String s = "commit";
					try {
						st.execute(s);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame, e);
					}
				}
				
			}
		});
		ADDbtn.setBounds(806, 72, 84, 23);
		ADDbtn.setBackground(new Color(211, 211, 211));
		ADDbtn.setUI(new StyledButtonUI());
		frame.getContentPane().add(ADDbtn);
		
		
		
		
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row_index = table.getSelectedRow();
				String s1 = table.getValueAt(row_index, 1).toString();
				String delete_query = "Delete from "+table_name+" where Bill_no = "+s1 ;
				String duplicate_data_sdelete_query = "Delete from Duplicate"+table_name+" where Bill_no = "+s1 ;
				
				try {
					PreparedStatement dps = con.prepareStatement(delete_query);
					dps.executeQuery();
					PreparedStatement Duplicate_dps = con.prepareStatement(delete_query);
					Duplicate_dps.executeQuery();
					stmt.execute("commit");
					
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
					id_value_result.next();
					if(id_value_result.getString(1)==null)
						SnoField.setText("1");
					else
						SnoField.setText(id_value_result.getString(1));
					ResultSet srs3 = stmt.executeQuery(sum);
					srs3.next();
					Double credit_total = srs3.getDouble(1);
					Double debit_total = srs3.getDouble(2);
					lblCreditTotal.setText(credit_total.toString());
					lblDebitTotal.setText(debit_total.toString());
					Double balance = new Double(0);
					balance = debit_total-credit_total;
					label.setText(balance.toString());
					ResultSet rs1 = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(806, 106, 84, 23);
		btnDelete.setBackground(new Color(211, 211, 211));
		btnDelete.setUI(new StyledButtonUI());
		frame.getContentPane().add(btnDelete);

		
		JButton button_1 = new JButton("=");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double deb = Double.parseDouble(rate.getText())*Double.parseDouble(quantity.getText());
				debit.setText(deb.toString());
			}
		});
		button_1.setBackground(new Color(211, 211, 211));
		button_1.setBounds(697, 73, 43, 20);
		frame.getContentPane().add(button_1);
		
		
		
		JButton button_2 = new JButton("=");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double deb = Double.parseDouble(rate.getText())*Double.parseDouble(quantity.getText());
				credit.setText(deb.toString());
			}
		});
		button_2.setBackground(new Color(211, 211, 211));
		button_2.setBounds(591, 73, 43, 20);
		frame.getContentPane().add(button_2);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat(company_name);
				MessageFormat footer = new MessageFormat("");
				try {
					table.print(PrintMode.FIT_WIDTH,header,footer);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnPrint.setBackground(new Color(211, 211, 211));
		btnPrint.setUI(new StyledButtonUI());
		btnPrint.setBounds(34, 489, 84, 23);
		frame.getContentPane().add(btnPrint);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 928, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel(company_name+"'s Account");
		lblNewLabel.setBounds(99, 0, 730, 61);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.setBounds(100, 100, 944,587);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
