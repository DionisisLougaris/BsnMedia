package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Company;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPasswordGUI {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtCode;
	private JTextField txtNewPassword;
	private JTextField txtConfirmPassword;
	private JButton btnNewButton_4;
	private Company theCompany;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordGUI window = new ForgotPasswordGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Create the application.
	 */
	public ForgotPasswordGUI(Company aCompany) {
		initialize(aCompany);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Company aCompany) {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 452);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		theCompany = aCompany;
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(204, 82, 116, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(204, 117, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Send Verification Code");
		btnNewButton.setBounds(184, 152, 163, 25);
		frame.getContentPane().add(btnNewButton);
		
		txtCode = new JTextField();
		txtCode.setText("Code");
		txtCode.setBounds(184, 190, 69, 22);
		frame.getContentPane().add(txtCode);
		txtCode.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(266, 190, 81, 22);
		frame.getContentPane().add(btnNewButton_1);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setText("New Password");
		txtNewPassword.setBounds(204, 225, 116, 22);
		frame.getContentPane().add(txtNewPassword);
		txtNewPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setText("Confirm Password");
		txtConfirmPassword.setBounds(204, 260, 116, 22);
		frame.getContentPane().add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_2.setBounds(214, 295, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log In");
		btnNewButton_3.setBounds(385, 332, 97, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Help");
		btnNewButton_4.setBounds(385, 370, 97, 25);
		frame.getContentPane().add(btnNewButton_4);
	}

}
