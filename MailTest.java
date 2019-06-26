package Section4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Servlet implementation class SendEmail
 */

public class MailTest {
	private static final long serialVersionUID = 1L;
   
	public static void main(String[] args){
		// TODO Auto-generated method stub
	
	
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "25");
        // 此处填写你的账号
        props.put("mail.user","1984852655@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password","segpcfwwzsuugjjc");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form;
		try {
			form = new InternetAddress(
			        props.getProperty("mail.user"));
		
			message.setFrom(form);
		

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress("2872718690@qq.com");
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("测试邮件");

        // 设置邮件的内容体
        message.setContent("这是一封测试邮件", "text/html;charset=UTF-8");

        // 最后当然就是发送邮件啦
        Transport.send(message);
	} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	

}
