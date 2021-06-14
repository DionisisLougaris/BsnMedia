package GUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Connection;
import entities.Conversation;
import entities.Group;
import entities.Notification;
import entities.User;
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

public class NewMessagesGUI {

	private JFrame frmNewMessages;
	private User user;
	private JTextField textField;


	public NewMessagesGUI(User theUser) throws IOException {
		initialize(theUser);
	}

	private void initialize(User theUser) throws IOException {
		frmNewMessages = new JFrame();
		frmNewMessages.getContentPane().setBackground(new Color(255, 153, 102));
		frmNewMessages.setResizable(false);
		frmNewMessages.setTitle("New Messages");
		frmNewMessages.setBounds(1200, 88, 200, 468);
		frmNewMessages.getContentPane().setLayout(null);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/BSNlogo.jpg");
		frmNewMessages.setIconImage(logoimage.getImage());
		
		user = theUser;
		
		JList<String> list = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<User> activeConversations = user.getListOfConnections();
		if (activeConversations.size()>0) {
			for(User allConvos: activeConversations) {
				listModel.addElement(allConvos.getFirstName());
			}
		}else {
			listModel.addElement("No Conversations..");
		}
		list.setModel(listModel);
		list.setBounds(12, 68, 172, 129);
		frmNewMessages.getContentPane().add(list);
		
		JList<String> list2 = new JList<String>();
		DefaultListModel<String> listModel2 = new DefaultListModel<String>();
		ArrayList<Group> activeGroupConversations = user.getGroups();
		if (activeGroupConversations.size()>0) {
			for(Group allGroupConvos: activeGroupConversations) {
				listModel2.addElement(allGroupConvos.getName());
			}
		}else {
			listModel2.addElement("No Conversations..");
		}
		list2.setModel(listModel2);
		list2.setBounds(12, 287, 172, 84);
		frmNewMessages.getContentPane().add(list2);
		
		
		Icon open = new ImageIcon("Buttons_backgrounds/open_32px.png");
		JButton btnNewButton = new JButton(open);
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Going to private Conversation
				String selectedUserString = list.getSelectedValue();
				User selectedUser = null;
				
				for(User user: user.getListOfConnections()) {
					String userName = user.getFirstName();
					
					if (userName.equalsIgnoreCase(selectedUserString)) {
						selectedUser = user;
						break;
					}
				}
				
				if (selectedUser == null) {
					 String message = "You have not selected any user!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}else {
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
				}
			}
		});
		btnNewButton.setBounds(144, 210, 40, 35);
		frmNewMessages.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Private conversations:");
		lblNewLabel.setBounds(22, 48, 129, 16);
		frmNewMessages.getContentPane().add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(12, 13, 129, 22);
		frmNewMessages.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton_1 = new JButton(search);
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(149, 12, 33, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = textField.getText();
				Conversation selectedUserToChat = null;
				if(!text.isEmpty()) {
					User selectedUser= null;
					for(User user: user.getListOfConnections()) {
						String userName = user.getFirstName();
						
						if (userName.equalsIgnoreCase(text)) {
							selectedUser = user;
							break;
						}
							ArrayList<Conversation> listOfConversation = user.getListOfConversations();
							
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
								new PrivateChatGUI(selectedUser, user, selectedUserToChat);
							}
						}
					}
				else {
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		frmNewMessages.getContentPane().add(btnNewButton_1);
		
		JLabel lblGroupConversations = new JLabel("Group conversations:");
		lblGroupConversations.setBounds(12, 258, 129, 16);
		frmNewMessages.getContentPane().add(lblGroupConversations);
		
		JButton btnNewButton_2 = new JButton(open);
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(144, 384, 40, 35);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//Going to group Conversation
					String selectedGroupString = list2.getSelectedValue();
					Group selectedGroup = null;
					Conversation selectedGroupToChat=null;
					for(Group aGroup: user.getGroups()) {
						String GroupName = aGroup.getName();
						
						if (GroupName.equalsIgnoreCase(selectedGroupString)) {
							selectedGroup = aGroup;
							break;
						}
					}
	
					if (selectedGroup == null) {
						 String message = "You have not selected any group!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.INFORMATION_MESSAGE);
					}
					else {
							selectedGroupToChat = selectedGroup.getMyConversation();
							}
	
						
						if(selectedGroupToChat == null) {
							 String message = "Something went Wrong!";
								JOptionPane.showMessageDialog(new JFrame(), message, "Message",
								        JOptionPane.INFORMATION_MESSAGE);
						}else {
							new GroupChatGUI(selectedGroup, theUser);
						}
			}
		
			});
		frmNewMessages.getContentPane().add(btnNewButton_2);
		frmNewMessages.setVisible(true);
	}
}


