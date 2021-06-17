package GUI;

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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

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
		frame.setTitle("Group Chat");
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 686, 794);
		frame.getContentPane().setLayout(null);
		
		//Chat always appears in the middle of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//Putting the BSN logo on the frame
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		JLabel informationLabel = new JLabel("Your messages are encrypted");
		informationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		informationLabel.setBounds(80, 15, 215, 20);
		frame.getContentPane().add(informationLabel);
		
		JLabel convoNameLabel = new JLabel("Group Conversation of '"+myGroup.getName()+"'");
		convoNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		convoNameLabel.setBounds(12, 46, 593, 25);
		frame.getContentPane().add(convoNameLabel);
		
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
		
		JTextArea allMessagesTextArea = new JTextArea();
		allMessagesTextArea.setEditable(false);
		allMessagesTextArea.setLineWrap(true);
		allMessagesTextArea.setWrapStyleWord(true);
		allMessagesTextArea.setBounds(0, 0, 619, 493);
		
		//Presenting all the messages the Group has exchanged
		ArrayList<String> ourMessages = new ArrayList<>();
		ourMessages= Storage.retrieveConversation(myGroup.getMyConversation());

			for(int i=0;i<ourMessages.size();i++)
			{
				allMessagesTextArea.append(ourMessages.get(i)+ "\n\r");
			}
			
		panel_1.add(allMessagesTextArea);
		JScrollPane scrollPaneMessages = new JScrollPane(allMessagesTextArea);
		scrollPaneMessages.setBounds(0, 0, 619, 493);
		scrollPaneMessages.setBorder(new LineBorder(Color.WHITE, 2));
		panel_1.add(scrollPaneMessages);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(12, 519, 521, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea newMessageTextArea = new JTextArea();
		newMessageTextArea.setLineWrap(true);
		newMessageTextArea.setWrapStyleWord(true);
		newMessageTextArea.setBounds(0, 0, 521, 120);
		panel_2.add(newMessageTextArea);
		
		Icon send = new ImageIcon("Buttons_backgrounds/email_send_60px.png");
		JButton sendMessageButton = new JButton(send);
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setBounds(556, 555, 62, 62);
		sendMessageButton.setBorderPainted(false);
		sendMessageButton.setToolTipText("Send");
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sending and creating a message written by the User
				String myText = newMessageTextArea.getText();
				Message myMessage = new Message(myText,myUser);
				myGroup.getMyConversation().addMessage(myMessage);
				newMessageTextArea.setText(""); 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String formatDateTime = myMessage.getTimesent().format(formatter);
				allMessagesTextArea.append(myMessage.getContent()+" | Date:"+formatDateTime+" | "+myMessage.getSender().getMyAccount().getUsername()+" | \n");
			}
		});
		panel.add(sendMessageButton);
		
		Icon lock = new ImageIcon("label_backgrounds/lock_32px.png");
		JLabel lockLabel = new JLabel(lock);
		lockLabel.setBounds(22, 11, 46, 38);
		frame.getContentPane().add(lockLabel);
		
		JLabel noteLabel = new JLabel("(Write in English characters)");
		noteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		noteLabel.setBounds(489, 11, 166, 24);
		frame.getContentPane().add(noteLabel);
	}
}
