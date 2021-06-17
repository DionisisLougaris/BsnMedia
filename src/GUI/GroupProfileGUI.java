package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Employee;
import entities.GeneralNotification;
import entities.Group;
import entities.Post;
import entities.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class GroupProfileGUI {

	private JFrame frame;
	private JTextField searchField;
	private static User myUser;
	private static Group myGroup;


	public GroupProfileGUI(User myUser,Group myGroup) throws IOException {
		initialize(myUser, myGroup);
	}

	private void initialize(User user, Group group) throws IOException {
		frame = new JFrame();
		frame.setTitle("Group Profile");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		//Setting exact position of frame 
		frame.setLocation(500, 0);
		//This is needed so the main frames cannot close from the x and only for the login screen so everything is saved!
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 250, 240));
		searchField.setBounds(293, 40, 286, 26);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);
		frame.setResizable(false);
		
		//Adding logo to frame
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		myUser = user;
		myGroup = group;
		
		JLabel groupNameLabel = new JLabel();
		groupNameLabel.setForeground(new Color(255, 0, 0));
		groupNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groupNameLabel.setText(myGroup.getName());
		groupNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 28));
		groupNameLabel.setBounds(38, 122, 825, 54);
		frame.getContentPane().add(groupNameLabel);
		
		JLabel projectinProgressLabel = new JLabel("Project in Progress:");
		projectinProgressLabel.setBounds(38, 220, 125, 16);
		frame.getContentPane().add(projectinProgressLabel);
		
		JLabel projectStatusLabel = new JLabel("Project Status:");
		projectStatusLabel.setBounds(38, 249, 97, 16);
		frame.getContentPane().add(projectStatusLabel);
		
		JLabel projectDescriptionLabel = new JLabel("Project Description:");
		projectDescriptionLabel.setBounds(38, 278, 117, 16);
		frame.getContentPane().add(projectDescriptionLabel);
		
		JTextArea projectDesc = new JTextArea(myGroup.getMyProject().getDescription());
		projectDesc.setBackground(new Color(255, 250, 240));
		projectDesc.setEditable(false);
		projectDesc.setLineWrap(true);
		projectDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		projectDesc.setBounds(189, 279, 390, 46);
		frame.getContentPane().add(projectDesc);
		
		JLabel groupEvaluationLabel = new JLabel("Group Evaluation: (/100)");
		groupEvaluationLabel.setBounds(38, 350, 141, 16);
		frame.getContentPane().add(groupEvaluationLabel);
		
		JSlider slider = new JSlider();
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider.setOpaque(false);
		slider.setBackground(Color.WHITE);
		slider.setBounds(199, 340, 200, 26);
		frame.getContentPane().add(slider);
		
		JLabel groupRatingLabel = new JLabel("Group rating: ");
		groupRatingLabel.setBounds(550, 350, 86, 16);
		frame.getContentPane().add(groupRatingLabel);
		
		JLabel notratedLabel = new JLabel();
		if (myGroup.getRating() == -1) {
			notratedLabel.setText("Not rated yet!");
		}else {
			notratedLabel.setText(String.valueOf(myGroup.getRating()));
		}
		notratedLabel.setBounds(648, 350, 125, 16);
		frame.getContentPane().add(notratedLabel);
		
		JButton submitRatingButton = new JButton("Submit");
		submitRatingButton.setContentAreaFilled(false); 
		submitRatingButton.setFocusPainted(false); 
		submitRatingButton.setOpaque(false);
		submitRatingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitRatingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Boss rates groups performance (through jslider) after project is done. Group rating is visible on group's profile
				if(myUser instanceof Boss)
				{
					if (myGroup.getMyProject().getStatus().equalsIgnoreCase("done")) {
						
					int value = (int)slider.getValue();
					myGroup.setRating(value);
					//Creating and adding notification to all Members
					GeneralNotification genNot = new GeneralNotification("Your group has been rated!",myGroup,"groupRated");
					myGroup.getSupervisor().getListOfNotifications().add(genNot);
					for(int i=0;i<myGroup.getGroupMembers().size();i++)
					{
						myGroup.getGroupMembers().get(i).getListOfNotifications().add(genNot);
					}
					String message = "You have successfully rated "+myGroup.getName()+"!\n All members have been notified!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
						
					notratedLabel.setText(String.valueOf(myGroup.getRating()));					
					}else {
						String message = "Please come back to rate when project is finished!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					String message = "Only the boss can rate Groups...";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		submitRatingButton.setBounds(401, 346, 86, 25);
		frame.getContentPane().add(submitRatingButton);
		
		JLabel membersofGroupLabel = new JLabel("Members of Group("+myGroup.getGroupMembers().size()+")");
		membersofGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		membersofGroupLabel.setBounds(38, 447, 190, 16);
		frame.getContentPane().add(membersofGroupLabel);
		
		JLabel groupPostsLabel = new JLabel("Posts of the Group");
		groupPostsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groupPostsLabel.setBounds(323, 447, 506, 16);
		frame.getContentPane().add(groupPostsLabel);
		
		JTextArea postTextArea = new JTextArea();
		postTextArea.setBounds(395, 476, 434, 406);
		//Adding posts of group members scoped to group to the textarea
		for( Post post : myGroup.getGroupPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
	        postTextArea.append("--------------------------------------------------------------------------------------------------------"+ ""+ "\n\r");
	        postTextArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+formatDateTime+ "\n\r");
		}
		postTextArea.setBackground(new Color(255, 250, 240));
		postTextArea.setEditable(false);
		postTextArea.setLineWrap(true);
		frame.getContentPane().add(postTextArea);
		JScrollPane scrollPanePost = new JScrollPane(postTextArea);
		scrollPanePost.setBounds(401, 476, 428, 406);
		scrollPanePost.setBorder(new LineBorder(Color.WHITE, 2));
		frame.getContentPane().add(scrollPanePost);
		
		JLabel projectName = new JLabel();
		projectName.setText(myGroup.getMyProject().getName());
		projectName.setBounds(187, 220, 457, 16);
		frame.getContentPane().add(projectName);
		
		JLabel projectSituation = new JLabel();
		projectSituation.setText(myGroup.getMyProject().getStatus());
		projectSituation.setBounds(185, 249, 125, 16);
		frame.getContentPane().add(projectSituation);
		
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
	    JButton goBackButton = new JButton(imagebutton);
		goBackButton.setContentAreaFilled(false); 
		goBackButton.setFocusPainted(false); 
		goBackButton.setBorderPainted(false);
		goBackButton.setToolTipText("Go back to your Profile");
		goBackButton.setOpaque(false);
		goBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goBackButton.addActionListener(new ActionListener() {
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
		goBackButton.setBounds(20, 20, 80, 66);
		frame.getContentPane().add(goBackButton);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton searchButton = new JButton(search);
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search bar on groups profile
				
				String searchedText = searchField.getText();
				if(!searchedText.isEmpty()) {
					boolean result;
					try {
						result = myUser.getMyAccount().getMyCompany().searchObject(searchedText, myUser);

						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							suggestedOptions = myUser.getMyAccount().getMyCompany().suggestedSearchOption(searchedText);
							new SearchSuggestionsGUI(suggestedOptions, myUser, frame);
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
		searchButton.setBounds(589, 27, 55, 39);
		frame.getContentPane().add(searchButton);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton helpButton = new JButton(help);
		helpButton.setContentAreaFilled(false); 
		helpButton.setFocusPainted(false); 
		helpButton.setOpaque(false);
		helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpButton.setToolTipText("BSN Support");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that leads to the help page
				try {
					frame.setVisible(false);
					new HelpGUI(myUser);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		helpButton.setBounds(808, 922, 55, 48);
		frame.getContentPane().add(helpButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(0, 174, 877, 16);
		frame.getContentPane().add(separator);
		
		//Adding group members to groups profile on jlist
		JList<String> membersList = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (Employee theMember: myGroup.getGroupMembers()) {
			listModel.addElement(theMember.getFirstName()+" "+theMember.getLastName()+" | "+theMember.getMyAccount().getUsername());
		}
		membersList.setModel(listModel);
		membersList.setBackground(new Color(255, 250, 240));
		membersList.setBounds(38, 474, 190, 408);
		frame.getContentPane().add(membersList);
		JScrollPane scrollPaneMembers = new JScrollPane(membersList);
		scrollPaneMembers.setBounds(38, 476, 190, 406);
		frame.getContentPane().add(scrollPaneMembers);
		
		JLabel supervisorLabel = new JLabel("Who is the group's supervisor");
		supervisorLabel.setBounds(38, 401, 190, 14);
		frame.getContentPane().add(supervisorLabel);
		
		JButton checkSupervisorProfileButton = new JButton("Check here");
		checkSupervisorProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkSupervisorProfileButton.setForeground(Color.RED);
		checkSupervisorProfileButton.setBounds(226, 399, 114, 18);
		checkSupervisorProfileButton.setOpaque(false);
		checkSupervisorProfileButton.setContentAreaFilled(false);
		checkSupervisorProfileButton.setBorderPainted(false);
		checkSupervisorProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//visiting supervisor's profile
					new FrontEndProfileGUI(myUser, myGroup.getSupervisor());
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(checkSupervisorProfileButton);
		
		//adding label which acts like background for the frame
		JLabel lblNewLabel_11 = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel_11.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel_11.setBounds(0, 0, 887, 981);
		frame.getContentPane().add(lblNewLabel_11);
			
	}
}
