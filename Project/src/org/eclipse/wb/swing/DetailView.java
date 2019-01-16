package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class DetailView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailView frame = new DetailView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DetailView() {
		setBounds(100, 100, 779, 474);

	}

}
