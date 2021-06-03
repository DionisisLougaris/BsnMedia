package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import GUI.WelcomeScreenGUI.ButtonListener;
import entities.Company;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen_GUI {

	private JFrame frmWelcomeToBsn;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JButton btnNewButton;
	private JButton btnSignUp;
	private JButton btnNewButton_1;
	private Company theCompany;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen_GUI window = new WelcomeScreen_GUI();
					window.frmWelcomeToBsn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public WelcomeScreen_GUI(Company aCompany) {
		initialize(aCompany);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Company aCompany) {
		frmWelcomeToBsn = new JFrame();
		this.frmWelcomeToBsn.setVisible(true);
		frmWelcomeToBsn.setTitle("Welcome to BSN Media");
		frmWelcomeToBsn.setVisible(true);
		frmWelcomeToBsn.setBounds(100, 100, 650, 350);
		frmWelcomeToBsn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToBsn.getContentPane().setLayout(null);
		
		theCompany = aCompany;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 311);
		frmWelcomeToBsn.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(0, 0, 297, 311);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Logo");
		lblNewLabel_2.setBounds(82, 87, 114, 66);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Keep your Network Safe!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(10, 25, 180, 14);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(255, 153, 51));
		panel_2.setBounds(296, 0, 338, 311);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setText("Username");
		txtUsername.setBackground(new Color(255, 153, 0));
		txtUsername.setBounds(101, 84, 117, 26);
		panel_2.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setBorder(null);
		pwdPassword.setToolTipText("Password");
		pwdPassword.setForeground(new Color(255, 255, 255));
		pwdPassword.setBackground(new Color(255, 153, 0));
		pwdPassword.setBounds(101, 121, 117, 26);
		panel_2.add(pwdPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(101, 109, 117, 2);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(101, 146, 117, 7);
		panel_2.add(separator_2);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("label_backgrounds/user_32px.png"));
		lblNewLabel.setBounds(62, 84, 29, 26);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("label_backgrounds/lock_32px.png"));
		lblNewLabel_1.setBounds(62, 121, 26, 26);
		panel_2.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Log In");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setBounds(101, 164, 69, 26);
		panel_2.add(btnNewButton);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(255, 153, 0));
		btnSignUp.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnSignUp.setBounds(177, 164, 69, 26);
		panel_2.add(btnSignUp);
		
		btnNewButton_1 = new JButton("Forgot Password?");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(129, 194, 89, 23);
		panel_2.add(btnNewButton_1);
		
		ButtonListener listener = new ButtonListener();
		btnNewButton.addActionListener(listener);
		btnSignUp.addActionListener(listener);
		btnNewButton_1.addActionListener(listener);
	}
	
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(btnNewButton)) {
				
				String username = txtUsername.getText();
				char [] passwordCharArray = pwdPassword.getPassword();
				String password = String.valueOf(passwordCharArray);
				
				//Prepei na klithei i login attemp apo tin klasi Account. Den ginetai na dimioyrgithei antikeimeno account, ara mallon
				// tha prepei i methodos ayti na paei stin klasi Company
			}else if (e.getSource().equals(btnSignUp)) {
				
				new CreateAccountGUI(theCompany);
			}else {
				
				new ForgotPasswordGUI(theCompany);
			}
		}
	}
	
}


