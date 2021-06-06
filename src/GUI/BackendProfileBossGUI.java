package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.*;
import java.awt.SystemColor;
import java.awt.Color;

public class BackendProfileBossGUI {

	private JFrame frame;
	private JTextField textField;
	private User boss;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackendProfileBossGUI window = new BackendProfileBossGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 * Create the application.
	 */
	public BackendProfileBossGUI(User theBoss) {
		boss = theBoss;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 887, 985);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(54, 56, 181, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		panel_1.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton = new JButton(search);
		//btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(623, 27, 46, 44);
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(427, 213, 424, 409);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Name LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(44, 243, 137, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(", Head of company ");
		lblNewLabel_2.setBounds(193, 253, 116, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
		lblNewLabel_4.setBounds(49, 286, 125, 16);
		panel.add(lblNewLabel_4);
		
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
		btnNewButton_1_1.setBounds(824, 929, 46, 38);
		panel.add(btnNewButton_1_1);

		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		JButton btnNewButton_1 = new JButton(friends);
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(714, 27, 37, 30);
		panel.add(btnNewButton_1);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/Messages_30px.png");
		JButton btnNewButton_1_2 = new JButton(messages);
		btnNewButton_1_2.setContentAreaFilled(false); 
		btnNewButton_1_2.setFocusPainted(false); 
		btnNewButton_1_2.setOpaque(false);
		btnNewButton_1_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2.setBounds(763, 27, 37, 30);
		panel.add(btnNewButton_1_2);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		JButton btnNewButton_1_3 = new JButton(bell);
		btnNewButton_1_3.setContentAreaFilled(false); 
		btnNewButton_1_3.setFocusPainted(false); 
		btnNewButton_1_3.setOpaque(false);
		btnNewButton_1_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_3.setBounds(814, 27, 37, 30);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_2 = new JButton("Edit Account Info");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(216, 294, 155, 25);
		panel.add(btnNewButton_2);
		
		JList list = new JList();
		list.setBackground(new Color(255, 250, 240));
		list.setBounds(44, 467, 116, 169);
		panel.add(list);
		
		JList list_1 = new JList();
		list_1.setBackground(new Color(255, 250, 240));
		list_1.setBounds(221, 467, 116, 169);
		panel.add(list_1);
		
		JLabel lblNewLabel_9 = new JLabel("Connections(0)");
		lblNewLabel_9.setBounds(49, 438, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(221, 438, 150, 16);
		panel.add(lblNewLabel_9_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(830, 213, 21, 409);
		panel.add(scrollBar);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 250, 240));
		textArea_1.setBounds(427, 651, 424, 49);
		panel.add(textArea_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Connections");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(503, 717, 112, 25);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Public");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(637, 717, 78, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.setContentAreaFilled(false); 
		btnNewButton_3.setFocusPainted(false); 
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnNewButton_3.setBounds(752, 717, 97, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Check profile");
		btnNewButton_4.setContentAreaFilled(false); 
		btnNewButton_4.setFocusPainted(false); 
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBounds(44, 649, 116, 25);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Send Message");
		btnNewButton_5.setContentAreaFilled(false); 
		btnNewButton_5.setFocusPainted(false); 
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBounds(44, 675, 116, 25);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Send request");
		btnNewButton_6.setContentAreaFilled(false); 
		btnNewButton_6.setFocusPainted(false); 
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setBounds(221, 649, 116, 25);
		panel.add(btnNewButton_6);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_50px.png");
		JButton btnNewButton_7 = new JButton(logout);
		btnNewButton_7.setContentAreaFilled(false); 
		btnNewButton_7.setFocusPainted(false); 
		btnNewButton_7.setOpaque(false);
		btnNewButton_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setBounds(793, 110, 56, 56);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_2_1 = new JButton("Edit Company Info");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setContentAreaFilled(false); 
		btnNewButton_2_1.setFocusPainted(false); 
		btnNewButton_2_1.setOpaque(false);
		btnNewButton_2_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2_1.setBounds(216, 332, 155, 25);
		panel.add(btnNewButton_2_1);

		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setColumns(10);
		textField.setBounds(332, 36, 279, 30);
		panel.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("logo");
		lblNewLabel_3.setBounds(12, 927, 56, 43);
		panel.add(lblNewLabel_3);
	}
}
