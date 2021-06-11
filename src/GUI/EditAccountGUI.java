package GUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Savepoint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Employee;
import entities.User;

public class EditAccountGUI {

	private JFrame frame;
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField telephoneField;
	private JTextField addressField;
	private JTextField specialityField;
	private JTextField genderField;
	private JTextField birthdayField;
	private JTextField usernameField;
	private JTextField currentPassField;
	private JTextField newPassField;
	private JTextField confirmPassField;
	private JTextField passAccountField;
	private JTextField confirmPassAccountField;
	private JTextField codeField;
	private JButton photoButton, publicDoneButton, privateDoneButton, deactivateButton, changeCodeButton; 
	
	private User user;
	private JFrame backendFrame;

	public EditAccountGUI(User theUser, JFrame frmStartingPage) {
		initialize(theUser, frmStartingPage);
		ButtonListener listener = new ButtonListener();
		photoButton.addActionListener(listener);
		privateDoneButton.addActionListener(listener);
		publicDoneButton.addActionListener(listener);
		deactivateButton.addActionListener(listener);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User theUser, JFrame frmStartingPage) {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 825);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(870, 200);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 116, 109);
		frame.getContentPane().add(panel);
		
		user = theUser;
		backendFrame = frmStartingPage;
		
		JLabel lblNewLabel = new JLabel("Public Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(140, 13, 126, 33);
		frame.getContentPane().add(lblNewLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(315, 71, 116, 22);
		frame.getContentPane().add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(315, 106, 116, 22);
		frame.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		photoButton = new JButton("Change Photo");
		photoButton.setContentAreaFilled(false); 
		photoButton.setFocusPainted(false); 
		photoButton.setOpaque(false);
		photoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		photoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		photoButton.setBounds(12, 126, 116, 25);
		frame.getContentPane().add(photoButton);
		
		emailField = new JTextField();
		emailField.setBounds(163, 164, 116, 22);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		telephoneField = new JTextField();
		telephoneField.setBounds(163, 199, 116, 22);
		frame.getContentPane().add(telephoneField);
		telephoneField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setBounds(163, 234, 116, 22);
		frame.getContentPane().add(addressField);
		addressField.setColumns(10);
		
		specialityField = new JTextField();
		specialityField.setBounds(163, 269, 116, 22);
		frame.getContentPane().add(specialityField);
		specialityField.setColumns(10);
		
		genderField = new JTextField();
		genderField.setBounds(425, 164, 116, 22);
		frame.getContentPane().add(genderField);
		genderField.setColumns(10);
		
		birthdayField = new JTextField();
		birthdayField.setBounds(425, 199, 116, 22);
		frame.getContentPane().add(birthdayField);
		birthdayField.setColumns(10);
		
		publicDoneButton = new JButton("Done");
		publicDoneButton.setContentAreaFilled(false); 
		publicDoneButton.setFocusPainted(false); 
		publicDoneButton.setOpaque(false);
		publicDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		publicDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		publicDoneButton.setBounds(444, 268, 82, 25);
		frame.getContentPane().add(publicDoneButton);
		
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
		
		usernameField = new JTextField();
		usernameField.setBounds(163, 385, 116, 22);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		currentPassField = new JTextField();
		currentPassField.setBounds(163, 420, 116, 22);
		frame.getContentPane().add(currentPassField);
		currentPassField.setColumns(10);
		
		newPassField = new JTextField();
		newPassField.setBounds(163, 455, 116, 22);
		frame.getContentPane().add(newPassField);
		newPassField.setColumns(10);
		
		confirmPassField = new JTextField();
		confirmPassField.setBounds(163, 490, 116, 22);
		frame.getContentPane().add(confirmPassField);
		confirmPassField.setColumns(10);
		
		privateDoneButton = new JButton("Done");
		privateDoneButton.setContentAreaFilled(false); 
		privateDoneButton.setFocusPainted(false); 
		privateDoneButton.setOpaque(false);
		privateDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		privateDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		privateDoneButton.setBounds(334, 489, 97, 25);
		frame.getContentPane().add(privateDoneButton);
		
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
		
		JPanel accountPanel = new JPanel();
		accountPanel.setBounds(12, 553, 529, 186);
		frame.getContentPane().add(accountPanel);
		accountPanel.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Account");
		lblNewLabel_14.setBounds(0, 0, 267, 33);
		accountPanel.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_15 = new JLabel("No longer a part of " + user.getMyAccount().getMyCompany().getName() + "?");
		lblNewLabel_15.setBounds(0, 46, 529, 16);
		accountPanel.add(lblNewLabel_15);
		
		passAccountField = new JTextField();
		passAccountField.setBounds(151, 88, 116, 22);
		accountPanel.add(passAccountField);
		passAccountField.setColumns(10);
		
		confirmPassAccountField = new JTextField();
		confirmPassAccountField.setBounds(151, 126, 116, 22);
		accountPanel.add(confirmPassAccountField);
		confirmPassAccountField.setColumns(10);
		
		deactivateButton = new JButton("Deactivate my account");
		deactivateButton.setBounds(287, 161, 174, 25);
		accountPanel.add(deactivateButton);
		deactivateButton.setContentAreaFilled(false); 
		deactivateButton.setFocusPainted(false); 
		deactivateButton.setOpaque(false);
		deactivateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_16 = new JLabel("Password");
		lblNewLabel_16.setBounds(77, 91, 62, 16);
		accountPanel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Confirm Password");
		lblNewLabel_17.setBounds(23, 129, 116, 16);
		accountPanel.add(lblNewLabel_17);
		deactivateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel companyPanel = new JPanel();
		companyPanel.setBounds(12, 553, 529, 186);
		frame.getContentPane().add(companyPanel);
		companyPanel.setLayout(null);
		
		JLabel lblNewLabel_141 = new JLabel("Change Company Verification Code");
		lblNewLabel_141.setBounds(0, 0, 97, 33);
		companyPanel.add(lblNewLabel_141);
		lblNewLabel_141.setFont(new Font("Tahoma", Font.PLAIN, 22));

		codeField = new JTextField();
		codeField.setBounds(151, 88, 116, 22);
		companyPanel.add(codeField);
		codeField.setColumns(10);

		changeCodeButton = new JButton("Save");
		changeCodeButton.setBounds(287, 161, 174, 25);
		companyPanel.add(changeCodeButton);
		changeCodeButton.setContentAreaFilled(false); 
		changeCodeButton.setFocusPainted(false); 
		changeCodeButton.setOpaque(false);
		changeCodeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		if(user instanceof Employee || user instanceof Chief) {
			accountPanel.setVisible(true);
			companyPanel.setVisible(false);
		}
		else if(user instanceof Boss) {
			accountPanel.setVisible(false);
			companyPanel.setVisible(true);
		}
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(photoButton)) {
				user.changeUsersPhoto(null); //den kserw ti na valw gia parametro
			}
			else if(e.getSource().equals(publicDoneButton)) {
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String email = emailField.getText();
				String telephone = telephoneField.getText();
				String address = addressField.getText();
				String speciality = specialityField.getText();
				String gender = genderField.getText();
				String birthday = birthdayField.getText();
				user.editPublicInfo(firstName, lastName, email, telephone, address, speciality, gender, birthday);
				
				if(user instanceof Employee) {
					try {
						new BackendProfileEmployeeGUI(user);
						backendFrame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if(user instanceof Chief) {
					try {
						new  BackendProfileChiefGUI(user);
						backendFrame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if(user instanceof Boss) {
					try {
						new BackendProfileBossGUI(user);
						backendFrame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			else if(e.getSource().equals(privateDoneButton)) {
				String username = usernameField.getText();
				String currPassword = currentPassField.getText();
				String newPassword = newPassField.getText();
				String confirmedPassword = confirmPassField.getText();
				
				user.editPrivateInfo(username, currPassword, newPassword, confirmedPassword);
			}
			else if(e.getSource().equals(deactivateButton)) {
				String password = passAccountField.getText();
				String confirmPass = confirmPassAccountField.getText();
				
				user.getMyAccount().deleteAccount(password, confirmPass, user);
			}
			else if(e.getSource().equals(changeCodeButton)) {
				String code = codeField.getText();
				
				((Boss)user).changeVerificationCode(code);
			}
		
	}
}
}
