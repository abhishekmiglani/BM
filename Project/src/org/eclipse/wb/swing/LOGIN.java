package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LOGIN {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private int i ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN window = new LOGIN();
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
	public LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 542, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.RED);
		lblUsername.setFont(new Font("Sitka Text", Font.BOLD, 16));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i>=3)
				{
					JOptionPane.showMessageDialog(frame, "UNAUTHORISED USER\nYOU CANNOT ACCESS THE SYSTEM");
				}
				if(textField.getText().equalsIgnoreCase("MIGLANIJI") && passwordField.getText().equalsIgnoreCase(passwd.loginpasswd) && i<3)
				{
					try {
						Home window = new Home();
						window.frmHomePage.setVisible(true);
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frame.dispose();
				}
				else
				{
					i++;
					JOptionPane.showMessageDialog(frame,"Wrong Credentials\nAccess Denied");
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		
		JRadioButton rdbtn = new JRadioButton("");
		rdbtn.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("M");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtn.isSelected()==true)
					Home.main(null);
			}
		});
		lblNewLabel.setForeground(new Color(124, 252, 0));
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		
		JLabel lbllogin = new JLabel("LOGIN PLEASE");
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setFont(new Font("Sitka Text", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(505)
					.addComponent(rdbtn))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel))
				.addComponent(lbllogin, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
					.addGap(93))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(199))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtn)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lbllogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(42)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addGap(49)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
					.addGap(70))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addGap(9))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addGap(9))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(textField)
							.addGap(4)))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(passwordField)
							.addGap(15))))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
