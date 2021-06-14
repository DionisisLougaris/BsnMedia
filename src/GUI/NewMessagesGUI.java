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
		frmNewMessages.setBounds(1200, 88, 200, 407);
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
		list.setBounds(12, 65, 172, 136);
		frmNewMessages.getContentPane().add(list);
		
		JList<String> list2 = new JList<String>();
		DefaultListModel<String> listModel2 = new DefaultListModel<String>();
		ArrayList<Group> activeGroupConversations = user.getGroups();
		if (activeGroupConversations.size()>0) {
			for(Group allGroupConvos: activeGroupConversations) {
				listModel.addElement(allGroupConvos.getName());
			}
		}else {
			listModel.addElement("No Conversations..");
		}
		list2.setBounds(12, 230, 172, 84);
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
				
				for(User theUser: theUser.getListOfConnections()) {
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
					ArrayList<Conversation> listOfConversation = theUser.getListOfConversations();
					Conversation selectedUserToChat = null;
					
					for (Conversation theConversation: listOfConversation) {
						
						if ((((privateConversation)theConversation).getDiscussant1().equals(theUser) && ((privateConversation)theConversation).getDiscussant2().equals(selectedUser)) ||
							(((privateConversation)theConversation).getDiscussant2().equals(theUser) && ((privateConversation)theConversation).getDiscussant1().equals(selectedUser))) {
							
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
				
				//Going to group Conversation
				String selectedGroupString = list2.getSelectedValue();
				Group selectedGroup = null;
				Conversation selectedGroupToChat=null;
				for(Group aGroup: theUser.getGroups()) {
					String GroupName = aGroup.getName();
					
					if (GroupName.equalsIgnoreCase(selectedUserString)) {
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
		btnNewButton.setBounds(77, 327, 40, 35);
		frmNewMessages.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Private conversations:");
		lblNewLabel.setBounds(22, 48, 129, 16);
		frmNewMessages.getContentPane().add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(12, 13, 122, 22);
		frmNewMessages.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(149, 12, 33, 23);
		frmNewMessages.getContentPane().add(btnNewButton_1);
		
		JLabel lblGroupConversations = new JLabel("Group conversations:");
		lblGroupConversations.setBounds(22, 214, 129, 16);
		frmNewMessages.getContentPane().add(lblGroupConversations);
		frmNewMessages.setVisible(true);
	}
}
