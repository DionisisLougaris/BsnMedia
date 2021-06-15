package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import java.awt.Color;
import java.awt.Cursor;

public class BackendProfileEmployeeGUI {

	private JFrame frmStartingPage;
	private JTextField searchField;
	private JTextField textPostGroup;
	private JPanel panel, picturePanel;
	private JLabel lblNewLabel;
	private JButton searchButton, helpButton, requestsButton, messagesButton, notifsButton, editAccountButton, postButton, 
	checkprofileButton, sendMessageButton, sendRequestButton, disconnectButton;
	private JLabel emailLabel;
	private JList<String> connectionsList, suggestedList; 
	private JTextArea writePostArea;
	private JRadioButton connectionsRadio, PublicRadio;
	private static User employee;
	TreeSet<User> suggestedListConnections = new TreeSet<>();
	TreeSet<Post> allPosts = new TreeSet<>();
	ButtonGroup radioGroup;
	ArrayList<User> listOfConnections;
	
	
	
	
	
	public BackendProfileEmployeeGUI(User aUser) throws IOException {
		initialize(aUser);
	}

	
	private void initialize(User aUser) throws IOException {
		frmStartingPage = new JFrame();
		frmStartingPage.setTitle("Starting Page");
		frmStartingPage.setBounds(100, 100, 893, 1020);
		frmStartingPage.setLocation(500, 0);
		frmStartingPage.setVisible(true);
		frmStartingPage.setResizable(false);
		frmStartingPage.getContentPane().setLayout(null);
		frmStartingPage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/BSNlogo.jpg");
		frmStartingPage.setIconImage(logoimage.getImage());
		
		employee = (Employee)aUser;
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 887, 985);
		frmStartingPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		picturePanel = new JPanel();
		picturePanel.setBounds(47, 79, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
		lblNewLabel = new JLabel();
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(employee.getImage()));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(181, 152, 170);
			lblNewLabel.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(0, 0, 181, 152);
		picturePanel.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton = new JButton(search);
		searchButton.setBounds(612, 47, 55, 44);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String searchedText = searchField.getText();
				if(!searchedText.isEmpty()) {
					boolean result;
					try {
						result = employee.getMyAccount().getMyCompany().searchObject(searchedText, employee);

						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							suggestedOptions = employee.getMyAccount().getMyCompany().suggestedSearchOption(searchedText);
							new SearchSuggestionsGUI(suggestedOptions, employee);
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
		panel.add(searchButton);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setBounds(47, 244, 321, 30);
		nameLabel.setText(employee.getFirstName()+" "+employee.getLastName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel("Employee, ");
		companyPostLabel.setBounds(47, 285, 64, 16);
		panel.add(companyPostLabel);
		
		JLabel specializationLabel = new JLabel(employee.getCompanyPost());
		specializationLabel.setBounds(116, 285, 112, 16);
		panel.add(specializationLabel);
		
		emailLabel = new JLabel(employee.getMyAccount().getEmail());
		emailLabel.setBounds(47, 311, 204, 16);
		panel.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setBounds(49, 357, 133, 16);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_5);
		
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		helpButton = new JButton(help);
		helpButton.setBounds(814, 917, 56, 50);
		helpButton.setContentAreaFilled(false); 
		helpButton.setToolTipText("Do you want help? Click me.");
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmStartingPage.setVisible(false);
					new HelpGUI(employee);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(helpButton);
		
		searchField = new JTextField();
		searchField.setBounds(332, 50, 268, 30);
		searchField.setBackground(new Color(255, 250, 240));
		searchField.setColumns(10);
		panel.add(searchField);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton = new JButton(friends);
		requestsButton.setBounds(714, 27, 37, 30);
		requestsButton.setToolTipText("Watch your connection requests");
		requestsButton.setContentAreaFilled(false); 
		requestsButton.setFocusPainted(false); 
		requestsButton.setOpaque(false);
		requestsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(requestsButton);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
		messagesButton = new JButton(messages);
		messagesButton.setBounds(763, 27, 37, 30);
		messagesButton.setToolTipText("See your new messages");
		messagesButton.setContentAreaFilled(false); 
		messagesButton.setFocusPainted(false); 
		messagesButton.setOpaque(false);
		messagesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(messagesButton);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		notifsButton = new JButton(bell);
		notifsButton.setBounds(814, 27, 37, 30);
		notifsButton.setToolTipText("Watch your notofications");
		notifsButton.setContentAreaFilled(false); 
		notifsButton.setFocusPainted(false); 
		notifsButton.setOpaque(false);
		notifsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(notifsButton);
		
		editAccountButton = new JButton("Edit Account Info");
		editAccountButton.setBounds(250, 307, 149, 25);
		editAccountButton.setContentAreaFilled(false); 
		editAccountButton.setFocusPainted(false); 
		editAccountButton.setOpaque(false);
		editAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(editAccountButton);
		
		connectionsList = new JList<String>();
		connectionsList.setBounds(44, 483, 116, 152);
		DefaultListModel<String> model = new DefaultListModel<String>();
		listOfConnections = employee.getListOfConnections(); //Get all his Connections
		for (User theUser: listOfConnections) {
			model.addElement(theUser.getFirstName()+" "+theUser.getLastName()); 
		}
		connectionsList.setModel(model);
		connectionsList.setBackground(new Color(255, 250, 240));
		frmStartingPage.getContentPane().add(connectionsList);
		JScrollPane scrollPaneConnections = new JScrollPane(connectionsList);
		scrollPaneConnections.setBounds(47, 483, 113, 152);
		scrollPaneConnections.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmStartingPage.getContentPane().add(scrollPaneConnections);
		
		
		
		
		
		
		suggestedListConnections = employee.suggestedConnections(); //Get all Suggested Connections
		suggestedList = new JList<String>();
		suggestedList.setBounds(221, 483, 116, 152);
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		for (User suggestedUser: suggestedListConnections) {
			model2.addElement(suggestedUser.getFirstName()+" "+suggestedUser.getLastName());
		}
		suggestedList.setModel(model2);
		suggestedList.setBackground(new Color(255, 250, 240));
		frmStartingPage.getContentPane().add(suggestedList);
		JScrollPane scrollPaneSuggestedConnections = new JScrollPane(suggestedList);
		scrollPaneSuggestedConnections.setBounds(221, 483, 116, 152);
		scrollPaneSuggestedConnections.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmStartingPage.getContentPane().add(scrollPaneSuggestedConnections);
		
		
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + employee.getListOfConnections().size() + ")");
		lblNewLabel_9.setBounds(49, 454, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(216, 454, 139, 16);
		panel.add(lblNewLabel_9_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(427, 244, 424, 409);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("");
		for( Post post : employee.returnAllPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
			textArea.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
			textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
		}
		textArea.setBackground(new Color(255, 250, 240));
		frmStartingPage.getContentPane().add(textArea);
		JScrollPane scrollPanePost = new JScrollPane(textArea);
		scrollPanePost.setBounds(441, 256, 379, 395);
		scrollPanePost.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmStartingPage.getContentPane().add(scrollPanePost);
		
		
		
		
		
		writePostArea = new JTextArea();
		writePostArea.setBounds(427, 688, 424, 49);
		writePostArea.setLineWrap(true);
		writePostArea.setWrapStyleWord(true);
		writePostArea.setBackground(new Color(255, 250, 240));
		panel.add(writePostArea);
		
		connectionsRadio = new JRadioButton("Connections");
		connectionsRadio.setBounds(441, 746, 112, 25);
		connectionsRadio.setActionCommand("Connections");
		connectionsRadio.setOpaque(false);
		connectionsRadio.setBackground(Color.WHITE);
		panel.add(connectionsRadio);
		
		PublicRadio = new JRadioButton("Public");
		PublicRadio.setBounds(557, 746, 78, 25);
		PublicRadio.setActionCommand("Public");
		PublicRadio.setOpaque(false);
		PublicRadio.setBackground(Color.WHITE);
		panel.add(PublicRadio);
		
		JRadioButton rdbtnGroup = new JRadioButton("Group");
		rdbtnGroup.setBounds(639, 746, 78, 25);
		rdbtnGroup.setActionCommand("Group");
		rdbtnGroup.setOpaque(false);
		rdbtnGroup.setBackground(Color.WHITE);
		panel.add(rdbtnGroup);
		
		postButton = new JButton("Post");
		postButton.setBounds(754, 750, 97, 25);
		postButton.setContentAreaFilled(false); 
		postButton.setFocusPainted(false); 
		postButton.setOpaque(false);
		postButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(connectionsRadio.isSelected() || PublicRadio.isSelected()){
				        
						//Putting post on boss' and others Users' wall
							String myText = writePostArea.getText();
							Post myPost = new Post(employee,myText,radioGroup.getSelection().getActionCommand());
							employee.addPost(myPost);
							textArea.setText(""); 
						    for( Post post : employee.returnAllPosts())
							{
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						        String formatDateTime = post.getTimestamp().format(formatter);
								textArea.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
								textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
							}
							
					   }
				 else if(rdbtnGroup.isSelected())
				 {
					 	String myText = writePostArea.getText();
						Post myPost = new Post(employee,myText,radioGroup.getSelection().getActionCommand());
						employee.addPost(myPost);
						textArea.setText(""); 
					    for( Post post : employee.returnAllPosts())
						{
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					        String formatDateTime = post.getTimestamp().format(formatter);
							textArea.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
							textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
						}
					 String groupToPost=textPostGroup.getText();
					 boolean found=false;
					 for(int i=0;i<employee.getGroups().size();i++)
					 {
						 if(employee.getGroups().get(i).getName().equals(groupToPost))
						 {
							 found=true;
							 employee.getGroups().get(i).addPostToGroupList(myPost);
							 String message = "You successfully posted on "+employee.getGroups().get(i).getName()+"'s wall!";
								JOptionPane.showMessageDialog(new JFrame(), message, "Message",
								  JOptionPane.INFORMATION_MESSAGE);
						 }
					 }
					 if(found==false)
					 {
						 String message = "Group not found...Please check your spelling!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							  JOptionPane.ERROR_MESSAGE);
					 }
				 }
				else
				{
					String message = "Select Post scope before posting!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					  JOptionPane.ERROR_MESSAGE);
				}
				 textArea.setBackground(new Color(255, 250, 240));
				 textArea.setBounds(427, 213, 424, 409);	
			}
		});
		panel.add(postButton);
		
		// create button group for the radio button to know which one was selected
		radioGroup = new ButtonGroup();
	    radioGroup.add(connectionsRadio);
		radioGroup.add(PublicRadio);
		radioGroup.add(rdbtnGroup);
		
		textPostGroup = new JTextField();
		textPostGroup.setBounds(639, 780, 64, 25);
		textPostGroup.setBackground(new Color(255, 250, 240));
		textPostGroup.setToolTipText("Compete the name of group that you want to post");
		textPostGroup.setColumns(10);
		panel.add(textPostGroup);
		
		checkprofileButton = new JButton("Check profile");
		checkprofileButton.setBounds(44, 648, 116, 25);
		checkprofileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkprofileButton.setContentAreaFilled(false); 
		checkprofileButton.setFocusPainted(false); 
		checkprofileButton.setOpaque(false);
		checkprofileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(checkprofileButton);
		
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.setBounds(44, 686, 116, 25);
		sendMessageButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(sendMessageButton);
		
		sendRequestButton = new JButton("Send request");
		sendRequestButton.setBounds(221, 648, 116, 25);
		sendRequestButton.setContentAreaFilled(false); 
		sendRequestButton.setFocusPainted(false); 
		sendRequestButton.setOpaque(false);
		sendRequestButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(sendRequestButton);
		
		JButton btnNewButton = new JButton("Group A");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(47, 384, 80, 23);
		if (employee.getGroups().size()>=1) {
			
			panel.add(btnNewButton);
			
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						new GroupProfileGUI(employee, employee.getGroups().get(0));
						frmStartingPage.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		JButton btnGroupB = new JButton("Group B");
		btnGroupB.setForeground(new Color(255, 0, 0));
		btnGroupB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGroupB.setBackground(new Color(255, 153, 102));
		btnGroupB.setBorder(null);
		btnGroupB.setBounds(135, 384, 80, 23);
		if (employee.getGroups().size()>=2) {
			
			panel.add(btnGroupB);
			
			btnGroupB.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						new GroupProfileGUI(employee, employee.getGroups().get(1));
						frmStartingPage.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		JButton btnGroupC = new JButton("Group C");
		btnGroupC.setForeground(new Color(255, 0, 0));
		btnGroupC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGroupC.setBackground(new Color(255, 153, 102));
		btnGroupC.setBorder(null);
		btnGroupC.setBounds(223, 384, 80, 23);
		if (employee.getGroups().size()==3) {
			
			panel.add(btnGroupC);
			
			btnGroupC.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						new GroupProfileGUI(employee, employee.getGroups().get(2));
						frmStartingPage.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_50px.png");
		disconnectButton = new JButton(logout);
		disconnectButton.setBounds(796, 169, 55, 54);
		disconnectButton.setContentAreaFilled(false);
		disconnectButton.setToolTipText("logout");
		disconnectButton.setFocusPainted(false); 
		disconnectButton.setOpaque(false);
		disconnectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Storage.saveInBinaryFile(employee.getMyAccount().getMyCompany());
				frmStartingPage.dispose();
				try {
					new WelcomeScreen_GUI(employee.getMyAccount().getMyCompany());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(disconnectButton);

	
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 887, 991);
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel_2.setIcon(new ImageIcon(imagerisizeb));
		panel.add(lblNewLabel_2);
		
		
		
		
		
		
		
		
		
		ButtonListener listener = new ButtonListener();
		requestsButton.addActionListener(listener);
		messagesButton.addActionListener(listener);
		notifsButton.addActionListener(listener);
		editAccountButton.addActionListener(listener);
		disconnectButton.addActionListener(listener);
		checkprofileButton.addActionListener(listener);
		sendMessageButton.addActionListener(listener);
		sendRequestButton.addActionListener(listener);
		postButton.addActionListener(listener);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(requestsButton)) {
				try {
					new ConnectionRequestsGUI(employee);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(messagesButton)) {
				try {
					new NewMessagesGUI(employee);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(notifsButton)) {
				try {
					new NotificationsGUI(employee,frmStartingPage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(editAccountButton)) {
				
				new EditAccountGUI(employee, frmStartingPage);
			}else if(e.getSource().equals(checkprofileButton)) {
				
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
						new FrontEndProfileGUI(employee, selectedUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmStartingPage.setVisible(false);
				}
			}
			else if (e.getSource().equals(sendMessageButton)) {
				
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
					ArrayList<Conversation> listOfConversation = employee.getListOfConversations();
					Conversation selectedUserToChat = null;
					
					for (Conversation theConversation: listOfConversation) {
						
						if ((((privateConversation)theConversation).getDiscussant1().equals(employee) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
							(((privateConversation)theConversation).getDiscussant2().equals(employee) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
							
							selectedUserToChat = theConversation;
							break;
						}
					}
					
					if(selectedUserToChat == null) {
						 String message = "Something went Wrong!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.INFORMATION_MESSAGE);
					}else {
						new PrivateChatGUI(selectedUser, employee, selectedUserToChat);
					}
				}
			}
			else if(e.getSource().equals(sendRequestButton)) {
				
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
					Connection possibleConnection = new Connection(employee, selectedUser);
					possibleConnection.sendConnectionRequest();
				}
				
			}
		}
	}
}
