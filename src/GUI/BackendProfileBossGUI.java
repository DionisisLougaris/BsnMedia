package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.*;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

public class BackendProfileBossGUI {

	private JFrame frmStartingPage;
	private JTextField textField;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JRadioButton connectionsRadio,PublicRadio;
	private JList<String> connectionsList;
	private JList<String> suggestedList;
	private Boss boss;
	private TreeSet<User> suggestedListConnections = new TreeSet<User>();
	private JPanel panel,picturePanel;
	private JButton searchButton,helpButton,requestsButton,messagesButton,notifsButton,editAccountButton,
	postButton,checkprofileButton,sendMessageButton,sendRequestButton,disconnectButton,editCompanyInfoButton;
	
	private ArrayList<User> listOfConnections;
	private JLabel lblNewLabel;

	public BackendProfileBossGUI(User theBoss) throws IOException{
		boss = (Boss)theBoss;
		initialize();
	}


	private void initialize() throws IOException{
		frmStartingPage = new JFrame();
		frmStartingPage.setTitle("Starting Page");
		frmStartingPage.setBounds(100, 100, 893, 1020);
		frmStartingPage.setLocation(500, 0);
		frmStartingPage.getContentPane().setLayout(null);
		frmStartingPage.setResizable(false);
		frmStartingPage.setVisible(true);
		
	    panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 887, 991);
		frmStartingPage.getContentPane().add(panel);
		panel.setLayout(null);
		
	    picturePanel = new JPanel();
		picturePanel.setBounds(54, 56, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel();
		BufferedImage imageicon2;
		try {
			imageicon2 = ImageIO.read(new File(boss.getImage()));
			ImageIcon image2 = new ImageIcon(imageicon2);
			Image imagerisize2 = image2.getImage().getScaledInstance(181, 152, 170);
			lblNewLabel_5.setIcon(new ImageIcon(imagerisize2));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel_5.setBounds(0, 0, 181, 152);
		picturePanel.add(lblNewLabel_5);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton = new JButton(search);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = textField.getText();
				if(!text.isEmpty()) {
					boolean result;
					try {
						result = boss.getMyAccount().getMyCompany().searchObject(text, boss);

						if (!result) {
							ArrayList<String> suggestedOptions = boss.getMyAccount().getMyCompany().suggestedSearchOption(text);
							new SearchSuggestionsGUI(suggestedOptions, boss);
						}else {
							frmStartingPage.setVisible(false);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		searchButton.setBounds(623, 27, 46, 44);
		panel.add(searchButton);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("");
		for( Post post : boss.returnAllPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
			textArea.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
			textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
		}
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(427, 213, 424, 409);
		panel.add(textArea);
		
		JLabel nameLabel = new JLabel(boss.getFirstName()+" "+boss.getLastName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(44, 243, 293, 30);
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel(" Head of company ");
		companyPostLabel.setBounds(54, 271, 116, 16);
		panel.add(companyPostLabel);
		
		JLabel emailLabel = new JLabel(boss.getMyAccount().getEmail());
		emailLabel.setBounds(54, 298, 206, 16);
		panel.add(emailLabel);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		helpButton = new JButton(help);
		helpButton.setContentAreaFilled(false); 
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					frmStartingPage.setVisible(false);
					new HelpGUI(boss);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		helpButton.setBounds(814, 922, 63, 58);
		panel.add(helpButton);

		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton = new JButton(friends);
		requestsButton.setContentAreaFilled(false); 
		requestsButton.setFocusPainted(false); 
		requestsButton.setOpaque(false);
		requestsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		requestsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ConnectionRequestsGUI(boss);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		requestsButton.setBounds(714, 27, 37, 30);
		panel.add(requestsButton);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
	    messagesButton = new JButton(messages);
	    messagesButton.setContentAreaFilled(false); 
	    messagesButton.setFocusPainted(false); 
	    messagesButton.setOpaque(false);
	    messagesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    messagesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					new NewMessagesGUI(boss);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    messagesButton.setBounds(763, 27, 37, 30);
		panel.add(messagesButton);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		notifsButton = new JButton(bell);
		notifsButton.setContentAreaFilled(false); 
		notifsButton.setFocusPainted(false); 
		notifsButton.setOpaque(false);
		notifsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		notifsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					new NotificationsGUI(boss);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		notifsButton.setBounds(814, 27, 37, 30);
		panel.add(notifsButton);
		
		editAccountButton = new JButton("Edit Account Info");
		editAccountButton.setContentAreaFilled(false); 
		editAccountButton.setFocusPainted(false); 
		editAccountButton.setOpaque(false);
		editAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EditAccountGUI((Boss)boss, frmStartingPage);
			}
		});
		editAccountButton.setBounds(44, 332, 155, 25);
		panel.add(editAccountButton);
		
		connectionsList = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listOfConnections = boss.getListOfConnections(); //Get all his Connections
		for (User theUser: listOfConnections) {
			model.addElement(theUser.getFirstName()+" "+theUser.getLastName()); 
		}
		connectionsList.setModel(model);
		connectionsList.setBackground(new Color(255, 250, 240));
		connectionsList.setBounds(44, 467, 116, 169);
		panel.add(connectionsList);
		
		suggestedList = new JList<String>();
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		suggestedListConnections = boss.suggestedConnections(); //Get all Suggested Connections
		for (User suggestedUser: suggestedListConnections) {
			model2.addElement(suggestedUser.getFirstName()+" "+suggestedUser.getLastName());
		}
		suggestedList.setModel(model2);
		suggestedList.setBackground(new Color(255, 250, 240));
		suggestedList.setBounds(221, 467, 116, 169);
		panel.add(suggestedList);
		
		JLabel lblNewLabel_9 = new JLabel("Connections: ("+boss.getListOfConnections().size()+")");
		lblNewLabel_9.setBounds(49, 438, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(221, 438, 150, 16);
		panel.add(lblNewLabel_9_1);
		
		JTextArea writePostArea = new JTextArea();
		writePostArea.setLineWrap(true);
		writePostArea.setWrapStyleWord(true);
		writePostArea.setBackground(new Color(255, 250, 240));
		writePostArea.setBounds(427, 651, 424, 49);
		panel.add(writePostArea);
		
		connectionsRadio= new JRadioButton("Connections");
		connectionsRadio.setActionCommand("Connections");
		connectionsRadio.setBackground(Color.WHITE);
		connectionsRadio.setOpaque(false);
		connectionsRadio.setBounds(503, 717, 112, 25);
		panel.add(connectionsRadio);
		
	    PublicRadio = new JRadioButton("Public");
	    PublicRadio.setActionCommand("Public");
		PublicRadio.setBackground(Color.WHITE);
		PublicRadio.setOpaque(false);
		PublicRadio.setBounds(637, 717, 78, 25);
		panel.add(PublicRadio);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(connectionsRadio);
		radioGroup.add(PublicRadio);
		
		postButton= new JButton("Post");
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   if(connectionsRadio.isSelected() || PublicRadio.isSelected() ){
			        
					//Putting post on boss' and others Users' wall
					//Prepei na ginei elegxos , an den exei epilexthei kapoio radio button na bgazei minima lathous sto pathma tou post
						String myText = writePostArea.getText();
						Post myPost = new Post(boss,myText,radioGroup.getSelection().getActionCommand());
						boss.addPost(myPost);
						textArea.setText(""); 
					    for( Post post : boss.returnAllPosts())
						{
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					        String formatDateTime = post.getTimestamp().format(formatter);
							textArea.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
							textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
						}
						textArea.setBackground(new Color(255, 250, 240));
						textArea.setBounds(427, 213, 424, 409);	
				   }
				   else
				   {
					   String message = "Select Post scope before posting!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
				   }

	
			}
		});
		postButton.setContentAreaFilled(false); 
		postButton.setFocusPainted(false); 
		postButton.setOpaque(false);
		postButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		postButton.setBounds(752, 717, 97, 25);
		panel.add(postButton);
		
		checkprofileButton = new JButton("Check profile");
		checkprofileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkprofileButton.setContentAreaFilled(false); 
		checkprofileButton.setFocusPainted(false); 
		checkprofileButton.setOpaque(false);
		checkprofileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkprofileButton.setBounds(44, 649, 116, 25);
		panel.add(checkprofileButton);
		
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendMessageButton.setBounds(44, 675, 116, 25);
		panel.add(sendMessageButton);
		
		sendRequestButton = new JButton("Send request");
		sendRequestButton.setContentAreaFilled(false); 
		sendRequestButton.setFocusPainted(false); 
		sendRequestButton.setOpaque(false);
		sendRequestButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendRequestButton.setBounds(221, 649, 116, 25);
		panel.add(sendRequestButton);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_50px.png");
		disconnectButton = new JButton(logout);
		disconnectButton.setContentAreaFilled(false); 
		disconnectButton.setFocusPainted(false); 
		disconnectButton.setOpaque(false);
		disconnectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmStartingPage.setVisible(false);
				try {
					new WelcomeScreen_GUI(boss.getMyAccount().getMyCompany());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		disconnectButton.setBounds(793, 110, 56, 56);
		panel.add(disconnectButton);
		
		editCompanyInfoButton= new JButton("Edit Company Info");
		editCompanyInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EditCompanyGUI((Boss)boss);
			}
		});
		editCompanyInfoButton.setContentAreaFilled(false); 
		editCompanyInfoButton.setFocusPainted(false); 
		editCompanyInfoButton.setOpaque(false);
		editCompanyInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editCompanyInfoButton.setBounds(216, 332, 155, 25);
		panel.add(editCompanyInfoButton);

		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setColumns(10);
		textField.setBounds(332, 36, 279, 30);
		panel.add(textField);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel_2.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel_2.setBounds(0, 0, 887, 991);
		panel.add(lblNewLabel_2);
		ButtonListener listener = new ButtonListener();
		checkprofileButton.addActionListener(listener);
		sendMessageButton.addActionListener(listener);
		sendRequestButton.addActionListener(listener);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(checkprofileButton)) {
				
				String selectedUserString = connectionsList.getSelectedValue();
				User selectedUser = null;
				
				for(User theUser: listOfConnections) {
					String userFullName = theUser.getFirstName()+" "+theUser.getLastName();
					
					if (userFullName.equalsIgnoreCase(selectedUserString)) {
						selectedUser = theUser;
						break;
					}
				}
				
				if (selectedUser == null) {
					 String message = "You have not selected any user!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}else {
					try {
						new FrontEndProfileGUI(boss, selectedUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmStartingPage.setVisible(false);
				}
			}else if (e.getSource().equals(sendMessageButton)) {
				
				String selectedUserString = connectionsList.getSelectedValue();
				User selectedUser = null;
				
				for(User theUser: listOfConnections) {
					String userFullName = theUser.getFirstName()+" "+theUser.getLastName();
					
					if (userFullName.equalsIgnoreCase(selectedUserString)) {
						selectedUser = theUser;
						break;
					}
				}
				
				if (selectedUser == null) {
					 String message = "You have not selected any user!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}else {
					ArrayList<Conversation> listOfConversation = boss.getListOfConversations();
					Conversation selectedUserToChat = null;
					
					for (Conversation theConversation: listOfConversation) {
						
						if ((((privateConversation)theConversation).getDiscussant1().equals(boss) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
							(((privateConversation)theConversation).getDiscussant2().equals(boss) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
							
							selectedUserToChat = theConversation;
							break;
						}
					}
					
					if(selectedUserToChat == null) {
						 String message = "Something went Wrong!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.INFORMATION_MESSAGE);
					}else {
						new PrivateChatGUI(boss, selectedUser, selectedUserToChat);
					}
				}
			}else if (e.getSource().equals(sendRequestButton)) {
				
				String selectedUserString = suggestedList.getSelectedValue();
				User selectedUser = null;
				
				for(User suggestedUser: suggestedListConnections) {
					String usersFullName = suggestedUser.getFirstName()+" "+suggestedUser.getLastName();
					
					if (usersFullName.equalsIgnoreCase(selectedUserString)) {
						selectedUser = suggestedUser;
						break;
					}
				}
				
				if (selectedUser == null) {
					 String message = "You have not selected any user!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}else {
					Connection possibleConnection = new Connection(boss, selectedUser);
					possibleConnection.sendConnectionRequest();
				}
			}
		}
	}
	
}
