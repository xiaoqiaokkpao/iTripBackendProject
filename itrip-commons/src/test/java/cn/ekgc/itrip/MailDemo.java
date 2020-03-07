package cn.ekgc.itrip;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailDemo {
	public static void main(String[] args) {
		// 用于发送邮件
		JavaMailSender mailSender = new JavaMailSenderImpl();
		// 创建邮件信息对象
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 抄送给自己
		mailMessage.setCc("chqiao829@163.com");
		// 发件人
		mailMessage.setFrom("chqiao829@163.com");
		// 收件人
		mailMessage.setTo("cqqiao417@163.com");
		// 邮件主题
		mailMessage.setSubject("爱旅行-用户注册激活码");
		// 设置邮件内容
		mailMessage.setText("胖墩！这是你激活爱旅行个人账户的激活码, 请胖墩查收！");

		// 设置邮箱信息
		mailSender.send(mailMessage);
	}
}
