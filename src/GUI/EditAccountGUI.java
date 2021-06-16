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

	//This method is the constructor of class  EditAccountGUI.
	public EditAccountGUI(User theUser, JFrame frmStartingPage) {
		initialize(theUser, frmStartingPage);
	}

	//This method initialize the properties of this gui.
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
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmEdiwYourAccount.setIconImage(logoimage.getImage());
		
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
		
		JLabel lblPublicInfo = new JLabel("Public Info");
		lblPublicInfo.setForeground(new Color(255, 255, 255));
		lblPublicInfo.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblPublicInfo.setBounds(140, 13, 126, 33);
		frmEdiwYourAccount.getContentPane().add(lblPublicInfo);
		
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
		lastNameField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(lastNameField);
		
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
		telephoneField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(telephoneField);
		
		addressField = new JTextField(user.getAddress());
		addressField.setBorder(null);
		addressField.setBackground(new Color(255, 153, 102));
		addressField.setForeground(new Color(255, 255, 255));
		addressField.setBounds(65, 245, 129, 16);
		addressField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(addressField);
		
		specialityField = new JTextField(user.getCompanyPost());
		specialityField.setBorder(null);
		specialityField.setBackground(new Color(255, 153, 102));
		specialityField.setForeground(new Color(255, 255, 255));
		specialityField.setBounds(78, 282, 116, 16);
		specialityField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(specialityField);
		
		
		genderField = new JTextField(user.getGender());
		genderField.setBorder(null);
		genderField.setBackground(new Color(255, 153, 102));
		genderField.setForeground(new Color(255, 255, 255));
		genderField.setBounds(264, 242, 116, 16);
		genderField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(genderField);
		
		
		birthdayField = new JTextField(user.getBirthday());
		birthdayField.setBorder(null);
		birthdayField.setBackground(new Color(255, 153, 102));
		birthdayField.setForeground(new Color(255, 255, 255));
		birthdayField.setBounds(276, 282, 116, 16);
		birthdayField.setColumns(10);
		frmEdiwYourAccount.getContentPane().add(birthdayField);
		
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
		
		JLabel lblPrivateInfo = new JLabel("Private Info");
		lblPrivateInfo.setForeground(new Color(255, 255, 255));
		lblPrivateInfo.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblPrivateInfo.setBounds(12, 330, 139, 33);
		frmEdiwYourAccount.getContentPane().add(lblPrivateInfo);
		
		usernameField = new JTextField(user.getMyAccount().getUsername());
		usernameField.setEditable(false);
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
		accountPanel.setLayout(null);
		frmEdiwYourAccount.getContentPane().add(accountPanel);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setForeground(new Color(255, 255, 255));
		lblAccount.setBounds(0, 0, 267, 33);
		accountPanel.add(lblAccount);
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblncAccount = new JLabel("No longer a part of " + user.getMyAccount().getMyCompany().getName() + "?");
		lblncAccount.setForeground(new Color(255, 255, 255));
		lblncAccount.setBackground(new Color(255, 255, 255));
		lblncAccount.setBounds(0, 46, 529, 16);
		accountPanel.add(lblncAccount);
		
		passAccountField = new JPasswordField();
		passAccountField.setForeground(new Color(255, 255, 255));
		passAccountField.setBackground(new Color(255, 102, 51));
		passAccountField.setBorder(null);
		passAccountField.setBounds(86, 89, 116, 16);
		passAccountField.setColumns(10);
		accountPanel.add(passAccountField);
		
		
		confirmPassAccountField = new JPasswordField();
		confirmPassAccountField.setForeground(new Color(255, 255, 255));
		confirmPassAccountField.setBorder(null);
		confirmPassAccountField.setBackground(new Color(255, 102, 51));
		confirmPassAccountField.setBounds(128, 116, 116, 16);
		confirmPassAccountField.setColumns(10);
		accountPanel.add(confirmPassAccountField);
	
		deactivateButton = new JButton("Deactivate my account");
		deactivateButton.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		deactivateButton.setBackground(new Color(255, 255, 255));
		deactivateButton.setForeground(new Color(255, 255, 255));
		deactivateButton.setBounds(345, 150, 174, 25);
		deactivateButton.setContentAreaFilled(false); 
		deactivateButton.setFocusPainted(false); 
		deactivateButton.setOpaque(false);
		deactivateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		accountPanel.add(deactivateButton);
		
		JLabel lblPasswordAccount = new JLabel("Password:");
		lblPasswordAccount.setForeground(new Color(255, 255, 255));
		lblPasswordAccount.setBounds(25, 91, 60, 16);
		accountPanel.add(lblPasswordAccount);
		
		JLabel lblConfirmPasswordAccount = new JLabel("Confirm Password:");
		lblConfirmPasswordAccount.setForeground(new Color(255, 255, 255));
		lblConfirmPasswordAccount.setBounds(25, 117, 116, 16);
		accountPanel.add(lblConfirmPasswordAccount);
		
		JSeparator separatorConfirmPasswordAccount = new JSeparator();
		separatorConfirmPasswordAccount.setForeground(Color.WHITE);
		separatorConfirmPasswordAccount.setBounds(128, 132, 116, 14);
		accountPanel.add(separatorConfirmPasswordAccount);
		
		JSeparator separatorPasswordAccount = new JSeparator();
		separatorPasswordAccount.setForeground(Color.WHITE);
		separatorPasswordAccount.setBounds(86, 107, 116, 14);
		accountPanel.add(separatorPasswordAccount);
		
		JPanel companyPanel = new JPanel();
		companyPanel.setBackground(new Color(255, 102, 51));
		companyPanel.setBounds(12, 553, 529, 186);
		companyPanel.setLayout(null);
		frmEdiwYourAccount.getContentPane().add(companyPanel);
		
		JLabel lblChangeVerificationCode = new JLabel("Change Company Verification Code");
		lblChangeVerificationCode.setForeground(new Color(255, 255, 255));
		lblChangeVerificationCode.setBounds(0, 0, 519, 33);
		lblChangeVerificationCode.setFont(new Font("Tahoma", Font.ITALIC, 22));
		companyPanel.add(lblChangeVerificationCode);
		
		JSeparator separatorChangeVerificationCodeBoss = new JSeparator();
		separatorChangeVerificationCodeBoss.setForeground(new Color(255, 255, 255));
		separatorChangeVerificationCodeBoss.setBounds(170, 117, 150, 16);
		companyPanel.add(separatorChangeVerificationCodeBoss);
		
		JLabel lblNewCompanyCodeBoss = new JLabel("New Company Code:");
		lblNewCompanyCodeBoss.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewCompanyCodeBoss.setForeground(new Color(255, 255, 255));
		lblNewCompanyCodeBoss.setBounds(47, 95, 125, 22);
		companyPanel.add(lblNewCompanyCodeBoss);

		codeField = new JTextField();
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
		changeCodeButton.setContentAreaFilled(false); 
		changeCodeButton.setFocusPainted(false); 
		changeCodeButton.setOpaque(false);
		changeCodeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		companyPanel.add(changeCodeButton);
		
		
		JSeparator separatorPublicPrivate = new JSeparator();
		separatorPublicPrivate.setForeground(new Color(255, 255, 255));
		separatorPublicPrivate.setBounds(0, 317, 568, 16);
		frmEdiwYourAccount.getContentPane().add(separatorPublicPrivate);
		
		JSeparator separatorPrivateAccount = new JSeparator();
		separatorPrivateAccount.setForeground(new Color(255, 255, 255));
		separatorPrivateAccount.setBounds(0, 525, 568, 16);
		frmEdiwYourAccount.getContentPane().add(separatorPrivateAccount);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setForeground(new Color(255, 255, 255));
		separatorEmail.setBounds(47, 178, 147, 14);
		frmEdiwYourAccount.getContentPane().add(separatorEmail);
		
		JSeparator separatorTelephone = new JSeparator();
		separatorTelephone.setForeground(Color.WHITE);
		separatorTelephone.setBounds(66, 220, 128, 14);
		frmEdiwYourAccount.getContentPane().add(separatorTelephone);
		
		JSeparator separatorAddress = new JSeparator();
		separatorAddress.setForeground(Color.WHITE);
		separatorAddress.setBounds(59, 261, 135, 14);
		frmEdiwYourAccount.getContentPane().add(separatorAddress);
		
		JSeparator separatorSpeciality = new JSeparator();
		separatorSpeciality.setForeground(Color.WHITE);
		separatorSpeciality.setBounds(78, 298, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separatorSpeciality);
		
		JSeparator separatorFirstName = new JSeparator();
		separatorFirstName.setForeground(Color.WHITE);
		separatorFirstName.setBounds(283, 178, 115, 14);
		frmEdiwYourAccount.getContentPane().add(separatorFirstName);
		
		JSeparator separatorLastName = new JSeparator();
		separatorLastName.setForeground(Color.WHITE);
		separatorLastName.setBounds(283, 217, 115, 14);
		frmEdiwYourAccount.getContentPane().add(separatorLastName);
		
		JSeparator separatorGender = new JSeparator();
		separatorGender.setForeground(Color.WHITE);
		separatorGender.setBounds(264, 260, 134, 14);
		frmEdiwYourAccount.getContentPane().add(separatorGender);
		
		JSeparator separatorBirthday = new JSeparator();
		separatorBirthday.setForeground(Color.WHITE);
		separatorBirthday.setBounds(264, 298, 128, 14);
		frmEdiwYourAccount.getContentPane().add(separatorBirthday);
		
		JSeparator separatorUsername = new JSeparator();
		separatorUsername.setForeground(Color.WHITE);
		separatorUsername.setBounds(78, 404, 148, 14);
		frmEdiwYourAccount.getContentPane().add(separatorUsername);
		
		JSeparator separatorCurrentPassword = new JSeparator();
		separatorCurrentPassword.setForeground(Color.WHITE);
		separatorCurrentPassword.setBounds(110, 437, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separatorCurrentPassword);
		
		JSeparator separatorNewPassword = new JSeparator();
		separatorNewPassword.setForeground(Color.WHITE);
		separatorNewPassword.setBounds(93, 472, 133, 14);
		frmEdiwYourAccount.getContentPane().add(separatorNewPassword);
		
		JSeparator separatorConfirmPassword = new JSeparator();
		separatorConfirmPassword.setForeground(Color.WHITE);
		separatorConfirmPassword.setBounds(110, 507, 116, 14);
		frmEdiwYourAccount.getContentPane().add(separatorConfirmPassword);
		
		JLabel lbRememberPrivate = new JLabel("Remember!");
		lbRememberPrivate.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lbRememberPrivate.setForeground(new Color(255, 255, 255));
		lbRememberPrivate.setBounds(341, 369, 116, 25);
		frmEdiwYourAccount.getContentPane().add(lbRememberPrivate);
		
		JLabel lblEncryptedPrivate = new JLabel("Your Password stored Encrypted!");
		lblEncryptedPrivate.setForeground(new Color(255, 255, 255));
		lblEncryptedPrivate.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEncryptedPrivate.setBounds(283, 389, 243, 25);
		frmEdiwYourAccount.getContentPane().add(lblEncryptedPrivate);
		
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
				    
					  backendFrame.dispose();
					  if(user instanceof Employee)
					  {
						   try {
							new BackendProfileEmployeeGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  }
					  else if(user instanceof Chief)
					  {
						  try {
							new BackendProfileChiefGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  }
					  else if(user instanceof Boss)
					  {
						  try {
							new BackendProfileBossGUI(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  }
					  frmEdiwYourAccount.dispose();
					  new EditAccountGUI(user,new JFrame());
					  String message = "Successful change in your photo!";
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
				
				char [] passwordCharArray = currentPassField.getPassword();
				String currPassword = String.valueOf(passwordCharArray);
				
				char [] passwordCharArray2 = newPassField.getPassword();
				String newPassword = String.valueOf(passwordCharArray2);
				
				char [] passwordCharArray3 = confirmPassField.getPassword();
				String confirmedPassword = String.valueOf(passwordCharArray3);
				
				user.editPrivateInfo(currPassword, newPassword, confirmedPassword);	
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
