package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Company;
import entities.Employee;
import entities.User;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.Icon;
import java.awt.Color;

public class CompanyProfileGUI {

	private JFrame frame;
	private JTextField textField;
	private static User myUser;
	private static Company theCompany;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyProfileGUI window = new CompanyProfileGUI(myUser);
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
	public CompanyProfileGUI(User myUser) {
		this.myUser = myUser;
		this.theCompany = myUser.getMyAccount().getMyCompany();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.setVisible(true);
		
		ImageIcon logoimage = new ImageIcon();
	    frame.setTitle("Company");
	    frame.getContentPane().setLayout(null);
	    
	    JButton btnNewButton_1 = new JButton("logo");
	    btnNewButton_1.setContentAreaFilled(false); 
	    btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(myUser instanceof Chief)
				{
					BackendProfileChiefGUI myProfile = new BackendProfileChiefGUI(myUser);
				}
				else if(myUser instanceof Boss)
				{
					BackendProfileBossGUI myProfile = new BackendProfileBossGUI(myUser);
				}
				else if(myUser instanceof Employee)
				{
					BackendProfileEmployeeGUI myProfile = new BackendProfileEmployeeGUI(myUser);
				}
	    	}
	    });
	    btnNewButton_1.setBounds(26, 27, 62, 53);
	    frame.getContentPane().add(btnNewButton_1);
	    
	    textField = new JTextField();
	    textField.setBackground(new Color(255, 250, 240));
	    textField.setColumns(10);
	    textField.setBounds(367, 38, 317, 30);
	    frame.getContentPane().add(textField);
	    
	    Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
	    JButton btnNewButton = new JButton(search);
	    btnNewButton.setContentAreaFilled(false); 
	    btnNewButton.setFocusPainted(false); 
	    btnNewButton.setOpaque(false);
	    btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(704, 36, 46, 44);
	    frame.getContentPane().add(btnNewButton);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    panel_1.setBounds(70, 140, 743, 285);
	    frame.getContentPane().add(panel_1);
	    
	    JLabel lblCompanyPhoto = new JLabel("Company photo");
	    lblCompanyPhoto.setBounds(329, 132, 305, 16);
	    panel_1.add(lblCompanyPhoto);
	    
	    JLabel lblNewLabel_1 = new JLabel("Company_Name");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    lblNewLabel_1.setBounds(347, 438, 226, 30);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_5 = new JLabel("What we are all about :");
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_5.setBounds(50, 487, 160, 30);
	    frame.getContentPane().add(lblNewLabel_5);
	    
	    JLabel lblNewLabel = new JLabel("This is a custom block of text blah blah blah blah");
	    lblNewLabel.setBounds(60, 530, 226, 118);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JList list = new JList();
	    list.setBackground(new Color(255, 250, 240));
	    list.setBounds(494, 609, 133, 186);
	    frame.getContentPane().add(list);
	    
	    JList list_1 = new JList();
	    list_1.setBackground(new Color(255, 250, 240));
	    list_1.setBounds(660, 609, 133, 186);
	    frame.getContentPane().add(list_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Employees(0)");
	    lblNewLabel_2.setBounds(660, 580, 91, 16);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Chiefs(0)");
	    lblNewLabel_2_1.setBounds(500, 580, 91, 16);
	    frame.getContentPane().add(lblNewLabel_2_1);

	    JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
	    lblNewLabel_4.setBounds(146, 751, 125, 16);
	    frame.getContentPane().add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_10 = new JLabel("23100000000");
	    lblNewLabel_10.setBounds(146, 780, 78, 16);
	    frame.getContentPane().add(lblNewLabel_10);
	    
	    JLabel lblNewLabel_11 = new JLabel("Egnatias, 156");
	    lblNewLabel_11.setBounds(146, 809, 78, 16);
	    frame.getContentPane().add(lblNewLabel_11);
	    
	    JLabel lblNewLabel_3 = new JLabel("Head of company :");
	    lblNewLabel_3.setBounds(70, 661, 128, 16);
	    frame.getContentPane().add(lblNewLabel_3);
	    
	    Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_7 = new JButton(help);
		btnNewButton_7.setContentAreaFilled(false); 
		btnNewButton_7.setFocusPainted(false); 
		btnNewButton_7.setOpaque(false);
		btnNewButton_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	    btnNewButton_7.setBounds(817, 922, 46, 38);
	    frame.getContentPane().add(btnNewButton_7);
	    
	    JLabel lblNewLabel_7 = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
	    lblNewLabel_7.setBounds(106, 751, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7);
	    
	    JLabel lblNewLabel_7_1 = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
	    lblNewLabel_7_1.setBounds(106, 780, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7_1);
	    
	    JLabel lblNewLabel_7_2 = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
	    lblNewLabel_7_2.setBounds(106, 809, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7_2);
	    
	    JButton btnNewButton_2 = new JButton("Boss' Profile");
	    btnNewButton_2.setContentAreaFilled(false); 
	    btnNewButton_2.setFocusPainted(false); 
	    btnNewButton_2.setOpaque(false);
	    btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btnNewButton_2.setBorderPainted(false);
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	}
	    });
	    btnNewButton_2.setBounds(180, 657, 106, 25);
	    frame.getContentPane().add(btnNewButton_2);
	    frame.setVisible(true);
	}
}
