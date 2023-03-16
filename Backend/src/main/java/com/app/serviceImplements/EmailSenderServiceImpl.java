package com.app.serviceImplements;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Customer;
import com.app.pojos.EmailSender;
import com.app.pojos.EnquiryDetails;
import com.app.service.EmailSenderServiceI;
import com.app.service.EnquiryDetailsServiceI;

@Service
public class EmailSenderServiceImpl implements EmailSenderServiceI
{
	@Autowired
	private EnquiryDetailsServiceI eds;
	
	
	@Autowired
	private JavaMailSender jms;
	
	
	@Value("${spring.mail.username}")
	String fromEmailId;
	
	@Override
	public void emailSend(EmailSender e) 
	{
//		take a Class SimpleMailMessage and Create Obj of It
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(fromEmailId);
		
//		message.setTo(e.getToEmailId());
//		For multipal mail send at a Time
		
		
		
		System.out.println(e.getTextBody());

		message.setTo(e.getToEmailId());
		message.setSubject(e.getSubject());
		message.setText(e.getTextBody());
		
		jms.send(message);
		System.out.println("Send Mail");
	}
	
	
	
	
	@Override
	public EnquiryDetails emailSendwithAttachment(EnquiryDetails enquiry)
	{
		
		System.out.println("FROM MAIL "+fromEmailId);
		System.out.println("TO MAIL "+enquiry.getEmail());
	
		String body= "<b>Dear "+enquiry.getFirstName()+" "+enquiry.getLastName()+"</b>,"
				+"<br>Your Loan Enquiry is approved, for further process visit to our office with following Documents : "
				+"<br><br>1. Address Proof"
				+"<br>2. Pancard"
				+"<br>3. Income Tax Return"
				+"<br>4. Aadhar Card"
				+"<br>5. Photo"
				+"<br>6. Bank Cheque"
				+"<br>7. Salary Slips"
				+"<br>8. addressproof"
				+"<br>9. Property Proof"
				+"<br>10. Property Insurance"
				+"<br><br><br><img src='cid:image001'/>"
				+"<br><b>Best Regards,</b>"
		        +"<br>Loan Officer,"
		        +"<br>ETHICAL HOME LOAN,"
		        +"<br>Contact ON "
		        +"<br>Email id : homeloanserviceofficial@gmail.com"
		        +"<br>Pune 411002";	
		
		

		
		String subject="Enquiry Approved For Loan";
		
//		String sendFrom="homeloanserviceofficial@gmail.com";
		
		
		String sendto=enquiry.getEmail();
		//String sendto="pritishthakre02115official@gmail.com";
		
		
	  MimeMessage meMimeMsg = jms.createMimeMessage();	
	 
	  try
	  {
		  MimeMessageHelper helper=new MimeMessageHelper(meMimeMsg, true);
		  helper.setTo(sendto);
		  helper.setFrom(fromEmailId);
		  helper.setSubject(subject);
		  
		  helper.setText(body,true);
		  
		  FileSystemResource resource = new FileSystemResource(new File("D:\\Banking-Loan-service\\Housing-Loan-Service\\Logo\\homeloan.ico"));
		  helper.addInline("image001", resource);
		 
		  
//		  
		  jms.send(meMimeMsg);
		  System.out.println("mail sent");
		 
	  }
	  
	  catch(MessagingException e2)
	  {
		  e2.printStackTrace();
	  }
		
	  	enquiry.setMailSent("SENT");
		 EnquiryDetails enquiryDetails=eds.saveEnquiryDetails(enquiry);
		 return enquiryDetails;
	}
	
	
	
	
	
	@Override
	public void sendSanctionLetter(Customer customer, MultipartFile sanctionLetter)
	{
		
		System.out.println("FROM MAIL"+fromEmailId);
		System.out.println("TO MAIN "+customer.getCustomerEmail());
	
		String body= "<b>Dear "+customer.getCustomerName()+"</b>,"
				+"<br>We thank you for choosing ETHICAL HOME LOAN as your financier for Loan. We are "
				+ "pleased to inform you that with reference to the application, we have in-principle sanctioned you a loan facility, the"
				+ "details of which are mensioned in ataached sanction Letter. "
				
				+"<br><br>If you accept Saction letter then sign the saction letter and submit it to the office"
				
				+"<br><br><br><img src='cid:image001'/>"
				+"<br><b>Best Regards,</b>"
		        +"<br>Loan Officer,"
		        +"<br>ETHICAL HOME LOAN,"
		        +"<br>Email id : loan@gmail.com"
		        +"<br>Pune.";	
		
		String sendto=customer.getCustomerEmail();
//		String sendto="vivek9545902416@gmail.com";
		
		String subject="Sanction Letter";
		
//		String sendFrom="ethicaan@gmail.com";
		
		
	  MimeMessage meMimeMsg= jms.createMimeMessage();	
	 
	  try
	  {
		  MimeMessageHelper helper=new MimeMessageHelper(meMimeMsg, true);
		  helper.setTo(sendto);
		  helper.setFrom(fromEmailId);
		  helper.setSubject(subject);
		  
		  helper.setText(body,true);
		  
		  FileSystemResource resource = new FileSystemResource(new File("D:\\zImage\\Logo.jpg"));
		  helper.addInline("image001", resource);
		  
//		  FileSystemResource file=new FileSystemResource("C:\\Users\\HP\\Downloads\\Spring Boot Notes\\Untitled.jpg");
		  
		  helper.addAttachment("sanctionLetter.pdf",sanctionLetter);
		  
		 jms.send(meMimeMsg);
		 
	  }
	  catch(MessagingException e2)
	  {
		  e2.printStackTrace();
	  }
		
//	  	enquiry.setMailSent("SENT");
//		 EnquiryDetails enquiryDetails=eds.saveEnquiryDetails(enquiry);
//		 return enquiryDetails;
	 
	}




	


}
