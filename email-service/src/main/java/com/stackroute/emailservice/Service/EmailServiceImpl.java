package com.stackroute.emailservice.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.stackroute.emailservice.model.Emaildto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.stackroute.emailservice.model.EmailDetails;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {
		@Autowired
	 	private JavaMailSender mailSender;
	 
	    // To send a simple email

	@RabbitListener(queues = "mail")
	public void getEmailDetail(Emaildto dto){
		System.out.println(dto);
		EmailDetails user= new EmailDetails();
		user.setRecipient(dto.getUserName());
		user.setFirstname(dto.getUserFirstName());
		user.setLastname(dto.getUserLastName());
		//Repository.save(user);

		System.out.println(user);



	}
	    public String sendSimpleMail(EmailDetails details)
	    {
	 
	        // Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message object
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom("noreply.housingdesire@gmail.com");
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText("Dear " + details.getFirstname() +" " + details.getLastname()+" ,"+"\n Thank you for Shopping with us..."+"\n\nRegards,"+"\nHousingDesires team.");
	            mailMessage.setSubject("Your Order is confirmed !!!");
	 
	            // Sending the mail
	            this.mailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }
	    
	    
	    // To send an Welcome email with attachment
	    @Value("${spring.mail.username}") private String sender;
	    
	    public String
	    sendMailWithAttachment(EmailDetails details)
	    {
	        // Creating a mime message
	        MimeMessage mimeMessage
	            = mailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	 
	        try {
	 
	            // Setting multipart as true for attachments to
	            // be send
	            mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(sender);
	            mimeMessageHelper.setTo(details.getRecipient());
	            mimeMessageHelper.setText("Dear "+ details.getFirstname()+" "+ details.getLastname() +","+"\nWelcome to HousingDesires community! We started this website for people who love to shop the furniture. We would love to hear back from you."
						+"\n\nRegards,"+"\nHousingDesires team.");
	            mimeMessageHelper.setSubject("Welcome Mail !!!");

	 
	            // Adding the attachment
	            FileSystemResource file
	                = new FileSystemResource(
	                    new File(details.getAttachment()));
	 
	            mimeMessageHelper.addAttachment(
	                file.getFilename(), file);
	 
	            // Sending the mail
	            mailSender.send(mimeMessage);
	            return "Mail sent Successfully";
	        }
	 
	        // Catch block to handle MessagingException
	        catch (MessagingException e) {
	 
	            // Display message when exception occurred
	            return "Error while sending mail!!!";
	        }
	    }

}
