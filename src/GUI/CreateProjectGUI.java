package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateProjectGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProjectGUI window = new CreateProjectGUI();
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
	public CreateProjectGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 704);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(885, 200);
		textField = new JTextField();
		textField.setBounds(210, 23, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Project name :");
		lblNewLabel.setBounds(82, 26, 103, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Project description :");
		lblNewLabel_1.setBounds(59, 90, 126, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Deadline");
		lblNewLabel_2.setBounds(96, 193, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 190, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 284, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Group name :");
		lblNewLabel_3.setBounds(74, 287, 91, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JList list = new JList();
		list.setBounds(71, 399, 126, 157);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Select employees:");
		lblNewLabel_4.setBounds(71, 370, 136, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JList list_1 = new JList();
		list_1.setBounds(327, 399, 126, 157);
		frame.getContentPane().add(list_1);
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group :");
		lblNewLabel_5.setBounds(327, 370, 126, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add to Group");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(71, 571, 126, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(337, 571, 85, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(414, 609, 77, 22);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(210, 90, 116, 68);
		frame.getContentPane().add(textArea);
		
		
		frame.setTitle("Create project");
		
		
	}
}
