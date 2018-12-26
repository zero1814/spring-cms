package org.service.impl.system;

import java.util.List;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScSetting;
import org.entity.system.ScTimeTask;
import org.mapper.system.ScSettingMapper;
import org.mapper.system.ScTimeTaskMapper;
import org.service.system.IScTimeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScTimeTaskServiceImpl <br>
 * 描述: 定时任务表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:56
 */
@Service
public class ScTimeTaskServiceImpl extends BaseServiceImpl<ScTimeTask, ScTimeTaskMapper, ScTimeTaskDto>
		implements IScTimeTaskService {

	@Autowired
	private ScSettingMapper settingMapper;

	@Value("${system.time_task.type}")
	private String typeCode;

	@Value("${system.time_task.status}")
	private String statusCode;

	@Override
	public List<ScSetting> types() {
		return settingMapper.selectSetting(typeCode);
	}

	@Override
	public List<ScSetting> status() {
		return settingMapper.selectSetting(statusCode);
	}
}