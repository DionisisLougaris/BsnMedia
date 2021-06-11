package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JList;

import entities.Notification;
import entities.User;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class NotificationsGUI {

	private JFrame frmNotifications;
	private User user;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotificationsGUI window = new NotificationsGUI();
					window.frmNotifications.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public NotificationsGUI(User theUser) throws IOException {
		initialize(theUser);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(User theUser) throws IOException {
		frmNotifications = new JFrame();
		frmNotifications.setTitle("Notifications");
		frmNotifications.setResizable(false);
		frmNotifications.getContentPane().setBackground(new Color(255, 153, 102));
		frmNotifications.setBounds(1325, 88, 200, 244);
		frmNotifications.getContentPane().setLayout(null);
		
		user = theUser;
		
		JList<String> list = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		TreeSet<Notification> generalNotifications = user.returnNotification();
		if (generalNotifications.size()>0) {
			for(Notification conReq: generalNotifications) {
				listModel.addElement(conReq.getNotificationContent());
			}
		}else {
			listModel.addElement("No Notifications..");
		}
		list.setModel(listModel);
		list.setBounds(10, 11, 172, 145);
		frmNotifications.getContentPane().add(list);
		
		Icon takealook = new ImageIcon("Buttons_backgrounds/takealook_32px.png");
		JButton btnNewButton = new JButton(takealook);
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(66, 158, 66, 38);
		frmNotifications.getContentPane().add(btnNewButton);
		
		frmNotifications.setVisible(true); //den anoige diaforetika
	}

}
