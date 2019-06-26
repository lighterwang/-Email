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
        // ��ʾSMTP�����ʼ���������������֤
        props.put("mail.smtp.auth", "true");
        //�˴���дSMTP������
        props.put("mail.smtp.host", "smtp.qq.com");
        //�˿ںţ�QQ��������������˿ڣ�������һ����һֱʹ�ò��ˣ����Ծ͸�����һ��587
        props.put("mail.smtp.port", "25");
        // �˴���д����˺�
        props.put("mail.user","1984852655@qq.com");
        // �˴����������ǰ��˵��16λSTMP����
        props.put("mail.password","segpcfwwzsuugjjc");

        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // �û���������
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession);
        // ���÷�����
        InternetAddress form;
		try {
			form = new InternetAddress(
			        props.getProperty("mail.user"));
		
			message.setFrom(form);
		

        // �����ռ��˵�����
        InternetAddress to = new InternetAddress("2872718690@qq.com");
        message.setRecipient(Message.RecipientType.TO, to);

        // �����ʼ�����
        message.setSubject("�����ʼ�");

        // �����ʼ���������
        message.setContent("����һ������ʼ�", "text/html;charset=UTF-8");

        // ���Ȼ���Ƿ����ʼ���
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
