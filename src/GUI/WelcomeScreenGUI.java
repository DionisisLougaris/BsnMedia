package GUI;

import entities.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WelcomeScreenGUI extends JFrame{

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private Company theCompany;
	private JButton logInButton;
	private JButton forgotPasswordButton;
	private JButton newAccountButton;
	private JButton helpButton;
	private JPanel panel;
	
	public WelcomeScreenGUI(Company company) {
		theCompany = company;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBounds(100, 100, 909, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(442, 0, 449, 583);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setForeground(new Color(0, 51, 153));
		usernameField.setBackground(new Color(255, 153, 0));
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameField.setText("          Username...");
		usernameField.setBounds(134, 158, 179, 33);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 224, 179, 33);
		panel.add(passwordField);
		
		JButton logInButton = new JButton("Log In");
		
		logInButton.setBounds(183, 289, 97, 25);
		panel.add(logInButton);
		
		JButton forgotPasswordButton = new JButton("Forgot Password?");
		forgotPasswordButton.setForeground(new Color(0, 0, 0));
		forgotPasswordButton.setBackground(new Color(255, 153, 0));
		
		forgotPasswordButton.setBounds(144, 467, 194, 25);
		panel.add(forgotPasswordButton);
		
		JButton newAccountButton = new JButton("Create Account");
		newAccountButton.setBounds(169, 327, 132, 25);
		panel.add(newAccountButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.setBounds(340, 545, 97, 25);
		panel.add(helpButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to BSN Media!");
		lblNewLabel.setBounds(83, 47, 285, 27);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Keep Your Network Safe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(133, 87, 207, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		ButtonListener listener = new ButtonListener();
		logInButton.addActionListener(listener);
		newAccountButton.addActionListener(listener);
		forgotPasswordButton.addActionListener(listener);
		helpButton.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 600);
	}
	
	class ButtonListener implements ActionListener {
		
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource().equals(logInButton)) {
					
					String theUsername = usernameField.getText();
					char [] thePasswordArray = passwordField.getPassword();
					String thePassword = String.valueOf(thePasswordArray);
					
					System.out.println(theUsername+"  "+thePassword);
				}
			}
	}
}
