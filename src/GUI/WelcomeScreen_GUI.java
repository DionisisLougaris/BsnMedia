package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import entities.*;

public class WelcomeScreen_GUI {

	private JFrame frmWelcomeToBsn;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private Company theCompany;
	
	private JButton logInButton;
	private JButton btnSingUp;
	private JButton forgotPasswordButton;
	
	public WelcomeScreen_GUI(Company aCompany) throws IOException {
		theCompany = aCompany;
		initialize();
	}

	private void initialize() throws IOException {
		frmWelcomeToBsn = new JFrame();
		frmWelcomeToBsn.setResizable(false); //It does not change dimensions, so that the positions and appearance of the graphic elements are not altered.
		frmWelcomeToBsn.setVisible(true);
		frmWelcomeToBsn.setTitle("Welcome to BSN Media");
		frmWelcomeToBsn.setBounds(100, 100, 982, 586);
		//Appears in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmWelcomeToBsn.setLocation(dim.width/2-frmWelcomeToBsn.getSize().width/2, dim.height/2-frmWelcomeToBsn.getSize().height/2);
		frmWelcomeToBsn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToBsn.getContentPane().setLayout(null);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmWelcomeToBsn.setIconImage(logoimage.getImage());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 102));
		panel.setBounds(0, 0, 976, 557);
		frmWelcomeToBsn.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 102, 51));
		panel_1.setBounds(0, 0, 460, 557);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel copyRightsLabel = new JLabel("\u00A9  2021 All rights reserved");
		copyRightsLabel.setForeground(new Color(255, 255, 255));
		copyRightsLabel.setBounds(155, 517, 172, 27);
		panel_1.add(copyRightsLabel);
		
		JLabel labelForBackGround = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/BSN_Background_page-0001.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(460, 544, 140) ;
		labelForBackGround.setIcon(new ImageIcon(imagerisizeb));
		labelForBackGround.setBounds(0, 0, 460, 544);
		panel_1.add(labelForBackGround);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2.setBackground(new Color(255, 153, 102));
		panel_2.setBounds(458, 0, 518, 557);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtUsername = new JTextField("Username");
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBackground(new Color(255, 153, 102));
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setBounds(188, 197, 174, 29);
		txtUsername.setColumns(10);
		//When the mouse click on the TextField, the text removed
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtUsername.setText("");
            }
        });
		panel_2.add(txtUsername);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBorder(null);
		pwdPassword.setForeground(new Color(255, 255, 255));
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pwdPassword.setBackground(new Color(255, 153, 102));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(188, 248, 174, 29);
		pwdPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	pwdPassword.setText("");
            }
        });
		panel_2.add(pwdPassword);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(188, 232, 180, 18);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(188, 281, 180, 18);
		panel_2.add(separator_1);
		
		JLabel usernameIcon = new JLabel();
		usernameIcon.setIcon(new ImageIcon("label_backgrounds/user_32px.png"));
		usernameIcon.setBounds(147, 199, 29, 29);
		panel_2.add(usernameIcon);
		
		JLabel passwordIcon = new JLabel();
		passwordIcon.setIcon(new ImageIcon("label_backgrounds/lock_32px.png"));
		passwordIcon.setBounds(149, 248, 29, 29);
		panel_2.add(passwordIcon);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_3.setBackground(new Color(255, 153, 102));
		panel_3.setBounds(188, 299, 85, 29);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		logInButton = new JButton("Log In");
		logInButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		logInButton.setForeground(new Color(255, 255, 255));
		logInButton.setBackground(new Color(255, 153, 102));
		logInButton.setBounds(0, 0, 85, 29);
		logInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_3.add(logInButton);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 153, 102));
		panel_3_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_3_1.setBounds(283, 299, 85, 29);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		btnSingUp = new JButton("Sign Up");
		btnSingUp.setForeground(new Color(255, 255, 255));
		btnSingUp.setBackground(new Color(255, 153, 102));
		btnSingUp.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnSingUp.setBounds(0, 0, 85, 29);
		btnSingUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_3_1.add(btnSingUp);
		
		forgotPasswordButton = new JButton("Forgot your Password?");
		forgotPasswordButton.setForeground(new Color(255, 255, 255));
		forgotPasswordButton.setOpaque(false);
		forgotPasswordButton.setContentAreaFilled(false);
		forgotPasswordButton.setBorderPainted(false);
		forgotPasswordButton.setBorder(null);
		forgotPasswordButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		forgotPasswordButton.setBounds(213, 329, 124, 23);
		forgotPasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_2.add(forgotPasswordButton);
		
		JLabel hyperLink = new JLabel("IT Intelligence");
		hyperLink.setToolTipText("Check our GitHub!");
		hyperLink.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hyperLink.setForeground(new Color(255, 255, 255));
		hyperLink.setBounds(423, 495, 95, 18);
		hyperLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hyperLink.addMouseListener(new MouseAdapter() {
        	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/DionisisLougaris/BsnMedia"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
            	hyperLink.setText("IT Intelligence");
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
            	hyperLink.setText("<html><a href=''>" + "IT Intelligence" + "</a></html>");
            }
 
        });
		panel_2.add(hyperLink);
		
		JLabel dateLabel = new JLabel("Since 2021");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setBounds(433, 512, 53, 14);
		panel_2.add(dateLabel);
		
		JLabel ourLogoLabel = new JLabel();
		BufferedImage imageicon2 = ImageIO.read(new File("label_backgrounds/IT_logo.png"));
		ImageIcon image2 = new ImageIcon(imageicon2);
		Image imagerisize2 = image2.getImage().getScaledInstance(40, 35, 140) ;
		ourLogoLabel.setIcon(new ImageIcon(imagerisize2));
		ourLogoLabel.setBounds(376, 495, 40, 35);
		panel_2.add(ourLogoLabel);
		
		ButtonListener listener = new ButtonListener();
		logInButton.addActionListener(listener);
		btnSingUp.addActionListener(listener);
		forgotPasswordButton.addActionListener(listener);
	}
	
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource().equals(logInButton)) {
				
				String username = txtUsername.getText();
				char [] passwordCharArray = pwdPassword.getPassword();
				String password = String.valueOf(passwordCharArray);
				
				try {
					if (theCompany.loginAttempt(username, password)) {
						frmWelcomeToBsn.setVisible(false);
					}else {
						String message = "Wrong username or password!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (e.getSource().equals(btnSingUp)) {
				
				new CreateAccountGUI(theCompany);
			}else {
				
				new ForgotPasswordGUI(theCompany);
			}
		}
	}
}
