package GUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewMessagesGUI {

	private JFrame frmNewMessages;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMessagesGUI window = new NewMessagesGUI();
					window.frmNewMessages.setVisible(true);
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
	public NewMessagesGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmNewMessages = new JFrame();
		frmNewMessages.getContentPane().setBackground(new Color(255, 153, 102));
		frmNewMessages.setResizable(false);
		frmNewMessages.setTitle("New Messages");
		frmNewMessages.setBounds(100, 100, 200, 244);
		frmNewMessages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewMessages.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 163, 147);
		frmNewMessages.getContentPane().add(list);
		
		BufferedImage buttonIcon = ImageIO.read(new File("Buttons_backgrounds/open_in_popup_48px.png"));
		JButton btnNewButton = new JButton(new ImageIcon(buttonIcon));
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("All good");
			}
		});
		btnNewButton.setBounds(66, 162, 41, 42);
		frmNewMessages.getContentPane().add(btnNewButton);
		frmNewMessages.setVisible(true);
	}
}
