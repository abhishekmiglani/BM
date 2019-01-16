package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class Update_Stock {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Stock window = new Update_Stock();
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
	public Update_Stock() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductStockCurrent = new JLabel("Product Current Status in the Stock\r\n");
		lblProductStockCurrent.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblProductStockCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductStockCurrent.setBounds(10, 38, 741, 14);
		frame.getContentPane().add(lblProductStockCurrent);
		
		JLabel lblUpdateYourStock = new JLabel("Update Your Stock");
		lblUpdateYourStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateYourStock.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblUpdateYourStock.setBounds(10, 203, 741, 14);
		frame.getContentPane().add(lblUpdateYourStock);
		
		JLabel lblNewLabel = new JLabel("Enter the amount sold out");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 270, 176, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(230, 268, 176, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewPrice = new JLabel("New Price");
		lblNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPrice.setBounds(50, 317, 176, 14);
		frame.getContentPane().add(lblNewPrice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 315, 176, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
