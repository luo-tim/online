/**
 * 
 */
package recruitSystem.service.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.util.StringUtils;

/**
 * @author 72412
 *
 */
public class Test {

	/**
	 * 检测邮件发送
	 * @param id 邮件设置表的主键
	 * @param toEmail 收件人的邮箱
	 * @throws QingException 
	 */
	public void emailTest(String toEmail)  {
	
		String webName = "饭碗团队";
		
	
	
		// 发信人邮件地址、密码
		final String fromaddress = "724128629@qq.com";
		final String password = "iyjcyzwysjrebebd";
		final  String host = "smtp.qq.com";//邮件服务器
		
		// 创建Properties 类用于记录邮箱的一些属性
		Properties props = new Properties();
		// 表示SMTP发送邮件，必须进行身份验证
		props.put("mail.smtp.auth", "true");
		// 此处填写SMTP服务器
		props.put("mail.smtp.host", host);
		// 端口号
		//props.put("mail.smtp.port", "465");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// 发件人用户名、密码
				return new PasswordAuthentication(fromaddress, password);
			}
		};
		
		// 使用环境属性和授权信息，创建邮件会话
		Session session = Session.getInstance(props, authenticator);
		
		// 创建邮件消息
		MimeMessage message = new MimeMessage(session);
		try {
			// 设置发件人
			if (StringUtils.isEmpty(webName)) {
				// 站点名称未设置时，使用默认昵称
				InternetAddress from = new InternetAddress(fromaddress);
				message.setFrom(from);
			} else {
				// 否则使用站点名称作为昵称
				String from = fromaddress;
				String nickname = "";
				try {
					nickname = javax.mail.internet.MimeUtility.encodeText(webName);
				} catch (UnsupportedEncodingException e) {
				
					e.printStackTrace();
				}
				message.setFrom(new InternetAddress(nickname + " <"+from+">"));
			}
			
			// 设置收件人的邮箱
			InternetAddress to = new InternetAddress(toEmail);
			message.setRecipient(RecipientType.TO, to);

			// 设置邮件标题
			message.setSubject("测试邮件");

			// 设置邮件的内容体
			String content = "";
			if (StringUtils.isEmpty(webName)) {
				content = "这是一封测试邮件";
			} else {
				content = "这是一封来自" + webName + "的测试邮件";
			}
			message.setContent(content, "text/html;charset=UTF-8");

			// 发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
		e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		  new Test().emailTest("1037663815@qq.com");
		  System.out.println("邮件发送完毕");
	 }
}
