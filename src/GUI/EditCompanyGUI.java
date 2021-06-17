package GUI;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

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
	private JFrame backEndBoss;
	
	//This method is the constructor of class EditCompanyGUI.
	public EditCompanyGUI(Boss theBoss, JFrame bossBackend) {
		initialize(theBoss, bossBackend);
	}
    
	//This method initialize the properties of this gui.
	private void initialize(Boss theBoss, JFrame bossBackend) {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 602);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setLocation(870, 200);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Edit Company");
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		boss = theBoss;
		backEndBoss = bossBackend;
		
		JButton btnChangeCompanyPhoto = new JButton("Change company photo");
		btnChangeCompanyPhoto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnChangeCompanyPhoto.setBorder(new LineBorder(Color.WHITE, 3));
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
			    String path = dialog.getDirectory() + dialog.getFile();
			    
			    if (dialog.getDirectory() != null && dialog.getFile() != null) {
			    	
			    	String extension = path.substring(path.length() - 3);
			    	
			    	if (extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg")) {
			    		boss.getMyAccount().getMyCompany().setImage(path);
				    
			    		frame.dispose();
						 new EditCompanyGUI(boss, backEndBoss);
					String message = "Successful change! Go check the Changes!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
			    	}else {
						String message = "You can only select \".jpg or .png\" files!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
			    	}
			    }
			}
		});
		btnChangeCompanyPhoto.setBounds(510, 232, 131, 25);
		frame.getContentPane().add(btnChangeCompanyPhoto);
		
		tfCompanyName = new JTextField(boss.getMyAccount().getMyCompany().getName());
		tfCompanyName.setBorder(null);
		tfCompanyName.setBackground(new Color(255, 153, 102));
		tfCompanyName.setForeground(new Color(255, 255, 255));
		tfCompanyName.setBounds(190, 233, 178, 22);
		frame.getContentPane().add(tfCompanyName);
		tfCompanyName.setColumns(10);
		
		tfCompanyTelephone = new JTextField(boss.getMyAccount().getMyCompany().getTelephone());
		tfCompanyTelephone.setBorder(null);
		tfCompanyTelephone.setBackground(new Color(255, 153, 102));
		tfCompanyTelephone.setForeground(new Color(255, 255, 255));
		tfCompanyTelephone.setBounds(190, 268, 178, 22);
		frame.getContentPane().add(tfCompanyTelephone);
		tfCompanyTelephone.setColumns(10);
		
		tfAddress = new JTextField(boss.getMyAccount().getMyCompany().getAddress());
		tfAddress.setBorder(null);
		tfAddress.setBackground(new Color(255, 153, 102));
		tfAddress.setForeground(new Color(255, 255, 255));
		tfAddress.setBounds(190, 303, 166, 22);
		frame.getContentPane().add(tfAddress);
		tfAddress.setColumns(10);
		
		tfCompanyEmail = new JTextField(boss.getMyAccount().getMyCompany().getEmail());
		tfCompanyEmail.setBorder(null);
		tfCompanyEmail.setBackground(new Color(255, 153, 102));
		tfCompanyEmail.setForeground(new Color(255, 255, 255));
		tfCompanyEmail.setBounds(190, 338, 166, 22);
		frame.getContentPane().add(tfCompanyEmail);
		tfCompanyEmail.setColumns(10);
		
		JPanel panelCompanyInfo = new JPanel();
		panelCompanyInfo.setBounds(190, 389, 312, 88);
		frame.getContentPane().add(panelCompanyInfo);
		panelCompanyInfo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.WHITE, 2));
		scrollPane.setBounds(0, 0, 312, 88);
		panelCompanyInfo.add(scrollPane);
		
		tfCompanyInfo = new JTextArea(boss.getMyAccount().getMyCompany().getInfo());
		tfCompanyInfo.setBorder(new LineBorder(Color.WHITE, 2));
		tfCompanyInfo.setBackground(new Color(255, 153, 102));
		tfCompanyInfo.setForeground(new Color(255, 255, 255));
		tfCompanyInfo.setLineWrap(true);
		scrollPane.setViewportView(tfCompanyInfo);
		 
		tfCompanyInfo.setColumns(10);
		
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
		btnSaveAll.setBorder(new LineBorder(Color.WHITE, 3));
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
		btnSaveAll.setBounds(216, 503, 116, 25);
		frame.getContentPane().add(btnSaveAll);
		
		btnViewChanges = new JButton("View Changes");
		btnViewChanges.setBorder(new LineBorder(Color.WHITE, 3));
		btnViewChanges.setBackground(new Color(255, 153, 102));
		btnViewChanges.setForeground(new Color(255, 255, 255));
		btnViewChanges.setContentAreaFilled(false); 
		btnViewChanges.setFocusPainted(false); 
		btnViewChanges.setOpaque(false);
		btnViewChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnViewChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CompanyProfileGUI(boss,boss.getMyAccount().getMyCompany());
				backEndBoss.dispose();
			    frame.dispose();
				
			}
		});
		btnViewChanges.setBounds(393, 503, 124, 25);
		frame.getContentPane().add(btnViewChanges);
		
		JSeparator separatorCompanyName = new JSeparator();
		separatorCompanyName.setForeground(Color.WHITE);
		separatorCompanyName.setBackground(Color.WHITE);
		separatorCompanyName.setBounds(190, 257, 166, 2);
		frame.getContentPane().add(separatorCompanyName);
		
		JSeparator separatorCompanyTelephone = new JSeparator();
		separatorCompanyTelephone.setForeground(Color.WHITE);
		separatorCompanyTelephone.setBounds(190, 294, 166, 16);
		frame.getContentPane().add(separatorCompanyTelephone);
		
		JSeparator separatorCompanyAddress = new JSeparator();
		separatorCompanyAddress.setForeground(Color.WHITE);
		separatorCompanyAddress.setBounds(190, 329, 166, 2);
		frame.getContentPane().add(separatorCompanyAddress);
		
		JSeparator separatorCompanyEmail = new JSeparator();
		separatorCompanyEmail.setForeground(Color.WHITE);
		separatorCompanyEmail.setBounds(190, 361, 166, 2);
		frame.getContentPane().add(separatorCompanyEmail);
		
		JSeparator separatorChangesButton = new JSeparator();
		separatorChangesButton.setForeground(Color.WHITE);
		separatorChangesButton.setBounds(0, 488, 776, 17);
		frame.getContentPane().add(separatorChangesButton);
		
		JPanel panelCompanyPhoto = new JPanel();
		panelCompanyPhoto.setBounds(31, 11, 610, 211);
		frame.getContentPane().add(panelCompanyPhoto);
		panelCompanyPhoto.setLayout(null);
		
		JLabel lblPhotoCompany = new JLabel();
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(theBoss.getMyAccount().getMyCompany().getImage()));
			ImageIcon imageBackground = new ImageIcon(imageicon);
			Image imagerisize = imageBackground.getImage().getScaledInstance(610, 211, 140) ;
			lblPhotoCompany.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lblPhotoCompany.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblPhotoCompany.setBounds(0, 0, 610, 211);
		panelCompanyPhoto.add(lblPhotoCompany);
	}
}
