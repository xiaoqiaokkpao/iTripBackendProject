package cn.ekgc.itrip.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	/*
	 * 对于Spring中的配置文件来说，也属于Spring的一种配置文件，那么Spring的配置文件的核心作用就是在创建Bean，
	 * 因此当使用配置类来替代原始的XML的时候，需要提供创建所需要对象的方法，当Spring框架加载的时候，
	 * 就会按照该方法，进行创建对应的Bean来进行管理
	 */
	@Bean
	public Docket createRestDocket(){
		// 创建Docket对象
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		// 设定Swagger生成UI界面时所显示的信息
		docket.apiInfo(apiInfo());
		return docket;
	}

	/**
	 * <b>用于创建Swagger文档页面相关规定信息的对象</b>
	 * @return
	 */
	private ApiInfo apiInfo (){
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("爱旅行-认证模块Api")
				// 设定版本号
				.version("1.0.0")
				.contact(new Contact("xiaohua", "www.huawei.com", "xiaohua@163.com"))

				.build();
				return apiInfo;
	}
}
