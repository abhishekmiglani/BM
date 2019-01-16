package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;


public class CustomerAccount {

	private static JFrame frame;
	private JTable table;
	String s ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAccount window = new CustomerAccount();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e);
				}
			}
		});
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CustomerAccount() throws ClassNotFoundException, SQLException {
		initialize("NEW","new");
	}
	public CustomerAccount(String s1,String s2) throws ClassNotFoundException, SQLException
	{
		initialize(s1,s2);
	}

	Double GrandTotal = 0.0 , QuantTotal =0.0;
	int customer_id = 0;
	private JScrollPane scrollPane;
	private JTextField BillNoField;
	private JTextField Particular2;
	private JTextField Rate2;
	private JTextField Quant2;
	private JLabel Total2;
	private JTextField Particular3;
	private JTextField Rate3;
	private JTextField Quant3;
	private JLabel Total3;
	private JTextField Particular4;
	private JTextField Rate4;
	private JTextField Quant4;
	private JLabel Total4;
	private JTextField Particular5;
	private JTextField Rate5;
	private JTextField Quant5;
	private JLabel Total5;
	private JTextField Particular6;
	private JTextField Rate6;
	private JTextField Quant6;
	private JLabel Total6;
	private JTextField Particular7;
	private JTextField Rate7;
	private JTextField Quant7;
	private JLabel Total7;
	private JTextField Particular1;
	private JTextField Rate1;
	private JTextField Quant1;
	private JLabel Total1;
	private JTextField Particular8;
	private JTextField Rate8;
	private JTextField Quant8;
	private JLabel Total8;
	private JTextField Particular9;
	private JTextField Rate9;
	private JTextField Quant9;
	private JLabel Total9;
	private JTextField Particular10;
	private JTextField Rate10;
	private JTextField Quant10;
	private JLabel Total10;
	private JTextField Particular11;
	private JTextField Rate11;
	private JTextField Quant11;
	private JLabel Total11;
	private JTextField Particular12;
	private JTextField Rate12;
	private JTextField Quant12;
	private JLabel Total12;
	private JTextField Particular13;
	private JTextField Rate13;
	private JTextField Quant13;
	private JLabel Total13;
	private JTextField Particular14;
	private JTextField Rate14;
	private JTextField Quant14;
	private JLabel Total14;
	private JTextField Particular15;
	private JTextField Rate15;
	private JTextField Quant15;
	private JLabel Total15;
	private JTextField Particular16;
	private JTextField Rate16;
	private JTextField Quant16;
	private JLabel Total16;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel CreditQuantTotal;
	private JLabel CreditTotal;
	private JButton lblTotal_1;
	private JPanel DetailPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton Enterbtn;
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnPrintBill;
	private JButton btnNewButton;
	private JLabel BillDate;
	private JLabel lblTotal;
	private JLabel BillTotalAmount;
	private JPanel panel_1;
	
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(String table_name,String customer_name) throws SQLException, ClassNotFoundException {
//		
//				
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 255, 47));
		
		frame.getContentPane().setForeground(Color.BLUE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		scrollPane.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		scrollPane.setAlignmentY(1.0f);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(13, 107, 833, 380);
		frame.getContentPane().add(scrollPane);
	
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		table.setRowHeight(30);
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		Statement stmt = con.createStatement();
		String sum = "select sum(credit) , sum(debit) from "+table_name;
		ResultSet srs = stmt.executeQuery(sum);
		srs.next();
		Double credit_total = srs.getDouble(1);
		Double debit_total = srs.getDouble(2);
		
		Double balance = new Double(0);
		balance = debit_total-credit_total;
		
		
		
		String query = "select  TO_CHAR(DESIRED_DATE, 'dd/MON/yy') as DATE_ , BillNo, PARTICULAR , CREDIT , DEBIT FROM "+table_name;
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1370, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(customer_name+"'s Account");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(89, 5, 1191, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(916, 72, 442, 614);
		frame.getContentPane().add(tabbedPane);
		
		DetailPane = new JPanel();
		tabbedPane.addTab("Details", null, DetailPane, null);
		DetailPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 43, 413, 377);
		DetailPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblBillNo = new JLabel("Bill No. :");
		lblBillNo.setBounds(12, 12, 44, 16);
		DetailPane.add(lblBillNo);
		
		JLabel BillNo = new JLabel("");
		BillNo.setBounds(70, 12, 27, 16);
		DetailPane.add(BillNo);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(296, 12, 35, 16);
		DetailPane.add(lblDate);
		
		BillDate = new JLabel("");
		BillDate.setBounds(341, 12, 71, 16);
		DetailPane.add(BillDate);
		
		btnPrintBill = new JButton("Print Bill");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header  = new MessageFormat("Bill No. "+BillNo.getText()+"                                  Date: "+BillDate.getText()) ;
				MessageFormat footer  = new MessageFormat("             Total :                           "+BillTotalAmount.getText()) ;
				PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
				pras.add(OrientationRequested.PORTRAIT);
				MessageFormat heads = new MessageFormat("");
//				Printable
				
				
			}
		});
		btnPrintBill.setBounds(323, 540, 102, 34);
		DetailPane.add(btnPrintBill);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(12, 432, 413, 19);
		DetailPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(189, 0, 34, 19);
		panel_1.add(lblTotal);
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		
		BillTotalAmount = new JLabel("");
		BillTotalAmount.setBounds(342, 0, 71, 19);
		panel_1.add(BillTotalAmount);
		BillTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		BillTotalAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel BillingPane = new JPanel();
		tabbedPane.addTab("Billing", null, BillingPane, null);
		BillingPane.setLayout(null);
		
		JLabel lblParticular = new JLabel("Particular");
		lblParticular.setHorizontalAlignment(SwingConstants.CENTER);
		lblParticular.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParticular.setBounds(52, 21, 73, 21);
		BillingPane.add(lblParticular);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRate.setBounds(210, 21, 35, 21);
		BillingPane.add(lblRate);
		
		JLabel lblQuantity = new JLabel("Quant.");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 16));
		lblQuantity.setBounds(257, 21, 54, 21);
		BillingPane.add(lblQuantity);
		
		Particular1 = new JTextField();
		Particular1.setColumns(10);
		Particular1.setBounds(52, 41, 135, 20);
		BillingPane.add(Particular1);
		
		Rate1 = new JTextField();
		Rate1.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate1.setText("0.00");
		Rate1.setColumns(10);
		Rate1.setBounds(199, 41, 54, 20);
		BillingPane.add(Rate1);
		
		Quant1 = new JTextField();
		Quant1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate1.getText());
					Double j = Double.parseDouble(Quant1.getText());
					Double k = i*j;
					Total1.setText(k.toString());
				}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, e);
				}
			}
		});
		Quant1.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant1.setText("0");
		Quant1.setColumns(10);
		Quant1.setBounds(257, 41, 54, 20);
		BillingPane.add(Quant1);
		
		Total1 = new JLabel();
		Total1.setHorizontalAlignment(SwingConstants.RIGHT);
		Total1.setText("0.00");
		Total1.setBounds(338, 41, 89, 20);
		BillingPane.add(Total1);
		
		Particular2 = new JTextField();
		Particular2.setBounds(52, 71, 135, 20);
		BillingPane.add(Particular2);
		Particular2.setColumns(10);
		
		Rate2 = new JTextField();
		Rate2.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate2.setText("0.00");
		Rate2.setBounds(199, 71, 54, 20);
		BillingPane.add(Rate2);
		Rate2.setColumns(10);
		
		Quant2 = new JTextField();
		Quant2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate2.getText());
					Double j = Double.parseDouble(Quant2.getText());
					Double k = i*j;
					Total2.setText(k.toString());
				}
			}
		});
		Quant2.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant2.setText("0");
		Quant2.setColumns(10);
		Quant2.setBounds(257, 71, 54, 20);
		BillingPane.add(Quant2);
		
		Total2 = new JLabel();
		Total2.setHorizontalAlignment(SwingConstants.RIGHT);
		Total2.setText("0.00");
		Total2.setBounds(338, 71, 89, 20);
		BillingPane.add(Total2);
		
		Particular3 = new JTextField();
		Particular3.setColumns(10);
		Particular3.setBounds(52, 101, 135, 20);
		BillingPane.add(Particular3);
		
		Rate3 = new JTextField();
		Rate3.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate3.setText("0.00");
		Rate3.setColumns(10);
		Rate3.setBounds(199, 101, 54, 20);
		BillingPane.add(Rate3);
		
		Quant3 = new JTextField();
		Quant3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate3.getText());
					Double j = Double.parseDouble(Quant3.getText());
					Double k = i*j;
					Total3.setText(k.toString());
				}
			}
		});
		Quant3.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant3.setText("0");
		Quant3.setColumns(10);
		Quant3.setBounds(257, 101, 54, 20);
		BillingPane.add(Quant3);
		
		Total3 = new JLabel();
		Total3.setHorizontalAlignment(SwingConstants.RIGHT);
		Total3.setText("0.00");
		Total3.setBounds(338, 101, 89, 20);
		BillingPane.add(Total3);
		
		Particular4 = new JTextField();
		Particular4.setColumns(10);
		Particular4.setBounds(52, 131, 135, 20);
		BillingPane.add(Particular4);
		
		Rate4 = new JTextField();
		Rate4.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate4.setText("0.00");
		Rate4.setColumns(10);
		Rate4.setBounds(199, 131, 54, 20);
		BillingPane.add(Rate4);
		
		Quant4 = new JTextField();
		Quant4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate4.getText());
					Double j = Double.parseDouble(Quant4.getText());
					Double k = i*j;
					Total4.setText(k.toString());
				}
			}
		});
		Quant4.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant4.setText("0");
		Quant4.setColumns(10);
		Quant4.setBounds(257, 131, 54, 20);
		BillingPane.add(Quant4);
		
		Total4 = new JLabel();
		Total4.setHorizontalAlignment(SwingConstants.RIGHT);
		Total4.setText("0.00");
		Total4.setBounds(338, 131, 89, 20);
		BillingPane.add(Total4);
		
		Particular5 = new JTextField();
		Particular5.setColumns(10);
		Particular5.setBounds(52, 161, 135, 20);
		BillingPane.add(Particular5);
		
		Rate5 = new JTextField();
		Rate5.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate5.setText("0.00");
		Rate5.setColumns(10);
		Rate5.setBounds(199, 161, 54, 20);
		BillingPane.add(Rate5);
		
		Quant5 = new JTextField();
		Quant5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate5.getText());
					Double j = Double.parseDouble(Quant5.getText());
					Double k = i*j;
					Total5.setText(k.toString());
				}
			}
		});
		Quant5.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant5.setText("0");
		Quant5.setColumns(10);
		Quant5.setBounds(257, 161, 54, 20);
		BillingPane.add(Quant5);
		
		Total5 = new JLabel();
		Total5.setHorizontalAlignment(SwingConstants.RIGHT);
		Total5.setText("0.00");
		Total5.setBounds(338, 161, 89, 20);
		BillingPane.add(Total5);
		
		Particular6 = new JTextField();
		Particular6.setColumns(10);
		Particular6.setBounds(52, 191, 135, 20);
		BillingPane.add(Particular6);
		
		Rate6 = new JTextField();
		Rate6.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate6.setText("0.00");
		Rate6.setColumns(10);
		Rate6.setBounds(199, 191, 54, 20);
		BillingPane.add(Rate6);
		
		Quant6 = new JTextField();
		Quant6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate6.getText());
					Double j = Double.parseDouble(Quant6.getText());
					Double k = i*j;
					Total6.setText(k.toString());
				}
			}
		});
		Quant6.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant6.setText("0");
		Quant6.setColumns(10);
		Quant6.setBounds(257, 191, 54, 20);
		BillingPane.add(Quant6);
		
		Total6 = new JLabel();
		Total6.setHorizontalAlignment(SwingConstants.RIGHT);
		Total6.setText("0.00");
		Total6.setBounds(338, 191, 89, 20);
		BillingPane.add(Total6);
		
		Particular7 = new JTextField();
		Particular7.setColumns(10);
		Particular7.setBounds(52, 221, 135, 20);
		BillingPane.add(Particular7);
		
		Rate7 = new JTextField();
		Rate7.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate7.setText("0.00");
		Rate7.setColumns(10);
		Rate7.setBounds(199, 221, 54, 20);
		BillingPane.add(Rate7);
		
		Quant7 = new JTextField();
		Quant7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate7.getText());
					Double j = Double.parseDouble(Quant7.getText());
					Double k = i*j;
					Total7.setText(k.toString());
				}
			}
		});
		Quant7.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant7.setText("0");
		Quant7.setColumns(10);
		Quant7.setBounds(257, 221, 54, 20);
		BillingPane.add(Quant7);
		
		Total7 = new JLabel();
		Total7.setHorizontalAlignment(SwingConstants.RIGHT);
		Total7.setText("0.00");
		Total7.setBounds(338, 221, 89, 20);
		BillingPane.add(Total7);
		
		Particular8 = new JTextField();
		Particular8.setColumns(10);
		Particular8.setBounds(52, 251, 135, 20);
		BillingPane.add(Particular8);
		
		Rate8 = new JTextField();
		Rate8.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate8.setText("0.00");
		Rate8.setColumns(10);
		Rate8.setBounds(199, 253, 54, 20);
		BillingPane.add(Rate8);
		
		Quant8 = new JTextField();
		Quant8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_TAB);
				{
					Double i = Double.parseDouble(Rate8.getText());
					Double j = Double.parseDouble(Quant8.getText());
					Double k = i*j;
					Total8.setText(k.toString());
				}
			}
		});
		Quant8.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant8.setText("0");
		Quant8.setColumns(10);
		Quant8.setBounds(257, 251, 54, 20);
		BillingPane.add(Quant8);
		
		Total8 = new JLabel();
		Total8.setHorizontalAlignment(SwingConstants.RIGHT);
		Total8.setText("0.00");
		Total8.setBounds(338, 251, 89, 20);
		BillingPane.add(Total8);
		
		Particular9 = new JTextField();
		Particular9.setColumns(10);
		Particular9.setBounds(52, 283, 135, 20);
		BillingPane.add(Particular9);
		
		Rate9 = new JTextField();
		Rate9.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate9.setText("0.00");
		Rate9.setColumns(10);
		Rate9.setBounds(199, 283, 54, 20);
		BillingPane.add(Rate9);
		
		Quant9 = new JTextField();
		Quant9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate9.getText());
					Double j = Double.parseDouble(Quant9.getText());
					Double k = i*j;
					Total9.setText(k.toString());
				}
			}
		});
		Quant9.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant9.setText("0");
		Quant9.setColumns(10);
		Quant9.setBounds(257, 283, 54, 20);
		BillingPane.add(Quant9);
		
		Total9 = new JLabel();
		Total9.setHorizontalAlignment(SwingConstants.RIGHT);
		Total9.setText("0.00");
		Total9.setBounds(338, 283, 89, 20);
		BillingPane.add(Total9);
		
		Particular10 = new JTextField();
		Particular10.setColumns(10);
		Particular10.setBounds(52, 315, 135, 20);
		BillingPane.add(Particular10);
		
		Rate10 = new JTextField();
		Rate10.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate10.setText("0.00");
		Rate10.setColumns(10);
		Rate10.setBounds(199, 315, 54, 20);
		BillingPane.add(Rate10);
		
		Quant10 = new JTextField();
		Quant10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate10.getText());
					Double j = Double.parseDouble(Quant10.getText());
					Double k = i*j;
					Total10.setText(k.toString());
				}
			}
		});
		Quant10.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant10.setText("0");
		Quant10.setColumns(10);
		Quant10.setBounds(257, 315, 54, 20);
		BillingPane.add(Quant10);
		
		Total10 = new JLabel();
		Total10.setHorizontalAlignment(SwingConstants.RIGHT);
		Total10.setText("0.00");
		Total10.setBounds(338, 315, 89, 20);
		BillingPane.add(Total10);
		
		Particular11 = new JTextField();
		Particular11.setColumns(10);
		Particular11.setBounds(52, 345, 135, 20);
		BillingPane.add(Particular11);
		
		Rate11 = new JTextField();
		Rate11.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate11.setText("0.00");
		Rate11.setColumns(10);
		Rate11.setBounds(199, 345, 54, 20);
		BillingPane.add(Rate11);
		
		Quant11 = new JTextField();
		Quant11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate11.getText());
					Double j = Double.parseDouble(Quant11.getText());
					Double k = i*j;
					Total11.setText(k.toString());
				}
			}
		});
		Quant11.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant11.setText("0");
		Quant11.setColumns(10);
		Quant11.setBounds(257, 345, 54, 20);
		BillingPane.add(Quant11);
		
		Total11 = new JLabel();
		Total11.setHorizontalAlignment(SwingConstants.RIGHT);
		Total11.setText("0.00");
		Total11.setBounds(338, 345, 89, 20);
		BillingPane.add(Total11);
		
		Particular12 = new JTextField();
		Particular12.setColumns(10);
		Particular12.setBounds(52, 377, 135, 20);
		BillingPane.add(Particular12);
		
		Rate12 = new JTextField();
		Rate12.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate12.setText("0.00");
		Rate12.setColumns(10);
		Rate12.setBounds(199, 377, 54, 20);
		BillingPane.add(Rate12);
		
		Quant12 = new JTextField();
		Quant12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate12.getText());
					Double j = Double.parseDouble(Quant12.getText());
					Double k = i*j;
					Total12.setText(k.toString());
				}
			}
		});
		Quant12.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant12.setText("0");
		Quant12.setColumns(10);
		Quant12.setBounds(257, 377, 54, 20);
		BillingPane.add(Quant12);
		
		Total12 = new JLabel();
		Total12.setHorizontalAlignment(SwingConstants.RIGHT);
		Total12.setText("0.00");
		Total12.setBounds(338, 377, 89, 20);
		BillingPane.add(Total12);
		
		Particular13 = new JTextField();
		Particular13.setColumns(10);
		Particular13.setBounds(52, 409, 135, 20);
		BillingPane.add(Particular13);
		
		Rate13 = new JTextField();
		Rate13.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate13.setText("0.00");
		Rate13.setColumns(10);
		Rate13.setBounds(199, 409, 54, 20);
		BillingPane.add(Rate13);
		
		Quant13 = new JTextField();
		Quant13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate13.getText());
					Double j = Double.parseDouble(Quant13.getText());
					Double k = i*j;
					Total13.setText(k.toString());
				}
			}
		});
		Quant13.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant13.setText("0");
		Quant13.setColumns(10);
		Quant13.setBounds(257, 409, 54, 20);
		BillingPane.add(Quant13);
		
		Total13 = new JLabel();
		Total13.setHorizontalAlignment(SwingConstants.RIGHT);
		Total13.setText("0.00");
		Total13.setBounds(338, 409, 89, 20);
		BillingPane.add(Total13);
		
		Particular14 = new JTextField();
		Particular14.setColumns(10);
		Particular14.setBounds(52, 441, 135, 20);
		BillingPane.add(Particular14);
		
		Rate14 = new JTextField();
		Rate14.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate14.setText("0.00");
		Rate14.setColumns(10);
		Rate14.setBounds(199, 441, 54, 20);
		BillingPane.add(Rate14);
		
		Quant14 = new JTextField();
		Quant14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate14.getText());
					Double j = Double.parseDouble(Quant14.getText());
					Double k = i*j;
					Total14.setText(k.toString());
				}
			}
		});
		Quant14.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant14.setText("0");
		Quant14.setColumns(10);
		Quant14.setBounds(257, 441, 54, 20);
		BillingPane.add(Quant14);
		
		Total14 = new JLabel();
		Total14.setHorizontalAlignment(SwingConstants.RIGHT);
		Total14.setText("0.00");
		Total14.setBounds(338, 441, 89, 20);
		BillingPane.add(Total14);
		
		Particular15 = new JTextField();
		Particular15.setColumns(10);
		Particular15.setBounds(52, 473, 135, 20);
		BillingPane.add(Particular15);
		
		Rate15 = new JTextField();
		Rate15.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate15.setText("0.00");
		Rate15.setColumns(10);
		Rate15.setBounds(199, 473, 54, 20);
		BillingPane.add(Rate15);
		
		Quant15 = new JTextField();
		Quant15.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate15.getText());
					Double j = Double.parseDouble(Quant15.getText());
					Double k = i*j;
					Total15.setText(k.toString());
				}
			}
		});
		Quant15.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant15.setText("0");
		Quant15.setColumns(10);
		Quant15.setBounds(257, 473, 54, 20);
		BillingPane.add(Quant15);
		
		Total15 = new JLabel();
		Total15.setHorizontalAlignment(SwingConstants.RIGHT);
		Total15.setText("0.00");
		Total15.setBounds(338, 473, 89, 20);
		BillingPane.add(Total15);
		
		Particular16 = new JTextField();
		Particular16.setColumns(10);
		Particular16.setBounds(52, 505, 135, 20);
		BillingPane.add(Particular16);
		
		Rate16 = new JTextField();
		Rate16.setHorizontalAlignment(SwingConstants.RIGHT);
		Rate16.setText("0.00");
		Rate16.setColumns(10);
		Rate16.setBounds(199, 505, 54, 20);
		BillingPane.add(Rate16);
		
		Quant16 = new JTextField();
		Quant16.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER);
				{
					Double i = Double.parseDouble(Rate16.getText());
					Double j = Double.parseDouble(Quant16.getText());
					Double k = i*j;
					Total16.setText(k.toString());
				}
			}
		});
		Quant16.setHorizontalAlignment(SwingConstants.RIGHT);
		Quant16.setText("0");
		Quant16.setColumns(10);
		Quant16.setBounds(257, 505, 54, 20);
		BillingPane.add(Quant16);
		
		Total16 = new JLabel();
		Total16.setHorizontalAlignment(SwingConstants.RIGHT);
		Total16.setText("0.00");
		Total16.setBounds(338, 505, 89, 20);
		BillingPane.add(Total16);
		
		label = new JLabel("1");
		label.setBounds(12, 43, 7, 16);
		BillingPane.add(label);
		
		label_1 = new JLabel("2");
		label_1.setBounds(12, 73, 7, 16);
		BillingPane.add(label_1);
		
		label_2 = new JLabel("3");
		label_2.setBounds(12, 103, 7, 16);
		BillingPane.add(label_2);
		
		label_3 = new JLabel("4");
		label_3.setBounds(12, 133, 7, 16);
		BillingPane.add(label_3);
		
		label_4 = new JLabel("5");
		label_4.setBounds(12, 163, 7, 16);
		BillingPane.add(label_4);
		
		label_5 = new JLabel("6");
		label_5.setBounds(12, 193, 7, 16);
		BillingPane.add(label_5);
		
		label_6 = new JLabel("7");
		label_6.setBounds(12, 223, 7, 16);
		BillingPane.add(label_6);
		
		label_7 = new JLabel("8");
		label_7.setBounds(12, 253, 7, 16);
		BillingPane.add(label_7);
		
		label_8 = new JLabel("9");
		label_8.setBounds(12, 285, 7, 16);
		BillingPane.add(label_8);
		
		label_9 = new JLabel("10");
		label_9.setBounds(12, 317, 14, 16);
		BillingPane.add(label_9);
		
		label_10 = new JLabel("11");
		label_10.setBounds(12, 347, 14, 16);
		BillingPane.add(label_10);
		
		label_11 = new JLabel("12");
		label_11.setBounds(12, 379, 14, 16);
		BillingPane.add(label_11);
		
		label_12 = new JLabel("13");
		label_12.setBounds(12, 411, 14, 16);
		BillingPane.add(label_12);
		
		label_13 = new JLabel("14");
		label_13.setBounds(12, 443, 14, 16);
		BillingPane.add(label_13);
		
		label_14 = new JLabel("15");
		label_14.setBounds(12, 475, 14, 16);
		BillingPane.add(label_14);
		
		label_15 = new JLabel("16");
		label_15.setBounds(12, 507, 14, 16);
		BillingPane.add(label_15);
		
		CreditQuantTotal = new JLabel("0");
		CreditQuantTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		CreditQuantTotal.setBounds(257, 537, 55, 16);
		BillingPane.add(CreditQuantTotal);
		
		
		CreditTotal = new JLabel("0.00");
		CreditTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		CreditTotal.setBounds(338, 537, 89, 16);
		BillingPane.add(CreditTotal);
		

		JLabel TotalArray[] = {Total1,Total2,Total3,Total4,Total5,Total6,Total7,Total8,Total9,Total10,Total11,Total12,Total13,Total14,Total15,Total16};
		JTextField ParticularArray[] = {Particular1,Particular2	,Particular3,Particular4,Particular5,Particular6,Particular7,Particular8,Particular9,Particular10,Particular11,Particular12,Particular13,Particular14,Particular15,Particular16};	
		JTextField RateArray[] = {Rate1,Rate2,Rate3,Rate4,Rate5,Rate6,Rate7,Rate8,Rate9,Rate10,Rate11,Rate12,Rate13,Rate14,Rate15,Rate16};
		JTextField QuantArray[] = {Quant1,Quant2,Quant3,Quant4,Quant5,Quant6,Quant7,Quant8,Quant9,Quant10,Quant11,Quant12,Quant13,Quant14,Quant15,Quant16};
		
		
		
		lblTotal_1 = new JButton("Total");
		lblTotal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0 ; i <TotalArray.length ; i++) {
					GrandTotal = GrandTotal + Double.parseDouble(TotalArray[i].getText());
					QuantTotal = QuantTotal + Double.parseDouble(QuantArray[i].getText());
				}
				CreditTotal.setText(GrandTotal.toString());
				CreditQuantTotal.setText(QuantTotal.toString());
			}
		});
		lblTotal_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_1.setBounds(52, 537, 135, 16);
		BillingPane.add(lblTotal_1);
		
		JRadioButton CreditRadioBtn = new JRadioButton("Credit");
		CreditRadioBtn.setSelected(true);
		buttonGroup.add(CreditRadioBtn);
		CreditRadioBtn.setBounds(310, 0, 59, 24);
		BillingPane.add(CreditRadioBtn);
		
		JRadioButton DebitRadioBtn = new JRadioButton("Debit");
		buttonGroup.add(DebitRadioBtn);
		DebitRadioBtn.setBounds(373, 0, 54, 24);
		BillingPane.add(DebitRadioBtn);
		
		BillNoField = new JTextField();
		BillNoField.setBounds(135, 2, 57, 20);
		BillNoField.setToolTipText("Enter Bill No.");
		BillingPane.add(BillNoField);
		BillNoField.setHorizontalAlignment(SwingConstants.CENTER);
		BillNoField.setColumns(10);
		
		String id_value = "select max(BillNo)+1  from "+table_name;
		Statement id_value_stmt = con.createStatement();
		ResultSet id_value_result = id_value_stmt.executeQuery(id_value);
		id_value_result.next();

		if(id_value_result.getString(1)==null)
			BillNoField.setText("1");
		else
			BillNoField.setText(id_value_result.getString(1));
		
		DateTextField Date = new DateTextField();
		Date.setBounds(12, 2, 111, 20);
		BillingPane.add(Date);
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		
		java.util.Date oo=Date.getDate();
		java.sql.Date os=new java.sql.Date(oo.getTime());
		
		Enterbtn = new JButton("ENTER");
		Enterbtn.setBounds(358, 565, 79, 21);
		BillingPane.add(Enterbtn);
		Enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement NewBillStatement = con.createStatement();
					NewBillStatement.executeQuery("Create table "+table_name+"Bill"+BillNoField.getText()+"(SNo number(5), Particular varchar(500) Primary Key , Rate decimal(20,2) , Quantity decimal(20,2) , Total Decimal(20,2))");
					ResultSet rr = NewBillStatement.executeQuery("Select sum(credit),sum(debit) from "+table_name+" where Desired_date<=(TO_DATE('"+os.toString()+"' ,'yyyy-mm-dd'))");
					rr.next();
					Double c = rr.getDouble(1) ,d = rr.getDouble(2) ,b = d-c; 
					
					String TotalParticular = "";
					
					for(int i = 0 ; i <16 ;i++ )
					{
						String Particular = ParticularArray[i].getText();
						TotalParticular = TotalParticular + ", " + Particular;
						if(Particular.equals(""))
							break;
						else
						{
							Double Rate = Double.parseDouble(RateArray[i].getText()) , Quant = Double.parseDouble(QuantArray[i].getText()) , Total = Double.parseDouble(TotalArray[i].getText());
							
							String data_insert_in_bill = "insert into "+table_name+"Bill"+BillNoField.getText()+" (SNo , Particular, Rate , Quantity, Total) values (?,?,?,?,?)";
							
							PreparedStatement data_insert_in_bill_statement = con.prepareStatement(data_insert_in_bill);
							
							data_insert_in_bill_statement.setInt(1, i+1);
							data_insert_in_bill_statement.setString(2, Particular);
							data_insert_in_bill_statement.setDouble(3,Rate);
							data_insert_in_bill_statement.setDouble(4, Quant);
							data_insert_in_bill_statement.setDouble(5, Rate*Quant);
							
							data_insert_in_bill_statement.executeQuery();
						}
					}

					Statement NewSerialNoStatement = con.createStatement();
					ResultSet NewSerialNo = NewSerialNoStatement.executeQuery("Select max(Sno)+1 from "+ table_name);
					NewSerialNo.next();
					
					String SerialNo = "1";
					if(NewSerialNo.getString(1)!=null)
						 SerialNo = NewSerialNo.getString(1);
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					String data_insert_in_account = "insert into " + table_name + "(Sno,BillNo,Desired_Date,Particular,Credit,Debit,Balance) values (?,?,?,?,?,?,?)";
					PreparedStatement data_insert_in_account_statement = con.prepareStatement(data_insert_in_account);
					
					data_insert_in_account_statement.setInt(1,Integer.parseInt(SerialNo) );
					data_insert_in_account_statement.setString(2, BillNoField.getText());
					data_insert_in_account_statement.setDate(3, os);
					data_insert_in_account_statement.setString(4,TotalParticular);
					
					if(CreditRadioBtn.isSelected())
					{
						data_insert_in_account_statement.setDouble(5, GrandTotal);
						data_insert_in_account_statement.setDouble(6, b);
					}
					else
					{
						data_insert_in_account_statement.setDouble(5, 0.00);
						data_insert_in_account_statement.setDouble(6, b);
					}
					data_insert_in_account_statement.setDouble(7, 0.00);
					  
					data_insert_in_account_statement.executeQuery();
					
					
					NewBillStatement.executeQuery("commit");
					
					
					ResultSet rs1 = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e);
					e.printStackTrace();
				} 
			}
		});
		
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(31, 545, 84, 23);
		frame.getContentPane().add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header  = new MessageFormat(customer_name) ;
				MessageFormat footer  = new MessageFormat("") ;
				try {
					table.print(PrintMode.FIT_WIDTH,header,footer);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame,"Nothing To Print");
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPrint.setBackground(new Color(211, 211, 211));
		btnPrint.setUI(new StyledButtonUI());
		
		btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					int row_index = table.getSelectedRow();
					String BillTableName = table_name+"Bill"+table.getValueAt(row_index, 1).toString();
					
					BillNo.setText((String) table.getValueAt(row_index, 1));
					BillDate.setText((String) table.getValueAt(row_index, 0));
					
					Statement BillDetailsStatement = con.createStatement();
					ResultSet BillDetailResultSet = BillDetailsStatement.executeQuery("Select Sno , Particular, Rate ,Quantity , Total as count from "+BillTableName);
					table_1.setModel(DbUtils.resultSetToTableModel(BillDetailResultSet));
					ResultSet BillDetailResultSet1 = BillDetailsStatement.executeQuery("Select Sno , Particular, Rate ,Quantity , Total as count from "+BillTableName);
					
					Double BillTotal = 0.0;
					while(BillDetailResultSet1.next())
					{
						BillTotal+=BillDetailResultSet1.getDouble(5);
					}
					BillTotalAmount.setText("Rs."+BillTotal.toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame,e);
//					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(848, 170, 67, 26);
		frame.getContentPane().add(btnNewButton);
		
		
		frame.setBounds(0, 0, 1610,750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
