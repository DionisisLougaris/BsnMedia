package GUI;

import java.awt.EventQueue;
import entities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import entities.User;

import java.awt.Color;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConnectionRequestsGUI {

	private JFrame frmConnectionRequests;
	private User user;
	private JButton acceptButton;
	private JButton deleteButton;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private TreeSet<Notification> connectionRequests;

	public ConnectionRequestsGUI(User theUser ) throws IOException {
		initialize(theUser);
	}

	private void initialize(User theUser){
		frmConnectionRequests = new JFrame();
		frmConnectionRequests.setResizable(false);
		frmConnectionRequests.setVisible(true); 
		frmConnectionRequests.setTitle("Connection Requests");
		frmConnectionRequests.getContentPane().setBackground(new Color(255, 153, 102));
		frmConnectionRequests.setBounds(1060, 88, 200, 244);
		frmConnectionRequests.getContentPane().setLayout(null);
		
		user = theUser;
		
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
				if (notification.getNotificationContent().equalsIgnoreCase(selectedRequestString));
				selectedRequest = notification;
				break;
			}
			
			if (e.getSource().equals(acceptButton)) {
				
				if (selectedRequestString.equals("No Connections Requests")) {
					
					String message = "There is no request to select";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
					
				}else if (selectedRequest != null){
					int indexOfSelectedValue = list.getSelectedIndex();
					User ôheOnewehoSentTheRequest = selectedRequest.getAboutThisUser();
					
					Connection newConnection = new Connection(ôheOnewehoSentTheRequest, user);
					newConnection.manageConnectionRequest(true);
					if (indexOfSelectedValue != -1) {
						listModel.remove(indexOfSelectedValue);
						indexOfSelectedValue = -1;
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
					User ôheOnewehoSentTheRequest = selectedRequest.getAboutThisUser();
					
					Connection newConnection = new Connection(ôheOnewehoSentTheRequest, user);
					newConnection.manageConnectionRequest(false);
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
