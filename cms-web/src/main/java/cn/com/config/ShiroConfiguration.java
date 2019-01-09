package cn.com.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.shiro.CustomShiroRealm;

@Configuration
public class ShiroConfiguration {

	private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	@Bean
	public CustomShiroRealm shiroRealm() {
		logger.info("生成shiroRealm的bean");
		CustomShiroRealm shiroRealm = new CustomShiroRealm();
		return shiroRealm;
	}

	/**
	 * 
	 * 方法: securityManager <br>
	 * 描述: 权限管理，配置主要是Realm的管理认证 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 上午8:20:39
	 * 
	 * @return
	 */
	@Bean
	public org.apache.shiro.mgt.SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		return securityManager;
	}

	/**
	 * 
	 * 方法: shiroFilterFactoryBean <br>
	 * 描述: Filter工厂，设置对应的过滤条件和跳转条件 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 上午8:21:06
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 登录
		shiroFilterFactoryBean.setLoginUrl("/login/index");
		// 首页
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 设置拦截器
		Map<String, String> filter = new HashMap<String, String>();
		// 登出
		filter.put("/logout", "logout");
		// 登录页面
		filter.put("/login", "anon");
		// 错误页面
		filter.put("/error/**", "anon");
		// 静态文件
		filter.put("/plugins/**", "anon");
		filter.put("/css/**", "anon");
		filter.put("/js/**", "anon");
		// 对所有用户认证
		filter.put("/**", "authc");
		// 无权跳转页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/error/permission");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
		return shiroFilterFactoryBean;
	}
}
