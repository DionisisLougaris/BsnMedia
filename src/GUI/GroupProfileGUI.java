package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JPanel;

public class GroupProfileGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupProfileGUI window = new GroupProfileGUI();
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
	public GroupProfileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(371, 27, 236, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(510, 62, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Group Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(38, 13, 158, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back  to Profile");
		btnNewButton_1.setBounds(690, 26, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Project in Progress:");
		lblNewLabel_1.setBounds(38, 117, 125, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project Status:");
		lblNewLabel_2.setBounds(38, 146, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Project Description:");
		lblNewLabel_3.setBounds(38, 175, 117, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Group Evaluation:");
		lblNewLabel_4.setBounds(38, 238, 117, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSlider slider = new JSlider();
		slider.setBounds(228, 238, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setBounds(440, 234, 86, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group");
		lblNewLabel_5.setBounds(69, 334, 115, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Posts of the Group");
		lblNewLabel_6.setBounds(534, 334, 117, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 352, 193, 306);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(384, 352, 404, 306);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("/10");
		lblNewLabel_7.setBackground(SystemColor.text);
		lblNewLabel_7.setBounds(183, 238, 48, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(175, 117, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(175, 146, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(175, 175, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
	}
}
