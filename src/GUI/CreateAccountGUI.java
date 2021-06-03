package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Company;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Company theCompany;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountGUI window = new CreateAccountGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*
	 * Create the application.
	 */
	public CreateAccountGUI(Company aCompany) {
		initialize(aCompany);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Company aCompany) {
		frame = new JFrame();
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
		
		btnNewButton = new JButton("Create New Account");
		btnNewButton.setBounds(177, 515, 169, 25);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.setBounds(385, 515, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Employee");
		rdbtnNewRadioButton.setBounds(219, 448, 88, 25);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Chief");
		rdbtnNewRadioButton_1.setBounds(311, 448, 64, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		btnNewButton_2 = new JButton("Help");
		btnNewButton_2.setBounds(385, 551, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
	}
}
