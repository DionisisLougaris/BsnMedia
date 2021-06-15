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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class EditGroupProjectGUI {

	private JFrame frame;
	private JTextField tfProjectName;
	private JTextArea tfChangeProjectDescription;
	private JTextField tfChangeGroupName;
	private static Group myGroup;
	private ArrayList<Employee> newMembers = new ArrayList<>();
	private ArrayList<Employee> membersToRemove = new ArrayList<>();
	
	public EditGroupProjectGUI(Group aGroup, JFrame chiefBackEnd) {
		initialize(aGroup, chiefBackEnd);
	}

	private void initialize(Group aGroup, JFrame chiefBackEnd) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setBounds(100, 100, 653, 678);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocation(720, 300);
		frame.setResizable(false);
		frame.setTitle("Edit Group and Project");
		
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		
		myGroup = aGroup;
		
		tfProjectName= new JTextField(myGroup.getMyProject().getName());
		tfProjectName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfProjectName.setBackground(new Color(255, 153, 102));
		tfProjectName.setForeground(new Color(255, 255, 255));
		tfProjectName.setBorder(null);
		tfProjectName.setBounds(183, 29, 174, 22);
		frame.getContentPane().add(tfProjectName);
		tfProjectName.setColumns(10);
		
		tfChangeGroupName = new JTextField(myGroup.getName());
		tfChangeGroupName.setEditable(false);
		tfChangeGroupName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfChangeGroupName.setBackground(new Color(255, 153, 102));
		tfChangeGroupName.setForeground(new Color(255, 255, 255));
		tfChangeGroupName.setBorder(null);
		tfChangeGroupName.setBounds(183, 167, 174, 22);
		frame.getContentPane().add(tfChangeGroupName);
		tfChangeGroupName.setColumns(10);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new LineBorder(Color.WHITE, 2));
		scrollPane_2.setBounds(183, 64, 308, 90);
		frame.getContentPane().add(scrollPane_2);
		
		tfChangeProjectDescription= new JTextArea(myGroup.getMyProject().getDescription());
		tfChangeProjectDescription.setEditable(false);
		tfChangeProjectDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfChangeProjectDescription.setBackground(new Color(255, 153, 102));
		tfChangeProjectDescription.setForeground(new Color(255, 255, 255));
		tfChangeProjectDescription.setLineWrap(true);
		tfChangeProjectDescription.setWrapStyleWord(true);
		tfChangeProjectDescription.setBorder(new LineBorder(Color.WHITE, 2));
		scrollPane_2.setViewportView(tfChangeProjectDescription);
		tfChangeProjectDescription.setColumns(10);
		
		JRadioButton rdbtnOnGoing = new JRadioButton("Ongoing");
		rdbtnOnGoing.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnOnGoing.setForeground(new Color(255, 255, 255));
		rdbtnOnGoing.setBorder(null);
		rdbtnOnGoing.setBackground(new Color(255, 153, 102));
		rdbtnOnGoing.setActionCommand("Ongoing");
		rdbtnOnGoing.setBounds(183, 208, 80, 25);
		frame.getContentPane().add(rdbtnOnGoing);
		
		JRadioButton rdbtnDone = new JRadioButton("Done");
		rdbtnDone.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnDone.setForeground(Color.WHITE);
		rdbtnDone.setBorder(null);
		rdbtnDone.setBackground(new Color(255, 153, 102));
		rdbtnDone.setActionCommand("Done");
		rdbtnDone.setBounds(273, 208, 61, 25);
		frame.getContentPane().add(rdbtnDone);
		
		// create button group for the radio button to know which one was selected
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnOnGoing);
	    radioGroup.add(rdbtnDone);
		
		JLabel lblChangeProjecctName = new JLabel("Change project name:");
		lblChangeProjecctName.setForeground(new Color(255, 255, 255));
		lblChangeProjecctName.setBounds(38, 33, 127, 16);
		frame.getContentPane().add(lblChangeProjecctName);
		
		JLabel lblChangeProjectDescription = new JLabel("Change project description:");
		lblChangeProjectDescription.setForeground(new Color(255, 255, 255));
		lblChangeProjectDescription.setBounds(12, 67, 159, 16);
		frame.getContentPane().add(lblChangeProjectDescription);
		
		JLabel lblChangeGroupName = new JLabel("Group name:");
		lblChangeGroupName.setForeground(new Color(255, 255, 255));
		lblChangeGroupName.setBounds(80, 171, 86, 16);
		frame.getContentPane().add(lblChangeGroupName);
		
		JLabel lblCurrentsituation = new JLabel("Change Current situation:");
		lblCurrentsituation.setForeground(new Color(255, 255, 255));
		lblCurrentsituation.setBounds(18, 212, 147, 16);
		frame.getContentPane().add(lblCurrentsituation);
		
		
		JList<String> EmployeesToAdd = new JList<String>();
		EmployeesToAdd.setBounds(58, 280, 153, 164);
		EmployeesToAdd.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DefaultListModel<String> addUserGroupmodel = new DefaultListModel<String>();
		for (Employee employee: myGroup.getSupervisor().getMyAccount().getMyCompany().returnEmployees()) {
			if (employee.getGroups().size()<=2 && !myGroup.isMember(employee)) {
				addUserGroupmodel.addElement(employee.getFirstName()+" "+employee.getLastName()+" | "+employee.getMyAccount().getUsername());
			}
		}
		EmployeesToAdd.setModel(addUserGroupmodel);
		frame.getContentPane().add(EmployeesToAdd);
		
		
		JList<String> groupMembersList = new JList<String>();
		groupMembersList.setBounds(390, 280, 153, 164);
		groupMembersList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DefaultListModel<String> removeUserGroupmodel = new DefaultListModel<String>();
		for (Employee employee: myGroup.getGroupMembers()) 
			removeUserGroupmodel.addElement(employee.getFirstName()+" "+employee.getLastName()+" | "+employee.getMyAccount().getUsername());
		groupMembersList.setModel(removeUserGroupmodel);
		frame.getContentPane().add(groupMembersList);
		
		JLabel lblNewLabel_4 = new JLabel("Add more users:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(58, 264, 153, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Users in the group:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(390, 264, 153, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnaddGroup = new JButton("Add to group");
		btnaddGroup.setForeground(Color.WHITE);
		btnaddGroup.setBorder(new LineBorder(Color.WHITE, 3));
		btnaddGroup.setContentAreaFilled(false); 
		btnaddGroup.setFocusPainted(false); 
		btnaddGroup.setOpaque(false);
		btnaddGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnaddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedEmployeeString = EmployeesToAdd.getSelectedValue();
				int index = EmployeesToAdd.getSelectedIndex();

				Employee selectedEmployee = null;
				
				for(Employee theEmp: myGroup.getSupervisor().getMyAccount().getMyCompany().returnEmployees()) {
					String fullName = theEmp.getFirstName()+" "+theEmp.getLastName()+" | "+theEmp.getMyAccount().getUsername();
					if (fullName.equalsIgnoreCase(selectedEmployeeString)) {
						selectedEmployee = theEmp;
						break;
					}
				}
				if (selectedEmployee != null) {
					newMembers.add(selectedEmployee);
					if (membersToRemove.contains(selectedEmployee)) {
						membersToRemove.remove(selectedEmployee);
					}
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
		btnaddGroup.setBounds(86, 450, 95, 25);
		frame.getContentPane().add(btnaddGroup);
		
		JButton btnremoveUser = new JButton("Remove");
		btnremoveUser.setForeground(Color.WHITE);
		btnremoveUser.setBorder(new LineBorder(Color.WHITE, 3));
		btnremoveUser.setContentAreaFilled(false); 
		btnremoveUser.setFocusPainted(false); 
		btnremoveUser.setOpaque(false);
		btnremoveUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnremoveUser.setBounds(422, 450, 95, 25);
		btnremoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedEmployeeString = groupMembersList.getSelectedValue();
				Employee selectedEmployeeToRemove = null;
				int index = groupMembersList.getSelectedIndex();
				
				for (User theEmployee: myGroup.getSupervisor().getMyAccount().getMyCompany().getCompanyMembers()) {
					String fullName = theEmployee.getFirstName()+" "+theEmployee.getLastName()+" | "+theEmployee.getMyAccount().getUsername();
					if (fullName.equalsIgnoreCase(selectedEmployeeString)) {
						selectedEmployeeToRemove = (Employee)theEmployee;
						break;
					}
				}
				if (selectedEmployeeToRemove!=null) {
					membersToRemove.add(selectedEmployeeToRemove);
					if (newMembers.contains(selectedEmployeeToRemove)) {
						newMembers.remove(selectedEmployeeToRemove);
					}
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
		btnSaveAll.setBorder(new LineBorder(Color.WHITE, 3));
		btnSaveAll.setForeground(Color.WHITE);
		btnSaveAll.setContentAreaFilled(false); 
		btnSaveAll.setFocusPainted(false); 
		btnSaveAll.setOpaque(false);
		btnSaveAll.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		btnSaveAll.setBounds(251, 513, 116, 25);
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
				
				for (Employee addedEmployee: newMembers) {
					if (!myGroup.isMember(addedEmployee)) {
						addedEmployee.addGroupToEmployeesList(myGroup);
					}
				}
				
				for (Employee employeeForRemove: membersToRemove) {
					if (myGroup.isMember(employeeForRemove)) {
						employeeForRemove.RemoveGroupFromUsersList(myGroup);
					}
				}
				
				String message = "Your changes were successful!\n If there are empty fields, then the previous ones will not be modified!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnSaveAll);
		
		JButton btnViwChanges = new JButton("View changes");
		btnViwChanges.setBorder(new LineBorder(Color.WHITE, 3));
		btnViwChanges.setForeground(Color.WHITE);
		btnViwChanges.setContentAreaFilled(false); 
		btnViwChanges.setFocusPainted(false); 
		btnViwChanges.setOpaque(false);
		btnViwChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnViwChanges.setBounds(251, 549, 116, 25);
		btnViwChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new GroupProfileGUI(myGroup.getSupervisor(), myGroup);
					frame.dispose();
					chiefBackEnd.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		frame.getContentPane().add(btnViwChanges);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(183, 51, 174, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(183, 191, 174, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(0, 503, 647, 16);
		frame.getContentPane().add(separator_2);
	}
}

