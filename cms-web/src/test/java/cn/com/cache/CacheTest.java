package cn.com.cache;

import java.util.Map.Entry;

import javax.annotation.Resource;

import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.CmsWebApplication;
import zero.commons.basics.result.EntityResult;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class CacheTest {

	@Resource
	private RedisTemplate<String, String> template;
	@Autowired
	private IScUserService service;

	@Test
	public void set() {
		ScUserDto dto = new ScUserDto();
		dto.setUserName("lisi");
		dto.setPassword("123456");
		EntityResult<ScUser> result = service.login(dto);
		ScUser entity = result.getEntity();
		System.out.println(JSON.toJSON(result));
		template.opsForHash().put("user", entity.getCode(), entity);
	}
	
	public void get() {
		HashOperations<String, String, ScUser> map = template.opsForHash();
		for (Entry<String, ScUser> ele : map.entries("user").entrySet()) {
			System.out.println(ele.getKey()+"="+ele.getValue());
		}
		System.out.println(JSON.toJSON(map.get("user", "SU1085362996009496576")));
	}
}
