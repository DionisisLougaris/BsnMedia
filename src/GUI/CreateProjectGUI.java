package GUI;

import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Chief;
import entities.Group;
import entities.Project;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateProjectGUI {

	private JFrame frame;
	private JTextField textProjectName;
	private JTextField textGroupName;
	private JTextField textProjectDescription;
	private JTextField textDeadline;
	private static Chief pchief;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProjectGUI window = new CreateProjectGUI(pchief);
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
	public CreateProjectGUI(Chief chief ) {
		pchief = chief;
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
		textProjectName = new JTextField();
		textProjectName.setBounds(210, 23, 116, 22);
		frame.getContentPane().add(textProjectName);
		textProjectName.setColumns(10);
		
		JLabel lblProjectName = new JLabel("Project name :");
		lblProjectName.setBounds(82, 26, 103, 16);
		frame.getContentPane().add(lblProjectName);
		
		JLabel lblProjectDescription= new JLabel("Project description :");
		lblProjectDescription.setBounds(59, 90, 126, 16);
		frame.getContentPane().add(lblProjectDescription);
		
		JTextArea textProjectDescription = new JTextArea();
		textProjectDescription.setBounds(210, 90, 116, 68);
		frame.getContentPane().add(textProjectDescription);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(96, 193, 56, 16);
		frame.getContentPane().add(lblDeadline);
		
		textDeadline = new JTextField();
		textDeadline.setBounds(210, 190, 116, 22);
		frame.getContentPane().add(textDeadline);
		textDeadline.setColumns(10);
		
		textGroupName = new JTextField();
		textGroupName.setBounds(210, 284, 116, 22);
		frame.getContentPane().add(textGroupName);
		textGroupName.setColumns(10);
		
		JLabel lblGroupName = new JLabel("Group name :");
		lblGroupName.setBounds(74, 287, 91, 16);
		frame.getContentPane().add(lblGroupName);
		
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
		
		JButton btnCreateProject = new JButton("Create");
		btnCreateProject.setContentAreaFilled(false); 
		btnCreateProject.setFocusPainted(false); 
		btnCreateProject.setOpaque(false);
		btnCreateProject.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCreateProject.setBounds(414, 609, 77, 22);
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean groupfound = false;
				
				if(!textProjectName.getText().equals("")  && !textProjectDescription.getText().equals("")  && !textDeadline.getText().equals("")   && !textGroupName.getText().equals("")  )
				{
					System.out.println("j8soi");
					for(int i=0; i<pchief.getMyAccount().getMyCompany().getCompanyGroups().size(); i++)
					{
						if(pchief.getMyAccount().getMyCompany().getCompanyGroups().get(i).getName().equals(lblGroupName.getText()))
						{
							groupfound = true;
							break;
						}
					}
					if(groupfound)
					{
						String message = "The group already exists. You can create group with the same name";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						Group createdGroup = new Group(textGroupName.getText(), null, pchief);
						Project createdProject = new Project(textProjectName.getText(), textProjectDescription.getText(), textDeadline.getText(), createdGroup);
						createdGroup.setMyProject(createdProject);
					}
				}
				else
				{
					String message = "You can create Project or Group";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",
					        JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnCreateProject);
		
		
		
		
		frame.setTitle("Create project");
		
		
	}
}
