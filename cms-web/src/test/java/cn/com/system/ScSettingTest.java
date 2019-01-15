package cn.com.system;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.system.IScSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.CmsWebApplication;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CmsWebApplication.class)
public class ScSettingTest {

	@Autowired
	private IScSettingService service;

	public void rootInsert() {
		ScSetting entity = new ScSetting();
		entity.setCode("0");
		entity.setName("参数配置");
		entity.setCreateUser("system");
		service.insert(entity);
	}

	@Test
	public void insertUserType() {
		ScSetting entity0 = new ScSetting();
		entity0.setUid(CodeHelper.getUUID());
		entity0.setCode(CodeHelper.getCode("SS"));
		entity0.setName("用户相关");
		entity0.setCreateUser("insert");
		service.insert(entity0);

//		ScSetting entity = new ScSetting();
//		entity.setUid(CodeHelper.getUUID());
//		entity.setCode(CodeHelper.getCode("SS"));
//		entity.setParentCode(entity0.getCode());
//		entity.setName("用户类型");
//		entity.setCreateUser("insert");
//		service.insert(entity);
//
//		ScSetting entity1 = new ScSetting();
//		entity1.setUid(CodeHelper.getUUID());
//		entity1.setCode(CodeHelper.getCode("SS"));
//		entity1.setParentCode(entity.getCode());
//		entity1.setName("商户管理员");
//		entity1.setCreateUser("insert");
//		service.insert(entity1);
//
//		ScSetting entity2 = new ScSetting();
//		entity2.setUid(CodeHelper.getUUID());
//		entity2.setCode(CodeHelper.getCode("SS"));
//		entity2.setParentCode(entity.getCode());
//		entity2.setName("系统管理员");
//		entity2.setCreateUser("insert");
//		service.insert(entity2);
//
//		ScSetting entity3 = new ScSetting();
//		entity3.setUid(CodeHelper.getUUID());
//		entity3.setCode(CodeHelper.getCode("SS"));
//		entity3.setParentCode(entity.getCode());
//		entity3.setName("超级管理员");
//		entity3.setCreateUser("insert");
//		service.insert(entity3);

	}

	public void insertUserStatus() {
		ScSetting entity = new ScSetting();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("SS"));
		entity.setParentCode("SS1077393847278891008");
		entity.setName("用户状态");
		entity.setCreateUser("insert");
		service.insert(entity);

		ScSetting entity1 = new ScSetting();
		entity1.setUid(CodeHelper.getUUID());
		entity1.setCode(CodeHelper.getCode("SS"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("正常");
		entity1.setCreateUser("insert");
		service.insert(entity1);

		ScSetting entity2 = new ScSetting();
		entity2.setUid(CodeHelper.getUUID());
		entity2.setCode(CodeHelper.getCode("SS"));
		entity2.setParentCode(entity.getCode());
		entity2.setName("注销");
		entity2.setCreateUser("insert");
		service.insert(entity2);

		ScSetting entity3 = new ScSetting();
		entity3.setUid(CodeHelper.getUUID());
		entity3.setCode(CodeHelper.getCode("SS"));
		entity3.setParentCode(entity.getCode());
		entity3.setName("冻结");
		entity3.setCreateUser("insert");
		service.insert(entity3);
	}

	public void insertMenuStatus() {
//		ScSetting entity = new ScSetting();
//		entity.setUid(CodeHelper.getUUID());
//		entity.setCode(CodeHelper.getCode("SS"));
//		entity.setName("通用配置");
//		entity.setCreateUser("insert");
//		service.insert(entity);
//
//		ScSetting entity1 = new ScSetting();
//		entity1.setUid(CodeHelper.getUUID());
//		entity1.setCode(CodeHelper.getCode("SS"));
//		entity1.setParentCode(entity.getCode());
//		entity1.setName("状态");
//		entity1.setCreateUser("insert");
//		service.insert(entity1);
//
//		ScSetting entity2 = new ScSetting();
//		entity2.setUid(CodeHelper.getUUID());
//		entity2.setCode(CodeHelper.getCode("SS"));
//		entity2.setParentCode(entity1.getCode());
//		entity2.setName("可用");
//		entity2.setCreateUser("insert");
//		service.insert(entity2);
//
//		ScSetting entity3 = new ScSetting();
//		entity3.setUid(CodeHelper.getUUID());
//		entity3.setCode(CodeHelper.getCode("SS"));
//		entity3.setParentCode(entity1.getCode());
//		entity3.setName("不可用");
//		entity3.setCreateUser("insert");
//		service.insert(entity3);

		ScSetting entity4 = new ScSetting();
		entity4.setUid(CodeHelper.getUUID());
		entity4.setCode(CodeHelper.getCode("SS"));
		entity4.setParentCode("SS1077459481475936256");
		entity4.setName("是否");
		entity4.setCreateUser("insert");
		service.insert(entity4);

		ScSetting entity5 = new ScSetting();
		entity5.setUid(CodeHelper.getUUID());
		entity5.setCode(CodeHelper.getCode("SS"));
		entity5.setParentCode(entity4.getCode());
		entity5.setName("是");
		entity5.setCreateUser("insert");
		service.insert(entity5);

		ScSetting entity6 = new ScSetting();
		entity6.setUid(CodeHelper.getUUID());
		entity6.setCode(CodeHelper.getCode("SS"));
		entity6.setParentCode(entity4.getCode());
		entity6.setName("否");
		entity6.setCreateUser("insert");
		service.insert(entity6);
	}

	public void insertTimeTaskType() {
		ScSetting entity = new ScSetting();
		entity.setUid(CodeHelper.getUUID());
		entity.setCode(CodeHelper.getCode("SS"));
		entity.setName("定时任务相关");
		entity.setCreateUser("insert");
		service.insert(entity);

		ScSetting entity1 = new ScSetting();
		entity1.setUid(CodeHelper.getUUID());
		entity1.setCode(CodeHelper.getCode("SS"));
		entity1.setParentCode(entity.getCode());
		entity1.setName("定时任务类型");
		entity1.setCreateUser("insert");
		service.insert(entity1);

		ScSetting entity2 = new ScSetting();
		entity2.setUid(CodeHelper.getUUID());
		entity2.setCode(CodeHelper.getCode("SS"));
		entity2.setParentCode(entity1.getCode());
		entity2.setName("用户相关");
		entity2.setCreateUser("insert");
		service.insert(entity2);

		ScSetting entity3 = new ScSetting();
		entity3.setUid(CodeHelper.getUUID());
		entity3.setCode(CodeHelper.getCode("SS"));
		entity3.setParentCode(entity1.getCode());
		entity3.setName("系统相关");
		entity3.setCreateUser("insert");
		service.insert(entity3);
	}

	public void tree() {
		ScSettingDto dto = new ScSettingDto();
		DataResult<ScSetting> data = service.tree(dto);
		System.out.println(JSON.toJSON(data));
	}
}
