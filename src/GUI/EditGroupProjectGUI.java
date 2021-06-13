package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import entities.Employee;
import entities.GeneralNotification;
import entities.Group;
import entities.Project;
import entities.User;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EditGroupProjectGUI {

	private JFrame frame;
	private JTextField tfProjectName;
	private JTextArea tfChangeProjectDescription;
	private JTextField tfChangeGroupName;
	private static Group myGroup;
	private ArrayList<Employee> selectedMembers = new ArrayList<Employee>(); //The group Members
	private ArrayList<Employee> selectedMembersRemove = new ArrayList<Employee>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditGroupProjectGUI window = new EditGroupProjectGUI(myGroup);
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
	public EditGroupProjectGUI(Group aGroup) {
		myGroup=aGroup;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setBounds(100, 100, 653, 678);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(720, 300);
		
		tfProjectName= new JTextField(myGroup.getMyProject().getName());
		tfProjectName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfProjectName.setBackground(new Color(255, 153, 102));
		tfProjectName.setForeground(new Color(255, 255, 255));
		tfProjectName.setBorder(null);
		tfProjectName.setBounds(194, 29, 116, 22);
		frame.getContentPane().add(tfProjectName);
		tfProjectName.setColumns(10);
		
		tfChangeGroupName = new JTextField(myGroup.getName());
		tfChangeGroupName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfChangeGroupName.setBackground(new Color(255, 153, 102));
		tfChangeGroupName.setForeground(new Color(255, 255, 255));
		tfChangeGroupName.setBorder(null);
		tfChangeGroupName.setBounds(183, 167, 116, 22);
		frame.getContentPane().add(tfChangeGroupName);
		tfChangeGroupName.setColumns(10);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(183, 64, 308, 90);
		frame.getContentPane().add(scrollPane_2);
		
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollPane_2.setRowHeaderView(scrollBar_2);
		
		tfChangeProjectDescription= new JTextArea(myGroup.getMyProject().getDescription());
		tfChangeProjectDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfChangeProjectDescription.setBackground(new Color(255, 153, 102));
		tfChangeProjectDescription.setForeground(new Color(255, 255, 255));
		tfChangeProjectDescription.setLineWrap(true);
		tfChangeProjectDescription.setWrapStyleWord(true);
		tfChangeProjectDescription.setBorder(null);
		scrollPane_2.setViewportView(tfChangeProjectDescription);
		tfChangeProjectDescription.setColumns(10);
		
		JRadioButton rdbtnOnGoing = new JRadioButton("Ongoing");
		rdbtnOnGoing.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnOnGoing.setForeground(new Color(255, 255, 255));
		rdbtnOnGoing.setBorder(null);
		rdbtnOnGoing.setBackground(new Color(255, 153, 102));
		rdbtnOnGoing.setActionCommand("Ongoing");
		rdbtnOnGoing.setBounds(183, 208, 127, 25);
		frame.getContentPane().add(rdbtnOnGoing);
		
		JRadioButton rdbtnDone = new JRadioButton("Done");
		rdbtnDone.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnDone.setForeground(new Color(255, 255, 255));
		rdbtnDone.setBorder(null);
		rdbtnDone.setBackground(new Color(255, 153, 102));
		rdbtnDone.setActionCommand("Done");
		rdbtnDone.setBounds(316, 208, 127, 25);
		frame.getContentPane().add(rdbtnDone);
		
		// create button group for the radio button to know which one was selected
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnOnGoing);
	    radioGroup.add(rdbtnDone);
		
		JLabel lblChangeProjecctName = new JLabel("Change project name:");
		lblChangeProjecctName.setForeground(new Color(255, 255, 255));
		lblChangeProjecctName.setBounds(44, 32, 146, 16);
		frame.getContentPane().add(lblChangeProjecctName);
		
		JLabel lblChangeProjectDescription = new JLabel("Change project description:");
		lblChangeProjectDescription.setForeground(new Color(255, 255, 255));
		lblChangeProjectDescription.setBounds(12, 67, 159, 16);
		frame.getContentPane().add(lblChangeProjectDescription);
		
		JLabel lblChangeGroupName = new JLabel("Change group name:");
		lblChangeGroupName.setForeground(new Color(255, 255, 255));
		lblChangeGroupName.setBounds(44, 170, 127, 16);
		frame.getContentPane().add(lblChangeGroupName);
		
		JLabel lblCurrentsituation = new JLabel("Current situation:");
		lblCurrentsituation.setForeground(new Color(255, 255, 255));
		lblCurrentsituation.setBounds(70, 211, 101, 16);
		frame.getContentPane().add(lblCurrentsituation);
		JList<String> listaddUserGroup = new JList<String>();
		listaddUserGroup.setBounds(89, 300, 101, 144);
		listaddUserGroup.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(listaddUserGroup);
		DefaultListModel<String> addUserGroupmodel = new DefaultListModel<String>();
		for (Employee employee: myGroup.getSupervisor().getMyAccount().getMyCompany().returnEmployees()) {
			if (employee.getGroups().size()<=2 && !myGroup.isMember(employee)) {
				addUserGroupmodel.addElement(employee.getFirstName()+" "+employee.getLastName()+" | "+employee.getMyAccount().getUsername());
			}
		}
		listaddUserGroup.setModel(addUserGroupmodel);
		frame.getContentPane().add(listaddUserGroup);
		
		
		JList<String> listremoveUserGroup = new JList<String>();
		listremoveUserGroup.setBounds(440, 300, 91, 144);
		listremoveUserGroup.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DefaultListModel<String> removeUserGroupmodel = new DefaultListModel<String>();
		for (Employee employee: myGroup.getGroupMembers()) {
			
			removeUserGroupmodel.addElement(employee.getFirstName()+" "+employee.getLastName()+" | "+employee.getMyAccount().getUsername());
			selectedMembers.add(employee);
		}
	   listremoveUserGroup.setModel(removeUserGroupmodel);
		frame.getContentPane().add(listremoveUserGroup);
		
		JLabel lblNewLabel_4 = new JLabel("Add more users");
		lblNewLabel_4.setBounds(89, 264, 101, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Users in the group");
		lblNewLabel_5.setBounds(429, 264, 127, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnaddGroup = new JButton("Add to group");
		btnaddGroup.setContentAreaFilled(false); 
		btnaddGroup.setFocusPainted(false); 
		btnaddGroup.setOpaque(false);
		btnaddGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnaddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedEmployeeString = listaddUserGroup.getSelectedValue();
				int index = listaddUserGroup.getSelectedIndex();

				Employee selectedEmployee = null;
				
				for(Employee theEmp: myGroup.getSupervisor().getMyAccount().getMyCompany().returnEmployees()) {
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
		btnaddGroup.setBounds(70, 484, 141, 25);
		frame.getContentPane().add(btnaddGroup);
		
		JButton btnremoveUser = new JButton("Remove");
		btnremoveUser.setContentAreaFilled(false); 
		btnremoveUser.setFocusPainted(false); 
		btnremoveUser.setOpaque(false);
		btnremoveUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnremoveUser.setBounds(414, 484, 142, 25);
		btnremoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String selectedEmployeeString = listremoveUserGroup.getSelectedValue();
				Employee selectedEmployeeToRemove = null;
				int index = listremoveUserGroup.getSelectedIndex();
				
				for (Employee theEmployee: selectedMembers ) {
					String fullName = theEmployee.getFirstName()+" "+theEmployee.getLastName()+" | "+theEmployee.getMyAccount().getUsername();
					if (fullName.equalsIgnoreCase(selectedEmployeeString)) {
						selectedEmployeeToRemove = theEmployee;
						break;
					}
				}
				if (selectedEmployeeToRemove!=null) {
					selectedMembers.remove(selectedEmployeeToRemove);
					selectedMembersRemove.add(selectedEmployeeToRemove);
					myGroup.getSupervisor().getMyAccount().getMyCompany().returnEmployees().add(selectedEmployeeToRemove);
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
		frame.getContentPane().add(btnremoveUser);
		
		JButton btnSaveAll = new JButton("Save all");
		btnSaveAll.setContentAreaFilled(false); 
		btnSaveAll.setFocusPainted(false); 
		btnSaveAll.setOpaque(false);
		btnSaveAll.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		btnSaveAll.setBounds(355, 541, 116, 25);
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(!tfProjectName.getText().equals("")  )
				{
				   myGroup.getMyProject().setName(tfProjectName.getText());
				}
				if(!tfChangeProjectDescription.getText().equals(""))
				{
					myGroup.getMyProject().setDescription(tfChangeProjectDescription.getText());
				}
				if(!tfChangeGroupName.getText().equals(""))
				{
					myGroup.setName(tfChangeGroupName.getText());
				}
				
				for (Employee theEmp: selectedMembers) {
						theEmp.addGroupToEmployeesList(myGroup);
						myGroup.addMember(theEmp);
				}
				for (Employee theEmp: selectedMembersRemove) {
					theEmp.RemoveGroupFromUsersList(myGroup);
					myGroup.removeUserFromGroup(theEmp);;
			}	
				
				if(rdbtnDone.isSelected())
				{
					myGroup.getMyProject().setStatus("Done");
					//Creating notification for boss to rate group
					GeneralNotification genNot = new GeneralNotification(myGroup.getMyProject().getName()+" is done,Please rate!",myGroup,"projectDone");
					myGroup.getSupervisor().getMyAccount().getMyCompany().getBoss().getListOfNotifications().add(genNot);
					
				}
				else if(rdbtnOnGoing.isSelected())
				{
					myGroup.getMyProject().setStatus("Ongoing");
				}
						
				
				
				
			}
		});
		frame.getContentPane().add(btnSaveAll);
		
		JButton btnViwChanges = new JButton("View changes");
		btnViwChanges.setContentAreaFilled(false); 
		btnViwChanges.setFocusPainted(false); 
		btnViwChanges.setOpaque(false);
		btnViwChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnViwChanges.setBounds(494, 541, 116, 25);
		btnViwChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new GroupProfileGUI(myGroup.getSupervisor(), myGroup);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			});
		frame.getContentPane().add(btnViwChanges);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(192, 51, 107, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(183, 191, 116, 2);
		frame.getContentPane().add(separator_1);
	
		
		
		frame.setTitle("Edit " + myGroup.getName());
		
		JScrollBar scrollBar_1 = new JScrollBar();
	}
}

