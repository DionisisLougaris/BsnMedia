package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import entities.*;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EditCompanyGUI {

	private JFrame frame;
	private JTextField tfCompanyName;
	private JTextField tfCompanyTelephone;
	private JTextField tfAddress;
	private JTextField tfCompanyEmail;
	private JTextArea tfCompanyInfo;
	private JLabel lblCompanyName;
	private JLabel lblCompanyTelephone;
	private JLabel lblAddress;
	private JLabel lblCompanyEmail;
	private JLabel lblCompanyInfo;
	private JButton btnSaveAll;
	private JButton btnViewChanges;
	
	private Boss boss;
	private JLabel lblCompanyPhoto;
	private Employee first5;
	
	/*
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setLocation(870, 200);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 750, 152);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCompanyPhoto = new JLabel("New label");
		lblCompanyPhoto.setBounds(0, 0, 750, 152);
		panel.add(lblCompanyPhoto);
		
		
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(boss.getMyAccount().getMyCompany().getImage()));
			ImageIcon imageBackground = new ImageIcon(imageicon);
		  Image imagerisize = imageBackground.getImage().getScaledInstance(740, 280, 140) ;
		  lblCompanyPhoto.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		boss = theBoss;
		
		JButton btnChangeCompanyPhoto = new JButton("Change company photo");
		btnChangeCompanyPhoto.setBackground(new Color(255, 153, 102));
		btnChangeCompanyPhoto.setForeground(new Color(255, 255, 255));
		btnChangeCompanyPhoto.setContentAreaFilled(false); 
		btnChangeCompanyPhoto.setFocusPainted(false); 
		btnChangeCompanyPhoto.setOpaque(false);
		btnChangeCompanyPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnChangeCompanyPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
			    dialog.setMode(FileDialog.LOAD);
			    dialog.setVisible(true);
			    String file = dialog.getFile();
			    boss.getMyAccount().getMyCompany().setImage(file);
			    
			    
				String message = "Your photo has been updated successfully!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnChangeCompanyPhoto.setBounds(584, 178, 178, 25);
		frame.getContentPane().add(btnChangeCompanyPhoto);
		
		tfCompanyName = new JTextField(boss.getMyAccount().getMyCompany().getName());
		tfCompanyName.setBorder(null);
		tfCompanyName.setBackground(new Color(255, 153, 102));
		tfCompanyName.setForeground(new Color(255, 255, 255));
		tfCompanyName.setBounds(190, 233, 116, 22);
		frame.getContentPane().add(tfCompanyName);
		tfCompanyName.setColumns(10);
		
		tfCompanyTelephone = new JTextField(boss.getMyAccount().getMyCompany().getTelephone());
		tfCompanyTelephone.setBorder(null);
		tfCompanyTelephone.setBackground(new Color(255, 153, 102));
		tfCompanyTelephone.setForeground(new Color(255, 255, 255));
		tfCompanyTelephone.setBounds(190, 268, 116, 22);
		frame.getContentPane().add(tfCompanyTelephone);
		tfCompanyTelephone.setColumns(10);
		
		tfAddress = new JTextField(boss.getMyAccount().getMyCompany().getAddress());
		tfAddress.setBorder(null);
		tfAddress.setBackground(new Color(255, 153, 102));
		tfAddress.setForeground(new Color(255, 255, 255));
		tfAddress.setBounds(190, 303, 116, 22);
		frame.getContentPane().add(tfAddress);
		tfAddress.setColumns(10);
		
		tfCompanyEmail = new JTextField(boss.getMyAccount().getMyCompany().getEmail());
		tfCompanyEmail.setBorder(null);
		tfCompanyEmail.setBackground(new Color(255, 153, 102));
		tfCompanyEmail.setForeground(new Color(255, 255, 255));
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
		
		tfCompanyInfo = new JTextArea(boss.getMyAccount().getMyCompany().getInfo());
		tfCompanyInfo.setBorder(null);
		tfCompanyInfo.setBackground(new Color(255, 153, 102));
		tfCompanyInfo.setForeground(new Color(255, 255, 255));
		tfCompanyInfo.setLineWrap(true);
		scrollPane.setViewportView(tfCompanyInfo);
		 
		tfCompanyInfo.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		lblCompanyName = new JLabel("Company name:");
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyName.setForeground(new Color(255, 255, 255));
		lblCompanyName.setBounds(83, 236, 95, 16);
		frame.getContentPane().add(lblCompanyName);
		
		lblCompanyTelephone	 = new JLabel("Company telephone:");
		lblCompanyTelephone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyTelephone.setForeground(new Color(255, 255, 255));
		lblCompanyTelephone.setBounds(54, 271, 124, 16);
		frame.getContentPane().add(lblCompanyTelephone);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(122, 306, 56, 16);
		frame.getContentPane().add(lblAddress);
		
		lblCompanyEmail = new JLabel("Company email:");
		lblCompanyEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyEmail.setForeground(new Color(255, 255, 255));
		lblCompanyEmail.setBounds(83, 341, 95, 16);
		frame.getContentPane().add(lblCompanyEmail);
		
		lblCompanyInfo = new JLabel("Company info:");
		lblCompanyInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompanyInfo.setForeground(new Color(255, 255, 255));
		lblCompanyInfo.setBounds(92, 389, 86, 16);
		frame.getContentPane().add(lblCompanyInfo);
		
		btnSaveAll = new JButton("Save All");
		btnSaveAll.setBackground(new Color(255, 153, 102));
		btnSaveAll.setForeground(new Color(255, 255, 255));
		btnSaveAll.setContentAreaFilled(false); 
		btnSaveAll.setFocusPainted(false); 
		btnSaveAll.setOpaque(false);
		btnSaveAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					boss.editCompanyInfo(tfCompanyName.getText(), tfCompanyInfo.getText(), tfCompanyTelephone.getText(), tfAddress.getText(), tfCompanyEmail.getText());
				
			
			}
		});
		btnSaveAll.setBounds(71, 503, 279, 25);
		frame.getContentPane().add(btnSaveAll);
		
		btnViewChanges = new JButton("View Changes");
		btnViewChanges.setBackground(new Color(255, 153, 102));
		btnViewChanges.setForeground(new Color(255, 255, 255));
		btnViewChanges.setContentAreaFilled(false); 
		btnViewChanges.setFocusPainted(false); 
		btnViewChanges.setOpaque(false);
		btnViewChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnViewChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CompanyProfileGUI(boss,boss.getMyAccount().getMyCompany());
			    frame.dispose();
				
			}
		});
		btnViewChanges.setBounds(455, 503, 156, 25);
		frame.getContentPane().add(btnViewChanges);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(190, 257, 116, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(190, 294, 116, 16);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(190, 329, 116, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(190, 361, 116, 2);
		frame.getContentPane().add(separator_3);
		
		frame.setVisible(true);
		frame.setTitle("Edit Company");
	}
}
