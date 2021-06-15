package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Account;
import entities.Chief;
import entities.Company;
import entities.Employee;
import entities.Password;
import entities.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class CreateAccountGUI {

	private JFrame frmRegisterNow;
	private JTextField txtCompanyCode;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtComfirmPassword;
	private JTextField txtEmail;
	private JTextField txtTelephone;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtGender;
	private JTextField txtBirthday;
	private JTextField txtSpeciality;
	private JButton createAccountButton;
	private JButton loginButton;
	private Company theCompany;


	public CreateAccountGUI(Company aCompany) {
		initialize(aCompany);
	}

	private void initialize(Company aCompany) {
		frmRegisterNow = new JFrame();
		frmRegisterNow.setTitle("Register Now!");
		frmRegisterNow.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmRegisterNow.getContentPane().setBackground(new Color(255, 153, 102));
		frmRegisterNow.setBounds(100, 100, 541, 551);
		frmRegisterNow.getContentPane().setLayout(null);
		frmRegisterNow.setVisible(true);
		//Appears in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmRegisterNow.setLocation(dim.width/2-frmRegisterNow.getSize().width/2, dim.height/2-frmRegisterNow.getSize().height/2);
		frmRegisterNow.setResizable(false);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmRegisterNow.setIconImage(logoimage.getImage());
		
		theCompany = aCompany;
		
		txtCompanyCode = new JTextField();
		txtCompanyCode.setBorder(null);
		txtCompanyCode.setBackground(new Color(255, 153, 102));
		txtCompanyCode.setForeground(new Color(255, 255, 255));
		txtCompanyCode.setBounds(117, 140, 101, 16);
		frmRegisterNow.getContentPane().add(txtCompanyCode);
		txtCompanyCode.setColumns(10);
		
		
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 153, 102));
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setBounds(86, 180, 132, 16);
		frmRegisterNow.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(255, 153, 102));
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setBounds(83, 220, 135, 16);
		frmRegisterNow.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtComfirmPassword = new JPasswordField();
		txtComfirmPassword.setBorder(null);
		txtComfirmPassword.setBackground(new Color(255, 153, 102));
		txtComfirmPassword.setForeground(new Color(255, 255, 255));
		txtComfirmPassword.setBounds(102, 260, 116, 18);
		frmRegisterNow.getContentPane().add(txtComfirmPassword);
		txtComfirmPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(255, 153, 102));
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setBounds(60, 300, 158, 16);
		frmRegisterNow.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelephone = new JTextField();
		txtTelephone.setBorder(null);
		txtTelephone.setBackground(new Color(255, 153, 102));
		txtTelephone.setForeground(new Color(255, 255, 255));
		txtTelephone.setBounds(90, 340, 128, 16);
		frmRegisterNow.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBorder(null);
		txtFirstName.setBackground(new Color(255, 153, 102));
		txtFirstName.setForeground(new Color(255, 255, 255));
		txtFirstName.setBounds(333, 180, 101, 16);
		frmRegisterNow.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBorder(null);
		txtLastName.setBackground(new Color(255, 153, 102));
		txtLastName.setForeground(new Color(255, 255, 255));
		txtLastName.setBounds(333, 220, 101, 16);
		frmRegisterNow.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(255, 153, 102));
		txtAddress.setForeground(new Color(255, 255, 255));
		txtAddress.setBounds(79, 381, 139, 16);
		frmRegisterNow.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setBorder(null);
		txtGender.setBackground(new Color(255, 153, 102));
		txtGender.setForeground(new Color(255, 255, 255));
		txtGender.setBounds(314, 260, 120, 16);
		frmRegisterNow.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setBorder(null);
		txtBirthday.setBackground(new Color(255, 153, 102));
		txtBirthday.setForeground(new Color(255, 255, 255));
		txtBirthday.setBounds(320, 300, 116, 16);
		frmRegisterNow.getContentPane().add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtSpeciality = new JTextField();
		txtSpeciality.setBorder(null);
		txtSpeciality.setBackground(new Color(255, 153, 102));
		txtSpeciality.setForeground(new Color(255, 255, 255));
		txtSpeciality.setBounds(329, 340, 105, 16);
		frmRegisterNow.getContentPane().add(txtSpeciality);
		txtSpeciality.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Company Post:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(268, 380, 88, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel);
		
		createAccountButton = new JButton("Create New Account");
		createAccountButton.setBackground(new Color(255, 153, 102));
		createAccountButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		createAccountButton.setForeground(new Color(255, 255, 255));
		createAccountButton.setBounds(187, 446, 169, 25);
		frmRegisterNow.getContentPane().add(createAccountButton);
		
		loginButton = new JButton("Log In");
		loginButton.setBackground(new Color(255, 153, 102));
		loginButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBounds(412, 446, 97, 25);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frmRegisterNow.setVisible(false);
			}
		});
		frmRegisterNow.getContentPane().add(loginButton);
		
		JRadioButton rdbtnEmployee= new JRadioButton("Employee");
		rdbtnEmployee.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnEmployee.setForeground(new Color(255, 255, 255));
		rdbtnEmployee.setBorder(null);
		rdbtnEmployee.setBackground(new Color(255, 153, 102));
		rdbtnEmployee.setBounds(363, 378, 73, 22);
		frmRegisterNow.getContentPane().add(rdbtnEmployee);
		
		JRadioButton rdbtnChief= new JRadioButton("Chief");
		rdbtnChief.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnChief.setForeground(new Color(255, 255, 255));
		rdbtnChief.setBorder(null);
		rdbtnChief.setBackground(new Color(255, 153, 102));
		rdbtnChief.setBounds(450, 378, 64, 22);
		frmRegisterNow.getContentPane().add(rdbtnChief);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnEmployee);
		radioGroup.add(rdbtnChief);
		
		JLabel lblNewLabel_1 = new JLabel("Company Code:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(23, 140, 88, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(23, 180, 56, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(23, 220, 56, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Pass:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(23, 260, 73, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(23, 300, 33, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(23, 340, 64, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("First Name:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(268, 180, 73, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Last Name:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(268, 220, 64, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(23, 380, 46, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(268, 260, 46, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Birthday:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(268, 300, 56, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Spaciality:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(268, 340, 56, 16);
		frmRegisterNow.getContentPane().add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 535, 119);
		frmRegisterNow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("");
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(100, 100, 80) ;
			lblNewLabel_13.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lblNewLabel_13.setBounds(41, 11, 115, 97);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Create an account now!");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14.setBounds(234, 57, 211, 29);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel("Want to be apart of BSN Media?");
		lblNewLabel_14_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14_1.setBounds(234, 15, 217, 29);
		panel.add(lblNewLabel_14_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 435, 535, 15);
		frmRegisterNow.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(83, 198, 135, 2);
		frmRegisterNow.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(117, 157, 101, 2);
		frmRegisterNow.getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(Color.WHITE);
		separator_1_2.setBounds(83, 236, 135, 2);
		frmRegisterNow.getContentPane().add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(Color.WHITE);
		separator_1_2_1.setBounds(102, 278, 117, 2);
		frmRegisterNow.getContentPane().add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setForeground(Color.WHITE);
		separator_1_2_2.setBounds(60, 317, 160, 2);
		frmRegisterNow.getContentPane().add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setForeground(Color.WHITE);
		separator_1_2_3.setBounds(86, 356, 135, 2);
		frmRegisterNow.getContentPane().add(separator_1_2_3);
		
		JSeparator separator_1_2_3_1 = new JSeparator();
		separator_1_2_3_1.setForeground(Color.WHITE);
		separator_1_2_3_1.setBounds(79, 397, 142, 2);
		frmRegisterNow.getContentPane().add(separator_1_2_3_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.WHITE);
		separator_1_1_1.setBounds(333, 196, 101, 2);
		frmRegisterNow.getContentPane().add(separator_1_1_1);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(Color.WHITE);
		separator_1_1_1_1.setBounds(333, 236, 101, 2);
		frmRegisterNow.getContentPane().add(separator_1_1_1_1);
		
		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setForeground(Color.WHITE);
		separator_1_1_1_1_1.setBounds(314, 276, 120, 2);
		frmRegisterNow.getContentPane().add(separator_1_1_1_1_1);
		
		JSeparator separator_1_1_1_2 = new JSeparator();
		separator_1_1_1_2.setForeground(Color.WHITE);
		separator_1_1_1_2.setBounds(314, 317, 120, 2);
		frmRegisterNow.getContentPane().add(separator_1_1_1_2);
		
		JSeparator separator_1_1_1_1_2 = new JSeparator();
		separator_1_1_1_1_2.setForeground(Color.WHITE);
		separator_1_1_1_1_2.setBounds(333, 356, 101, 2);
		frmRegisterNow.getContentPane().add(separator_1_1_1_1_2);
		
		JLabel lblNewLabel_15 = new JLabel("(Given from your Company)");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_15.setBounds(221, 141, 196, 14);
		frmRegisterNow.getContentPane().add(lblNewLabel_15);
		
		createAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			   
				if (txtCompanyCode.getText().equals(theCompany.getVerificationCode())) {
					
					char [] passwordCharArray = txtPassword.getPassword();
					String password = String.valueOf(passwordCharArray);
					
					char [] confirmedPasswordCharArray = txtComfirmPassword.getPassword();
					String confirmedPassword = String.valueOf(confirmedPasswordCharArray);
					
					//No empty fields
					if (!txtUsername.getText().equals("") && !txtEmail.getText().equals("") && !txtTelephone.getText().equals("") && !txtFirstName.getText().equals("")
							&& !txtLastName.getText().equals("") && !txtAddress.getText().equals("") && !txtGender.getText().equals("") && !txtBirthday.getText().equals("")
							&& !txtSpeciality.getText().equals("") && !password.equals("") && !confirmedPassword.equals("")) {
						
						if(theCompany.isCompanyMember(txtUsername.getText()) == null)
						{
							if(password.equals(confirmedPassword))
							{
								Password createdPassword = new Password(password, txtUsername.getText(), txtFirstName.getText(), txtLastName.getText());
								
								if (password.length()>=8 && !password.equalsIgnoreCase(txtUsername.getText()) 
										 				 && !password.equalsIgnoreCase(txtFirstName.getText())
										 				 && !password.equalsIgnoreCase(txtLastName.getText())) {
									
									Account createdAccount = new Account(txtUsername.getText(), txtEmail.getText(), theCompany, createdPassword);
									
									if (createdAccount.emailAvailability(txtEmail.getText())) {
										
										if(rdbtnEmployee.isSelected())
										 {
											 Employee createdUser = new Employee(txtFirstName.getText(), txtLastName.getText(), txtTelephone.getText(), txtAddress.getText(), txtGender.getText(), txtBirthday.getText(),txtSpeciality.getText(), createdAccount);
											 theCompany.addUser(createdUser);
											 String message = "Successful registration of a new Employee!!!";
												JOptionPane.showMessageDialog(new JFrame(), message, "Message",
												        JOptionPane.INFORMATION_MESSAGE);
										 }
										 else if(rdbtnChief.isSelected())
										 {
											 Chief createdUser = new Chief(txtFirstName.getText(), txtLastName.getText(), txtTelephone.getText(), txtAddress.getText(), txtGender.getText(), txtBirthday.getText(),txtSpeciality.getText(), createdAccount);
											 theCompany.addUser(createdUser);
											 String message = "Successful registration of a new Chief!!!";
												JOptionPane.showMessageDialog(new JFrame(), message, "Message",
												        JOptionPane.INFORMATION_MESSAGE);
										 }
										 else
										 {
											 String message = "You have not selected your position. Please check your position";
												JOptionPane.showMessageDialog(new JFrame(), message, "Message",
												        JOptionPane.INFORMATION_MESSAGE);
										 }
									}
								}
							}
							else
							{
								String message = "The password and confirm password are not the same.Please to contimue they must be identical";
								JOptionPane.showMessageDialog(new JFrame(), message, "Message",
								        JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							String message = "This user with this username already exists. Change the username.";
							JOptionPane.showMessageDialog(new JFrame(), message, "Message",
							        JOptionPane.ERROR_MESSAGE);
						}
					}else {
						String message = "There are blank fields that you must fill in!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
					}
				}else {
					String message = "The company verification code you provided is not identical to the one declared by a company!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			 	
			}
		});
	}
}
