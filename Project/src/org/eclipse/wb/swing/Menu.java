package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.BoxLayout;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ak Miglani\\Pictures\\4874159_orig.jpg"));
		frame.setBounds(100, 100, 602, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewCustomer = new JMenuItem("NEW CUSTOMER");
		mnFile.add(mntmNewCustomer);
		
		JMenuItem mntmOldCustomerDetails = new JMenuItem("OLD CUSTOMER DETAILS");
		mnFile.add(mntmOldCustomerDetails);
		
		JMenuItem mntmCompanyAccounts = new JMenuItem("COMPANY ACCOUNTS");
		mnFile.add(mntmCompanyAccounts);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mnFile.add(mntmExit);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(24, 62, 236, 51);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(307, 62, 214, 51);
		panel.add(btnNewButton_1);
	}
}
