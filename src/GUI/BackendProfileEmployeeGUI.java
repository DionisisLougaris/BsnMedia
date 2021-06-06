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
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		picturePanel = new JPanel();
		picturePanel.setBounds(49, 27, 181, 152);
		panel.add(picturePanel);
		picturePanel.setLayout(null);
		
		lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		picturePanel.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		searchButton = new JButton(search);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		searchButton.setBounds(613, 13, 55, 44);
		panel.add(searchButton);
		
		JLabel nameLabel = new JLabel("Name LastName");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(59, 192, 137, 30);
		panel.add(nameLabel);
		
		JLabel companyPostLabel = new JLabel("Employee, ");
		companyPostLabel.setBounds(221, 202, 89, 16);
		panel.add(companyPostLabel);
		
		JLabel specializationLabel = new JLabel("Specialization");
		specializationLabel.setBounds(285, 202, 78, 16);
		panel.add(specializationLabel);
		
		emailLabel = new JLabel(employee.getMyAccount().getEmail());
		emailLabel.setBounds(69, 221, 125, 16);
		panel.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(49, 285, 133, 16);
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
		groupALabel.setBounds(49, 314, 56, 16);
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
		groupBLabel.setBounds(114, 314, 56, 16);
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
		groupCLabel.setBounds(174, 314, 56, 16);
		panel.add(groupCLabel);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		helpButton = new JButton(help);
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		helpButton.setBounds(824, 929, 46, 38);
		panel.add(helpButton);
		
		searchField = new JTextField();
		searchField.setColumns(10);
		searchField.setBounds(333, 27, 268, 30);
		panel.add(searchField);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		requestsButton = new JButton(friends);
		requestsButton.setBounds(714, 27, 37, 30);
		panel.add(requestsButton);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
		messagesButton = new JButton(messages);
		messagesButton.setBounds(763, 27, 37, 30);
		panel.add(messagesButton);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		notifsButton = new JButton(bell);
		notifsButton.setBounds(814, 27, 37, 30);
		panel.add(notifsButton);
		
		editAccountButton = new JButton("Edit Account Info");
		editAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editAccountButton.setBounds(216, 250, 155, 25);
		panel.add(editAccountButton);
		
		connectionsList = new JList(employee.getListOfConnections().toArray());
		connectionsList.setBounds(44, 402, 116, 152);
		panel.add(connectionsList);
		
		suggestedListConnections = employee.suggestedConnections();
		suggestedList = new JList(suggestedListConnections.toArray());
		suggestedList.setBounds(221, 402, 116, 152);
		panel.add(suggestedList);
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + employee.getListOfConnections().size() + ")");
		lblNewLabel_9.setBounds(49, 373, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(221, 373, 139, 16);
		panel.add(lblNewLabel_9_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(830, 171, 21, 409);
		panel.add(scrollBar);
		
		writePostArea = new JTextArea();
		writePostArea.setBounds(427, 601, 424, 49);
		panel.add(writePostArea);
		
		connectionsRadio = new JRadioButton("Connections");
		connectionsRadio.setBounds(427, 675, 112, 25);
		panel.add(connectionsRadio);
		
		PublicRadio = new JRadioButton("Public");
		PublicRadio.setBounds(543, 675, 78, 25);
		panel.add(PublicRadio);
		
		postButton = new JButton("Post");
		postButton.setBounds(754, 675, 97, 25);
		panel.add(postButton);
		
		// create button group for the radio button to know which one was selected
		radioGroup = new ButtonGroup();
		radioGroup.add(connectionsRadio);
		radioGroup.add(PublicRadio);
		radioGroup.add(GroupARadio);
		radioGroup.add(GroupBRadio);
		radioGroup.add(GroupCRadio);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(468, 709, 64, 25);
		panel.add(textField);
		
		checkprofileButton = new JButton("Check profile");
		checkprofileButton.setBounds(44, 567, 116, 25);
		panel.add(checkprofileButton);
		
		sendMessageButton = new JButton("Send Message");
		sendMessageButton.setBounds(44, 601, 116, 25);
		panel.add(sendMessageButton);
		
		sendRequestButton = new JButton("Send request");
		sendRequestButton.setBounds(221, 567, 116, 25);
		panel.add(sendRequestButton);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_35px.png");
		disconnectButton = new JButton(logout);
		disconnectButton.setBounds(754, 98, 97, 25);
		panel.add(disconnectButton);
		
		lblNewLabel_1 = new JLabel("logo");
		lblNewLabel_1.setBounds(12, 917, 56, 43);
		panel.add(lblNewLabel_1);

		postArea = new JTextArea();
		postArea.setBounds(427, 175, 424, 409);
		allPosts = employee.returnAllPosts();
		// not finished
		for(int i = 0; i < allPosts.size(); i++) {
			
		}
		panel.add(postArea);
		
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
