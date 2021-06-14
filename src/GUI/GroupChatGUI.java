package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JTextArea;

import entities.Group;
import entities.Message;
import entities.Storage;
import entities.User;

public class GroupChatGUI {

	private JFrame frame;
	private static User myUser;
	private static Group myGroup;

	
	public GroupChatGUI(Group aGroup,User aUser) {
		myUser= aUser;
		myGroup = aGroup;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 686, 794);
		frame.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		frame.setResizable(false);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/BSNlogo.jpg");
		frame.setIconImage(logoimage.getImage());
		
		JLabel lblNewLabel = new JLabel("Your messages are encrypted");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 15, 215, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Group Conversation of \" \"");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(12, 46, 593, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(12, 84, 643, 652);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(12, 13, 619, 493);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(0, 0, 619, 493);
		ArrayList<String> ourMessages = new ArrayList<>();
		ourMessages= Storage.retrieveConversation(myGroup.getMyConversation());

			for(int i=0;i<ourMessages.size();i++)
			{
				textArea.append(ourMessages.get(i)+ "\n\r");
			}
			
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(12, 519, 521, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setBounds(0, 0, 521, 120);
		panel_2.add(textArea_1);
		
		Icon send = new ImageIcon("Buttons_backgrounds/email_send_60px.png");
		JButton btnNewButton_1_1_1 = new JButton(send);
		btnNewButton_1_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1_1.setFocusPainted(false); 
		btnNewButton_1_1_1.setOpaque(false);
		btnNewButton_1_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String myText = textArea_1.getText();
				Message myMessage = new Message(myText,myUser);
				myGroup.getMyConversation().addMessage(myMessage);
				textArea.setText(""); 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String formatDateTime = myMessage.getTimesent().format(formatter);
				textArea.append(myMessage.getContent()+" | Date:"+formatDateTime+" | "+myMessage.getSender().getMyAccount().getUsername()+" | \n");
			}
		});
		btnNewButton_1_1_1.setBounds(556, 555, 62, 62);
		panel.add(btnNewButton_1_1_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.setContentAreaFilled(false); 
		btnNewButton_1_1.setFocusPainted(false); 
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(609, 742, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1);
		
		Icon lock = new ImageIcon("label_backgrounds/lock_32px.png");
		JLabel lblNewLabel_2 = new JLabel(lock);
		lblNewLabel_2.setBounds(22, 14, 46, 38);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
