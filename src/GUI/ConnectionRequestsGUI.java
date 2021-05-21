package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConnectionRequestsGUI {

	private JFrame frmConnectionRequests;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionRequestsGUI window = new ConnectionRequestsGUI();
					window.frmConnectionRequests.setVisible(true);
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
	public ConnectionRequestsGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmConnectionRequests = new JFrame();
		frmConnectionRequests.setResizable(false);
		frmConnectionRequests.setTitle("Connection Requests");
		frmConnectionRequests.getContentPane().setBackground(new Color(255, 153, 102));
		frmConnectionRequests.setBounds(100, 100, 200, 244);
		frmConnectionRequests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnectionRequests.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 163, 147);
		frmConnectionRequests.getContentPane().add(list);
		
		BufferedImage buttonIcon1 = ImageIO.read(new File("C:\\Users\\Μηνας\\Documents\\BsnMedia\\Buttons_backgrounds\\ok_48px.png"));
		JButton btnNewButton = new JButton(new ImageIcon(buttonIcon1));
		btnNewButton.setBounds(41, 160, 39, 34);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setContentAreaFilled(false);
		frmConnectionRequests.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("All good");
			}
		});
		
		BufferedImage buttonIcon2 = ImageIO.read(new File("C:\\Users\\Μηνας\\Documents\\BsnMedia\\Buttons_backgrounds\\cancel_48px.png"));
		JButton btnNewButton_1 = new JButton(new ImageIcon(buttonIcon2));
		btnNewButton_1.setBounds(105, 160, 39, 34);
		btnNewButton_1.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_1.setContentAreaFilled(false);
		frmConnectionRequests.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("And there all good");
			}
		});
	}

}
