package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import entities.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Cursor;


public class ForgotPasswordGUI {

	private JFrame frmForgotPassword;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtVerificationCode;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;
	private JPanel panel;
	private JLabel titleLabel;
	private JLabel bsnMediaLogo;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JLabel usernameLabel;
	private JLabel emailLabel;
	private JLabel verCodeLabel;
	private JLabel newPasswordLabel;
	private JLabel confirmPasswordLabel;
	private JButton sendCodeButton;
	private JButton checkCodeButton;
	private JButton doneButton;
	private JButton goToLogInButton;
	
	private User userToRetrieve = null;
	private String recoveryCode = "";
	private boolean correctCodeInput = false;
	private Company theCompany;


	public ForgotPasswordGUI(Company aCompany){
		initialize(aCompany);
	}

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
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmForgotPassword.setIconImage(logoimage.getImage());
		
		theCompany = aCompany;
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 153, 102));
		txtUsername.setForeground(new Color(255, 255, 255));
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
		txtEmail.setToolTipText("Email");
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(255, 153, 102));
		txtEmail.setForeground(new Color(255, 255, 255));
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
		
		sendCodeButton = new JButton("Send Verification Code");
		sendCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendCodeButton.setForeground(new Color(255, 255, 255));
		sendCodeButton.setBackground(new Color(255, 153, 102));
		sendCodeButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		sendCodeButton.setBounds(355, 99, 163, 25);
		frmForgotPassword.getContentPane().add(sendCodeButton);
		
		txtVerificationCode = new JTextField();
		txtVerificationCode.setToolTipText("Verification Code");
		txtVerificationCode.setBorder(null);
		txtVerificationCode.setBackground(new Color(255, 153, 102));
		txtVerificationCode.setForeground(new Color(255, 255, 255));
		//When the mouse click on the TextField, the text removed
		txtVerificationCode.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtVerificationCode.setText("");
            }
        });
		txtVerificationCode.setBounds(351, 152, 69, 14);
		frmForgotPassword.getContentPane().add(txtVerificationCode);
		txtVerificationCode.setColumns(10);
		
		checkCodeButton = new JButton("Check");
		checkCodeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkCodeButton.setForeground(new Color(255, 255, 255));
		checkCodeButton.setBackground(new Color(0, 153, 51));
		checkCodeButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		checkCodeButton.setBounds(430, 148, 81, 22);
		frmForgotPassword.getContentPane().add(checkCodeButton);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setToolTipText("New Password");
		txtNewPassword.setBorder(null);
		txtNewPassword.setBackground(new Color(255, 153, 102));
		txtNewPassword.setForeground(new Color(255, 255, 255));
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
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setToolTipText("Confirm New Password");
		txtConfirmPassword.setBorder(null);
		txtConfirmPassword.setBackground(new Color(255, 153, 102));
		txtConfirmPassword.setForeground(new Color(255, 255, 255));
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
		
		doneButton = new JButton("Done");
		doneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		doneButton.setForeground(new Color(255, 255, 255));
		doneButton.setBackground(new Color(255, 153, 102));
		doneButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		doneButton.setBounds(400, 271, 81, 25);
		frmForgotPassword.getContentPane().add(doneButton);
		
		goToLogInButton = new JButton("Go to Log In");
		goToLogInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goToLogInButton.setForeground(new Color(255, 255, 255));
		goToLogInButton.setBackground(new Color(255, 153, 102));
		goToLogInButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		goToLogInButton.setBounds(477, 336, 97, 25);
		frmForgotPassword.getContentPane().add(goToLogInButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 276, 372);
		frmForgotPassword.getContentPane().add(panel);
		panel.setLayout(null);
		
		titleLabel = new JLabel("Forgot your Password?");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		titleLabel.setBounds(51, 37, 168, 22);
		panel.add(titleLabel);
		
		bsnMediaLogo = new JLabel("");
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
			ImageIcon image = new ImageIcon(imageicon);
			Image imagerisize = image.getImage().getScaledInstance(120, 120, 90) ;
			bsnMediaLogo.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		bsnMediaLogo.setBounds(69, 100, 150, 120);
		panel.add(bsnMediaLogo);
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(380, 53, 116, 2);
		frmForgotPassword.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(380, 86, 116, 2);
		frmForgotPassword.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(351, 168, 63, 9);
		frmForgotPassword.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(380, 242, 116, 7);
		frmForgotPassword.getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(380, 215, 116, 7);
		frmForgotPassword.getContentPane().add(separator_4);
		
		usernameLabel = new JLabel("New label");
		usernameLabel.setIcon(new ImageIcon("label_backgrounds/user_32px.png"));
		usernameLabel.setBounds(343, 33, 27, 22);
		frmForgotPassword.getContentPane().add(usernameLabel);
		
		emailLabel = new JLabel("New label");
		emailLabel.setIcon(new ImageIcon("label_backgrounds/gmail_32px.png"));
		emailLabel.setBounds(343, 66, 33, 22);
		frmForgotPassword.getContentPane().add(emailLabel);
		
		verCodeLabel = new JLabel("New label");
		verCodeLabel.setIcon(new ImageIcon("label_backgrounds/password_32px.png"));
		verCodeLabel.setBounds(314, 148, 27, 22);
		frmForgotPassword.getContentPane().add(verCodeLabel);
		
		newPasswordLabel = new JLabel("New label");
		newPasswordLabel.setIcon(new ImageIcon("label_backgrounds/lock_32px.png"));
		newPasswordLabel.setBounds(343, 185, 27, 34);
		frmForgotPassword.getContentPane().add(newPasswordLabel);
		
		confirmPasswordLabel = new JLabel("New label");
		confirmPasswordLabel.setIcon(new ImageIcon("label_backgrounds/verified_account_32px.png"));
		confirmPasswordLabel.setBounds(343, 223, 27, 22);
		frmForgotPassword.getContentPane().add(confirmPasswordLabel);
		
		ButtonListener listener = new ButtonListener();
		sendCodeButton.addActionListener(listener);
		checkCodeButton.addActionListener(listener);
		doneButton.addActionListener(listener);
		goToLogInButton.addActionListener(listener);
	}
	
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource().equals(sendCodeButton)) {
				
				String inputUsername = txtUsername.getText();
				String inputEmail = txtEmail.getText();
				
				Random rand = new Random();
				recoveryCode = "";
				int upperbound = 10;
				//Generate an 8-digit code to be sent for user confirmation
				for(int i=0; i<8; i++ ) {
					int int_random = rand.nextInt(upperbound);
					recoveryCode = recoveryCode + int_random;
				}
				
				//The account with this information may be recovered
				Account retrievedAccount = new Account(inputUsername, inputEmail, theCompany);
				
				userToRetrieve = retrievedAccount.forgotPassword(inputUsername, inputEmail, "The Recovery Code is: "+recoveryCode);
				
				if (userToRetrieve == null) {
					String message = "The information you provided does not correspond to a user of the system.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}else {
					String message = "Check your Email! A confirmation code has been sent to you!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
					
				}
			}else if (e.getSource().equals(checkCodeButton)) {
				if (userToRetrieve == null ) {
					String message = "Fill in or check your details in the Username\n and Email fields and select to recieve the Recovery Code!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}else{
					String recoveryCodeInput = txtVerificationCode.getText();
					
					if (recoveryCodeInput.equals(recoveryCode)) {
						correctCodeInput = true;
						String message = "Recovery Code accepted! You can recover your account!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						String message = "The recovery code we sent you is not the same as the one given!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
					}
				}
			}else if (e.getSource().equals(doneButton)) {
				if (userToRetrieve == null ) {
					String message = "Fill in or check your details in the Username\n and Email fields and select to recieve the Recovery Code!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}else if (!correctCodeInput) {
					String message = "You must first fill in the recovery code correctly!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}else {
					char [] passwordCharArray = txtNewPassword.getPassword();
					String newPasswordInput = String.valueOf(passwordCharArray);
					
					char [] confirmedPasswordCharArray = txtConfirmPassword.getPassword();
					String confirmedPasswordInput = String.valueOf(confirmedPasswordCharArray);
					
					userToRetrieve.getMyAccount().getMyPassword().newPassword(newPasswordInput, confirmedPasswordInput, userToRetrieve);
				}
			}else {
				frmForgotPassword.setVisible(false);
			}
		}
	}

}
