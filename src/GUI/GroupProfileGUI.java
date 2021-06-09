package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Employee;
import entities.Group;
import entities.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JPanel;

public class GroupProfileGUI {

	private JFrame frame;
	private JTextField textField;
	private static User myUser;
	private static Group myGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupProfileGUI window = new GroupProfileGUI(myUser,myGroup);
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
	public GroupProfileGUI(User myUser,Group myGroup) {
		this.myUser = myUser;
		this.myGroup = myGroup;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(401, 33, 286, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(myGroup.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(38, 122, 274, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project in Progress:");
		lblNewLabel_1.setBounds(38, 220, 125, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project Status:");
		lblNewLabel_2.setBounds(38, 249, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Project Description:");
		lblNewLabel_3.setBounds(38, 278, 117, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Group Evaluation:");
		lblNewLabel_4.setBounds(38, 350, 117, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.WHITE);
		slider.setBounds(240, 350, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(myUser instanceof Boss)
				{
					int value = (int)slider.getValue();
					myGroup.setRating(value);
					System.out.println(myGroup.getRating());
					String message = "You have successfully rated "+myGroup.getName()+"!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					String message = "Only the boss can rate Groups...";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(452, 346, 86, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group");
		lblNewLabel_5.setBounds(38, 447, 115, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Posts of the Group");
		lblNewLabel_6.setBounds(323, 447, 117, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 492, 193, 306);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(322, 489, 507, 393);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("/100");
		lblNewLabel_7.setBackground(SystemColor.text);
		lblNewLabel_7.setBounds(185, 350, 48, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setText(myGroup.getMyProject().getName());
		lblNewLabel_8.setBounds(187, 220, 125, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setText(myGroup.getMyProject().getStatus());
		lblNewLabel_9.setBounds(185, 249, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setText(myGroup.getMyProject().getDescription());
		lblNewLabel_10.setBounds(187, 278, 507, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton_1_1 = new JButton("logo");
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setFocusPainted(false); 
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(myUser instanceof Chief)
				{
					BackendProfileChiefGUI myProfile = new BackendProfileChiefGUI(myUser);
				}
				else if(myUser instanceof Boss)
				{
					BackendProfileBossGUI myProfile = new BackendProfileBossGUI(myUser);
				}
				else if(myUser instanceof Employee)
				{
					BackendProfileEmployeeGUI myProfile = new BackendProfileEmployeeGUI(myUser);
				}
			}
		});
		btnNewButton_1_1.setBounds(38, 20, 62, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton_1 = new JButton(search);
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(696, 33, 55, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1_1 = new JButton(help);
		btnNewButton_1_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1_1.setFocusPainted(false); 
		btnNewButton_1_1_1.setOpaque(false);
		btnNewButton_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(817, 922, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1_1);
	}
}
