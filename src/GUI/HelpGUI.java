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
	private JButton submitButton;
	private User myUser;


	public HelpGUI(User myUser) throws IOException {
		initialize(myUser);
	}

	private void initialize(User user) throws IOException {
		frame = new JFrame();
		frame.setTitle("BSN Support");
		frame.setBounds(100, 100, 883, 1009);
		//Setting exact position of frame 
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		//This is needed so the main frames cannot close from the x and only for the login screen so everything is saved!
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		
		//Adding logo to frame
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
		Image imagerisize2 = image2.getImage().getScaledInstance(110, 110, 150) ;
		btnlogoback.setIcon(new ImageIcon(imagerisize2));
		btnlogoback.setContentAreaFilled(false); 
		btnlogoback.setToolTipText("Go back to your profile");
		btnlogoback.setFocusPainted(false); 
		btnlogoback.setOpaque(false);
		btnlogoback.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnlogoback.setBounds(22, 11, 127, 122);
		btnlogoback.setBorderPainted(false);
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
		panel.add(btnlogoback);
		
		
		//FAQs and answers
		JLabel askedQuestionsLabel = new JLabel("Frequently asked questions:");
		askedQuestionsLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		askedQuestionsLabel.setBounds(34, 144, 314, 27);
		panel.add(askedQuestionsLabel);
		
		JLabel question1Label = new JLabel("1. Is Bsn Media accesible online?");
		question1Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question1Label.setBounds(34, 201, 314, 16);
		panel.add(question1Label);
		
		JLabel answerTo1QuestionLabel1 = new JLabel("Bsn Media is currently not accesible online");
		answerTo1QuestionLabel1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo1QuestionLabel1.setBounds(44, 230, 356, 16);
		panel.add(answerTo1QuestionLabel1);
		
		JLabel question2Label = new JLabel("2. Who is the audience of Bsn Media?");
		question2Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question2Label.setBounds(34, 293, 275, 16);
		panel.add(question2Label);
		
		JLabel answerTo2QuestionLabel1 = new JLabel("Bsn Media is addressed to companies with");
		answerTo2QuestionLabel1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo2QuestionLabel1.setBounds(44, 322, 265, 16);
		panel.add(answerTo2QuestionLabel1);
		
		JLabel answerTo2QuestionLabel2 = new JLabel("a big social network!");
		answerTo2QuestionLabel2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo2QuestionLabel2.setBounds(44, 340, 265, 16);
		panel.add(answerTo2QuestionLabel2);
		
		JLabel question3_1Label = new JLabel("3. Can there be more than one Boss");
		question3_1Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question3_1Label.setBounds(34, 383, 251, 16);
		panel.add(question3_1Label);
		
		JLabel question3_2Label = new JLabel("on the Bsn Media network?");
		question3_2Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question3_2Label.setBounds(56, 402, 364, 16);
		panel.add(question3_2Label);
		
		JLabel answerTo3QuestionLabel = new JLabel("Currently no.");
		answerTo3QuestionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo3QuestionLabel.setBounds(44, 436, 265, 16);
		panel.add(answerTo3QuestionLabel);
		
		JLabel question4_1Label = new JLabel("4. Can there be more than one Company");
		question4_1Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question4_1Label.setBounds(39, 478, 291, 16);
		panel.add(question4_1Label);
		
		JLabel question4_2Label = new JLabel("on the Bsn Media network?");
		question4_2Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question4_2Label.setBounds(56, 496, 364, 16);
		panel.add(question4_2Label);
		
		JLabel answerTo4QuestionLabel = new JLabel("Currently no.");
		answerTo4QuestionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo4QuestionLabel.setBounds(44, 525, 265, 16);
		panel.add(answerTo4QuestionLabel);
		
		JLabel answerTo1QuestionLabel2 = new JLabel(" and can be used localy from one computer.");
		answerTo1QuestionLabel2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo1QuestionLabel2.setBounds(44, 249, 356, 16);
		panel.add(answerTo1QuestionLabel2);
		
		JLabel question5Label = new JLabel("5. Can I use the greek alphabet on Bsn Media?");
		question5Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		question5Label.setBounds(34, 565, 314, 27);
		panel.add(question5Label);
		
		JLabel answerTo5QuestionLabel = new JLabel("No, greek letters cannot be encrypted currently.");
		answerTo5QuestionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		answerTo5QuestionLabel.setBounds(44, 605, 304, 20);
		panel.add(answerTo5QuestionLabel);
		
		JLabel notes1Label = new JLabel("** You 'll have to be logged in our email in order");
		notes1Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		notes1Label.setBounds(19, 670, 329, 27);
		panel.add(notes1Label);
		
		JLabel notes2Label = new JLabel(" to recieve authentication email for resetting password **");
		notes2Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		notes2Label.setBounds(22, 692, 376, 27);
		panel.add(notes2Label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(410, 0, 465, 749);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Contact form
		JLabel sendMessageLabel = new JLabel("Send us a message!");
		sendMessageLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		sendMessageLabel.setBounds(41, 143, 314, 27);
		panel_1.add(sendMessageLabel);
		
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
		
		JLabel nameForSendingMessageLabel = new JLabel("Name");
		nameForSendingMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameForSendingMessageLabel.setBounds(57, 207, 56, 16);
		panel_1.add(nameForSendingMessageLabel);
		
		JLabel emailForSendingMessageLabel = new JLabel("email");
		emailForSendingMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailForSendingMessageLabel.setBounds(57, 279, 56, 16);
		panel_1.add(emailForSendingMessageLabel);
		
		JLabel messageLabel = new JLabel("Message");
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		messageLabel.setBounds(57, 361, 73, 27);
		panel_1.add(messageLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		submitButton.setForeground(Color.WHITE);
		submitButton.setContentAreaFilled(false); 
		submitButton.setFocusPainted(false); 
		submitButton.setOpaque(false);
		submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitButton.setBounds(243, 528, 97, 25);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(submitButton);
		
		JLabel backgroundLabel = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/Background_help_page-0001.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(465, 749,0) ;
		backgroundLabel.setIcon(new ImageIcon(imagerisizeb));
		backgroundLabel.setBounds(0, 0, 465, 749);
		panel_1.add(backgroundLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(0, 704, 875, 269);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel getInTouchLabel = new JLabel("Get in touch!");
		getInTouchLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		getInTouchLabel.setBounds(39, 76, 163, 27);
		panel_2.add(getInTouchLabel);
		
		//Hyperlinking creators' linkedin profiles
		JLabel creatorsLabel = new JLabel("Creators:");
		creatorsLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		creatorsLabel.setBounds(445, 79, 105, 27);
		panel_2.add(creatorsLabel);
		
		JLabel member2Label = new JLabel("Kosmidou Eleni");
		member2Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member2Label.setForeground(Color.BLUE);
		member2Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member2Label.setBounds(445, 148, 117, 20);
		member2Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleni-kosmidou-8227231b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member2Label);
		
		JLabel member3Label = new JLabel("Kwnstantinidi Styliana");
		member3Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member3Label.setForeground(Color.BLUE);
		member3Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member3Label.setBounds(445, 177, 163, 20);
		member3Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/styliana-konstantinidi-6506411b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member3Label);
		
		JLabel member4Label = new JLabel("Lougaris Dionisis");
		member4Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member4Label.setForeground(Color.BLUE);
		member4Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member4Label.setBounds(445, 206, 117, 23);
		member4Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/dionisis-lougaris/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member4Label);
		
		JLabel member5Label = new JLabel("Mazaraki Eleni");
		member5Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member5Label.setForeground(Color.BLUE);
		member5Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member5Label.setBounds(445, 235, 105, 20);
		member5Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleni-mazaraki-a820211b9/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member5Label);
		
		JLabel member6Label = new JLabel("Machairas Panagiotis");
		member6Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member6Label.setForeground(Color.BLUE);
		member6Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member6Label.setBounds(687, 119, 176, 20);
		member6Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/panagiotis-machairas-9263841b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member6Label);
		
		JLabel member7Label = new JLabel("Melissanidou Kwnstantina");
		member7Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member7Label.setForeground(Color.BLUE);
		member7Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member7Label.setBounds(687, 148, 176, 20);
		member7Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/konstantina-melissanidou-b6b3981b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member7Label);
		
		JLabel member8Label = new JLabel("Mertzanhs Antwnhs");
		member8Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member8Label.setForeground(Color.BLUE);
		member8Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member8Label.setBounds(687, 177, 147, 20);
		member8Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/antonis-mertzanis-713a87214/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member8Label);
		
		JLabel member9Label = new JLabel("Nanou Eleftheria");
		member9Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member9Label.setForeground(Color.BLUE);
		member9Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member9Label.setBounds(687, 209, 117, 20);
		member9Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/eleftheria-nanou"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member9Label);
		
		JLabel member10Label = new JLabel("Stefou Giwrgos-Giannis");
		member10Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member10Label.setForeground(Color.BLUE);
		member10Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member10Label.setBounds(687, 235, 151, 20);
		member10Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/george-stefou-713a9a1b8/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member10Label);
		
		JLabel member1Label = new JLabel("Charakopoulos Minas-Theodoros");
		member1Label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		member1Label.setForeground(Color.BLUE);
		member1Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		member1Label.setBounds(445, 119, 222, 20);
		member1Label.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("www.linkedin.com/in/minas-theodoros-charakopoulos-59b2531b9"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(member1Label);
		
		//Hyperlinking communication methods with It intelligence and presenting github repository
		JLabel footerLabel = new JLabel("\u00A9 Bsn Media 2021");
		footerLabel.setBounds(12, 240, 117, 16);
		panel_2.add(footerLabel);
		
		JLabel gmailLabel = new JLabel("");
		gmailLabel.setIcon(new ImageIcon("label_backgrounds/gmail_32px.png"));
		gmailLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gmailLabel.setToolTipText("Send an email to our Company");
		gmailLabel.setBounds(150, 128, 56, 46);
		gmailLabel.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("mailto:itintelligenceuomgmail.com"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(gmailLabel);
		
		JLabel linkedinLabel = new JLabel("");
		linkedinLabel.setIcon(new ImageIcon("label_backgrounds/linkedin_32px.png"));
		linkedinLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		linkedinLabel.setToolTipText("Find us on LinkedIn");
		linkedinLabel.setBounds(93, 128, 56, 46);
		linkedinLabel.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/it-intelligence-7067aa213/"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(linkedinLabel);
		
		JLabel githubLabel = new JLabel("");
		githubLabel.setIcon(new ImageIcon("label_backgrounds/github_32px.png"));
		githubLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		githubLabel.setToolTipText("Find us on GitHub");
		githubLabel.setBounds(39, 128, 56, 46);
		githubLabel.addMouseListener(new MouseAdapter() {
       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/DionisisLougaris/BsnMedia"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel_2.add(githubLabel);
		
		ButtonListener listener = new ButtonListener();
		submitButton.addActionListener(listener);
		
	}
	
	//Button listener for the form's submit button
	class ButtonListener implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
			// Checking if form fields were filled correctly
			
			if (e.getSource().equals(submitButton)) {
				
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
