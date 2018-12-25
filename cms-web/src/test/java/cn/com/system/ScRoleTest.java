package cn.com.system;

import org.entity.system.ScRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.CmsWebApplication;
import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScRoleTest {

	@Autowired
	private IScRoleService service;

	@Test
	public void insert() {
		ScRole entity = new ScRole();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("SR"));
		entity.setName("管理员");
		entity.setCreateUser("insert");
		service.insert(entity);
	}
}
