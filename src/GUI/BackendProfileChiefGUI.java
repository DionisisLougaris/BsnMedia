package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUI.BackendProfileEmployeeGUI.ButtonListener;
import entities.*;
import java.awt.Color;

public class BackendProfileChiefGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField searchField;
	private static Chief chief;
	private JPanel panel, picturePanel;
	private JLabel lblNewLabel;
	private JButton searchButton, helpButton, requestsButton, messagesButton, notifsButton, editAccountButton,createProjectButton, editGroupAButton, editGroupBButton, editGroupCButton , postButton, checkprofileButton, sendMessageButton, sendRequestButton, disconnectButton;
	private JLabel emailLabel;
	private JLabel groupALabel, groupBLabel, groupCLabel;
	private JRadioButton connectionsRadio, PublicRadio, GroupARadio, GroupBRadio, GroupCRadio;
	private JTextArea writePostArea, postArea;
	private JList<String> connectionsList, suggestedList, postList;
	ArrayList<User> listOfConnections;
	TreeSet<User> suggestedListConnections = new TreeSet<>();
	ButtonGroup radioGroup;
	private JLabel lblNewLabel_1;
	TreeSet<Post> allPosts = new TreeSet<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackendProfileChiefGUI window = new BackendProfileChiefGUI(chief);
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
	public BackendProfileChiefGUI(User theChief) {
		chief = (Chief) theChief;
		initialize();
		ButtonListener listener = new ButtonListener();
		requestsButton.addActionListener(listener);
		messagesButton.addActionListener(listener);
		notifsButton.addActionListener(listener);
		editAccountButton.addActionListener(listener);
		helpButton.addActionListener(listener);
		disconnectButton.addActionListener(listener);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
	    panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		picturePanel = new JPanel();
		picturePanel.setBounds(49, 76, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
	    lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		picturePanel.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton= new JButton(search);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		searchButton.setBounds(612, 38, 55, 44);
		panel.add(searchButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(427, 225, 424, 409);
		panel.add(textArea);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText(chief.getFirstName()+" "+chief.getLastName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(49, 254, 137, 30);
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel("Chief, ");
		companyPostLabel.setBounds(193, 264, 89, 16);
		panel.add(companyPostLabel);
		
		JLabel specializationLabel = new JLabel("Specialization");
		specializationLabel.setBounds(282, 264, 89, 16);
		panel.add(specializationLabel);
		
		emailLabel = new JLabel(chief.getMyAccount().getEmail());
		emailLabel.setBounds(52, 297, 125, 16);
		panel.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Currently supervising:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(44, 351, 133, 16);
		panel.add(lblNewLabel_5);
		
		// na balw ta buttoms//
		
		String name;
		if(chief.getGroups().size()>0) {
			name = chief.getGroups().get(0).getName();
			
			GroupARadio = new JRadioButton(name);
			GroupARadio.setBounds(625, 675, 126, 25);
			panel.add(GroupARadio);
		}
		else {
			name = "";
		}
		groupALabel = new JLabel(name);
		groupALabel.setBounds(49, 386, 56, 16);
		panel.add(groupALabel);
		
		if(chief.getGroups().size()>1) {
			name = chief.getGroups().get(1).getName();
			
			GroupBRadio = new JRadioButton(name);
			GroupBRadio.setBounds(625, 709, 126, 25);
			panel.add(GroupBRadio);
		}
		else {
			name = "";
		}
		groupBLabel = new JLabel(name);
		groupBLabel.setBounds(104, 386, 56, 16);
		panel.add(groupBLabel);
		
		if(chief.getGroups().size()>2) {
			name = chief.getGroups().get(2).getName();
			
			GroupCRadio = new JRadioButton(name);
			GroupCRadio.setBounds(625, 739, 127, 25);
			panel.add(GroupCRadio);
		}
		else {
			name = "";
		}
		groupCLabel = new JLabel(name);
		groupCLabel.setBounds(172, 386, 56, 16);
		panel.add(groupCLabel);
		
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		helpButton = new JButton(help);
		helpButton.setContentAreaFilled(false); 
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		helpButton.setBounds(824, 929, 46, 38);
		panel.add(helpButton);
		
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 250, 240));
		searchField.setColumns(10);
		searchField.setBounds(324, 42, 275, 30);
		panel.add(searchField);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton= new JButton(friends);
		requestsButton.setContentAreaFilled(false); 
		requestsButton.setFocusPainted(false); 
		requestsButton.setOpaque(false);
		requestsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		requestsButton.setBounds(714, 27, 37, 30);
		panel.add(requestsButton);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
		messagesButton = new JButton(messages);
		messagesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		messagesButton.setContentAreaFilled(false); 
		messagesButton.setFocusPainted(false); 
		messagesButton.setOpaque(false);
		messagesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		messagesButton.setBounds(763, 27, 37, 30);
		panel.add(messagesButton);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		notifsButton = new JButton(bell);
		notifsButton.setContentAreaFilled(false); 
		notifsButton.setFocusPainted(false); 
		notifsButton.setOpaque(false);
		notifsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		notifsButton.setBounds(814, 27, 37, 30);
		panel.add(notifsButton);
		
		editAccountButton = new JButton("Edit Account Info");
		editAccountButton.setContentAreaFilled(false); 
		editAccountButton.setFocusPainted(false); 
		editAccountButton.setOpaque(false);
		editAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editAccountButton.setBounds(216, 293, 155, 25);
		panel.add(editAccountButton);
		
		
		
		connectionsList = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listOfConnections = chief.getListOfConnections(); //Get all his Connections
		for (User theUser: listOfConnections) {
			model.addElement(theUser.getFirstName()+" "+theUser.getLastName()); 
		}
		connectionsList.setModel(model);
		connectionsList.setBackground(new Color(255, 250, 240));
		connectionsList.setBounds(44, 483, 116, 152);
		panel.add(connectionsList);
		
		suggestedListConnections = chief.suggestedConnections(); //Get all Suggested Connections
		suggestedList = new JList<String>();
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		for (User suggestedUser: suggestedListConnections) {
			model2.addElement(suggestedUser.getFirstName()+" "+suggestedUser.getLastName());
		}
		suggestedList.setModel(model2);
		suggestedList.setBackground(new Color(255, 250, 240));
		suggestedList.setBounds(221, 483, 116, 152);
		panel.add(suggestedList);
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + chief.getListOfConnections().size() + ")");
		lblNewLabel_9.setBounds(49, 454, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(216, 454, 139, 16);
		panel.add(lblNewLabel_9_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(830, 254, 21, 411);
		panel.add(scrollBar);
		
		writePostArea = new JTextArea();
		writePostArea.setBackground(new Color(255, 250, 240));
		writePostArea.setBounds(427, 688, 424, 49);
		panel.add(writePostArea);
		
		connectionsRadio = new JRadioButton("Connections");
		connectionsRadio.setBackground(Color.WHITE);
		connectionsRadio.setBounds(441, 746, 112, 25);
		panel.add(connectionsRadio);
		
		PublicRadio = new JRadioButton("Public");
		PublicRadio.setBackground(Color.WHITE);
		PublicRadio.setBounds(557, 746, 78, 25);
		panel.add(PublicRadio);
		
		postButton = new JButton("Post");
		postButton.setContentAreaFilled(false); 
		postButton.setFocusPainted(false); 
		postButton.setOpaque(false);
		postButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		postButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		postButton.setBounds(754, 750, 97, 25);
		panel.add(postButton);
		
		// create button group for the radio button to know which one was selected
		radioGroup = new ButtonGroup();
		radioGroup.add(connectionsRadio);
		radioGroup.add(PublicRadio);
		radioGroup.add(GroupARadio);
		radioGroup.add(GroupBRadio);
		radioGroup.add(GroupCRadio);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setColumns(10);
		textField.setBounds(639, 780, 64, 25);
		panel.add(textField);
		
		checkprofileButton = new JButton("Check profile");
		checkprofileButton.setContentAreaFilled(false); 
		checkprofileButton.setFocusPainted(false); 
		checkprofileButton.setOpaque(false);
		checkprofileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkprofileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkprofileButton.setBounds(44, 648, 116, 25);
		panel.add(checkprofileButton);
		
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sendMessageButton.setBounds(44, 686, 116, 25);
		panel.add(sendMessageButton);
		
		sendRequestButton = new JButton("Send request");
		sendRequestButton.setContentAreaFilled(false); 
		sendRequestButton.setFocusPainted(false); 
		sendRequestButton.setOpaque(false);
		sendRequestButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sendRequestButton.setBounds(221, 648, 116, 25);
		panel.add(sendRequestButton);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_50px.png");
		disconnectButton = new JButton(logout);
		disconnectButton.setContentAreaFilled(false); 
		disconnectButton.setFocusPainted(false); 
		disconnectButton.setOpaque(false);
		disconnectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		disconnectButton.setBounds(796, 169, 55, 54);
		panel.add(disconnectButton);
		
	 createProjectButton = new JButton("Create Project");
	
		createProjectButton.setContentAreaFilled(false); 
		createProjectButton.setFocusPainted(false); 
		createProjectButton.setOpaque(false);
		createProjectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			createProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createProjectButton.setBounds(216, 332, 155, 25);
		panel.add(createProjectButton);
		
		Icon edit = new ImageIcon("Buttons_backgrounds/edit_20px.png");
		editGroupAButton = new JButton(edit);
		editGroupAButton.setContentAreaFilled(false); 
		editGroupAButton.setFocusPainted(false); 
		editGroupAButton.setOpaque(false);
		editGroupAButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editGroupAButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editGroupAButton.setBounds(58, 409, 27, 25);
		panel.add(editGroupAButton);
		
		editGroupBButton = new JButton(edit);
		editGroupBButton.setContentAreaFilled(false); 
		editGroupBButton.setFocusPainted(false); 
		editGroupBButton.setOpaque(false);
		editGroupBButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editGroupBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editGroupBButton.setBounds(121, 409, 27, 25);
		panel.add(editGroupBButton);
		
		editGroupCButton = new JButton(edit);
		editGroupCButton.setContentAreaFilled(false); 
		editGroupCButton.setFocusPainted(false); 
		editGroupCButton.setOpaque(false);
		editGroupCButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editGroupCButton.setBounds(183, 409, 27, 25);
		panel.add(editGroupCButton);
		
		lblNewLabel_1 = new JLabel("logo");
		lblNewLabel_1.setBounds(12, 917, 56, 43);
		panel.add(lblNewLabel_1);

		postArea = new JTextArea();
		postArea.setBackground(new Color(255, 250, 240));
		postArea.setBounds(427, 256, 424, 409);
		allPosts = chief.returnAllPosts();
		// not finished
		for(int i = 0; i < allPosts.size(); i++) {
			
		}
		panel.add(postArea);
		
		JRadioButton rdbtnGroup = new JRadioButton("Group");
		rdbtnGroup.setBackground(Color.WHITE);
		rdbtnGroup.setBounds(639, 746, 78, 25);
		panel.add(rdbtnGroup);
	}
	
	public void disconnectUser() throws IOException {
		frame.dispose();
		new WelcomeScreen_GUI(null); // null?
	}
	
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(requestsButton)) {
				try {
					new ConnectionRequestsGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(messagesButton)) {
				try {
					new NewMessagesGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(notifsButton)) {
				try {
					new NotificationsGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(editAccountButton)) {
				new EditAccountGUI();
			}
			else if(e.getSource().equals(helpButton)) {
				try {
					new HelpGUI(chief);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(disconnectButton)) {
				try {
					disconnectUser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(checkprofileButton)) {
				
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
					new FrontEndProfileGUI(chief, selectedUser);
				}
			}
			else if(e.getSource().equals(sendMessageButton)) {
				
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
					TreeSet<Conversation> listOfConversation = chief.getListOfConversations();
					Conversation selectedUserToChat = null;
					
					for (Conversation theConversation: listOfConversation) {
						
						if ((((privateConversation)theConversation).getDiscussant1().equals(chief) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
							(((privateConversation)theConversation).getDiscussant2().equals(chief) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
							
							selectedUserToChat = theConversation;
							break;
						}
					}
					
					if(selectedUserToChat == null) {
						 String message = "Something went Wrong!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.INFORMATION_MESSAGE);
					}else {
						new PrivateChatGUI(chief, selectedUser, selectedUserToChat);
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
					Connection possibleConnection = new Connection(chief, selectedUser);
					possibleConnection.sendConnectionRequest();
				}
				
			}
			// not finished
			else if(e.getSource().equals(postButton)) {
				String postText = writePostArea.getText();
				if(connectionsRadio.isSelected() || PublicRadio.isSelected() || GroupARadio.isSelected() || GroupBRadio.isSelected() || GroupCRadio.isSelected()) {
					String selected = radioGroup.getSelection().toString();
					Post newPost = new Post(chief, postText, selected);
					chief.addPost(newPost);
					postList.remove(postList); 
					
				}
				
				
			}
			
		}
		
		
		
	}
}
