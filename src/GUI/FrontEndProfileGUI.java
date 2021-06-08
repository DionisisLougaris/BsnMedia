package GUI;


import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Connection;
import entities.Employee;
import entities.Group;
import entities.User;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Color;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField searchtext;
	private static User tuser;
	private static User auser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEndProfileGUI window = new FrontEndProfileGUI(tuser, auser);
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
	public FrontEndProfileGUI(User tUser,User aUser) {
		tuser = tUser; //The user who is connected
		auser = aUser; //The other User
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
		
		Connection usersconnection = new Connection(tuser,auser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(108, 75, 183, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labeldefaulprofilephoto = new JLabel("default photo/defaultProfilePhoto.png");
		labeldefaulprofilephoto.setBounds(51, 66, 99, 16);
		panel_1.add(labeldefaulprofilephoto);
		
		searchtext = new JTextField();
		searchtext.setBackground(new Color(255, 250, 240));
		searchtext.setBounds(437, 38, 317, 30);
		panel.add(searchtext);
		searchtext.setColumns(10);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton searchbutton = new JButton(search);
		searchbutton.setContentAreaFilled(false); 
		searchbutton.setFocusPainted(false); 
		searchbutton.setOpaque(false);
		searchbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuser.getMyAccount().getMyCompany().searchObject(searchtext.getText(), tuser);
			}
		});
		searchbutton.setBounds(766, 27, 55, 44);
		panel.add(searchbutton);
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(tuser instanceof Chief)
				{
					BackendProfileChiefGUI myProfile = new BackendProfileChiefGUI(tuser);
				}
				else if(tuser instanceof Boss)
				{
					BackendProfileBossGUI myProfile = new BackendProfileBossGUI(tuser);
				}
				else if(tuser instanceof Employee)
				{
					BackendProfileEmployeeGUI myProfile = new BackendProfileEmployeeGUI(tuser);
				}
			}
		});
		btnNewButton_1.setBounds(12, 13, 62, 53);
		panel.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(32, 561, 810, 336);
		panel.add(textArea);
		
		String namelastname = auser.getFirstName() + " " + auser.getLastName();
		JLabel labelnamelastname= new JLabel(namelastname);
		labelnamelastname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelnamelastname.setBounds(60, 240, 202, 26);
		panel.add(labelnamelastname);
		
		
		String companypost = auser.getCompanyPost();
		JLabel labelcompanypost = new JLabel(companypost);
		labelcompanypost.setBounds(267, 250, 89, 16);
		panel.add(labelcompanypost);
		
		String spacialization = auser.getCompanyPost();
		JLabel labelspacialization = new JLabel(spacialization);
		labelspacialization.setBounds(354, 250, 78, 16);
		panel.add(labelspacialization);
		
		String email = auser.getMyAccount().getEmail();
		JLabel labelemail = new JLabel(email);
        labelemail.setBounds(130, 413, 125, 16);
		panel.add(labelemail);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 287, 133, 16);
		panel.add(lblNewLabel_5);
		
		ArrayList<Group> ausersgroups = auser.getGroups();
	

	   if( ausersgroups.size() ==1)
	   {
		 JLabel lblNewLabel_6 = new JLabel(ausersgroups.get(0).getName());
		lblNewLabel_6.setBounds(108, 316, 56, 16);
		panel.add(lblNewLabel_6);
	   }
	   else if(ausersgroups.size() == 2)
	   {
		   
		   JLabel lblNewLabel_6 = new JLabel(ausersgroups.get(0).getName());
			lblNewLabel_6.setBounds(108, 316, 56, 16);
			panel.add(lblNewLabel_6);
		   
		  JLabel lblNewLabel_7 = new JLabel(ausersgroups.get(1).getName());
		lblNewLabel_7.setBounds(185, 316, 56, 16);
		panel.add(lblNewLabel_7);
	   }
	   else if(ausersgroups.size() == 3)
	   {
		   JLabel lblNewLabel_6 = new JLabel(ausersgroups.get(0).getName());
			lblNewLabel_6.setBounds(108, 316, 56, 16);
			panel.add(lblNewLabel_6);
		   
		   JLabel lblNewLabel_7 = new JLabel(ausersgroups.get(1).getName());
		lblNewLabel_7.setBounds(185, 316, 56, 16);
		panel.add(lblNewLabel_7);
		   
		JLabel lblNewLabel_8 = new JLabel(ausersgroups.get(2).getName());
		lblNewLabel_8.setBounds(253, 316, 56, 16);
		panel.add(lblNewLabel_8);
	   }
		
	
	     
		
		
		
		
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
				
				usersconnection.sendConnectionRequest();
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
				
				usersconnection.removeConnection();
				
			}
		});
		removeConnection.setBounds(694, 313, 148, 25);
		panel.add(removeConnection);
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(74, 376, 84, 16);
		panel.add(lblNewLabel_9);
		
		String telephone = auser.getTelephone();
		JLabel labeltelephone = new JLabel(telephone);
		labeltelephone.setBounds(131, 442, 78, 16);
		panel.add(labeltelephone);
		
		String address = auser.getAddress();
		JLabel labeladdress = new JLabel(address);
		labeladdress.setBounds(131, 476, 78, 16);
		panel.add(labeladdress);
		
		String birthday = auser.getBirthday();
		JLabel labelbirthday = new JLabel(birthday);
		labelbirthday.setBounds(130, 510, 79, 16);
		panel.add(labelbirthday);
		
		JLabel lblNewLabel_13 = new JLabel("Mutual connections");
		lblNewLabel_13.setBounds(712, 377, 109, 16);
		panel.add(lblNewLabel_13);
		
		JList listmutualconnections = new JList();
		listmutualconnections.setBackground(new Color(255, 250, 240));
		listmutualconnections.setBounds(709, 409, 133, 127);
		for(int i=0; i<usersconnection.mutualConnections().size(); i++)
		{
			listmutualconnections.add(listmutualconnections, usersconnection.mutualConnections() + "\n");
		}
		panel.add(listmutualconnections);
		
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
