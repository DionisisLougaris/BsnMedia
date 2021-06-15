package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.*;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


public class CreateProjectGUI {

	private JFrame frame;
	private JTextField textProjectName;
	private JTextField textGroupName;
	private JTextField textDeadline;  
	private static Chief pchief;
	private ArrayList<Employee> selectedMembers = new ArrayList<Employee>(); //The group Members
	private ArrayList<Employee> feasibleForSelection; //all propably members

	public CreateProjectGUI(Chief chief) {
		initialize(chief);
	}

	private void initialize(Chief chief) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setBounds(100, 100, 535, 704);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(885, 200);
		textProjectName = new JTextField();
		textProjectName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textProjectName.setBackground(new Color(255, 153, 102));
		textProjectName.setForeground(new Color(255, 255, 255));
		textProjectName.setBorder(null);
		textProjectName.setBounds(155, 83, 236, 16);
		frame.getContentPane().add(textProjectName);
		textProjectName.setColumns(10);
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		pchief = chief;
		
		JLabel lblProjectName = new JLabel("Project name :");
		lblProjectName.setForeground(new Color(255, 255, 255));
		lblProjectName.setBounds(48, 86, 103, 16);
		frame.getContentPane().add(lblProjectName);
		
		JLabel lblProjectDescription= new JLabel("Project description :");
		lblProjectDescription.setForeground(new Color(255, 255, 255));
		lblProjectDescription.setBounds(48, 124, 108, 16);
		frame.getContentPane().add(lblProjectDescription);
		
		JTextArea textProjectDescription = new JTextArea();
		textProjectDescription.setBounds(155, 125, 284, 68);
		textProjectDescription.setLineWrap(true);
		textProjectDescription.setWrapStyleWord(true);
		frame.getContentPane().add(textProjectDescription);
		
		JLabel lblDeadline = new JLabel("Deadline:");
		lblDeadline.setForeground(new Color(255, 255, 255));
		lblDeadline.setBounds(48, 208, 56, 16);
		frame.getContentPane().add(lblDeadline);
		
		textDeadline = new JTextField();
		textDeadline.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDeadline.setBorder(null);
		textDeadline.setBackground(new Color(255, 153, 102));
		textDeadline.setForeground(new Color(255, 255, 255));
		textDeadline.setBounds(155, 205, 236, 16);
		frame.getContentPane().add(textDeadline);
		textDeadline.setColumns(10);
		
		textGroupName = new JTextField();
		textGroupName.setForeground(new Color(255, 255, 255));
		textGroupName.setBackground(new Color(255, 153, 102));
		textGroupName.setBorder(null);
		textGroupName.setBounds(155, 284, 236, 16);
		frame.getContentPane().add(textGroupName);
		textGroupName.setColumns(10);
		
		JLabel lblGroupName = new JLabel("Group name :");
		lblGroupName.setForeground(new Color(255, 255, 255));
		lblGroupName.setBounds(48, 287, 91, 16);
		frame.getContentPane().add(lblGroupName);
		
		feasibleForSelection = pchief.getMyAccount().getMyCompany().returnEmployees(); //All Employees
		JList<String> addUsersGroupList = new JList<String>();
		addUsersGroupList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addUsersGroupList.setBounds(48, 399, 174, 157);
		DefaultListModel<String> addUserGroupmodel = new DefaultListModel<String>();
		for (Employee employee: feasibleForSelection) {
			if (employee.getGroups().size()<=2) {
				addUserGroupmodel.addElement(employee.getFirstName()+" "+employee.getLastName()+" | "+employee.getMyAccount().getUsername());
			}
		}
		addUsersGroupList.setModel(addUserGroupmodel);
		frame.getContentPane().add(addUsersGroupList);
		JScrollPane scrollPaneaddUser = new JScrollPane(addUsersGroupList);
		scrollPaneaddUser.setBounds(48, 403, 174, 153);
		scrollPaneaddUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPaneaddUser);
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Select employees:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(71, 370, 136, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JList<String> selectedEmployeesList = new JList<String>();
		DefaultListModel<String> removeUserGroupmodel = new DefaultListModel<String>();
		selectedEmployeesList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		selectedEmployeesList.setBounds(298, 399, 174, 157);
		selectedEmployeesList.setModel(removeUserGroupmodel);
		frame.getContentPane().add(selectedEmployeesList);
		JScrollPane scrollPaneremoveUser = new JScrollPane(selectedEmployeesList);
		scrollPaneremoveUser.setBounds(298, 403, 174, 153);
		scrollPaneremoveUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPaneremoveUser);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Members of Group :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(327, 370, 126, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnaddUserGroup = new JButton("Add to Group");
		btnaddUserGroup.setBackground(new Color(255, 255, 255));
		btnaddUserGroup.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		btnaddUserGroup.setContentAreaFilled(false); 
		btnaddUserGroup.setFocusPainted(false); 
		btnaddUserGroup.setOpaque(false);
		btnaddUserGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnaddUserGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedEmployeeString = addUsersGroupList.getSelectedValue();
				int index = addUsersGroupList.getSelectedIndex();

				Employee selectedEmployee = null;
				
				for(Employee theEmp: chief.getMyAccount().getMyCompany().returnEmployees()) {
					String fullName = theEmp.getFirstName()+" "+theEmp.getLastName()+" | "+theEmp.getMyAccount().getUsername();
					if (fullName.equalsIgnoreCase(selectedEmployeeString)) {
						selectedEmployee = theEmp;
						break;
					}
				}
				if (selectedEmployee != null) {
					selectedMembers.add(selectedEmployee);
					removeUserGroupmodel.addElement(selectedEmployee.getFirstName()+" "+selectedEmployee.getLastName()+" | "+selectedEmployee.getMyAccount().getUsername());
				    if (index != -1) {
				    	addUserGroupmodel.remove(index);
				    }
				}else {
					String message = "You have not selected any users";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnaddUserGroup.setBounds(71, 571, 126, 25);
		frame.getContentPane().add(btnaddUserGroup);
		
		JButton btnremoveUserGroup = new JButton("Remove");
		btnremoveUserGroup.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		btnremoveUserGroup.setContentAreaFilled(false); 
		btnremoveUserGroup.setFocusPainted(false); 
		btnremoveUserGroup.setOpaque(false);
		btnremoveUserGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnremoveUserGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedEmployeeString = selectedEmployeesList.getSelectedValue();
				Employee selectedEmployeeToRemove = null;
				int index = selectedEmployeesList.getSelectedIndex();
				
				for (Employee theEmployee: selectedMembers ) {
					String fullName = theEmployee.getFirstName()+" "+theEmployee.getLastName()+" | "+theEmployee.getMyAccount().getUsername();
					if (fullName.equalsIgnoreCase(selectedEmployeeString)) {
						selectedEmployeeToRemove = theEmployee;
						break;
					}
				}
				if (selectedEmployeeToRemove!=null) {
					selectedMembers.remove(selectedEmployeeToRemove);
					feasibleForSelection.add(selectedEmployeeToRemove);
					addUserGroupmodel.addElement(selectedEmployeeToRemove.getFirstName()+" "+selectedEmployeeToRemove.getLastName()+" | "+selectedEmployeeToRemove.getMyAccount().getUsername());
				    if (index != -1) {
				    	removeUserGroupmodel.remove(index);
				    }
				}else {
					String message = "You have not selected any users";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnremoveUserGroup.setBounds(327, 571, 126, 25);
		frame.getContentPane().add(btnremoveUserGroup);
		
		JButton btnCreateProject = new JButton("Create");
		btnCreateProject.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		btnCreateProject.setForeground(new Color(255, 255, 255));
		btnCreateProject.setContentAreaFilled(false); 
		btnCreateProject.setFocusPainted(false); 
		btnCreateProject.setOpaque(false);
		btnCreateProject.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCreateProject.setBounds(222, 632, 77, 22);
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(!textProjectName.getText().equals("") && !textProjectDescription.getText().equals("") && !textDeadline.getText().equals("") && !textGroupName.getText().equals("")
						&& selectedMembers.size()>=1) {
				   
					if (pchief.getMyAccount().getMyCompany().groupNameAvailability(textGroupName.getText())) {
						
						Project createdProject = new Project(textProjectName.getText(), textProjectDescription.getText(), textDeadline.getText());
						Group createdGroup = new Group(textGroupName.getText(), createdProject, pchief);
						pchief.addGroupToSupervise(createdGroup);
						groupConversation conversation = new groupConversation(createdGroup);
						createdGroup.setMyConversation(conversation);
						
						for (Employee theEmp: selectedMembers) {
							theEmp.addGroupToEmployeesList(createdGroup);
						}
						
						pchief.getMyAccount().getMyCompany().addCompanyGroups(createdGroup);
						
						String message = "The group was created successfully!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
					}else {
						String message = "The Group name selected is not available";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.ERROR_MESSAGE);
					}
				}else {
					String message = "All fields must be completed!\nThere are fields that have not been filled in or you have not selected members!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnCreateProject);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(0, 246, 519, 16);
		frame.getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 519, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		BufferedImage imagebackground;
		try {
			imagebackground = ImageIO.read(new File("label_backgrounds/teamwork_50px.png"));
			ImageIcon imageb = new ImageIcon(imagebackground);
			Image imagerisizeb = imageb.getImage().getScaledInstance(50, 40, 140) ;
			lblNewLabel.setIcon(new ImageIcon(imagerisizeb));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(10, 11, 60, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create a Group");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(115, 11, 255, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("for better organization!");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(115, 29, 255, 22);
		panel.add(lblNewLabel_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(155, 222, 236, 13);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(155, 100, 236, 13);
		frame.getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(Color.WHITE);
		separator_1_2.setBounds(155, 300, 236, 13);
		frame.getContentPane().add(separator_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBounds(0, 614, 519, 13);
		frame.getContentPane().add(separator_2);
		
		

		
		frame.setTitle("Create project");
	}
}
