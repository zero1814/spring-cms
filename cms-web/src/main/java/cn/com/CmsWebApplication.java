package cn.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.service", "cn.com" })
@MapperScan(basePackages = { "org.mapper" })
public class CmsWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmsWebApplication.class, args);
	}
}
