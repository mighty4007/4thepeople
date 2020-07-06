package com.medi.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.medi.frames.LoginFrame;

public class WelcomeMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1820722866566456217L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeMain frame = new WelcomeMain();
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
	public WelcomeMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 488);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				new LoginFrame();
				dispose();
			}
		});
		btnNewButton.setBounds(701, 11, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("WelCome Dear.. lets do some work");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(236, 169, 327, 83);
		getContentPane().add(lblNewLabel);
	}
}
