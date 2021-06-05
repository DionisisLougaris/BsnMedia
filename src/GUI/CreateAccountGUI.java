package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

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
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 541, 636);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		theCompany = aCompany;
		
		txtCompanyCode = new JTextField();
		txtCompanyCode.setText("Company Code");
		txtCompanyCode.setBounds(202, 27, 116, 22);
		frame.getContentPane().add(txtCompanyCode);
		txtCompanyCode.setColumns(10);
		
		
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(202, 62, 116, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(202, 97, 116, 22);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtComfirmPassword = new JTextField();
		txtComfirmPassword.setText("Comfirm  Password");
		txtComfirmPassword.setBounds(202, 132, 116, 22);
		frame.getContentPane().add(txtComfirmPassword);
		txtComfirmPassword.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(202, 167, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelephone = new JTextField();
		txtTelephone.setText("Telephone");
		txtTelephone.setBounds(202, 202, 116, 22);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(202, 237, 116, 22);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setBounds(202, 272, 116, 22);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setBounds(202, 307, 116, 22);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setBounds(202, 342, 116, 22);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setText("Birthday");
		txtBirthday.setBounds(202, 377, 116, 22);
		frame.getContentPane().add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtSpeciality = new JTextField();
		txtSpeciality.setText("Speciality");
		txtSpeciality.setBounds(202, 412, 116, 22);
		frame.getContentPane().add(txtSpeciality);
		txtSpeciality.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Company Post");
		lblNewLabel.setBounds(133, 452, 88, 16);
		frame.getContentPane().add(lblNewLabel);
		
		createAccountButton = new JButton("Create New Account");
		createAccountButton.setBounds(177, 515, 169, 25);
		frame.getContentPane().add(createAccountButton);
		
		loginButton = new JButton("Log In");
		loginButton.setBounds(385, 515, 97, 25);
		frame.getContentPane().add(loginButton);
		
		JRadioButton rdbtnEmployee= new JRadioButton("Employee");
		rdbtnEmployee.setBounds(219, 448, 88, 25);
		frame.getContentPane().add(rdbtnEmployee);
		
		JRadioButton rdbtnChief= new JRadioButton("Chief");
		rdbtnChief.setBounds(311, 448, 64, 25);
		frame.getContentPane().add(rdbtnChief);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnEmployee);
		radioGroup.add(rdbtnChief);
		
		helpButton = new JButton("Help");
		helpButton.setBounds(385, 551, 97, 25);
		frame.getContentPane().add(helpButton);
		
		JLabel lblNewLabel_1 = new JLabel("Company Code:");
		lblNewLabel_1.setBounds(84, 30, 106, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(84, 65, 73, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(84, 100, 82, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
		lblNewLabel_4.setBounds(81, 135, 109, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(81, 170, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone:");
		lblNewLabel_6.setBounds(78, 205, 88, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("First Name:");
		lblNewLabel_7.setBounds(78, 240, 88, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Last Name:");
		lblNewLabel_8.setBounds(74, 275, 83, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setBounds(75, 310, 82, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender:");
		lblNewLabel_10.setBounds(74, 345, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Birthday:");
		lblNewLabel_11.setBounds(78, 380, 56, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Spaciality:");
		lblNewLabel_12.setBounds(81, 415, 64, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
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
