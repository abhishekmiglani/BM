package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Product_list {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_list window = new Product_list();
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
	public Product_list() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.LIGHT_GRAY);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 1075, 609);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1059, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblYourProductsList = new JLabel("Products List");
		lblYourProductsList.setBounds(423, 13, 212, 46);
		panel.add(lblYourProductsList);
		lblYourProductsList.setForeground(UIManager.getColor("TextField.background"));
		lblYourProductsList.setFont(new Font("Sylfaen", Font.BOLD, 34));
		lblYourProductsList.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder(null, new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))));
		scrollPane.setBounds(10, 85, 787, 458);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Home window = new Home();
					window.main(null);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(panel, e);
				}
				
			}
		});
		btnHome.setUI(new StyledButtonUI());
		Image img = new ImageIcon(this.getClass().getResource("/home-icon.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		btnHome.setBounds(825, 84, 196, 59);
		frame.getContentPane().add(btnHome);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setUI(new StyledButtonUI());
		Image img2 = new ImageIcon(this.getClass().getResource("/add-new-icon.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img2));
		btnAdd.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		btnAdd.setBounds(825, 184, 196, 59);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setUI(new StyledButtonUI());
		Image img3 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnDelete.setIcon(new ImageIcon(img3));
		btnDelete.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		btnDelete.setBounds(825, 284, 196, 59);
		frame.getContentPane().add(btnDelete);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefresh.setUI(new StyledButtonUI());
		Image img4 = new ImageIcon(this.getClass().getResource("/Refresh-icon.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(img4));
		btnRefresh.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		btnRefresh.setBounds(825, 384, 196, 59);
		frame.getContentPane().add(btnRefresh);
	}
}
