package GUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Employee;
import entities.Help;
import entities.User;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class HelpGUI {

	private JFrame frame;
	private JTextField txtYourFullName;
	private JTextField txtYourEmail;
	private JTextArea txtYourMessage;
	private JButton btnNewButton_2;
	private User myUser;


	public HelpGUI(User myUser) throws IOException {
		initialize(myUser);
	}

	private void initialize(User user) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		myUser = user;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 410, 749);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JButton btnlogoback = new JButton();
		BufferedImage imageicon2 = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
		ImageIcon image2 = new ImageIcon(imageicon2);
		Image imagerisize2 = image2.getImage().getScaledInstance(110, 110, 170) ;
		btnlogoback.setIcon(new ImageIcon(imagerisize2));
		btnlogoback.setContentAreaFilled(false); 
		btnlogoback.setToolTipText("Go back to your profile");
		btnlogoback.setFocusPainted(false); 
		btnlogoback.setOpaque(false);
		btnlogoback.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnlogoback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(myUser instanceof Chief)
				{
					try {
						new BackendProfileChiefGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(myUser instanceof Boss)
				{
					try {
						new BackendProfileBossGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(myUser instanceof Employee)
				{
					try {
						new BackendProfileEmployeeGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnlogoback.setBounds(22, 11, 127, 122);
		panel.add(btnlogoback);
		
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
		lblNewLabel_15_1_1_1_1_1.setBounds(44, 605, 304, 20);
		panel.add(lblNewLabel_15_1_1_1_1_1);
		
		JLabel lblNewLabel_14_1_1_2_1_1 = new JLabel("** You 'll have to be logged in our email in order");
		lblNewLabel_14_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_2_1_1.setBounds(19, 670, 329, 27);
		panel.add(lblNewLabel_14_1_1_2_1_1);
		
		JLabel lblNewLabel_14_1_1_2_1_1_1 = new JLabel(" to recieve authentication email for resetting password **");
		lblNewLabel_14_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_2_1_1_1.setBounds(22, 692, 376, 27);
		panel.add(lblNewLabel_14_1_1_2_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(410, 0, 465, 749);
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
		
		btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnNewButton_2.setForeground(Color.WHITE);
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
		
		JLabel lblNewLabel_21 = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/Background_help_page-0001.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(465, 749,0) ;
		lblNewLabel_21.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel_21.setBounds(0, 0, 465, 749);
		panel_1.add(lblNewLabel_21);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(0, 704, 875, 269);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get in touch!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 76, 163, 27);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Creators:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(445, 79, 105, 27);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kosmidou Eleni");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(445, 148, 117, 20);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleni-kosmidou-8227231b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kwnstantinidi Styliana");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(445, 177, 163, 20);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/styliana-konstantinidi-6506411b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lougaris Dionisis");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(445, 206, 117, 23);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/dionisis-lougaris/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mazaraki Eleni");
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(445, 235, 105, 20);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleni-mazaraki-a820211b9/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Machairas Panagiotis");
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(687, 119, 176, 20);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/panagiotis-machairas-9263841b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Melissanidou Kwnstantina");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(687, 148, 176, 20);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/konstantina-melissanidou-b6b3981b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mertzanhs Antwnhs");
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(687, 177, 147, 20);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/antonis-mertzanis-713a87214/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nanou Eleftheria");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(687, 209, 117, 20);
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleftheria-nanou"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Stefou Giwrgos-Giannis");
		lblNewLabel_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(687, 235, 151, 20);
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/george-stefou-713a9a1b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Charakopoulos Minas-Theodoros");
		lblNewLabel_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_11.setForeground(Color.BLUE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(445, 119, 222, 20);
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("www.linkedin.com/in/minas-theodoros-charakopoulos-59b2531b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\u00A9 Bsn Media 2021");
		lblNewLabel_12.setBounds(12, 240, 117, 16);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon("label_backgrounds/gmail_32px.png"));
		lblNewLabel_18.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_18.setToolTipText("Send an email to our Company");
		lblNewLabel_18.setBounds(150, 128, 56, 46);
		lblNewLabel_18.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("mailto:itintelligenceuomgmail.com"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon("label_backgrounds/linkedin_32px.png"));
		lblNewLabel_19.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_19.setToolTipText("Find us on LinkedIn");
		lblNewLabel_19.setBounds(93, 128, 56, 46);
		lblNewLabel_19.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/it-intelligence-7067aa213/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon("label_backgrounds/github_32px.png"));
		lblNewLabel_20.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_20.setToolTipText("Find us on GitHub");
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
		
		ButtonListener listener = new ButtonListener();
		btnNewButton_2.addActionListener(listener);
		
		frame.setTitle("User's Suport");
	}
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource().equals(btnNewButton_2)) {
				
				String userFullName = txtYourFullName.getText();
				String usersEmail = txtYourEmail.getText();
				String usersMessage = txtYourMessage.getText();
				
				if (!userFullName.equalsIgnoreCase("") && !usersEmail.equalsIgnoreCase("") && !usersMessage.equalsIgnoreCase("")
					&& !userFullName.equalsIgnoreCase("Your full name...") && !usersEmail.equalsIgnoreCase("Your email...") && !usersMessage.equalsIgnoreCase("Your message...")) {
					Help questionFromUser = new Help(userFullName, usersEmail, usersMessage);
					questionFromUser.sendQuestion();
				}else {
					String message = "There are fields you need to fill in!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}	
			}
		}
	}
}
