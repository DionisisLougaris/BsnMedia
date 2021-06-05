package GUI;

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

public class BackendProfileChiefGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private User chief;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackendProfileChiefGUI window = new BackendProfileChiefGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 * Create the application.
	 */
	public BackendProfileChiefGUI(User theChief) {
		chief = theChief;
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
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(49, 27, 181, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		panel_1.add(lblNewLabel);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton = new JButton(search);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(613, 13, 55, 44);
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(427, 171, 424, 409);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Name LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(59, 192, 137, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Company Post, ");
		lblNewLabel_2.setBounds(221, 202, 89, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization");
		lblNewLabel_3.setBounds(310, 202, 78, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
		lblNewLabel_4.setBounds(69, 221, 125, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(49, 285, 133, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Group A");
		lblNewLabel_6.setBounds(49, 314, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Group B");
		lblNewLabel_7.setBounds(114, 314, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Group C");
		lblNewLabel_8.setBounds(174, 314, 56, 16);
		panel.add(lblNewLabel_8);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(824, 929, 46, 38);
		panel.add(btnNewButton_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(333, 27, 268, 30);
		panel.add(textField_1);
		
		Icon friends = new ImageIcon("Buttons_backgrounds/friends_30px.png");
		JButton btnNewButton_1 = new JButton(friends);
		btnNewButton_1.setBounds(714, 27, 37, 30);
		panel.add(btnNewButton_1);
		
		Icon messages = new ImageIcon("Buttons_backgrounds/messages_Messages_30px.png");
		JButton btnNewButton_1_2 = new JButton(messages);
		btnNewButton_1_2.setBounds(763, 27, 37, 30);
		panel.add(btnNewButton_1_2);
		
		Icon bell = new ImageIcon("Buttons_backgrounds/bell_30px.png");
		JButton btnNewButton_1_3 = new JButton(bell);
		btnNewButton_1_3.setBounds(814, 27, 37, 30);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_2 = new JButton("Edit Account Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(216, 250, 155, 25);
		panel.add(btnNewButton_2);
		
		JList list = new JList();
		list.setBounds(44, 402, 116, 152);
		panel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(221, 402, 116, 152);
		panel.add(list_1);
		
		JLabel lblNewLabel_9 = new JLabel("Connections(0)");
		lblNewLabel_9.setBounds(49, 373, 99, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Suggested Connections");
		lblNewLabel_9_1.setBounds(221, 373, 139, 16);
		panel.add(lblNewLabel_9_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(830, 171, 21, 409);
		panel.add(scrollBar);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(427, 601, 424, 49);
		panel.add(textArea_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Connections");
		rdbtnNewRadioButton.setBounds(458, 675, 112, 25);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Public");
		rdbtnNewRadioButton_1.setBounds(574, 675, 78, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Group");
		rdbtnNewRadioButton_2.setBounds(651, 675, 89, 25);
		panel.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.setBounds(754, 675, 97, 25);
		panel.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(661, 709, 64, 25);
		panel.add(textField);
		
		JButton btnNewButton_4 = new JButton("Check profile");
		btnNewButton_4.setBounds(44, 567, 116, 25);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Send Message");
		btnNewButton_5.setBounds(44, 601, 116, 25);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Send request");
		btnNewButton_6.setBounds(221, 567, 116, 25);
		panel.add(btnNewButton_6);
		
		Icon logout = new ImageIcon("Buttons_backgrounds/exit_35px.png");
		JButton btnNewButton_7 = new JButton(logout);
		btnNewButton_7.setBounds(754, 98, 97, 25);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_2_1 = new JButton("Create Project");
		btnNewButton_2_1.setBounds(255, 310, 116, 25);
		panel.add(btnNewButton_2_1);
		
		Icon edit = new ImageIcon("Buttons_backgrounds/edit_20px.png");
		JButton btnNewButton_8 = new JButton(edit);
		btnNewButton_8.setBounds(59, 335, 27, 25);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_8_1 = new JButton(edit);
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_8_1.setBounds(124, 335, 27, 25);
		panel.add(btnNewButton_8_1);
		
		JButton btnNewButton_8_2 = new JButton(edit);
		btnNewButton_8_2.setBounds(184, 335, 27, 25);
		panel.add(btnNewButton_8_2);
		
		textField = new JTextField();
		textField.setBounds(661, 709, 63, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(326, 27, 268, 30);
		panel.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("logo");
		lblNewLabel_3_1.setBounds(12, 917, 56, 43);
		panel.add(lblNewLabel_3_1);
	}
}
