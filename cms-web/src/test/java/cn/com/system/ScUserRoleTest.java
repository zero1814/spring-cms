package cn.com.system;

import org.entity.system.ScRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.CmsWebApplication;
import zero.commons.basics.result.TransferResult;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScUserRoleTest {

	@Autowired
	private IScUserRoleService service;

	@Test
	public void transferRoles() {
		String userCode = "SU1085362996009496576";
		TransferResult<ScRole> result = service.userRoles(userCode);
		System.out.println(JSON.toJSON(result));
	}
}
