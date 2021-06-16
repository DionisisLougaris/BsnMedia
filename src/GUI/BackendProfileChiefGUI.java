package GUI;

import java.awt.Cursor;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import GUI.BackendProfileEmployeeGUI.ButtonListener;
import entities.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class BackendProfileChiefGUI {

	private JFrame frmStartingPage;
	private JTextField textField;
	private JTextField searchField;
	private static Chief chief;
	private JPanel panel, picturePanel;
	private JLabel lblPhotoProfile;
	private JButton searchButton, helpButton, requestsButton, messagesButton, notifsButton, editAccountButton,createProjectButton, 
	postButton, checkprofileButton, sendMessageButton, sendRequestButton, disconnectButton;
	private JLabel emailLabel;
	private JRadioButton connectionsRadio, PublicRadio;
	private JTextArea writePostArea;
	private JList<String> connectionsList, suggestedList;
	private ArrayList<User> listOfConnections;
	private TreeSet<User> suggestedListConnections = new TreeSet<>();
	private ButtonGroup radioGroup;
	private JTextArea textAreaPost;
	private JButton editGroupButton;
	private JSeparator separator;

	//This method is the constructor of class  BackendProfileChiefGUI.
	public BackendProfileChiefGUI(User theChief) throws IOException {
		chief = (Chief) theChief;
		initialize();
	}
	
	//This method initialize the properties of this gui.
	private void initialize() throws IOException {
		frmStartingPage = new JFrame();
		frmStartingPage.setTitle("Starting Page");
		frmStartingPage.setBounds(100, 100, 893, 1020);
		frmStartingPage.setLocation(500, 0);
		frmStartingPage.setVisible(true);
		frmStartingPage.setResizable(false);
		frmStartingPage.getContentPane().setLayout(null);
		frmStartingPage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmStartingPage.setIconImage(logoimage.getImage());
		
	    panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 893, 1020);
		frmStartingPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		picturePanel = new JPanel();
		picturePanel.setBounds(49, 76, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
	    lblPhotoProfile = new JLabel();
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(chief.getImage()));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(181, 152, 170);
			lblPhotoProfile.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblPhotoProfile.setBounds(0, 0, 181, 152);
		picturePanel.add(lblPhotoProfile);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton= new JButton(search);
		searchButton.setBounds(612, 38, 55, 44);
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
						result = chief.getMyAccount().getMyCompany().searchObject(searchedText, chief);
						
						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							suggestedOptions = chief.getMyAccount().getMyCompany().suggestedSearchOption(searchedText);
							new SearchSuggestionsGUI(suggestedOptions, chief, frmStartingPage);
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
		nameLabel.setBounds(49, 254, 322, 30);
		nameLabel.setText(chief.getFirstName()+" "+chief.getLastName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel("Chief, ");
		companyPostLabel.setBounds(49, 297, 37, 16);
		panel.add(companyPostLabel);
		
		JLabel specializationLabel = new JLabel(chief.getCompanyPost());
		specializationLabel.setBounds(86, 295, 124, 16);
		panel.add(specializationLabel);
		
		emailLabel = new JLabel(chief.getMyAccount().getEmail());
		emailLabel.setBounds(49, 324, 125, 16);
		panel.add(emailLabel);
		
		JLabel lblCurrentlySupervising = new JLabel("Currently supervising:");
		lblCurrentlySupervising.setBounds(49, 359, 155, 16);
		lblCurrentlySupervising.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCurrentlySupervising);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		helpButton = new JButton(help);
		helpButton.setBounds(814, 922, 63, 58);
		helpButton.setContentAreaFilled(false); 
		helpButton.setToolTipText("Do you want help? Click me.");
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(helpButton);
		
		searchField = new JTextField();
		searchField.setBounds(324, 42, 275, 30);
		searchField.setBackground(new Color(255, 250, 240));
		searchField.setColumns(10);
		panel.add(searchField);
		
		JLabel numberOfConnectionsReq = new JLabel(chief.returnConnectionsRequest().size()+"");
		numberOfConnectionsReq.setForeground(Color.RED);
		numberOfConnectionsReq.setFont(new Font("Tahoma", Font.BOLD, 20));
		numberOfConnectionsReq.setBounds(711, 11, 17, 25);
		panel.add(numberOfConnectionsReq);
		
		JLabel numberOfMessages = new JLabel(chief.getListOfConversations().size()+"");
		numberOfMessages.setForeground(Color.RED);
		numberOfMessages.setFont(new Font("Tahoma", Font.BOLD, 20));
		numberOfMessages.setBounds(760, 11, 17, 25);
		panel.add(numberOfMessages);
		
		int number = 0;
		for (Notification theNotif: chief.returnNotification()) {
			if (theNotif instanceof GeneralNotification)
				number++;
		}
		JLabel numberOfGeneralNot = new JLabel(number+"");
		numberOfGeneralNot.setForeground(Color.RED);
		numberOfGeneralNot.setFont(new Font("Tahoma", Font.BOLD, 20));
		numberOfGeneralNot.setBounds(812, 11, 17, 25);
		panel.add(numberOfGeneralNot);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton= new JButton(friends);
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
		editAccountButton.setBounds(216, 293, 155, 25);
		editAccountButton.setContentAreaFilled(false); 
		editAccountButton.setFocusPainted(false); 
		editAccountButton.setOpaque(false);
		editAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(editAccountButton);
		
		connectionsList = new JList<String>();
		connectionsList.setBounds(43, 594, 116, 152);
		DefaultListModel<String> model = new DefaultListModel<String>();
		listOfConnections = chief.getListOfConnections(); //Get all his Connections
		for (User theUser: listOfConnections) {
			model.addElement(theUser.getFirstName()+" "+theUser.getLastName()); 
		}
		connectionsList.setModel(model);
		connectionsList.setBackground(new Color(255, 250, 240));
		panel.add(connectionsList);
		JScrollPane scrollPaneConnections = new JScrollPane(connectionsList);
		scrollPaneConnections.setBounds(43, 594, 116, 152);
		scrollPaneConnections.setBorder(new LineBorder(Color.WHITE, 2));
		panel.add(scrollPaneConnections);
		
	    suggestedListConnections = chief.suggestedConnections(); //Get all Suggested Connections
		suggestedList = new JList<String>();
		suggestedList.setBounds(220, 594, 116, 152);
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		for (User suggestedUser: suggestedListConnections) {
			model2.addElement(suggestedUser.getFirstName()+" "+suggestedUser.getLastName());
		}
		suggestedList.setModel(model2);
		suggestedList.setBackground(new Color(255, 250, 240));
		panel.add(suggestedList);
		JScrollPane scrollPaneSuggestedConnections = new JScrollPane(suggestedList);
		scrollPaneSuggestedConnections.setBounds(225, 594, 111, 152);
		scrollPaneSuggestedConnections.setBorder(new LineBorder(Color.WHITE, 2));
		panel.add(scrollPaneSuggestedConnections);
		
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + chief.getListOfConnections().size() + ")");
		lblNewLabel_9.setBounds(48, 565, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(215, 565, 139, 16);
		panel.add(lblNewLabel_9_1);
		
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
		
		textAreaPost = new JTextArea();
		textAreaPost.setBounds(427, 237, 424, 409);
		textAreaPost.setEditable(false);
		textAreaPost.setWrapStyleWord(true);
		textAreaPost.setText("");
		textAreaPost.setLineWrap(true);
		for( Post post : chief.returnAllPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
			textAreaPost.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
			textAreaPost.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
		}
		textAreaPost.setBackground(new Color(255, 250, 240));
		panel.add(textAreaPost);
		JScrollPane scrollPanePost = new JScrollPane(textAreaPost);
		scrollPanePost.setBounds(427, 237, 424, 409);
		scrollPanePost.setBorder(new LineBorder(Color.WHITE, 2));
		panel.add(scrollPanePost);
		
		textField = new JTextField();
		textField.setBounds(639, 780, 64, 25);
		textField.setToolTipText("Complete the groups name");
		textField.setBackground(new Color(255, 250, 240));
		textField.setColumns(10);
		panel.add(textField);
		
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
							Post myPost = new Post(chief,myText,radioGroup.getSelection().getActionCommand());
							chief.addPost(myPost);
							textAreaPost.setText(""); 
						    for( Post post : chief.returnAllPosts())
							{
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						        String formatDateTime = post.getTimestamp().format(formatter);
						        textAreaPost.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
								textAreaPost.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
							}
							
					   }
				 else if(rdbtnGroup.isSelected())
				 {
					    String myText = writePostArea.getText();
						Post myPost = new Post(chief,myText,radioGroup.getSelection().getActionCommand());
						chief.addPost(myPost);
						textAreaPost.setText(""); 
					    for( Post post : chief.returnAllPosts())
						{
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					        String formatDateTime = post.getTimestamp().format(formatter);
					        textAreaPost.append("-----------------------------------------------------------------------------------------------------"+ "\n\r");
							textAreaPost.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
						}
					 String groupToPost=textField.getText();
					 boolean found=false;
					 for(int i=0;i<chief.getGroups().size();i++)
					 {
						 if(chief.getGroups().get(i).getName().equals(groupToPost))
						 {
							 found=true;
							 chief.getGroups().get(i).addPostToGroupList(myPost);
						 
						 String message = "You successfully posted on "+chief.getGroups().get(i).getName()+"'s wall!";
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
			}
		});
		panel.add(postButton);
		
		checkprofileButton = new JButton("Check profile");
		checkprofileButton.setBounds(43, 759, 116, 25);
		checkprofileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkprofileButton.setContentAreaFilled(false); 
		checkprofileButton.setFocusPainted(false); 
		checkprofileButton.setOpaque(false);
		checkprofileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(checkprofileButton);
		
		// create button group for the radio button to know which one was selected
		radioGroup = new ButtonGroup();
	    radioGroup.add(connectionsRadio);
		radioGroup.add(PublicRadio);
		radioGroup.add(rdbtnGroup);
		
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.setBounds(43, 797, 116, 25);
		sendMessageButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(sendMessageButton);
		
		sendRequestButton = new JButton("Send request");
		sendRequestButton.setBounds(220, 759, 116, 25);
		sendRequestButton.setContentAreaFilled(false); 
		sendRequestButton.setFocusPainted(false); 
		sendRequestButton.setOpaque(false);
		sendRequestButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(sendRequestButton);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_50px.png");
		disconnectButton = new JButton(logout);
		disconnectButton.setBounds(796, 155, 55, 54);
	    disconnectButton.setContentAreaFilled(false);
		disconnectButton.setToolTipText("logout");
		disconnectButton.setFocusPainted(false); 
		disconnectButton.setOpaque(false);
		disconnectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Storage.saveInBinaryFile(chief.getMyAccount().getMyCompany());
				frmStartingPage.dispose();
				try {
					new WelcomeScreen_GUI(chief.getMyAccount().getMyCompany());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(disconnectButton);
		
		createProjectButton = new JButton("Create Project");
		createProjectButton.setBounds(216, 332, 155, 25);
		createProjectButton.setContentAreaFilled(false); 
		createProjectButton.setFocusPainted(false); 
		createProjectButton.setOpaque(false);
		createProjectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(createProjectButton);
		
		JList<String> list = new JList<String>();
		list.setBounds(49, 386, 155, 110);
		DefaultListModel<String> listModelForGroups = new DefaultListModel<String>();
		for (Group theSupervisingGroup: chief.getGroups()) {
			listModelForGroups.addElement(theSupervisingGroup.getName());
		}
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		listModelForGroups.addElement("weuq9wsiqqwwedqe");
		list.setModel(listModelForGroups);
		panel.add(list);
		JScrollPane scrollPaneGroups = new JScrollPane(list);
		scrollPaneGroups.setBounds(49, 388, 139, 108);
		scrollPaneGroups.setBorder(new LineBorder(Color.WHITE, 2));
		panel.add(scrollPaneGroups);
		
		Icon check = new ImageIcon("Buttons_backgrounds/takealook_32px.png");
		JButton checkGroup = new JButton(check);
		checkGroup.setBounds(80, 495, 48, 36);
		checkGroup.setBorder(null);
		checkGroup.setContentAreaFilled(false); 
		checkGroup.setFocusPainted(false); 
		checkGroup.setOpaque(false);
		checkGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkGroup.setOpaque(false);
		checkGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedGroupString = list.getSelectedValue()+"";
				Group selectedGroup = null;
				
				for (Group supervisingGroup: chief.getGroups()) {
					if (selectedGroupString.equalsIgnoreCase(supervisingGroup.getName())) {
						selectedGroup = supervisingGroup;
						break;
					}
				}
				
				if (selectedGroup != null) {
					try {
						new GroupProfileGUI(chief, selectedGroup);
						frmStartingPage.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					String message = "You havent select any Group!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(checkGroup);
		
		Icon edit = new ImageIcon("Buttons_backgrounds/edit_20px.png");
		editGroupButton = new JButton(edit);
		editGroupButton.setBounds(124, 495, 48, 36);
		editGroupButton.setBorder(null);
		editGroupButton.setContentAreaFilled(false); 
		editGroupButton.setFocusPainted(false); 
		editGroupButton.setOpaque(false);
		editGroupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editGroupButton.setOpaque(false);
		editGroupButton.setBackground(new Color(248, 248, 255));
		editGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedGroupString = list.getSelectedValue()+"";
				Group selectedGroup = null;
				
				for (Group supervisingGroup: chief.getGroups()) {
					if (selectedGroupString.equalsIgnoreCase(supervisingGroup.getName())) {
						selectedGroup = supervisingGroup;
						break;
					}
				}
				
				if (selectedGroup != null) {
					new EditGroupProjectGUI(selectedGroup, frmStartingPage);
				}else {
					String message = "You havent select any Group!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					  JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel.add(editGroupButton);
		
		separator = new JSeparator();
		separator.setBounds(49, 549, 287, 5);
		separator.setForeground(new Color(255, 250, 250));
		panel.add(separator);
		
		JLabel editGroup = new JLabel("");
		editGroup.setBounds(0, 0, 887, 991);
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		editGroup.setIcon(new ImageIcon(imagerisizeb));
		panel.add(editGroup);
		
		ButtonListener listener = new ButtonListener();
		requestsButton.addActionListener(listener);
		messagesButton.addActionListener(listener);
		notifsButton.addActionListener(listener);
		editAccountButton.addActionListener(listener);
		createProjectButton.addActionListener(listener);
		helpButton.addActionListener(listener);
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
					new ConnectionRequestsGUI(chief);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (e.getSource().equals(messagesButton)) {
				
				try {
					new NewMessagesGUI(chief);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
								ArrayList<Conversation> listOfConversation = chief.getListOfConversations();
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
									new PrivateChatGUI(selectedUser, chief, selectedUserToChat);
								}
							}
			}
			else if(e.getSource().equals(notifsButton)) {
				try {
					new NotificationsGUI(chief,frmStartingPage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(editAccountButton)) {
				
				new EditAccountGUI(chief, frmStartingPage);
			}
			
			else if(e.getSource().equals(createProjectButton)) {
				
				 new CreateProjectGUI(chief);
			}
			
			else if(e.getSource().equals(helpButton)) {
				try {
					frmStartingPage.setVisible(false);
					new HelpGUI(chief);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
						new FrontEndProfileGUI(chief, selectedUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmStartingPage.setVisible(false);
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
					ArrayList<Conversation> listOfConversation = chief.getListOfConversations();
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
		}
	}
}
