package GUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.User;

import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class NewMessagesGUI {

	private JFrame frmNewMessages;
	private User user;


	public NewMessagesGUI(User theUser) throws IOException {
		initialize(theUser);
	}

	private void initialize(User theUser) throws IOException {
		frmNewMessages = new JFrame();
		frmNewMessages.getContentPane().setBackground(new Color(255, 153, 102));
		frmNewMessages.setResizable(false);
		frmNewMessages.setTitle("New Messages");
		frmNewMessages.setBounds(1200, 88, 200, 244);
		frmNewMessages.getContentPane().setLayout(null);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/BSNlogo.jpg");
		frmNewMessages.setIconImage(logoimage.getImage());
		
		user = theUser;
		
		JList<String> list = new JList<String>();
		list.setBounds(10, 11, 172, 138);
		frmNewMessages.getContentPane().add(list);
		
		Icon open = new ImageIcon("Buttons_backgrounds/open_32px.png");
		JButton btnNewButton = new JButton(open);
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(70, 156, 53, 40);
		frmNewMessages.getContentPane().add(btnNewButton);
		frmNewMessages.setVisible(true);
	}
}
