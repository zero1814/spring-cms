package cn.com.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfiguration {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public RedisTemplate template(LettuceConnectionFactory factory) {
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer valueSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		valueSerializer.setObjectMapper(mapper);
		RedisTemplate template = new RedisTemplate<>();
		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(valueSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(stringSerializer);
		template.setConnectionFactory(factory);
		return template;
	}
}
