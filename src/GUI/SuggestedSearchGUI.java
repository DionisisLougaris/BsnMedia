package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SuggestedSearchGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuggestedSearchGUI window = new SuggestedSearchGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuggestedSearchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 430, 300);
		frame.setVisible(true);
		frame.setLocation(920, 110);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBackground(new Color(255, 250, 240));
		list.setBounds(12, 40, 385, 151);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Go to Profile");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(121, 204, 169, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Do you mean...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(26, 11, 285, 25);
		frame.getContentPane().add(lblNewLabel);
	}
}
