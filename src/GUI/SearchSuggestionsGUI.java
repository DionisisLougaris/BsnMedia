package GUI;

import javax.swing.JFrame;

import entities.User;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class SearchSuggestionsGUI {
	
	ArrayList<String> SuggestedOptions;

	private JFrame frame;
	private User loggedUser;
	private JButton searchButton;
	private JList<String> list; 
	private JFrame frameBefore;

	public SearchSuggestionsGUI(ArrayList<String> suggested, User theUser, JFrame theFrame) {
		initialize(suggested, theUser, theFrame);
	}

	
	private void initialize(ArrayList<String> suggested, User theUser, JFrame theFrame) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 260, 299);
		frame.setVisible(true);
		frame.setLocation(920, 110);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		SuggestedOptions = suggested;
		loggedUser = theUser;
		frameBefore = theFrame;
		
		list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		if(SuggestedOptions.size()>0) {
			for(String name: SuggestedOptions) {
				model.addElement(name);
			}
		}else {
			model.addElement("No results");
		}
		list.setModel(model);
		list.setBackground(new Color(255, 250, 240));
		list.setBounds(12, 40, 221, 151);
		frame.getContentPane().add(list);
		
		searchButton = new JButton("Go to Profile");
		searchButton.setBackground(new Color(255, 250, 240));
		searchButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setBounds(55, 204, 131, 25);
		frame.getContentPane().add(searchButton);
		
		JLabel suggestedLabel = new JLabel("Do you mean...");
		suggestedLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		suggestedLabel.setBounds(26, 11, 285, 25);
		frame.getContentPane().add(suggestedLabel);
		
		ButtonListener listener = new ButtonListener();
		searchButton.addActionListener(listener);
	}
	
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(searchButton)) {
				
				String selectedSuggestedSearch = list.getSelectedValue();
				
				if(selectedSuggestedSearch != null) {
					
					try {
						if (loggedUser.getMyAccount().getMyCompany().searchObject(selectedSuggestedSearch, loggedUser)) {
							frame.dispose();
							frameBefore.dispose();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					 String message = "Please select one of the suggested searches!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
