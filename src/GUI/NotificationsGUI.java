package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import entities.Notification;
import entities.User;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;

public class NotificationsGUI {

	private JFrame frmNotifications;
	private User user;
	private JFrame backendFrame;

	
	public NotificationsGUI(User theUser,JFrame backendFrame) throws IOException {
		initialize(theUser, backendFrame);
	}

	private void initialize(User theUser,JFrame mainFrame) throws IOException {
		frmNotifications = new JFrame();
		frmNotifications.setTitle("Notifications");
		frmNotifications.setResizable(false);
		frmNotifications.getContentPane().setBackground(new Color(255, 153, 102));
		frmNotifications.setBounds(1325, 88, 200, 244);
		frmNotifications.getContentPane().setLayout(null);
		frmNotifications.setVisible(true); 
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frmNotifications.setIconImage(logoimage.getImage());
		
		backendFrame = mainFrame;
		user = theUser;
		
		JList<String> list = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		TreeSet<Notification> generalNotifications = user.returnNotification();
		if (generalNotifications.size()>0) {
			for(Notification conReq: generalNotifications) {
				listModel.addElement(conReq.getNotificationContent());
			}
		}else {
			listModel.addElement("No Notifications..");
		}
		list.setModel(listModel);
		list.setBounds(10, 11, 172, 145);
		frmNotifications.getContentPane().add(list);
		JScrollPane scrollPaneNotifications = new JScrollPane(list);
		scrollPaneNotifications.setBounds(10, 11, 172, 145);
		scrollPaneNotifications.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmNotifications.getContentPane().add(scrollPaneNotifications);
		
		Icon takealook = new ImageIcon("Buttons_backgrounds/takealook_32px.png");
		JButton checkButton = new JButton(takealook);
		checkButton.setContentAreaFilled(false); 
		checkButton.setFocusPainted(false); 
		checkButton.setOpaque(false);
		checkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedNotificationString = list.getSelectedValue()+"";
				int index = list.getSelectedIndex();
				Notification selectedNotification = null;
				
				for(int i=0;i<user.getListOfNotifications().size();i++)
				{
					if(selectedNotificationString.equals(user.getListOfNotifications().get(i).getNotificationContent()))
					{
						selectedNotification=user.getListOfNotifications().get(i);
						break;
					}
				}
				if(selectedNotification != null)
				{
					user.getListOfNotifications().remove(selectedNotification);
					if (index != -1) {
						   listModel.remove(index);
					}
					if(selectedNotification.getAboutThisGroup()!=null)
					{
						try {
							new GroupProfileGUI(user,selectedNotification.getAboutThisGroup());
							backendFrame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(selectedNotification.getAboutThisUser()!=null)
					{
						try {
							new FrontEndProfileGUI(user,selectedNotification.getAboutThisUser());
							backendFrame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}	
				}
				else
				{
					String message = "You have not selected a notification!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		checkButton.setBounds(66, 158, 66, 38);
		frmNotifications.getContentPane().add(checkButton);
	}

}
