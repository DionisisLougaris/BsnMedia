package GUI;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;

public class HelpGUI {

	private JFrame frame;
	private JTextField txtYourFullName;
	private JTextField txtYourEmail;
	private JTextArea txtYourMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpGUI window = new HelpGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public HelpGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 410, 705);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
	   
		BufferedImage imageicon = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
	    ImageIcon image = new ImageIcon(imageicon);
		Image imagerisize = image.getImage().getScaledInstance(30, 40, 20) ;
		ImageIcon imagebutton = new ImageIcon(imagerisize);
	    JButton buttonLogo = new JButton( imagebutton);
	    buttonLogo.setBounds(824, 929, 46, 38);
		buttonLogo.setBorderPainted(false);
		buttonLogo.setFocusPainted(false);
		buttonLogo.setContentAreaFilled(false);
		panel.add(buttonLogo);
		buttonLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(34, 26, 73, 65);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_13 = new JLabel("Frequently asked questions:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_13.setBounds(34, 144, 314, 27);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("1. Is Bsn Media accesible online?");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(34, 201, 314, 16);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Bsn Media is currently not accesible online");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15.setBounds(44, 230, 356, 16);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14_1 = new JLabel("2. Who is the audience of Bsn Media?");
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1.setBounds(34, 293, 275, 16);
		panel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Bsn Media is addressed to companies with");
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1.setBounds(44, 322, 265, 16);
		panel.add(lblNewLabel_15_1);
		
		JLabel lblNewLabel_15_1_1 = new JLabel("a big social network!");
		lblNewLabel_15_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1.setBounds(44, 340, 265, 16);
		panel.add(lblNewLabel_15_1_1);
		
		JLabel lblNewLabel_14_1_1 = new JLabel("3. Can there be more than one Boss");
		lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1.setBounds(34, 383, 251, 16);
		panel.add(lblNewLabel_14_1_1);
		
		JLabel lblNewLabel_14_1_1_1 = new JLabel("on the Bsn Media network?");
		lblNewLabel_14_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1.setBounds(56, 402, 364, 16);
		panel.add(lblNewLabel_14_1_1_1);
		
		JLabel lblNewLabel_15_1_1_1 = new JLabel("Currently no.");
		lblNewLabel_15_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1_1.setBounds(44, 436, 265, 16);
		panel.add(lblNewLabel_15_1_1_1);
		
		JLabel lblNewLabel_14_1_1_2 = new JLabel("4. Can there be more than one Company");
		lblNewLabel_14_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_2.setBounds(39, 478, 291, 16);
		panel.add(lblNewLabel_14_1_1_2);
		
		JLabel lblNewLabel_14_1_1_1_1 = new JLabel("on the Bsn Media network?");
		lblNewLabel_14_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1_1.setBounds(56, 496, 364, 16);
		panel.add(lblNewLabel_14_1_1_1_1);
		
		JLabel lblNewLabel_15_1_1_1_1 = new JLabel("Currently no.");
		lblNewLabel_15_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1_1_1.setBounds(44, 525, 265, 16);
		panel.add(lblNewLabel_15_1_1_1_1);
		
		JLabel lblNewLabel_15_2 = new JLabel(" and can be used localy from one computer.");
		lblNewLabel_15_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_2.setBounds(44, 249, 356, 16);
		panel.add(lblNewLabel_15_2);
		
		JLabel lblNewLabel_14_1_1_2_1 = new JLabel("5. Can I use the greek alphabet on Bsn Media?");
		lblNewLabel_14_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_2_1.setBounds(34, 565, 314, 27);
		panel.add(lblNewLabel_14_1_1_2_1);
		
		JLabel lblNewLabel_15_1_1_1_1_1 = new JLabel("No, greek letters cannot be encrypted currently.");
		lblNewLabel_15_1_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_15_1_1_1_1_1.setBounds(44, 605, 304, 16);
		panel.add(lblNewLabel_15_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(410, 0, 465, 705);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_13_1 = new JLabel("Send us a message!");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_13_1.setBounds(41, 143, 314, 27);
		panel_1.add(lblNewLabel_13_1);
		
		txtYourFullName = new JTextField();
		txtYourFullName.setText("Your full name...");
		txtYourFullName.setBounds(57, 230, 273, 36);
		txtYourFullName.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtYourFullName.setText("");
            }
        });
		panel_1.add(txtYourFullName);
		txtYourFullName.setColumns(10);
		
		txtYourEmail = new JTextField();
		txtYourEmail.setText("Your email...");
		txtYourEmail.setColumns(10);
		txtYourEmail.setBounds(57, 301, 273, 36);
		txtYourEmail.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtYourEmail.setText("");
            }
        });
		panel_1.add(txtYourEmail);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(0, 0, 1, 626);
		panel_1.add(verticalStrut);
		
		txtYourMessage = new JTextArea();
		txtYourMessage.setText("Your message...");
		txtYourMessage.setColumns(10);
		txtYourMessage.setBounds(57, 386, 273, 100);
		txtYourMessage.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtYourMessage.setText("");
            }
        });
		panel_1.add(txtYourMessage);
		
		JLabel lblNewLabel_16 = new JLabel("Name");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(57, 207, 56, 16);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_16_1 = new JLabel("email");
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16_1.setBounds(57, 279, 56, 16);
		panel_1.add(lblNewLabel_16_1);
		
		JLabel lblNewLabel_17 = new JLabel("Message");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setBounds(57, 361, 73, 27);
		panel_1.add(lblNewLabel_17);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(243, 528, 97, 25);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(0, 704, 875, 269);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get in touch!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 60, 163, 27);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Creators:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(349, 41, 77, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kosmidou Eleni");
		lblNewLabel_2.setBounds(475, 83, 105, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kwnstantinidi Styliana");
		lblNewLabel_3.setBounds(475, 128, 134, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lougaris Dionisis");
		lblNewLabel_4.setBounds(475, 163, 105, 16);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mazaraki Eleni");
		lblNewLabel_5.setBounds(475, 206, 105, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Machairas Panagiotis");
		lblNewLabel_6.setBounds(701, 42, 134, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Melissanidou Kwnstantina");
		lblNewLabel_7.setBounds(701, 83, 146, 16);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mertzanhs Antwnhs");
		lblNewLabel_8.setBounds(701, 128, 117, 16);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nanou Eleftheria");
		lblNewLabel_9.setBounds(701, 163, 117, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stefou Giwrgos-Giannis");
		lblNewLabel_10.setBounds(701, 206, 134, 16);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Charakopoulos Minas-Theodoros");
		lblNewLabel_11.setBounds(467, 42, 222, 16);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\u00A9 Bsn Media 2021");
		lblNewLabel_12.setBounds(12, 240, 117, 16);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon("label_backgrounds/gmail_32px.png"));
		lblNewLabel_18.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_18.setBounds(150, 128, 56, 46);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon("label_backgrounds/linkedin_32px.png"));
		lblNewLabel_19.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_19.setBounds(93, 128, 56, 46);
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://linkedin.com"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon("label_backgrounds/github_32px.png"));
		lblNewLabel_20.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_20.setBounds(39, 128, 56, 46);
		lblNewLabel_20.addMouseListener(new MouseAdapter() {
       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/DionisisLougaris/BsnMedia"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_20);
		
		frame.setVisible(true); // den anoige diaforetika
	
	}
}
