package com.medi.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.medi.model.UserDetails;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PatientMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7813809100437173603L;
	private JPanel contentPane;


	public PatientMainFrame(UserDetails user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new LineBorder(new Color(0, 0, 0)));
		header.setBounds(0, 11, 994, 51);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel userIDLable = new JLabel("UserID :");
		userIDLable.setBounds(818, 12, 46, 14);
		userIDLable.setHorizontalAlignment(SwingConstants.LEFT);
		userIDLable.setVerticalAlignment(SwingConstants.BOTTOM);
		header.add(userIDLable);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(796, 37, 68, 14);
		header.add(lblUsername);
		
		JLabel UserIDValue = new JLabel(user.getUserID());
		UserIDValue.setBounds(865, 12, 119, 14);
		header.add(UserIDValue);
		
		JLabel UserNameV = new JLabel(user.getUserName());
		UserNameV.setBounds(865, 37, 119, 14);
		header.add(UserNameV);
		
		JPanel footer = new JPanel();
		footer.setBorder(new LineBorder(new Color(0, 0, 0)));
		footer.setBounds(0, 541, 994, 19);
		contentPane.add(footer);
		
		JLabel footerNote = new JLabel("\u00A9 For the People");
		footerNote.setFont(new Font("Calibri", Font.ITALIC, 10));
		footer.add(footerNote);
	}
}
