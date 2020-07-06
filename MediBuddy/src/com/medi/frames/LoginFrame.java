package com.medi.frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.medi.controller.UserController;
import com.medi.exception.MediException;
import com.medi.model.UserDetails;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -101086820180849026L;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JTextField userID;

	public LoginFrame() {

		System.out.println("reached login:" + this.isVisible());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(306, 189, 64, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPassword.setBounds(306, 218, 64, 14);
		contentPane.add(lblPassword);

		userName = new JTextField();
		userName.setBounds(373, 186, 183, 20);
		contentPane.add(userName);
		userName.setColumns(10);

		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {

				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					submitAction();
				}
			}
		});

		password.setBounds(373, 214, 183, 20);
		contentPane.add(password);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				submitAction();

			}
		});

		btnNewButton.setBounds(401, 256, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblUserid = new JLabel("UserID :");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUserid.setBounds(306, 164, 64, 14);
		contentPane.add(lblUserid);

		userID = new JTextField();
		userID.setColumns(10);
		userID.setBounds(373, 161, 183, 20);
		contentPane.add(userID);
		this.setVisible(true);

	}

	public void submitAction() {

		String username = userName.getText().trim();
		
		String userId = userID.getText().trim();
		String pwd = new StringBuilder().append(password.getPassword()).toString().trim();
		UserDetails user = null;
		try {
			user = UserController.getUser(userId, username, pwd);
			JOptionPane.showMessageDialog(this, user.getUserID() + ":" + user.getUserName() + ":"+user.getPassword() );
			new PatientMainFrame(user).setVisible(true);
			dispose();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		} catch (MediException m) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, m.getMessage());
		}

	}
}
