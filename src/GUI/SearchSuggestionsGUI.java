package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.User;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SearchSuggestionsGUI {
	
	ArrayList<String> SuggestedOptions;

	private JFrame frame;
	private User loggedUser;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SearchSuggestionsGUI window = new SearchSuggestionsGUI();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SearchSuggestionsGUI(ArrayList<String> suggested, User theUser) {
		initialize(suggested, theUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> suggested, User theUser) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 260, 299);
		frame.setVisible(true);
		frame.setLocation(920, 110);
		frame.getContentPane().setLayout(null);
		
		SuggestedOptions = suggested;
		loggedUser = theUser;
		
		JList<String> list = new JList<String>();
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
		
		btnNewButton = new JButton("Go to Profile");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(55, 204, 131, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Do you mean...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(26, 11, 285, 25);
		frame.getContentPane().add(lblNewLabel);
		
		ButtonListener listener = new ButtonListener();
		btnNewButton.addActionListener(listener);
	}
	
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnNewButton)) {
				
			}
		}
	}
}
