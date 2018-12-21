package org.service.impl.system;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.mapper.system.ScSettingMapper;
import org.service.system.IScSettingService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScSettingServiceImpl <br>
 * 描述: 系统相关配置表业务接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:19
 */
@Service
public class ScSettingServiceImpl extends BaseServiceImpl<ScSetting, ScSettingMapper, ScSettingDto>
		implements IScSettingService {
}