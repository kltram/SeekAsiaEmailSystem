package com.seekasia.emailsystem.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.seekasia.emailsystem.constant.CanditateConstant;

public class SendEmailUtil {

	static String emailToRecipient, emailSubject, emailMessage;
	@Autowired
	private JavaMailSender mailSenderObj;

	public SendEmailUtil() {

	}

	public String sendEmail(String emailTo, String emailSub, String emailMeg) {
		// Reading Email Form Input Parameters
		emailSubject = emailSub;
		emailMessage = emailMeg;
		emailToRecipient = emailTo;
		String messageDevliverStatus = "";
		Properties config = createConfiguration();
		try {
			// Creates a mail session. We need to supply username and
			// password for Gmail authentication.
			Session session = Session.getInstance(config, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(CanditateConstant.USERNAME, CanditateConstant.PASSWORD);
				}
			});
			// Creates email message
			Message message = new MimeMessage(session);
			message.setSentDate(new Date());
			message.setFrom(new InternetAddress(CanditateConstant.EMAIL_FROM_RECEIPIENT));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailToRecipient));
			message.setSubject(emailSubject);
			message.setText(emailMessage);
			// Send a message
			Transport.send(message, CanditateConstant.USERNAME, CanditateConstant.PASSWORD);
			messageDevliverStatus = CanditateConstant.SUCCESS;
		} catch (AuthenticationFailedException exp) {
			messageDevliverStatus = CanditateConstant.LOGIN_AUTH_FAILED;
		} catch (AddressException ex) {
			messageDevliverStatus = CanditateConstant.WRONG_EMAIL;

		} catch (MessagingException ex) {
			messageDevliverStatus = ex.getMessage();
		}

		return messageDevliverStatus;
	}

	private Properties createConfiguration() {
		return new Properties() {
			{
				put("mail.smtp.host", CanditateConstant.GATEWAY);
				put("mail.smtp.auth", CanditateConstant.TRUE);
				put("mail.smtp.port", CanditateConstant.GMAIL_PORT);
				put("mail.smtp.socketFactory.port", CanditateConstant.GMAIL_PORT);
				put("mail.smtp.socketFactory.class", CanditateConstant.GMAIL_FACTORY);
				put("mail.debug", CanditateConstant.FALSE);
				put("mail.smtp.starttls.enable", CanditateConstant.TRUE);
			}
		};
	}

}
