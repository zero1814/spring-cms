package cn.com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 
 * 类: DataSourceConfiguration <br>
 * 描述: 数据源配置 <br>
 * 作者: zhy<br>
 * 时间: 2018年11月5日 上午10:47:47
 */
@Configuration
public class DataSourceConfiguration {

	/**
	 * 
	 * 方法: hanaDataSource <br>
	 * 描述: hana数据库配置 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年10月30日 上午9:43:10
	 * 
	 * @return
	 */
	@Bean(name = "system")
	@Qualifier("system")
	@ConfigurationProperties(prefix = "spring.datasource.system")
	@Primary
	public DataSource hanaDataSource() {
		return DataSourceBuilder.create().build();
	}

}
