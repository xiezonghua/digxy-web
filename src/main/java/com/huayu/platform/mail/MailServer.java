package com.huayu.platform.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailServer.class.getCanonicalName());

	public static void main(String[] args) {
		String sender = "digxy2014@163.com";
		String password = "digxyfive2014";
		String mailHost = "smtp.163.com";
		String receiver = "xiezonghuago@163.com";

		MailProperties mailInfo = new MailProperties(sender, receiver, password);
		mailInfo.setHost(mailHost);
		mailInfo.setSubject("歡迎加入迪格學苑");
		mailInfo.setContent("歡迎加入迪格學苑，開心您的學習新旅程，我們已經爲你激活了賬號請使用");

		try {
			MailServer.sendSimpleMail(mailInfo);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static final String DIGXY_SENDER = "digxy2014@163.com" ;
	private static final String DIGXY_PASSWORD = "digxyfive2014" ; 
	private static final String DIGXY_HOST = "smtp.163.com" ;
	
	public static MailProperties getDefaultProperties() {
		MailProperties mailInfo = new MailProperties(DIGXY_SENDER, null, DIGXY_PASSWORD);
		mailInfo.setHost(DIGXY_HOST);
		mailInfo.setSubject("歡迎加入迪格學苑");
		mailInfo.setContent("歡迎加入迪格學苑，開心您的學習新旅程，我們已經爲你激活了賬號請使用 , 迪格学苑：<a href='http://www.digxy.cn'>www.digxy.cn</a>");
		return mailInfo;
	}

	public static void sendSimpleMail(MailProperties mailProp) throws MessagingException {
		mailProp.validate();

		Properties prop = new Properties();
		prop.setProperty("mail.host", mailProp.getHost());
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		// session.setDebug(true);
		// 2、通过session得到transport对象
		Transport ts = null;
		try {
			ts = session.getTransport();
			// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
			// ts.connect("smtp.163.com", "", "");
			ts.connect(mailProp.getSender(), mailProp.getPassword());
			// 4、创建邮件

			// 创建邮件对象
			MimeMessage message = new MimeMessage(session);
			// 指明邮件的发件人
			message.setFrom(new InternetAddress(mailProp.getSender()));

			// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailProp.getReceiver()));
			// 邮件的标题
			message.setSubject(mailProp.getSubject());
			// 邮件的文本内容
			message.setContent(mailProp.getContent(), "text/html;charset=UTF-8");
			// 返回创建好的邮件对象

			// 5、发送邮件
			ts.sendMessage(message, message.getAllRecipients());

			LOGGER.info("The mail send successfully , from {} to {}", mailProp.getSender(), mailProp.getReceiver());
		} finally {
			if (ts != null)
				ts.close();
		}
	}
}
