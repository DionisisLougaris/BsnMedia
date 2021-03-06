package entities;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Help implements Serializable{
	
	private String authorName;
	private String authorEmail;
	private String question;
	private String supportEmail;
	private String supportEmailPassword;
	
	
	//Constructor for Help class;
	public Help(String authorName, String authorEmail, String question) {
		super();
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.question = question;
		this.supportEmail = "itintelligenceuom@gmail.com";
		this.supportEmailPassword = "ITintelligence2001";
	}
	
	
	//A method that allows users to contact the Bsn Media technical support team.
	public void sendQuestion() {
		
		boolean sendToUs;
		boolean sendToTheUser;
		
		String [] reciverForConfirmation = new String[1];
		reciverForConfirmation[0] = authorEmail; //The recipient is the email stated by the person who wrote the uphill
		String subject = "Inquiry confirmation!";
		String body = "Thank you very much for your comments "+authorName;
		//An Email is sent to his email that we received his report (True if sent successfully / False if there was an error sending)
		sendToTheUser = Help.sendGMail(supportEmail, supportEmailPassword, reciverForConfirmation, subject, body);
		
		
		String [] usAsRecievers = new String[1];
		usAsRecievers[0] = supportEmail; //Recipients are the Bsn Media team who are informed about the user report
		String subject2 = "Requested by user";
		String body2 = "Question: "+this.question+"\nFrom the User: "+this.authorName+"\nEmail for Contact: "+this.authorEmail;
		//(True if sent successfully / False if there was an error sending)
		sendToUs = Help.sendGMail(supportEmail, supportEmailPassword, usAsRecievers, subject2, body2);
		
		//If both emails were sent successfully, then an appropriate notification is displayed
		if (sendToTheUser && sendToUs) { 
			
			String message = "Successful Submission! Thank you very much for your comments!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}else {
			String message = "There was a problem connecting!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*In order for the email to be sent, the sender's email must be connected to the 
	 * computer browser, otherwise there may be a connection error and sending may not be possible!
	 */
	//A method that sends email to someone
	 public static boolean sendGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            return true; //The mail was sent successfully
	        }
	        catch (AddressException ae) {
	            //ae.printStackTrace();
	            return false; //There was an error
	        }
	        catch (MessagingException me) {
	            //me.printStackTrace();
	            return false; //There was an error
	        }
	    }
	

}
