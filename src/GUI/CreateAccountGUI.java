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

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class CreateAccountGUI {

	private JFrame frame;
	private JTextField txtCompanyCode;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtComfirmPassword;
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
	private JButton helpButton;
	private Company theCompany;


	public CreateAccountGUI(Company aCompany) {
		initialize(aCompany);
	}

	private void initialize(Company aCompany) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setBounds(100, 100, 541, 636);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		theCompany = aCompany;
		
		txtCompanyCode = new JTextField();
		txtCompanyCode.setBorder(null);
		txtCompanyCode.setBackground(new Color(255, 153, 102));
		txtCompanyCode.setForeground(new Color(255, 255, 255));
		txtCompanyCode.setText("Company Code");
		txtCompanyCode.setBounds(289, 137, 116, 16);
		frame.getContentPane().add(txtCompanyCode);
		txtCompanyCode.setColumns(10);
		
		
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 153, 102));
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setText("Username");
		txtUsername.setBounds(289, 164, 116, 16);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(255, 153, 102));
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setText("Password");
		txtPassword.setBounds(289, 191, 116, 22);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtComfirmPassword = new JTextField();
		txtComfirmPassword.setBorder(null);
		txtComfirmPassword.setBackground(new Color(255, 153, 102));
		txtComfirmPassword.setForeground(new Color(255, 255, 255));
		txtComfirmPassword.setText("Comfirm  Password");
		txtComfirmPassword.setBounds(289, 220, 116, 22);
		frame.getContentPane().add(txtComfirmPassword);
		txtComfirmPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(255, 153, 102));
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setText("Email");
		txtEmail.setBounds(289, 245, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelephone = new JTextField();
		txtTelephone.setBorder(null);
		txtTelephone.setBackground(new Color(255, 153, 102));
		txtTelephone.setForeground(new Color(255, 255, 255));
		txtTelephone.setText("Telephone");
		txtTelephone.setBounds(289, 272, 116, 22);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBorder(null);
		txtFirstName.setBackground(new Color(255, 153, 102));
		txtFirstName.setForeground(new Color(255, 255, 255));
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(289, 305, 73, 22);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBorder(null);
		txtLastName.setBackground(new Color(255, 153, 102));
		txtLastName.setForeground(new Color(255, 255, 255));
		txtLastName.setText("Last Name");
		txtLastName.setBounds(289, 332, 116, 22);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(255, 153, 102));
		txtAddress.setForeground(new Color(255, 255, 255));
		txtAddress.setText("Address");
		txtAddress.setBounds(289, 359, 88, 22);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setBorder(null);
		txtGender.setBackground(new Color(255, 153, 102));
		txtGender.setForeground(new Color(255, 255, 255));
		txtGender.setText("Gender");
		txtGender.setBounds(289, 386, 73, 22);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setBorder(null);
		txtBirthday.setBackground(new Color(255, 153, 102));
		txtBirthday.setForeground(new Color(255, 255, 255));
		txtBirthday.setText("Birthday");
		txtBirthday.setBounds(289, 413, 116, 22);
		frame.getContentPane().add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtSpeciality = new JTextField();
		txtSpeciality.setBorder(null);
		txtSpeciality.setBackground(new Color(255, 153, 102));
		txtSpeciality.setForeground(new Color(255, 255, 255));
		txtSpeciality.setText("Speciality");
		txtSpeciality.setBounds(289, 440, 88, 22);
		frame.getContentPane().add(txtSpeciality);
		txtSpeciality.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Company Post:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(177, 470, 88, 16);
		frame.getContentPane().add(lblNewLabel);
		
		createAccountButton = new JButton("Create New Account");
		createAccountButton.setBackground(new Color(255, 153, 102));
		createAccountButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		createAccountButton.setForeground(new Color(255, 255, 255));
		createAccountButton.setBounds(177, 515, 169, 25);
		frame.getContentPane().add(createAccountButton);
		
		loginButton = new JButton("Log In");
		loginButton.setBackground(new Color(255, 153, 102));
		loginButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBounds(385, 515, 97, 25);
		frame.getContentPane().add(loginButton);
		
		JRadioButton rdbtnEmployee= new JRadioButton("Employee");
		rdbtnEmployee.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnEmployee.setForeground(new Color(255, 255, 255));
		rdbtnEmployee.setBorder(null);
		rdbtnEmployee.setBackground(new Color(255, 153, 102));
		rdbtnEmployee.setBounds(289, 469, 73, 22);
		frame.getContentPane().add(rdbtnEmployee);
		
		JRadioButton rdbtnChief= new JRadioButton("Chief");
		rdbtnChief.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnChief.setForeground(new Color(255, 255, 255));
		rdbtnChief.setBorder(null);
		rdbtnChief.setBackground(new Color(255, 153, 102));
		rdbtnChief.setBounds(364, 469, 64, 22);
		frame.getContentPane().add(rdbtnChief);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnEmployee);
		radioGroup.add(rdbtnChief);
		
		helpButton = new JButton("Help");
		helpButton.setBackground(new Color(255, 153, 102));
		helpButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		helpButton.setForeground(new Color(255, 255, 255));
		helpButton.setBounds(385, 551, 97, 25);
		frame.getContentPane().add(helpButton);
		
		JLabel lblNewLabel_1 = new JLabel("Company Code:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(177, 140, 82, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(177, 167, 73, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(177, 194, 73, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Pass:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(177, 223, 109, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(177, 248, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(177, 275, 73, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("First Name:");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(177, 308, 73, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Last Name:");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(177, 335, 83, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(177, 362, 82, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender:");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(177, 389, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Birthday:");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(177, 416, 56, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Spaciality:");
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(177, 443, 64, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 535, 119);
		frame.getContentPane().add(panel);
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
		
		JLabel lblNewLabel_14 = new JLabel("Create easy your Account!");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14.setBounds(234, 57, 211, 29);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel("You are new here?");
		lblNewLabel_14_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14_1.setBounds(250, 17, 179, 29);
		panel.add(lblNewLabel_14_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 503, 535, 15);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(289, 163, 101, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(289, 184, 101, 2);
		frame.getContentPane().add(separator_1_1);
		
		createAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			   
				
				if(theCompany.isCompanyMember(txtUsername.getText()) == null && txtUsername.getText()!= "")
				{
					if(txtPassword.getText().equals(txtComfirmPassword.getText()))
					{
						Password createdPassword = new Password(txtPassword.getText(), txtUsername.getText(), txtFirstName.getText(), txtLastName.getText());
						Account createdAccount = new Account(txtUsername.getText(),txtEmail.getText(),theCompany,createdPassword);
						if(rdbtnEmployee.isSelected())
						 {
							 Employee createdUser = new Employee(txtFirstName.getText(), txtLastName.getText(), txtTelephone.getText(), txtAddress.getText(), txtGender.getText(), txtBirthday.getText(),txtSpeciality.getText(), createdAccount);
						 }
						 else if(rdbtnChief.isSelected())
						 {
							 Chief createdUser = new Chief(txtFirstName.getText(), txtLastName.getText(), txtTelephone.getText(), txtAddress.getText(), txtGender.getText(), txtBirthday.getText(),txtSpeciality.getText(), createdAccount);
						 }
						 else
						 {
							 String message = "You have not selected your position.Please check your position";
								JOptionPane.showMessageDialog(new JFrame(), message, "Message",
								        JOptionPane.INFORMATION_MESSAGE);
						 }
					}
					else
					{
						String message = "The password and confirm password is not the same.Please to contimue they must be identical ";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					String message = "This user with this username already exists.Change the username.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
				}
			 
				
			}
		});
		
		helpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new HelpGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String passwordCharArray = txtPassword.getText();
				
			}
			
		});
		
		
	}
}
