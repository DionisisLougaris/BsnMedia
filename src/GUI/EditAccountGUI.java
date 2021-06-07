package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditAccountGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccountGUI window = new EditAccountGUI();
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
	public EditAccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 825);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(870, 200);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 116, 109);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Public Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(140, 13, 126, 33);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(315, 71, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 106, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Change Photo");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 126, 116, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 164, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(163, 199, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(163, 234, 116, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(163, 269, 116, 22);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(425, 164, 116, 22);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(425, 199, 116, 22);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(444, 268, 82, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(236, 74, 67, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(236, 112, 67, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(114, 167, 37, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telephone");
		lblNewLabel_4.setBounds(84, 202, 67, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(95, 237, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Speciality");
		lblNewLabel_6.setBounds(95, 272, 56, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(364, 167, 49, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Birthday");
		lblNewLabel_8.setBounds(364, 202, 49, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Private Info");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_9.setBounds(12, 330, 139, 33);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(163, 385, 116, 22);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(163, 420, 116, 22);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(163, 455, 116, 22);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(163, 490, 116, 22);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(334, 489, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("Username");
		lblNewLabel_10.setBounds(84, 388, 67, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Current Password");
		lblNewLabel_11.setBounds(47, 423, 104, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New Password");
		lblNewLabel_12.setBounds(59, 458, 92, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Confirm Password");
		lblNewLabel_13.setBounds(35, 493, 116, 16);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Account");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_14.setBounds(12, 553, 97, 33);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("No longer a part of \" \" ?");
		lblNewLabel_15.setBounds(12, 599, 529, 16);
		frame.getContentPane().add(lblNewLabel_15);
		
		textField_12 = new JTextField();
		textField_12.setBounds(163, 641, 116, 22);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(163, 679, 116, 22);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Deactivate my account");
		btnNewButton_3.setContentAreaFilled(false); 
		btnNewButton_3.setFocusPainted(false); 
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(299, 714, 174, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_16 = new JLabel("Password");
		lblNewLabel_16.setBounds(89, 644, 62, 16);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Confirm Password");
		lblNewLabel_17.setBounds(35, 682, 116, 16);
		frame.getContentPane().add(lblNewLabel_17);
		
	}
}
