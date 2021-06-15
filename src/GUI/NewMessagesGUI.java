package GUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Boss;
import entities.Connection;
import entities.Conversation;
import entities.Group;
import entities.Notification;
import entities.*;
import entities.privateConversation;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class NewMessagesGUI {

	private JFrame frmNewMessages;
	private User user;
	private JTextField searchConvoField;


	public NewMessagesGUI(User theUser) throws IOException {
		initialize(theUser);
	}

	private void initialize(User theUser) throws IOException {
		frmNewMessages = new JFrame();
		frmNewMessages.getContentPane().setBackground(new Color(255, 153, 102));
		frmNewMessages.setResizable(false);
		frmNewMessages.setTitle("New Messages");
		frmNewMessages.setBounds(1200, 88, 212, 276);
		frmNewMessages.getContentPane().setLayout(null);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmNewMessages.setIconImage(logoimage.getImage());
		
		user = theUser;
		
		JList<String> listWithConversations = new JList<String>();
		listWithConversations.setBorder(new LineBorder(new Color(0, 0, 0)));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<User> activeConversations = user.getListOfConnections();
		if (user instanceof Boss) {
			
			if (activeConversations.size()>0) {
				for(User allConvos: activeConversations) {
					listModel.addElement(allConvos.getFirstName()+" "+allConvos.getLastName());
				}
			}else {
				listModel.addElement("No Conversations..");
			}
		}else {
			if (activeConversations.size()>0 || user.getGroups().size()>0) {
				
				for(User allConvos: activeConversations) {
					listModel.addElement(allConvos.getFirstName()+" "+allConvos.getLastName());
				}
				
				for (Group myGroup: user.getGroups()) {
					listModel.addElement(myGroup.getName());
				}
			}else {
				listModel.addElement("No Conversations..");
			}
		}
		listWithConversations.setModel(listModel);
		listWithConversations.setBounds(12, 68, 172, 129);
		frmNewMessages.getContentPane().add(listWithConversations);

		Icon open = new ImageIcon("Buttons_backgrounds/open_32px.png");
		JButton goToConvo = new JButton(open);
		goToConvo.setBorder(null);
		goToConvo.setContentAreaFilled(false); 
		goToConvo.setFocusPainted(false); 
		goToConvo.setOpaque(false);
		goToConvo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goToConvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Going to private Conversation
				String selectedString = listWithConversations.getSelectedValue();
				boolean found = false;
				
				User selectedUser = null;
				
				for(User user: user.getListOfConnections()) {
					String fullName = user.getFirstName()+" "+user.getLastName();
					
					if (fullName.equalsIgnoreCase(selectedString)) {
						selectedUser = user;
						found = true;
						break;
					}
				}
				
				if (selectedUser != null ) {
					
					ArrayList<Conversation> listOfConversation = user.getListOfConversations();
					Conversation selectedUserToChat = null;
					
					for (Conversation theConversation: listOfConversation) {
						
						if ((((privateConversation)theConversation).getDiscussant1().equals(user) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
							(((privateConversation)theConversation).getDiscussant2().equals(user) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
							
							selectedUserToChat = theConversation;
							break;
						}
					}
					
					if(selectedUserToChat == null) {
						
						 String message = "Something went Wrong!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.INFORMATION_MESSAGE);
					}else {
						
						new PrivateChatGUI(selectedUser, theUser, selectedUserToChat);
					}
				}else {
					
					for(Group myGroup: user.getGroups()) {
						if (myGroup.getName().equalsIgnoreCase(selectedString)) {
							new GroupChatGUI(myGroup, user);
							found = true; 
							break;
						}
					}
				}
				if (!found) {
					 String message = "You haven't select any Conversation";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		goToConvo.setBounds(144, 201, 40, 35);
		frmNewMessages.getContentPane().add(goToConvo);
		
		JLabel lblNewLabel = new JLabel("All Conversations:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(22, 48, 162, 16);
		frmNewMessages.getContentPane().add(lblNewLabel);
		
		
		searchConvoField = new JTextField();
		searchConvoField.setBorder(null);
		searchConvoField.setBounds(12, 13, 129, 22);
		frmNewMessages.getContentPane().add(searchConvoField);
		searchConvoField.setColumns(10);
		
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton searchButton = new JButton(search);
		searchButton.setBorder(null);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setBounds(149, 12, 33, 29);
		searchButton.addActionListener(new ActionListener() {
			
			//The Search works only to search conversations with other users and no for GroupConversations
			public void actionPerformed(ActionEvent arg0) {
				
				String text = searchConvoField.getText();
				Conversation selectedConversation = null;
				boolean found = false;
				
				if(!text.isEmpty()) {
					
					User selectedUser = null;
					
					for(User user: user.getListOfConnections()) {
						String fullName = user.getFirstName()+" "+user.getLastName();
						
						if (fullName.equalsIgnoreCase(text) || user.getFirstName().equalsIgnoreCase(text) || user.getLastName().equalsIgnoreCase(text)) {
							selectedUser = user;
							found = true;
							break;
						}
					}
					
					if (selectedUser != null) {
						
						ArrayList<Conversation> listOfConversation = user.getListOfConversations();
						
						for (Conversation theConversation: listOfConversation) {
							
							if ((((privateConversation)theConversation).getDiscussant1().equals(user) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
								(((privateConversation)theConversation).getDiscussant2().equals(user) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
								
								selectedConversation = theConversation;
								break;
							}
						}
						
						if(selectedConversation == null) {
							 String message = "Something went Wrong!";
								JOptionPane.showMessageDialog(new JFrame(), message, "Message",
								        JOptionPane.INFORMATION_MESSAGE);
						}else {
							
							new PrivateChatGUI(selectedUser, user, selectedConversation);
						}
					}
					
					if (!found) {
						
						 String message = "The search was not successful";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		frmNewMessages.getContentPane().add(searchButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(0, 40, 194, 10);
		frmNewMessages.getContentPane().add(separator);
		frmNewMessages.setVisible(true);
	}
}


