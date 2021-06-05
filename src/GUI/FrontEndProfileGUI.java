package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEndProfileGUI window = new FrontEndProfileGUI();
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
	public FrontEndProfileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(108, 75, 181, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(437, 38, 317, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton = new JButton(search);
		btnNewButton.setBounds(766, 28, 55, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(12, 13, 62, 53);
		panel.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 561, 810, 336);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Name LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(118, 240, 137, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Company Post, ");
		lblNewLabel_2.setBounds(286, 250, 89, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization");
		lblNewLabel_3.setBounds(387, 250, 78, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
		lblNewLabel_4.setBounds(130, 413, 125, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 287, 133, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Group A");
		lblNewLabel_6.setBounds(85, 317, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Group B");
		lblNewLabel_7.setBounds(153, 317, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Group C");
		lblNewLabel_8.setBounds(221, 317, 56, 16);
		panel.add(lblNewLabel_8);
		
		JButton buttonchat= new JButton("Chat");
		buttonchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//new PrivateChatGUI();// prepei na baloume twn xhrhsrh
			}
		});
		buttonchat.setBounds(479, 313, 62, 25);
		panel.add(buttonchat);
		
		JButton btnNewButton_3 = new JButton("Add connection");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(553, 313, 131, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remove connection");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(694, 313, 148, 25);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(74, 376, 84, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("69000000000");
		lblNewLabel_10.setBounds(131, 442, 78, 16);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Valtetsioy, 3");
		lblNewLabel_11.setBounds(131, 476, 78, 16);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("19/12/01");
		lblNewLabel_12.setBounds(130, 510, 56, 16);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Mutual connections");
		lblNewLabel_13.setBounds(712, 377, 109, 16);
		panel.add(lblNewLabel_13);
		
		JList list = new JList();
		list.setBounds(709, 409, 133, 127);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(821, 409, 21, 127);
		panel.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(814, 561, 28, 336);
		panel.add(scrollBar_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(824, 929, 46, 38);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_14 = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
		lblNewLabel_14.setBounds(85, 409, 28, 25);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
		lblNewLabel_14_1.setBounds(85, 438, 28, 25);
		panel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_14_2 = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
		lblNewLabel_14_2.setBounds(85, 467, 28, 25);
		panel.add(lblNewLabel_14_2);
		
		JLabel lblNewLabel_14_3 = new JLabel(new ImageIcon("label_backgrounds/birthday_cake_20px.png"));
		lblNewLabel_14_3.setBounds(85, 501, 28, 25);
		panel.add(lblNewLabel_14_3);
	}
}
