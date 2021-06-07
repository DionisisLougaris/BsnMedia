package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditCompanyGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCompanyGUI window = new EditCompanyGUI();
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
	public EditCompanyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 602);
		frame.setLocation(870, 200);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 750, 152);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Change company photo");
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(584, 178, 178, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(190, 233, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 268, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 303, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 338, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(190, 389, 178, 88);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 178, 88);
		panel_1.add(scrollPane);
		
		textField_4 = new JTextField();
		scrollPane.setViewportView(textField_4);
		textField_4.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		lblNewLabel = new JLabel("Company name");
		lblNewLabel.setBounds(83, 236, 95, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Company telephone");
		lblNewLabel_1.setBounds(54, 271, 124, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(122, 306, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Company email");
		lblNewLabel_3.setBounds(83, 341, 95, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Company info");
		lblNewLabel_4.setBounds(92, 389, 86, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		btnNewButton_1 = new JButton("Save All");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(71, 503, 279, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("View Changes");
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(455, 503, 156, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		frame.setVisible(true);
	}

}
