package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
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
import java.awt.Component;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 250, 240));
		searchField.setBounds(293, 40, 286, 26);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);
		frame.setResizable(false);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/BSNlogo.jpg");
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
		
		JLabel lblNewLabel_1 = new JLabel("Project in Progress:");
		lblNewLabel_1.setBounds(38, 220, 125, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project Status:");
		lblNewLabel_2.setBounds(38, 249, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Project Description:");
		lblNewLabel_3.setBounds(38, 278, 117, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JTextArea projectDesc = new JTextArea(myGroup.getMyProject().getDescription());
		projectDesc.setBackground(new Color(255, 250, 240));
		projectDesc.setEditable(false);
		projectDesc.setLineWrap(true);
		projectDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		projectDesc.setBounds(189, 279, 390, 46);
		frame.getContentPane().add(projectDesc);
		
		JLabel lblNewLabel_4 = new JLabel("Group Evaluation: (/100)");
		lblNewLabel_4.setBounds(38, 350, 141, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSlider slider = new JSlider();
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider.setOpaque(false);
		slider.setBackground(Color.WHITE);
		slider.setBounds(189, 346, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton submitRatingButton = new JButton("Submit");
		submitRatingButton.setContentAreaFilled(false); 
		submitRatingButton.setFocusPainted(false); 
		submitRatingButton.setOpaque(false);
		submitRatingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitRatingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group("+myGroup.getGroupMembers().size()+")");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(38, 447, 190, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Posts of the Group");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(323, 447, 506, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(323, 474, 506, 408);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea postTextArea = new JTextArea();
		for( Post post : myGroup.getGroupPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
	        postTextArea.append("------------------------------------------------------------------------------------------------------------"+ ""+ "\n\r");
	        postTextArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+formatDateTime+ "\n\r");
		}
		postTextArea.setBackground(new Color(255, 250, 240));
		postTextArea.setEditable(false);
		postTextArea.setLineWrap(true);
		postTextArea.setBounds(0, 0, 507, 408);
		panel_1.add(postTextArea);
		
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
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		JList<String> membersList = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (Employee theMember: myGroup.getGroupMembers()) {
			listModel.addElement(theMember.getFirstName()+" "+theMember.getLastName()+" | "+theMember.getMyAccount().getUsername());
		}
		membersList.setModel(listModel);
		membersList.setBackground(new Color(255, 250, 240));
		membersList.setBounds(38, 474, 190, 408);
		frame.getContentPane().add(membersList);
		
		JLabel lblNewLabel = new JLabel("Who supervise this Group?");
		lblNewLabel.setBounds(38, 401, 168, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Learn Now!");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(196, 399, 114, 18);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new FrontEndProfileGUI(myUser, myGroup.getSupervisor());
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel_11.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel_11.setBounds(0, 0, 875, 981);
		frame.getContentPane().add(lblNewLabel_11);
	}
}
