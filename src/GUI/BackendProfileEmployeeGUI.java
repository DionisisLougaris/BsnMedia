package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.Connection;
import entities.User;

import javax.swing.JRadioButton;

public class BackendProfileEmployeeGUI {

	private JFrame frame;
	private JTextField searchField;
	private JTextField textField;
	private JPanel panel, picturePanel;
	private JLabel lblNewLabel;
	private JButton searchButton, helpButton, requestsButton, messagesButton, notifsButton, editAccountButton, postButton, checkprofileButton, sendMessageButton, sendRequestButton, disconnectButton;
	private JTextArea postsArea;
	private JLabel emailLabel;
	private JLabel groupALabel, groupBLabel, groupCLabel;
	private JList connectionsList, suggestedList; // xreiazetai na kanoume to suggested connections
	private JTextArea writePostArea;
	private JRadioButton connectionsRadio, PublicRadio, GroupRadio;
	private static User user; // static??
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// oxi sigourh gia thn parametro prepei na thn doume sto testing
					BackendProfileEmployeeGUI window = new BackendProfileEmployeeGUI(user);
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
		user = aUser;
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
		
		postsArea = new JTextArea();
		postsArea.setBounds(427, 171, 424, 409);
		panel.add(postsArea);
		
		JLabel nameLabel = new JLabel("Name LastName");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameLabel.setBounds(59, 192, 137, 30);
		panel.add(nameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Company Post, ");
		lblNewLabel_2.setBounds(221, 202, 89, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization");
		lblNewLabel_3.setBounds(310, 202, 78, 16);
		panel.add(lblNewLabel_3);
		
		emailLabel = new JLabel("example@gmail.com");
		emailLabel.setBounds(69, 221, 125, 16);
		panel.add(emailLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(49, 285, 133, 16);
		panel.add(lblNewLabel_5);
		
		groupALabel = new JLabel("Group A");
		groupALabel.setBounds(49, 314, 56, 16);
		panel.add(groupALabel);
		
		groupBLabel = new JLabel("Group B");
		groupBLabel.setBounds(114, 314, 56, 16);
		panel.add(groupBLabel);
		
		groupCLabel = new JLabel("Group C");
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
		
		connectionsList = new JList(user.getListOfConnections().toArray());
		connectionsList.setBounds(44, 402, 116, 152);
		panel.add(connectionsList);
		
		suggestedList = new JList();
		suggestedList.setBounds(221, 402, 116, 152);
		panel.add(suggestedList);
		
		JLabel lblNewLabel_9 = new JLabel("Connections (" + user.getListOfConnections().size() + ")");
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
		connectionsRadio.setBounds(458, 675, 112, 25);
		panel.add(connectionsRadio);
		
		PublicRadio = new JRadioButton("Public");
		PublicRadio.setBounds(574, 675, 78, 25);
		panel.add(PublicRadio);
		
		GroupRadio = new JRadioButton("Group");
		GroupRadio.setBounds(651, 675, 89, 25);
		panel.add(GroupRadio);
		
		postButton = new JButton("Post");
		postButton.setBounds(754, 675, 97, 25);
		panel.add(postButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(661, 709, 64, 25);
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
					Connection conn = new Connection(user, anotherUser);
					conn.sendConnectionRequest();
				}
			}
			else if(e.getSource().equals(sendMessageButton)) {
				if(!connectionsList.isSelectionEmpty()) {
					User anotherUser = (User) connectionsList.getSelectedValue();
					new PrivateChatGUI(anotherUser, user, null); //null?
				}
			}
		}
		
		
		
	}
}
