package cn.com.system;

import org.entity.system.ScUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.CmsWebApplication;
import zero.commons.basics.MD5Util;
import zero.commons.basics.Pinyin4jUtil;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScUserTest {

	@Autowired
	private IScUserService service;

	public void insert() {
		ScUser entity = new ScUser();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("SU"));
		entity.setUserName(Pinyin4jUtil.converterToSpell("张三"));
		entity.setPassword(MD5Util.md5Hex("123456"));
		entity.setEmail("1222@te.com");
		entity.setPhone("13422983321");
		entity.setCreateUser("insert");
		entity.setStatus("1");
		service.insert(entity);
	}

	public void update() {
		ScUser entity = new ScUser();
		entity.setCode("SU1077022534957789184");
		entity.setPassword(MD5Util.md5Hex("000000"));
		entity.setUpdateUser("update");
		service.update(entity);
	}

	public void select() {
		EntityResult<ScUser> result = service.select("SU1077022534957789184");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void del() {
		BaseResult result = service.delete("SU1077022534957789184");
		System.out.println(JSON.toJSON(result));
	}
}
