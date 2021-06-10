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
import entities.Post;
import entities.User;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Color;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField searchtext;
	private static User tuser;
	private static User auser;

	public FrontEndProfileGUI(User tUser,User aUser) throws IOException {
		initialize(tUser, aUser);
	}

	private void initialize(User tUser, User aUser) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		tuser = tUser; //The user who is connected
		auser = aUser; //The other User
		
		
		Connection usersconnection = new Connection(tuser,auser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 887, 985);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(108, 75, 183, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon defaultprofilephoto = new ImageIcon(auser.getImage());
		Image imagerisize = defaultprofilephoto.getImage().getScaledInstance(181, 152, 170) ;
		ImageIcon ndefaultprofilephoto = new ImageIcon(imagerisize);
		JLabel labeldefaulprofilephoto = new JLabel(ndefaultprofilephoto);
		labeldefaulprofilephoto.setBounds(0, 0, 183, 152);
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
				
				String searchedText = searchtext.getText();
				if(!searchedText.isEmpty()) {
					boolean result;
					try {
						result = tuser.getMyAccount().getMyCompany().searchObject(searchedText, tuser);

						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							new SearchSuggestionsGUI(suggestedOptions, tuser);
						}else {
							frame.setVisible(false);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		searchbutton.setBounds(766, 27, 55, 44);
		panel.add(searchbutton);
		
		
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File("Buttons_backgrounds/BSN-logo-white.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon image = new ImageIcon(buttonIcon);
		Image imagerisizel = image.getImage().getScaledInstance(80, 45, 60) ;
		ImageIcon imagebutton = new ImageIcon(imagerisizel);
	    JButton buttongotomyprofile = new JButton(imagebutton);
	    buttongotomyprofile.setBorderPainted(false);
	    buttongotomyprofile.setFocusPainted(false);
	    buttongotomyprofile.setContentAreaFilled(false);
		buttongotomyprofile.setContentAreaFilled(false); 
		buttongotomyprofile.setFocusPainted(false); 
		buttongotomyprofile.setToolTipText("Go back to your Profile");
		buttongotomyprofile.setOpaque(false);
		buttongotomyprofile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttongotomyprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(tuser instanceof Chief){
					try {
						new BackendProfileChiefGUI(tuser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(tuser instanceof Boss){
					try {
						new BackendProfileBossGUI(tuser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(tuser instanceof Employee){
					try {
						new BackendProfileEmployeeGUI(tuser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		buttongotomyprofile.setBounds(12, 13, 84, 69);
		panel.add(buttongotomyprofile);
		
		JTextArea ausersposts = new JTextArea();
		ausersposts.setEditable(false);
		ausersposts.setLineWrap(true);
		ausersposts.setBackground(new Color(255, 250, 240));
		ausersposts.setBounds(32, 561, 810, 336);
	    for(Post post : auser.getListOfPosts())
		{
			  ausersposts.append(post.getContent());
		}
		panel.add(ausersposts);
		
		String namelastname = auser.getFirstName() + " " + auser.getLastName();
		JLabel labelnamelastname= new JLabel(namelastname);
		labelnamelastname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelnamelastname.setBounds(108, 240, 202, 26);
		panel.add(labelnamelastname);
		
		String currentlypost ="";
		if(auser instanceof Employee)
		{
			currentlypost = "Employee";
		}
		else if(auser instanceof Chief)
		{
			currentlypost = "Chief";
		}
		else if(auser instanceof Boss)
		{
			currentlypost = "Boss";
		}
		JLabel labelcompanypost = new JLabel(currentlypost);
		labelcompanypost.setBounds(108, 266, 89, 16);
		panel.add(labelcompanypost);
		
		String spacialization = auser.getCompanyPost();
		JLabel labelspacialization = new JLabel(spacialization);
		labelspacialization.setBounds(322, 248, 78, 16);
		panel.add(labelspacialization);
		
		String email = auser.getMyAccount().getEmail();
		JLabel labelemail = new JLabel(email);
        labelemail.setBounds(130, 413, 194, 16);
		panel.add(labelemail);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 287, 133, 16);
		panel.add(lblNewLabel_5);
		if(auser instanceof Boss) {
			lblNewLabel_5.setVisible(false);
		}
		
		ArrayList<Group> ausersgroups = auser.getGroups();
		
		if(ausersgroups!=null) {
			if( ausersgroups.size() ==1) {
				JLabel lblNewLabel_6 = new JLabel(ausersgroups.get(0).getName());
				lblNewLabel_6.setBounds(108, 316, 56, 16);
				panel.add(lblNewLabel_6);
			} else if(ausersgroups.size() == 2) { 
				JLabel lblNewLabel_6 = new JLabel(ausersgroups.get(0).getName());
				lblNewLabel_6.setBounds(108, 316, 56, 16);
				panel.add(lblNewLabel_6);
				   
				JLabel lblNewLabel_7 = new JLabel(ausersgroups.get(1).getName());
				lblNewLabel_7.setBounds(185, 316, 56, 16);
				panel.add(lblNewLabel_7);
			} else if(ausersgroups.size() == 3) {
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
		}
		
		
		if(!tuser.equals(auser))
		{
			JButton buttonchat= new JButton("Chat");
			buttonchat.setContentAreaFilled(false); 
			buttonchat.setFocusPainted(false); 
			buttonchat.setOpaque(false);
			buttonchat.setCursor(new Cursor(Cursor.HAND_CURSOR));
			buttonchat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					new PrivateChatGUI(auser, tuser, usersconnection.getAboutThisConversation());// prepei na baloume twn xhrhsrh
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
		}
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(74, 376, 84, 16);
		panel.add(lblNewLabel_9);
		
		String telephone = auser.getTelephone();
		JLabel labeltelephone = new JLabel(telephone);
		labeltelephone.setBounds(131, 442, 110, 16);
		panel.add(labeltelephone);
		
		String address = auser.getAddress();
		JLabel labeladdress = new JLabel(address);
		labeladdress.setBounds(131, 476, 110, 16);
		panel.add(labeladdress);
		
		String birthday = auser.getBirthday();
		JLabel labelbirthday = new JLabel(birthday);
		labelbirthday.setBounds(130, 510, 123, 16);
		panel.add(labelbirthday);
		
		JLabel lblNewLabel_13 = new JLabel("Mutual connections");
		lblNewLabel_13.setBounds(712, 377, 130, 16);
		panel.add(lblNewLabel_13);
		
		DefaultListModel<String> mutualmodel = new DefaultListModel<String>();
		JList<String> listmutualconnections = new JList<String>();
		listmutualconnections.setBackground(new Color(255, 250, 240));
		listmutualconnections.setBounds(709, 409, 133, 127);
		for (User theUser: usersconnection.mutualConnections()) {
			mutualmodel.addElement(theUser.getFirstName()+" "+theUser.getLastName());
		}
		listmutualconnections.setModel(mutualmodel);
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
				
				try {
					frame.setVisible(false);
					new HelpGUI(tuser);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JLabel lblNewLabel = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel.setBounds(0, 0, 887, 985);
		panel.add(lblNewLabel);
		
		frame.setResizable(false);
		frame.setTitle(auser.getMyAccount().getUsername());
	}
}
