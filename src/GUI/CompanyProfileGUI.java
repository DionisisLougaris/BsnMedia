package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Boss;
import entities.Chief;
import entities.Company;
import entities.Employee;
import entities.User;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class CompanyProfileGUI {

	private JFrame frame;
	private JTextField searchField;
	private JButton logoButton;
	private static User theLoggedUser;
	private static Company company;

	
	
	public CompanyProfileGUI(User myUser,Company theCompany) {
		
		initialize(myUser, theCompany);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User myUser, Company theCompany) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 893, 1020);
		frame.setLocation(500, 0);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.setTitle("Company");
	    frame.getContentPane().setLayout(null);
	    
	    ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
	    frame.setIconImage(logoimage.getImage());
		
		theLoggedUser = myUser;
		company = theCompany;
	    
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File("label_backgrounds/BSNlogo.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon image = new ImageIcon(buttonIcon);
		Image imagerisizel = image.getImage().getScaledInstance(84, 69, 60) ;
		ImageIcon imagebutton = new ImageIcon(imagerisizel);
		logoButton  = new JButton(imagebutton);
		logoButton.setBorder(null);
		logoButton.setToolTipText("Go back to your Profile");
		logoButton.setContentAreaFilled(false); 
		logoButton.setFocusPainted(false); 
		logoButton.setOpaque(false);
		logoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//Closing previous GUI
				frame.setVisible(false);
				//Returning to the right backend profile
				if(myUser instanceof Chief) {
					try {
						new BackendProfileChiefGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(myUser instanceof Boss) {
					try {
						new BackendProfileBossGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(myUser instanceof Employee) {
					try {
						new BackendProfileEmployeeGUI(myUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	    	}
	    });
		logoButton.setBounds(26, 27, 84, 69);
	    frame.getContentPane().add(logoButton);
	    
	    searchField = new JTextField();
	    searchField.setBackground(new Color(255, 250, 240));
	    searchField.setColumns(10);
	    searchField.setBounds(367, 38, 317, 30);
	    frame.getContentPane().add(searchField);
	    
	    Icon search = new ImageIcon("Buttons_backgrounds/search_30px.png");
	    JButton searchButton = new JButton(search);
	    searchButton.setContentAreaFilled(false); 
	    searchButton.setFocusPainted(false); 
	    searchButton.setOpaque(false);
	    searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    searchButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
				
				String searchedText = searchField.getText();
				if(!searchedText.isEmpty()) {
					boolean result;
					try {
						result = company.searchObject(searchedText, theLoggedUser);

						if (!result) {
							ArrayList<String> suggestedOptions = new ArrayList<String>();
							suggestedOptions = theCompany.suggestedSearchOption(searchedText);
							new SearchSuggestionsGUI(suggestedOptions, theLoggedUser, frame);
						}else {
							frame.setVisible(false);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}else {
					 String message = "Type something in the Search field";
						JOptionPane.showMessageDialog(new JFrame(), message, "Message",
						        JOptionPane.INFORMATION_MESSAGE);
				}
	    	}
	    });
	    searchButton.setBounds(704, 36, 46, 44);
	    frame.getContentPane().add(searchButton);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    panel_1.setBounds(70, 140, 743, 285);
	    frame.getContentPane().add(panel_1);
	    
	    JLabel lblCompanyPhoto = new JLabel();
		BufferedImage imageicon;
		try {
			imageicon = ImageIO.read(new File(company.getImage()));
			ImageIcon imageBackground = new ImageIcon(imageicon);
			Image imagerisize = imageBackground.getImage().getScaledInstance(740, 280, 140) ;
			lblCompanyPhoto.setIcon(new ImageIcon(imagerisize));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    lblCompanyPhoto.setBounds(0, 0, 743, 285);
	    panel_1.add(lblCompanyPhoto);
	    
	    JLabel companyName = new JLabel(company.getName());
	    companyName.setHorizontalAlignment(SwingConstants.CENTER);
	    companyName.setFont(new Font("Tahoma", Font.PLAIN, 24));
	    companyName.setBounds(70, 438, 743, 30);
	    frame.getContentPane().add(companyName);
	    
	    JLabel companyInfoLabel = new JLabel("What we are all about :");
	    companyInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    companyInfoLabel.setBounds(60, 487, 197, 30);
	    frame.getContentPane().add(companyInfoLabel);
	    
	    JLabel companyDetails = new JLabel(company.getInfo());
	    companyDetails.setFont(new Font("Tahoma", Font.ITALIC, 14));
	    companyDetails.setText(theCompany.getInfo());
	    companyDetails.setBounds(60, 517, 332, 38);
	    frame.getContentPane().add(companyDetails);
	    
	    
	    
	    JList<String> allEmployeesLists = new JList<String>();
	    DefaultListModel<String> employeesModel = new DefaultListModel<String>();
	    for(User employee: company.returnEmployees()) {
	    	employeesModel.addElement(employee.getFirstName()+" "+employee.getLastName());
	    }
	    allEmployeesLists.setModel(employeesModel);
	    allEmployeesLists.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    allEmployeesLists.setBackground(new Color(255, 250, 240));
	    allEmployeesLists.setBounds(660, 609, 133, 186);
	    frame.getContentPane().add(allEmployeesLists);
	    
	    JLabel EmployeesLabel = new JLabel("Employees (" + theCompany.returnEmployees().size() + ")");
	    EmployeesLabel.setBounds(660, 580, 91, 16);
	    frame.getContentPane().add(EmployeesLabel);
	    
	    JList<String> allChiefsList = new JList<String>();
	    DefaultListModel<String> chiefsModel = new DefaultListModel<String>();
	    for(User chief: company.returnChiefs()) {
	    	chiefsModel.addElement(chief.getFirstName()+" "+chief.getLastName());
	    }
	    allChiefsList.setModel(chiefsModel);
	    allChiefsList.setBorder(new LineBorder(new Color(0, 0, 0), 5));
	    allChiefsList.setBackground(new Color(255, 250, 240));
	    allChiefsList.setBounds(461, 609, 133, 186);
	    frame.getContentPane().add(allChiefsList);
	    
	    JLabel chiefsLabel = new JLabel("Chiefs (" + theCompany.returnChiefs().size() + ")");
	    chiefsLabel.setBounds(500, 580, 91, 16);
	    frame.getContentPane().add(chiefsLabel);

	    JLabel companyEmailLabel = new JLabel();
	    companyEmailLabel.setForeground(Color.RED);
	    companyEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    companyEmailLabel.setText(theCompany.getEmail());
	    companyEmailLabel.setBounds(112, 704, 337, 25);
	    frame.getContentPane().add(companyEmailLabel);
	    companyEmailLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    companyEmailLabel.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("mailto:"+company.getEmail()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
		});
	    
	    JLabel companyTelLabel = new JLabel();
	    companyTelLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    companyTelLabel.setText(theCompany.getTelephone());
	    companyTelLabel.setBounds(112, 742, 280, 25);
	    frame.getContentPane().add(companyTelLabel);
	    
	    JLabel companyAddressLabel = new JLabel();
	    companyAddressLabel.setForeground(Color.RED);
	    companyAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    companyAddressLabel.setText(theCompany.getAddress());
	    companyAddressLabel.setBounds(112, 780, 280, 25);
	    companyAddressLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    companyAddressLabel.addMouseListener(new MouseAdapter() {
	       	 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/"+company.getAddress()));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	companyAddressLabel.setText("<html><a href=''>" + company.getAddress()+ "</a></html>");
            }
		});
	    frame.getContentPane().add(companyAddressLabel);
	    
	    JLabel headOfCompanyLabel = new JLabel("Head of company :");
	    headOfCompanyLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    headOfCompanyLabel.setBounds(70, 613, 117, 16);
	    frame.getContentPane().add(headOfCompanyLabel);
	    
	    Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton customerSupportButton = new JButton(help);
		customerSupportButton.setContentAreaFilled(false); 
		customerSupportButton.setFocusPainted(false); 
		customerSupportButton.setOpaque(false);
		customerSupportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		customerSupportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.setVisible(false);
					new HelpGUI(theLoggedUser);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    customerSupportButton.setBounds(810, 909, 65, 63);
	    frame.getContentPane().add(customerSupportButton);
	    
	    JLabel lblNewLabel_7 = new JLabel(new ImageIcon("label_backgrounds/email_20px.png"));
	    lblNewLabel_7.setBounds(72, 704, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7);
	    
	    JLabel lblNewLabel_7_1 = new JLabel(new ImageIcon("label_backgrounds/telephone_20px.png"));
	    lblNewLabel_7_1.setBounds(72, 742, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7_1);
	    
	    JLabel lblNewLabel_7_2 = new JLabel(new ImageIcon("label_backgrounds/address_20px.png"));
	    lblNewLabel_7_2.setBounds(70, 780, 28, 25);
	    frame.getContentPane().add(lblNewLabel_7_2);
	    
	    JButton goToBossProfButton = new JButton("Check the Boss");
	    goToBossProfButton.setBackground(new Color(255, 153, 102));
	    goToBossProfButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    goToBossProfButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    goToBossProfButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		//Closing previous GUI
				frame.setVisible(false);
				//Opening Boss' Profile
	    		try {
					new FrontEndProfileGUI(theLoggedUser,theCompany.getBoss());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    });
	    goToBossProfButton.setBounds(187, 611, 117, 22);
	    frame.getContentPane().add(goToBossProfButton);    
	    
	    JLabel lblNewLabel = new JLabel("Contact Us!");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    lblNewLabel.setBounds(70, 668, 187, 25);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBackground(Color.RED);
	    separator.setForeground(Color.RED);
	    separator.setBounds(49, 691, 288, 8);
	    frame.getContentPane().add(separator);
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setForeground(Color.RED);
	    separator_1.setBackground(Color.RED);
	    separator_1.setBounds(49, 588, 288, 8);
	    frame.getContentPane().add(separator_1);
	}
}
