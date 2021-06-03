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
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;

public class CompanyProfileGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyProfileGUI window = new CompanyProfileGUI();
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
	public CompanyProfileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon logoimage = new ImageIcon();
	    frame.setTitle("Company");
	    frame.getContentPane().setLayout(null);
	    
	    JButton btnNewButton_1 = new JButton("logo");
	    btnNewButton_1.setBounds(26, 27, 62, 53);
	    frame.getContentPane().add(btnNewButton_1);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(409, 38, 317, 30);
	    frame.getContentPane().add(textField);
	    
	    JButton btnNewButton = new JButton("icon");
	    btnNewButton.setBounds(738, 41, 55, 25);
	    frame.getContentPane().add(btnNewButton);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    panel_1.setBounds(50, 142, 743, 285);
	    frame.getContentPane().add(panel_1);
	    
	    JLabel lblCompanyPhoto = new JLabel("Company photo");
	    lblCompanyPhoto.setBounds(329, 132, 305, 16);
	    panel_1.add(lblCompanyPhoto);
	    
	    JLabel lblNewLabel_1 = new JLabel("Company_Name");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    lblNewLabel_1.setBounds(350, 440, 226, 30);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_5 = new JLabel("What we are all about :");
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_5.setBounds(63, 528, 160, 30);
	    frame.getContentPane().add(lblNewLabel_5);
	    
	    JLabel lblNewLabel = new JLabel("This is a custom block of text blah blah blah blah");
	    lblNewLabel.setBounds(61, 580, 226, 118);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JList list = new JList();
	    list.setBounds(516, 742, 133, 153);
	    frame.getContentPane().add(list);
	    
	    JList list_1 = new JList();
	    list_1.setBounds(691, 742, 133, 153);
	    frame.getContentPane().add(list_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Employees(0)");
	    lblNewLabel_2.setBounds(691, 723, 91, 16);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Chiefs(0)");
	    lblNewLabel_2_1.setBounds(520, 723, 91, 16);
	    frame.getContentPane().add(lblNewLabel_2_1);
	    
	    JButton btnNewButton_5_3 = new JButton("email icon");
	    btnNewButton_5_3.setBounds(50, 824, 22, 21);
	    frame.getContentPane().add(btnNewButton_5_3);
	    
	    JButton btnNewButton_5 = new JButton("telephone icon");
	    btnNewButton_5.setBounds(50, 858, 22, 21);
	    frame.getContentPane().add(btnNewButton_5);
	    
	    JButton btnNewButton_5_1 = new JButton("adress icon");
	    btnNewButton_5_1.setBounds(50, 892, 22, 21);
	    frame.getContentPane().add(btnNewButton_5_1);
	    
	    JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
	    lblNewLabel_4.setBounds(98, 829, 125, 16);
	    frame.getContentPane().add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_10 = new JLabel("23100000000");
	    lblNewLabel_10.setBounds(98, 860, 78, 16);
	    frame.getContentPane().add(lblNewLabel_10);
	    
	    JLabel lblNewLabel_11 = new JLabel("Egnatias, 156");
	    lblNewLabel_11.setBounds(98, 894, 78, 16);
	    frame.getContentPane().add(lblNewLabel_11);
	    
	    JLabel lblNewLabel_3 = new JLabel("Head of company :");
	    lblNewLabel_3.setBounds(48, 711, 128, 16);
	    frame.getContentPane().add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_6 = new JLabel("Boss' Profile");
	    lblNewLabel_6.setBounds(50, 743, 106, 16);
	    frame.getContentPane().add(lblNewLabel_6);
	    frame.setVisible(true);
	}
}
