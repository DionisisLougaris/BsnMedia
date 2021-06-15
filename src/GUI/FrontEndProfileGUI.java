package GUI;


import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Connection;
import entities.Conversation;
import entities.Employee;
import entities.Group;
import entities.Post;
import entities.User;
import entities.privateConversation;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Color;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField searchtext;
	private static User loggedUser;
	private static User profileUser;

	public FrontEndProfileGUI(User tUser,User aUser) throws IOException {
		initialize(tUser, aUser);
	}

	private void initialize(User tUser, User aUser) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(aUser.getMyAccount().getUsername());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());	    
			
		loggedUser = tUser; //The user who is connected
		profileUser = aUser; //The other User who, we visit his profile
		
		Connection usersconnection = new Connection(loggedUser,profileUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 887, 985);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(108, 75, 183, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon defaultprofilephoto = new ImageIcon(profileUser.getImage());
		Image imagerisize = defaultprofilephoto.getImage().getScaledInstance(181, 152, 170) ;
		ImageIcon ndefaultprofilephoto = new ImageIcon(imagerisize);
		JLabel labeldefaulprofilephoto = new JLabel(ndefaultprofilephoto);
		labeldefaulprofilephoto.setBounds(0, 0, 183, 152);
		panel_1.add(labeldefaulprofilephoto);
		
		searchtext = new JTextField();
		searchtext.setBackground(new Color(255, 250, 240));
		searchtext.setBounds(437, 38, 317, 30);
		panel.add(searchtext);
		searchtext.setColumns(10);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton searchbutton = new JButton(search);
		searchbutton.setContentAreaFilled(false); 
		searchbutton.setFocusPainted(false); 
		searchbutton.setOpaque(false);
		searchbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchedText = searchtext.getText();
				if(!searchedText.isEmpty()) {
					boolean result;
					try {
						result = loggedUser.getMyAccount().getMyCompany().searchObject(searchedText, loggedUser);

						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							suggestedOptions = loggedUser.getMyAccount().getMyCompany().suggestedSearchOption(searchedText);
							new SearchSuggestionsGUI(suggestedOptions, loggedUser, frame);
						}else {
							frame.setVisible(false);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		searchbutton.setBounds(766, 27, 55, 44);
		panel.add(searchbutton);
		
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File("Buttons_backgrounds/BSN-logo-white.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon image = new ImageIcon(buttonIcon);
		Image imagerisizel = image.getImage().getScaledInstance(80, 45, 60) ;
		ImageIcon imagebutton = new ImageIcon(imagerisizel);
	    JButton buttongotomyprofile = new JButton(imagebutton);
	    buttongotomyprofile.setFocusPainted(false);
		buttongotomyprofile.setContentAreaFilled(false); 
		buttongotomyprofile.setFocusPainted(false); 
		buttongotomyprofile.setToolTipText("Go back to your Profile");
		buttongotomyprofile.setOpaque(false);
		buttongotomyprofile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttongotomyprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(loggedUser instanceof Chief){
					try {
						new BackendProfileChiefGUI(loggedUser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(loggedUser instanceof Boss){
					try {
						new BackendProfileBossGUI(loggedUser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(loggedUser instanceof Employee){
					try {
						new BackendProfileEmployeeGUI(loggedUser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		buttongotomyprofile.setBounds(12, 13, 84, 69);
		panel.add(buttongotomyprofile);
		
		JTextArea ausersposts = new JTextArea();
		for( Post post : aUser.getListOfPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
	        ausersposts.append("----------------------------------------------------------------------------------------------------------"
	        		+ "-------------------------------------------------------------------------------------------"
	        		+ ""+ "\n\r");
	        ausersposts.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
		}
		ausersposts.setEditable(false);
		ausersposts.setLineWrap(true);
		ausersposts.setBackground(new Color(255, 250, 240));
		ausersposts.setBounds(32, 561, 810, 336);
		panel.add(ausersposts);
		
		String namelastname = profileUser.getFirstName() + " " + profileUser.getLastName();
		JLabel labelnamelastname= new JLabel(namelastname);
		labelnamelastname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelnamelastname.setBounds(108, 240, 504, 26);
		panel.add(labelnamelastname);
		
		String currentlypost = "";
		if(profileUser instanceof Employee)
		{
			currentlypost = "Employee ||"+profileUser.getCompanyPost();
		}
		else if(profileUser instanceof Chief)
		{
			currentlypost = "Chief ||"+profileUser.getCompanyPost();
		}
		else if(profileUser instanceof Boss)
		{
			currentlypost = "Boss ||"+profileUser.getCompanyPost();
		}
		JLabel labelcompanypost = new JLabel(currentlypost);
		labelcompanypost.setBounds(108, 266, 283, 16);
		panel.add(labelcompanypost);
		
		String email = profileUser.getMyAccount().getEmail();
		JLabel labelemail = new JLabel(email);
		labelemail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelemail.setForeground(new Color(255, 0, 0));
        labelemail.setBounds(130, 413, 194, 16);
        labelemail.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("mailto:"+profileUser.getMyAccount().getEmail()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
		panel.add(labelemail);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(108, 287, 133, 16);
		if (profileUser instanceof Employee) {
			panel.add(lblNewLabel_5);
		}
		
		if (profileUser instanceof Employee) {
			
			JButton btnNewButton = new JButton("Group A");
			btnNewButton.setOpaque(false);
			btnNewButton.setBorder(null);
			btnNewButton.setForeground(Color.RED);
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.setBackground(new Color(255, 153, 102));
			btnNewButton.setBounds(74, 318, 68, 23);
			if (profileUser.getGroups().size()>=1) {
				
				panel.add(btnNewButton);
				
				btnNewButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							new GroupProfileGUI(profileUser, profileUser.getGroups().get(0));
							frame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
			
			JButton btnGroupB = new JButton("Group B");
			btnGroupB.setOpaque(false);
			btnGroupB.setForeground(Color.RED);
			btnGroupB.setBorder(null);
			btnGroupB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGroupB.setBackground(new Color(255, 153, 102));
			btnGroupB.setBounds(152, 318, 71, 23);
			if (profileUser.getGroups().size()>=2) {
				
				panel.add(btnGroupB);
				
				btnGroupB.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							new GroupProfileGUI(profileUser, profileUser.getGroups().get(1));
							frame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
			
			JButton btnGroupC = new JButton("Group C");
			btnGroupC.setOpaque(false);
			btnGroupC.setForeground(Color.RED);
			btnGroupC.setBorder(null);
			btnGroupC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGroupC.setBackground(new Color(255, 153, 102));
			btnGroupC.setBounds(232, 318, 68, 23);
			if (profileUser.getGroups().size()==3) {
				
				panel.add(btnGroupC);
				
				btnGroupC.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							new GroupProfileGUI(profileUser, profileUser.getGroups().get(2));
							frame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		}
		
		if(!loggedUser.equals(profileUser))
		{
			if(!usersconnection.areConnected()) {
				
				 JButton addConnection = new JButton("Add connection");
				 addConnection.setContentAreaFilled(false); 
				 addConnection.setFocusPainted(false); 
				 addConnection.setOpaque(false);
				 addConnection.setCursor(new Cursor(Cursor.HAND_CURSOR));
				 addConnection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						usersconnection.sendConnectionRequest();
					}
				});
				addConnection.setBounds(710, 313, 131, 25);
				panel.add(addConnection);
			}
			else
			{
				JButton buttonchat= new JButton("Chat");
				buttonchat.setContentAreaFilled(false); 
				buttonchat.setFocusPainted(false); 
				buttonchat.setOpaque(false);
				buttonchat.setCursor(new Cursor(Cursor.HAND_CURSOR));
				buttonchat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
								ArrayList<Conversation> listOfConversation = loggedUser.getListOfConversations();
								Conversation selectedUserToChat = null;
								
								for (Conversation theConversation: listOfConversation) {
									
									if ((((privateConversation)theConversation).getDiscussant1().equals(loggedUser) && ((privateConversation)theConversation).getDiscussant2().equals(profileUser)) ||
										(((privateConversation)theConversation).getDiscussant2().equals(loggedUser) && ((privateConversation)theConversation).getDiscussant1().equals(profileUser))) {
										
										selectedUserToChat = theConversation;
										break;
									}
								}
								
								if(selectedUserToChat == null) {
									 String message = "Something went Wrong!";
										JOptionPane.showMessageDialog(new JFrame(), message, "Message",
										        JOptionPane.INFORMATION_MESSAGE);
								}else {
									new PrivateChatGUI(profileUser, loggedUser, selectedUserToChat);
								}
							}
				
				});
				buttonchat.setBounds(620, 313, 62, 25);
				panel.add(buttonchat);
				
				JButton removeConnection = new JButton("Remove connection");
				removeConnection.setContentAreaFilled(false); 
				removeConnection.setFocusPainted(false); 
				removeConnection.setOpaque(false);
				removeConnection.setCursor(new Cursor(Cursor.HAND_CURSOR));
				removeConnection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						usersconnection.removeConnection();
						
					}
				});
				removeConnection.setBounds(694, 313, 148, 25);
				panel.add(removeConnection);
			}
		}
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(74, 376, 84, 16);
		panel.add(lblNewLabel_9);
		
		String telephone = profileUser.getTelephone();
		JLabel labeltelephone = new JLabel(telephone);
		labeltelephone.setBounds(131, 442, 110, 16);
		panel.add(labeltelephone);
		
		String address = profileUser.getAddress();
		JLabel labeladdress = new JLabel(address);
		labeladdress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labeladdress.setForeground(new Color(255, 0, 0));
		labeladdress.setBounds(131, 476, 110, 16);
		labeladdress.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/"+profileUser.getAddress()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	labeladdress.setText("<html><a href=''>" + profileUser.getAddress()+ "</a></html>");
            }
		});
		panel.add(labeladdress);
		
		String birthday = profileUser.getBirthday();
		JLabel labelbirthday = new JLabel(birthday);
		labelbirthday.setBounds(130, 510, 123, 16);
		panel.add(labelbirthday);
		
		if (!loggedUser.equals(profileUser)) {
			
			JLabel lblNewLabel_13 = new JLabel("Mutual connections("+usersconnection.mutualConnections().size()+")");
			lblNewLabel_13.setBounds(709, 382, 130, 16);
			panel.add(lblNewLabel_13);
			
			DefaultListModel<String> mutualmodel = new DefaultListModel<String>();
			JList<String> listmutualconnections = new JList<String>();
			listmutualconnections.setBackground(new Color(255, 250, 240));
			listmutualconnections.setBounds(709, 409, 133, 127);
			for (User theUser: usersconnection.mutualConnections()) {
				mutualmodel.addElement(theUser.getFirstName()+" "+theUser.getLastName());
			}
			listmutualconnections.setModel(mutualmodel);
			panel.add(listmutualconnections);
		}
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton helpButton = new JButton(help);
		helpButton.setContentAreaFilled(false); 
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.setVisible(false);
					new HelpGUI(loggedUser);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		helpButton.setBounds(824, 929, 46, 38);
		panel.add(helpButton);
		
		JLabel lblNewLabel_14 = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
		lblNewLabel_14.setBounds(85, 409, 28, 25);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
		lblNewLabel_14_1.setBounds(85, 438, 28, 25);
		panel.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_14_2 = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
		lblNewLabel_14_2.setBounds(85, 467, 28, 25);
		panel.add(lblNewLabel_14_2);
		
		JLabel lblNewLabel_14_3 = new JLabel(new ImageIcon("label_backgrounds/birthday_cake_20px.png"));
		lblNewLabel_14_3.setBounds(85, 501, 28, 25);
		panel.add(lblNewLabel_14_3);
		
		JLabel lblNewLabel = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel.setBounds(0, 0, 887, 985);
		panel.add(lblNewLabel);
	}
}
