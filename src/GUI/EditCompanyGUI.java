package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import entities.*;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditCompanyGUI {

	private JFrame frame;
	private JTextField tfCompanyName;
	private JTextField tfCompanyTelephone;
	private JTextField tfAddress;
	private JTextField tfCompanyEmail;
	private JTextField tfCompanyInfo;
	private JLabel lblCompanyName;
	private JLabel lblCompanyTelephone;
	private JLabel lblAddress;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnSaveAll;
	private JButton btnNewButton_2;
	
	private Boss boss;

	/**
	 * Launch the application.
	 *
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
	public EditCompanyGUI(Boss theBoss) {
		initialize(theBoss);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Boss theBoss) {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 602);
		frame.setLocation(870, 200);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 750, 152);
		frame.getContentPane().add(panel);
		
		boss = theBoss;
		
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
		
		tfCompanyName = new JTextField();
		tfCompanyName.setBounds(190, 233, 116, 22);
		frame.getContentPane().add(tfCompanyName);
		tfCompanyName.setColumns(10);
		
		tfCompanyTelephone = new JTextField();
		tfCompanyTelephone.setBounds(190, 268, 116, 22);
		frame.getContentPane().add(tfCompanyTelephone);
		tfCompanyTelephone.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(190, 303, 116, 22);
		frame.getContentPane().add(tfAddress);
		tfAddress.setColumns(10);
		
		tfCompanyEmail = new JTextField();
		tfCompanyEmail.setBounds(190, 338, 116, 22);
		frame.getContentPane().add(tfCompanyEmail);
		tfCompanyEmail.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(190, 389, 178, 88);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 178, 88);
		panel_1.add(scrollPane);
		
		tfCompanyInfo = new JTextField();
		scrollPane.setViewportView(tfCompanyInfo);
		tfCompanyInfo.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		lblCompanyName = new JLabel("Company name");
		lblCompanyName.setBounds(83, 236, 95, 16);
		frame.getContentPane().add(lblCompanyName);
		
		lblCompanyTelephone	 = new JLabel("Company telephone");
		lblCompanyTelephone.setBounds(54, 271, 124, 16);
		frame.getContentPane().add(lblCompanyTelephone);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(122, 306, 56, 16);
		frame.getContentPane().add(lblAddress);
		
		lblNewLabel_3 = new JLabel("Company email");
		lblNewLabel_3.setBounds(83, 341, 95, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Company info");
		lblNewLabel_4.setBounds(92, 389, 86, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		btnSaveAll = new JButton("Save All");
		btnSaveAll.setContentAreaFilled(false); 
		btnSaveAll.setFocusPainted(false); 
		btnSaveAll.setOpaque(false);
		btnSaveAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!tfCompanyName.getText().equals("") && !tfCompanyTelephone.getText().equals("") && !tfAddress.getText().equals("") && !tfCompanyEmail.getText().equals("") )
				{
					boss.editCompanyInfo(tfCompanyName.getText(), tfCompanyInfo.getText(), tfCompanyTelephone.getText(), tfAddress.getText(), tfCompanyEmail.getText());
				}
			}
		});
		btnSaveAll.setBounds(71, 503, 279, 25);
		frame.getContentPane().add(btnSaveAll);
		
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
