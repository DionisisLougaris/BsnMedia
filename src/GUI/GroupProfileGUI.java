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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Component;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GroupProfileGUI {

	private JFrame frame;
	private JTextField textField;
	private static User myUser;
	private static Group myGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupProfileGUI window = new GroupProfileGUI(myUser,myGroup);
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
	public GroupProfileGUI(User myUser,Group myGroup) throws IOException {
		this.myUser = myUser;
		this.myGroup = myGroup;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(401, 33, 286, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(myGroup.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(38, 122, 274, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project in Progress:");
		lblNewLabel_1.setBounds(38, 220, 125, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project Status:");
		lblNewLabel_2.setBounds(38, 249, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Project Description:");
		lblNewLabel_3.setBounds(38, 278, 117, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Group Evaluation:");
		lblNewLabel_4.setBounds(38, 350, 117, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSlider slider = new JSlider();
		slider.setOpaque(false);
		slider.setBackground(Color.WHITE);
		slider.setBounds(240, 350, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBounds(452, 346, 86, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group");
		lblNewLabel_5.setBounds(38, 447, 115, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Posts of the Group");
		lblNewLabel_6.setBounds(323, 447, 117, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 492, 193, 306);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(322, 489, 507, 393);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		for( Post post : myGroup.getGroupPosts())
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = post.getTimestamp().format(formatter);
	        textArea.append("------------------------------------------------------------------------------------------------------------"+ ""+ "\n\r");
	        textArea.append(post.getContent()+" | "+post.getCreator().getFirstName()+" | "+formatDateTime+ "\n\r");
		}
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(0, 0, 507, 393);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_7 = new JLabel("/100");
		lblNewLabel_7.setBackground(SystemColor.text);
		lblNewLabel_7.setBounds(185, 350, 48, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setText(myGroup.getMyProject().getName());
		lblNewLabel_8.setBounds(187, 220, 125, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setText(myGroup.getMyProject().getStatus());
		lblNewLabel_9.setBounds(185, 249, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setText(myGroup.getMyProject().getDescription());
		lblNewLabel_10.setBounds(187, 278, 507, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton_1_1 = new JButton("logo");
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setFocusPainted(false); 
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setBounds(38, 20, 62, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
		JButton btnNewButton_1 = new JButton(search);
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(696, 33, 55, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1_1 = new JButton(help);
		btnNewButton_1_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1_1.setFocusPainted(false); 
		btnNewButton_1_1_1.setOpaque(false);
		btnNewButton_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(817, 922, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		BufferedImage imagebackground = ImageIO.read(new File("label_backgrounds/background.jpg"));
		ImageIcon imageb = new ImageIcon(imagebackground);
		Image imagerisizeb = imageb.getImage().getScaledInstance(887, 991, 140) ;
		lblNewLabel_11.setIcon(new ImageIcon(imagerisizeb));
		lblNewLabel_11.setBounds(0, 0, 875, 973);
		frame.getContentPane().add(lblNewLabel_11);
	}
}
