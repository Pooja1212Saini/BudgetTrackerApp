package in.pooja.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendResetEmail(String toEmail, String token) {
		
		String subject = "Reset Your Password - Budget Tracker App";
		String resetLink ="http://localhost:8080/reset-password?token=" + token;
		String body = "Click the link to reset your password:\n" + resetLink;

		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject(subject) ;
		message.setText(body);
		
		mailSender.send(message);
	}
	

}
