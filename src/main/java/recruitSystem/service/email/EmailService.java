/**
 * 
 */
package recruitSystem.service.email;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import recruitSystem.service.activateInfo.ActivateInfoService;
import recruitSystem.view.ActivateInfo;
import recruitSystem.view.User;

/**
 * @author 72412
 *邮件服务
 */
@Service("EmailService")
public class EmailService {
	
	@Autowired
	private ActivateInfoService activateInfoService;
	
	/**
	 * 发送邮件
	 * @param user
	 * @param subject
	 * @param type
	 */
	@Async
	public void  sendEmail(User user,String subject, String type){
		
		// 获取当前系统时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formatter.format(currentTime);
		String verificationCode = String.valueOf((int)((Math.random()*9+1)*100000));
		// 生成邮件内容
		StringBuffer content = new StringBuffer();
		content.append("<div style='background:#f7f7f7;overflow:hidden'>");
		content.append("<div style='background:#fff;border:1px solid #ccc;margin:2%;padding:0 30px'>");
		content.append("<div style='line-height:40px;height:40px'>&nbsp;</div>");
		content.append("<p style='margin:0;padding:0;font-size:14px;line-height:30px;color:#333;font-family:arial,sans-serif;font-weight:bold'>亲爱的用户 <b style='font-size:18px;color:#f90'>"+user.getUserName()+"</b>：</p>");
		content.append("<div style='line-height:20px;height:20px'>&nbsp;</div>");
		content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>您好！感谢您使用找回密码服务，您正在进行邮箱验证，本次请求的验证码为：</p>");
		content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>");
		content.append("<b style='font-size:18px;color:#f90'>"+verificationCode+"</b>");
		content.append("<span style='margin:0;padding:0;margin-left:10px;line-height:30px;font-size:14px;color:#979797;font-family:'宋体',arial,sans-serif'>(为了保障您账号的安全性，请在1小时内完成验证。)</span>");
		content.append("</p>");
		content.append("<div style='line-height:80px;height:80px'>&nbsp;</div>");
		content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>饭碗团队</p>");
		content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>"+now+"</p>");
		content.append("</div>");
		content.append("</div>");
		postEmail(user.getEmail(), subject, content.toString());
		
		// 生成验证码有效期
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setUserId(user.getId());
		activateInfo.setType(type);	// 用户修改邮箱
		activateInfo.setCode(verificationCode);
		activateInfo.setCreateTime(now);
		activateInfoService.save(activateInfo);
	}
	/**
	 * 发送 邮件
	 * @param toEmail
	 * @param subject
	 * @param content
	 */
	private void postEmail(String toEmail, String subject, String content) {

		String webName="饭碗团队";

	
		// 发信人邮件地址、密码
		final String fromaddress = "724128629@qq.com";
		final String password = "iyjcyzwysjrebebd";
		final  String host = "smtp.qq.com";//邮件服务器
		// 创建Properties 类用于记录邮箱的一些属性
		Properties props = new Properties();
		// 表示SMTP发送邮件，必须进行身份验证
		props.put("mail.smtp.auth", "true");
		//此处填写SMTP服务器
		props.put("mail.smtp.host", host);
		//端口号
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
			message.setSubject(subject);

			// 设置邮件的内容体
			message.setContent(content, "text/html;charset=UTF-8");

			// 发送邮件
			Transport.send(message);
			
			// 成功的话，直接返回
		
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}
	
		
}

