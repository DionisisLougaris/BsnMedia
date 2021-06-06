package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.Connection;
import entities.Employee;
import entities.Post;
import entities.User;
import java.awt.Color;
import java.awt.Cursor;

public class BackendProfileEmployeeGUI {

	private JFrame frame;
	private JTextField searchField;
	private JTextField textField;
	private JPanel panel, picturePanel;
	private JLabel lblNewLabel;
	private JButton searchButton, helpButton, requestsButton, messagesButton, notifsButton, editAccountButton, postButton, checkprofileButton, sendMessageButton, sendRequestButton, disconnectButton;
	private JLabel emailLabel;
	private JLabel groupALabel, groupBLabel, groupCLabel;
	private JList connectionsList, suggestedList, postList; // xreiazetai na kanoume to suggested connections
	private JTextArea writePostArea, postArea;
	private JRadioButton connectionsRadio, PublicRadio, GroupARadio, GroupBRadio, GroupCRadio;
	private static Employee employee; // static??
	private JLabel lblNewLabel_1;
	TreeSet<User> suggestedListConnections = new TreeSet<>();
	TreeSet<Post> allPosts = new TreeSet<>();
	private JScrollPane scrollPane;
	ButtonGroup radioGroup;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// oxi sigourh gia thn parametro prepei na thn doume sto testing
					BackendProfileEmployeeGUI window = new BackendProfileEmployeeGUI(employee);
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
	public BackendProfileEmployeeGUI(User aUser) {
		employee = (Employee) aUser;
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
		panel.setBounds(0, 0, 887, 985);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		picturePanel = new JPanel();
		picturePanel.setBounds(47, 79, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
		lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		picturePanel.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton = new JButton(search);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		searchButton.setBounds(612, 47, 55, 44);
		panel.add(searchButton);
		
		JLabel nameLabel = new JLabel("Name LastName");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(47, 244, 137, 30);
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel("Employee, ");
		companyPostLabel.setBounds(196, 254, 89, 16);
		panel.add(companyPostLabel);
		
		JLabel specializationLabel = new JLabel("Specialization");
		specializationLabel.setBounds(261, 254, 78, 16);
		panel.add(specializationLabel);
		
		emailLabel = new JLabel(employee.getMyAccount().getEmail());
		emailLabel.setBounds(49, 287, 125, 16);
		panel.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(49, 357, 133, 16);
		panel.add(lblNewLabel_5);
		
		String name;
		if(employee.getGroups().size()>0) {
			name = employee.getGroups().get(0).getName();
			
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
		
		if(employee.getGroups().size()>1) {
			name = employee.getGroups().get(1).getName();
			
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
		
		if(employee.getGroups().size()>2) {
			name = employee.getGroups().get(2).getName();
			
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
		searchField.setBounds(332, 50, 268, 30);
		panel.add(searchField);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton = new JButton(friends);
		requestsButton.setContentAreaFilled(false); 
		requestsButton.setFocusPainted(false); 
		requestsButton.setOpaque(false);
		requestsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		requestsButton.setBounds(714, 27, 37, 30);
		panel.add(requestsButton);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
		messagesButton = new JButton(messages);
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
		editAccountButton.setBounds(208, 297, 155, 25);
		panel.add(editAccountButton);
		
		connectionsList = new JList(employee.getListOfConnections().toArray());
		connectionsList.setBackground(new Color(255, 250, 240));
		connectionsList.setBounds(44, 483, 116, 152);
		panel.add(connectionsList);
		
		suggestedListConnections = employee.suggestedConnections();
		suggestedList = new JList(suggestedListConnections.toArray());
		suggestedList.setBackground(new Color(255, 250, 240));
		suggestedList.setBounds(221, 483, 116, 152);
		panel.add(suggestedList);
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + employee.getListOfConnections().size() + ")");
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
		
		lblNewLabel_1 = new JLabel("logo");
		lblNewLabel_1.setBounds(12, 917, 56, 43);
		panel.add(lblNewLabel_1);

		postArea = new JTextArea();
		postArea.setBackground(new Color(255, 250, 240));
		postArea.setBounds(427, 256, 424, 409);
		allPosts = employee.returnAllPosts();
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
					new HelpGUI();
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
				if(!connectionsList.isSelectionEmpty()) {
					User anotherUser = (User) connectionsList.getSelectedValue();
					new FrontEndProfileGUI(anotherUser);
				}
			}
			else if(e.getSource().equals(sendMessageButton)) {
				if(!connectionsList.isSelectionEmpty()) {
					User anotherUser = (User) connectionsList.getSelectedValue();
					new PrivateChatGUI(anotherUser, employee, null); //null?
				}
			}
			else if(e.getSource().equals(sendRequestButton)) {
				if(!suggestedList.isSelectionEmpty()) {
					User anotherUser = (User) suggestedList.getSelectedValue();
					Connection conn = new Connection(employee, anotherUser);
					conn.sendConnectionRequest();
				}
			}
			// not finished
			else if(e.getSource().equals(postButton)) {
				String postText = writePostArea.getText();
				if(connectionsRadio.isSelected() || PublicRadio.isSelected() || GroupARadio.isSelected() || GroupBRadio.isSelected() || GroupCRadio.isSelected()) {
					String selected = radioGroup.getSelection().toString();
					Post newPost = new Post(employee, postText, selected);
					employee.addPost(newPost);
					postList.remove(postList); //den eimai sigourh an douleuei
					
				}
				
				
			}
		}
		
		
		
	}
}
