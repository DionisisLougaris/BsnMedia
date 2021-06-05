package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Company;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class ForgotPasswordGUI {

	private JFrame frmForgotPassword;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtCode;
	private JTextField txtNewPassword;
	private JTextField txtConfirmPassword;
	private JButton btnNewButton_4;
	private Company theCompany;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

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
		frmForgotPassword = new JFrame();
		frmForgotPassword.setTitle("Forgot Password?");
		frmForgotPassword.getContentPane().setBackground(new Color(255, 153, 102));
		frmForgotPassword.setBounds(100, 100, 603, 401);
		//Appears in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmForgotPassword.setLocation(dim.width/2-frmForgotPassword.getSize().width/2, dim.height/2-frmForgotPassword.getSize().height/2);
		frmForgotPassword.setVisible(true);
		frmForgotPassword.setResizable(false);
		frmForgotPassword.getContentPane().setLayout(null);
		
		theCompany = aCompany;
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 153, 102));
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setText("Username");
		//When the mouse click on the TextField, the text removed
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtUsername.setText("");
            }
        });
		txtUsername.setBounds(380, 33, 116, 14);
		frmForgotPassword.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(255, 153, 102));
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setText("Email");
		//When the mouse click on the TextField, the text removed
		txtEmail.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtEmail.setText("");
            }
        });
		txtEmail.setBounds(380, 66, 116, 14);
		frmForgotPassword.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Send Verification Code");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton.setBounds(355, 99, 163, 25);
		frmForgotPassword.getContentPane().add(btnNewButton);
		
		txtCode = new JTextField();
		txtCode.setBorder(null);
		txtCode.setBackground(new Color(255, 153, 102));
		txtCode.setForeground(new Color(255, 255, 255));
		txtCode.setText("Code");
		//When the mouse click on the TextField, the text removed
		txtCode.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtCode.setText("");
            }
        });
		txtCode.setBounds(351, 152, 69, 14);
		frmForgotPassword.getContentPane().add(txtCode);
		txtCode.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 153, 51));
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(430, 148, 81, 22);
		frmForgotPassword.getContentPane().add(btnNewButton_1);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setBorder(null);
		txtNewPassword.setBackground(new Color(255, 153, 102));
		txtNewPassword.setForeground(new Color(255, 255, 255));
		txtNewPassword.setText("New Password");
		//When the mouse click on the TextField, the text removed
		txtNewPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtNewPassword.setText("");
            }
        });
		txtNewPassword.setBounds(380, 201, 116, 14);
		frmForgotPassword.getContentPane().add(txtNewPassword);
		txtNewPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBorder(null);
		txtConfirmPassword.setBackground(new Color(255, 153, 102));
		txtConfirmPassword.setForeground(new Color(255, 255, 255));
		txtConfirmPassword.setText("Confirm Password");
		//When the mouse click on the TextField, the text removed
		txtConfirmPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtConfirmPassword.setText("");
            }
        });
		txtConfirmPassword.setBounds(380, 226, 116, 16);
		frmForgotPassword.getContentPane().add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 153, 102));
		btnNewButton_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton_2.setBounds(400, 271, 81, 25);
		frmForgotPassword.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log In");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 153, 102));
		btnNewButton_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton_3.setBounds(491, 309, 97, 25);
		frmForgotPassword.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Help");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 153, 102));
		btnNewButton_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnNewButton_4.setBounds(491, 336, 97, 25);
		frmForgotPassword.getContentPane().add(btnNewButton_4);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 276, 372);
		frmForgotPassword.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Forgot your Password?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(51, 37, 168, 22);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(120, 120, 90) ;
			lblNewLabel_1.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lblNewLabel_1.setBounds(69, 100, 150, 120);
		panel.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(380, 53, 81, 2);
		frmForgotPassword.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(380, 86, 81, 2);
		frmForgotPassword.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(351, 165, 63, 9);
		frmForgotPassword.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(380, 242, 116, 7);
		frmForgotPassword.getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(380, 215, 116, 7);
		frmForgotPassword.getContentPane().add(separator_4);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("label_backgrounds/user_32px.png"));
		lblNewLabel_2.setBounds(343, 33, 27, 22);
		frmForgotPassword.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("label_backgrounds/gmail_32px.png"));
		lblNewLabel_3.setBounds(343, 66, 33, 22);
		frmForgotPassword.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("label_backgrounds/password_32px.png"));
		lblNewLabel_4.setBounds(314, 148, 27, 22);
		frmForgotPassword.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("label_backgrounds/lock_32px.png"));
		lblNewLabel_5.setBounds(343, 185, 27, 34);
		frmForgotPassword.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("label_backgrounds/verified_account_32px.png"));
		lblNewLabel_6.setBounds(343, 223, 27, 22);
		frmForgotPassword.getContentPane().add(lblNewLabel_6);
	}

}
