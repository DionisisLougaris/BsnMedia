package GUI;

import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Savepoint;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Employee;
import entities.User;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextPane;

public class EditAccountGUI {

	private JFrame frmEdiwYourAccount;
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField telephoneField;
	private JTextField addressField;
	private JTextField specialityField;
	private JTextField genderField;
	private JTextField birthdayField;
	private JTextField usernameField;
	private JPasswordField currentPassField;
	private JPasswordField newPassField;
	private JPasswordField confirmPassField;
	private JPasswordField passAccountField;
	private JPasswordField confirmPassAccountField;
	private JTextField codeField;
	private JButton photoFChangeButton, publicDoneButton, privateDoneButton, deactivateButton, changeCodeButton; 
	
	private User user;
	private JFrame backendFrame;

	public EditAccountGUI(User theUser, JFrame frmStartingPage) {
		initialize(theUser, frmStartingPage);
	}

	private void initialize(User theUser, JFrame frmStartingPage) {
		frmEdiwYourAccount = new JFrame();
		frmEdiwYourAccount.getContentPane().setForeground(new Color(255, 255, 255));
		frmEdiwYourAccount.setTitle("Edit your Account");
		frmEdiwYourAccount.getContentPane().setBackground(new Color(255, 153, 102));
		frmEdiwYourAccount.setBounds(100, 100, 574, 825);
		frmEdiwYourAccount.getContentPane().setLayout(null);
		frmEdiwYourAccount.setVisible(true);
		frmEdiwYourAccount.setResizable(false);
		frmEdiwYourAccount.setLocation(870, 200);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 116, 109);
		frmEdiwYourAccount.getContentPane().add(panel);
		panel.setLayout(null);
		
		user = theUser;
		backendFrame = frmStartingPage;
		
		JLabel UserPhotoLabel = new JLabel();
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(theUser.getImage()));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(110, 100, 140) ;
			UserPhotoLabel.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserPhotoLabel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		UserPhotoLabel.setBounds(0, 0, 116, 109);
		panel.add(UserPhotoLabel);
		
		JLabel lblNewLabel = new JLabel("Public Info");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel.setBounds(140, 13, 126, 33);
		frmEdiwYourAccount.getContentPane().add(lblNewLabel);
		
		firstNameField = new JTextField(user.getFirstName());
		firstNameField.setBorder(null);
		firstNameField.setBackground(new Color(255, 153, 102));
		firstNameField.setForeground(new Color(255, 255, 255));
		firstNameField.setBounds(283, 162, 115, 16);
		frmEdiwYourAccount.getContentPane().add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField(user.getLastName());
		lastNameField.setBorder(null);
		lastNameField.setBackground(new Color(255, 153, 102));
		lastNameField.setForeground(new Color(255, 255, 255));
		lastNameField.setBounds(283, 199, 109, 16);
		frmEdiwYourAccount.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		photoFChangeButton = new JButton("Change Photo");
		photoFChangeButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		photoFChangeButton.setForeground(new Color(255, 255, 255));
		photoFChangeButton.setContentAreaFilled(false); 
		photoFChangeButton.setFocusPainted(false); 
		photoFChangeButton.setOpaque(false);
		photoFChangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		photoFChangeButton.setBounds(18, 126, 104, 25);
		frmEdiwYourAccount.getContentPane().add(photoFChangeButton);
		
		emailField = new JTextField(user.getMyAccount().getEmail());
		emailField.setBorder(null);
		emailField.setBackground(new Color(255, 153, 102));
		emailField.setForeground(new Color(255, 255, 255));
		emailField.setBounds(59, 162, 135, 16);
		frmEdiwYourAccount.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		telephoneField = new JTextField(user.getTelephone());
		telephoneField.setBorder(null);
		telephoneField.setBackground(new Color(255, 153, 102));
		telephoneField.setForeground(new Color(255, 255, 255));
		telephoneField.setBounds(78, 202, 116, 16);
		frmEdiwYourAccount.getContentPane().add(telephoneField);
		telephoneField.setColumns(10);
		
		addressField = new JTextField(user.getAddress());
		addressField.setBorder(null);
		addressField.setBackground(new Color(255, 153, 102));
		addressField.setForeground(new Color(255, 255, 255));
		addressField.setBounds(65, 245, 129, 16);
		frmEdiwYourAccount.getContentPane().add(addressField);
		addressField.setColumns(10);
		
		specialityField = new JTextField(user.getCompanyPost());
		specialityField.setBorder(null);
		specialityField.setBackground(new Color(255, 153, 102));
		specialityField.setForeground(new Color(255, 255, 255));
		specialityField.setBounds(78, 282, 116, 16);
		frmEdiwYourAccount.getContentPane().add(specialityField);
		specialityField.setColumns(10);
		
		genderField = new JTextField(user.getGender());
		genderField.setBorder(null);
		genderField.setBackground(new Color(255, 153, 102));
		genderField.setForeground(new Color(255, 255, 255));
		genderField.setBounds(264, 242, 116, 16);
		frmEdiwYourAccount.getContentPane().add(genderField);
		genderField.setColumns(10);
		
		birthdayField = new JTextField(user.getBirthday());
		birthdayField.setBorder(null);
		birthdayField.setBackground(new Color(255, 153, 102));
		birthdayField.setForeground(new Color(255, 255, 255));
		birthdayField.setBounds(276, 282, 116, 16);
		frmEdiwYourAccount.getContentPane().add(birthdayField);
		birthdayField.setColumns(10);
		
		publicDoneButton = new JButton("Done");
		publicDoneButton.setForeground(new Color(255, 255, 255));
		publicDoneButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		publicDoneButton.setContentAreaFilled(false); 
		publicDoneButton.setFocusPainted(false); 
		publicDoneButton.setOpaque(false);
		publicDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		publicDoneButton.setBounds(459, 287, 82, 25);
		frmEdiwYourAccount.getContentPane().add(publicDoneButton);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setBounds(217, 165, 67, 16);
		frmEdiwYourAccount.getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setForeground(new Color(255, 255, 255));
		lastNameLabel.setBounds(217, 205, 67, 16);
		frmEdiwYourAccount.getContentPane().add(lastNameLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setForeground(new Color(255, 255, 255));
		emailLabel.setBounds(12, 165, 43, 16);
		frmEdiwYourAccount.getContentPane().add(emailLabel);
		
		JLabel telephoneLabel = new JLabel("Telephone:");
		telephoneLabel.setForeground(new Color(255, 255, 255));
		telephoneLabel.setBounds(12, 205, 67, 16);
		frmEdiwYourAccount.getContentPane().add(telephoneLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setForeground(new Color(255, 255, 255));
		addressLabel.setBounds(12, 245, 56, 16);
		frmEdiwYourAccount.getContentPane().add(addressLabel);
		
		JLabel specialityLabel = new JLabel("Speciality:");
		specialityLabel.setForeground(new Color(255, 255, 255));
		specialityLabel.setBounds(12, 285, 67, 16);
		frmEdiwYourAccount.getContentPane().add(specialityLabel);
		
		JLabel genderLabel = new JLabel("Gender:");
		genderLabel.setForeground(new Color(255, 255, 255));
		genderLabel.setBounds(217, 245, 49, 16);
		frmEdiwYourAccount.getContentPane().add(genderLabel);
		
		JLabel birthLabel = new JLabel("Birthday:");
		birthLabel.setForeground(new Color(255, 255, 255));
		birthLabel.setBounds(217, 285, 56, 16);
		frmEdiwYourAccount.getContentPane().add(birthLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Private Info");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_9.setBounds(12, 330, 139, 33);
		frmEdiwYourAccount.getContentPane().add(lblNewLabel_9);
		
		usernameField = new JTextField(user.getMyAccount().getUsername());
		usernameField.setForeground(new Color(255, 255, 255));
		usernameField.setBackground(new Color(255, 153, 102));
		usernameField.setBorder(null);
		usernameField.setBounds(78, 387, 148, 16);
		frmEdiwYourAccount.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		currentPassField = new JPasswordField();
		currentPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		currentPassField.setForeground(new Color(255, 255, 255));
		currentPassField.setBackground(new Color(255, 153, 102));
		currentPassField.setBorder(null);
		currentPassField.setBounds(110, 421, 116, 16);
		frmEdiwYourAccount.getContentPane().add(currentPassField);
		currentPassField.setColumns(10);
		
		newPassField = new JPasswordField();
		newPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		newPassField.setForeground(new Color(255, 255, 255));
		newPassField.setBorder(null);
		newPassField.setBackground(new Color(255, 153, 102));
		newPassField.setBounds(94, 456, 132, 16);
		frmEdiwYourAccount.getContentPane().add(newPassField);
		newPassField.setColumns(10);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmPassField.setForeground(new Color(255, 255, 255));
		confirmPassField.setBackground(new Color(255, 153, 102));
		confirmPassField.setBorder(null);
		confirmPassField.setBounds(110, 491, 116, 16);
		frmEdiwYourAccount.getContentPane().add(confirmPassField);
		confirmPassField.setColumns(10);
		
		privateDoneButton = new JButton("Done");
		privateDoneButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		privateDoneButton.setForeground(new Color(255, 255, 255));
		privateDoneButton.setContentAreaFilled(false); 
		privateDoneButton.setFocusPainted(false); 
		privateDoneButton.setOpaque(false);
		privateDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		privateDoneButton.setBounds(459, 488, 82, 25);
		frmEdiwYourAccount.getContentPane().add(privateDoneButton);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setBounds(12, 388, 67, 16);
		frmEdiwYourAccount.getContentPane().add(usernameLabel);
		
		JLabel currPassLabel = new JLabel("Current Password:");
		currPassLabel.setForeground(new Color(255, 255, 255));
		currPassLabel.setBounds(12, 423, 104, 16);
		frmEdiwYourAccount.getContentPane().add(currPassLabel);
		
		JLabel newPassLabel = new JLabel("New Password:");
		newPassLabel.setForeground(new Color(255, 255, 255));
		newPassLabel.setBounds(12, 458, 87, 16);
		frmEdiwYourAccount.getContentPane().add(newPassLabel);
		
		JLabel confirmPassLabel = new JLabel("Confirm Password:");
		confirmPassLabel.setForeground(new Color(255, 255, 255));
		confirmPassLabel.setBounds(12, 493, 104, 16);
		frmEdiwYourAccount.getContentPane().add(confirmPassLabel);
		
		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(new Color(255, 102, 51));
		accountPanel.setBounds(12, 553, 529, 186);
		frmEdiwYourAccount.getContentPane().add(accountPanel);
		accountPanel.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Account");
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setBounds(0, 0, 267, 33);
		accountPanel.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_15 = new JLabel("No longer a part of " + user.getMyAccount().getMyCompany().getName() + "?");
		lblNewLabel_15.setForeground(new Color(255, 255, 255));
		lblNewLabel_15.setBackground(new Color(255, 255, 255));
		lblNewLabel_15.setBounds(0, 46, 529, 16);
		accountPanel.add(lblNewLabel_15);
		
		passAccountField = new JPasswordField();
		passAccountField.setForeground(new Color(255, 255, 255));
		passAccountField.setBackground(new Color(255, 102, 51));
		passAccountField.setBorder(null);
		passAccountField.setBounds(86, 89, 116, 16);
		accountPanel.add(passAccountField);
		passAccountField.setColumns(10);
		
		confirmPassAccountField = new JPasswordField();
		confirmPassAccountField.setForeground(new Color(255, 255, 255));
		confirmPassAccountField.setBorder(null);
		confirmPassAccountField.setBackground(new Color(255, 102, 51));
		confirmPassAccountField.setBounds(128, 116, 116, 16);
		accountPanel.add(confirmPassAccountField);
		confirmPassAccountField.setColumns(10);
		
		deactivateButton = new JButton("Deactivate my account");
		deactivateButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		deactivateButton.setBackground(new Color(255, 255, 255));
		deactivateButton.setForeground(new Color(255, 255, 255));
		deactivateButton.setBounds(345, 150, 174, 25);
		accountPanel.add(deactivateButton);
		deactivateButton.setContentAreaFilled(false); 
		deactivateButton.setFocusPainted(false); 
		deactivateButton.setOpaque(false);
		deactivateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_16 = new JLabel("Password:");
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(25, 91, 55, 16);
		accountPanel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Confirm Password:");
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(25, 117, 103, 16);
		accountPanel.add(lblNewLabel_17);
		
		JSeparator separator_2_1_2_3_2 = new JSeparator();
		separator_2_1_2_3_2.setForeground(Color.WHITE);
		separator_2_1_2_3_2.setBounds(128, 132, 116, 14);
		accountPanel.add(separator_2_1_2_3_2);
		
		JSeparator separator_2_1_2_3_2_1 = new JSeparator();
		separator_2_1_2_3_2_1.setForeground(Color.WHITE);
		separator_2_1_2_3_2_1.setBounds(86, 107, 116, 14);
		accountPanel.add(separator_2_1_2_3_2_1);
		
		JPanel companyPanel = new JPanel();
		companyPanel.setBackground(new Color(255, 102, 51));
		companyPanel.setBounds(12, 553, 529, 186);
		frmEdiwYourAccount.getContentPane().add(companyPanel);
		companyPanel.setLayout(null);
		
		JLabel lblNewLabel_141 = new JLabel("Change Company Verification Code");
		lblNewLabel_141.setForeground(new Color(255, 255, 255));
		lblNewLabel_141.setBounds(0, 0, 519, 33);
		companyPanel.add(lblNewLabel_141);
		lblNewLabel_141.setFont(new Font("Tahoma", Font.ITALIC, 22));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(170, 117, 150, 16);
		companyPanel.add(separator_3);
		
		JLabel lblNewLabel_1 = new JLabel("New Company Code:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(47, 95, 125, 22);
		companyPanel.add(lblNewLabel_1);

		codeField = new JTextField();
		codeField.setToolTipText("");
		codeField.setBorder(null);
		codeField.setBackground(new Color(255, 102, 51));
		codeField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		codeField.setForeground(new Color(255, 255, 255));
		codeField.setBounds(170, 95, 150, 22);
		companyPanel.add(codeField);
		codeField.setColumns(10);

		changeCodeButton = new JButton("Save");
		changeCodeButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		changeCodeButton.setForeground(new Color(255, 255, 255));
		changeCodeButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		changeCodeButton.setBackground(new Color(255, 102, 0));
		changeCodeButton.setBounds(340, 150, 103, 25);
		companyPanel.add(changeCodeButton);
		changeCodeButton.setContentAreaFilled(false); 
		changeCodeButton.setFocusPainted(false); 
		changeCodeButton.setOpaque(false);
		changeCodeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 317, 568, 16);
		frmEdiwYourAccount.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(0, 525, 568, 16);
		frmEdiwYourAccount.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBounds(47, 178, 147, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.WHITE);
		separator_2_1.setBounds(66, 220, 128, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setForeground(Color.WHITE);
		separator_2_1_1.setBounds(59, 261, 135, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setForeground(Color.WHITE);
		separator_2_1_1_1.setBounds(78, 298, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_1_1);
		
		JSeparator separator_2_1_2 = new JSeparator();
		separator_2_1_2.setForeground(Color.WHITE);
		separator_2_1_2.setBounds(283, 178, 115, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2);
		
		JSeparator separator_2_1_2_1 = new JSeparator();
		separator_2_1_2_1.setForeground(Color.WHITE);
		separator_2_1_2_1.setBounds(283, 217, 115, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_1);
		
		JSeparator separator_2_1_2_2 = new JSeparator();
		separator_2_1_2_2.setForeground(Color.WHITE);
		separator_2_1_2_2.setBounds(264, 260, 134, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_2);
		
		JSeparator separator_2_1_2_3 = new JSeparator();
		separator_2_1_2_3.setForeground(Color.WHITE);
		separator_2_1_2_3.setBounds(264, 298, 128, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_3);
		
		JSeparator separator_2_1_2_2_1 = new JSeparator();
		separator_2_1_2_2_1.setForeground(Color.WHITE);
		separator_2_1_2_2_1.setBounds(78, 404, 148, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_2_1);
		
		JSeparator separator_2_1_2_3_1 = new JSeparator();
		separator_2_1_2_3_1.setForeground(Color.WHITE);
		separator_2_1_2_3_1.setBounds(110, 437, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_3_1);
		
		JSeparator separator_2_1_2_3_1_1 = new JSeparator();
		separator_2_1_2_3_1_1.setForeground(Color.WHITE);
		separator_2_1_2_3_1_1.setBounds(93, 472, 133, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_3_1_1);
		
		JSeparator separator_2_1_2_3_1_2 = new JSeparator();
		separator_2_1_2_3_1_2.setForeground(Color.WHITE);
		separator_2_1_2_3_1_2.setBounds(110, 507, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separator_2_1_2_3_1_2);
		
		JLabel lblNewLabel_19 = new JLabel("Remember!");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setBounds(341, 369, 116, 25);
		frmEdiwYourAccount.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Your Password stored Encrypted!");
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_20.setBounds(283, 389, 243, 25);
		frmEdiwYourAccount.getContentPane().add(lblNewLabel_20);
		
		JLabel encryptedPasswordPhoto = new JLabel();
		encryptedPasswordPhoto.setIcon(new ImageIcon("label_backgrounds/encrypt_67px.png"));
		encryptedPasswordPhoto.setBounds(354, 421, 67, 65);
		frmEdiwYourAccount.getContentPane().add(encryptedPasswordPhoto);
		
		if(user instanceof Employee || user instanceof Chief) {
			accountPanel.setVisible(true);
			companyPanel.setVisible(false);
		}
		else if(user instanceof Boss) {
			accountPanel.setVisible(false);
			companyPanel.setVisible(true);
		}
		
		ButtonListener listener = new ButtonListener();
		photoFChangeButton.addActionListener(listener);
		privateDoneButton.addActionListener(listener);
		publicDoneButton.addActionListener(listener);
		deactivateButton.addActionListener(listener);
		changeCodeButton.addActionListener(listener);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(photoFChangeButton)) {
				
			    FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
			    dialog.setMode(FileDialog.LOAD);
			    dialog.setVisible(true);
			    String path = dialog.getDirectory() + dialog.getFile();
			    
			    if (dialog.getDirectory() != null && dialog.getFile() != null) {
			    	
			    	String extension = path.substring(path.length() - 3);
			    	
			    	if (extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg")) {
				    user.setImage(path);
				    
					String message = "Successful change! Your photo will be visible on the next login!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
			    	}else {
						String message = "You can only select \".jpg or .png\" files!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
			    	}
			    }
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
				
				if (user.editPublicInfo(firstName, lastName, email, telephone, address, speciality, gender, birthday)) {
					String message = "All fields were updated successfully!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
				}else {
					String message = "There are fields that could not be changed"+"\n"+"(If you do not modify them again, they will remain the same!)";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
				
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
				frmEdiwYourAccount.dispose();
			}
			else if(e.getSource().equals(privateDoneButton)) {
				String username = usernameField.getText();
				
				char [] passwordCharArray = currentPassField.getPassword();
				String currPassword = String.valueOf(passwordCharArray);
				
				char [] passwordCharArray2 = newPassField.getPassword();
				String newPassword = String.valueOf(passwordCharArray2);
				
				char [] passwordCharArray3 = confirmPassField.getPassword();
				String confirmedPassword = String.valueOf(passwordCharArray3);
				
				user.editPrivateInfo(username, currPassword, newPassword, confirmedPassword);	
			}
			else if(e.getSource().equals(deactivateButton)) {
				
				char [] passwordCharArray4 = passAccountField.getPassword();
				String password = String.valueOf(passwordCharArray4);
				
				char [] passwordCharArray5 = confirmPassAccountField.getPassword();
				String confirmPass = String.valueOf(passwordCharArray5);
				
				if (user.getMyAccount().deleteAccount(password, confirmPass, user)) {
					frmEdiwYourAccount.dispose();
					backendFrame.dispose();
					try {
						new WelcomeScreen_GUI(user.getMyAccount().getMyCompany());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else if(e.getSource().equals(changeCodeButton)) {
				String code = codeField.getText();
				
				((Boss)user).changeVerificationCode(code);
			}
		}
		
	}
}
