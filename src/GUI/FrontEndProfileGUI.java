package GUI;


import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.User;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Color;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField textField;
	private static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEndProfileGUI window = new FrontEndProfileGUI(user);
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
	public FrontEndProfileGUI(User aUser) {
		
		user = aUser; 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(108, 75, 181, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(437, 38, 317, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton = new JButton(search);
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(766, 27, 55, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(12, 13, 62, 53);
		panel.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(32, 561, 810, 336);
		panel.add(textArea);
		
		String namelastname = user.getFirstName() + " " + user.getLastName();
		JLabel labelnamelastname= new JLabel(namelastname);
		labelnamelastname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelnamelastname.setBounds(60, 240, 202, 26);
		panel.add(labelnamelastname);
		
		String companypost = user.getCompanyPost();
		JLabel labelcompanypost = new JLabel(companypost);
		labelcompanypost.setBounds(267, 250, 89, 16);
		panel.add(labelcompanypost);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization");
		lblNewLabel_3.setBounds(354, 250, 78, 16);
		panel.add(lblNewLabel_3);
		
		String email = user.getMyAccount().getEmail()
;		JLabel labelemail = new JLabel(email);
        labelemail.setBounds(130, 413, 125, 16);
		panel.add(labelemail);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 287, 133, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Group A");
		lblNewLabel_6.setBounds(108, 316, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Group B");
		lblNewLabel_7.setBounds(185, 316, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Group C");
		lblNewLabel_8.setBounds(253, 316, 56, 16);
		panel.add(lblNewLabel_8);
		
		JButton buttonchat= new JButton("Chat");
		buttonchat.setContentAreaFilled(false); 
		buttonchat.setFocusPainted(false); 
		buttonchat.setOpaque(false);
		buttonchat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//new PrivateChatGUI();// prepei na baloume twn xhrhsrh
			}
		});
		buttonchat.setBounds(479, 313, 62, 25);
		panel.add(buttonchat);
		
		JButton addConnection = new JButton("Add connection");
		addConnection.setContentAreaFilled(false); 
		addConnection.setFocusPainted(false); 
		addConnection.setOpaque(false);
		addConnection.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addConnection.setBounds(553, 313, 131, 25);
		panel.add(addConnection);
		
		JButton removeConnection = new JButton("Remove connection");
		removeConnection.setContentAreaFilled(false); 
		removeConnection.setFocusPainted(false); 
		removeConnection.setOpaque(false);
		removeConnection.setCursor(new Cursor(Cursor.HAND_CURSOR));
		removeConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		removeConnection.setBounds(694, 313, 148, 25);
		panel.add(removeConnection);
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(74, 376, 84, 16);
		panel.add(lblNewLabel_9);
		
		String telephone = user.getTelephone();
		JLabel labeltelephone = new JLabel(telephone);
		labeltelephone.setBounds(131, 442, 78, 16);
		panel.add(labeltelephone);
		
		String address = user.getAddress();
		JLabel labeladdress = new JLabel(address);
		labeladdress.setBounds(131, 476, 78, 16);
		panel.add(labeladdress);
		
		String birthday = user.getBirthday();
		JLabel labelbirthday = new JLabel(birthday);
		labelbirthday.setBounds(130, 510, 79, 16);
		panel.add(labelbirthday);
		
		JLabel lblNewLabel_13 = new JLabel("Mutual connections");
		lblNewLabel_13.setBounds(712, 377, 109, 16);
		panel.add(lblNewLabel_13);
		
		JList list = new JList();
		list.setBackground(new Color(255, 250, 240));
		list.setBounds(709, 409, 133, 127);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(821, 409, 21, 127);
		panel.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(814, 561, 28, 336);
		panel.add(scrollBar_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setFocusPainted(false); 
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(824, 929, 46, 38);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_14 = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
		lblNewLabel_14.setBounds(85, 409, 28, 25);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
		lblNewLabel_14_1.setBounds(85, 438, 28, 25);
		panel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_14_2 = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
		lblNewLabel_14_2.setBounds(85, 467, 28, 25);
		panel.add(lblNewLabel_14_2);
		
		JLabel lblNewLabel_14_3 = new JLabel(new ImageIcon("label_backgrounds/birthday_cake_20px.png"));
		lblNewLabel_14_3.setBounds(85, 501, 28, 25);
		panel.add(lblNewLabel_14_3);
	}
}
