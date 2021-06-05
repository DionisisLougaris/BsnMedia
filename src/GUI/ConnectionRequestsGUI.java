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
import javax.swing.Icon;
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
		frmConnectionRequests.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 172, 145);
		frmConnectionRequests.getContentPane().add(list);
		
		Icon accept = new ImageIcon("Buttons_backgrounds/accept_32px.png");
		JButton btnNewButton_2 = new JButton(accept);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 165, 75, 36);
		frmConnectionRequests.getContentPane().add(btnNewButton_2);
		
		Icon decline = new ImageIcon("Buttons_backgrounds/decline_32px.png");
		JButton btnNewButton_2_1 = new JButton(decline);
		btnNewButton_2_1.setBounds(107, 165, 75, 36);
		frmConnectionRequests.getContentPane().add(btnNewButton_2_1);
		
		frmConnectionRequests.setVisible(true); //den anoige diaforetika
	}

}
