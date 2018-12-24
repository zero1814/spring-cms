package cn.com.system;

import org.entity.system.ScMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.CmsWebApplication;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScMenuTest {

	@Autowired
	private IScMenuService service;

	public void insert() {
		String createUser = "insert";
		String status = "1";
		ScMenu entity = new ScMenu();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("SM"));
		entity.setName("首页");
		entity.setSort(0);
		entity.setLinkUrl("index");
		entity.setCreateUser(createUser);
		entity.setStatus(status);
		service.insert(entity);

		ScMenu entity1 = new ScMenu();
		entity1.setUid(CodeHelper.getUUID());
		entity1.setCode(CodeHelper.getCode("SM"));
		entity1.setName("系统管理");
		entity1.setSort(0);
		entity1.setCreateUser(createUser);
		entity1.setStatus(status);
		service.insert(entity1);

		ScMenu entity2 = new ScMenu();
		entity2.setUid(CodeHelper.getUUID());
		entity2.setCode(CodeHelper.getCode("SM"));
		entity2.setName("用户管理");
		entity.setLinkUrl("system/user/index");
		entity2.setSort(1);
		entity2.setCreateUser(createUser);
		entity2.setStatus(status);
		service.insert(entity2);

		ScMenu entity3 = new ScMenu();
		entity3.setUid(CodeHelper.getUUID());
		entity3.setCode(CodeHelper.getCode("SM"));
		entity3.setName("菜单管理");
		entity3.setLinkUrl("system/menu/index");
		entity3.setSort(0);
		entity3.setCreateUser(createUser);
		entity3.setStatus(status);
		service.insert(entity3);

		ScMenu entity4 = new ScMenu();
		entity4.setUid(CodeHelper.getUUID());
		entity4.setCode(CodeHelper.getCode("SM"));
		entity4.setName("角色管理");
		entity4.setLinkUrl("system/role/index");
		entity4.setSort(2);
		entity4.setCreateUser(createUser);
		entity4.setStatus(status);
		service.insert(entity4);

		ScMenu entity5 = new ScMenu();
		entity5.setUid(CodeHelper.getUUID());
		entity5.setCode(CodeHelper.getCode("SM"));
		entity5.setName("定时任务");
		entity5.setLinkUrl("system/task/index");
		entity5.setSort(3);
		entity5.setCreateUser(createUser);
		entity5.setStatus(status);
		service.insert(entity5);

		ScMenu entity6 = new ScMenu();
		entity6.setUid(CodeHelper.getUUID());
		entity6.setCode(CodeHelper.getCode("SM"));
		entity6.setName("参数配置");
		entity6.setLinkUrl("system/setting/index");
		entity6.setSort(3);
		entity6.setCreateUser(createUser);
		entity6.setStatus(status);
		service.insert(entity6);
	}

	public void update() {
		ScMenu entity = new ScMenu();
		entity.setCode("SM1077032354360324096");
		entity.setStatus("2");
		entity.setUpdateUser("update");
		service.update(entity);
	}

	public void select() {
		EntityResult<ScMenu> result = service.select("SM1077032354360324096");
		System.out.println(JSON.toJSON(result));
	}

	public void delete() {
		BaseResult result = service.delete("SM1077032354360324096");
		System.out.println(JSON.toJSON(result));
	}

	@Test
	public void navs() {
		DataResult<ScMenu> result = service.navs();
		System.out.println(JSON.toJSON(result));
	}
}
