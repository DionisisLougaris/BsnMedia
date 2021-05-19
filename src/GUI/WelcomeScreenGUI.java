package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreenGUI {

	JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreenGUI window = new WelcomeScreenGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreenGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBounds(100, 100, 909, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(442, 0, 449, 583);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 51, 153));
		txtUsername.setBackground(new Color(255, 153, 0));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setText("          Username");
		txtUsername.setBounds(134, 158, 179, 33);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 224, 179, 33);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(183, 289, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forgot Password?");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(144, 467, 194, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.setBounds(169, 327, 132, 25);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Welcome to BSN Media!");
		lblNewLabel.setBounds(83, 47, 285, 27);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Keep Your Network Safe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(133, 87, 207, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
