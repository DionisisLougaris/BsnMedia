package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class FrontEndProfileGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEndProfileGUI window = new FrontEndProfileGUI();
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
	public FrontEndProfileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 882, 1053);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(85, 105, 181, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile photo");
		lblNewLabel.setBounds(51, 66, 72, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(437, 38, 317, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("icon");
		btnNewButton.setBounds(766, 41, 55, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("logo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(12, 13, 62, 53);
		panel.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 586, 810, 362);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Name LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(113, 269, 137, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Company Post, ");
		lblNewLabel_2.setBounds(262, 279, 89, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Specialization");
		lblNewLabel_3.setBounds(363, 279, 78, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("example@gmail.com");
		lblNewLabel_4.setBounds(117, 313, 125, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Currently apart of:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(117, 348, 133, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Group A");
		lblNewLabel_6.setBounds(97, 377, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Group B");
		lblNewLabel_7.setBounds(165, 377, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Group C");
		lblNewLabel_8.setBounds(233, 377, 56, 16);
		panel.add(lblNewLabel_8);
		
		JButton btnNewButton_2 = new JButton("Chat");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(460, 345, 62, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add connection");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(545, 345, 131, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remove connection");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(688, 345, 148, 25);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("Information:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(69, 421, 84, 16);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("69000000000");
		lblNewLabel_10.setBounds(128, 462, 78, 16);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Valtetsioy, 3");
		lblNewLabel_11.setBounds(128, 491, 78, 16);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("19/12/01");
		lblNewLabel_12.setBounds(128, 520, 56, 16);
		panel.add(lblNewLabel_12);
		
		JButton btnNewButton_5 = new JButton("telephone icon");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(85, 460, 22, 21);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("adress icon");
		btnNewButton_5_1.setBounds(85, 487, 22, 21);
		panel.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("birthday icon");
		btnNewButton_5_2.setBounds(85, 516, 22, 21);
		panel.add(btnNewButton_5_2);
		
		JLabel lblNewLabel_13 = new JLabel("Mutual connections");
		lblNewLabel_13.setBounds(698, 406, 109, 16);
		panel.add(lblNewLabel_13);
		
		JList list = new JList();
		list.setBounds(688, 435, 133, 127);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(786, 435, 21, 127);
		panel.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(817, 599, 28, 362);
		panel.add(scrollBar_1);
		
		JButton btnNewButton_1_1 = new JButton("Help");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(824, 1002, 46, 38);
		panel.add(btnNewButton_1_1);
	}
}
