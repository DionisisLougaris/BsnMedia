package GUI;

import entities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import entities.User;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ConnectionRequestsGUI {

	private  JFrame frmConnectionRequests;
	private User user;
	private JButton acceptButton;
	private JButton deleteButton;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private TreeSet<Notification> connectionRequests;
	private JFrame backEndFrame;
	

	public ConnectionRequestsGUI(User theUser, JFrame backendFrame) throws IOException {
		initialize(theUser, backendFrame);
	}

	private void initialize(User theUser, JFrame backendFrame){
		frmConnectionRequests = new JFrame();
		frmConnectionRequests.setResizable(false);
		frmConnectionRequests.setVisible(true); 
		frmConnectionRequests.setTitle("Connection Requests");
		frmConnectionRequests.getContentPane().setBackground(new Color(255, 153, 102));
		frmConnectionRequests.setBounds(1060, 88, 200, 244);
		frmConnectionRequests.getContentPane().setLayout(null);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmConnectionRequests.setIconImage(logoimage.getImage());
		
		user = theUser;
		backEndFrame = backendFrame;
		
		list = new JList<String>();
		listModel = new DefaultListModel<String>();
		connectionRequests = user.returnConnectionsRequest();
		if (connectionRequests.size()>0) {
			for(Notification conReq: connectionRequests) {
				listModel.addElement(conReq.getNotificationContent());
			}
		}else {
			listModel.addElement("No Connections Requests");
		}
		list.setModel(listModel);
		list.setBounds(10, 11, 172, 145);
		frmConnectionRequests.getContentPane().add(list);
		JScrollPane scrollPaneConnectionRequests = new JScrollPane(list);
		scrollPaneConnectionRequests.setBounds(10, 11, 172, 145);
		scrollPaneConnectionRequests.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmConnectionRequests.getContentPane().add(scrollPaneConnectionRequests);
		
		Icon accept = new ImageIcon("Buttons_backgrounds/accept_32px.png");
		acceptButton = new JButton(accept);
		acceptButton.setContentAreaFilled(false); 
		acceptButton.setFocusPainted(false); 
		acceptButton.setOpaque(false);
		acceptButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		acceptButton.setBounds(10, 165, 75, 36);
		frmConnectionRequests.getContentPane().add(acceptButton);
		
		Icon decline = new ImageIcon("Buttons_backgrounds/decline_32px.png");
		deleteButton = new JButton(decline);
		deleteButton.setContentAreaFilled(false); 
		deleteButton.setFocusPainted(false); 
		deleteButton.setOpaque(false);
		deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteButton.setBounds(107, 165, 75, 36);
		frmConnectionRequests.getContentPane().add(deleteButton);
		
	
		
		ButtonListener listener = new ButtonListener();
		acceptButton.addActionListener(listener);
		deleteButton.addActionListener(listener);	
	}
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String selectedRequestString = list.getSelectedValue()+"";
			Notification selectedRequest = null;
			
			for(Notification notification: connectionRequests) {
				if (notification.getNotificationContent().equalsIgnoreCase(selectedRequestString)) {
					selectedRequest = notification;
					break;
				}
			}
			
			if (e.getSource().equals(acceptButton)) {
				
				if (selectedRequestString.equals("No Connections Requests")) {
					
					String message = "There is no request to select";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
					
				}else if (selectedRequest != null){
					int indexOfSelectedValue = list.getSelectedIndex();
					User theOnewehoSentTheRequest = selectedRequest.getAboutThisUser();
					
					Connection newConnection = new Connection(theOnewehoSentTheRequest, user);
					newConnection.manageConnectionRequest(true, selectedRequest); //They will be connected
					//Notifing user that his request was accepted
					GeneralNotification genNot = new GeneralNotification("You are now connected with "+user.getFirstName(),user,"acceptRequest"); //Send Notification to the user who send the request
					theOnewehoSentTheRequest.getListOfNotifications().add(genNot);
					if (indexOfSelectedValue != -1) {
						listModel.remove(indexOfSelectedValue);
						indexOfSelectedValue = -1;
					}
					if (user instanceof Employee) {
						try {
							new BackendProfileEmployeeGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						backEndFrame.dispose();
					}else if (user instanceof Chief) {
						try {
							new BackendProfileChiefGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						backEndFrame.dispose();
					}else {
						try {
							new BackendProfileBossGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						backEndFrame.dispose();
					}
				}else {
					String message = "You have not selected any requests to Accept!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
				
			}else if(e.getSource().equals(deleteButton)) {
				
				if (selectedRequestString.equals("No Connections Requests")) {
					
					String message = "There is no request to select";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
					
				}else if (selectedRequest != null){
					
					int indexOfSelectedValue = list.getSelectedIndex();
					User theOnewehoSentTheRequest = selectedRequest.getAboutThisUser();
					
					Connection newConnection = new Connection(theOnewehoSentTheRequest, user);
					newConnection.manageConnectionRequest(false, selectedRequest); //The user decline the request
					if (indexOfSelectedValue != -1) {
						listModel.remove(indexOfSelectedValue);
						indexOfSelectedValue = -1;
					}
				}else {
					String message = "You have not selected any requests to delete!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
