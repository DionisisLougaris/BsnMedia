package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditGroupProjectGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditGroupProjectGUI window = new EditGroupProjectGUI();
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
	public EditGroupProjectGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 678);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 29, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 167, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("In progress");
		rdbtnNewRadioButton.setBounds(183, 198, 127, 25);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Done");
		rdbtnNewRadioButton_1.setBounds(314, 198, 127, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Change project name");
		lblNewLabel.setBounds(44, 32, 127, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Change project description");
		lblNewLabel_1.setBounds(12, 67, 159, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Change group name");
		lblNewLabel_2.setBounds(44, 170, 127, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Current situation");
		lblNewLabel_3.setBounds(70, 202, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 281, 141, 190);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(118, 0, 21, 188);
		panel.add(scrollBar);
		
		JLabel lblNewLabel_4 = new JLabel("Add more users");
		lblNewLabel_4.setBounds(89, 264, 101, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Users in the group");
		lblNewLabel_5.setBounds(429, 264, 127, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add to group");
		btnNewButton.setBounds(70, 484, 141, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(414, 484, 142, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save all");
		btnNewButton_2.setBounds(355, 541, 116, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View changes");
		btnNewButton_3.setBounds(494, 541, 116, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Help");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBounds(526, 593, 97, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(183, 64, 308, 90);
		frame.getContentPane().add(scrollPane_2);
		
		textField_1 = new JTextField();
		scrollPane_2.setViewportView(textField_1);
		textField_1.setColumns(10);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollPane_2.setRowHeaderView(scrollBar_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(414, 281, 135, 190);
		frame.getContentPane().add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(112, 0, 21, 188);
		panel_1.add(scrollBar_1);
	}
}
