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
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

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
		frame.setTitle("User's Profile");
		frame.setBounds(100, 100, 893, 1020);
		//Setting exact position of frame 
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(aUser.getMyAccount().getUsername());
		//This is needed so the main frames cannot close from the x and only for the login screen so everything is saved!
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//Adding logo to frame
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
		searchtext.setBounds(437, 38, 317, 30);
		searchtext.setBackground(new Color(255, 250, 240));
		panel.add(searchtext);
		searchtext.setColumns(10);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton searchbutton = new JButton(search);
		searchbutton.setBounds(766, 27, 55, 44);
		searchbutton.setContentAreaFilled(false); 
		searchbutton.setFocusPainted(false); 
		searchbutton.setOpaque(false);
		searchbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search bar on the Frontend Profile
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
	    buttongotomyprofile.setBounds(12, 13, 84, 69);
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
		panel.add(buttongotomyprofile);
		
		JTextArea frontEndProfileUser = new JTextArea();
		frontEndProfileUser.setBounds(32, 561, 810, 336);
		TreeSet<Post> visiblePosts = new TreeSet<Post>();
		if (loggedUser.equals(profileUser)) {
			visiblePosts = loggedUser.getListOfPosts(); //If the logged in user goes to his public profile, he will be able to see all his posts
		}else {
			visiblePosts = loggedUser.returnVisiblePosts(profileUser);
		}
		//adding user's posts to his wall
		for( Post post : visiblePosts)
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
	        frontEndProfileUser.append("----------------------------------------------------------------------------------------------------------"
	        		+ "---------------------------------------------------------------------------------------"
	        		+ ""+ "\n\r");
	        frontEndProfileUser.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+post.getPostScope()+" | "+formatDateTime+ "\n\r");
		}
		frontEndProfileUser.setEditable(false);
		frontEndProfileUser.setLineWrap(true);
		frontEndProfileUser.setBackground(new Color(255, 250, 240));
		JScrollPane scrollPanePost = new JScrollPane(frontEndProfileUser);
		scrollPanePost.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPanePost.setBounds(32, 561, 810, 336);
		panel.add(scrollPanePost);

		String namelastname = profileUser.getFirstName() + " " + profileUser.getLastName();
		JLabel labelnamelastname= new JLabel(namelastname);
		labelnamelastname.setBounds(108, 240, 504, 26);
		labelnamelastname.setFont(new Font("Tahoma", Font.PLAIN, 19));
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
		labelemail.setBounds(130, 413, 194, 16);
		labelemail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelemail.setForeground(new Color(255, 0, 0));
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
		
		
		//adding section if user is of type employee
		JLabel apartOfLabel = new JLabel("Currently apart of:");
		apartOfLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apartOfLabel.setBounds(108, 287, 133, 16);
		if (profileUser instanceof Employee) {
			panel.add(apartOfLabel);
		}
		
		if (profileUser instanceof Employee) {
			
			JButton btnGroupA = new JButton("Group A");
			btnGroupA.setOpaque(false);
			btnGroupA.setBorder(null);
			btnGroupA.setForeground(Color.RED);
			btnGroupA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGroupA.setBackground(new Color(255, 153, 102));
			btnGroupA.setBounds(74, 318, 68, 23);
			if (profileUser.getGroups().size()>=1) {
				
				panel.add(btnGroupA);
				
				btnGroupA.addActionListener(new ActionListener() {
					
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
		
		//Showing addConnection and buttonchat buttons if User is not visiting his own frontend profile
		if(!loggedUser.equals(profileUser))
		{
			//Showing addConnection button if User is not already connected with the user whose profile he visited
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
				//Showing buttonchat button if User is already connected with the user whose profile he visited
				JButton buttonchat= new JButton("Chat");
				buttonchat.setContentAreaFilled(false); 
				buttonchat.setFocusPainted(false); 
				buttonchat.setOpaque(false);
				buttonchat.setCursor(new Cursor(Cursor.HAND_CURSOR));
				buttonchat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
								//Finding correct conversation between two users and opening their chat
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
		
		JLabel infolabel = new JLabel("Information:");
		infolabel.setBounds(74, 376, 84, 16);
		infolabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(infolabel);
		
		String telephone = profileUser.getTelephone();
		JLabel labeltelephone = new JLabel(telephone);
		labeltelephone.setBounds(131, 442, 110, 16);
		panel.add(labeltelephone);
		
		String address = profileUser.getAddress();
		JLabel labeladdress = new JLabel(address);
		labeladdress.setBounds(131, 476, 110, 16);
		labeladdress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labeladdress.setForeground(new Color(255, 0, 0));
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
			
			JLabel mutualconnectionsLabel = new JLabel("Mutual connections("+usersconnection.mutualConnections().size()+")");
			mutualconnectionsLabel.setBounds(709, 382, 130, 16);
			panel.add(mutualconnectionsLabel);
			
			//Adding mutual their connections to list
			DefaultListModel<String> mutualmodel = new DefaultListModel<String>();
			JList<String> listmutualconnections = new JList<String>();
			listmutualconnections.setBackground(new Color(255, 250, 240));
			listmutualconnections.setBounds(709, 409, 133, 127);
			for (User theUser: usersconnection.mutualConnections()) {
				mutualmodel.addElement(theUser.getFirstName()+" "+theUser.getLastName());
			}
			listmutualconnections.setModel(mutualmodel);
			JScrollPane scrollPaneMutuals = new JScrollPane(listmutualconnections);
			scrollPaneMutuals.setBorder(new LineBorder(Color.BLACK, 2));
			scrollPaneMutuals.setBounds(709, 409, 133, 127);
			panel.add(scrollPaneMutuals);
		}
		
		//Button that leads to BSN Support Page
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton helpButton = new JButton(help);
		helpButton.setBounds(824, 929, 46, 38);
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
		panel.add(helpButton);
		
		JLabel emailLabel = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
		emailLabel.setBounds(85, 409, 28, 25);
		panel.add(emailLabel);
		
		JLabel telephoneLabel = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
		telephoneLabel.setBounds(85, 438, 28, 25);
		panel.add(telephoneLabel);
		
		JLabel addressLabel = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
		addressLabel.setBounds(85, 467, 28, 25);
		panel.add(addressLabel);
		
		JLabel birthdayLabel = new JLabel(new ImageIcon("label_backgrounds/birthday_cake_20px.png"));
		birthdayLabel.setBounds(85, 501, 28, 25);
		panel.add(birthdayLabel);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 887, 985);
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		backgroundLabel.setIcon(new ImageIcon(imagerisizeb));
		panel.add(backgroundLabel);
	}
}
