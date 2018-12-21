package cn.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	/**
	 * 
	 * 方法: createRestApi <br>
	 * 描述: 创建API应用<br>
	 * apiInfo() 增加API相关信息<br>
	 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，<br>
	 * 本例采用指定扫描的包路径来定义指定要建立API的目录。<br>
	 * 作者: zhy<br>
	 * 时间: 2018年11月16日 下午4:17:50
	 * 
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("cn.com.controller")).paths(PathSelectors.any()).build();
	}

	/**
	 * 
	 * 方法: apiInfo <br>
	 * 描述: 创建该API的基本信息（这些基本信息会展现在文档页面中）<br>
	 * 访问地址：http://项目实际地址/swagger-ui.html<br>
	 * 作者: zhy<br>
	 * 时间: 2018年11月16日 下午4:21:34
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("系统中心对外开发接口").description("系统中心对外开发接口")
				.contact(new Contact("zero", "https://my.oschina.net/u/3896892/", "zero1814@126.com"))
				.version("1.0.0-dev").build();
	}
}
