package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;

public class HelpGUI {

	private JFrame frame;
	private JTextField txtYourFullName;
	private JTextField txtYourEmail;
	private JTextField txtYourMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpGUI window = new HelpGUI();
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
	public HelpGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 410, 705);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Help");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(824, 929, 46, 38);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.setBounds(34, 26, 73, 65);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_13 = new JLabel("Frequently asked questions:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_13.setBounds(34, 144, 314, 27);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("1. Is Bsn Media accesible online?");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(34, 212, 213, 16);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Bsn Media is currently not accesible online and can be used localy from one computer.");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15.setBounds(44, 247, 265, 16);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14_1 = new JLabel("2. Who is the audience of Bsn Media?");
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1.setBounds(34, 298, 275, 16);
		panel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Bsn Media is addressed to companies with");
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1.setBounds(44, 340, 265, 16);
		panel.add(lblNewLabel_15_1);
		
		JLabel lblNewLabel_15_1_1 = new JLabel("a big social network!");
		lblNewLabel_15_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1.setBounds(44, 362, 265, 16);
		panel.add(lblNewLabel_15_1_1);
		
		JLabel lblNewLabel_14_1_1 = new JLabel("3. Can there be more than one Boss");
		lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1.setBounds(34, 406, 251, 16);
		panel.add(lblNewLabel_14_1_1);
		
		JLabel lblNewLabel_14_1_1_1 = new JLabel("on the Bsn Media network?");
		lblNewLabel_14_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1.setBounds(56, 427, 364, 16);
		panel.add(lblNewLabel_14_1_1_1);
		
		JLabel lblNewLabel_15_1_1_1 = new JLabel("Currently no.");
		lblNewLabel_15_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1_1.setBounds(44, 468, 265, 16);
		panel.add(lblNewLabel_15_1_1_1);
		
		JLabel lblNewLabel_14_1_1_2 = new JLabel("4. Can there be more than one Company");
		lblNewLabel_14_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_2.setBounds(34, 512, 291, 16);
		panel.add(lblNewLabel_14_1_1_2);
		
		JLabel lblNewLabel_14_1_1_1_1 = new JLabel("on the Bsn Media network?");
		lblNewLabel_14_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1_1.setBounds(56, 535, 364, 16);
		panel.add(lblNewLabel_14_1_1_1_1);
		
		JLabel lblNewLabel_15_1_1_1_1 = new JLabel("Currently no.");
		lblNewLabel_15_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1_1_1.setBounds(44, 571, 265, 16);
		panel.add(lblNewLabel_15_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(410, 0, 465, 705);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_13_1 = new JLabel("Send us a message!");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_13_1.setBounds(41, 143, 314, 27);
		panel_1.add(lblNewLabel_13_1);
		
		txtYourFullName = new JTextField();
		txtYourFullName.setText("Your full name...");
		txtYourFullName.setBounds(57, 230, 273, 36);
		panel_1.add(txtYourFullName);
		txtYourFullName.setColumns(10);
		
		txtYourEmail = new JTextField();
		txtYourEmail.setText("Your email...");
		txtYourEmail.setColumns(10);
		txtYourEmail.setBounds(57, 301, 273, 36);
		panel_1.add(txtYourEmail);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(0, 0, 1, 626);
		panel_1.add(verticalStrut);
		
		txtYourMessage = new JTextField();
		txtYourMessage.setText("Your message...");
		txtYourMessage.setColumns(10);
		txtYourMessage.setBounds(57, 386, 273, 100);
		panel_1.add(txtYourMessage);
		
		JLabel lblNewLabel_16 = new JLabel("Name");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(57, 207, 56, 16);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_16_1 = new JLabel("email");
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16_1.setBounds(57, 279, 56, 16);
		panel_1.add(lblNewLabel_16_1);
		
		JLabel lblNewLabel_17 = new JLabel("Message");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setBounds(57, 361, 73, 27);
		panel_1.add(lblNewLabel_17);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setBounds(243, 528, 97, 25);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(0, 704, 875, 269);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get in touch!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 60, 163, 27);
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Github icon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(39, 123, 37, 27);
		panel_2.add(btnNewButton);
		
		JButton btnLinkedinIcon = new JButton("LinkedIn icon");
		btnLinkedinIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLinkedinIcon.setBounds(107, 123, 37, 27);
		panel_2.add(btnLinkedinIcon);
		
		JButton btnGmailIcon = new JButton("Gmail icon");
		btnGmailIcon.setBounds(173, 123, 37, 27);
		panel_2.add(btnGmailIcon);
		
		JLabel lblNewLabel_1 = new JLabel("Creators:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(349, 41, 77, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kosmidou Eleni");
		lblNewLabel_2.setBounds(475, 42, 105, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kwnstantinidi Styliana");
		lblNewLabel_3.setBounds(475, 83, 134, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lougaris Dionisis");
		lblNewLabel_4.setBounds(475, 123, 105, 16);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mazaraki Eleni");
		lblNewLabel_5.setBounds(475, 163, 105, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Machairas Panagiotis");
		lblNewLabel_6.setBounds(475, 206, 134, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Melissanidou Kwnstantina");
		lblNewLabel_7.setBounds(621, 42, 146, 16);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mertzanhs Antwnhs");
		lblNewLabel_8.setBounds(621, 83, 117, 16);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nanou Eleftheria");
		lblNewLabel_9.setBounds(621, 128, 117, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stefou Giwrgos-Giannis");
		lblNewLabel_10.setBounds(621, 163, 134, 16);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Charakopoulos Minas-Theodoros");
		lblNewLabel_11.setBounds(625, 206, 222, 16);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\u00A9 Bsn Media 2021");
		lblNewLabel_12.setBounds(12, 240, 117, 16);
		panel_2.add(lblNewLabel_12);
		
		frame.setVisible(true); // den anoige diaforetika
	
	}
}
