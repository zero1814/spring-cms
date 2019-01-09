package cn.com.config;

import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 类: CacheConfiguration <br>
 * 描述: spring缓存配置类 <br>
 * 作者: zhy<br>
 * 时间: 2019年1月8日 上午9:49:32
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager manager = new SimpleCacheManager();
		manager.setCaches(Collections.singletonList(new ConcurrentMapCache("models")));
		return manager;
	}
}
