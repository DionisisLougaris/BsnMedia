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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

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
		frmNotifications.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNotifications.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 163, 147);
		frmNotifications.getContentPane().add(list);
		
		BufferedImage buttonIcon = ImageIO.read(new File("Buttons_backgrounds/search_property_32px.png"));
		JButton btnNewButton = new JButton(new ImageIcon(buttonIcon));
		btnNewButton.setBounds(142, 158, 42, 36);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setContentAreaFilled(false);
		frmNotifications.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("All good");
			}
		});
		frmNotifications.setVisible(true); //den anoige diaforetika
	}

}
