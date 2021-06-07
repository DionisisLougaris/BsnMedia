package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class GroupChatGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupChatGUI window = new GroupChatGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GroupChatGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 685, 840);
		frame.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("Go to User Profile");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(522, 14, 133, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Your messages are encrypted");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 9, 215, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Group Conversation of \" \"");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(12, 46, 593, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(12, 84, 643, 652);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(12, 13, 619, 493);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(12, 519, 532, 120);
		panel.add(panel_2);
		
		Icon send = new ImageIcon("Buttons_backgrounds/email_send_32px.png");
		JButton btnNewButton_1_1_1 = new JButton(send);
		btnNewButton_1_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1_1.setFocusPainted(false); 
		btnNewButton_1_1_1.setOpaque(false);
		btnNewButton_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(572, 601, 46, 38);
		panel.add(btnNewButton_1_1_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setFocusPainted(false); 
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(609, 742, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1);
		
		Icon lock = new ImageIcon("label_backgrounds/lock_32px.png");
		JLabel lblNewLabel_2 = new JLabel(lock);
		lblNewLabel_2.setBounds(22, 14, 46, 38);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
