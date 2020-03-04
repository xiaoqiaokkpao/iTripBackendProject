package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>爱旅行-认证模块消费者启动类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AuthConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(AuthConsumerStarter.class, args);
	}
}
