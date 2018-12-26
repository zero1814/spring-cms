package cn.com.system;

import org.entity.system.ScTimeTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScTimeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.CmsWebApplication;
import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScTimeTaskTest {

	@Autowired
	private IScTimeTaskService service;

	@Test
	public void insert() {
		ScTimeTask entity = new ScTimeTask();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("STT"));
		entity.setName("用户登录定时同步");
		entity.setTime("* 0/3 * * * ?");
		entity.setExecClass("cn.com.task");
		entity.setType("1");
		entity.setStatus("1");
		entity.setDescription("this is a test ");
		entity.setCreateUser("insert");
		service.insert(entity);
	}
}
