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
		frame.setBounds(100, 100, 893, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(440, 35, 286, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Group Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(38, 122, 158, 54);
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
		slider.setBounds(240, 350, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JLabel lblNewLabel_7 = new JLabel("/10");
		lblNewLabel_7.setBackground(SystemColor.text);
		lblNewLabel_7.setBounds(185, 350, 48, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(187, 220, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(185, 249, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(187, 278, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JButton btnNewButton_1_1 = new JButton("logo");
		btnNewButton_1_1.setBounds(38, 20, 62, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("icon");
		btnNewButton_1.setBounds(744, 34, 55, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Help");
		btnNewButton_1_1_1.setBounds(817, 922, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1_1);
	}
}
