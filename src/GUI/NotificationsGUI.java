package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class NotificationsGUI {

	private JFrame frmNotifications;

	/**
	 * Launch the application.
	 */
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
	public NotificationsGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmNotifications = new JFrame();
		frmNotifications.setTitle("Notifications");
		frmNotifications.setResizable(false);
		frmNotifications.getContentPane().setBackground(new Color(255, 153, 102));
		frmNotifications.setBounds(100, 100, 200, 244);
		frmNotifications.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 174, 134);
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
